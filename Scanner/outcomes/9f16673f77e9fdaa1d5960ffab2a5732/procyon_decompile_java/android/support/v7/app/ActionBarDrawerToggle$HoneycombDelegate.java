// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.app.ActionBar;
import android.graphics.drawable.Drawable;
import android.content.Context;
import android.app.Activity;

class ActionBarDrawerToggle$HoneycombDelegate implements ActionBarDrawerToggle$Delegate
{
    final Activity mActivity;
    ActionBarDrawerToggleHoneycomb$SetIndicatorInfo mSetIndicatorInfo;
    
    ActionBarDrawerToggle$HoneycombDelegate(final Activity mActivity) {
        this.mActivity = mActivity;
    }
    
    public Context getActionBarThemedContext() {
        return (Context)this.mActivity;
    }
    
    public Drawable getThemeUpIndicator() {
        return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.mActivity);
    }
    
    public boolean isNavigationVisible() {
        final ActionBar actionBar = this.mActivity.getActionBar();
        return actionBar != null && (actionBar.getDisplayOptions() & 0x4) != 0x0;
    }
    
    public void setActionBarDescription(final int n) {
        this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, n);
    }
    
    public void setActionBarUpIndicator(final Drawable drawable, final int n) {
        final ActionBar actionBar = this.mActivity.getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            this.mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, drawable, n);
            actionBar.setDisplayShowHomeEnabled(false);
        }
    }
}
