// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.Transformation;

public class GifDrawableTransformation implements Transformation
{
    private final BitmapPool bitmapPool;
    private final Transformation wrapped;
    
    public GifDrawableTransformation(final Transformation wrapped, final BitmapPool bitmapPool) {
        this.wrapped = wrapped;
        this.bitmapPool = bitmapPool;
    }
    
    public String getId() {
        return this.wrapped.getId();
    }
    
    public Resource transform(final Resource resource, final int n, final int n2) {
        final GifDrawable gifDrawable = (GifDrawable)resource.get();
        final Bitmap firstFrame = ((GifDrawable)resource.get()).getFirstFrame();
        final Bitmap bitmap = (Bitmap)this.wrapped.transform(new BitmapResource(firstFrame, this.bitmapPool), n, n2).get();
        if (!bitmap.equals(firstFrame)) {
            return new GifDrawableResource(new GifDrawable(gifDrawable, bitmap, this.wrapped));
        }
        return resource;
    }
}
