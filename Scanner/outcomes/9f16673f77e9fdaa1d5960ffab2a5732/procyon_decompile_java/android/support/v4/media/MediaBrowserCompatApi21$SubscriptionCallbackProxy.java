// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import java.util.List;
import android.media.browse.MediaBrowser$SubscriptionCallback;

class MediaBrowserCompatApi21$SubscriptionCallbackProxy extends MediaBrowser$SubscriptionCallback
{
    protected final MediaBrowserCompatApi21$SubscriptionCallback mSubscriptionCallback;
    
    public MediaBrowserCompatApi21$SubscriptionCallbackProxy(final MediaBrowserCompatApi21$SubscriptionCallback mSubscriptionCallback) {
        this.mSubscriptionCallback = mSubscriptionCallback;
    }
    
    public void onChildrenLoaded(final String s, final List list) {
        this.mSubscriptionCallback.onChildrenLoaded(s, list);
    }
    
    public void onError(final String s) {
        this.mSubscriptionCallback.onError(s);
    }
}
