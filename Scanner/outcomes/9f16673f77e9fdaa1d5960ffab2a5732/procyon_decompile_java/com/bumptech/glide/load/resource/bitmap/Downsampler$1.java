// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import java.io.InputStream;
import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

final class Downsampler$1 extends Downsampler
{
    public String getId() {
        return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
    }
    
    protected int getSampleSize(final int n, final int n2, final int n3, final int n4) {
        return Math.min(n2 / n4, n / n3);
    }
}
