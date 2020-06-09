// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.provider;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.ResourceDecoder;

public class ChildLoadProvider implements LoadProvider, Cloneable
{
    private ResourceDecoder cacheDecoder;
    private ResourceEncoder encoder;
    private final LoadProvider parent;
    private ResourceDecoder sourceDecoder;
    private Encoder sourceEncoder;
    private ResourceTranscoder transcoder;
    
    public ChildLoadProvider(final LoadProvider parent) {
        this.parent = parent;
    }
    
    public ChildLoadProvider clone() {
        try {
            final Object clone = super.clone();
            try {
                return (ChildLoadProvider)clone;
            }
            catch (CloneNotSupportedException ex) {
                throw new RuntimeException(ex);
            }
        }
        catch (CloneNotSupportedException ex2) {}
    }
    
    public ResourceDecoder getCacheDecoder() {
        final ResourceDecoder cacheDecoder = this.cacheDecoder;
        if (cacheDecoder != null) {
            return cacheDecoder;
        }
        return this.parent.getCacheDecoder();
    }
    
    public ResourceEncoder getEncoder() {
        final ResourceEncoder encoder = this.encoder;
        if (encoder != null) {
            return encoder;
        }
        return this.parent.getEncoder();
    }
    
    public ModelLoader getModelLoader() {
        return this.parent.getModelLoader();
    }
    
    public ResourceDecoder getSourceDecoder() {
        final ResourceDecoder sourceDecoder = this.sourceDecoder;
        if (sourceDecoder != null) {
            return sourceDecoder;
        }
        return this.parent.getSourceDecoder();
    }
    
    public Encoder getSourceEncoder() {
        final Encoder sourceEncoder = this.sourceEncoder;
        if (sourceEncoder != null) {
            return sourceEncoder;
        }
        return this.parent.getSourceEncoder();
    }
    
    public ResourceTranscoder getTranscoder() {
        final ResourceTranscoder transcoder = this.transcoder;
        if (transcoder != null) {
            return transcoder;
        }
        return this.parent.getTranscoder();
    }
    
    public void setCacheDecoder(final ResourceDecoder cacheDecoder) {
        this.cacheDecoder = cacheDecoder;
    }
    
    public void setEncoder(final ResourceEncoder encoder) {
        this.encoder = encoder;
    }
    
    public void setSourceDecoder(final ResourceDecoder sourceDecoder) {
        this.sourceDecoder = sourceDecoder;
    }
    
    public void setSourceEncoder(final Encoder sourceEncoder) {
        this.sourceEncoder = sourceEncoder;
    }
    
    public void setTranscoder(final ResourceTranscoder transcoder) {
        this.transcoder = transcoder;
    }
}
