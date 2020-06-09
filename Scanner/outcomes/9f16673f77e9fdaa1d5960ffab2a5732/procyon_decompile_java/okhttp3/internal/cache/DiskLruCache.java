// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.cache;

import java.util.Arrays;
import okio.Source;
import java.io.FileNotFoundException;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import java.io.IOException;
import java.io.EOFException;
import java.util.Iterator;
import okio.Okio;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.internal.Util;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.LinkedHashMap;
import okio.BufferedSink;
import okhttp3.internal.io.FileSystem;
import java.util.concurrent.Executor;
import java.io.File;
import okio.Sink;
import java.util.regex.Pattern;
import java.io.Flushable;
import java.io.Closeable;

public final class DiskLruCache implements Closeable, Flushable
{
    static final long ANY_SEQUENCE_NUMBER = 255L;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN;
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final Sink NULL_SINK;
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Runnable cleanupRunnable;
    private boolean closed;
    private final File directory;
    private final Executor executor;
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private BufferedSink journalWriter;
    private final LinkedHashMap lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;
    
    static {
        LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
        NULL_SINK = new DiskLruCache$4();
    }
    
    DiskLruCache(final FileSystem fileSystem, final File directory, final int appVersion, final int valueCount, final long maxSize, final Executor executor) {
        final long n = 0L;
        this.size = n;
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.nextSequenceNumber = n;
        this.cleanupRunnable = new DiskLruCache$1(this);
        this.fileSystem = fileSystem;
        this.directory = directory;
        this.appVersion = appVersion;
        this.journalFile = new File(directory, "journal");
        this.journalFileTmp = new File(directory, "journal.tmp");
        this.journalFileBackup = new File(directory, "journal.bkp");
        this.valueCount = valueCount;
        this.maxSize = maxSize;
        this.executor = executor;
    }
    
    private void checkNotClosed() {
        synchronized (this) {
            if (!this.isClosed()) {
                return;
            }
            throw new IllegalStateException("cache is closed");
        }
    }
    
    private void completeEdit(final DiskLruCache$Editor diskLruCache$Editor, final boolean b) {
        synchronized (this) {
            final DiskLruCache$Entry access$2100 = diskLruCache$Editor.entry;
            if (access$2100.currentEditor == diskLruCache$Editor) {
                int i = 0;
                if (b && !access$2100.readable) {
                    for (int j = 0; j < this.valueCount; ++j) {
                        if (!diskLruCache$Editor.written[j]) {
                            diskLruCache$Editor.abort();
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Newly created entry didn't create value for index ");
                            sb.append(j);
                            throw new IllegalStateException(sb.toString());
                        }
                        if (!this.fileSystem.exists(access$2100.dirtyFiles[j])) {
                            diskLruCache$Editor.abort();
                            return;
                        }
                    }
                }
                while (i < this.valueCount) {
                    final File file = access$2100.dirtyFiles[i];
                    if (b) {
                        if (this.fileSystem.exists(file)) {
                            final File file2 = access$2100.cleanFiles[i];
                            this.fileSystem.rename(file, file2);
                            final long n = access$2100.lengths[i];
                            final long size = this.fileSystem.size(file2);
                            access$2100.lengths[i] = size;
                            this.size = this.size - n + size;
                        }
                    }
                    else {
                        this.fileSystem.delete(file);
                    }
                    ++i;
                }
                final int redundantOpCount = this.redundantOpCount;
                final int n2 = 1;
                this.redundantOpCount = redundantOpCount + n2;
                access$2100.currentEditor = null;
                final boolean b2 = access$2100.readable | b;
                final int n3 = 10;
                final int n4 = 32;
                if (b2) {
                    access$2100.readable = (n2 != 0);
                    this.journalWriter.writeUtf8("CLEAN").writeByte(n4);
                    this.journalWriter.writeUtf8(access$2100.key);
                    access$2100.writeLengths(this.journalWriter);
                    this.journalWriter.writeByte(n3);
                    if (b) {
                        final long nextSequenceNumber = this.nextSequenceNumber;
                        this.nextSequenceNumber = 1L + nextSequenceNumber;
                        access$2100.sequenceNumber = nextSequenceNumber;
                    }
                }
                else {
                    this.lruEntries.remove(access$2100.key);
                    this.journalWriter.writeUtf8("REMOVE").writeByte(n4);
                    this.journalWriter.writeUtf8(access$2100.key);
                    this.journalWriter.writeByte(n3);
                }
                this.journalWriter.flush();
                if (this.size > this.maxSize || this.journalRebuildRequired()) {
                    this.executor.execute(this.cleanupRunnable);
                }
                return;
            }
            throw new IllegalStateException();
        }
    }
    
    public static DiskLruCache create(final FileSystem fileSystem, final File file, final int n, final int n2, final long n3) {
        if (n3 <= 0L) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (n2 > 0) {
            return new DiskLruCache(fileSystem, file, n, n2, n3, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), Util.threadFactory("OkHttp DiskLruCache", true)));
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }
    
    private DiskLruCache$Editor edit(final String s, final long n) {
        synchronized (this) {
            this.initialize();
            this.checkNotClosed();
            this.validateKey(s);
            DiskLruCache$Entry diskLruCache$Entry = this.lruEntries.get(s);
            if (n != -1 && (diskLruCache$Entry == null || diskLruCache$Entry.sequenceNumber != n)) {
                return null;
            }
            if (diskLruCache$Entry != null && diskLruCache$Entry.currentEditor != null) {
                return null;
            }
            if (this.mostRecentTrimFailed || this.mostRecentRebuildFailed) {
                this.executor.execute(this.cleanupRunnable);
                return null;
            }
            this.journalWriter.writeUtf8("DIRTY").writeByte(32).writeUtf8(s).writeByte(10);
            this.journalWriter.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (diskLruCache$Entry == null) {
                diskLruCache$Entry = new DiskLruCache$Entry(this, s, null);
                this.lruEntries.put(s, diskLruCache$Entry);
            }
            final DiskLruCache$Editor diskLruCache$Editor = new DiskLruCache$Editor(this, diskLruCache$Entry, null);
            diskLruCache$Entry.currentEditor = diskLruCache$Editor;
            return diskLruCache$Editor;
        }
    }
    
    private boolean journalRebuildRequired() {
        final int redundantOpCount = this.redundantOpCount;
        return redundantOpCount >= 2000 && redundantOpCount >= this.lruEntries.size();
    }
    
    private BufferedSink newJournalWriter() {
        return Okio.buffer(new DiskLruCache$2(this, this.fileSystem.appendingSink(this.journalFile)));
    }
    
    private void processJournal() {
        this.fileSystem.delete(this.journalFileTmp);
        final Iterator<DiskLruCache$Entry> iterator = this.lruEntries.values().iterator();
        while (iterator.hasNext()) {
            final DiskLruCache$Entry diskLruCache$Entry = iterator.next();
            if (diskLruCache$Entry.currentEditor == null) {
                for (int i = 0; i < this.valueCount; ++i) {
                    this.size += diskLruCache$Entry.lengths[i];
                }
            }
            else {
                diskLruCache$Entry.currentEditor = null;
                for (int j = 0; j < this.valueCount; ++j) {
                    this.fileSystem.delete(diskLruCache$Entry.cleanFiles[j]);
                    this.fileSystem.delete(diskLruCache$Entry.dirtyFiles[j]);
                }
                iterator.remove();
            }
        }
    }
    
    private void readJournal() {
        final BufferedSource buffer = Okio.buffer(this.fileSystem.source(this.journalFile));
        try {
            final String utf8LineStrict = buffer.readUtf8LineStrict();
            final String utf8LineStrict2 = buffer.readUtf8LineStrict();
            final String utf8LineStrict3 = buffer.readUtf8LineStrict();
            final String utf8LineStrict4 = buffer.readUtf8LineStrict();
            final String utf8LineStrict5 = buffer.readUtf8LineStrict();
            if ("libcore.io.DiskLruCache".equals(utf8LineStrict)) {
                if ("1".equals(utf8LineStrict2)) {
                    if (Integer.toString(this.appVersion).equals(utf8LineStrict3)) {
                        if (Integer.toString(this.valueCount).equals(utf8LineStrict4)) {
                            if ("".equals(utf8LineStrict5)) {
                                int n = 0;
                                try {
                                    while (true) {
                                        this.readJournalLine(buffer.readUtf8LineStrict());
                                        ++n;
                                    }
                                }
                                catch (EOFException ex) {
                                    this.redundantOpCount = n - this.lruEntries.size();
                                    if (!buffer.exhausted()) {
                                        this.rebuildJournal();
                                    }
                                    else {
                                        this.journalWriter = this.newJournalWriter();
                                    }
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("unexpected journal header: [");
            sb.append(utf8LineStrict);
            sb.append(", ");
            sb.append(utf8LineStrict2);
            sb.append(", ");
            sb.append(utf8LineStrict4);
            sb.append(", ");
            sb.append(utf8LineStrict5);
            sb.append("]");
            throw new IOException(sb.toString());
        }
        finally {
            Util.closeQuietly(buffer);
        }
    }
    
    private void readJournalLine(final String s) {
        final int n = 32;
        final int index = s.indexOf(n);
        final int n2 = -1;
        if (index != n2) {
            final int n3 = index + 1;
            final int index2 = s.indexOf(n, n3);
            String s2;
            if (index2 == n2) {
                s2 = s.substring(n3);
                if (index == "REMOVE".length() && s.startsWith("REMOVE")) {
                    this.lruEntries.remove(s2);
                    return;
                }
            }
            else {
                s2 = s.substring(n3, index2);
            }
            DiskLruCache$Entry diskLruCache$Entry = this.lruEntries.get(s2);
            if (diskLruCache$Entry == null) {
                diskLruCache$Entry = new DiskLruCache$Entry(this, s2, null);
                this.lruEntries.put(s2, diskLruCache$Entry);
            }
            if (index2 != n2 && index == "CLEAN".length() && s.startsWith("CLEAN")) {
                final String[] split = s.substring(index2 + 1).split(" ");
                diskLruCache$Entry.readable = true;
                diskLruCache$Entry.currentEditor = null;
                diskLruCache$Entry.setLengths(split);
            }
            else if (index2 == n2 && index == "DIRTY".length() && s.startsWith("DIRTY")) {
                diskLruCache$Entry.currentEditor = new DiskLruCache$Editor(this, diskLruCache$Entry, null);
            }
            else if (index2 != n2 || index != "READ".length() || !s.startsWith("READ")) {
                final StringBuilder sb = new StringBuilder();
                sb.append("unexpected journal line: ");
                sb.append(s);
                throw new IOException(sb.toString());
            }
            return;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("unexpected journal line: ");
        sb2.append(s);
        throw new IOException(sb2.toString());
    }
    
    private void rebuildJournal() {
        synchronized (this) {
            if (this.journalWriter != null) {
                this.journalWriter.close();
            }
            final BufferedSink buffer = Okio.buffer(this.fileSystem.sink(this.journalFileTmp));
            final String s = "libcore.io.DiskLruCache";
            final BufferedSink bufferedSink = buffer;
            try {
                final BufferedSink writeUtf8 = bufferedSink.writeUtf8(s);
                final int n = 10;
                writeUtf8.writeByte(n);
                buffer.writeUtf8("1").writeByte(n);
                buffer.writeDecimalLong(this.appVersion).writeByte(n);
                buffer.writeDecimalLong(this.valueCount).writeByte(n);
                buffer.writeByte(n);
                for (final DiskLruCache$Entry diskLruCache$Entry : this.lruEntries.values()) {
                    final DiskLruCache$Editor access$1300 = diskLruCache$Entry.currentEditor;
                    final int n2 = 32;
                    if (access$1300 != null) {
                        buffer.writeUtf8("DIRTY").writeByte(n2);
                        buffer.writeUtf8(diskLruCache$Entry.key);
                        buffer.writeByte(n);
                    }
                    else {
                        buffer.writeUtf8("CLEAN").writeByte(n2);
                        buffer.writeUtf8(diskLruCache$Entry.key);
                        diskLruCache$Entry.writeLengths(buffer);
                        buffer.writeByte(n);
                    }
                }
                buffer.close();
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.rename(this.journalFile, this.journalFileBackup);
                }
                this.fileSystem.rename(this.journalFileTmp, this.journalFile);
                this.fileSystem.delete(this.journalFileBackup);
                this.journalWriter = this.newJournalWriter();
                this.hasJournalErrors = false;
                this.mostRecentRebuildFailed = false;
            }
            finally {
                buffer.close();
            }
        }
    }
    
    private boolean removeEntry(final DiskLruCache$Entry diskLruCache$Entry) {
        if (diskLruCache$Entry.currentEditor != null) {
            diskLruCache$Entry.currentEditor.detach();
        }
        for (int i = 0; i < this.valueCount; ++i) {
            this.fileSystem.delete(diskLruCache$Entry.cleanFiles[i]);
            this.size -= diskLruCache$Entry.lengths[i];
            diskLruCache$Entry.lengths[i] = 0L;
        }
        final int redundantOpCount = this.redundantOpCount;
        final int n = 1;
        this.redundantOpCount = redundantOpCount + n;
        this.journalWriter.writeUtf8("REMOVE").writeByte(32).writeUtf8(diskLruCache$Entry.key).writeByte(10);
        this.lruEntries.remove(diskLruCache$Entry.key);
        if (this.journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return n != 0;
    }
    
    private void trimToSize() {
        while (this.size > this.maxSize) {
            this.removeEntry(this.lruEntries.values().iterator().next());
        }
        this.mostRecentTrimFailed = false;
    }
    
    private void validateKey(final String s) {
        if (DiskLruCache.LEGAL_KEY_PATTERN.matcher(s).matches()) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("keys must match regex [a-z0-9_-]{1,120}: \"");
        sb.append(s);
        sb.append("\"");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void close() {
        synchronized (this) {
            final boolean initialized = this.initialized;
            final boolean b = true;
            if (initialized && !this.closed) {
                final DiskLruCache$Entry[] array = (DiskLruCache$Entry[])this.lruEntries.values().toArray(new DiskLruCache$Entry[this.lruEntries.size()]);
                for (int length = array.length, i = 0; i < length; ++i) {
                    final DiskLruCache$Entry diskLruCache$Entry = array[i];
                    if (diskLruCache$Entry.currentEditor != null) {
                        diskLruCache$Entry.currentEditor.abort();
                    }
                }
                this.trimToSize();
                this.journalWriter.close();
                this.journalWriter = null;
                this.closed = b;
                return;
            }
            this.closed = b;
        }
    }
    
    public void delete() {
        this.close();
        this.fileSystem.deleteContents(this.directory);
    }
    
    public DiskLruCache$Editor edit(final String s) {
        return this.edit(s, -1);
    }
    
    public void evictAll() {
        synchronized (this) {
            this.initialize();
            final DiskLruCache$Entry[] array = (DiskLruCache$Entry[])this.lruEntries.values().toArray(new DiskLruCache$Entry[this.lruEntries.size()]);
            for (int length = array.length, i = 0; i < length; ++i) {
                this.removeEntry(array[i]);
            }
            this.mostRecentTrimFailed = false;
        }
    }
    
    public void flush() {
        synchronized (this) {
            if (!this.initialized) {
                return;
            }
            this.checkNotClosed();
            this.trimToSize();
            this.journalWriter.flush();
        }
    }
    
    public DiskLruCache$Snapshot get(final String s) {
        synchronized (this) {
            this.initialize();
            this.checkNotClosed();
            this.validateKey(s);
            final DiskLruCache$Entry diskLruCache$Entry = this.lruEntries.get(s);
            if (diskLruCache$Entry == null || diskLruCache$Entry.readable) {
                return null;
            }
            final DiskLruCache$Snapshot snapshot = diskLruCache$Entry.snapshot();
            if (snapshot == null) {
                return null;
            }
            ++this.redundantOpCount;
            this.journalWriter.writeUtf8("READ").writeByte(32).writeUtf8(s).writeByte(10);
            if (this.journalRebuildRequired()) {
                this.executor.execute(this.cleanupRunnable);
            }
            return snapshot;
        }
    }
    
    public File getDirectory() {
        return this.directory;
    }
    
    public long getMaxSize() {
        synchronized (this) {
            return this.maxSize;
        }
    }
    
    public void initialize() {
        synchronized (this) {
            if (this.initialized) {
                return;
            }
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                }
                else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            final boolean exists = this.fileSystem.exists(this.journalFile);
            final boolean b = true;
            if (exists) {
                try {
                    this.readJournal();
                    this.processJournal();
                    try {
                        this.initialized = b;
                        return;
                    }
                    catch (IOException ex) {
                        final Platform value = Platform.get();
                        final int n = 5;
                        final StringBuilder sb = new StringBuilder();
                        sb.append("DiskLruCache ");
                        sb.append(this.directory);
                        sb.append(" is corrupt: ");
                        sb.append(ex.getMessage());
                        sb.append(", removing");
                        value.log(n, sb.toString(), ex);
                        this.delete();
                        this.closed = false;
                    }
                }
                catch (IOException ex2) {}
            }
            this.rebuildJournal();
            this.initialized = b;
        }
    }
    
    public boolean isClosed() {
        synchronized (this) {
            return this.closed;
        }
    }
    
    public boolean remove(final String s) {
        synchronized (this) {
            this.initialize();
            this.checkNotClosed();
            this.validateKey(s);
            final DiskLruCache$Entry diskLruCache$Entry = this.lruEntries.get(s);
            if (diskLruCache$Entry == null) {
                return false;
            }
            final boolean removeEntry = this.removeEntry(diskLruCache$Entry);
            if (removeEntry && this.size <= this.maxSize) {
                this.mostRecentTrimFailed = false;
            }
            return removeEntry;
        }
    }
    
    public void setMaxSize(final long maxSize) {
        synchronized (this) {
            this.maxSize = maxSize;
            if (this.initialized) {
                this.executor.execute(this.cleanupRunnable);
            }
        }
    }
    
    public long size() {
        synchronized (this) {
            this.initialize();
            return this.size;
        }
    }
    
    public Iterator snapshots() {
        synchronized (this) {
            this.initialize();
            return new DiskLruCache$3(this);
        }
    }
}
