// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Bundle;

class MediaBrowserCompat$MediaBrowserImplApi21$7 implements Runnable
{
    final /* synthetic */ MediaBrowserCompat$MediaBrowserImplApi21 this$0;
    final /* synthetic */ String val$action;
    final /* synthetic */ MediaBrowserCompat$CustomActionCallback val$callback;
    final /* synthetic */ Bundle val$extras;
    
    MediaBrowserCompat$MediaBrowserImplApi21$7(final MediaBrowserCompat$MediaBrowserImplApi21 this$0, final MediaBrowserCompat$CustomActionCallback val$callback, final String val$action, final Bundle val$extras) {
        this.this$0 = this$0;
        this.val$callback = val$callback;
        this.val$action = val$action;
        this.val$extras = val$extras;
    }
    
    public void run() {
        this.val$callback.onError(this.val$action, this.val$extras, null);
    }
}
