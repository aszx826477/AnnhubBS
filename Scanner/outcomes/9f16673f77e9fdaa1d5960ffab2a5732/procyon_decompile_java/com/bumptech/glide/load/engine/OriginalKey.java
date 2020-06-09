// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

import java.security.MessageDigest;
import com.bumptech.glide.load.Key;

class OriginalKey implements Key
{
    private final String id;
    private final Key signature;
    
    public OriginalKey(final String id, final Key signature) {
        this.id = id;
        this.signature = signature;
    }
    
    public boolean equals(final Object o) {
        final boolean b = true;
        if (this == o) {
            return b;
        }
        if (o != null && this.getClass() == o.getClass()) {
            final OriginalKey originalKey = (OriginalKey)o;
            return this.id.equals(originalKey.id) && this.signature.equals(originalKey.signature) && b;
        }
        return false;
    }
    
    public int hashCode() {
        return this.id.hashCode() * 31 + this.signature.hashCode();
    }
    
    public void updateDiskCacheKey(final MessageDigest messageDigest) {
        messageDigest.update(this.id.getBytes("UTF-8"));
        this.signature.updateDiskCacheKey(messageDigest);
    }
}
