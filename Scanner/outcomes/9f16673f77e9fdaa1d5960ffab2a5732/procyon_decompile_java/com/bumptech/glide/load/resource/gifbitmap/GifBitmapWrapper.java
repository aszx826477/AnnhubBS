// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.engine.Resource;

public class GifBitmapWrapper
{
    private final Resource bitmapResource;
    private final Resource gifResource;
    
    public GifBitmapWrapper(final Resource bitmapResource, final Resource gifResource) {
        if (bitmapResource != null && gifResource != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        }
        if (bitmapResource == null && gifResource == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        }
        this.bitmapResource = bitmapResource;
        this.gifResource = gifResource;
    }
    
    public Resource getBitmapResource() {
        return this.bitmapResource;
    }
    
    public Resource getGifResource() {
        return this.gifResource;
    }
    
    public int getSize() {
        final Resource bitmapResource = this.bitmapResource;
        if (bitmapResource != null) {
            return bitmapResource.getSize();
        }
        return this.gifResource.getSize();
    }
}
