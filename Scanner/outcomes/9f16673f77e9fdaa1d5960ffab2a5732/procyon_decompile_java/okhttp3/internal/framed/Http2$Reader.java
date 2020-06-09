// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import okhttp3.Protocol;
import okio.BufferedSink;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import java.io.IOException;
import java.util.logging.Level;
import java.util.List;
import okio.ByteString;
import okio.Source;
import okio.BufferedSource;

final class Http2$Reader implements FrameReader
{
    private final boolean client;
    private final Http2$ContinuationSource continuation;
    final Hpack$Reader hpackReader;
    private final BufferedSource source;
    
    Http2$Reader(final BufferedSource source, final int n, final boolean client) {
        this.source = source;
        this.client = client;
        this.continuation = new Http2$ContinuationSource(this.source);
        this.hpackReader = new Hpack$Reader(n, this.continuation);
    }
    
    private void readData(final FrameReader$Handler frameReader$Handler, int access$400, final byte b, final int n) {
        final byte b2 = (byte)(b & 0x1);
        boolean b3 = true;
        short n2 = 0;
        final boolean b4 = b2 != 0;
        if ((b & 0x20) == 0x0) {
            b3 = false;
        }
        if (!b3) {
            if ((b & 0x8) != 0x0) {
                n2 = (short)(this.source.readByte() & 0xFF);
            }
            access$400 = lengthWithoutPadding(access$400, b, n2);
            frameReader$Handler.data(b4, n, this.source, access$400);
            this.source.skip(n2);
            return;
        }
        throw ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
    }
    
    private void readGoAway(final FrameReader$Handler frameReader$Handler, final int n, final byte b, final int n2) {
        final int n3 = 1;
        if (n < 8) {
            final Object[] array = new Object[n3];
            array[0] = n;
            throw ioException("TYPE_GOAWAY length < 8: %s", array);
        }
        if (n2 != 0) {
            throw ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        final int int1 = this.source.readInt();
        final int int2 = this.source.readInt();
        final int n4 = n - 8;
        final ErrorCode fromHttp2 = ErrorCode.fromHttp2(int2);
        if (fromHttp2 != null) {
            ByteString byteString = ByteString.EMPTY;
            if (n4 > 0) {
                byteString = this.source.readByteString(n4);
            }
            frameReader$Handler.goAway(int1, fromHttp2, byteString);
            return;
        }
        final Object[] array2 = new Object[n3];
        array2[0] = int2;
        throw ioException("TYPE_GOAWAY unexpected error code: %d", array2);
    }
    
    private List readHeaderBlock(final int n, final short padding, final byte flags, final int streamId) {
        final Http2$ContinuationSource continuation = this.continuation;
        continuation.left = n;
        continuation.length = n;
        continuation.padding = padding;
        continuation.flags = flags;
        continuation.streamId = streamId;
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }
    
    private void readHeaders(final FrameReader$Handler frameReader$Handler, int access$400, final byte b, final int n) {
        short n2 = 0;
        if (n != 0) {
            final boolean b2 = (b & 0x1) != 0x0;
            if ((b & 0x8) != 0x0) {
                n2 = (short)(this.source.readByte() & 0xFF);
            }
            if ((b & 0x20) != 0x0) {
                this.readPriority(frameReader$Handler, n);
                access$400 -= 5;
            }
            access$400 = lengthWithoutPadding(access$400, b, n2);
            frameReader$Handler.headers(false, b2, n, -1, this.readHeaderBlock(access$400, n2, b, n), HeadersMode.HTTP_20_HEADERS);
            return;
        }
        throw ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }
    
    private void readPing(final FrameReader$Handler frameReader$Handler, final int n, final byte b, final int n2) {
        boolean b2 = false;
        final int n3 = 1;
        if (n != 8) {
            final Object[] array = new Object[n3];
            array[0] = n;
            throw ioException("TYPE_PING length != 8: %s", array);
        }
        if (n2 == 0) {
            final int int1 = this.source.readInt();
            final int int2 = this.source.readInt();
            if ((b & 0x1) != 0x0) {
                b2 = true;
            }
            frameReader$Handler.ping(b2, int1, int2);
            return;
        }
        throw ioException("TYPE_PING streamId != 0", new Object[0]);
    }
    
    private void readPriority(final FrameReader$Handler frameReader$Handler, final int n) {
        final int int1 = this.source.readInt();
        frameReader$Handler.priority(n, -1 >>> 1 & int1, (this.source.readByte() & 0xFF) + 1, (-1 << -1 & int1) != 0x0);
    }
    
    private void readPriority(final FrameReader$Handler frameReader$Handler, final int n, final byte b, final int n2) {
        if (n != 5) {
            throw ioException("TYPE_PRIORITY length: %d != 5", new Object[] { n });
        }
        if (n2 != 0) {
            this.readPriority(frameReader$Handler, n2);
            return;
        }
        throw ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
    }
    
    private void readPushPromise(final FrameReader$Handler frameReader$Handler, int access$400, final byte b, final int n) {
        short n2 = 0;
        if (n != 0) {
            if ((b & 0x8) != 0x0) {
                n2 = (short)(this.source.readByte() & 0xFF);
            }
            final int n3 = this.source.readInt() & -1 >>> 1;
            access$400 = lengthWithoutPadding(access$400 - 4, b, n2);
            frameReader$Handler.pushPromise(n, n3, this.readHeaderBlock(access$400, n2, b, n));
            return;
        }
        throw ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }
    
    private void readRstStream(final FrameReader$Handler frameReader$Handler, final int n, final byte b, final int n2) {
        final int n3 = 1;
        if (n != 4) {
            final Object[] array = new Object[n3];
            array[0] = n;
            throw ioException("TYPE_RST_STREAM length: %d != 4", array);
        }
        if (n2 == 0) {
            throw ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        final int int1 = this.source.readInt();
        final ErrorCode fromHttp2 = ErrorCode.fromHttp2(int1);
        if (fromHttp2 != null) {
            frameReader$Handler.rstStream(n2, fromHttp2);
            return;
        }
        final Object[] array2 = new Object[n3];
        array2[0] = int1;
        throw ioException("TYPE_RST_STREAM unexpected error code: %d", array2);
    }
    
    private void readSettings(final FrameReader$Handler frameReader$Handler, final int n, final byte b, final int n2) {
        if (n2 != 0) {
            throw ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 0x1) != 0x0) {
            if (n == 0) {
                frameReader$Handler.ackSettings();
                return;
            }
            throw ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        }
        else {
            final int n3 = n % 6;
            final int n4 = 1;
            if (n3 == 0) {
                final Settings settings = new Settings();
                int i = 0;
            Label_0272_Outer:
                while (i < n) {
                    int short1 = this.source.readShort();
                    final int int1 = this.source.readInt();
                    while (true) {
                        switch (short1) {
                            default: {
                                break Label_0272;
                            }
                            case 5: {
                                if (int1 >= 16384 && int1 <= 16777215) {
                                    break Label_0272;
                                }
                                final Object[] array = new Object[n4];
                                array[0] = int1;
                                throw ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", array);
                            }
                            case 4: {
                                short1 = 7;
                                if (int1 >= 0) {
                                    break Label_0272;
                                }
                                throw ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            }
                            case 2: {
                                if (int1 != 0 && int1 != n4) {
                                    throw ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                                }
                                break Label_0272;
                            }
                            case 1: {
                                settings.set(short1, 0, int1);
                                i += 6;
                                continue Label_0272_Outer;
                            }
                            case 6: {
                                continue;
                            }
                            case 3: {
                                short1 = 4;
                                continue;
                            }
                        }
                        break;
                    }
                }
                frameReader$Handler.settings(false, settings);
                return;
            }
            final Object[] array2 = new Object[n4];
            array2[0] = n;
            throw ioException("TYPE_SETTINGS length %% 6 != 0: %s", array2);
        }
    }
    
    private void readWindowUpdate(final FrameReader$Handler frameReader$Handler, final int n, final byte b, final int n2) {
        final int n3 = 1;
        if (n != 4) {
            final Object[] array = new Object[n3];
            array[0] = n;
            throw ioException("TYPE_WINDOW_UPDATE length !=4: %s", array);
        }
        final long n4 = this.source.readInt() & 0x7FFFFFFFL;
        if (n4 != 0L) {
            frameReader$Handler.windowUpdate(n2, n4);
            return;
        }
        final Object[] array2 = new Object[n3];
        array2[0] = n4;
        throw ioException("windowSizeIncrement was 0", array2);
    }
    
    public void close() {
        this.source.close();
    }
    
    public boolean nextFrame(final FrameReader$Handler frameReader$Handler) {
        try {
            this.source.require(9);
            final int access$300 = readMedium(this.source);
            final int n = 1;
            if (access$300 >= 0 && access$300 <= 16384) {
                final byte b = (byte)(this.source.readByte() & 0xFF);
                final byte b2 = (byte)(this.source.readByte() & 0xFF);
                final int n2 = this.source.readInt() & -1 >>> 1;
                if (Http2.logger.isLoggable(Level.FINE)) {
                    Http2.logger.fine(Http2$FrameLogger.formatHeader((boolean)(n != 0), n2, access$300, b, b2));
                }
                switch (b) {
                    default: {
                        this.source.skip(access$300);
                        break;
                    }
                    case 8: {
                        this.readWindowUpdate(frameReader$Handler, access$300, b2, n2);
                        break;
                    }
                    case 7: {
                        this.readGoAway(frameReader$Handler, access$300, b2, n2);
                        break;
                    }
                    case 6: {
                        this.readPing(frameReader$Handler, access$300, b2, n2);
                        break;
                    }
                    case 5: {
                        this.readPushPromise(frameReader$Handler, access$300, b2, n2);
                        break;
                    }
                    case 4: {
                        this.readSettings(frameReader$Handler, access$300, b2, n2);
                        break;
                    }
                    case 3: {
                        this.readRstStream(frameReader$Handler, access$300, b2, n2);
                        break;
                    }
                    case 2: {
                        this.readPriority(frameReader$Handler, access$300, b2, n2);
                        break;
                    }
                    case 1: {
                        this.readHeaders(frameReader$Handler, access$300, b2, n2);
                        break;
                    }
                    case 0: {
                        this.readData(frameReader$Handler, access$300, b2, n2);
                        break;
                    }
                }
                return n != 0;
            }
            final Object[] array = new Object[n];
            array[0] = access$300;
            throw ioException("FRAME_SIZE_ERROR: %s", array);
        }
        catch (IOException ex) {
            return false;
        }
    }
    
    public void readConnectionPreface() {
        if (this.client) {
            return;
        }
        final ByteString byteString = this.source.readByteString(Http2.CONNECTION_PREFACE.size());
        final boolean loggable = Http2.logger.isLoggable(Level.FINE);
        final int n = 1;
        if (loggable) {
            final Logger access$100 = Http2.logger;
            final Object[] array = new Object[n];
            array[0] = byteString.hex();
            access$100.fine(Util.format("<< CONNECTION %s", array));
        }
        if (Http2.CONNECTION_PREFACE.equals(byteString)) {
            return;
        }
        final Object[] array2 = new Object[n];
        array2[0] = byteString.utf8();
        throw ioException("Expected a connection header but was %s", array2);
    }
}
