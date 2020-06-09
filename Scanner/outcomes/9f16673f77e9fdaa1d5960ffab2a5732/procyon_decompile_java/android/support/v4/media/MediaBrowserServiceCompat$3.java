// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Parcelable;
import android.os.Bundle;
import java.util.List;
import android.support.v4.os.ResultReceiver;

class MediaBrowserServiceCompat$3 extends MediaBrowserServiceCompat$Result
{
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    final /* synthetic */ ResultReceiver val$receiver;
    
    MediaBrowserServiceCompat$3(final MediaBrowserServiceCompat this$0, final Object o, final ResultReceiver val$receiver) {
        this.this$0 = this$0;
        this.val$receiver = val$receiver;
        super(o);
    }
    
    void onResultSent(final List list) {
        if ((this.getFlags() & 0x4) == 0x0 && list != null) {
            final Bundle bundle = new Bundle();
            bundle.putParcelableArray("search_results", (Parcelable[])list.toArray(new MediaBrowserCompat$MediaItem[0]));
            this.val$receiver.send(0, bundle);
            return;
        }
        this.val$receiver.send(-1, null);
    }
}
