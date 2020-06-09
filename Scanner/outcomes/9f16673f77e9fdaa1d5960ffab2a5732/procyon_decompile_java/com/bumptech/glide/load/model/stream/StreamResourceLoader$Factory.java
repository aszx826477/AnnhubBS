// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model.stream;

import java.io.InputStream;
import android.net.Uri;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import android.content.Context;
import com.bumptech.glide.load.model.ModelLoaderFactory;

public class StreamResourceLoader$Factory implements ModelLoaderFactory
{
    public ModelLoader build(final Context context, final GenericLoaderFactory genericLoaderFactory) {
        return new StreamResourceLoader(context, genericLoaderFactory.buildModelLoader(Uri.class, InputStream.class));
    }
    
    public void teardown() {
    }
}
