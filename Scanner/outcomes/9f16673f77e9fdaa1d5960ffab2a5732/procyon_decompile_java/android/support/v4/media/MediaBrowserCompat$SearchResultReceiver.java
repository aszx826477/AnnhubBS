// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Parcelable;
import java.util.List;
import java.util.ArrayList;
import android.os.Handler;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

class MediaBrowserCompat$SearchResultReceiver extends ResultReceiver
{
    private final MediaBrowserCompat$SearchCallback mCallback;
    private final Bundle mExtras;
    private final String mQuery;
    
    MediaBrowserCompat$SearchResultReceiver(final String mQuery, final Bundle mExtras, final MediaBrowserCompat$SearchCallback mCallback, final Handler handler) {
        super(handler);
        this.mQuery = mQuery;
        this.mExtras = mExtras;
        this.mCallback = mCallback;
    }
    
    protected void onReceiveResult(final int n, final Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
        }
        if (n == 0 && bundle != null && bundle.containsKey("search_results")) {
            final Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            List<MediaBrowserCompat$MediaItem> list = null;
            if (parcelableArray != null) {
                list = new ArrayList<MediaBrowserCompat$MediaItem>();
                for (int length = parcelableArray.length, i = 0; i < length; ++i) {
                    list.add((MediaBrowserCompat$MediaItem)parcelableArray[i]);
                }
            }
            this.mCallback.onSearchResult(this.mQuery, this.mExtras, list);
            return;
        }
        this.mCallback.onError(this.mQuery, this.mExtras);
    }
}
