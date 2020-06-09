// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model.file_descriptor;

import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;
import android.net.Uri;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import android.content.Context;
import com.bumptech.glide.load.model.UriLoader;

public class FileDescriptorUriLoader extends UriLoader implements FileDescriptorModelLoader
{
    public FileDescriptorUriLoader(final Context context) {
        this(context, Glide.buildFileDescriptorModelLoader(GlideUrl.class, context));
    }
    
    public FileDescriptorUriLoader(final Context context, final ModelLoader modelLoader) {
        super(context, modelLoader);
    }
    
    protected DataFetcher getAssetPathFetcher(final Context context, final String s) {
        return new FileDescriptorAssetPathFetcher(context.getApplicationContext().getAssets(), s);
    }
    
    protected DataFetcher getLocalUriFetcher(final Context context, final Uri uri) {
        return new FileDescriptorLocalUriFetcher(context, uri);
    }
}
