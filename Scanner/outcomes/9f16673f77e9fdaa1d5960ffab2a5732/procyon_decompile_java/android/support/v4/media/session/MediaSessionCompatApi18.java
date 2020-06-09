// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.SystemClock;
import android.media.RemoteControlClient$OnPlaybackPositionUpdateListener;
import android.media.RemoteControlClient;
import android.util.Log;
import android.media.AudioManager;
import android.content.ComponentName;
import android.app.PendingIntent;
import android.content.Context;

class MediaSessionCompatApi18
{
    private static final long ACTION_SEEK_TO = 256L;
    private static final String TAG = "MediaSessionCompatApi18";
    private static boolean sIsMbrPendingIntentSupported;
    
    static {
        MediaSessionCompatApi18.sIsMbrPendingIntentSupported = true;
    }
    
    public static Object createPlaybackPositionUpdateListener(final MediaSessionCompatApi18$Callback mediaSessionCompatApi18$Callback) {
        return new MediaSessionCompatApi18$OnPlaybackPositionUpdateListener(mediaSessionCompatApi18$Callback);
    }
    
    static int getRccTransportControlFlagsFromActions(final long n) {
        int rccTransportControlFlagsFromActions = MediaSessionCompatApi14.getRccTransportControlFlagsFromActions(n);
        if ((0x100L & n) != 0x0L) {
            rccTransportControlFlagsFromActions |= 0x100;
        }
        return rccTransportControlFlagsFromActions;
    }
    
    public static void registerMediaButtonEventReceiver(final Context context, final PendingIntent pendingIntent, final ComponentName componentName) {
        final AudioManager audioManager = (AudioManager)context.getSystemService("audio");
        if (MediaSessionCompatApi18.sIsMbrPendingIntentSupported) {
            final AudioManager audioManager2 = audioManager;
            try {
                audioManager2.registerMediaButtonEventReceiver(pendingIntent);
            }
            catch (NullPointerException ex) {
                Log.w("MediaSessionCompatApi18", "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                MediaSessionCompatApi18.sIsMbrPendingIntentSupported = false;
            }
        }
        if (!MediaSessionCompatApi18.sIsMbrPendingIntentSupported) {
            audioManager.registerMediaButtonEventReceiver(componentName);
        }
    }
    
    public static void setOnPlaybackPositionUpdateListener(final Object o, final Object o2) {
        ((RemoteControlClient)o).setPlaybackPositionUpdateListener((RemoteControlClient$OnPlaybackPositionUpdateListener)o2);
    }
    
    public static void setState(final Object o, int rccStateFromState, long n, final float n2, final long n3) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        if (rccStateFromState == 3) {
            final long n4 = 0L;
            if (n > n4) {
                long n5 = 0L;
                if (n3 > n4) {
                    n5 = elapsedRealtime - n3;
                    if (n2 > 0.0f && n2 != 1.0f) {
                        n5 *= (long)n2;
                    }
                }
                n += n5;
            }
        }
        rccStateFromState = MediaSessionCompatApi14.getRccStateFromState(rccStateFromState);
        ((RemoteControlClient)o).setPlaybackState(rccStateFromState, n, n2);
    }
    
    public static void setTransportControlFlags(final Object o, final long n) {
        ((RemoteControlClient)o).setTransportControlFlags(getRccTransportControlFlagsFromActions(n));
    }
    
    public static void unregisterMediaButtonEventReceiver(final Context context, final PendingIntent pendingIntent, final ComponentName componentName) {
        final AudioManager audioManager = (AudioManager)context.getSystemService("audio");
        if (MediaSessionCompatApi18.sIsMbrPendingIntentSupported) {
            audioManager.unregisterMediaButtonEventReceiver(pendingIntent);
        }
        else {
            audioManager.unregisterMediaButtonEventReceiver(componentName);
        }
    }
}
