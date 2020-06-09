// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.cache;

import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import java.io.EOFException;
import java.util.Iterator;
import okio.Okio;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.internal.Util;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import java.io.Flushable;
import java.io.Closeable;
import okio.BufferedSink;
import java.util.Arrays;
import okio.Source;
import java.io.File;
import java.io.FileNotFoundException;
import okio.Sink;
import okhttp3.internal.io.FileSystem;
import java.io.IOException;

public final class DiskLruCache$Editor
{
    private boolean done;
    private final DiskLruCache$Entry entry;
    final /* synthetic */ DiskLruCache this$0;
    private final boolean[] written;
    
    private DiskLruCache$Editor(final DiskLruCache this$0, final DiskLruCache$Entry entry) {
        this.this$0 = this$0;
        this.entry = entry;
        boolean[] written;
        if (entry.readable) {
            written = null;
        }
        else {
            written = new boolean[this$0.valueCount];
        }
        this.written = written;
    }
    
    public void abort() {
        synchronized (this.this$0) {
            if (!this.done) {
                if (this.entry.currentEditor == this) {
                    this.this$0.completeEdit(this, false);
                }
                this.done = true;
                return;
            }
            throw new IllegalStateException();
        }
    }
    
    public void abortUnlessCommitted() {
        synchronized (this.this$0) {
            if (!this.done && this.entry.currentEditor == this) {
                try {
                    this.this$0.completeEdit(this, false);
                }
                catch (IOException ex) {}
            }
        }
    }
    
    public void commit() {
        synchronized (this.this$0) {
            if (!this.done) {
                final DiskLruCache$Editor access$1300 = this.entry.currentEditor;
                final boolean done = true;
                if (access$1300 == this) {
                    this.this$0.completeEdit(this, done);
                }
                this.done = done;
                return;
            }
            throw new IllegalStateException();
        }
    }
    
    void detach() {
        if (this.entry.currentEditor == this) {
            for (int i = 0; i < this.this$0.valueCount; ++i) {
                try {
                    final DiskLruCache this$0 = this.this$0;
                    try {
                        final FileSystem access$2700 = this$0.fileSystem;
                        try {
                            final DiskLruCache$Entry entry = this.entry;
                            try {
                                access$2700.delete(entry.dirtyFiles[i]);
                            }
                            catch (IOException ex) {}
                        }
                        catch (IOException ex2) {}
                    }
                    catch (IOException ex3) {}
                }
                catch (IOException ex4) {}
            }
            this.entry.currentEditor = null;
        }
    }
    
    public Sink newSink(final int n) {
        final DiskLruCache this$0 = this.this$0;
        // monitorenter(this$0)
        try {
            Label_0152: {
                if (this.done) {
                    break Label_0152;
                }
                if (this.entry.currentEditor != this) {
                    return DiskLruCache.NULL_SINK;
                }
                if (!this.entry.readable) {
                    this.written[n] = true;
                }
                final File file = this.entry.dirtyFiles[n];
                try {
                    final DiskLruCache this$2 = this.this$0;
                    try {
                        return new DiskLruCache$Editor$1(this, this$2.fileSystem.sink(file));
                    }
                    catch (FileNotFoundException ex) {
                        return DiskLruCache.NULL_SINK;
                        throw new IllegalStateException();
                    }
                }
                catch (FileNotFoundException ex2) {}
                finally {
                }
                // monitorexit(this$0)
            }
        }
        finally {}
    }
    
    public Source newSource(final int n) {
        final DiskLruCache this$0 = this.this$0;
        // monitorenter(this$0)
        try {
            Label_0112: {
                if (this.done) {
                    break Label_0112;
                }
                Label_0108: {
                    if (!this.entry.readable || this.entry.currentEditor != this) {
                        break Label_0108;
                    }
                    try {
                        final DiskLruCache this$2 = this.this$0;
                        try {
                            final FileSystem access$2700 = this$2.fileSystem;
                            try {
                                final DiskLruCache$Entry entry = this.entry;
                                try {
                                    return access$2700.source(entry.cleanFiles[n]);
                                }
                                catch (FileNotFoundException ex) {
                                    return null;
                                    return null;
                                    throw new IllegalStateException();
                                }
                            }
                            catch (FileNotFoundException ex2) {}
                        }
                        catch (FileNotFoundException ex3) {}
                        finally {
                        }
                        // monitorexit(this$0)
                    }
                    catch (FileNotFoundException ex4) {}
                }
            }
        }
        finally {}
    }
}
