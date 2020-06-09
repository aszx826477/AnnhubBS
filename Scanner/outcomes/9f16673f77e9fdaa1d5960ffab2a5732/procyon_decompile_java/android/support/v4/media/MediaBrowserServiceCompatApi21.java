// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.media.session.MediaSession$Token;
import android.os.IBinder;
import android.content.Intent;
import android.service.media.MediaBrowserService;
import android.content.Context;

class MediaBrowserServiceCompatApi21
{
    public static Object createService(final Context context, final MediaBrowserServiceCompatApi21$ServiceCompatProxy mediaBrowserServiceCompatApi21$ServiceCompatProxy) {
        return new MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptor(context, mediaBrowserServiceCompatApi21$ServiceCompatProxy);
    }
    
    public static void notifyChildrenChanged(final Object o, final String s) {
        ((MediaBrowserService)o).notifyChildrenChanged(s);
    }
    
    public static IBinder onBind(final Object o, final Intent intent) {
        return ((MediaBrowserService)o).onBind(intent);
    }
    
    public static void onCreate(final Object o) {
        ((MediaBrowserService)o).onCreate();
    }
    
    public static void setSessionToken(final Object o, final Object o2) {
        ((MediaBrowserService)o).setSessionToken((MediaSession$Token)o2);
    }
}
