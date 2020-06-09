// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import okhttp3.Protocol;
import okio.BufferedSource;
import java.util.logging.Logger;
import okio.ByteString;
import java.util.List;
import okhttp3.internal.Util;
import java.util.logging.Level;
import java.io.IOException;
import okio.BufferedSink;
import okio.Buffer;

final class Http2$Writer implements FrameWriter
{
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    final Hpack$Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;
    
    Http2$Writer(final BufferedSink sink, final boolean client) {
        this.sink = sink;
        this.client = client;
        this.hpackBuffer = new Buffer();
        this.hpackWriter = new Hpack$Writer(this.hpackBuffer);
        this.maxFrameSize = 16384;
    }
    
    private void writeContinuationFrames(final int n, long n2) {
        while (true) {
            final long n3 = 0L;
            if (n2 <= n3) {
                break;
            }
            final int n4 = (int)Math.min(this.maxFrameSize, n2);
            n2 -= n4;
            final byte b = 9;
            byte b2;
            if (n2 == n3) {
                b2 = 4;
            }
            else {
                b2 = 0;
            }
            this.frameHeader(n, n4, b, b2);
            this.sink.write(this.hpackBuffer, n4);
        }
    }
    
    public void applyAndAckSettings(final Settings settings) {
        synchronized (this) {
            if (!this.closed) {
                this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
                if (settings.getHeaderTableSize() > -1) {
                    this.hpackWriter.setHeaderTableSizeSetting(settings.getHeaderTableSize());
                }
                this.frameHeader(0, 0, (byte)4, (byte)1);
                this.sink.flush();
                return;
            }
            throw new IOException("closed");
        }
    }
    
    public void close() {
        // monitorenter(this)
        final boolean closed = true;
        try {
            this.closed = closed;
            this.sink.close();
        }
        finally {
        }
        // monitorexit(this)
    }
    
    public void connectionPreface() {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (!this.client) {
                return;
            }
            if (Http2.logger.isLoggable(Level.FINE)) {
                Http2.logger.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.hex()));
            }
            this.sink.write(Http2.CONNECTION_PREFACE.toByteArray());
            this.sink.flush();
        }
    }
    
    public void data(final boolean b, final int n, final Buffer buffer, final int n2) {
        synchronized (this) {
            if (!this.closed) {
                byte b2 = 0;
                if (b) {
                    b2 = (byte)((false | true) ? 1 : 0);
                }
                this.dataFrame(n, b2, buffer, n2);
                return;
            }
            throw new IOException("closed");
        }
    }
    
    void dataFrame(final int n, final byte b, final Buffer buffer, final int n2) {
        this.frameHeader(n, n2, (byte)0, b);
        if (n2 > 0) {
            this.sink.write(buffer, n2);
        }
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
    
    void frameHeader(final int n, final int n2, final byte b, final byte b2) {
        if (Http2.logger.isLoggable(Level.FINE)) {
            Http2.logger.fine(Http2$FrameLogger.formatHeader(false, n, n2, b, b2));
        }
        final int maxFrameSize = this.maxFrameSize;
        final int n3 = 1;
        if (n2 > maxFrameSize) {
            final Object[] array = { maxFrameSize, null };
            array[n3] = n2;
            throw illegalArgument("FRAME_SIZE_ERROR length > %d: %d", array);
        }
        if ((-1 << -1 & n) == 0x0) {
            writeMedium(this.sink, n2);
            this.sink.writeByte(b & 0xFF);
            this.sink.writeByte(b2 & 0xFF);
            this.sink.writeInt(-1 >>> 1 & n);
            return;
        }
        final Object[] array2 = new Object[n3];
        array2[0] = n;
        throw illegalArgument("reserved bit set: %s", array2);
    }
    
    public void goAway(final int n, final ErrorCode errorCode, final byte[] array) {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.httpCode != -1) {
                this.frameHeader(0, array.length + 8, (byte)7, (byte)0);
                this.sink.writeInt(n);
                this.sink.writeInt(errorCode.httpCode);
                if (array.length > 0) {
                    this.sink.write(array);
                }
                this.sink.flush();
                return;
            }
            throw illegalArgument("errorCode.httpCode == -1", new Object[0]);
        }
    }
    
    public void headers(final int n, final List list) {
        synchronized (this) {
            if (!this.closed) {
                this.headers(false, n, list);
                return;
            }
            throw new IOException("closed");
        }
    }
    
    void headers(final boolean b, final int n, final List list) {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            final long size = this.hpackBuffer.size();
            final int n2 = (int)Math.min(this.maxFrameSize, size);
            final byte b2 = 1;
            byte b3;
            if (size == n2) {
                b3 = 4;
            }
            else {
                b3 = 0;
            }
            if (b) {
                b3 |= 0x1;
            }
            this.frameHeader(n, n2, b2, b3);
            this.sink.write(this.hpackBuffer, n2);
            if (size > n2) {
                this.writeContinuationFrames(n, size - n2);
            }
            return;
        }
        throw new IOException("closed");
    }
    
    public int maxDataLength() {
        return this.maxFrameSize;
    }
    
    public void ping(final boolean b, final int n, final int n2) {
        synchronized (this) {
            if (!this.closed) {
                final int n3 = 8;
                final byte b2 = 6;
                byte b3;
                if (b) {
                    b3 = 1;
                }
                else {
                    b3 = 0;
                }
                this.frameHeader(0, n3, b2, b3);
                this.sink.writeInt(n);
                this.sink.writeInt(n2);
                this.sink.flush();
                return;
            }
            throw new IOException("closed");
        }
    }
    
    public void pushPromise(final int n, final int n2, final List list) {
        synchronized (this) {
            if (!this.closed) {
                this.hpackWriter.writeHeaders(list);
                final long size = this.hpackBuffer.size();
                final int maxFrameSize = this.maxFrameSize;
                byte b = 4;
                final int n3 = (int)Math.min(maxFrameSize - b, size);
                final byte b2 = 5;
                if (size != n3) {
                    b = 0;
                }
                this.frameHeader(n, n3 + 4, b2, b);
                this.sink.writeInt(-1 >>> 1 & n2);
                this.sink.write(this.hpackBuffer, n3);
                if (size > n3) {
                    this.writeContinuationFrames(n, size - n3);
                }
                return;
            }
            throw new IOException("closed");
        }
    }
    
    public void rstStream(final int n, final ErrorCode errorCode) {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.httpCode != -1) {
                this.frameHeader(n, 4, (byte)3, (byte)0);
                this.sink.writeInt(errorCode.httpCode);
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException();
        }
    }
    
    public void settings(final Settings settings) {
        synchronized (this) {
            if (!this.closed) {
                this.frameHeader(0, settings.size() * 6, (byte)4, (byte)0);
                for (int i = 0; i < 10; ++i) {
                    if (settings.isSet(i)) {
                        int n;
                        if ((n = i) == 4) {
                            n = 3;
                        }
                        else if (i == 7) {
                            n = 4;
                        }
                        this.sink.writeShort(n);
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
                this.headers(b, n, list);
                return;
            }
            throw new IOException("closed");
        }
    }
    
    public void synStream(final boolean b, final boolean b2, final int n, final int n2, final List list) {
        // monitorenter(this)
        if (!b2) {
            Label_0065: {
                try {
                    if (!this.closed) {
                        this.headers(b, n, list);
                        // monitorexit(this)
                        return;
                    }
                    throw new IOException("closed");
                }
                finally {
                    break Label_0065;
                }
                throw new UnsupportedOperationException();
            }
        }
        // monitorexit(this)
        throw new UnsupportedOperationException();
    }
    
    public void windowUpdate(final int n, final long n2) {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (n2 != 0L && n2 <= 2147483647L) {
                this.frameHeader(n, 4, (byte)8, (byte)0);
                this.sink.writeInt((int)n2);
                this.sink.flush();
                return;
            }
            throw illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] { n2 });
        }
    }
}
