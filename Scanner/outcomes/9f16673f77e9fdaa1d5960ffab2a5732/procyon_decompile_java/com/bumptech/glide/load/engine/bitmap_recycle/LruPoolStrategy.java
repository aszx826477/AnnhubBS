// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;

interface LruPoolStrategy
{
    Bitmap get(final int p0, final int p1, final Bitmap$Config p2);
    
    int getSize(final Bitmap p0);
    
    String logBitmap(final int p0, final int p1, final Bitmap$Config p2);
    
    String logBitmap(final Bitmap p0);
    
    void put(final Bitmap p0);
    
    Bitmap removeLast();
}
