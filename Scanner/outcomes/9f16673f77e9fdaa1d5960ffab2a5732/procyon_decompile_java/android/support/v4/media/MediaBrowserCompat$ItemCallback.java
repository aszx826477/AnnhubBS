// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Build$VERSION;

public abstract class MediaBrowserCompat$ItemCallback
{
    final Object mItemCallbackObj;
    
    public MediaBrowserCompat$ItemCallback() {
        if (Build$VERSION.SDK_INT >= 23) {
            this.mItemCallbackObj = MediaBrowserCompatApi23.createItemCallback(new MediaBrowserCompat$ItemCallback$StubApi23(this));
        }
        else {
            this.mItemCallbackObj = null;
        }
    }
    
    public void onError(final String s) {
    }
    
    public void onItemLoaded(final MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem) {
    }
}
