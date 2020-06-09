// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.model.ModelLoader;

class GifFrameModelLoader implements ModelLoader
{
    public DataFetcher getResourceFetcher(final GifDecoder gifDecoder, final int n, final int n2) {
        return new GifFrameModelLoader$GifFrameDataFetcher(gifDecoder);
    }
}
