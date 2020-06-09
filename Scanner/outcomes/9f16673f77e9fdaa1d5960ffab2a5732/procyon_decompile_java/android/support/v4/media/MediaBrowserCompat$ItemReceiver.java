// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Parcelable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.os.ResultReceiver;

class MediaBrowserCompat$ItemReceiver extends ResultReceiver
{
    private final MediaBrowserCompat$ItemCallback mCallback;
    private final String mMediaId;
    
    MediaBrowserCompat$ItemReceiver(final String mMediaId, final MediaBrowserCompat$ItemCallback mCallback, final Handler handler) {
        super(handler);
        this.mMediaId = mMediaId;
        this.mCallback = mCallback;
    }
    
    protected void onReceiveResult(final int n, final Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
        }
        if (n == 0 && bundle != null && bundle.containsKey("media_item")) {
            final Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable != null && !(parcelable instanceof MediaBrowserCompat$MediaItem)) {
                this.mCallback.onError(this.mMediaId);
            }
            else {
                this.mCallback.onItemLoaded((MediaBrowserCompat$MediaItem)parcelable);
            }
            return;
        }
        this.mCallback.onError(this.mMediaId);
    }
}
