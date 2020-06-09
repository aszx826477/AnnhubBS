// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import android.content.Context;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoaderFactory;

public class HttpUrlGlideUrlLoader$Factory implements ModelLoaderFactory
{
    private final ModelCache modelCache;
    
    public HttpUrlGlideUrlLoader$Factory() {
        this.modelCache = new ModelCache(500);
    }
    
    public ModelLoader build(final Context context, final GenericLoaderFactory genericLoaderFactory) {
        return new HttpUrlGlideUrlLoader(this.modelCache);
    }
    
    public void teardown() {
    }
}
