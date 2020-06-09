// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.util;

import java.io.IOException;
import java.util.Queue;
import java.io.InputStream;

public class ExceptionCatchingInputStream extends InputStream
{
    private static final Queue QUEUE;
    private IOException exception;
    private InputStream wrapped;
    
    static {
        QUEUE = Util.createQueue(0);
    }
    
    static void clearQueue() {
        while (!ExceptionCatchingInputStream.QUEUE.isEmpty()) {
            ExceptionCatchingInputStream.QUEUE.remove();
        }
    }
    
    public static ExceptionCatchingInputStream obtain(final InputStream inputStream) {
        Object queue = ExceptionCatchingInputStream.QUEUE;
        synchronized (queue) {
            ExceptionCatchingInputStream exceptionCatchingInputStream2;
            final ExceptionCatchingInputStream exceptionCatchingInputStream = exceptionCatchingInputStream2 = ExceptionCatchingInputStream.QUEUE.poll();
            // monitorexit(queue)
            if (exceptionCatchingInputStream == null) {
                queue = (exceptionCatchingInputStream2 = new ExceptionCatchingInputStream());
            }
            exceptionCatchingInputStream2.setInputStream(inputStream);
            return exceptionCatchingInputStream2;
        }
    }
    
    public int available() {
        return this.wrapped.available();
    }
    
    public void close() {
        this.wrapped.close();
    }
    
    public IOException getException() {
        return this.exception;
    }
    
    public void mark(final int n) {
        this.wrapped.mark(n);
    }
    
    public boolean markSupported() {
        return this.wrapped.markSupported();
    }
    
    public int read() {
        int read = 0;
        try {
            final InputStream wrapped = this.wrapped;
            try {
                read = wrapped.read();
            }
            catch (IOException exception) {
                this.exception = exception;
                read = -1;
            }
        }
        catch (IOException ex) {}
        return read;
    }
    
    public int read(final byte[] array) {
        int read;
        try {
            read = this.wrapped.read(array);
        }
        catch (IOException exception) {
            this.exception = exception;
            read = -1;
        }
        return read;
    }
    
    public int read(final byte[] array, final int n, final int n2) {
        int read;
        try {
            read = this.wrapped.read(array, n, n2);
        }
        catch (IOException exception) {
            this.exception = exception;
            read = -1;
        }
        return read;
    }
    
    public void release() {
        this.exception = null;
        this.wrapped = null;
        synchronized (ExceptionCatchingInputStream.QUEUE) {
            ExceptionCatchingInputStream.QUEUE.offer(this);
        }
    }
    
    public void reset() {
        synchronized (this) {
            this.wrapped.reset();
        }
    }
    
    void setInputStream(final InputStream wrapped) {
        this.wrapped = wrapped;
    }
    
    public long skip(final long n) {
        long skip;
        try {
            skip = this.wrapped.skip(n);
        }
        catch (IOException exception) {
            this.exception = exception;
            skip = 0L;
        }
        return skip;
    }
}
