// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.nio.charset.Charset;
import java.io.EOFException;
import java.io.InputStream;

final class RealBufferedSource implements BufferedSource
{
    public final Buffer buffer;
    boolean closed;
    public final Source source;
    
    RealBufferedSource(final Source source) {
        this.buffer = new Buffer();
        if (source != null) {
            this.source = source;
            return;
        }
        throw new NullPointerException("source == null");
    }
    
    public Buffer buffer() {
        return this.buffer;
    }
    
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.buffer.clear();
    }
    
    public boolean exhausted() {
        if (!this.closed) {
            return this.buffer.exhausted() && this.source.read(this.buffer, 8192L) == -1;
        }
        throw new IllegalStateException("closed");
    }
    
    public long indexOf(final byte b) {
        return this.indexOf(b, 0L);
    }
    
    public long indexOf(final byte b, long max) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            final long index = this.buffer.indexOf(b, max);
            final long n = -1;
            if (index != n) {
                return index;
            }
            final long size = this.buffer.size;
            if (this.source.read(this.buffer, 8192L) == n) {
                return n;
            }
            max = Math.max(max, size);
        }
    }
    
    public long indexOf(final ByteString byteString) {
        return this.indexOf(byteString, 0L);
    }
    
    public long indexOf(final ByteString byteString, long max) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            final long index = this.buffer.indexOf(byteString, max);
            final long n = -1;
            if (index != n) {
                return index;
            }
            final long size = this.buffer.size;
            if (this.source.read(this.buffer, 8192L) == n) {
                return n;
            }
            max = Math.max(max, size - byteString.size() + 1L);
        }
    }
    
    public long indexOfElement(final ByteString byteString) {
        return this.indexOfElement(byteString, 0L);
    }
    
    public long indexOfElement(final ByteString byteString, long max) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            final long indexOfElement = this.buffer.indexOfElement(byteString, max);
            final long n = -1;
            if (indexOfElement != n) {
                return indexOfElement;
            }
            final long size = this.buffer.size;
            if (this.source.read(this.buffer, 8192L) == n) {
                return n;
            }
            max = Math.max(max, size);
        }
    }
    
    public InputStream inputStream() {
        return new RealBufferedSource$1(this);
    }
    
    public boolean rangeEquals(final long n, final ByteString byteString) {
        return this.rangeEquals(n, byteString, 0, byteString.size());
    }
    
    public boolean rangeEquals(final long n, final ByteString byteString, final int n2, final int n3) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (n >= 0L && n2 >= 0 && n3 >= 0 && byteString.size() - n2 >= n3) {
            for (int i = 0; i < n3; ++i) {
                final long n4 = i + n;
                if (!this.request(1L + n4)) {
                    return false;
                }
                if (this.buffer.getByte(n4) != byteString.getByte(n2 + i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public int read(final byte[] array) {
        return this.read(array, 0, array.length);
    }
    
    public int read(final byte[] array, final int n, final int n2) {
        Util.checkOffsetAndCount(array.length, n, n2);
        if (this.buffer.size == 0L && this.source.read(this.buffer, 8192L) == -1) {
            return -1;
        }
        return this.buffer.read(array, n, (int)Math.min(n2, this.buffer.size));
    }
    
    public long read(final Buffer buffer, final long n) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        final long n2 = 0L;
        if (n < n2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString());
        }
        if (!this.closed) {
            if (this.buffer.size == n2) {
                final long read = this.source.read(this.buffer, 8192L);
                final long n3 = -1;
                if (read == n3) {
                    return n3;
                }
            }
            return this.buffer.read(buffer, Math.min(n, this.buffer.size));
        }
        throw new IllegalStateException("closed");
    }
    
    public long readAll(final Sink sink) {
        if (sink != null) {
            long n = 0L;
            long n3;
            while (true) {
                final long read = this.source.read(this.buffer, 8192L);
                final long n2 = -1;
                n3 = 0L;
                if (read == n2) {
                    break;
                }
                final long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
                if (completeSegmentByteCount <= n3) {
                    continue;
                }
                n += completeSegmentByteCount;
                sink.write(this.buffer, completeSegmentByteCount);
            }
            if (this.buffer.size() > n3) {
                n += this.buffer.size();
                final Buffer buffer = this.buffer;
                sink.write(buffer, buffer.size());
            }
            return n;
        }
        throw new IllegalArgumentException("sink == null");
    }
    
    public byte readByte() {
        this.require(1L);
        return this.buffer.readByte();
    }
    
    public byte[] readByteArray() {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteArray();
    }
    
    public byte[] readByteArray(final long n) {
        this.require(n);
        return this.buffer.readByteArray(n);
    }
    
    public ByteString readByteString() {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteString();
    }
    
    public ByteString readByteString(final long n) {
        this.require(n);
        return this.buffer.readByteString(n);
    }
    
    public long readDecimalLong() {
        this.require(1L);
        int n = 0;
        while (this.request(n + 1)) {
            final byte byte1 = this.buffer.getByte(n);
            if ((byte1 < 48 || byte1 > 57) && (n != 0 || byte1 != 45)) {
                if (n != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", byte1));
            }
            else {
                ++n;
            }
        }
        return this.buffer.readDecimalLong();
    }
    
    public void readFully(final Buffer buffer, final long n) {
        try {
            this.require(n);
            this.buffer.readFully(buffer, n);
        }
        catch (EOFException ex) {
            buffer.writeAll(this.buffer);
            throw ex;
        }
    }
    
    public void readFully(final byte[] array) {
        try {
            this.require(array.length);
            this.buffer.readFully(array);
        }
        catch (EOFException ex) {
            int n = 0;
            while (this.buffer.size > 0L) {
                final Buffer buffer = this.buffer;
                final int read = buffer.read(array, n, (int)buffer.size);
                if (read == -1) {
                    throw new AssertionError();
                }
                n += read;
            }
            throw ex;
        }
    }
    
    public long readHexadecimalUnsignedLong() {
        this.require(1L);
        int n = 0;
        while (this.request(n + 1)) {
            final byte byte1 = this.buffer.getByte(n);
            if ((byte1 < 48 || byte1 > 57) && ((byte1 < 97 || byte1 > 102) && (byte1 < 65 || byte1 > 70))) {
                if (n != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", byte1));
            }
            else {
                ++n;
            }
        }
        return this.buffer.readHexadecimalUnsignedLong();
    }
    
    public int readInt() {
        this.require(4);
        return this.buffer.readInt();
    }
    
    public int readIntLe() {
        this.require(4);
        return this.buffer.readIntLe();
    }
    
    public long readLong() {
        this.require(8);
        return this.buffer.readLong();
    }
    
    public long readLongLe() {
        this.require(8);
        return this.buffer.readLongLe();
    }
    
    public short readShort() {
        this.require(2);
        return this.buffer.readShort();
    }
    
    public short readShortLe() {
        this.require(2);
        return this.buffer.readShortLe();
    }
    
    public String readString(final long n, final Charset charset) {
        this.require(n);
        if (charset != null) {
            return this.buffer.readString(n, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }
    
    public String readString(final Charset charset) {
        if (charset != null) {
            this.buffer.writeAll(this.source);
            return this.buffer.readString(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }
    
    public String readUtf8() {
        this.buffer.writeAll(this.source);
        return this.buffer.readUtf8();
    }
    
    public String readUtf8(final long n) {
        this.require(n);
        return this.buffer.readUtf8(n);
    }
    
    public int readUtf8CodePoint() {
        this.require(1L);
        final byte byte1 = this.buffer.getByte(0L);
        if ((byte1 & 0xE0) == 0xC0) {
            this.require(2);
        }
        else if ((byte1 & 0xF0) == 0xE0) {
            this.require(3);
        }
        else if ((byte1 & 0xF8) == 0xF0) {
            this.require(4);
        }
        return this.buffer.readUtf8CodePoint();
    }
    
    public String readUtf8Line() {
        final long index = this.indexOf((byte)10);
        if (index == -1) {
            String utf8;
            if (this.buffer.size != 0L) {
                utf8 = this.readUtf8(this.buffer.size);
            }
            else {
                utf8 = null;
            }
            return utf8;
        }
        return this.buffer.readUtf8Line(index);
    }
    
    public String readUtf8LineStrict() {
        final long index = this.indexOf((byte)10);
        if (index != -1) {
            return this.buffer.readUtf8Line(index);
        }
        final Buffer buffer = new Buffer();
        final Buffer buffer2 = this.buffer;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        final StringBuilder sb = new StringBuilder();
        sb.append("\\n not found: size=");
        sb.append(this.buffer.size());
        sb.append(" content=");
        sb.append(buffer.readByteString().hex());
        sb.append("\u2026");
        throw new EOFException(sb.toString());
    }
    
    public boolean request(final long n) {
        if (n < 0L) {
            final StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString());
        }
        if (!this.closed) {
            while (this.buffer.size < n) {
                if (this.source.read(this.buffer, 8192L) == -1) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }
    
    public void require(final long n) {
        if (this.request(n)) {
            return;
        }
        throw new EOFException();
    }
    
    public int select(final Options options) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            final int selectPrefix = this.buffer.selectPrefix(options);
            final int n = -1;
            if (selectPrefix == n) {
                return n;
            }
            final int size = options.byteStrings[selectPrefix].size();
            if (size <= this.buffer.size) {
                this.buffer.skip(size);
                return selectPrefix;
            }
            if (this.source.read(this.buffer, 8192L) == -1) {
                return n;
            }
        }
    }
    
    public void skip(long n) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            final long n2 = 0L;
            if (n <= n2) {
                return;
            }
            if (this.buffer.size == n2 && this.source.read(this.buffer, 8192L) == -1) {
                throw new EOFException();
            }
            final long min = Math.min(n, this.buffer.size());
            this.buffer.skip(min);
            n -= min;
        }
    }
    
    public Timeout timeout() {
        return this.source.timeout();
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(this.source);
        sb.append(")");
        return sb.toString();
    }
}
