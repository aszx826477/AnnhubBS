// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.Glide;
import android.net.Uri;
import android.content.Context;
import com.bumptech.glide.load.model.ResourceLoader;

public class StreamResourceLoader extends ResourceLoader implements StreamModelLoader
{
    public StreamResourceLoader(final Context context) {
        this(context, Glide.buildStreamModelLoader(Uri.class, context));
    }
    
    public StreamResourceLoader(final Context context, final ModelLoader modelLoader) {
        super(context, modelLoader);
    }
}
