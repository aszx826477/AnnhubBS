// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.util.Util;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

public class BitmapDrawableResource extends DrawableResource
{
    private final BitmapPool bitmapPool;
    
    public BitmapDrawableResource(final BitmapDrawable bitmapDrawable, final BitmapPool bitmapPool) {
        super((Drawable)bitmapDrawable);
        this.bitmapPool = bitmapPool;
    }
    
    public int getSize() {
        return Util.getBitmapByteSize(((BitmapDrawable)this.drawable).getBitmap());
    }
    
    public void recycle() {
        this.bitmapPool.put(((BitmapDrawable)this.drawable).getBitmap());
    }
}
