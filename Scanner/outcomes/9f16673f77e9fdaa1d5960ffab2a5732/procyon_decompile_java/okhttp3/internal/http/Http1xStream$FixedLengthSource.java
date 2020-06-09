// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.http;

import java.io.EOFException;
import java.io.IOException;
import okhttp3.Response$Builder;
import okhttp3.internal.Internal;
import okhttp3.Headers$Builder;
import okhttp3.Headers;
import okio.Okio;
import okhttp3.ResponseBody;
import okhttp3.HttpUrl;
import okio.Sink;
import okhttp3.Request;
import okhttp3.internal.connection.RealConnection;
import okhttp3.Response;
import okio.Timeout;
import okio.ForwardingTimeout;
import okhttp3.internal.connection.StreamAllocation;
import okio.BufferedSource;
import okio.BufferedSink;
import okhttp3.OkHttpClient;
import java.net.ProtocolException;
import okio.Buffer;
import okio.Source;
import okhttp3.internal.Util;
import java.util.concurrent.TimeUnit;

class Http1xStream$FixedLengthSource extends Http1xStream$AbstractSource
{
    private long bytesRemaining;
    final /* synthetic */ Http1xStream this$0;
    
    public Http1xStream$FixedLengthSource(final Http1xStream this$0, final long bytesRemaining) {
        this.this$0 = this$0;
        super(this$0, null);
        this.bytesRemaining = bytesRemaining;
        if (this.bytesRemaining == 0L) {
            this.endOfInput(true);
        }
    }
    
    public void close() {
        if (this.closed) {
            return;
        }
        if (this.bytesRemaining != 0L && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
            this.endOfInput(false);
        }
        this.closed = true;
    }
    
    public long read(final Buffer buffer, final long n) {
        final long n2 = 0L;
        if (n < n2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        final long bytesRemaining = this.bytesRemaining;
        final long n3 = -1;
        if (bytesRemaining == n2) {
            return n3;
        }
        final long read = this.this$0.source.read(buffer, Math.min(this.bytesRemaining, n));
        if (read != n3) {
            this.bytesRemaining -= read;
            if (this.bytesRemaining == n2) {
                this.endOfInput(true);
            }
            return read;
        }
        this.endOfInput(false);
        throw new ProtocolException("unexpected end of stream");
    }
}
