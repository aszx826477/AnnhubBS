// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.IOException;
import java.io.InputStream;

final class Okio$2 implements Source
{
    final /* synthetic */ InputStream val$in;
    final /* synthetic */ Timeout val$timeout;
    
    Okio$2(final Timeout val$timeout, final InputStream val$in) {
        this.val$timeout = val$timeout;
        this.val$in = val$in;
    }
    
    public void close() {
        this.val$in.close();
    }
    
    public long read(final Buffer buffer, final long n) {
        final long n2 = 0L;
        if (n >= n2) {
            if (n == n2) {
                return n2;
            }
            try {
                final Timeout val$timeout = this.val$timeout;
                try {
                    val$timeout.throwIfReached();
                    final Segment writableSegment = buffer.writableSegment(1);
                    try {
                        final int n3 = (int)Math.min(n, 8192 - writableSegment.limit);
                        final InputStream val$in = this.val$in;
                        try {
                            final byte[] data = writableSegment.data;
                            try {
                                final int read = val$in.read(data, writableSegment.limit, n3);
                                if (read == -1) {
                                    return -1;
                                }
                                writableSegment.limit += read;
                                buffer.size += read;
                                return read;
                            }
                            catch (AssertionError assertionError) {
                                if (Okio.isAndroidGetsocknameError(assertionError)) {
                                    throw new IOException(assertionError);
                                }
                                throw assertionError;
                            }
                        }
                        catch (AssertionError assertionError2) {}
                    }
                    catch (AssertionError assertionError3) {}
                }
                catch (AssertionError assertionError4) {}
            }
            catch (AssertionError assertionError5) {}
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("byteCount < 0: ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public Timeout timeout() {
        return this.val$timeout;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("source(");
        sb.append(this.val$in);
        sb.append(")");
        return sb.toString();
    }
}
