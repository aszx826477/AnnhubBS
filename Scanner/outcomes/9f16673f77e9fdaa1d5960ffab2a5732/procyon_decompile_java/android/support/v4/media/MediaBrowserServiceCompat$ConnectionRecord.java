// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import java.util.HashMap;
import android.os.Bundle;

class MediaBrowserServiceCompat$ConnectionRecord
{
    MediaBrowserServiceCompat$ServiceCallbacks callbacks;
    String pkg;
    MediaBrowserServiceCompat$BrowserRoot root;
    Bundle rootHints;
    HashMap subscriptions;
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    
    MediaBrowserServiceCompat$ConnectionRecord(final MediaBrowserServiceCompat this$0) {
        this.this$0 = this$0;
        this.subscriptions = new HashMap();
    }
}
