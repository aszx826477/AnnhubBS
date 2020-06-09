// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.net.ProtocolException;
import java.util.List;
import okio.ByteString;
import okhttp3.internal.Util;
import java.io.IOException;
import okio.BufferedSource;

final class Spdy3$Reader implements FrameReader
{
    private final boolean client;
    private final NameValueBlockReader headerBlockReader;
    private final BufferedSource source;
    
    Spdy3$Reader(final BufferedSource source, final boolean client) {
        this.source = source;
        this.headerBlockReader = new NameValueBlockReader(this.source);
        this.client = client;
    }
    
    private static IOException ioException(final String s, final Object... array) {
        throw new IOException(Util.format(s, array));
    }
    
    private void readGoAway(final FrameReader$Handler frameReader$Handler, final int n, final int n2) {
        final int n3 = 1;
        if (n2 != 8) {
            final Object[] array = new Object[n3];
            array[0] = n2;
            throw ioException("TYPE_GOAWAY length: %d != 8", array);
        }
        final int n4 = this.source.readInt() & -1 >>> 1;
        final int int1 = this.source.readInt();
        final ErrorCode fromSpdyGoAway = ErrorCode.fromSpdyGoAway(int1);
        if (fromSpdyGoAway != null) {
            frameReader$Handler.goAway(n4, fromSpdyGoAway, ByteString.EMPTY);
            return;
        }
        final Object[] array2 = new Object[n3];
        array2[0] = int1;
        throw ioException("TYPE_GOAWAY unexpected error code: %d", array2);
    }
    
    private void readHeaders(final FrameReader$Handler frameReader$Handler, final int n, final int n2) {
        frameReader$Handler.headers(false, false, -1 >>> 1 & this.source.readInt(), -1, this.headerBlockReader.readNameValueBlock(n2 - 4), HeadersMode.SPDY_HEADERS);
    }
    
    private void readPing(final FrameReader$Handler frameReader$Handler, final int n, final int n2) {
        int n3 = 1;
        if (n2 == 4) {
            final int int1 = this.source.readInt();
            if (this.client != ((int1 & 0x1) == n3)) {
                n3 = 0;
            }
            frameReader$Handler.ping(n3 != 0, int1, 0);
            return;
        }
        final Object[] array = new Object[n3];
        array[0] = n2;
        throw ioException("TYPE_PING length: %d != 4", array);
    }
    
    private void readRstStream(final FrameReader$Handler frameReader$Handler, final int n, final int n2) {
        final int n3 = 1;
        if (n2 != 8) {
            final Object[] array = new Object[n3];
            array[0] = n2;
            throw ioException("TYPE_RST_STREAM length: %d != 8", array);
        }
        final int n4 = this.source.readInt() & -1 >>> 1;
        final int int1 = this.source.readInt();
        final ErrorCode fromSpdy3Rst = ErrorCode.fromSpdy3Rst(int1);
        if (fromSpdy3Rst != null) {
            frameReader$Handler.rstStream(n4, fromSpdy3Rst);
            return;
        }
        final Object[] array2 = new Object[n3];
        array2[0] = int1;
        throw ioException("TYPE_RST_STREAM unexpected error code: %d", array2);
    }
    
    private void readSettings(final FrameReader$Handler frameReader$Handler, final int n, final int n2) {
        final int int1 = this.source.readInt();
        final int n3 = int1 * 8 + 4;
        boolean b = false;
        final int n4 = 1;
        if (n2 == n3) {
            final Settings settings = new Settings();
            for (int i = 0; i < int1; ++i) {
                final int int2 = this.source.readInt();
                settings.set(0xFFFFFF & int2, (0xFF000000 & int2) >>> 24, this.source.readInt());
            }
            if ((n & 0x1) != 0x0) {
                b = true;
            }
            frameReader$Handler.settings(b, settings);
            return;
        }
        final Object[] array = { n2, null };
        array[n4] = int1;
        throw ioException("TYPE_SETTINGS length: %d != 4 + 8 * %d", array);
    }
    
    private void readSynReply(final FrameReader$Handler frameReader$Handler, final int n, final int n2) {
        frameReader$Handler.headers(false, (n & 0x1) != 0x0, -1 >>> 1 & this.source.readInt(), -1, this.headerBlockReader.readNameValueBlock(n2 - 4), HeadersMode.SPDY_REPLY);
    }
    
    private void readSynStream(final FrameReader$Handler frameReader$Handler, final int n, final int n2) {
        final int int1 = this.source.readInt();
        final int int2 = this.source.readInt();
        final int n3 = -1 >>> 1;
        final int n4 = int1 & n3;
        final int n5 = n3 & int2;
        this.source.readShort();
        final List nameValueBlock = this.headerBlockReader.readNameValueBlock(n2 - 10);
        final int n6 = n & 0x1;
        boolean b = false;
        final boolean b2 = n6 != 0;
        if ((n & 0x2) != 0x0) {
            b = true;
        }
        frameReader$Handler.headers(b, b2, n4, n5, nameValueBlock, HeadersMode.SPDY_SYN_STREAM);
    }
    
    private void readWindowUpdate(final FrameReader$Handler frameReader$Handler, final int n, final int n2) {
        final int n3 = 1;
        if (n2 != 8) {
            final Object[] array = new Object[n3];
            array[0] = n2;
            throw ioException("TYPE_WINDOW_UPDATE length: %d != 8", array);
        }
        final int int1 = this.source.readInt();
        final int int2 = this.source.readInt();
        final int n4 = -1 >>> 1;
        final int n5 = int1 & n4;
        final long n6 = n4 & int2;
        if (n6 != 0L) {
            frameReader$Handler.windowUpdate(n5, n6);
            return;
        }
        final Object[] array2 = new Object[n3];
        array2[0] = n6;
        throw ioException("windowSizeIncrement was 0", array2);
    }
    
    public void close() {
        this.headerBlockReader.close();
    }
    
    public boolean nextFrame(final FrameReader$Handler frameReader$Handler) {
        boolean b = false;
        try {
            final BufferedSource source = this.source;
            try {
                final int int1 = source.readInt();
                try {
                    final BufferedSource source2 = this.source;
                    try {
                        final int int2 = source2.readInt();
                        final int n = -1 << -1 & int1;
                        final boolean b2 = true;
                        final boolean b3 = n != 0;
                        final int n2 = (0xFF000000 & int2) >>> 24;
                        final int n3 = 0xFFFFFF & int2;
                        if (!b3) {
                            final int n4 = -1 >>> 1 & int1;
                            if ((n2 & 0x1) != 0x0) {
                                b = true;
                            }
                            frameReader$Handler.data(b, n4, this.source, n3);
                            return b2;
                        }
                        final int n5 = (0x7FFF0000 & int1) >>> 16;
                        final char c = (char)((char)(-1) & int1);
                        if (n5 != 3) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("version != 3: ");
                            sb.append(n5);
                            throw new ProtocolException(sb.toString());
                        }
                        switch (c) {
                            default: {
                                this.source.skip(n3);
                                return b2;
                            }
                            case 9: {
                                this.readWindowUpdate(frameReader$Handler, n2, n3);
                                return b2;
                            }
                            case 8: {
                                this.readHeaders(frameReader$Handler, n2, n3);
                                return b2;
                            }
                            case 7: {
                                this.readGoAway(frameReader$Handler, n2, n3);
                                return b2;
                            }
                            case 6: {
                                this.readPing(frameReader$Handler, n2, n3);
                                return b2;
                            }
                            case 4: {
                                this.readSettings(frameReader$Handler, n2, n3);
                                return b2;
                            }
                            case 3: {
                                this.readRstStream(frameReader$Handler, n2, n3);
                                return b2;
                            }
                            case 2: {
                                this.readSynReply(frameReader$Handler, n2, n3);
                                return b2;
                            }
                            case 1: {
                                this.readSynStream(frameReader$Handler, n2, n3);
                                return b2;
                            }
                        }
                    }
                    catch (IOException ex) {
                        return false;
                    }
                }
                catch (IOException ex2) {}
            }
            catch (IOException ex3) {}
        }
        catch (IOException ex4) {}
    }
    
    public void readConnectionPreface() {
    }
}
