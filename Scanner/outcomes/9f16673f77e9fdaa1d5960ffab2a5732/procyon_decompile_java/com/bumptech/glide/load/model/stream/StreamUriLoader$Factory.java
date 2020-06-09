// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model.stream;

import java.io.InputStream;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import android.content.Context;
import com.bumptech.glide.load.model.ModelLoaderFactory;

public class StreamUriLoader$Factory implements ModelLoaderFactory
{
    public ModelLoader build(final Context context, final GenericLoaderFactory genericLoaderFactory) {
        return new StreamUriLoader(context, genericLoaderFactory.buildModelLoader(GlideUrl.class, InputStream.class));
    }
    
    public void teardown() {
    }
}
