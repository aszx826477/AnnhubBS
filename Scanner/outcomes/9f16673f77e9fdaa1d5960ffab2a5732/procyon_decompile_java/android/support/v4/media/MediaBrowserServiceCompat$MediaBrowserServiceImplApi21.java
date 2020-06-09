// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.app.BundleCompat;
import android.os.Handler;
import android.content.Context;
import android.os.IBinder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Messenger;

class MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompat$MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21$ServiceCompatProxy
{
    Messenger mMessenger;
    Object mServiceObj;
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    
    MediaBrowserServiceCompat$MediaBrowserServiceImplApi21(final MediaBrowserServiceCompat this$0) {
        this.this$0 = this$0;
    }
    
    public Bundle getBrowserRootHints() {
        final Messenger mMessenger = this.mMessenger;
        Bundle bundle = null;
        if (mMessenger == null) {
            return null;
        }
        if (this.this$0.mCurConnection != null) {
            if (this.this$0.mCurConnection.rootHints != null) {
                bundle = new Bundle(this.this$0.mCurConnection.rootHints);
            }
            return bundle;
        }
        throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem or onSearch methods");
    }
    
    public void notifyChildrenChanged(final String s, final Bundle bundle) {
        if (this.mMessenger == null) {
            MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, s);
        }
        else {
            this.this$0.mHandler.post((Runnable)new MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$1(this, s, bundle));
        }
    }
    
    public IBinder onBind(final Intent intent) {
        return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, intent);
    }
    
    public void onCreate() {
        MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj = MediaBrowserServiceCompatApi21.createService((Context)this.this$0, this));
    }
    
    public MediaBrowserServiceCompatApi21$BrowserRoot onGetRoot(final String s, final int n, final Bundle bundle) {
        Bundle extras = null;
        if (bundle != null && bundle.getInt("extra_client_version", 0) != 0) {
            bundle.remove("extra_client_version");
            this.mMessenger = new Messenger((Handler)this.this$0.mHandler);
            final Bundle bundle2 = extras = new Bundle();
            bundle2.putInt("extra_service_version", 1);
            BundleCompat.putBinder(bundle2, "extra_messenger", this.mMessenger.getBinder());
            if (this.this$0.mSession != null) {
                final IMediaSession extraBinder = this.this$0.mSession.getExtraBinder();
                final String s2 = "extra_session_binder";
                IBinder binder;
                if (extraBinder == null) {
                    binder = null;
                }
                else {
                    binder = extraBinder.asBinder();
                }
                BundleCompat.putBinder(extras, s2, binder);
            }
        }
        final MediaBrowserServiceCompat$BrowserRoot onGetRoot = this.this$0.onGetRoot(s, n, bundle);
        if (onGetRoot == null) {
            return null;
        }
        if (extras == null) {
            extras = onGetRoot.getExtras();
        }
        else if (onGetRoot.getExtras() != null) {
            extras.putAll(onGetRoot.getExtras());
        }
        return new MediaBrowserServiceCompatApi21$BrowserRoot(onGetRoot.getRootId(), extras);
    }
    
    public void onLoadChildren(final String s, final MediaBrowserServiceCompatApi21$ResultWrapper mediaBrowserServiceCompatApi21$ResultWrapper) {
        this.this$0.onLoadChildren(s, new MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2(this, s, mediaBrowserServiceCompatApi21$ResultWrapper));
    }
    
    public void setSessionToken(final MediaSessionCompat$Token mediaSessionCompat$Token) {
        MediaBrowserServiceCompatApi21.setSessionToken(this.mServiceObj, mediaSessionCompat$Token.getToken());
    }
}
