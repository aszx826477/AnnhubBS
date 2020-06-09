// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.util.Log;
import android.os.IBinder;

class MediaBrowserServiceCompat$ServiceBinderImpl$4 implements Runnable
{
    final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    final /* synthetic */ String val$id;
    final /* synthetic */ IBinder val$token;
    
    MediaBrowserServiceCompat$ServiceBinderImpl$4(final MediaBrowserServiceCompat$ServiceBinderImpl this$1, final MediaBrowserServiceCompat$ServiceCallbacks val$callbacks, final String val$id, final IBinder val$token) {
        this.this$1 = this$1;
        this.val$callbacks = val$callbacks;
        this.val$id = val$id;
        this.val$token = val$token;
    }
    
    public void run() {
        final MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = (MediaBrowserServiceCompat$ConnectionRecord)this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
        if (mediaBrowserServiceCompat$ConnectionRecord == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("removeSubscription for callback that isn't registered id=");
            sb.append(this.val$id);
            Log.w("MBServiceCompat", sb.toString());
            return;
        }
        if (!this.this$1.this$0.removeSubscription(this.val$id, mediaBrowserServiceCompat$ConnectionRecord, this.val$token)) {
            final String s = "MBServiceCompat";
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("removeSubscription called for ");
            sb2.append(this.val$id);
            sb2.append(" which is not subscribed");
            Log.w(s, sb2.toString());
        }
    }
}
