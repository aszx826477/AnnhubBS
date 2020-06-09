// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import okhttp3.Protocol;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.BufferedSource;
import java.io.IOException;
import java.util.logging.Logger;
import okio.ByteString;

public final class Http2 implements Variant
{
    private static final ByteString CONNECTION_PREFACE;
    static final byte FLAG_ACK = 1;
    static final byte FLAG_COMPRESSED = 32;
    static final byte FLAG_END_HEADERS = 4;
    static final byte FLAG_END_PUSH_PROMISE = 4;
    static final byte FLAG_END_STREAM = 1;
    static final byte FLAG_NONE = 0;
    static final byte FLAG_PADDED = 8;
    static final byte FLAG_PRIORITY = 32;
    static final int INITIAL_MAX_FRAME_SIZE = 16384;
    static final byte TYPE_CONTINUATION = 9;
    static final byte TYPE_DATA = 0;
    static final byte TYPE_GOAWAY = 7;
    static final byte TYPE_HEADERS = 1;
    static final byte TYPE_PING = 6;
    static final byte TYPE_PRIORITY = 2;
    static final byte TYPE_PUSH_PROMISE = 5;
    static final byte TYPE_RST_STREAM = 3;
    static final byte TYPE_SETTINGS = 4;
    static final byte TYPE_WINDOW_UPDATE = 8;
    private static final Logger logger;
    
    static {
        logger = Logger.getLogger(Http2$FrameLogger.class.getName());
        CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    }
    
    private static IllegalArgumentException illegalArgument(final String s, final Object... array) {
        throw new IllegalArgumentException(Util.format(s, array));
    }
    
    private static IOException ioException(final String s, final Object... array) {
        throw new IOException(Util.format(s, array));
    }
    
    private static int lengthWithoutPadding(int n, final byte b, final short n2) {
        if ((b & 0x8) != 0x0) {
            --n;
        }
        if (n2 <= n) {
            return (short)(n - n2);
        }
        throw ioException("PROTOCOL_ERROR padding %s > remaining length %s", n2, n);
    }
    
    private static int readMedium(final BufferedSource bufferedSource) {
        return (bufferedSource.readByte() & 0xFF) << 16 | (bufferedSource.readByte() & 0xFF) << 8 | (bufferedSource.readByte() & 0xFF);
    }
    
    private static void writeMedium(final BufferedSink bufferedSink, final int n) {
        bufferedSink.writeByte(n >>> 16 & 0xFF);
        bufferedSink.writeByte(n >>> 8 & 0xFF);
        bufferedSink.writeByte(n & 0xFF);
    }
    
    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }
    
    public FrameReader newReader(final BufferedSource bufferedSource, final boolean b) {
        return new Http2$Reader(bufferedSource, 4096, b);
    }
    
    public FrameWriter newWriter(final BufferedSink bufferedSink, final boolean b) {
        return new Http2$Writer(bufferedSink, b);
    }
}
