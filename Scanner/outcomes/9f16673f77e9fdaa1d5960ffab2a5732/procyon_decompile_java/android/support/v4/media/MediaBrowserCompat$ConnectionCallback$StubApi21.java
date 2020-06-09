// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

class MediaBrowserCompat$ConnectionCallback$StubApi21 implements MediaBrowserCompatApi21$ConnectionCallback
{
    final /* synthetic */ MediaBrowserCompat$ConnectionCallback this$0;
    
    MediaBrowserCompat$ConnectionCallback$StubApi21(final MediaBrowserCompat$ConnectionCallback this$0) {
        this.this$0 = this$0;
    }
    
    public void onConnected() {
        if (this.this$0.mConnectionCallbackInternal != null) {
            this.this$0.mConnectionCallbackInternal.onConnected();
        }
        this.this$0.onConnected();
    }
    
    public void onConnectionFailed() {
        if (this.this$0.mConnectionCallbackInternal != null) {
            this.this$0.mConnectionCallbackInternal.onConnectionFailed();
        }
        this.this$0.onConnectionFailed();
    }
    
    public void onConnectionSuspended() {
        if (this.this$0.mConnectionCallbackInternal != null) {
            this.this$0.mConnectionCallbackInternal.onConnectionSuspended();
        }
        this.this$0.onConnectionSuspended();
    }
}
