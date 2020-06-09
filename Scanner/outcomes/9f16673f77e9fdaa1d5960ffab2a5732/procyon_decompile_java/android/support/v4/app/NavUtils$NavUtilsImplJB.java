// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.content.pm.ActivityInfo;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;

class NavUtils$NavUtilsImplJB extends NavUtils$NavUtilsImplBase
{
    public Intent getParentActivityIntent(final Activity activity) {
        Intent intent = NavUtilsJB.getParentActivityIntent(activity);
        if (intent == null) {
            intent = this.superGetParentActivityIntent(activity);
        }
        return intent;
    }
    
    public String getParentActivityName(final Context context, final ActivityInfo activityInfo) {
        String s = NavUtilsJB.getParentActivityName(activityInfo);
        if (s == null) {
            s = super.getParentActivityName(context, activityInfo);
        }
        return s;
    }
    
    public void navigateUpTo(final Activity activity, final Intent intent) {
        NavUtilsJB.navigateUpTo(activity, intent);
    }
    
    public boolean shouldUpRecreateTask(final Activity activity, final Intent intent) {
        return NavUtilsJB.shouldUpRecreateTask(activity, intent);
    }
    
    Intent superGetParentActivityIntent(final Activity activity) {
        return super.getParentActivityIntent(activity);
    }
}
