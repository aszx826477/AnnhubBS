// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Bundle;
import java.util.List;
import android.os.Binder;
import android.os.Build$VERSION;
import android.os.IBinder;
import java.lang.ref.WeakReference;

public abstract class MediaBrowserCompat$SubscriptionCallback
{
    private final Object mSubscriptionCallbackObj;
    WeakReference mSubscriptionRef;
    private final IBinder mToken;
    
    public MediaBrowserCompat$SubscriptionCallback() {
        if (Build$VERSION.SDK_INT >= 21) {
            this.mSubscriptionCallbackObj = MediaBrowserCompatApi21.createSubscriptionCallback(new MediaBrowserCompat$SubscriptionCallback$StubApi21(this));
            this.mToken = (IBinder)new Binder();
        }
        else {
            this.mSubscriptionCallbackObj = null;
            this.mToken = (IBinder)new Binder();
        }
    }
    
    private void setSubscription(final MediaBrowserCompat$Subscription mediaBrowserCompat$Subscription) {
        this.mSubscriptionRef = new WeakReference((T)mediaBrowserCompat$Subscription);
    }
    
    public void onChildrenLoaded(final String s, final List list) {
    }
    
    public void onChildrenLoaded(final String s, final List list, final Bundle bundle) {
    }
    
    public void onError(final String s) {
    }
    
    public void onError(final String s, final Bundle bundle) {
    }
}
