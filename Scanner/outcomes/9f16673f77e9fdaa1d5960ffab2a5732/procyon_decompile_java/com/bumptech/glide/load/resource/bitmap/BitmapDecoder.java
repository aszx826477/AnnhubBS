// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public interface BitmapDecoder
{
    Bitmap decode(final Object p0, final BitmapPool p1, final int p2, final int p3, final DecodeFormat p4);
    
    String getId();
}
