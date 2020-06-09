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
import okio.Buffer;
import okio.Timeout;
import okio.ForwardingTimeout;
import okio.Sink;

final class Http1xStream$ChunkedSink implements Sink
{
    private boolean closed;
    final /* synthetic */ Http1xStream this$0;
    private final ForwardingTimeout timeout;
    
    private Http1xStream$ChunkedSink(final Http1xStream this$0) {
        this.this$0 = this$0;
        this.timeout = new ForwardingTimeout(this.this$0.sink.timeout());
    }
    
    public void close() {
        synchronized (this) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.this$0.sink.writeUtf8("0\r\n\r\n");
            this.this$0.detachTimeout(this.timeout);
            this.this$0.state = 3;
        }
    }
    
    public void flush() {
        synchronized (this) {
            if (this.closed) {
                return;
            }
            this.this$0.sink.flush();
        }
    }
    
    public Timeout timeout() {
        return this.timeout;
    }
    
    public void write(final Buffer buffer, final long n) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (n == 0L) {
            return;
        }
        this.this$0.sink.writeHexadecimalUnsignedLong(n);
        this.this$0.sink.writeUtf8("\r\n");
        this.this$0.sink.write(buffer, n);
        this.this$0.sink.writeUtf8("\r\n");
    }
}
