// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.os.ParcelFileDescriptor;
import android.net.Uri;
import android.content.Context;

public class FileDescriptorLocalUriFetcher extends LocalUriFetcher
{
    public FileDescriptorLocalUriFetcher(final Context context, final Uri uri) {
        super(context, uri);
    }
    
    protected void close(final ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }
    
    protected ParcelFileDescriptor loadResource(final Uri uri, final ContentResolver contentResolver) {
        return contentResolver.openAssetFileDescriptor(uri, "r").getParcelFileDescriptor();
    }
}
