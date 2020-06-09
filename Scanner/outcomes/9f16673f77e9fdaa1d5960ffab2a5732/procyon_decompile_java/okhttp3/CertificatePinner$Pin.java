// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okio.ByteString;

final class CertificatePinner$Pin
{
    private static final String WILDCARD = "*.";
    final String canonicalHostname;
    final ByteString hash;
    final String hashAlgorithm;
    final String pattern;
    
    CertificatePinner$Pin(final String pattern, final String s) {
        this.pattern = pattern;
        String canonicalHostname;
        if (pattern.startsWith("*.")) {
            final StringBuilder sb = new StringBuilder();
            sb.append("http://");
            sb.append(pattern.substring("*.".length()));
            canonicalHostname = HttpUrl.parse(sb.toString()).host();
        }
        else {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("http://");
            sb2.append(pattern);
            canonicalHostname = HttpUrl.parse(sb2.toString()).host();
        }
        this.canonicalHostname = canonicalHostname;
        if (s.startsWith("sha1/")) {
            this.hashAlgorithm = "sha1/";
            this.hash = ByteString.decodeBase64(s.substring("sha1/".length()));
        }
        else {
            if (!s.startsWith("sha256/")) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("pins must start with 'sha256/' or 'sha1/': ");
                sb3.append(s);
                throw new IllegalArgumentException(sb3.toString());
            }
            this.hashAlgorithm = "sha256/";
            this.hash = ByteString.decodeBase64(s.substring("sha256/".length()));
        }
        if (this.hash != null) {
            return;
        }
        final StringBuilder sb4 = new StringBuilder();
        sb4.append("pins must be base64: ");
        sb4.append(s);
        throw new IllegalArgumentException(sb4.toString());
    }
    
    public boolean equals(final Object o) {
        if (o instanceof CertificatePinner$Pin) {
            if (this.pattern.equals(((CertificatePinner$Pin)o).pattern)) {
                if (this.hashAlgorithm.equals(((CertificatePinner$Pin)o).hashAlgorithm)) {
                    if (this.hash.equals(((CertificatePinner$Pin)o).hash)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public int hashCode() {
        return ((17 * 31 + this.pattern.hashCode()) * 31 + this.hashAlgorithm.hashCode()) * 31 + this.hash.hashCode();
    }
    
    boolean matches(final String s) {
        if (this.pattern.startsWith("*.")) {
            final int n = s.indexOf(46) + 1;
            final String canonicalHostname = this.canonicalHostname;
            return s.regionMatches(false, n, canonicalHostname, 0, canonicalHostname.length());
        }
        return s.equals(this.canonicalHostname);
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.hashAlgorithm);
        sb.append(this.hash.base64());
        return sb.toString();
    }
}
