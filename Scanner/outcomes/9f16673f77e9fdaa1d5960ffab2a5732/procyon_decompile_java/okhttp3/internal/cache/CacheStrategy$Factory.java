// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.cache;

import okhttp3.Headers$Builder;
import okhttp3.Response$Builder;
import okhttp3.internal.Internal;
import okhttp3.CacheControl;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpDate;
import okhttp3.Request;
import java.util.Date;
import okhttp3.Response;

public class CacheStrategy$Factory
{
    private int ageSeconds;
    final Response cacheResponse;
    private String etag;
    private Date expires;
    private Date lastModified;
    private String lastModifiedString;
    final long nowMillis;
    private long receivedResponseMillis;
    final Request request;
    private long sentRequestMillis;
    private Date servedDate;
    private String servedDateString;
    
    public CacheStrategy$Factory(final long nowMillis, final Request request, final Response cacheResponse) {
        final int ageSeconds = -1;
        this.ageSeconds = ageSeconds;
        this.nowMillis = nowMillis;
        this.request = request;
        this.cacheResponse = cacheResponse;
        if (cacheResponse != null) {
            this.sentRequestMillis = cacheResponse.sentRequestAtMillis();
            this.receivedResponseMillis = cacheResponse.receivedResponseAtMillis();
            final Headers headers = cacheResponse.headers();
            for (int i = 0; i < headers.size(); ++i) {
                final String name = headers.name(i);
                final String value = headers.value(i);
                if ("Date".equalsIgnoreCase(name)) {
                    this.servedDate = HttpDate.parse(value);
                    this.servedDateString = value;
                }
                else if ("Expires".equalsIgnoreCase(name)) {
                    this.expires = HttpDate.parse(value);
                }
                else if ("Last-Modified".equalsIgnoreCase(name)) {
                    this.lastModified = HttpDate.parse(value);
                    this.lastModifiedString = value;
                }
                else if ("ETag".equalsIgnoreCase(name)) {
                    this.etag = value;
                }
                else if ("Age".equalsIgnoreCase(name)) {
                    this.ageSeconds = HttpHeaders.parseSeconds(value, ageSeconds);
                }
            }
        }
    }
    
    private long cacheResponseAge() {
        final Date servedDate = this.servedDate;
        long max = 0L;
        if (servedDate != null) {
            max = Math.max(max, this.receivedResponseMillis - servedDate.getTime());
        }
        long max2;
        if (this.ageSeconds != -1) {
            max2 = Math.max(max, TimeUnit.SECONDS.toMillis(this.ageSeconds));
        }
        else {
            max2 = max;
        }
        final long receivedResponseMillis = this.receivedResponseMillis;
        return max2 + (receivedResponseMillis - this.sentRequestMillis) + (this.nowMillis - receivedResponseMillis);
    }
    
    private long computeFreshnessLifetime() {
        final CacheControl cacheControl = this.cacheResponse.cacheControl();
        if (cacheControl.maxAgeSeconds() != -1) {
            return TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds());
        }
        final Date expires = this.expires;
        long n = 0L;
        if (expires != null) {
            final Date servedDate = this.servedDate;
            long n2;
            if (servedDate != null) {
                n2 = servedDate.getTime();
            }
            else {
                n2 = this.receivedResponseMillis;
            }
            final long n3 = this.expires.getTime() - n2;
            if (n3 > n) {
                n = n3;
            }
            return n;
        }
        if (this.lastModified != null && this.cacheResponse.request().url().query() == null) {
            final Date servedDate2 = this.servedDate;
            long n4;
            if (servedDate2 != null) {
                n4 = servedDate2.getTime();
            }
            else {
                n4 = this.sentRequestMillis;
            }
            final long n5 = n4 - this.lastModified.getTime();
            if (n5 > n) {
                n = n5 / 10;
            }
            return n;
        }
        return n;
    }
    
    private CacheStrategy getCandidate() {
        if (this.cacheResponse == null) {
            return new CacheStrategy(this.request, null, null);
        }
        if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
            return new CacheStrategy(this.request, null, null);
        }
        if (!CacheStrategy.isCacheable(this.cacheResponse, this.request)) {
            return new CacheStrategy(this.request, null, null);
        }
        final CacheControl cacheControl = this.request.cacheControl();
        if (!cacheControl.noCache()) {
            if (!hasConditions(this.request)) {
                final long cacheResponseAge = this.cacheResponseAge();
                long n = this.computeFreshnessLifetime();
                final int maxAgeSeconds = cacheControl.maxAgeSeconds();
                final int n2 = -1;
                if (maxAgeSeconds != n2) {
                    n = Math.min(n, TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
                }
                long millis = 0L;
                if (cacheControl.minFreshSeconds() != n2) {
                    millis = TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds());
                }
                long millis2 = 0L;
                final CacheControl cacheControl2 = this.cacheResponse.cacheControl();
                if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != n2) {
                    millis2 = TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
                }
                if (!cacheControl2.noCache() && cacheResponseAge + millis < n + millis2) {
                    final Response$Builder builder = this.cacheResponse.newBuilder();
                    if (cacheResponseAge + millis >= n) {
                        builder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (cacheResponseAge > 86400000L && this.isFreshnessLifetimeHeuristic()) {
                        builder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy(null, builder.build(), null);
                }
                String s;
                String s2;
                if (this.etag != null) {
                    s = "If-None-Match";
                    s2 = this.etag;
                }
                else if (this.lastModified != null) {
                    s = "If-Modified-Since";
                    s2 = this.lastModifiedString;
                }
                else {
                    if (this.servedDate == null) {
                        return new CacheStrategy(this.request, null, null);
                    }
                    s = "If-Modified-Since";
                    s2 = this.servedDateString;
                }
                final Headers$Builder builder2 = this.request.headers().newBuilder();
                Internal.instance.addLenient(builder2, s, s2);
                return new CacheStrategy(this.request.newBuilder().headers(builder2.build()).build(), this.cacheResponse, null);
            }
        }
        return new CacheStrategy(this.request, null, null);
    }
    
    private static boolean hasConditions(final Request request) {
        return request.header("If-Modified-Since") != null || request.header("If-None-Match") != null;
    }
    
    private boolean isFreshnessLifetimeHeuristic() {
        return this.cacheResponse.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
    }
    
    public CacheStrategy get() {
        final CacheStrategy candidate = this.getCandidate();
        if (candidate.networkRequest != null && this.request.cacheControl().onlyIfCached()) {
            return new CacheStrategy(null, null, null);
        }
        return candidate;
    }
}
