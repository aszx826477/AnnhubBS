// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import android.content.Context;

public class FitCenter extends BitmapTransformation
{
    public FitCenter(final Context context) {
        super(context);
    }
    
    public FitCenter(final BitmapPool bitmapPool) {
        super(bitmapPool);
    }
    
    public String getId() {
        return "FitCenter.com.bumptech.glide.load.resource.bitmap";
    }
    
    protected Bitmap transform(final BitmapPool bitmapPool, final Bitmap bitmap, final int n, final int n2) {
        return TransformationUtils.fitCenter(bitmap, bitmapPool, n, n2);
    }
}
