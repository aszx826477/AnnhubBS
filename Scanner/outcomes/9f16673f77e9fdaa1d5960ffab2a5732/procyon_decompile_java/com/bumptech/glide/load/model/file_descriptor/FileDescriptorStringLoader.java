// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model.file_descriptor;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.Glide;
import android.net.Uri;
import android.content.Context;
import com.bumptech.glide.load.model.StringLoader;

public class FileDescriptorStringLoader extends StringLoader implements FileDescriptorModelLoader
{
    public FileDescriptorStringLoader(final Context context) {
        this(Glide.buildFileDescriptorModelLoader(Uri.class, context));
    }
    
    public FileDescriptorStringLoader(final ModelLoader modelLoader) {
        super(modelLoader);
    }
}
