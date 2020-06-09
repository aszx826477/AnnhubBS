// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.media.browse.MediaBrowser$ConnectionCallback;

class MediaBrowserCompatApi21$ConnectionCallbackProxy extends MediaBrowser$ConnectionCallback
{
    protected final MediaBrowserCompatApi21$ConnectionCallback mConnectionCallback;
    
    public MediaBrowserCompatApi21$ConnectionCallbackProxy(final MediaBrowserCompatApi21$ConnectionCallback mConnectionCallback) {
        this.mConnectionCallback = mConnectionCallback;
    }
    
    public void onConnected() {
        this.mConnectionCallback.onConnected();
    }
    
    public void onConnectionFailed() {
        this.mConnectionCallback.onConnectionFailed();
    }
    
    public void onConnectionSuspended() {
        this.mConnectionCallback.onConnectionSuspended();
    }
}
