// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.provider.DataLoadProvider;

public class ImageVideoGifDrawableLoadProvider implements DataLoadProvider
{
    private final ResourceDecoder cacheDecoder;
    private final ResourceEncoder encoder;
    private final ResourceDecoder sourceDecoder;
    private final Encoder sourceEncoder;
    
    public ImageVideoGifDrawableLoadProvider(final DataLoadProvider dataLoadProvider, final DataLoadProvider dataLoadProvider2, final BitmapPool bitmapPool) {
        final GifBitmapWrapperResourceDecoder sourceDecoder = new GifBitmapWrapperResourceDecoder(dataLoadProvider.getSourceDecoder(), dataLoadProvider2.getSourceDecoder(), bitmapPool);
        this.cacheDecoder = new FileToStreamDecoder(new GifBitmapWrapperStreamResourceDecoder(sourceDecoder));
        this.sourceDecoder = sourceDecoder;
        this.encoder = new GifBitmapWrapperResourceEncoder(dataLoadProvider.getEncoder(), dataLoadProvider2.getEncoder());
        this.sourceEncoder = dataLoadProvider.getSourceEncoder();
    }
    
    public ResourceDecoder getCacheDecoder() {
        return this.cacheDecoder;
    }
    
    public ResourceEncoder getEncoder() {
        return this.encoder;
    }
    
    public ResourceDecoder getSourceDecoder() {
        return this.sourceDecoder;
    }
    
    public Encoder getSourceEncoder() {
        return this.sourceEncoder;
    }
}
