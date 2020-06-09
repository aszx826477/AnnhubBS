// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;

class ActivityCompatApi21
{
    private static SharedElementCallback createCallback(final ActivityCompatApi21$SharedElementCallback21 activityCompatApi21$SharedElementCallback21) {
        SharedElementCallback sharedElementCallback = null;
        if (activityCompatApi21$SharedElementCallback21 != null) {
            sharedElementCallback = new ActivityCompatApi21$SharedElementCallbackImpl(activityCompatApi21$SharedElementCallback21);
        }
        return sharedElementCallback;
    }
    
    public static void finishAfterTransition(final Activity activity) {
        activity.finishAfterTransition();
    }
    
    public static void postponeEnterTransition(final Activity activity) {
        activity.postponeEnterTransition();
    }
    
    public static void setEnterSharedElementCallback(final Activity activity, final ActivityCompatApi21$SharedElementCallback21 activityCompatApi21$SharedElementCallback21) {
        activity.setEnterSharedElementCallback(createCallback(activityCompatApi21$SharedElementCallback21));
    }
    
    public static void setExitSharedElementCallback(final Activity activity, final ActivityCompatApi21$SharedElementCallback21 activityCompatApi21$SharedElementCallback21) {
        activity.setExitSharedElementCallback(createCallback(activityCompatApi21$SharedElementCallback21));
    }
    
    public static void startPostponedEnterTransition(final Activity activity) {
        activity.startPostponedEnterTransition();
    }
}
