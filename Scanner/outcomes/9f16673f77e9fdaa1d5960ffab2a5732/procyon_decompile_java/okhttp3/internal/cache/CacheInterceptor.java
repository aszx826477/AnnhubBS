// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.cache;

import okhttp3.internal.http.HttpHeaders;
import okhttp3.Protocol;
import okhttp3.Response$Builder;
import java.io.Closeable;
import okhttp3.internal.Util;
import okhttp3.Interceptor$Chain;
import java.util.Date;
import java.io.IOException;
import okhttp3.internal.http.HttpMethod;
import okhttp3.Request;
import okhttp3.internal.Internal;
import okhttp3.Headers$Builder;
import okhttp3.Headers;
import okio.Sink;
import okhttp3.internal.http.RealResponseBody;
import okio.Source;
import okio.Okio;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Interceptor;

public final class CacheInterceptor implements Interceptor
{
    private static final ResponseBody EMPTY_BODY;
    final InternalCache cache;
    
    static {
        EMPTY_BODY = new CacheInterceptor$1();
    }
    
    public CacheInterceptor(final InternalCache cache) {
        this.cache = cache;
    }
    
    private Response cacheWritingResponse(final CacheRequest cacheRequest, final Response response) {
        if (cacheRequest == null) {
            return response;
        }
        final Sink body = cacheRequest.body();
        if (body == null) {
            return response;
        }
        return response.newBuilder().body(new RealResponseBody(response.headers(), Okio.buffer(new CacheInterceptor$2(this, response.body().source(), cacheRequest, Okio.buffer(body))))).build();
    }
    
    private static Headers combine(final Headers headers, final Headers headers2) {
        final Headers$Builder headers$Builder = new Headers$Builder();
        for (int i = 0; i < headers.size(); ++i) {
            final String name = headers.name(i);
            final String value = headers.value(i);
            if (!"Warning".equalsIgnoreCase(name) || !value.startsWith("1")) {
                if (!isEndToEnd(name) || headers2.get(name) == null) {
                    Internal.instance.addLenient(headers$Builder, name, value);
                }
            }
        }
        for (int j = 0; j < headers2.size(); ++j) {
            final String name2 = headers2.name(j);
            if (!"Content-Length".equalsIgnoreCase(name2)) {
                if (isEndToEnd(name2)) {
                    Internal.instance.addLenient(headers$Builder, name2, headers2.value(j));
                }
            }
        }
        return headers$Builder.build();
    }
    
    static boolean isEndToEnd(final String s) {
        if (!"Connection".equalsIgnoreCase(s)) {
            if (!"Keep-Alive".equalsIgnoreCase(s)) {
                if (!"Proxy-Authenticate".equalsIgnoreCase(s)) {
                    if (!"Proxy-Authorization".equalsIgnoreCase(s)) {
                        if (!"TE".equalsIgnoreCase(s)) {
                            if (!"Trailers".equalsIgnoreCase(s)) {
                                if (!"Transfer-Encoding".equalsIgnoreCase(s)) {
                                    if (!"Upgrade".equalsIgnoreCase(s)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private CacheRequest maybeCache(final Response response, final Request request, final InternalCache internalCache) {
        if (internalCache == null) {
            return null;
        }
        if (!CacheStrategy.isCacheable(response, request)) {
            if (HttpMethod.invalidatesCache(request.method())) {
                try {
                    internalCache.remove(request);
                }
                catch (IOException ex) {}
            }
            return null;
        }
        return internalCache.put(response);
    }
    
    private static Response stripBody(final Response response) {
        Response build;
        if (response != null && response.body() != null) {
            build = response.newBuilder().body(null).build();
        }
        else {
            build = response;
        }
        return build;
    }
    
    private static boolean validate(final Response response, final Response response2) {
        final int code = response2.code();
        final boolean b = true;
        if (code == 304) {
            return b;
        }
        final Date date = response.headers().getDate("Last-Modified");
        if (date != null) {
            final Date date2 = response2.headers().getDate("Last-Modified");
            if (date2 != null) {
                if (date2.getTime() < date.getTime()) {
                    return b;
                }
            }
        }
        return false;
    }
    
    public Response intercept(final Interceptor$Chain interceptor$Chain) {
        final InternalCache cache = this.cache;
        Response value;
        if (cache != null) {
            value = cache.get(interceptor$Chain.request());
        }
        else {
            value = null;
        }
        final CacheStrategy value2 = new CacheStrategy$Factory(System.currentTimeMillis(), interceptor$Chain.request(), value).get();
        final Request networkRequest = value2.networkRequest;
        final Response cacheResponse = value2.cacheResponse;
        final InternalCache cache2 = this.cache;
        if (cache2 != null) {
            cache2.trackResponse(value2);
        }
        if (value != null && cacheResponse == null) {
            Util.closeQuietly(value.body());
        }
        if (networkRequest == null && cacheResponse == null) {
            return new Response$Builder().request(interceptor$Chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(CacheInterceptor.EMPTY_BODY).sentRequestAtMillis(-1).receivedResponseAtMillis(System.currentTimeMillis()).build();
        }
        if (networkRequest == null) {
            return cacheResponse.newBuilder().cacheResponse(stripBody(cacheResponse)).build();
        }
        try {
            final Response proceed;
            if ((proceed = interceptor$Chain.proceed(networkRequest)) == null && value != null) {
                Util.closeQuietly(value.body());
            }
            if (cacheResponse != null) {
                if (validate(cacheResponse, proceed)) {
                    final Response build = cacheResponse.newBuilder().headers(combine(cacheResponse.headers(), proceed.headers())).cacheResponse(stripBody(cacheResponse)).networkResponse(stripBody(proceed)).build();
                    proceed.body().close();
                    this.cache.trackConditionalCacheHit();
                    this.cache.update(cacheResponse, build);
                    return build;
                }
                Util.closeQuietly(cacheResponse.body());
            }
            Response response = proceed.newBuilder().cacheResponse(stripBody(cacheResponse)).networkResponse(stripBody(proceed)).build();
            if (HttpHeaders.hasBody(response)) {
                response = this.cacheWritingResponse(this.maybeCache(response, proceed.request(), this.cache), response);
            }
            return response;
        }
        finally {
            if (!false && value != null) {
                Util.closeQuietly(value.body());
            }
        }
    }
}
