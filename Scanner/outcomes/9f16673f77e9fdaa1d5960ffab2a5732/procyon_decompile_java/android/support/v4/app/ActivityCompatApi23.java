// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;

class ActivityCompatApi23
{
    private static SharedElementCallback createCallback(final ActivityCompatApi23$SharedElementCallback23 activityCompatApi23$SharedElementCallback23) {
        SharedElementCallback sharedElementCallback = null;
        if (activityCompatApi23$SharedElementCallback23 != null) {
            sharedElementCallback = new ActivityCompatApi23$SharedElementCallbackImpl(activityCompatApi23$SharedElementCallback23);
        }
        return sharedElementCallback;
    }
    
    public static void requestPermissions(final Activity activity, final String[] array, final int n) {
        if (activity instanceof ActivityCompatApi23$RequestPermissionsRequestCodeValidator) {
            ((ActivityCompatApi23$RequestPermissionsRequestCodeValidator)activity).validateRequestPermissionsRequestCode(n);
        }
        activity.requestPermissions(array, n);
    }
    
    public static void setEnterSharedElementCallback(final Activity activity, final ActivityCompatApi23$SharedElementCallback23 activityCompatApi23$SharedElementCallback23) {
        activity.setEnterSharedElementCallback(createCallback(activityCompatApi23$SharedElementCallback23));
    }
    
    public static void setExitSharedElementCallback(final Activity activity, final ActivityCompatApi23$SharedElementCallback23 activityCompatApi23$SharedElementCallback23) {
        activity.setExitSharedElementCallback(createCallback(activityCompatApi23$SharedElementCallback23));
    }
    
    public static boolean shouldShowRequestPermissionRationale(final Activity activity, final String s) {
        return activity.shouldShowRequestPermissionRationale(s);
    }
}
