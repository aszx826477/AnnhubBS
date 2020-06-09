// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

class MediaBrowserServiceCompat$ServiceBinderImpl$7 implements Runnable
{
    final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    
    MediaBrowserServiceCompat$ServiceBinderImpl$7(final MediaBrowserServiceCompat$ServiceBinderImpl this$1, final MediaBrowserServiceCompat$ServiceCallbacks val$callbacks) {
        this.this$1 = this$1;
        this.val$callbacks = val$callbacks;
    }
    
    public void run() {
        this.this$1.this$0.mConnections.remove(this.val$callbacks.asBinder());
    }
}
