// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;
import android.content.Context;

public abstract class UriLoader implements ModelLoader
{
    private final Context context;
    private final ModelLoader urlLoader;
    
    public UriLoader(final Context context, final ModelLoader urlLoader) {
        this.context = context;
        this.urlLoader = urlLoader;
    }
    
    private static boolean isLocalUri(final String s) {
        return "file".equals(s) || "content".equals(s) || "android.resource".equals(s);
    }
    
    protected abstract DataFetcher getAssetPathFetcher(final Context p0, final String p1);
    
    protected abstract DataFetcher getLocalUriFetcher(final Context p0, final Uri p1);
    
    public final DataFetcher getResourceFetcher(final Uri uri, final int n, final int n2) {
        final String scheme = uri.getScheme();
        DataFetcher dataFetcher = null;
        if (isLocalUri(scheme)) {
            if (AssetUriParser.isAssetUri(uri)) {
                dataFetcher = this.getAssetPathFetcher(this.context, AssetUriParser.toAssetPath(uri));
            }
            else {
                dataFetcher = this.getLocalUriFetcher(this.context, uri);
            }
        }
        else if (this.urlLoader != null && ("http".equals(scheme) || "https".equals(scheme))) {
            dataFetcher = this.urlLoader.getResourceFetcher(new GlideUrl(uri.toString()), n, n2);
        }
        return dataFetcher;
    }
}
