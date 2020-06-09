// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import android.support.v4.content.IntentCompat;
import android.content.Context;
import android.content.ComponentName;
import android.content.Intent;
import android.app.Activity;

class NavUtils$NavUtilsImplBase implements NavUtils$NavUtilsImpl
{
    public Intent getParentActivityIntent(final Activity activity) {
        final String parentActivityName = NavUtils.getParentActivityName(activity);
        if (parentActivityName == null) {
            return null;
        }
        final ComponentName component = new ComponentName((Context)activity, parentActivityName);
        try {
            if (NavUtils.getParentActivityName((Context)activity, component) == null) {
                return IntentCompat.makeMainActivity(component);
            }
            try {
                final Intent intent2 = new Intent();
                try {
                    return intent2.setComponent(component);
                }
                catch (PackageManager$NameNotFoundException ex) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("getParentActivityIntent: bad parentActivityName '");
                    sb.append(parentActivityName);
                    sb.append("' in manifest");
                    Log.e("NavUtils", sb.toString());
                    return null;
                }
            }
            catch (PackageManager$NameNotFoundException ex2) {}
        }
        catch (PackageManager$NameNotFoundException ex3) {}
    }
    
    public String getParentActivityName(final Context context, final ActivityInfo activityInfo) {
        if (activityInfo.metaData == null) {
            return null;
        }
        String s = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
        if (s == null) {
            return null;
        }
        if (s.charAt(0) == '.') {
            final StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(s);
            s = sb.toString();
        }
        return s;
    }
    
    public void navigateUpTo(final Activity activity, final Intent intent) {
        intent.addFlags(67108864);
        activity.startActivity(intent);
        activity.finish();
    }
    
    public boolean shouldUpRecreateTask(final Activity activity, final Intent intent) {
        final String action = activity.getIntent().getAction();
        return action != null && !action.equals("android.intent.action.MAIN");
    }
}
