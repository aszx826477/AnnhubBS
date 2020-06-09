// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.Priority;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.data.DataFetcher;

class GifFrameModelLoader$GifFrameDataFetcher implements DataFetcher
{
    private final GifDecoder decoder;
    
    public GifFrameModelLoader$GifFrameDataFetcher(final GifDecoder decoder) {
        this.decoder = decoder;
    }
    
    public void cancel() {
    }
    
    public void cleanup() {
    }
    
    public String getId() {
        return String.valueOf(this.decoder.getCurrentFrameIndex());
    }
    
    public GifDecoder loadData(final Priority priority) {
        return this.decoder;
    }
}
