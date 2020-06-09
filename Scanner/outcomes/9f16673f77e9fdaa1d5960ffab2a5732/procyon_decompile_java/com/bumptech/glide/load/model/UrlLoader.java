// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import java.net.URL;
import com.bumptech.glide.load.data.DataFetcher;

public class UrlLoader implements ModelLoader
{
    private final ModelLoader glideUrlLoader;
    
    public UrlLoader(final ModelLoader glideUrlLoader) {
        this.glideUrlLoader = glideUrlLoader;
    }
    
    public DataFetcher getResourceFetcher(final URL url, final int n, final int n2) {
        return this.glideUrlLoader.getResourceFetcher(new GlideUrl(url), n, n2);
    }
}
