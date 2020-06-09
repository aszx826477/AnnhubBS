// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.service.media.MediaBrowserService$Result;
import android.content.Context;

class MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptor
{
    MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptor(final Context context, final MediaBrowserServiceCompatApi23$ServiceCompatProxy mediaBrowserServiceCompatApi23$ServiceCompatProxy) {
        super(context, mediaBrowserServiceCompatApi23$ServiceCompatProxy);
    }
    
    public void onLoadItem(final String s, final MediaBrowserService$Result mediaBrowserService$Result) {
        ((MediaBrowserServiceCompatApi23$ServiceCompatProxy)this.mServiceProxy).onLoadItem(s, new MediaBrowserServiceCompatApi21$ResultWrapper(mediaBrowserService$Result));
    }
}
