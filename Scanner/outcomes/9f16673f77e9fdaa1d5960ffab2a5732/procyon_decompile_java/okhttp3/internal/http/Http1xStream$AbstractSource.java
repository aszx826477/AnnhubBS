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
import okhttp3.internal.connection.StreamAllocation;
import okio.BufferedSource;
import okio.BufferedSink;
import okhttp3.OkHttpClient;
import okio.Timeout;
import okio.ForwardingTimeout;
import okio.Source;

abstract class Http1xStream$AbstractSource implements Source
{
    protected boolean closed;
    final /* synthetic */ Http1xStream this$0;
    protected final ForwardingTimeout timeout;
    
    private Http1xStream$AbstractSource(final Http1xStream this$0) {
        this.this$0 = this$0;
        this.timeout = new ForwardingTimeout(this.this$0.source.timeout());
    }
    
    protected final void endOfInput(final boolean b) {
        final int access$500 = this.this$0.state;
        final int n = 6;
        if (access$500 == n) {
            return;
        }
        if (this.this$0.state == 5) {
            this.this$0.detachTimeout(this.timeout);
            this.this$0.state = n;
            if (this.this$0.streamAllocation != null) {
                this.this$0.streamAllocation.streamFinished(b ^ true, this.this$0);
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.this$0.state);
        throw new IllegalStateException(sb.toString());
    }
    
    public Timeout timeout() {
        return this.timeout;
    }
}
