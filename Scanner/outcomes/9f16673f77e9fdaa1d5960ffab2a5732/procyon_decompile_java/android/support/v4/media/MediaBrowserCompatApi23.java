// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.media.browse.MediaBrowser$ItemCallback;
import android.media.browse.MediaBrowser;

class MediaBrowserCompatApi23
{
    public static Object createItemCallback(final MediaBrowserCompatApi23$ItemCallback mediaBrowserCompatApi23$ItemCallback) {
        return new MediaBrowserCompatApi23$ItemCallbackProxy(mediaBrowserCompatApi23$ItemCallback);
    }
    
    public static void getItem(final Object o, final String s, final Object o2) {
        ((MediaBrowser)o).getItem(s, (MediaBrowser$ItemCallback)o2);
    }
}
