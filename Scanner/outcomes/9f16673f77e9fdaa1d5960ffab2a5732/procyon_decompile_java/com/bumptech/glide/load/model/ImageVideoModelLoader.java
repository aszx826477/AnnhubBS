// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import com.bumptech.glide.load.data.DataFetcher;

public class ImageVideoModelLoader implements ModelLoader
{
    private static final String TAG = "IVML";
    private final ModelLoader fileDescriptorLoader;
    private final ModelLoader streamLoader;
    
    public ImageVideoModelLoader(final ModelLoader streamLoader, final ModelLoader fileDescriptorLoader) {
        if (streamLoader == null && fileDescriptorLoader == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.streamLoader = streamLoader;
        this.fileDescriptorLoader = fileDescriptorLoader;
    }
    
    public DataFetcher getResourceFetcher(final Object o, final int n, final int n2) {
        DataFetcher resourceFetcher = null;
        final ModelLoader streamLoader = this.streamLoader;
        if (streamLoader != null) {
            resourceFetcher = streamLoader.getResourceFetcher(o, n, n2);
        }
        DataFetcher resourceFetcher2 = null;
        final ModelLoader fileDescriptorLoader = this.fileDescriptorLoader;
        if (fileDescriptorLoader != null) {
            resourceFetcher2 = fileDescriptorLoader.getResourceFetcher(o, n, n2);
        }
        if (resourceFetcher == null && resourceFetcher2 == null) {
            return null;
        }
        return new ImageVideoModelLoader$ImageVideoFetcher(resourceFetcher, resourceFetcher2);
    }
}
