// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import java.io.InputStream;
import android.net.Uri;
import android.content.Context;

public class StreamLocalUriFetcher extends LocalUriFetcher
{
    public StreamLocalUriFetcher(final Context context, final Uri uri) {
        super(context, uri);
    }
    
    protected void close(final InputStream inputStream) {
        inputStream.close();
    }
    
    protected InputStream loadResource(final Uri uri, final ContentResolver contentResolver) {
        return contentResolver.openInputStream(uri);
    }
}
