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
import okio.Source;
import okhttp3.Response;
import okio.Timeout;
import okio.ForwardingTimeout;
import okhttp3.internal.connection.StreamAllocation;
import okio.BufferedSource;
import okio.BufferedSink;
import okhttp3.OkHttpClient;
import okio.Buffer;

class Http1xStream$UnknownLengthSource extends Http1xStream$AbstractSource
{
    private boolean inputExhausted;
    final /* synthetic */ Http1xStream this$0;
    
    private Http1xStream$UnknownLengthSource(final Http1xStream this$0) {
        this.this$0 = this$0;
        super(this$0, null);
    }
    
    public void close() {
        if (this.closed) {
            return;
        }
        if (!this.inputExhausted) {
            this.endOfInput(false);
        }
        this.closed = true;
    }
    
    public long read(final Buffer buffer, final long n) {
        if (n < 0L) {
            final StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        final boolean inputExhausted = this.inputExhausted;
        final long n2 = -1;
        if (inputExhausted) {
            return n2;
        }
        final long read = this.this$0.source.read(buffer, n);
        if (read == n2) {
            this.endOfInput(this.inputExhausted = true);
            return n2;
        }
        return read;
    }
}
