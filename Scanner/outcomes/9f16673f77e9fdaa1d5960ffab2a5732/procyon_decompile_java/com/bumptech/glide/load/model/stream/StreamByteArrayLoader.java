// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.data.ByteArrayFetcher;
import com.bumptech.glide.load.data.DataFetcher;

public class StreamByteArrayLoader implements StreamModelLoader
{
    private final String id;
    
    public StreamByteArrayLoader() {
        this("");
    }
    
    public StreamByteArrayLoader(final String id) {
        this.id = id;
    }
    
    public DataFetcher getResourceFetcher(final byte[] array, final int n, final int n2) {
        return new ByteArrayFetcher(array, this.id);
    }
}
