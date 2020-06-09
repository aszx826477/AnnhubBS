// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.content.Context;

class MediaBrowserServiceCompatApi23
{
    public static Object createService(final Context context, final MediaBrowserServiceCompatApi23$ServiceCompatProxy mediaBrowserServiceCompatApi23$ServiceCompatProxy) {
        return new MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptor(context, mediaBrowserServiceCompatApi23$ServiceCompatProxy);
    }
}
