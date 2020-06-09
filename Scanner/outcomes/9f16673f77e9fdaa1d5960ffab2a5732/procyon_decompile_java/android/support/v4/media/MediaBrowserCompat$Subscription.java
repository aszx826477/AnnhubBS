// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class MediaBrowserCompat$Subscription
{
    private final List mCallbacks;
    private final List mOptionsList;
    
    public MediaBrowserCompat$Subscription() {
        this.mCallbacks = new ArrayList();
        this.mOptionsList = new ArrayList();
    }
    
    public MediaBrowserCompat$SubscriptionCallback getCallback(final Bundle bundle) {
        for (int i = 0; i < this.mOptionsList.size(); ++i) {
            if (MediaBrowserCompatUtils.areSameOptions((Bundle)this.mOptionsList.get(i), bundle)) {
                return (MediaBrowserCompat$SubscriptionCallback)this.mCallbacks.get(i);
            }
        }
        return null;
    }
    
    public List getCallbacks() {
        return this.mCallbacks;
    }
    
    public List getOptionsList() {
        return this.mOptionsList;
    }
    
    public boolean isEmpty() {
        return this.mCallbacks.isEmpty();
    }
    
    public void putCallback(final Bundle bundle, final MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback) {
        for (int i = 0; i < this.mOptionsList.size(); ++i) {
            if (MediaBrowserCompatUtils.areSameOptions((Bundle)this.mOptionsList.get(i), bundle)) {
                this.mCallbacks.set(i, mediaBrowserCompat$SubscriptionCallback);
                return;
            }
        }
        this.mCallbacks.add(mediaBrowserCompat$SubscriptionCallback);
        this.mOptionsList.add(bundle);
    }
}
