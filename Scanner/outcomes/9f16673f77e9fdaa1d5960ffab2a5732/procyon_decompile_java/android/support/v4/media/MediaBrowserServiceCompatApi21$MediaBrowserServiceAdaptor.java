// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.service.media.MediaBrowserService$Result;
import android.service.media.MediaBrowserService$BrowserRoot;
import android.os.Bundle;
import android.content.Context;
import android.service.media.MediaBrowserService;

class MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptor extends MediaBrowserService
{
    final MediaBrowserServiceCompatApi21$ServiceCompatProxy mServiceProxy;
    
    MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptor(final Context context, final MediaBrowserServiceCompatApi21$ServiceCompatProxy mServiceProxy) {
        this.attachBaseContext(context);
        this.mServiceProxy = mServiceProxy;
    }
    
    public MediaBrowserService$BrowserRoot onGetRoot(final String s, final int n, final Bundle bundle) {
        final MediaBrowserServiceCompatApi21$ServiceCompatProxy mServiceProxy = this.mServiceProxy;
        MediaBrowserService$BrowserRoot mediaBrowserService$BrowserRoot = null;
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = null;
        }
        else {
            bundle2 = new Bundle(bundle);
        }
        final MediaBrowserServiceCompatApi21$BrowserRoot onGetRoot = mServiceProxy.onGetRoot(s, n, bundle2);
        if (onGetRoot != null) {
            mediaBrowserService$BrowserRoot = new MediaBrowserService$BrowserRoot(onGetRoot.mRootId, onGetRoot.mExtras);
        }
        return mediaBrowserService$BrowserRoot;
    }
    
    public void onLoadChildren(final String s, final MediaBrowserService$Result mediaBrowserService$Result) {
        this.mServiceProxy.onLoadChildren(s, new MediaBrowserServiceCompatApi21$ResultWrapper(mediaBrowserService$Result));
    }
}
