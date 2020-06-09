// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Bundle;

class MediaBrowserCompat$MediaBrowserImplBase$5 implements Runnable
{
    final /* synthetic */ MediaBrowserCompat$MediaBrowserImplBase this$0;
    final /* synthetic */ MediaBrowserCompat$SearchCallback val$callback;
    final /* synthetic */ Bundle val$extras;
    final /* synthetic */ String val$query;
    
    MediaBrowserCompat$MediaBrowserImplBase$5(final MediaBrowserCompat$MediaBrowserImplBase this$0, final MediaBrowserCompat$SearchCallback val$callback, final String val$query, final Bundle val$extras) {
        this.this$0 = this$0;
        this.val$callback = val$callback;
        this.val$query = val$query;
        this.val$extras = val$extras;
    }
    
    public void run() {
        this.val$callback.onError(this.val$query, this.val$extras);
    }
}
