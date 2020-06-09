// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import android.content.Context;

public class CenterCrop extends BitmapTransformation
{
    public CenterCrop(final Context context) {
        super(context);
    }
    
    public CenterCrop(final BitmapPool bitmapPool) {
        super(bitmapPool);
    }
    
    public String getId() {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }
    
    protected Bitmap transform(final BitmapPool bitmapPool, final Bitmap bitmap, final int n, final int n2) {
        Bitmap$Config bitmap$Config;
        if (bitmap.getConfig() != null) {
            bitmap$Config = bitmap.getConfig();
        }
        else {
            bitmap$Config = Bitmap$Config.ARGB_8888;
        }
        final Bitmap value = bitmapPool.get(n, n2, bitmap$Config);
        final Bitmap centerCrop = TransformationUtils.centerCrop(value, bitmap, n, n2);
        if (value != null && value != centerCrop && !bitmapPool.put(value)) {
            value.recycle();
        }
        return centerCrop;
    }
}
