// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okhttp3.internal.Util;

public final class Challenge
{
    private final String realm;
    private final String scheme;
    
    public Challenge(final String scheme, final String realm) {
        this.scheme = scheme;
        this.realm = realm;
    }
    
    public boolean equals(final Object o) {
        if (o instanceof Challenge) {
            if (Util.equal(this.scheme, ((Challenge)o).scheme)) {
                if (Util.equal(this.realm, ((Challenge)o).realm)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int hashCode() {
        final int n = 29 * 31;
        final String realm = this.realm;
        int hashCode = 0;
        int hashCode2;
        if (realm != null) {
            hashCode2 = realm.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final int n2 = (n + hashCode2) * 31;
        final String scheme = this.scheme;
        if (scheme != null) {
            hashCode = scheme.hashCode();
        }
        return n2 + hashCode;
    }
    
    public String realm() {
        return this.realm;
    }
    
    public String scheme() {
        return this.scheme;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.scheme);
        sb.append(" realm=\"");
        sb.append(this.realm);
        sb.append("\"");
        return sb.toString();
    }
}
