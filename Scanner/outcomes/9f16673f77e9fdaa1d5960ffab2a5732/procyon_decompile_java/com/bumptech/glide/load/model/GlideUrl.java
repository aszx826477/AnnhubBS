// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import java.util.Map;
import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;

public class GlideUrl
{
    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    private final Headers headers;
    private String safeStringUrl;
    private URL safeUrl;
    private final String stringUrl;
    private final URL url;
    
    public GlideUrl(final String s) {
        this(s, Headers.DEFAULT);
    }
    
    public GlideUrl(final String stringUrl, final Headers headers) {
        if (TextUtils.isEmpty((CharSequence)stringUrl)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("String url must not be empty or null: ");
            sb.append(stringUrl);
            throw new IllegalArgumentException(sb.toString());
        }
        if (headers != null) {
            this.stringUrl = stringUrl;
            this.url = null;
            this.headers = headers;
            return;
        }
        throw new IllegalArgumentException("Headers must not be null");
    }
    
    public GlideUrl(final URL url) {
        this(url, Headers.DEFAULT);
    }
    
    public GlideUrl(final URL url, final Headers headers) {
        if (url == null) {
            throw new IllegalArgumentException("URL must not be null!");
        }
        if (headers != null) {
            this.url = url;
            this.stringUrl = null;
            this.headers = headers;
            return;
        }
        throw new IllegalArgumentException("Headers must not be null");
    }
    
    private String getSafeStringUrl() {
        if (TextUtils.isEmpty((CharSequence)this.safeStringUrl)) {
            String s = this.stringUrl;
            if (TextUtils.isEmpty((CharSequence)s)) {
                s = this.url.toString();
            }
            this.safeStringUrl = Uri.encode(s, "@#&=*+-_.,:!?()/~'%");
        }
        return this.safeStringUrl;
    }
    
    private URL getSafeUrl() {
        if (this.safeUrl == null) {
            this.safeUrl = new URL(this.getSafeStringUrl());
        }
        return this.safeUrl;
    }
    
    public boolean equals(final Object o) {
        final boolean b = o instanceof GlideUrl;
        boolean b2 = false;
        if (b) {
            final GlideUrl glideUrl = (GlideUrl)o;
            if (this.getCacheKey().equals(glideUrl.getCacheKey()) && this.headers.equals(glideUrl.headers)) {
                b2 = true;
            }
            return b2;
        }
        return false;
    }
    
    public String getCacheKey() {
        String s = this.stringUrl;
        if (s == null) {
            s = this.url.toString();
        }
        return s;
    }
    
    public Map getHeaders() {
        return this.headers.getHeaders();
    }
    
    public int hashCode() {
        return this.getCacheKey().hashCode() * 31 + this.headers.hashCode();
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getCacheKey());
        sb.append('\n');
        sb.append(this.headers.toString());
        return sb.toString();
    }
    
    public String toStringUrl() {
        return this.getSafeStringUrl();
    }
    
    public URL toURL() {
        return this.getSafeUrl();
    }
}
