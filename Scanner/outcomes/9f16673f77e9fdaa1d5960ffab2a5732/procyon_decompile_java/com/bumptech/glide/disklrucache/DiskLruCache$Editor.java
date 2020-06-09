// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.disklrucache;

import java.util.ArrayList;
import java.util.Map;
import java.io.EOFException;
import java.io.BufferedWriter;
import java.util.Iterator;
import java.io.PrintStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.LinkedHashMap;
import java.io.Writer;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.Callable;
import java.util.Arrays;
import java.io.Closeable;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStream;

public final class DiskLruCache$Editor
{
    private boolean committed;
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
    
    private InputStream newInputStream(final int n) {
        synchronized (this.this$0) {
            if (this.entry.currentEditor == this) {
                if (!this.entry.readable) {
                    return null;
                }
                try {
                    try {
                        return new FileInputStream(this.entry.getCleanFile(n));
                    }
                    catch (FileNotFoundException ex) {
                        return null;
                    }
                }
                catch (FileNotFoundException ex2) {}
            }
            throw new IllegalStateException();
        }
    }
    
    public void abort() {
        this.this$0.completeEdit(this, false);
    }
    
    public void abortUnlessCommitted() {
        if (!this.committed) {
            try {
                this.abort();
            }
            catch (IOException ex) {}
        }
    }
    
    public void commit() {
        final DiskLruCache this$0 = this.this$0;
        final boolean committed = true;
        this$0.completeEdit(this, committed);
        this.committed = committed;
    }
    
    public File getFile(final int n) {
        synchronized (this.this$0) {
            if (this.entry.currentEditor == this) {
                if (!this.entry.readable) {
                    this.written[n] = true;
                }
                final File dirtyFile = this.entry.getDirtyFile(n);
                if (!this.this$0.directory.exists()) {
                    this.this$0.directory.mkdirs();
                }
                return dirtyFile;
            }
            throw new IllegalStateException();
        }
    }
    
    public String getString(final int n) {
        final InputStream inputStream = this.newInputStream(n);
        String access$1700;
        if (inputStream != null) {
            access$1700 = inputStreamToString(inputStream);
        }
        else {
            access$1700 = null;
        }
        return access$1700;
    }
    
    public void set(final int n, final String s) {
        Closeable closeable = null;
        try {
            ((Writer)(closeable = new OutputStreamWriter(new FileOutputStream(this.getFile(n)), Util.UTF_8))).write(s);
        }
        finally {
            Util.closeQuietly(closeable);
        }
    }
}
