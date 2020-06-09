// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.http;

import okio.BufferedSink;
import okhttp3.Request;
import okhttp3.internal.connection.StreamAllocation;
import java.net.ProtocolException;
import okio.Okio;
import okhttp3.Response;
import okhttp3.Interceptor$Chain;
import okhttp3.Interceptor;

public final class CallServerInterceptor implements Interceptor
{
    private final boolean forWebSocket;
    
    public CallServerInterceptor(final boolean forWebSocket) {
        this.forWebSocket = forWebSocket;
    }
    
    public Response intercept(final Interceptor$Chain interceptor$Chain) {
        final HttpStream httpStream = ((RealInterceptorChain)interceptor$Chain).httpStream();
        final StreamAllocation streamAllocation = ((RealInterceptorChain)interceptor$Chain).streamAllocation();
        final Request request = interceptor$Chain.request();
        final long currentTimeMillis = System.currentTimeMillis();
        httpStream.writeRequestHeaders(request);
        if (HttpMethod.permitsRequestBody(request.method()) && request.body() != null) {
            final BufferedSink buffer = Okio.buffer(httpStream.createRequestBody(request, request.body().contentLength()));
            request.body().writeTo(buffer);
            buffer.close();
        }
        httpStream.finishRequest();
        Response response = httpStream.readResponseHeaders().request(request).handshake(streamAllocation.connection().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        if (!this.forWebSocket || response.code() != 101) {
            response = response.newBuilder().body(httpStream.openResponseBody(response)).build();
        }
        if ("close".equalsIgnoreCase(response.request().header("Connection")) || "close".equalsIgnoreCase(response.header("Connection"))) {
            streamAllocation.noNewStreams();
        }
        final int code = response.code();
        if ((code != 204 && code != 205) || response.body().contentLength() <= 0L) {
            return response;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("HTTP ");
        sb.append(code);
        sb.append(" had non-zero Content-Length: ");
        sb.append(response.body().contentLength());
        throw new ProtocolException(sb.toString());
    }
}
