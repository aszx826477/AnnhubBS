// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Parcel;
import android.media.browse.MediaBrowser$MediaItem;
import android.media.browse.MediaBrowser$ItemCallback;

class MediaBrowserCompatApi23$ItemCallbackProxy extends MediaBrowser$ItemCallback
{
    protected final MediaBrowserCompatApi23$ItemCallback mItemCallback;
    
    public MediaBrowserCompatApi23$ItemCallbackProxy(final MediaBrowserCompatApi23$ItemCallback mItemCallback) {
        this.mItemCallback = mItemCallback;
    }
    
    public void onError(final String s) {
        this.mItemCallback.onError(s);
    }
    
    public void onItemLoaded(final MediaBrowser$MediaItem mediaBrowser$MediaItem) {
        if (mediaBrowser$MediaItem == null) {
            this.mItemCallback.onItemLoaded(null);
        }
        else {
            final Parcel obtain = Parcel.obtain();
            mediaBrowser$MediaItem.writeToParcel(obtain, 0);
            this.mItemCallback.onItemLoaded(obtain);
        }
    }
}
