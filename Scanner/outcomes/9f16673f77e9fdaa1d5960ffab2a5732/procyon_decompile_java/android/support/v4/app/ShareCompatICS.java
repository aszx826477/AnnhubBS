// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.view.ActionProvider;
import android.content.Context;
import android.widget.ShareActionProvider;
import android.content.Intent;
import android.app.Activity;
import android.view.MenuItem;

class ShareCompatICS
{
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";
    
    public static void configureMenuItem(final MenuItem menuItem, final Activity activity, final Intent shareIntent) {
        final ActionProvider actionProvider = menuItem.getActionProvider();
        ShareActionProvider actionProvider2;
        if (!(actionProvider instanceof ShareActionProvider)) {
            actionProvider2 = new ShareActionProvider((Context)activity);
        }
        else {
            actionProvider2 = (ShareActionProvider)actionProvider;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(".sharecompat_");
        sb.append(activity.getClass().getName());
        actionProvider2.setShareHistoryFileName(sb.toString());
        actionProvider2.setShareIntent(shareIntent);
        menuItem.setActionProvider((ActionProvider)actionProvider2);
    }
}
