// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import android.net.Uri;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import android.content.Context;
import com.bumptech.glide.load.model.UriLoader;

public class StreamUriLoader extends UriLoader implements StreamModelLoader
{
    public StreamUriLoader(final Context context) {
        this(context, Glide.buildStreamModelLoader(GlideUrl.class, context));
    }
    
    public StreamUriLoader(final Context context, final ModelLoader modelLoader) {
        super(context, modelLoader);
    }
    
    protected DataFetcher getAssetPathFetcher(final Context context, final String s) {
        return new StreamAssetPathFetcher(context.getApplicationContext().getAssets(), s);
    }
    
    protected DataFetcher getLocalUriFetcher(final Context context, final Uri uri) {
        return new StreamLocalUriFetcher(context, uri);
    }
}
