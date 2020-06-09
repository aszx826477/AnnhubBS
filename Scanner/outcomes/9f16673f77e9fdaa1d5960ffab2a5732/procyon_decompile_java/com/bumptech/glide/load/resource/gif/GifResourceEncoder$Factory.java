// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import android.graphics.Bitmap;
import com.bumptech.glide.gifencoder.AnimatedGifEncoder;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider;

class GifResourceEncoder$Factory
{
    public GifDecoder buildDecoder(final GifDecoder$BitmapProvider gifDecoder$BitmapProvider) {
        return new GifDecoder(gifDecoder$BitmapProvider);
    }
    
    public AnimatedGifEncoder buildEncoder() {
        return new AnimatedGifEncoder();
    }
    
    public Resource buildFrameResource(final Bitmap bitmap, final BitmapPool bitmapPool) {
        return new BitmapResource(bitmap, bitmapPool);
    }
    
    public GifHeaderParser buildParser() {
        return new GifHeaderParser();
    }
}
