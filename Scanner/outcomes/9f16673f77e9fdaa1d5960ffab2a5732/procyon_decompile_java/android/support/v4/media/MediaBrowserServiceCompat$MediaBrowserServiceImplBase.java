// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.support.v4.media.session.MediaSessionCompat$Token;
import android.os.Handler;
import android.os.IBinder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Messenger;

class MediaBrowserServiceCompat$MediaBrowserServiceImplBase implements MediaBrowserServiceCompat$MediaBrowserServiceImpl
{
    private Messenger mMessenger;
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    
    MediaBrowserServiceCompat$MediaBrowserServiceImplBase(final MediaBrowserServiceCompat this$0) {
        this.this$0 = this$0;
    }
    
    public Bundle getBrowserRootHints() {
        if (this.this$0.mCurConnection != null) {
            Bundle bundle;
            if (this.this$0.mCurConnection.rootHints == null) {
                bundle = null;
            }
            else {
                bundle = new Bundle(this.this$0.mCurConnection.rootHints);
            }
            return bundle;
        }
        throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem or onSearch methods");
    }
    
    public void notifyChildrenChanged(final String s, final Bundle bundle) {
        this.this$0.mHandler.post((Runnable)new MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2(this, s, bundle));
    }
    
    public IBinder onBind(final Intent intent) {
        if ("android.media.browse.MediaBrowserService".equals(intent.getAction())) {
            return this.mMessenger.getBinder();
        }
        return null;
    }
    
    public void onCreate() {
        this.mMessenger = new Messenger((Handler)this.this$0.mHandler);
    }
    
    public void setSessionToken(final MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.this$0.mHandler.post((Runnable)new MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1(this, mediaSessionCompat$Token));
    }
}
