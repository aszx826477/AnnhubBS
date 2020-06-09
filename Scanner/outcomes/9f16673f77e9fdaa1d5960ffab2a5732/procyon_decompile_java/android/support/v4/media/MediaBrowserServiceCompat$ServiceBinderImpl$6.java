// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.IBinder;
import android.os.Bundle;

class MediaBrowserServiceCompat$ServiceBinderImpl$6 implements Runnable
{
    final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    final /* synthetic */ Bundle val$rootHints;
    
    MediaBrowserServiceCompat$ServiceBinderImpl$6(final MediaBrowserServiceCompat$ServiceBinderImpl this$1, final MediaBrowserServiceCompat$ServiceCallbacks val$callbacks, final Bundle val$rootHints) {
        this.this$1 = this$1;
        this.val$callbacks = val$callbacks;
        this.val$rootHints = val$rootHints;
    }
    
    public void run() {
        final IBinder binder = this.val$callbacks.asBinder();
        this.this$1.this$0.mConnections.remove(binder);
        final MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = new MediaBrowserServiceCompat$ConnectionRecord(this.this$1.this$0);
        mediaBrowserServiceCompat$ConnectionRecord.callbacks = this.val$callbacks;
        mediaBrowserServiceCompat$ConnectionRecord.rootHints = this.val$rootHints;
        this.this$1.this$0.mConnections.put(binder, mediaBrowserServiceCompat$ConnectionRecord);
    }
}
