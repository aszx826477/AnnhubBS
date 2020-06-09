// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;

public class BitmapPoolAdapter implements BitmapPool
{
    public void clearMemory() {
    }
    
    public Bitmap get(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        return null;
    }
    
    public Bitmap getDirty(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        return null;
    }
    
    public int getMaxSize() {
        return 0;
    }
    
    public boolean put(final Bitmap bitmap) {
        return false;
    }
    
    public void setSizeMultiplier(final float n) {
    }
    
    public void trimMemory(final int n) {
    }
}
