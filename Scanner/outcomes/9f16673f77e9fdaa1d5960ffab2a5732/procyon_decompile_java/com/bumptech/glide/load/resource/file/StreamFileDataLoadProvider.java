// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.resource.NullResourceEncoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.provider.DataLoadProvider;

public class StreamFileDataLoadProvider implements DataLoadProvider
{
    private static final StreamFileDataLoadProvider$ErrorSourceDecoder ERROR_DECODER;
    private final ResourceDecoder cacheDecoder;
    private final Encoder encoder;
    
    static {
        ERROR_DECODER = new StreamFileDataLoadProvider$ErrorSourceDecoder(null);
    }
    
    public StreamFileDataLoadProvider() {
        this.cacheDecoder = new FileDecoder();
        this.encoder = new StreamEncoder();
    }
    
    public ResourceDecoder getCacheDecoder() {
        return this.cacheDecoder;
    }
    
    public ResourceEncoder getEncoder() {
        return NullResourceEncoder.get();
    }
    
    public ResourceDecoder getSourceDecoder() {
        return StreamFileDataLoadProvider.ERROR_DECODER;
    }
    
    public Encoder getSourceEncoder() {
        return this.encoder;
    }
}
