// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.data.MediaStoreThumbFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import android.net.Uri;
import android.content.Context;
import com.bumptech.glide.load.model.ModelLoader;

public class MediaStoreStreamLoader implements ModelLoader
{
    private final Context context;
    private final ModelLoader uriLoader;
    
    public MediaStoreStreamLoader(final Context context, final ModelLoader uriLoader) {
        this.context = context;
        this.uriLoader = uriLoader;
    }
    
    public DataFetcher getResourceFetcher(final Uri uri, final int n, final int n2) {
        return new MediaStoreThumbFetcher(this.context, uri, this.uriLoader.getResourceFetcher(uri, n, n2), n, n2);
    }
}
