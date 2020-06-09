// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import android.content.res.AssetManager;

public class FileDescriptorAssetPathFetcher extends AssetPathFetcher
{
    public FileDescriptorAssetPathFetcher(final AssetManager assetManager, final String s) {
        super(assetManager, s);
    }
    
    protected void close(final ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }
    
    protected ParcelFileDescriptor loadResource(final AssetManager assetManager, final String s) {
        return assetManager.openFd(s).getParcelFileDescriptor();
    }
}
