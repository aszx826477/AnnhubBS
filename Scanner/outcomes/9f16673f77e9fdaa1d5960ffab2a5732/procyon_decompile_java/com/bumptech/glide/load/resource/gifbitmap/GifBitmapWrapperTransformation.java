// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.Transformation;

public class GifBitmapWrapperTransformation implements Transformation
{
    private final Transformation bitmapTransformation;
    private final Transformation gifDataTransformation;
    
    GifBitmapWrapperTransformation(final Transformation bitmapTransformation, final Transformation gifDataTransformation) {
        this.bitmapTransformation = bitmapTransformation;
        this.gifDataTransformation = gifDataTransformation;
    }
    
    public GifBitmapWrapperTransformation(final BitmapPool bitmapPool, final Transformation transformation) {
        this(transformation, new GifDrawableTransformation(transformation, bitmapPool));
    }
    
    public String getId() {
        return this.bitmapTransformation.getId();
    }
    
    public Resource transform(final Resource resource, final int n, final int n2) {
        final Resource bitmapResource = ((GifBitmapWrapper)resource.get()).getBitmapResource();
        final Resource gifResource = ((GifBitmapWrapper)resource.get()).getGifResource();
        if (bitmapResource != null) {
            final Transformation bitmapTransformation = this.bitmapTransformation;
            if (bitmapTransformation != null) {
                final Resource transform = bitmapTransformation.transform(bitmapResource, n, n2);
                if (!bitmapResource.equals(transform)) {
                    return new GifBitmapWrapperResource(new GifBitmapWrapper(transform, ((GifBitmapWrapper)resource.get()).getGifResource()));
                }
                return resource;
            }
        }
        if (gifResource != null) {
            final Transformation gifDataTransformation = this.gifDataTransformation;
            if (gifDataTransformation != null) {
                final Resource transform2 = gifDataTransformation.transform(gifResource, n, n2);
                if (!gifResource.equals(transform2)) {
                    return new GifBitmapWrapperResource(new GifBitmapWrapper(((GifBitmapWrapper)resource.get()).getBitmapResource(), transform2));
                }
            }
        }
        return resource;
    }
}
