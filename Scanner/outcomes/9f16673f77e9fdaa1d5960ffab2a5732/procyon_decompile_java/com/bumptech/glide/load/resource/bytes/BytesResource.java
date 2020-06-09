// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.engine.Resource;

public class BytesResource implements Resource
{
    private final byte[] bytes;
    
    public BytesResource(final byte[] bytes) {
        if (bytes != null) {
            this.bytes = bytes;
            return;
        }
        throw new NullPointerException("Bytes must not be null");
    }
    
    public byte[] get() {
        return this.bytes;
    }
    
    public int getSize() {
        return this.bytes.length;
    }
    
    public void recycle() {
    }
}
