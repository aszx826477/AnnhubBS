// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.data;

import java.io.InputStream;
import android.content.res.AssetManager;

public class StreamAssetPathFetcher extends AssetPathFetcher
{
    public StreamAssetPathFetcher(final AssetManager assetManager, final String s) {
        super(assetManager, s);
    }
    
    protected void close(final InputStream inputStream) {
        inputStream.close();
    }
    
    protected InputStream loadResource(final AssetManager assetManager, final String s) {
        return assetManager.open(s);
    }
}
