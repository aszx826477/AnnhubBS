// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;

public class HttpUrlGlideUrlLoader implements ModelLoader
{
    private final ModelCache modelCache;
    
    public HttpUrlGlideUrlLoader() {
        this(null);
    }
    
    public HttpUrlGlideUrlLoader(final ModelCache modelCache) {
        this.modelCache = modelCache;
    }
    
    public DataFetcher getResourceFetcher(final GlideUrl glideUrl, final int n, final int n2) {
        GlideUrl glideUrl2 = glideUrl;
        final ModelCache modelCache = this.modelCache;
        if (modelCache != null) {
            glideUrl2 = (GlideUrl)modelCache.get(glideUrl, 0, 0);
            if (glideUrl2 == null) {
                this.modelCache.put(glideUrl, 0, 0, glideUrl);
                glideUrl2 = glideUrl;
            }
        }
        return new HttpUrlFetcher(glideUrl2);
    }
}
