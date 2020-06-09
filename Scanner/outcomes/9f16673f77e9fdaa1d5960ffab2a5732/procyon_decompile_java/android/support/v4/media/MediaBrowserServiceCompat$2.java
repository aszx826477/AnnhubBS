// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Parcelable;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

class MediaBrowserServiceCompat$2 extends MediaBrowserServiceCompat$Result
{
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    final /* synthetic */ ResultReceiver val$receiver;
    
    MediaBrowserServiceCompat$2(final MediaBrowserServiceCompat this$0, final Object o, final ResultReceiver val$receiver) {
        this.this$0 = this$0;
        this.val$receiver = val$receiver;
        super(o);
    }
    
    void onResultSent(final MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem) {
        if ((this.getFlags() & 0x2) != 0x0) {
            this.val$receiver.send(-1, null);
            return;
        }
        final Bundle bundle = new Bundle();
        bundle.putParcelable("media_item", (Parcelable)mediaBrowserCompat$MediaItem);
        this.val$receiver.send(0, bundle);
    }
}
