// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import android.content.Context;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.provider.DataLoadProvider;

public class GifDrawableLoadProvider implements DataLoadProvider
{
    private final FileToStreamDecoder cacheDecoder;
    private final GifResourceDecoder decoder;
    private final GifResourceEncoder encoder;
    private final StreamEncoder sourceEncoder;
    
    public GifDrawableLoadProvider(final Context context, final BitmapPool bitmapPool) {
        this.decoder = new GifResourceDecoder(context, bitmapPool);
        this.cacheDecoder = new FileToStreamDecoder(this.decoder);
        this.encoder = new GifResourceEncoder(bitmapPool);
        this.sourceEncoder = new StreamEncoder();
    }
    
    public ResourceDecoder getCacheDecoder() {
        return this.cacheDecoder;
    }
    
    public ResourceEncoder getEncoder() {
        return this.encoder;
    }
    
    public ResourceDecoder getSourceDecoder() {
        return this.decoder;
    }
    
    public Encoder getSourceEncoder() {
        return this.sourceEncoder;
    }
}
