// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import okio.Source;
import java.io.IOException;
import java.io.Closeable;
import okhttp3.internal.Util;
import okio.ByteString;
import java.util.List;
import okio.Okio;
import okio.Sink;
import okio.DeflaterSink;
import java.util.zip.Deflater;
import okio.BufferedSink;
import okio.Buffer;

final class Spdy3$Writer implements FrameWriter
{
    private final boolean client;
    private boolean closed;
    private final Buffer headerBlockBuffer;
    private final BufferedSink headerBlockOut;
    private final BufferedSink sink;
    
    Spdy3$Writer(final BufferedSink sink, final boolean client) {
        this.sink = sink;
        this.client = client;
        final Deflater deflater = new Deflater();
        deflater.setDictionary(Spdy3.DICTIONARY);
        this.headerBlockBuffer = new Buffer();
        this.headerBlockOut = Okio.buffer(new DeflaterSink((Sink)this.headerBlockBuffer, deflater));
    }
    
    private void writeNameValueBlockToBuffer(final List list) {
        this.headerBlockOut.writeInt(list.size());
        for (int i = 0; i < list.size(); ++i) {
            final ByteString name = list.get(i).name;
            this.headerBlockOut.writeInt(name.size());
            this.headerBlockOut.write(name);
            final ByteString value = list.get(i).value;
            this.headerBlockOut.writeInt(value.size());
            this.headerBlockOut.write(value);
        }
        this.headerBlockOut.flush();
    }
    
    public void applyAndAckSettings(final Settings settings) {
    }
    
    public void close() {
        // monitorenter(this)
        final boolean closed = true;
        try {
            this.closed = closed;
            Util.closeAll(this.sink, this.headerBlockOut);
        }
        finally {
        }
        // monitorexit(this)
    }
    
    public void connectionPreface() {
    }
    // monitorenter(this)
    // monitorexit(this)
    
    public void data(final boolean b, final int n, final Buffer buffer, final int n2) {
        // monitorenter(this)
        final int n3 = b ? 1 : 0;
        try {
            this.sendDataFrame(n, n3, buffer, n2);
        }
        finally {
        }
        // monitorexit(this)
    }
    
    public void flush() {
        synchronized (this) {
            if (!this.closed) {
                this.sink.flush();
                return;
            }
            throw new IOException("closed");
        }
    }
    
    public void goAway(final int n, final ErrorCode errorCode, final byte[] array) {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.spdyGoAwayCode != -1) {
                final char c = '\u0007';
                final int n2 = 8;
                this.sink.writeInt(0x80030000 | ((char)(-1) & c));
                this.sink.writeInt((0x0 & 0xFF) << 24 | (0xFFFFFF & n2));
                this.sink.writeInt(n);
                this.sink.writeInt(errorCode.spdyGoAwayCode);
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
        }
    }
    
    public void headers(final int n, final List list) {
        synchronized (this) {
            if (!this.closed) {
                this.writeNameValueBlockToBuffer(list);
                final char c = '\b';
                final int n2 = (int)(this.headerBlockBuffer.size() + 4);
                this.sink.writeInt(0x80030000 | ((char)(-1) & c));
                this.sink.writeInt((0x0 & 0xFF) << 24 | (0xFFFFFF & n2));
                this.sink.writeInt(-1 >>> 1 & n);
                this.sink.writeAll(this.headerBlockBuffer);
                return;
            }
            throw new IOException("closed");
        }
    }
    
    public int maxDataLength() {
        return 16383;
    }
    
    public void ping(final boolean b, final int n, final int n2) {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            final boolean client = this.client;
            final int n3 = n & 0x1;
            boolean b2 = false;
            if (client != (n3 == 1)) {
                b2 = true;
            }
            if (b == b2) {
                final char c = '\u0006';
                final int n4 = 4;
                this.sink.writeInt(0x80030000 | ((char)(-1) & c));
                this.sink.writeInt((0x0 & 0xFF) << 24 | (0xFFFFFF & n4));
                this.sink.writeInt(n);
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException("payload != reply");
        }
    }
    
    public void pushPromise(final int n, final int n2, final List list) {
    }
    
    public void rstStream(final int n, final ErrorCode errorCode) {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.spdyRstCode != -1) {
                final char c = '\u0003';
                final int n2 = 8;
                this.sink.writeInt(0x80030000 | ((char)(-1) & c));
                this.sink.writeInt((0x0 & 0xFF) << 24 | (0xFFFFFF & n2));
                this.sink.writeInt(-1 >>> 1 & n);
                this.sink.writeInt(errorCode.spdyRstCode);
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException();
        }
    }
    
    void sendDataFrame(final int n, final int n2, final Buffer buffer, final int n3) {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (n3 <= 16777215L) {
            this.sink.writeInt(-1 >>> 1 & n);
            this.sink.writeInt((n2 & 0xFF) << 24 | (0xFFFFFF & n3));
            if (n3 > 0) {
                this.sink.write(buffer, n3);
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("FRAME_TOO_LARGE max size is 16Mib: ");
        sb.append(n3);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void settings(final Settings settings) {
        synchronized (this) {
            if (!this.closed) {
                final char c = '\u0004';
                final int size = settings.size();
                final int n = size * 8 + 4;
                this.sink.writeInt(0x80030000 | ((char)(-1) & c));
                final BufferedSink sink = this.sink;
                final int n2 = (0x0 & 0xFF) << 24;
                final int n3 = 16777215;
                sink.writeInt(n2 | (n & n3));
                this.sink.writeInt(size);
                for (int i = 0; i <= 10; ++i) {
                    if (settings.isSet(i)) {
                        this.sink.writeInt((settings.flags(i) & 0xFF) << 24 | (i & n3));
                        this.sink.writeInt(settings.get(i));
                    }
                }
                this.sink.flush();
                return;
            }
            throw new IOException("closed");
        }
    }
    
    public void synReply(final boolean b, final int n, final List list) {
        synchronized (this) {
            if (!this.closed) {
                this.writeNameValueBlockToBuffer(list);
                final char c = '\u0002';
                final boolean b2 = b;
                final int n2 = (int)(this.headerBlockBuffer.size() + 4);
                this.sink.writeInt(0x80030000 | ((char)(-1) & c));
                this.sink.writeInt(((b2 ? 1 : 0) & 0xFF) << 24 | (0xFFFFFF & n2));
                this.sink.writeInt(-1 >>> 1 & n);
                this.sink.writeAll(this.headerBlockBuffer);
                this.sink.flush();
                return;
            }
            throw new IOException("closed");
        }
    }
    
    public void synStream(final boolean b, final boolean b2, final int n, final int n2, final List list) {
        synchronized (this) {
            if (!this.closed) {
                this.writeNameValueBlockToBuffer(list);
                final int n3 = (int)(this.headerBlockBuffer.size() + 10);
                final char c = '\u0001';
                int n4;
                if (b2) {
                    n4 = 2;
                }
                else {
                    n4 = 0;
                }
                final boolean b3 = (n4 | (b ? 1 : 0)) != 0x0;
                this.sink.writeInt(0x80030000 | ((char)(-1) & c));
                this.sink.writeInt(((b3 ? 1 : 0) & 0xFF) << 24 | (0xFFFFFF & n3));
                final BufferedSink sink = this.sink;
                final int n5 = -1 >>> 1;
                sink.writeInt(n & n5);
                this.sink.writeInt(n5 & n2);
                this.sink.writeShort((0x0 & 0x7) << 13 | (0x0 & 0x1F) << 8 | (0x0 & 0xFF));
                this.sink.writeAll(this.headerBlockBuffer);
                this.sink.flush();
                return;
            }
            throw new IOException("closed");
        }
    }
    
    public void windowUpdate(final int n, final long n2) {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (n2 != 0L && n2 <= 2147483647L) {
                final char c = '\t';
                final int n3 = 8;
                this.sink.writeInt(0x80030000 | ((char)(-1) & c));
                this.sink.writeInt((0x0 & 0xFF) << 24 | (0xFFFFFF & n3));
                this.sink.writeInt(n);
                this.sink.writeInt((int)n2);
                this.sink.flush();
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("windowSizeIncrement must be between 1 and 0x7fffffff: ");
            sb.append(n2);
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
