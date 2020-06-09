// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Build$VERSION;

public class MediaBrowserCompat$ConnectionCallback
{
    MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal mConnectionCallbackInternal;
    final Object mConnectionCallbackObj;
    
    public MediaBrowserCompat$ConnectionCallback() {
        if (Build$VERSION.SDK_INT >= 21) {
            this.mConnectionCallbackObj = MediaBrowserCompatApi21.createConnectionCallback(new MediaBrowserCompat$ConnectionCallback$StubApi21(this));
        }
        else {
            this.mConnectionCallbackObj = null;
        }
    }
    
    public void onConnected() {
    }
    
    public void onConnectionFailed() {
    }
    
    public void onConnectionSuspended() {
    }
    
    void setInternalConnectionCallback(final MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal mConnectionCallbackInternal) {
        this.mConnectionCallbackInternal = mConnectionCallbackInternal;
    }
}
