// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.content.ServiceConnection;

class MediaBrowserCompat$MediaBrowserImplBase$1 implements Runnable
{
    final /* synthetic */ MediaBrowserCompat$MediaBrowserImplBase this$0;
    final /* synthetic */ ServiceConnection val$thisConnection;
    
    MediaBrowserCompat$MediaBrowserImplBase$1(final MediaBrowserCompat$MediaBrowserImplBase this$0, final ServiceConnection val$thisConnection) {
        this.this$0 = this$0;
        this.val$thisConnection = val$thisConnection;
    }
    
    public void run() {
        if (this.val$thisConnection == this.this$0.mServiceConnection) {
            this.this$0.forceCloseConnection();
            this.this$0.mCallback.onConnectionFailed();
        }
    }
}
