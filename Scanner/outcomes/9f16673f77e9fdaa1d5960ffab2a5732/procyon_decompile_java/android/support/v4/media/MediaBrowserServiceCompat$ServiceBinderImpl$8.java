// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.util.Log;
import android.support.v4.os.ResultReceiver;
import android.os.Bundle;

class MediaBrowserServiceCompat$ServiceBinderImpl$8 implements Runnable
{
    final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    final /* synthetic */ Bundle val$extras;
    final /* synthetic */ String val$query;
    final /* synthetic */ ResultReceiver val$receiver;
    
    MediaBrowserServiceCompat$ServiceBinderImpl$8(final MediaBrowserServiceCompat$ServiceBinderImpl this$1, final MediaBrowserServiceCompat$ServiceCallbacks val$callbacks, final String val$query, final Bundle val$extras, final ResultReceiver val$receiver) {
        this.this$1 = this$1;
        this.val$callbacks = val$callbacks;
        this.val$query = val$query;
        this.val$extras = val$extras;
        this.val$receiver = val$receiver;
    }
    
    public void run() {
        final MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = (MediaBrowserServiceCompat$ConnectionRecord)this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
        if (mediaBrowserServiceCompat$ConnectionRecord == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("search for callback that isn't registered query=");
            sb.append(this.val$query);
            Log.w("MBServiceCompat", sb.toString());
            return;
        }
        this.this$1.this$0.performSearch(this.val$query, this.val$extras, mediaBrowserServiceCompat$ConnectionRecord, this.val$receiver);
    }
}
