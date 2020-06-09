// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.util.Util;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Resource;

public class BitmapResource implements Resource
{
    private final Bitmap bitmap;
    private final BitmapPool bitmapPool;
    
    public BitmapResource(final Bitmap bitmap, final BitmapPool bitmapPool) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (bitmapPool != null) {
            this.bitmap = bitmap;
            this.bitmapPool = bitmapPool;
            return;
        }
        throw new NullPointerException("BitmapPool must not be null");
    }
    
    public static BitmapResource obtain(final Bitmap bitmap, final BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bitmapPool);
    }
    
    public Bitmap get() {
        return this.bitmap;
    }
    
    public int getSize() {
        return Util.getBitmapByteSize(this.bitmap);
    }
    
    public void recycle() {
        if (!this.bitmapPool.put(this.bitmap)) {
            this.bitmap.recycle();
        }
    }
}
