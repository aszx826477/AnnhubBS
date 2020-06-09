// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.model.ModelLoader;

public class FixedLoadProvider implements LoadProvider
{
    private final DataLoadProvider dataLoadProvider;
    private final ModelLoader modelLoader;
    private final ResourceTranscoder transcoder;
    
    public FixedLoadProvider(final ModelLoader modelLoader, final ResourceTranscoder transcoder, final DataLoadProvider dataLoadProvider) {
        if (modelLoader == null) {
            throw new NullPointerException("ModelLoader must not be null");
        }
        this.modelLoader = modelLoader;
        if (transcoder == null) {
            throw new NullPointerException("Transcoder must not be null");
        }
        this.transcoder = transcoder;
        if (dataLoadProvider != null) {
            this.dataLoadProvider = dataLoadProvider;
            return;
        }
        throw new NullPointerException("DataLoadProvider must not be null");
    }
    
    public ResourceDecoder getCacheDecoder() {
        return this.dataLoadProvider.getCacheDecoder();
    }
    
    public ResourceEncoder getEncoder() {
        return this.dataLoadProvider.getEncoder();
    }
    
    public ModelLoader getModelLoader() {
        return this.modelLoader;
    }
    
    public ResourceDecoder getSourceDecoder() {
        return this.dataLoadProvider.getSourceDecoder();
    }
    
    public Encoder getSourceEncoder() {
        return this.dataLoadProvider.getSourceEncoder();
    }
    
    public ResourceTranscoder getTranscoder() {
        return this.transcoder;
    }
}
