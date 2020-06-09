// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import java.io.IOException;
import android.util.Log;
import java.io.InputStream;
import java.io.FilterInputStream;

public class RecyclableBufferedInputStream extends FilterInputStream
{
    private static final String TAG = "BufferedIs";
    private volatile byte[] buf;
    private int count;
    private int marklimit;
    private int markpos;
    private int pos;
    
    public RecyclableBufferedInputStream(final InputStream inputStream, final byte[] buf) {
        super(inputStream);
        this.markpos = -1;
        if (buf != null && buf.length != 0) {
            this.buf = buf;
            return;
        }
        throw new IllegalArgumentException("buffer is null or empty");
    }
    
    private int fillbuf(final InputStream inputStream, byte[] array) {
        final int markpos = this.markpos;
        final int markpos2 = -1;
        if (markpos != markpos2) {
            final int n = this.pos - markpos;
            final int marklimit = this.marklimit;
            if (n < marklimit) {
                if (markpos == 0 && marklimit > array.length && this.count == array.length) {
                    int marklimit2 = array.length * 2;
                    if (marklimit2 > marklimit) {
                        marklimit2 = this.marklimit;
                    }
                    if (Log.isLoggable("BufferedIs", 3)) {
                        final String s = "BufferedIs";
                        final StringBuilder sb = new StringBuilder();
                        sb.append("allocate buffer of length: ");
                        sb.append(marklimit2);
                        Log.d(s, sb.toString());
                    }
                    final byte[] buf = new byte[marklimit2];
                    System.arraycopy(array, 0, buf, 0, array.length);
                    this.buf = buf;
                    array = buf;
                }
                else {
                    final int markpos3 = this.markpos;
                    if (markpos3 > 0) {
                        System.arraycopy(array, markpos3, array, 0, array.length - markpos3);
                    }
                }
                this.pos -= this.markpos;
                this.markpos = 0;
                this.count = 0;
                final int pos = this.pos;
                final int read = inputStream.read(array, pos, array.length - pos);
                int pos2;
                if (read <= 0) {
                    pos2 = this.pos;
                }
                else {
                    pos2 = this.pos + read;
                }
                this.count = pos2;
                return read;
            }
        }
        final int read2 = inputStream.read(array);
        if (read2 > 0) {
            this.markpos = markpos2;
            this.pos = 0;
            this.count = read2;
        }
        return read2;
    }
    
    private static IOException streamClosed() {
        throw new IOException("BufferedInputStream is closed");
    }
    
    public int available() {
        synchronized (this) {
            final InputStream in = this.in;
            if (this.buf != null && in != null) {
                return this.count - this.pos + in.available();
            }
            throw streamClosed();
        }
    }
    
    public void close() {
        this.buf = null;
        final InputStream in = this.in;
        this.in = null;
        if (in != null) {
            in.close();
        }
    }
    
    public void fixMarkLimit() {
        synchronized (this) {
            this.marklimit = this.buf.length;
        }
    }
    
    public void mark(final int n) {
        synchronized (this) {
            this.marklimit = Math.max(this.marklimit, n);
            this.markpos = this.pos;
        }
    }
    
    public boolean markSupported() {
        return true;
    }
    
    public int read() {
        synchronized (this) {
            byte[] array = this.buf;
            final InputStream in = this.in;
            if (array == null || in == null) {
                throw streamClosed();
            }
            final int pos = this.pos;
            final int count = this.count;
            final int n = -1;
            if (pos >= count && this.fillbuf(in, array) == n) {
                return n;
            }
            if (array != this.buf && (array = this.buf) == null) {
                throw streamClosed();
            }
            if (this.count - this.pos > 0) {
                return array[this.pos++] & 0xFF;
            }
            return n;
        }
    }
    
    public int read(final byte[] array, int n, final int n2) {
        synchronized (this) {
            byte[] array2 = this.buf;
            if (array2 == null) {
                throw streamClosed();
            }
            if (n2 == 0) {
                return 0;
            }
            final InputStream in = this.in;
            if (in == null) {
                throw streamClosed();
            }
            int n4;
            if (this.pos < this.count) {
                int n3;
                if (this.count - this.pos >= n2) {
                    n3 = n2;
                }
                else {
                    n3 = this.count - this.pos;
                }
                System.arraycopy(array2, this.pos, array, n, n3);
                this.pos += n3;
                if (n3 == n2 || in.available() == 0) {
                    return n3;
                }
                n += n3;
                n4 = n2 - n3;
            }
            else {
                n4 = n2;
            }
            while (true) {
                final int markpos = this.markpos;
                int n5 = -1;
                int read;
                if (markpos == n5 && n4 >= array2.length) {
                    read = in.read(array, n, n4);
                    if (read == n5) {
                        if (n4 != n2) {
                            n5 = n2 - n4;
                        }
                        return n5;
                    }
                }
                else {
                    if (this.fillbuf(in, array2) == n5) {
                        if (n4 != n2) {
                            n5 = n2 - n4;
                        }
                        return n5;
                    }
                    if (array2 != this.buf && (array2 = this.buf) == null) {
                        throw streamClosed();
                    }
                    if (this.count - this.pos >= n4) {
                        read = n4;
                    }
                    else {
                        read = this.count - this.pos;
                    }
                    System.arraycopy(array2, this.pos, array, n, read);
                    this.pos += read;
                }
                n4 -= read;
                if (n4 == 0) {
                    return n2;
                }
                if (in.available() == 0) {
                    return n2 - n4;
                }
                n += read;
            }
        }
    }
    
    public void reset() {
        synchronized (this) {
            if (this.buf == null) {
                throw new IOException("Stream is closed");
            }
            if (-1 != this.markpos) {
                this.pos = this.markpos;
                return;
            }
            throw new RecyclableBufferedInputStream$InvalidMarkException("Mark has been invalidated");
        }
    }
    
    public long skip(final long n) {
        synchronized (this) {
            final byte[] buf = this.buf;
            final InputStream in = this.in;
            if (buf == null) {
                throw streamClosed();
            }
            if (n < 1L) {
                return 0L;
            }
            if (in == null) {
                throw streamClosed();
            }
            if (this.count - this.pos >= n) {
                this.pos += (int)n;
                return n;
            }
            final long n2 = this.count - this.pos;
            this.pos = this.count;
            final int markpos = this.markpos;
            final int n3 = -1;
            if (markpos == n3 || n > this.marklimit) {
                return in.skip(n - n2) + n2;
            }
            if (this.fillbuf(in, buf) == n3) {
                return n2;
            }
            if (this.count - this.pos >= n - n2) {
                this.pos += (int)(n - n2);
                return n;
            }
            final long n4 = this.count + n2 - this.pos;
            this.pos = this.count;
            return n4;
        }
    }
}
