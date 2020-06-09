// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.ResultReceiver;
import android.media.session.MediaController$Callback;
import android.os.Handler;
import android.app.PendingIntent;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.media.session.MediaSession$Token;
import android.content.Context;
import android.view.KeyEvent;
import android.media.session.MediaController;

class MediaControllerCompatApi21
{
    public static void adjustVolume(final Object o, final int n, final int n2) {
        ((MediaController)o).adjustVolume(n, n2);
    }
    
    public static Object createCallback(final MediaControllerCompatApi21$Callback mediaControllerCompatApi21$Callback) {
        return new MediaControllerCompatApi21$CallbackProxy(mediaControllerCompatApi21$Callback);
    }
    
    public static boolean dispatchMediaButtonEvent(final Object o, final KeyEvent keyEvent) {
        return ((MediaController)o).dispatchMediaButtonEvent(keyEvent);
    }
    
    public static Object fromToken(final Context context, final Object o) {
        return new MediaController(context, (MediaSession$Token)o);
    }
    
    public static Bundle getExtras(final Object o) {
        return ((MediaController)o).getExtras();
    }
    
    public static long getFlags(final Object o) {
        return ((MediaController)o).getFlags();
    }
    
    public static Object getMediaController(final Activity activity) {
        return activity.getMediaController();
    }
    
    public static Object getMetadata(final Object o) {
        return ((MediaController)o).getMetadata();
    }
    
    public static String getPackageName(final Object o) {
        return ((MediaController)o).getPackageName();
    }
    
    public static Object getPlaybackInfo(final Object o) {
        return ((MediaController)o).getPlaybackInfo();
    }
    
    public static Object getPlaybackState(final Object o) {
        return ((MediaController)o).getPlaybackState();
    }
    
    public static List getQueue(final Object o) {
        final List queue = ((MediaController)o).getQueue();
        if (queue == null) {
            return null;
        }
        return new ArrayList(queue);
    }
    
    public static CharSequence getQueueTitle(final Object o) {
        return ((MediaController)o).getQueueTitle();
    }
    
    public static int getRatingType(final Object o) {
        return ((MediaController)o).getRatingType();
    }
    
    public static PendingIntent getSessionActivity(final Object o) {
        return ((MediaController)o).getSessionActivity();
    }
    
    public static Object getSessionToken(final Object o) {
        return ((MediaController)o).getSessionToken();
    }
    
    public static Object getTransportControls(final Object o) {
        return ((MediaController)o).getTransportControls();
    }
    
    public static void registerCallback(final Object o, final Object o2, final Handler handler) {
        ((MediaController)o).registerCallback((MediaController$Callback)o2, handler);
    }
    
    public static void sendCommand(final Object o, final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
        ((MediaController)o).sendCommand(s, bundle, resultReceiver);
    }
    
    public static void setMediaController(final Activity activity, final Object o) {
        activity.setMediaController((MediaController)o);
    }
    
    public static void setVolumeTo(final Object o, final int n, final int n2) {
        ((MediaController)o).setVolumeTo(n, n2);
    }
    
    public static void unregisterCallback(final Object o, final Object o2) {
        ((MediaController)o).unregisterCallback((MediaController$Callback)o2);
    }
}
