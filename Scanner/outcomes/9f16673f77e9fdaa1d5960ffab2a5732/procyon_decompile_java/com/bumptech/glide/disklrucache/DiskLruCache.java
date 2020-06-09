// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.disklrucache;

import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.io.EOFException;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.Iterator;
import java.io.PrintStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.LinkedHashMap;
import java.io.Writer;
import java.util.concurrent.ThreadPoolExecutor;
import java.io.File;
import java.util.concurrent.Callable;
import java.io.Closeable;

public final class DiskLruCache implements Closeable
{
    static final long ANY_SEQUENCE_NUMBER = 255L;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable cleanupCallable;
    private final File directory;
    final ThreadPoolExecutor executorService;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap lruEntries;
    private long maxSize;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;
    
    private DiskLruCache(final File directory, final int appVersion, final int valueCount, final long maxSize) {
        final long n = 0L;
        this.size = n;
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.nextSequenceNumber = n;
        this.executorService = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        this.cleanupCallable = new DiskLruCache$1(this);
        this.directory = directory;
        this.appVersion = appVersion;
        this.journalFile = new File(directory, "journal");
        this.journalFileTmp = new File(directory, "journal.tmp");
        this.journalFileBackup = new File(directory, "journal.bkp");
        this.valueCount = valueCount;
        this.maxSize = maxSize;
    }
    
    private void checkNotClosed() {
        if (this.journalWriter != null) {
            return;
        }
        throw new IllegalStateException("cache is closed");
    }
    
    private void completeEdit(final DiskLruCache$Editor diskLruCache$Editor, final boolean b) {
        synchronized (this) {
            final DiskLruCache$Entry access$1400 = diskLruCache$Editor.entry;
            if (access$1400.currentEditor == diskLruCache$Editor) {
                int i = 0;
                if (b && !access$1400.readable) {
                    for (int j = 0; j < this.valueCount; ++j) {
                        if (!diskLruCache$Editor.written[j]) {
                            diskLruCache$Editor.abort();
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Newly created entry didn't create value for index ");
                            sb.append(j);
                            throw new IllegalStateException(sb.toString());
                        }
                        if (!access$1400.getDirtyFile(j).exists()) {
                            diskLruCache$Editor.abort();
                            return;
                        }
                    }
                }
                while (i < this.valueCount) {
                    final File dirtyFile = access$1400.getDirtyFile(i);
                    if (b) {
                        if (dirtyFile.exists()) {
                            final File cleanFile = access$1400.getCleanFile(i);
                            dirtyFile.renameTo(cleanFile);
                            final long n = access$1400.lengths[i];
                            final long length = cleanFile.length();
                            access$1400.lengths[i] = length;
                            this.size = this.size - n + length;
                        }
                    }
                    else {
                        deleteIfExists(dirtyFile);
                    }
                    ++i;
                }
                final int redundantOpCount = this.redundantOpCount;
                final int n2 = 1;
                this.redundantOpCount = redundantOpCount + n2;
                access$1400.currentEditor = null;
                final boolean b2 = access$1400.readable | b;
                final char c = '\n';
                final char c2 = ' ';
                if (b2) {
                    access$1400.readable = (n2 != 0);
                    this.journalWriter.append((CharSequence)"CLEAN");
                    this.journalWriter.append(c2);
                    this.journalWriter.append((CharSequence)access$1400.key);
                    this.journalWriter.append((CharSequence)access$1400.getLengths());
                    this.journalWriter.append(c);
                    if (b) {
                        final long nextSequenceNumber = this.nextSequenceNumber;
                        this.nextSequenceNumber = 1L + nextSequenceNumber;
                        access$1400.sequenceNumber = nextSequenceNumber;
                    }
                }
                else {
                    this.lruEntries.remove(access$1400.key);
                    this.journalWriter.append((CharSequence)"REMOVE");
                    this.journalWriter.append(c2);
                    this.journalWriter.append((CharSequence)access$1400.key);
                    this.journalWriter.append(c);
                }
                this.journalWriter.flush();
                if (this.size > this.maxSize || this.journalRebuildRequired()) {
                    this.executorService.submit((Callable<Object>)this.cleanupCallable);
                }
                return;
            }
            throw new IllegalStateException();
        }
    }
    
    private static void deleteIfExists(final File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }
    
    private DiskLruCache$Editor edit(final String s, final long n) {
        synchronized (this) {
            this.checkNotClosed();
            DiskLruCache$Entry diskLruCache$Entry = this.lruEntries.get(s);
            if (n != -1 && (diskLruCache$Entry == null || diskLruCache$Entry.sequenceNumber != n)) {
                return null;
            }
            if (diskLruCache$Entry == null) {
                diskLruCache$Entry = new DiskLruCache$Entry(this, s, null);
                this.lruEntries.put(s, diskLruCache$Entry);
            }
            else if (diskLruCache$Entry.currentEditor != null) {
                return null;
            }
            final DiskLruCache$Editor diskLruCache$Editor = new DiskLruCache$Editor(this, diskLruCache$Entry, null);
            diskLruCache$Entry.currentEditor = diskLruCache$Editor;
            this.journalWriter.append((CharSequence)"DIRTY");
            this.journalWriter.append(' ');
            this.journalWriter.append((CharSequence)s);
            this.journalWriter.append('\n');
            this.journalWriter.flush();
            return diskLruCache$Editor;
        }
    }
    
    private static String inputStreamToString(final InputStream inputStream) {
        return Util.readFully(new InputStreamReader(inputStream, Util.UTF_8));
    }
    
    private boolean journalRebuildRequired() {
        final int redundantOpCount = this.redundantOpCount;
        return redundantOpCount >= 2000 && redundantOpCount >= this.lruEntries.size();
    }
    
    public static DiskLruCache open(final File file, final int n, final int n2, final long n3) {
        if (n3 <= 0L) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (n2 > 0) {
            final File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                final File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                }
                else {
                    renameTo(file2, file3, false);
                }
            }
            final DiskLruCache diskLruCache = new DiskLruCache(file, n, n2, n3);
            if (diskLruCache.journalFile.exists()) {
                try {
                    diskLruCache.readJournal();
                    diskLruCache.processJournal();
                    return diskLruCache;
                }
                catch (IOException ex) {
                    final PrintStream out = System.out;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("DiskLruCache ");
                    sb.append(file);
                    sb.append(" is corrupt: ");
                    sb.append(ex.getMessage());
                    sb.append(", removing");
                    out.println(sb.toString());
                    diskLruCache.delete();
                }
            }
            file.mkdirs();
            final DiskLruCache diskLruCache2 = new DiskLruCache(file, n, n2, n3);
            diskLruCache2.rebuildJournal();
            return diskLruCache2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }
    
    private void processJournal() {
        deleteIfExists(this.journalFileTmp);
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
                    deleteIfExists(diskLruCache$Entry.getCleanFile(j));
                    deleteIfExists(diskLruCache$Entry.getDirtyFile(j));
                }
                iterator.remove();
            }
        }
    }
    
    private void readJournal() {
        final StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.journalFile), Util.US_ASCII);
        try {
            final String line = strictLineReader.readLine();
            final String line2 = strictLineReader.readLine();
            final String line3 = strictLineReader.readLine();
            final String line4 = strictLineReader.readLine();
            final String line5 = strictLineReader.readLine();
            if ("libcore.io.DiskLruCache".equals(line) && "1".equals(line2) && Integer.toString(this.appVersion).equals(line3) && Integer.toString(this.valueCount).equals(line4) && "".equals(line5)) {
                int n = 0;
                try {
                    while (true) {
                        this.readJournalLine(strictLineReader.readLine());
                        ++n;
                    }
                }
                catch (EOFException ex) {
                    this.redundantOpCount = n - this.lruEntries.size();
                    if (strictLineReader.hasUnterminatedLine()) {
                        this.rebuildJournal();
                    }
                    else {
                        this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
                    }
                    return;
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("unexpected journal header: [");
            sb.append(line);
            sb.append(", ");
            sb.append(line2);
            sb.append(", ");
            sb.append(line4);
            sb.append(", ");
            sb.append(line5);
            sb.append("]");
            throw new IOException(sb.toString());
        }
        finally {
            Util.closeQuietly(strictLineReader);
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
            final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
            final String s = "libcore.io.DiskLruCache";
            final BufferedWriter bufferedWriter2 = bufferedWriter;
            try {
                bufferedWriter2.write(s);
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.appVersion));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.valueCount));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (final DiskLruCache$Entry diskLruCache$Entry : this.lruEntries.values()) {
                    final DiskLruCache$Editor access$700 = diskLruCache$Entry.currentEditor;
                    final char c = '\n';
                    if (access$700 != null) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("DIRTY ");
                        sb.append(diskLruCache$Entry.key);
                        sb.append(c);
                        bufferedWriter.write(sb.toString());
                    }
                    else {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("CLEAN ");
                        sb2.append(diskLruCache$Entry.key);
                        sb2.append(diskLruCache$Entry.getLengths());
                        sb2.append(c);
                        bufferedWriter.write(sb2.toString());
                    }
                }
                bufferedWriter.close();
                final boolean exists = this.journalFile.exists();
                final boolean b = true;
                if (exists) {
                    renameTo(this.journalFile, this.journalFileBackup, b);
                }
                renameTo(this.journalFileTmp, this.journalFile, false);
                this.journalFileBackup.delete();
                this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, b), Util.US_ASCII));
            }
            finally {
                bufferedWriter.close();
            }
        }
    }
    
    private static void renameTo(final File file, final File file2, final boolean b) {
        if (b) {
            deleteIfExists(file2);
        }
        if (file.renameTo(file2)) {
            return;
        }
        throw new IOException();
    }
    
    private void trimToSize() {
        while (this.size > this.maxSize) {
            this.remove(this.lruEntries.entrySet().iterator().next().getKey());
        }
    }
    
    public void close() {
        synchronized (this) {
            if (this.journalWriter == null) {
                return;
            }
            for (final DiskLruCache$Entry diskLruCache$Entry : new ArrayList<DiskLruCache$Entry>(this.lruEntries.values())) {
                if (diskLruCache$Entry.currentEditor != null) {
                    diskLruCache$Entry.currentEditor.abort();
                }
            }
            this.trimToSize();
            this.journalWriter.close();
            this.journalWriter = null;
        }
    }
    
    public void delete() {
        this.close();
        Util.deleteContents(this.directory);
    }
    
    public DiskLruCache$Editor edit(final String s) {
        return this.edit(s, -1);
    }
    
    public void flush() {
        synchronized (this) {
            this.checkNotClosed();
            this.trimToSize();
            this.journalWriter.flush();
        }
    }
    
    public DiskLruCache$Value get(final String s) {
        synchronized (this) {
            this.checkNotClosed();
            final DiskLruCache$Entry diskLruCache$Entry = this.lruEntries.get(s);
            if (diskLruCache$Entry == null) {
                return null;
            }
            if (!diskLruCache$Entry.readable) {
                return null;
            }
            final File[] cleanFiles = diskLruCache$Entry.cleanFiles;
            for (int length = cleanFiles.length, i = 0; i < length; ++i) {
                if (!cleanFiles[i].exists()) {
                    return null;
                }
            }
            ++this.redundantOpCount;
            this.journalWriter.append((CharSequence)"READ");
            this.journalWriter.append(' ');
            this.journalWriter.append((CharSequence)s);
            this.journalWriter.append('\n');
            if (this.journalRebuildRequired()) {
                this.executorService.submit((Callable<Object>)this.cleanupCallable);
            }
            final long access$1200;
            final File[] cleanFiles2;
            final long[] access$1201;
            final DiskLruCache$Value diskLruCache$Value = new DiskLruCache$Value(this, s, access$1200, cleanFiles2, access$1201, null);
            access$1200 = diskLruCache$Entry.sequenceNumber;
            cleanFiles2 = diskLruCache$Entry.cleanFiles;
            access$1201 = diskLruCache$Entry.lengths;
            return diskLruCache$Value;
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
    
    public boolean isClosed() {
        synchronized (this) {
            return this.journalWriter == null;
        }
    }
    
    public boolean remove(final String s) {
        synchronized (this) {
            this.checkNotClosed();
            final DiskLruCache$Entry diskLruCache$Entry = this.lruEntries.get(s);
            int i = 0;
            if (diskLruCache$Entry != null && diskLruCache$Entry.currentEditor == null) {
                while (i < this.valueCount) {
                    final File cleanFile = diskLruCache$Entry.getCleanFile(i);
                    if (cleanFile.exists() && !cleanFile.delete()) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("failed to delete ");
                        sb.append(cleanFile);
                        throw new IOException(sb.toString());
                    }
                    this.size -= diskLruCache$Entry.lengths[i];
                    diskLruCache$Entry.lengths[i] = 0L;
                    ++i;
                }
                final int redundantOpCount = this.redundantOpCount;
                final int n = 1;
                this.redundantOpCount = redundantOpCount + n;
                this.journalWriter.append((CharSequence)"REMOVE");
                this.journalWriter.append(' ');
                this.journalWriter.append((CharSequence)s);
                this.journalWriter.append('\n');
                this.lruEntries.remove(s);
                if (this.journalRebuildRequired()) {
                    this.executorService.submit((Callable<Object>)this.cleanupCallable);
                }
                return n != 0;
            }
            return false;
        }
    }
    
    public void setMaxSize(final long maxSize) {
        synchronized (this) {
            this.maxSize = maxSize;
            this.executorService.submit((Callable<Object>)this.cleanupCallable);
        }
    }
    
    public long size() {
        synchronized (this) {
            return this.size;
        }
    }
}
