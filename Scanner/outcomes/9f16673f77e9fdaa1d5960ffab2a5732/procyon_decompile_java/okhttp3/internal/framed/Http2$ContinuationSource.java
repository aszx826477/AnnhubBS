// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import okhttp3.Protocol;
import okhttp3.internal.Util;
import okio.BufferedSink;
import java.io.IOException;
import java.util.logging.Logger;
import okio.ByteString;
import okio.Timeout;
import okio.Buffer;
import java.util.logging.Level;
import okio.BufferedSource;
import okio.Source;

final class Http2$ContinuationSource implements Source
{
    byte flags;
    int left;
    int length;
    short padding;
    private final BufferedSource source;
    int streamId;
    
    public Http2$ContinuationSource(final BufferedSource source) {
        this.source = source;
    }
    
    private void readContinuationHeader() {
        final int streamId = this.streamId;
        final int access$300 = readMedium(this.source);
        this.left = access$300;
        this.length = access$300;
        final byte b = (byte)(this.source.readByte() & 0xFF);
        this.flags = (byte)(this.source.readByte() & 0xFF);
        final boolean loggable = Http2.logger.isLoggable(Level.FINE);
        final int n = 1;
        if (loggable) {
            Http2.logger.fine(Http2$FrameLogger.formatHeader((boolean)(n != 0), this.streamId, this.length, b, this.flags));
        }
        this.streamId = (this.source.readInt() & -1 >>> 1);
        if (b != 9) {
            final Object[] array = new Object[n];
            array[0] = b;
            throw ioException("%s != TYPE_CONTINUATION", array);
        }
        if (this.streamId == streamId) {
            return;
        }
        throw ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
    }
    
    public void close() {
    }
    
    public long read(final Buffer buffer, final long n) {
        while (true) {
            final int left = this.left;
            final long n2 = -1;
            if (left == 0) {
                this.source.skip(this.padding);
                this.padding = 0;
                if ((this.flags & 0x4) != 0x0) {
                    return n2;
                }
                this.readContinuationHeader();
            }
            else {
                final long read = this.source.read(buffer, Math.min(n, left));
                if (read == n2) {
                    return n2;
                }
                this.left -= (int)read;
                return read;
            }
        }
    }
    
    public Timeout timeout() {
        return this.source.timeout();
    }
}
