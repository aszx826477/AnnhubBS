// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model.file_descriptor;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.Glide;
import android.net.Uri;
import android.content.Context;
import com.bumptech.glide.load.model.FileLoader;

public class FileDescriptorFileLoader extends FileLoader implements FileDescriptorModelLoader
{
    public FileDescriptorFileLoader(final Context context) {
        this(Glide.buildFileDescriptorModelLoader(Uri.class, context));
    }
    
    public FileDescriptorFileLoader(final ModelLoader modelLoader) {
        super(modelLoader);
    }
}
