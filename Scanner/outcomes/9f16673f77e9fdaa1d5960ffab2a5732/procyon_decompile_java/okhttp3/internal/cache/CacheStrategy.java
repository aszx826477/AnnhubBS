// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.cache;

import okhttp3.Request;
import okhttp3.Response;

public final class CacheStrategy
{
    public final Response cacheResponse;
    public final Request networkRequest;
    
    private CacheStrategy(final Request networkRequest, final Response cacheResponse) {
        this.networkRequest = networkRequest;
        this.cacheResponse = cacheResponse;
    }
    
    public static boolean isCacheable(final Response response, final Request request) {
        final int code = response.code();
        boolean b = false;
        Label_0208: {
            switch (code) {
                case 302:
                case 307: {
                    if (response.header("Expires") != null) {
                        break Label_0208;
                    }
                    if (response.cacheControl().maxAgeSeconds() != -1) {
                        break Label_0208;
                    }
                    if (response.cacheControl().isPublic()) {
                        break Label_0208;
                    }
                    if (response.cacheControl().isPrivate()) {
                        break Label_0208;
                    }
                    break;
                }
                case 200:
                case 203:
                case 204:
                case 300:
                case 301:
                case 308:
                case 404:
                case 405:
                case 410:
                case 414:
                case 501: {
                    if (!response.cacheControl().noStore() && !request.cacheControl().noStore()) {
                        b = true;
                    }
                    return b;
                }
            }
        }
        return false;
    }
}
