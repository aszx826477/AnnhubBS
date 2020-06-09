// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.Glide;
import android.net.Uri;
import android.content.Context;
import com.bumptech.glide.load.model.StringLoader;

public class StreamStringLoader extends StringLoader implements StreamModelLoader
{
    public StreamStringLoader(final Context context) {
        this(Glide.buildStreamModelLoader(Uri.class, context));
    }
    
    public StreamStringLoader(final ModelLoader modelLoader) {
        super(modelLoader);
    }
}
