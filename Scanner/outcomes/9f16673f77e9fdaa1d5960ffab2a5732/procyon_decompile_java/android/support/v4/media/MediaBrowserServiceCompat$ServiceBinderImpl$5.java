// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.util.Log;
import android.support.v4.os.ResultReceiver;

class MediaBrowserServiceCompat$ServiceBinderImpl$5 implements Runnable
{
    final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    final /* synthetic */ String val$mediaId;
    final /* synthetic */ ResultReceiver val$receiver;
    
    MediaBrowserServiceCompat$ServiceBinderImpl$5(final MediaBrowserServiceCompat$ServiceBinderImpl this$1, final MediaBrowserServiceCompat$ServiceCallbacks val$callbacks, final String val$mediaId, final ResultReceiver val$receiver) {
        this.this$1 = this$1;
        this.val$callbacks = val$callbacks;
        this.val$mediaId = val$mediaId;
        this.val$receiver = val$receiver;
    }
    
    public void run() {
        final MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = (MediaBrowserServiceCompat$ConnectionRecord)this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
        if (mediaBrowserServiceCompat$ConnectionRecord == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("getMediaItem for callback that isn't registered id=");
            sb.append(this.val$mediaId);
            Log.w("MBServiceCompat", sb.toString());
            return;
        }
        this.this$1.this$0.performLoadItem(this.val$mediaId, mediaBrowserServiceCompat$ConnectionRecord, this.val$receiver);
    }
}
