// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gif;

import java.security.MessageDigest;
import java.util.UUID;
import com.bumptech.glide.load.Key;

class GifFrameLoader$FrameSignature implements Key
{
    private final UUID uuid;
    
    public GifFrameLoader$FrameSignature() {
        this(UUID.randomUUID());
    }
    
    GifFrameLoader$FrameSignature(final UUID uuid) {
        this.uuid = uuid;
    }
    
    public boolean equals(final Object o) {
        return o instanceof GifFrameLoader$FrameSignature && ((GifFrameLoader$FrameSignature)o).uuid.equals(this.uuid);
    }
    
    public int hashCode() {
        return this.uuid.hashCode();
    }
    
    public void updateDiskCacheKey(final MessageDigest messageDigest) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
