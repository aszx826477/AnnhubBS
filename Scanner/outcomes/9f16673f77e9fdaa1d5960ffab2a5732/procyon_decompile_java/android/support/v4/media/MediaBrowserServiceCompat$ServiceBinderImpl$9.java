// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.util.Log;
import android.support.v4.os.ResultReceiver;
import android.os.Bundle;

class MediaBrowserServiceCompat$ServiceBinderImpl$9 implements Runnable
{
    final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    final /* synthetic */ String val$action;
    final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    final /* synthetic */ Bundle val$extras;
    final /* synthetic */ ResultReceiver val$receiver;
    
    MediaBrowserServiceCompat$ServiceBinderImpl$9(final MediaBrowserServiceCompat$ServiceBinderImpl this$1, final MediaBrowserServiceCompat$ServiceCallbacks val$callbacks, final String val$action, final Bundle val$extras, final ResultReceiver val$receiver) {
        this.this$1 = this$1;
        this.val$callbacks = val$callbacks;
        this.val$action = val$action;
        this.val$extras = val$extras;
        this.val$receiver = val$receiver;
    }
    
    public void run() {
        final MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = (MediaBrowserServiceCompat$ConnectionRecord)this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
        if (mediaBrowserServiceCompat$ConnectionRecord == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("sendCustomAction for callback that isn't registered action=");
            sb.append(this.val$action);
            sb.append(", extras=");
            sb.append(this.val$extras);
            Log.w("MBServiceCompat", sb.toString());
            return;
        }
        this.this$1.this$0.performCustomAction(this.val$action, this.val$extras, mediaBrowserServiceCompat$ConnectionRecord, this.val$receiver);
    }
}
