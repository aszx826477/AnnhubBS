// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.util.concurrent.TimeUnit;

public final class CacheControl$Builder
{
    int maxAgeSeconds;
    int maxStaleSeconds;
    int minFreshSeconds;
    boolean noCache;
    boolean noStore;
    boolean noTransform;
    boolean onlyIfCached;
    
    public CacheControl$Builder() {
        final int minFreshSeconds = -1;
        this.maxAgeSeconds = minFreshSeconds;
        this.maxStaleSeconds = minFreshSeconds;
        this.minFreshSeconds = minFreshSeconds;
    }
    
    public CacheControl build() {
        return new CacheControl(this, null);
    }
    
    public CacheControl$Builder maxAge(final int n, final TimeUnit timeUnit) {
        if (n >= 0) {
            final long seconds = timeUnit.toSeconds(n);
            int maxAgeSeconds;
            if (seconds > 2147483647L) {
                maxAgeSeconds = -1 >>> 1;
            }
            else {
                maxAgeSeconds = (int)seconds;
            }
            this.maxAgeSeconds = maxAgeSeconds;
            return this;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("maxAge < 0: ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public CacheControl$Builder maxStale(final int n, final TimeUnit timeUnit) {
        if (n >= 0) {
            final long seconds = timeUnit.toSeconds(n);
            int maxStaleSeconds;
            if (seconds > 2147483647L) {
                maxStaleSeconds = -1 >>> 1;
            }
            else {
                maxStaleSeconds = (int)seconds;
            }
            this.maxStaleSeconds = maxStaleSeconds;
            return this;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("maxStale < 0: ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public CacheControl$Builder minFresh(final int n, final TimeUnit timeUnit) {
        if (n >= 0) {
            final long seconds = timeUnit.toSeconds(n);
            int minFreshSeconds;
            if (seconds > 2147483647L) {
                minFreshSeconds = -1 >>> 1;
            }
            else {
                minFreshSeconds = (int)seconds;
            }
            this.minFreshSeconds = minFreshSeconds;
            return this;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("minFresh < 0: ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public CacheControl$Builder noCache() {
        this.noCache = true;
        return this;
    }
    
    public CacheControl$Builder noStore() {
        this.noStore = true;
        return this;
    }
    
    public CacheControl$Builder noTransform() {
        this.noTransform = true;
        return this;
    }
    
    public CacheControl$Builder onlyIfCached() {
        this.onlyIfCached = true;
        return this;
    }
}
