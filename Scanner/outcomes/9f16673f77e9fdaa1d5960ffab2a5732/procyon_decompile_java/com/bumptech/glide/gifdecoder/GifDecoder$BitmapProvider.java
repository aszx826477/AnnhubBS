// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;

public interface GifDecoder$BitmapProvider
{
    Bitmap obtain(final int p0, final int p1, final Bitmap$Config p2);
    
    void release(final Bitmap p0);
}
