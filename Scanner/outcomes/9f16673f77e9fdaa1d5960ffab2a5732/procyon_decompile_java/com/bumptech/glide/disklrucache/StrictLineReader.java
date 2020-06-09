// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.disklrucache;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.io.Closeable;

class StrictLineReader implements Closeable
{
    private static final byte CR = 13;
    private static final byte LF = 10;
    private byte[] buf;
    private final Charset charset;
    private int end;
    private final InputStream in;
    private int pos;
    
    public StrictLineReader(final InputStream in, final int n, final Charset charset) {
        if (in == null || charset == null) {
            throw new NullPointerException();
        }
        if (n < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (charset.equals(Util.US_ASCII)) {
            this.in = in;
            this.charset = charset;
            this.buf = new byte[n];
            return;
        }
        throw new IllegalArgumentException("Unsupported encoding");
    }
    
    public StrictLineReader(final InputStream inputStream, final Charset charset) {
        this(inputStream, 8192, charset);
    }
    
    private void fillBuf() {
        final InputStream in = this.in;
        final byte[] buf = this.buf;
        final int read = in.read(buf, 0, buf.length);
        if (read != -1) {
            this.pos = 0;
            this.end = read;
            return;
        }
        throw new EOFException();
    }
    
    public void close() {
        synchronized (this.in) {
            if (this.buf != null) {
                this.buf = null;
                this.in.close();
            }
        }
    }
    
    public boolean hasUnterminatedLine() {
        return this.end == -1;
    }
    
    public String readLine() {
        synchronized (this.in) {
            if (this.buf == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.pos >= this.end) {
                this.fillBuf();
            }
            int pos = this.pos;
            while (true) {
                final int end = this.end;
                final byte b = 10;
                if (pos == end) {
                    final StrictLineReader$1 strictLineReader$1 = new StrictLineReader$1(this, this.end - this.pos + 80);
                    int i = 0;
                Block_10:
                    while (true) {
                        strictLineReader$1.write(this.buf, this.pos, this.end - this.pos);
                        this.end = -1;
                        this.fillBuf();
                        for (i = this.pos; i != this.end; ++i) {
                            if (this.buf[i] == b) {
                                break Block_10;
                            }
                        }
                    }
                    if (i != this.pos) {
                        strictLineReader$1.write(this.buf, this.pos, i - this.pos);
                    }
                    this.pos = i + 1;
                    return strictLineReader$1.toString();
                }
                if (this.buf[pos] == b) {
                    int n;
                    if (pos != this.pos && this.buf[pos - 1] == 13) {
                        n = pos - 1;
                    }
                    else {
                        n = pos;
                    }
                    final String s = new String(this.buf, this.pos, n - this.pos, this.charset.name());
                    this.pos = pos + 1;
                    return s;
                }
                ++pos;
            }
        }
    }
}
