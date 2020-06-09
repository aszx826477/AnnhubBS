// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gif;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.load.Transformation;
import android.graphics.Bitmap;
import android.content.Context;
import com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import android.graphics.drawable.Drawable$ConstantState;

class GifDrawable$GifState extends Drawable$ConstantState
{
    private static final int GRAVITY = 119;
    BitmapPool bitmapPool;
    GifDecoder$BitmapProvider bitmapProvider;
    Context context;
    byte[] data;
    Bitmap firstFrame;
    Transformation frameTransformation;
    GifHeader gifHeader;
    int targetHeight;
    int targetWidth;
    
    public GifDrawable$GifState(final GifHeader gifHeader, final byte[] data, final Context context, final Transformation frameTransformation, final int targetWidth, final int targetHeight, final GifDecoder$BitmapProvider bitmapProvider, final BitmapPool bitmapPool, final Bitmap firstFrame) {
        if (firstFrame != null) {
            this.gifHeader = gifHeader;
            this.data = data;
            this.bitmapPool = bitmapPool;
            this.firstFrame = firstFrame;
            this.context = context.getApplicationContext();
            this.frameTransformation = frameTransformation;
            this.targetWidth = targetWidth;
            this.targetHeight = targetHeight;
            this.bitmapProvider = bitmapProvider;
            return;
        }
        throw new NullPointerException("The first frame of the GIF must not be null");
    }
    
    public GifDrawable$GifState(final GifDrawable$GifState gifDrawable$GifState) {
        if (gifDrawable$GifState != null) {
            this.gifHeader = gifDrawable$GifState.gifHeader;
            this.data = gifDrawable$GifState.data;
            this.context = gifDrawable$GifState.context;
            this.frameTransformation = gifDrawable$GifState.frameTransformation;
            this.targetWidth = gifDrawable$GifState.targetWidth;
            this.targetHeight = gifDrawable$GifState.targetHeight;
            this.bitmapProvider = gifDrawable$GifState.bitmapProvider;
            this.bitmapPool = gifDrawable$GifState.bitmapPool;
            this.firstFrame = gifDrawable$GifState.firstFrame;
        }
    }
    
    public int getChangingConfigurations() {
        return 0;
    }
    
    public Drawable newDrawable() {
        return new GifDrawable(this);
    }
    
    public Drawable newDrawable(final Resources resources) {
        return this.newDrawable();
    }
}
