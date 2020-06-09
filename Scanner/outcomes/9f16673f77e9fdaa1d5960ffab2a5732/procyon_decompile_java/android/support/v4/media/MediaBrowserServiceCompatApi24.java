// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.service.media.MediaBrowserService;
import android.os.Bundle;
import android.content.Context;
import android.util.Log;
import android.service.media.MediaBrowserService$Result;
import java.lang.reflect.Field;

class MediaBrowserServiceCompatApi24
{
    private static final String TAG = "MBSCompatApi24";
    private static Field sResultFlags;
    
    static {
        final Class<MediaBrowserService$Result> clazz = MediaBrowserService$Result.class;
        final String s = "mFlags";
        final Class<MediaBrowserService$Result> clazz2 = clazz;
        try {
            final Field declaredField = clazz2.getDeclaredField(s);
            try {
                (MediaBrowserServiceCompatApi24.sResultFlags = declaredField).setAccessible(true);
            }
            catch (NoSuchFieldException ex) {
                Log.w("MBSCompatApi24", (Throwable)ex);
            }
        }
        catch (NoSuchFieldException ex2) {}
    }
    
    public static Object createService(final Context context, final MediaBrowserServiceCompatApi24$ServiceCompatProxy mediaBrowserServiceCompatApi24$ServiceCompatProxy) {
        return new MediaBrowserServiceCompatApi24$MediaBrowserServiceAdaptor(context, mediaBrowserServiceCompatApi24$ServiceCompatProxy);
    }
    
    public static Bundle getBrowserRootHints(final Object o) {
        return ((MediaBrowserService)o).getBrowserRootHints();
    }
    
    public static void notifyChildrenChanged(final Object o, final String s, final Bundle bundle) {
        ((MediaBrowserService)o).notifyChildrenChanged(s, bundle);
    }
}
