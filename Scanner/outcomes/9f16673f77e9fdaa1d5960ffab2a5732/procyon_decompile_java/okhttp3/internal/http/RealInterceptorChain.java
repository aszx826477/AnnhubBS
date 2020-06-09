// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.http;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.HttpUrl;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.Request;
import java.util.List;
import okhttp3.Connection;
import okhttp3.Interceptor$Chain;

public final class RealInterceptorChain implements Interceptor$Chain
{
    private int calls;
    private final Connection connection;
    private final HttpStream httpStream;
    private final int index;
    private final List interceptors;
    private final Request request;
    private final StreamAllocation streamAllocation;
    
    public RealInterceptorChain(final List interceptors, final StreamAllocation streamAllocation, final HttpStream httpStream, final Connection connection, final int index, final Request request) {
        this.interceptors = interceptors;
        this.connection = connection;
        this.streamAllocation = streamAllocation;
        this.httpStream = httpStream;
        this.index = index;
        this.request = request;
    }
    
    private boolean sameConnection(final HttpUrl httpUrl) {
        return httpUrl.host().equals(this.connection.route().address().url().host()) && httpUrl.port() == this.connection.route().address().url().port();
    }
    
    public Connection connection() {
        return this.connection;
    }
    
    public HttpStream httpStream() {
        return this.httpStream;
    }
    
    public Response proceed(final Request request) {
        return this.proceed(request, this.streamAllocation, this.httpStream, this.connection);
    }
    
    public Response proceed(final Request request, final StreamAllocation streamAllocation, final HttpStream httpStream, final Connection connection) {
        if (this.index >= this.interceptors.size()) {
            throw new AssertionError();
        }
        final int calls = this.calls;
        final int n = 1;
        this.calls = calls + n;
        if (this.httpStream != null && !this.sameConnection(request.url())) {
            final StringBuilder sb = new StringBuilder();
            sb.append("network interceptor ");
            sb.append(this.interceptors.get(this.index - n));
            sb.append(" must retain the same host and port");
            throw new IllegalStateException(sb.toString());
        }
        if (this.httpStream != null && this.calls > n) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("network interceptor ");
            sb2.append(this.interceptors.get(this.index - n));
            sb2.append(" must call proceed() exactly once");
            throw new IllegalStateException(sb2.toString());
        }
        final RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, streamAllocation, httpStream, connection, this.index + 1, request);
        final Interceptor interceptor = this.interceptors.get(this.index);
        final Response intercept = interceptor.intercept(realInterceptorChain);
        if (httpStream != null && this.index + n < this.interceptors.size() && realInterceptorChain.calls != n) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("network interceptor ");
            sb3.append(interceptor);
            sb3.append(" must call proceed() exactly once");
            throw new IllegalStateException(sb3.toString());
        }
        if (intercept != null) {
            return intercept;
        }
        final StringBuilder sb4 = new StringBuilder();
        sb4.append("interceptor ");
        sb4.append(interceptor);
        sb4.append(" returned null");
        throw new NullPointerException(sb4.toString());
    }
    
    public Request request() {
        return this.request;
    }
    
    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }
}
