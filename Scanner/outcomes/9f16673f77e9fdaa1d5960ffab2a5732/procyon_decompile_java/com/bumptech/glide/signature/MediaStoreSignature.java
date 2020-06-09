// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.signature;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import com.bumptech.glide.load.Key;

public class MediaStoreSignature implements Key
{
    private final long dateModified;
    private final String mimeType;
    private final int orientation;
    
    public MediaStoreSignature(final String mimeType, final long dateModified, final int orientation) {
        this.mimeType = mimeType;
        this.dateModified = dateModified;
        this.orientation = orientation;
    }
    
    public boolean equals(final Object o) {
        final boolean b = true;
        if (this == o) {
            return b;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final MediaStoreSignature mediaStoreSignature = (MediaStoreSignature)o;
        if (this.dateModified != mediaStoreSignature.dateModified) {
            return false;
        }
        if (this.orientation != mediaStoreSignature.orientation) {
            return false;
        }
        final String mimeType = this.mimeType;
        if (mimeType != null) {
            if (mimeType.equals(mediaStoreSignature.mimeType)) {
                return b;
            }
        }
        else if (mediaStoreSignature.mimeType == null) {
            return b;
        }
        return false;
    }
    
    public int hashCode() {
        final String mimeType = this.mimeType;
        int hashCode;
        if (mimeType != null) {
            hashCode = mimeType.hashCode();
        }
        else {
            hashCode = 0;
        }
        final int n = hashCode * 31;
        final long dateModified = this.dateModified;
        return (n + (int)(dateModified ^ dateModified >>> 32)) * 31 + this.orientation;
    }
    
    public void updateDiskCacheKey(final MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.dateModified).putInt(this.orientation).array());
        messageDigest.update(this.mimeType.getBytes("UTF-8"));
    }
}
