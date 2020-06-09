// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.model.ImageVideoWrapperEncoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.provider.DataLoadProvider;

public class ImageVideoDataLoadProvider implements DataLoadProvider
{
    private final ResourceDecoder cacheDecoder;
    private final ResourceEncoder encoder;
    private final ImageVideoBitmapDecoder sourceDecoder;
    private final ImageVideoWrapperEncoder sourceEncoder;
    
    public ImageVideoDataLoadProvider(final DataLoadProvider dataLoadProvider, final DataLoadProvider dataLoadProvider2) {
        this.encoder = dataLoadProvider.getEncoder();
        this.sourceEncoder = new ImageVideoWrapperEncoder(dataLoadProvider.getSourceEncoder(), dataLoadProvider2.getSourceEncoder());
        this.cacheDecoder = dataLoadProvider.getCacheDecoder();
        this.sourceDecoder = new ImageVideoBitmapDecoder(dataLoadProvider.getSourceDecoder(), dataLoadProvider2.getSourceDecoder());
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
