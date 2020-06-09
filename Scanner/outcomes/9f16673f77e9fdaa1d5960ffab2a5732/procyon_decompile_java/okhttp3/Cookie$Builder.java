// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okhttp3.internal.Util;

public final class Cookie$Builder
{
    String domain;
    long expiresAt;
    boolean hostOnly;
    boolean httpOnly;
    String name;
    String path;
    boolean persistent;
    boolean secure;
    String value;
    
    public Cookie$Builder() {
        this.expiresAt = 253402300799999L;
        this.path = "/";
    }
    
    private Cookie$Builder domain(final String s, final boolean hostOnly) {
        if (s == null) {
            throw new NullPointerException("domain == null");
        }
        final String domainToAscii = Util.domainToAscii(s);
        if (domainToAscii != null) {
            this.domain = domainToAscii;
            this.hostOnly = hostOnly;
            return this;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unexpected domain: ");
        sb.append(s);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public Cookie build() {
        return new Cookie(this, null);
    }
    
    public Cookie$Builder domain(final String s) {
        return this.domain(s, false);
    }
    
    public Cookie$Builder expiresAt(long expiresAt) {
        if (expiresAt <= 0L) {
            expiresAt = Long.MIN_VALUE;
        }
        if (expiresAt > 253402300799999L) {
            expiresAt = 253402300799999L;
        }
        this.expiresAt = expiresAt;
        this.persistent = true;
        return this;
    }
    
    public Cookie$Builder hostOnlyDomain(final String s) {
        return this.domain(s, true);
    }
    
    public Cookie$Builder httpOnly() {
        this.httpOnly = true;
        return this;
    }
    
    public Cookie$Builder name(final String name) {
        if (name == null) {
            throw new NullPointerException("name == null");
        }
        if (name.trim().equals(name)) {
            this.name = name;
            return this;
        }
        throw new IllegalArgumentException("name is not trimmed");
    }
    
    public Cookie$Builder path(final String path) {
        if (path.startsWith("/")) {
            this.path = path;
            return this;
        }
        throw new IllegalArgumentException("path must start with '/'");
    }
    
    public Cookie$Builder secure() {
        this.secure = true;
        return this;
    }
    
    public Cookie$Builder value(final String value) {
        if (value == null) {
            throw new NullPointerException("value == null");
        }
        if (value.trim().equals(value)) {
            this.value = value;
            return this;
        }
        throw new IllegalArgumentException("value is not trimmed");
    }
}
