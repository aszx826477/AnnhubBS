// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

interface LruBitmapPool$BitmapTracker
{
    void add(final Bitmap p0);
    
    void remove(final Bitmap p0);
}
