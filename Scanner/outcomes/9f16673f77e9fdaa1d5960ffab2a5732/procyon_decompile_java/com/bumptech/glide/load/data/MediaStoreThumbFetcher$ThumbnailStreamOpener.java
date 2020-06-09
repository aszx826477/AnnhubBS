// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.data;

import java.io.InputStream;
import android.util.Log;
import java.io.IOException;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import android.content.Context;
import java.io.File;
import android.text.TextUtils;
import android.net.Uri;
import android.database.Cursor;

class MediaStoreThumbFetcher$ThumbnailStreamOpener
{
    private static final MediaStoreThumbFetcher$FileService DEFAULT_SERVICE;
    private MediaStoreThumbFetcher$ThumbnailQuery query;
    private final MediaStoreThumbFetcher$FileService service;
    
    static {
        DEFAULT_SERVICE = new MediaStoreThumbFetcher$FileService();
    }
    
    public MediaStoreThumbFetcher$ThumbnailStreamOpener(final MediaStoreThumbFetcher$FileService service, final MediaStoreThumbFetcher$ThumbnailQuery query) {
        this.service = service;
        this.query = query;
    }
    
    public MediaStoreThumbFetcher$ThumbnailStreamOpener(final MediaStoreThumbFetcher$ThumbnailQuery mediaStoreThumbFetcher$ThumbnailQuery) {
        this(MediaStoreThumbFetcher$ThumbnailStreamOpener.DEFAULT_SERVICE, mediaStoreThumbFetcher$ThumbnailQuery);
    }
    
    private Uri parseThumbUri(final Cursor cursor) {
        Uri fromFile = null;
        final String string = cursor.getString(0);
        if (!TextUtils.isEmpty((CharSequence)string)) {
            final File value = this.service.get(string);
            if (this.service.exists(value) && this.service.length(value) > 0L) {
                fromFile = Uri.fromFile(value);
            }
        }
        return fromFile;
    }
    
    public int getOrientation(final Context context, final Uri uri) {
        int orientation = -1;
        InputStream openInputStream = null;
        while (true) {
            try {
                try {
                    openInputStream = context.getContentResolver().openInputStream(uri);
                    orientation = new ImageHeaderParser(openInputStream).getOrientation();
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                            return orientation;
                        }
                        catch (IOException ex2) {
                            return orientation;
                        }
                    }
                    Label_0063:;
                }
                finally {
                    if (openInputStream != null) {
                        final InputStream inputStream = openInputStream;
                        inputStream.close();
                    }
                    final String s = "MediaStoreThumbFetcher";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Failed to open uri: ");
                    sb.append(uri);
                    final IOException ex;
                    Log.d(s, sb.toString(), (Throwable)ex);
                    // iftrue(Label_0063:, openInputStream == null)
                    openInputStream.close();
                }
            }
            catch (IOException ex3) {}
            try {
                final InputStream inputStream = openInputStream;
                inputStream.close();
                continue;
            }
            catch (IOException ex4) {}
            break;
        }
    }
    
    public InputStream open(final Context context, final Uri uri) {
        Uri thumbUri = null;
        InputStream openInputStream = null;
        final Cursor queryPath = this.query.queryPath(context, uri);
        if (queryPath != null) {
            try {
                if (queryPath.moveToFirst()) {
                    thumbUri = this.parseThumbUri(queryPath);
                }
            }
            finally {
                if (queryPath != null) {
                    queryPath.close();
                }
            }
        }
        if (queryPath != null) {
            queryPath.close();
        }
        if (thumbUri != null) {
            openInputStream = context.getContentResolver().openInputStream(thumbUri);
        }
        return openInputStream;
    }
}
