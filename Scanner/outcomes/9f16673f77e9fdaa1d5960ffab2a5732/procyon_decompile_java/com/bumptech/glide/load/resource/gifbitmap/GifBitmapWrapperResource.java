// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.engine.Resource;

public class GifBitmapWrapperResource implements Resource
{
    private final GifBitmapWrapper data;
    
    public GifBitmapWrapperResource(final GifBitmapWrapper data) {
        if (data != null) {
            this.data = data;
            return;
        }
        throw new NullPointerException("Data must not be null");
    }
    
    public GifBitmapWrapper get() {
        return this.data;
    }
    
    public int getSize() {
        return this.data.getSize();
    }
    
    public void recycle() {
        final Resource bitmapResource = this.data.getBitmapResource();
        if (bitmapResource != null) {
            bitmapResource.recycle();
        }
        final Resource gifResource = this.data.getGifResource();
        if (gifResource != null) {
            gifResource.recycle();
        }
    }
}
