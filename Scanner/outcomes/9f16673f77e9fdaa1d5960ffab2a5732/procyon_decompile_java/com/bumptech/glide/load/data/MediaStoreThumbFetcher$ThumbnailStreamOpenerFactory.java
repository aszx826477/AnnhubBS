// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import java.io.IOException;
import java.io.FileNotFoundException;
import android.util.Log;
import java.io.InputStream;
import android.content.Context;
import android.net.Uri;

class MediaStoreThumbFetcher$ThumbnailStreamOpenerFactory
{
    public MediaStoreThumbFetcher$ThumbnailStreamOpener build(final Uri uri, final int n, final int n2) {
        if (!isMediaStoreUri(uri) || n > 512 || n2 > 384) {
            return null;
        }
        if (isMediaStoreVideo(uri)) {
            return new MediaStoreThumbFetcher$ThumbnailStreamOpener(new MediaStoreThumbFetcher$VideoThumbnailQuery());
        }
        return new MediaStoreThumbFetcher$ThumbnailStreamOpener(new MediaStoreThumbFetcher$ImageThumbnailQuery());
    }
}
