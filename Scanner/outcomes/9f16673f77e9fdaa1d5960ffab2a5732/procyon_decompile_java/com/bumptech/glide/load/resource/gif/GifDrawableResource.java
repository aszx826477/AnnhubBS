// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.util.Util;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

public class GifDrawableResource extends DrawableResource
{
    public GifDrawableResource(final GifDrawable gifDrawable) {
        super(gifDrawable);
    }
    
    public int getSize() {
        return ((GifDrawable)this.drawable).getData().length + Util.getBitmapByteSize(((GifDrawable)this.drawable).getFirstFrame());
    }
    
    public void recycle() {
        ((GifDrawable)this.drawable).stop();
        ((GifDrawable)this.drawable).recycle();
    }
}
