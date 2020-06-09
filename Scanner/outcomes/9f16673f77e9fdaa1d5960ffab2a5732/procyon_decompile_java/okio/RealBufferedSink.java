// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.nio.charset.Charset;
import java.io.EOFException;
import java.io.OutputStream;

final class RealBufferedSink implements BufferedSink
{
    public final Buffer buffer;
    boolean closed;
    public final Sink sink;
    
    RealBufferedSink(final Sink sink) {
        this.buffer = new Buffer();
        if (sink != null) {
            this.sink = sink;
            return;
        }
        throw new NullPointerException("sink == null");
    }
    
    public Buffer buffer() {
        return this.buffer;
    }
    
    public void close() {
        if (this.closed) {
            return;
        }
        Throwable t = null;
        try {
            if (this.buffer.size > 0L) {
                this.sink.write(this.buffer, this.buffer.size);
            }
        }
        finally {
            final Throwable t2;
            t = t2;
        }
        try {
            this.sink.close();
        }
        finally {
            if (t == null) {
                final Throwable t3;
                t = t3;
            }
        }
        this.closed = true;
        if (t != null) {
            Util.sneakyRethrow(t);
        }
    }
    
    public BufferedSink emit() {
        if (!this.closed) {
            final long size = this.buffer.size();
            if (size > 0L) {
                this.sink.write(this.buffer, size);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }
    
    public BufferedSink emitCompleteSegments() {
        if (!this.closed) {
            final long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
            if (completeSegmentByteCount > 0L) {
                this.sink.write(this.buffer, completeSegmentByteCount);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }
    
    public void flush() {
        if (!this.closed) {
            if (this.buffer.size > 0L) {
                final Sink sink = this.sink;
                final Buffer buffer = this.buffer;
                sink.write(buffer, buffer.size);
            }
            this.sink.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }
    
    public OutputStream outputStream() {
        return new RealBufferedSink$1(this);
    }
    
    public Timeout timeout() {
        return this.sink.timeout();
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(this.sink);
        sb.append(")");
        return sb.toString();
    }
    
    public BufferedSink write(final ByteString byteString) {
        if (!this.closed) {
            this.buffer.write(byteString);
            return this.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
    
    public BufferedSink write(final Source source, long n) {
        while (n > 0L) {
            final long read = source.read(this.buffer, n);
            if (read == -1) {
                throw new EOFException();
            }
            n -= read;
            this.emitCompleteSegments();
        }
        return this;
    }
    
    public BufferedSink write(final byte[] array) {
        if (!this.closed) {
            this.buffer.write(array);
            return this.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
    
    public BufferedSink write(final byte[] array, final int n, final int n2) {
        if (!this.closed) {
            this.buffer.write(array, n, n2);
            return this.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
    
    public void write(final Buffer buffer, final long n) {
        if (!this.closed) {
            this.buffer.write(buffer, n);
            this.emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed");
    }
    
    public long writeAll(final Source source) {
        if (source != null) {
            long n = 0L;
            while (true) {
                final long read = source.read(this.buffer, 8192L);
                if (read == -1) {
                    break;
                }
                n += read;
                this.emitCompleteSegments();
            }
            return n;
        }
        throw new IllegalArgumentException("source == null");
    }
    
    public BufferedSink writeByte(final int n) {
        if (!this.closed) {
            this.buffer.writeByte(n);
            return this.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
    
    public BufferedSink writeDecimalLong(final long n) {
        if (!this.closed) {
            this.buffer.writeDecimalLong(n);
            return this.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
    
    public BufferedSink writeHexadecimalUnsignedLong(final long n) {
        if (!this.closed) {
            this.buffer.writeHexadecimalUnsignedLong(n);
            return this.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
    
    public BufferedSink writeInt(final int n) {
        if (!this.closed) {
            this.buffer.writeInt(n);
            return this.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
    
    public BufferedSink writeIntLe(final int n) {
        if (!this.closed) {
            this.buffer.writeIntLe(n);
            return this.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
    
    public BufferedSink writeLong(final long n) {
        if (!this.closed) {
            this.buffer.writeLong(n);
            return this.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
    
    public BufferedSink writeLongLe(final long n) {
        if (!this.closed) {
            this.buffer.writeLongLe(n);
            return this.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
    
    public BufferedSink writeShort(final int n) {
        if (!this.closed) {
            this.buffer.writeShort(n);
            return this.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
    
    public BufferedSink writeShortLe(final int n) {
        if (!this.closed) {
            this.buffer.writeShortLe(n);
            return this.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
    
    public BufferedSink writeString(final String s, final int n, final int n2, final Charset charset) {
        if (!this.closed) {
            this.buffer.writeString(s, n, n2, charset);
            return this.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
    
    public BufferedSink writeString(final String s, final Charset charset) {
        if (!this.closed) {
            this.buffer.writeString(s, charset);
            return this.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
    
    public BufferedSink writeUtf8(final String s) {
        if (!this.closed) {
            this.buffer.writeUtf8(s);
            return this.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
    
    public BufferedSink writeUtf8(final String s, final int n, final int n2) {
        if (!this.closed) {
            this.buffer.writeUtf8(s, n, n2);
            return this.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
    
    public BufferedSink writeUtf8CodePoint(final int n) {
        if (!this.closed) {
            this.buffer.writeUtf8CodePoint(n);
            return this.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }
}
