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
import okhttp3.Request;
import okhttp3.internal.connection.RealConnection;
import okio.Source;
import okhttp3.Response;
import okhttp3.internal.connection.StreamAllocation;
import okio.BufferedSource;
import okio.BufferedSink;
import okhttp3.OkHttpClient;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.Timeout;
import java.net.ProtocolException;
import okio.ForwardingTimeout;
import okio.Sink;

final class Http1xStream$FixedLengthSink implements Sink
{
    private long bytesRemaining;
    private boolean closed;
    final /* synthetic */ Http1xStream this$0;
    private final ForwardingTimeout timeout;
    
    private Http1xStream$FixedLengthSink(final Http1xStream this$0, final long bytesRemaining) {
        this.this$0 = this$0;
        this.timeout = new ForwardingTimeout(this.this$0.sink.timeout());
        this.bytesRemaining = bytesRemaining;
    }
    
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        if (this.bytesRemaining <= 0L) {
            this.this$0.detachTimeout(this.timeout);
            this.this$0.state = 3;
            return;
        }
        throw new ProtocolException("unexpected end of stream");
    }
    
    public void flush() {
        if (this.closed) {
            return;
        }
        this.this$0.sink.flush();
    }
    
    public Timeout timeout() {
        return this.timeout;
    }
    
    public void write(final Buffer buffer, final long n) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        Util.checkOffsetAndCount(buffer.size(), 0L, n);
        if (n <= this.bytesRemaining) {
            this.this$0.sink.write(buffer, n);
            this.bytesRemaining -= n;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("expected ");
        sb.append(this.bytesRemaining);
        sb.append(" bytes but received ");
        sb.append(n);
        throw new ProtocolException(sb.toString());
    }
}
