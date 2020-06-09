// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import java.io.IOException;
import java.io.FileNotFoundException;
import android.util.Log;
import android.net.Uri;
import java.io.InputStream;
import android.content.Context;

public class MediaStoreThumbFetcher implements DataFetcher
{
    private static final MediaStoreThumbFetcher$ThumbnailStreamOpenerFactory DEFAULT_FACTORY;
    private static final int MINI_HEIGHT = 384;
    private static final int MINI_WIDTH = 512;
    private static final String TAG = "MediaStoreThumbFetcher";
    private final Context context;
    private final DataFetcher defaultFetcher;
    private final MediaStoreThumbFetcher$ThumbnailStreamOpenerFactory factory;
    private final int height;
    private InputStream inputStream;
    private final Uri mediaStoreUri;
    private final int width;
    
    static {
        DEFAULT_FACTORY = new MediaStoreThumbFetcher$ThumbnailStreamOpenerFactory();
    }
    
    public MediaStoreThumbFetcher(final Context context, final Uri uri, final DataFetcher dataFetcher, final int n, final int n2) {
        this(context, uri, dataFetcher, n, n2, MediaStoreThumbFetcher.DEFAULT_FACTORY);
    }
    
    MediaStoreThumbFetcher(final Context context, final Uri mediaStoreUri, final DataFetcher defaultFetcher, final int width, final int height, final MediaStoreThumbFetcher$ThumbnailStreamOpenerFactory factory) {
        this.context = context;
        this.mediaStoreUri = mediaStoreUri;
        this.defaultFetcher = defaultFetcher;
        this.width = width;
        this.height = height;
        this.factory = factory;
    }
    
    private static boolean isMediaStoreUri(final Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }
    
    private static boolean isMediaStoreVideo(final Uri uri) {
        return isMediaStoreUri(uri) && uri.getPathSegments().contains("video");
    }
    
    private InputStream openThumbInputStream(final MediaStoreThumbFetcher$ThumbnailStreamOpener mediaStoreThumbFetcher$ThumbnailStreamOpener) {
        InputStream open = null;
        try {
            final Context context = this.context;
            try {
                open = mediaStoreThumbFetcher$ThumbnailStreamOpener.open(context, this.mediaStoreUri);
            }
            catch (FileNotFoundException ex) {
                if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                    Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", (Throwable)ex);
                }
            }
        }
        catch (FileNotFoundException ex2) {}
        int orientation = -1;
        if (open != null) {
            orientation = mediaStoreThumbFetcher$ThumbnailStreamOpener.getOrientation(this.context, this.mediaStoreUri);
        }
        if (orientation != -1) {
            open = new ExifOrientationStream(open, orientation);
        }
        return open;
    }
    
    public void cancel() {
    }
    
    public void cleanup() {
        final InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            }
            catch (IOException ex) {}
        }
        this.defaultFetcher.cleanup();
    }
    
    public String getId() {
        return this.mediaStoreUri.toString();
    }
    
    public InputStream loadData(final Priority priority) {
        final MediaStoreThumbFetcher$ThumbnailStreamOpener build = this.factory.build(this.mediaStoreUri, this.width, this.height);
        if (build != null) {
            this.inputStream = this.openThumbInputStream(build);
        }
        if (this.inputStream == null) {
            this.inputStream = (InputStream)this.defaultFetcher.loadData(priority);
        }
        return this.inputStream;
    }
}
