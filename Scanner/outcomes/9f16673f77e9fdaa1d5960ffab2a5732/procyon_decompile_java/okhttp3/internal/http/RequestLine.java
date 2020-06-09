// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.http;

import okhttp3.HttpUrl;
import java.net.Proxy;
import okhttp3.Request;

public final class RequestLine
{
    static String get(final Request request, final Proxy.Type type) {
        final StringBuilder sb = new StringBuilder();
        sb.append(request.method());
        sb.append(' ');
        if (includeAuthorityInRequestLine(request, type)) {
            sb.append(request.url());
        }
        else {
            sb.append(requestPath(request.url()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }
    
    private static boolean includeAuthorityInRequestLine(final Request request, final Proxy.Type type) {
        return !request.isHttps() && type == Proxy.Type.HTTP;
    }
    
    public static String requestPath(final HttpUrl httpUrl) {
        final String encodedPath = httpUrl.encodedPath();
        final String encodedQuery = httpUrl.encodedQuery();
        String string;
        if (encodedQuery != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(encodedPath);
            sb.append('?');
            sb.append(encodedQuery);
            string = sb.toString();
        }
        else {
            string = encodedPath;
        }
        return string;
    }
}
