// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.content.pm.PackageManager$NameNotFoundException;
import android.support.v4.content.IntentCompat;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.os.Build$VERSION;

public final class NavUtils
{
    private static final NavUtils$NavUtilsImpl IMPL;
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";
    
    static {
        if (Build$VERSION.SDK_INT >= 16) {
            IMPL = new NavUtils$NavUtilsImplJB();
        }
        else {
            IMPL = new NavUtils$NavUtilsImplBase();
        }
    }
    
    public static Intent getParentActivityIntent(final Activity activity) {
        return NavUtils.IMPL.getParentActivityIntent(activity);
    }
    
    public static Intent getParentActivityIntent(final Context context, final ComponentName componentName) {
        final String parentActivityName = getParentActivityName(context, componentName);
        if (parentActivityName == null) {
            return null;
        }
        final ComponentName component = new ComponentName(componentName.getPackageName(), parentActivityName);
        Intent intent;
        if (getParentActivityName(context, component) == null) {
            intent = IntentCompat.makeMainActivity(component);
        }
        else {
            intent = new Intent().setComponent(component);
        }
        return intent;
    }
    
    public static Intent getParentActivityIntent(final Context context, final Class clazz) {
        final String parentActivityName = getParentActivityName(context, new ComponentName(context, clazz));
        if (parentActivityName == null) {
            return null;
        }
        final ComponentName component = new ComponentName(context, parentActivityName);
        Intent intent;
        if (getParentActivityName(context, component) == null) {
            intent = IntentCompat.makeMainActivity(component);
        }
        else {
            intent = new Intent().setComponent(component);
        }
        return intent;
    }
    
    public static String getParentActivityName(final Activity activity) {
        try {
            return getParentActivityName((Context)activity, activity.getComponentName());
        }
        catch (PackageManager$NameNotFoundException ex) {
            throw new IllegalArgumentException((Throwable)ex);
        }
    }
    
    public static String getParentActivityName(final Context context, final ComponentName componentName) {
        return NavUtils.IMPL.getParentActivityName(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }
    
    public static void navigateUpFromSameTask(final Activity activity) {
        final Intent parentActivityIntent = getParentActivityIntent(activity);
        if (parentActivityIntent != null) {
            navigateUpTo(activity, parentActivityIntent);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Activity ");
        sb.append(activity.getClass().getSimpleName());
        sb.append(" does not have a parent activity name specified.");
        sb.append(" (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> ");
        sb.append(" element in your manifest?)");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public static void navigateUpTo(final Activity activity, final Intent intent) {
        NavUtils.IMPL.navigateUpTo(activity, intent);
    }
    
    public static boolean shouldUpRecreateTask(final Activity activity, final Intent intent) {
        return NavUtils.IMPL.shouldUpRecreateTask(activity, intent);
    }
}
