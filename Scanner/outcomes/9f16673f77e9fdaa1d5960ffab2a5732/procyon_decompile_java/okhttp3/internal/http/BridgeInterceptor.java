// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.http;

import okhttp3.Headers;
import okhttp3.Response$Builder;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Request$Builder;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Okio;
import okio.Source;
import okio.GzipSource;
import okhttp3.internal.Version;
import okhttp3.internal.Util;
import okhttp3.Response;
import okhttp3.Interceptor$Chain;
import okhttp3.Cookie;
import java.util.List;
import okhttp3.CookieJar;
import okhttp3.Interceptor;

public final class BridgeInterceptor implements Interceptor
{
    private final CookieJar cookieJar;
    
    public BridgeInterceptor(final CookieJar cookieJar) {
        this.cookieJar = cookieJar;
    }
    
    private String cookieHeader(final List list) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); ++i) {
            if (i > 0) {
                sb.append("; ");
            }
            final Cookie cookie = list.get(i);
            sb.append(cookie.name());
            sb.append('=');
            sb.append(cookie.value());
        }
        return sb.toString();
    }
    
    public Response intercept(final Interceptor$Chain interceptor$Chain) {
        final Request request = interceptor$Chain.request();
        final Request$Builder builder = request.newBuilder();
        final RequestBody body = request.body();
        if (body != null) {
            final MediaType contentType = body.contentType();
            if (contentType != null) {
                builder.header("Content-Type", contentType.toString());
            }
            final long contentLength = body.contentLength();
            if (contentLength != -1) {
                builder.header("Content-Length", Long.toString(contentLength));
                builder.removeHeader("Transfer-Encoding");
            }
            else {
                builder.header("Transfer-Encoding", "chunked");
                builder.removeHeader("Content-Length");
            }
        }
        if (request.header("Host") == null) {
            builder.header("Host", Util.hostHeader(request.url(), false));
        }
        if (request.header("Connection") == null) {
            builder.header("Connection", "Keep-Alive");
        }
        boolean b = false;
        if (request.header("Accept-Encoding") == null) {
            b = true;
            builder.header("Accept-Encoding", "gzip");
        }
        final List loadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            builder.header("Cookie", this.cookieHeader(loadForRequest));
        }
        if (request.header("User-Agent") == null) {
            builder.header("User-Agent", Version.userAgent());
        }
        final Response proceed = interceptor$Chain.proceed(builder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), proceed.headers());
        final Response$Builder request2 = proceed.newBuilder().request(request);
        if (b) {
            if ("gzip".equalsIgnoreCase(proceed.header("Content-Encoding"))) {
                if (HttpHeaders.hasBody(proceed)) {
                    final GzipSource gzipSource = new GzipSource(proceed.body().source());
                    final Headers build = proceed.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
                    request2.headers(build);
                    request2.body(new RealResponseBody(build, Okio.buffer(gzipSource)));
                }
            }
        }
        return request2.build();
    }
}
