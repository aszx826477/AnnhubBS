// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.content.Intent;
import android.net.Uri;
import android.os.Build$VERSION;
import android.app.Activity;
import android.support.v4.content.ContextCompat;

public class ActivityCompat extends ContextCompat
{
    private static ActivityCompatApi21$SharedElementCallback21 createCallback(final SharedElementCallback sharedElementCallback) {
        ActivityCompatApi21$SharedElementCallback21 activityCompatApi21$SharedElementCallback21 = null;
        if (sharedElementCallback != null) {
            activityCompatApi21$SharedElementCallback21 = new ActivityCompat$SharedElementCallback21Impl(sharedElementCallback);
        }
        return activityCompatApi21$SharedElementCallback21;
    }
    
    private static ActivityCompatApi23$SharedElementCallback23 createCallback23(final SharedElementCallback sharedElementCallback) {
        ActivityCompatApi23$SharedElementCallback23 activityCompatApi23$SharedElementCallback23 = null;
        if (sharedElementCallback != null) {
            activityCompatApi23$SharedElementCallback23 = new ActivityCompat$SharedElementCallback23Impl(sharedElementCallback);
        }
        return activityCompatApi23$SharedElementCallback23;
    }
    
    public static void finishAffinity(final Activity activity) {
        if (Build$VERSION.SDK_INT >= 16) {
            ActivityCompatJB.finishAffinity(activity);
        }
        else {
            activity.finish();
        }
    }
    
    public static void finishAfterTransition(final Activity activity) {
        if (Build$VERSION.SDK_INT >= 21) {
            ActivityCompatApi21.finishAfterTransition(activity);
        }
        else {
            activity.finish();
        }
    }
    
    public static Uri getReferrer(final Activity activity) {
        if (Build$VERSION.SDK_INT >= 22) {
            return ActivityCompatApi22.getReferrer(activity);
        }
        final Intent intent = activity.getIntent();
        final Uri uri = (Uri)intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        final String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (stringExtra != null) {
            return Uri.parse(stringExtra);
        }
        return null;
    }
    
    public static boolean invalidateOptionsMenu(final Activity activity) {
        if (Build$VERSION.SDK_INT >= 11) {
            ActivityCompatHoneycomb.invalidateOptionsMenu(activity);
            return true;
        }
        return false;
    }
    
    public static void postponeEnterTransition(final Activity activity) {
        if (Build$VERSION.SDK_INT >= 21) {
            ActivityCompatApi21.postponeEnterTransition(activity);
        }
    }
    
    public static void requestPermissions(final Activity activity, final String[] array, final int n) {
        if (Build$VERSION.SDK_INT >= 23) {
            ActivityCompatApi23.requestPermissions(activity, array, n);
        }
        else if (activity instanceof ActivityCompat$OnRequestPermissionsResultCallback) {
            new Handler(Looper.getMainLooper()).post((Runnable)new ActivityCompat$1(array, activity, n));
        }
    }
    
    public static void setEnterSharedElementCallback(final Activity activity, final SharedElementCallback sharedElementCallback) {
        if (Build$VERSION.SDK_INT >= 23) {
            ActivityCompatApi23.setEnterSharedElementCallback(activity, createCallback23(sharedElementCallback));
        }
        else if (Build$VERSION.SDK_INT >= 21) {
            ActivityCompatApi21.setEnterSharedElementCallback(activity, createCallback(sharedElementCallback));
        }
    }
    
    public static void setExitSharedElementCallback(final Activity activity, final SharedElementCallback sharedElementCallback) {
        if (Build$VERSION.SDK_INT >= 23) {
            ActivityCompatApi23.setExitSharedElementCallback(activity, createCallback23(sharedElementCallback));
        }
        else if (Build$VERSION.SDK_INT >= 21) {
            ActivityCompatApi21.setExitSharedElementCallback(activity, createCallback(sharedElementCallback));
        }
    }
    
    public static boolean shouldShowRequestPermissionRationale(final Activity activity, final String s) {
        return Build$VERSION.SDK_INT >= 23 && ActivityCompatApi23.shouldShowRequestPermissionRationale(activity, s);
    }
    
    public static void startActivityForResult(final Activity activity, final Intent intent, final int n, final Bundle bundle) {
        if (Build$VERSION.SDK_INT >= 16) {
            ActivityCompatJB.startActivityForResult(activity, intent, n, bundle);
        }
        else {
            activity.startActivityForResult(intent, n);
        }
    }
    
    public static void startIntentSenderForResult(final Activity activity, final IntentSender intentSender, final int n, final Intent intent, final int n2, final int n3, final int n4, final Bundle bundle) {
        if (Build$VERSION.SDK_INT >= 16) {
            ActivityCompatJB.startIntentSenderForResult(activity, intentSender, n, intent, n2, n3, n4, bundle);
        }
        else {
            activity.startIntentSenderForResult(intentSender, n, intent, n2, n3, n4);
        }
    }
    
    public static void startPostponedEnterTransition(final Activity activity) {
        if (Build$VERSION.SDK_INT >= 21) {
            ActivityCompatApi21.startPostponedEnterTransition(activity);
        }
    }
}
