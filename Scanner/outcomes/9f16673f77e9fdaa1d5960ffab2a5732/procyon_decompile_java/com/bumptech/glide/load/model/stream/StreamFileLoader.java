// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.Glide;
import android.net.Uri;
import android.content.Context;
import com.bumptech.glide.load.model.FileLoader;

public class StreamFileLoader extends FileLoader implements StreamModelLoader
{
    public StreamFileLoader(final Context context) {
        this(Glide.buildStreamModelLoader(Uri.class, context));
    }
    
    public StreamFileLoader(final ModelLoader modelLoader) {
        super(modelLoader);
    }
}
