// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import okhttp3.internal.http.HttpHeaders;
import java.util.concurrent.TimeUnit;

public final class CacheControl
{
    public static final CacheControl FORCE_CACHE;
    public static final CacheControl FORCE_NETWORK;
    String headerValue;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;
    
    static {
        FORCE_NETWORK = new CacheControl$Builder().noCache().build();
        FORCE_CACHE = new CacheControl$Builder().onlyIfCached().maxStale(-1 >>> 1, TimeUnit.SECONDS).build();
    }
    
    private CacheControl(final CacheControl$Builder cacheControl$Builder) {
        this.noCache = cacheControl$Builder.noCache;
        this.noStore = cacheControl$Builder.noStore;
        this.maxAgeSeconds = cacheControl$Builder.maxAgeSeconds;
        this.sMaxAgeSeconds = -1;
        this.isPrivate = false;
        this.isPublic = false;
        this.mustRevalidate = false;
        this.maxStaleSeconds = cacheControl$Builder.maxStaleSeconds;
        this.minFreshSeconds = cacheControl$Builder.minFreshSeconds;
        this.onlyIfCached = cacheControl$Builder.onlyIfCached;
        this.noTransform = cacheControl$Builder.noTransform;
    }
    
    private CacheControl(final boolean noCache, final boolean noStore, final int maxAgeSeconds, final int sMaxAgeSeconds, final boolean isPrivate, final boolean isPublic, final boolean mustRevalidate, final int maxStaleSeconds, final int minFreshSeconds, final boolean onlyIfCached, final boolean noTransform, final String headerValue) {
        this.noCache = noCache;
        this.noStore = noStore;
        this.maxAgeSeconds = maxAgeSeconds;
        this.sMaxAgeSeconds = sMaxAgeSeconds;
        this.isPrivate = isPrivate;
        this.isPublic = isPublic;
        this.mustRevalidate = mustRevalidate;
        this.maxStaleSeconds = maxStaleSeconds;
        this.minFreshSeconds = minFreshSeconds;
        this.onlyIfCached = onlyIfCached;
        this.noTransform = noTransform;
        this.headerValue = headerValue;
    }
    
    private String headerValue() {
        final StringBuilder sb = new StringBuilder();
        if (this.noCache) {
            sb.append("no-cache, ");
        }
        if (this.noStore) {
            sb.append("no-store, ");
        }
        final int maxAgeSeconds = this.maxAgeSeconds;
        final int n = -1;
        if (maxAgeSeconds != n) {
            sb.append("max-age=");
            sb.append(this.maxAgeSeconds);
            sb.append(", ");
        }
        if (this.sMaxAgeSeconds != n) {
            sb.append("s-maxage=");
            sb.append(this.sMaxAgeSeconds);
            sb.append(", ");
        }
        if (this.isPrivate) {
            sb.append("private, ");
        }
        if (this.isPublic) {
            sb.append("public, ");
        }
        if (this.mustRevalidate) {
            sb.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != n) {
            sb.append("max-stale=");
            sb.append(this.maxStaleSeconds);
            sb.append(", ");
        }
        if (this.minFreshSeconds != n) {
            sb.append("min-fresh=");
            sb.append(this.minFreshSeconds);
            sb.append(", ");
        }
        if (this.onlyIfCached) {
            sb.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb.append("no-transform, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
    
    public static CacheControl parse(final Headers headers) {
        Headers headers2 = headers;
        boolean b = false;
        float n = 0.0f;
        boolean b2 = false;
        float n2 = 0.0f;
        int seconds = -1;
        int seconds2 = -1;
        boolean b3 = false;
        boolean b4 = false;
        boolean b5 = false;
        int seconds3 = -1;
        int seconds4 = -1;
        boolean b6 = false;
        boolean b7 = false;
        float n3 = 0.0f;
        boolean b8 = true;
        String s = null;
        int n4;
        for (int i = 0, size = headers.size(); i < size; ++i, size = n4, headers2 = headers) {
            n4 = size;
            final String name = headers2.name(i);
            boolean b9 = b7;
            float n5 = n3;
            final String value = headers2.value(i);
            if (name.equalsIgnoreCase("Cache-Control")) {
                if (s != null) {
                    b8 = false;
                }
                else {
                    s = value;
                }
            }
            else {
                if (!name.equalsIgnoreCase("Pragma")) {
                    continue;
                }
                b8 = false;
            }
            int n6 = 0;
            boolean b10;
            while (true) {
                b10 = b;
                final float n7 = n;
                if (n6 >= value.length()) {
                    break;
                }
                final int n8 = n6;
                final boolean b11 = b2;
                final float n9 = n2;
                final int skipUntil = HttpHeaders.skipUntil(value, n6, "=,;");
                final String trim = value.substring(n8, skipUntil).trim();
                int n10 = 0;
                String s2 = null;
                int skipUntil3 = 0;
                Label_0400: {
                    if (skipUntil != value.length()) {
                        final char char1 = value.charAt(skipUntil);
                        n10 = seconds;
                        if (char1 != ',') {
                            if (value.charAt(skipUntil) != ';') {
                                final int skipWhitespace = HttpHeaders.skipWhitespace(value, skipUntil + 1);
                                if (skipWhitespace < value.length() && value.charAt(skipWhitespace) == '\"') {
                                    final int n11;
                                    final int skipUntil2 = HttpHeaders.skipUntil(value, n11 = skipWhitespace + 1, "\"");
                                    s2 = value.substring(n11, skipUntil2);
                                    skipUntil3 = skipUntil2 + 1;
                                    break Label_0400;
                                }
                                final int n12 = skipWhitespace;
                                skipUntil3 = HttpHeaders.skipUntil(value, skipWhitespace, ",;");
                                s2 = value.substring(n12, skipUntil3).trim();
                                break Label_0400;
                            }
                        }
                    }
                    else {
                        n10 = seconds;
                    }
                    skipUntil3 = skipUntil + 1;
                    s2 = null;
                }
                int n13;
                if ("no-cache".equalsIgnoreCase(trim)) {
                    b = true;
                    n = Float.MIN_VALUE;
                    n13 = skipUntil3;
                    b2 = b11;
                    n2 = n9;
                    seconds = n10;
                }
                else if ("no-store".equalsIgnoreCase(trim)) {
                    n13 = skipUntil3;
                    b2 = true;
                    n2 = Float.MIN_VALUE;
                    b = b10;
                    n = n7;
                    seconds = n10;
                }
                else {
                    final boolean equalsIgnoreCase = "max-age".equalsIgnoreCase(trim);
                    n13 = skipUntil3;
                    final int n14 = -1;
                    if (equalsIgnoreCase) {
                        seconds = HttpHeaders.parseSeconds(s2, n14);
                        b = b10;
                        n = n7;
                        b2 = b11;
                        n2 = n9;
                    }
                    else if ("s-maxage".equalsIgnoreCase(trim)) {
                        seconds2 = HttpHeaders.parseSeconds(s2, n14);
                        b = b10;
                        n = n7;
                        b2 = b11;
                        n2 = n9;
                        seconds = n10;
                    }
                    else if ("private".equalsIgnoreCase(trim)) {
                        b3 = true;
                        b = b10;
                        n = n7;
                        b2 = b11;
                        n2 = n9;
                        seconds = n10;
                    }
                    else if ("public".equalsIgnoreCase(trim)) {
                        b4 = true;
                        b = b10;
                        n = n7;
                        b2 = b11;
                        n2 = n9;
                        seconds = n10;
                    }
                    else if ("must-revalidate".equalsIgnoreCase(trim)) {
                        b5 = true;
                        b = b10;
                        n = n7;
                        b2 = b11;
                        n2 = n9;
                        seconds = n10;
                    }
                    else if ("max-stale".equalsIgnoreCase(trim)) {
                        seconds3 = HttpHeaders.parseSeconds(s2, -1 >>> 1);
                        b = b10;
                        n = n7;
                        b2 = b11;
                        n2 = n9;
                        seconds = n10;
                    }
                    else if ("min-fresh".equalsIgnoreCase(trim)) {
                        seconds4 = HttpHeaders.parseSeconds(s2, n14);
                        b = b10;
                        n = n7;
                        b2 = b11;
                        n2 = n9;
                        seconds = n10;
                    }
                    else if ("only-if-cached".equalsIgnoreCase(trim)) {
                        b6 = true;
                        b = b10;
                        n = n7;
                        b2 = b11;
                        n2 = n9;
                        seconds = n10;
                    }
                    else if ("no-transform".equalsIgnoreCase(trim)) {
                        final boolean b12 = true;
                        final float n15 = Float.MIN_VALUE;
                        b9 = b12;
                        n5 = n15;
                        b = b10;
                        n = n7;
                        b2 = b11;
                        n2 = n9;
                        seconds = n10;
                    }
                    else {
                        b = b10;
                        n = n7;
                        b2 = b11;
                        n2 = n9;
                        seconds = n10;
                    }
                }
                n6 = n13;
            }
            b = b10;
            b7 = b9;
            n3 = n5;
        }
        final boolean b13 = b7;
        if (!b8) {
            s = null;
        }
        return new CacheControl(b, b2, seconds, seconds2, b3, b4, b5, seconds3, seconds4, b6, b13, s);
    }
    
    public boolean isPrivate() {
        return this.isPrivate;
    }
    
    public boolean isPublic() {
        return this.isPublic;
    }
    
    public int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }
    
    public int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }
    
    public int minFreshSeconds() {
        return this.minFreshSeconds;
    }
    
    public boolean mustRevalidate() {
        return this.mustRevalidate;
    }
    
    public boolean noCache() {
        return this.noCache;
    }
    
    public boolean noStore() {
        return this.noStore;
    }
    
    public boolean noTransform() {
        return this.noTransform;
    }
    
    public boolean onlyIfCached() {
        return this.onlyIfCached;
    }
    
    public int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }
    
    public String toString() {
        final String headerValue = this.headerValue;
        String headerValue2;
        if (headerValue != null) {
            headerValue2 = headerValue;
        }
        else {
            headerValue2 = this.headerValue();
            this.headerValue = headerValue2;
        }
        return headerValue2;
    }
}
