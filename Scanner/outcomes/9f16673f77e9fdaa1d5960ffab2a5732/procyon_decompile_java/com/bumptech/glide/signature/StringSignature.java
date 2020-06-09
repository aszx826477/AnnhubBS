// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.signature;

import java.security.MessageDigest;
import com.bumptech.glide.load.Key;

public class StringSignature implements Key
{
    private final String signature;
    
    public StringSignature(final String signature) {
        if (signature != null) {
            this.signature = signature;
            return;
        }
        throw new NullPointerException("Signature cannot be null!");
    }
    
    public boolean equals(final Object o) {
        return this == o || (o != null && this.getClass() == o.getClass() && this.signature.equals(((StringSignature)o).signature));
    }
    
    public int hashCode() {
        return this.signature.hashCode();
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("StringSignature{signature='");
        sb.append(this.signature);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
    
    public void updateDiskCacheKey(final MessageDigest messageDigest) {
        messageDigest.update(this.signature.getBytes("UTF-8"));
    }
}
