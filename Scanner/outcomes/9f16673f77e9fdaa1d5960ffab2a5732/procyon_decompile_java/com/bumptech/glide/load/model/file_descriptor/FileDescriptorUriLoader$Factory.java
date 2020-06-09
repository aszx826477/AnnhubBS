// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model.file_descriptor;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import android.content.Context;
import com.bumptech.glide.load.model.ModelLoaderFactory;

public class FileDescriptorUriLoader$Factory implements ModelLoaderFactory
{
    public ModelLoader build(final Context context, final GenericLoaderFactory genericLoaderFactory) {
        return new FileDescriptorUriLoader(context, genericLoaderFactory.buildModelLoader(GlideUrl.class, ParcelFileDescriptor.class));
    }
    
    public void teardown() {
    }
}
