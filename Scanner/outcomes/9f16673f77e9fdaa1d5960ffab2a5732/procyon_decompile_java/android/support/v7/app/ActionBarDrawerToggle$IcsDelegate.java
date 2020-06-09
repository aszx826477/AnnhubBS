// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.app.ActionBar;
import android.content.Context;
import android.app.Activity;

class ActionBarDrawerToggle$IcsDelegate extends ActionBarDrawerToggle$HoneycombDelegate
{
    ActionBarDrawerToggle$IcsDelegate(final Activity activity) {
        super(activity);
    }
    
    public Context getActionBarThemedContext() {
        final ActionBar actionBar = this.mActivity.getActionBar();
        Object o;
        if (actionBar != null) {
            o = actionBar.getThemedContext();
        }
        else {
            o = this.mActivity;
        }
        return (Context)o;
    }
}
