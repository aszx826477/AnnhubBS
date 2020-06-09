// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.util.Log;
import android.os.IBinder;
import android.os.Bundle;

class MediaBrowserServiceCompat$ServiceBinderImpl$3 implements Runnable
{
    final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    final /* synthetic */ String val$id;
    final /* synthetic */ Bundle val$options;
    final /* synthetic */ IBinder val$token;
    
    MediaBrowserServiceCompat$ServiceBinderImpl$3(final MediaBrowserServiceCompat$ServiceBinderImpl this$1, final MediaBrowserServiceCompat$ServiceCallbacks val$callbacks, final String val$id, final IBinder val$token, final Bundle val$options) {
        this.this$1 = this$1;
        this.val$callbacks = val$callbacks;
        this.val$id = val$id;
        this.val$token = val$token;
        this.val$options = val$options;
    }
    
    public void run() {
        final MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = (MediaBrowserServiceCompat$ConnectionRecord)this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
        if (mediaBrowserServiceCompat$ConnectionRecord == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("addSubscription for callback that isn't registered id=");
            sb.append(this.val$id);
            Log.w("MBServiceCompat", sb.toString());
            return;
        }
        this.this$1.this$0.addSubscription(this.val$id, mediaBrowserServiceCompat$ConnectionRecord, this.val$token, this.val$options);
    }
}
