// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.data;

import android.provider.MediaStore$Images$Thumbnails;
import android.database.Cursor;
import android.net.Uri;
import android.content.Context;

class MediaStoreThumbFetcher$ImageThumbnailQuery implements MediaStoreThumbFetcher$ThumbnailQuery
{
    private static final String[] PATH_PROJECTION;
    private static final String PATH_SELECTION = "kind = 1 AND image_id = ?";
    
    static {
        PATH_PROJECTION = new String[] { "_data" };
    }
    
    public Cursor queryPath(final Context context, final Uri uri) {
        return context.getContentResolver().query(MediaStore$Images$Thumbnails.EXTERNAL_CONTENT_URI, MediaStoreThumbFetcher$ImageThumbnailQuery.PATH_PROJECTION, "kind = 1 AND image_id = ?", new String[] { uri.getLastPathSegment() }, (String)null);
    }
}
