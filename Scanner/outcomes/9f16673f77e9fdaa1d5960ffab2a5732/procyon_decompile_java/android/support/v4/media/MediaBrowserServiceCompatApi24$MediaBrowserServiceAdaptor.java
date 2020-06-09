// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Bundle;
import android.service.media.MediaBrowserService$Result;
import android.content.Context;

class MediaBrowserServiceCompatApi24$MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptor
{
    MediaBrowserServiceCompatApi24$MediaBrowserServiceAdaptor(final Context context, final MediaBrowserServiceCompatApi24$ServiceCompatProxy mediaBrowserServiceCompatApi24$ServiceCompatProxy) {
        super(context, mediaBrowserServiceCompatApi24$ServiceCompatProxy);
    }
    
    public void onLoadChildren(final String s, final MediaBrowserService$Result mediaBrowserService$Result, final Bundle bundle) {
        ((MediaBrowserServiceCompatApi24$ServiceCompatProxy)this.mServiceProxy).onLoadChildren(s, new MediaBrowserServiceCompatApi24$ResultWrapper(mediaBrowserService$Result), bundle);
    }
}
