// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.content.pm.PackageManager;
import java.util.List;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.content.Intent;
import android.content.ComponentName;
import android.util.Log;
import android.app.PendingIntent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class MediaButtonReceiver extends BroadcastReceiver
{
    private static final String TAG = "MediaButtonReceiver";
    
    public static PendingIntent buildMediaButtonPendingIntent(final Context context, final long n) {
        final ComponentName mediaButtonReceiverComponent = getMediaButtonReceiverComponent(context);
        if (mediaButtonReceiverComponent == null) {
            Log.w("MediaButtonReceiver", "A unique media button receiver could not be found in the given context, so couldn't build a pending intent.");
            return null;
        }
        return buildMediaButtonPendingIntent(context, mediaButtonReceiverComponent, n);
    }
    
    public static PendingIntent buildMediaButtonPendingIntent(final Context context, final ComponentName component, final long n) {
        if (component == null) {
            Log.w("MediaButtonReceiver", "The component name of media button receiver should be provided.");
            return null;
        }
        final int keyCode = PlaybackStateCompat.toKeyCode(n);
        if (keyCode == 0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Cannot build a media button pending intent with the given action: ");
            sb.append(n);
            Log.w("MediaButtonReceiver", sb.toString());
            return null;
        }
        final Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(component);
        intent.putExtra("android.intent.extra.KEY_EVENT", (Parcelable)new KeyEvent(0, keyCode));
        return PendingIntent.getBroadcast(context, keyCode, intent, 0);
    }
    
    static ComponentName getMediaButtonReceiverComponent(final Context context) {
        final Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        final List queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        final int size = queryBroadcastReceivers.size();
        final int n = 1;
        if (size == n) {
            final ResolveInfo resolveInfo = queryBroadcastReceivers.get(0);
            return new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }
        if (queryBroadcastReceivers.size() > n) {
            Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        }
        return null;
    }
    
    public static KeyEvent handleIntent(final MediaSessionCompat mediaSessionCompat, final Intent intent) {
        if (mediaSessionCompat != null && intent != null) {
            if ("android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) {
                if (intent.hasExtra("android.intent.extra.KEY_EVENT")) {
                    final KeyEvent keyEvent = (KeyEvent)intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                    mediaSessionCompat.getController().dispatchMediaButtonEvent(keyEvent);
                    return keyEvent;
                }
            }
        }
        return null;
    }
    
    public void onReceive(final Context context, final Intent intent) {
        final Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON");
        intent2.setPackage(context.getPackageName());
        final PackageManager packageManager = context.getPackageManager();
        List list = packageManager.queryIntentServices(intent2, 0);
        if (list.isEmpty()) {
            intent2.setAction("android.media.browse.MediaBrowserService");
            list = packageManager.queryIntentServices(intent2, 0);
        }
        if (list.isEmpty()) {
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or a media browser service implementation");
        }
        if (list.size() == 1) {
            final ResolveInfo resolveInfo = list.get(0);
            intent.setComponent(new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name));
            context.startService(intent);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected 1 Service that handles ");
        sb.append(intent2.getAction());
        sb.append(", found ");
        sb.append(list.size());
        throw new IllegalStateException(sb.toString());
    }
}
