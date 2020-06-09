// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

class MediaBrowserServiceCompat$4 extends MediaBrowserServiceCompat$Result
{
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    final /* synthetic */ ResultReceiver val$receiver;
    
    MediaBrowserServiceCompat$4(final MediaBrowserServiceCompat this$0, final Object o, final ResultReceiver val$receiver) {
        this.this$0 = this$0;
        this.val$receiver = val$receiver;
        super(o);
    }
    
    void onErrorSent(final Bundle bundle) {
        this.val$receiver.send(-1, bundle);
    }
    
    void onProgressUpdateSent(final Bundle bundle) {
        this.val$receiver.send(1, bundle);
    }
    
    void onResultSent(final Bundle bundle) {
        this.val$receiver.send(0, bundle);
    }
}
