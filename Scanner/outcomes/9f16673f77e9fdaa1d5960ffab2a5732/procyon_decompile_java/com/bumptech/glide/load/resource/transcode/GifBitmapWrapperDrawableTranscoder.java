// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.bumptech.glide.load.engine.Resource;

public class GifBitmapWrapperDrawableTranscoder implements ResourceTranscoder
{
    private final ResourceTranscoder bitmapDrawableResourceTranscoder;
    
    public GifBitmapWrapperDrawableTranscoder(final ResourceTranscoder bitmapDrawableResourceTranscoder) {
        this.bitmapDrawableResourceTranscoder = bitmapDrawableResourceTranscoder;
    }
    
    public String getId() {
        return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
    
    public Resource transcode(final Resource resource) {
        final GifBitmapWrapper gifBitmapWrapper = (GifBitmapWrapper)resource.get();
        final Resource bitmapResource = gifBitmapWrapper.getBitmapResource();
        Resource resource2;
        if (bitmapResource != null) {
            resource2 = this.bitmapDrawableResourceTranscoder.transcode(bitmapResource);
        }
        else {
            resource2 = gifBitmapWrapper.getGifResource();
        }
        return resource2;
    }
}
