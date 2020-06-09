// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model.file_descriptor;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.Glide;
import android.net.Uri;
import android.content.Context;
import com.bumptech.glide.load.model.ResourceLoader;

public class FileDescriptorResourceLoader extends ResourceLoader implements FileDescriptorModelLoader
{
    public FileDescriptorResourceLoader(final Context context) {
        this(context, Glide.buildFileDescriptorModelLoader(Uri.class, context));
    }
    
    public FileDescriptorResourceLoader(final Context context, final ModelLoader modelLoader) {
        super(context, modelLoader);
    }
}
