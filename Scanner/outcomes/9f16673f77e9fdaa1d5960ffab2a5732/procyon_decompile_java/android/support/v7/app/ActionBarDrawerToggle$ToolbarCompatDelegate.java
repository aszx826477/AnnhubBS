// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.graphics.drawable.Drawable;

class ActionBarDrawerToggle$ToolbarCompatDelegate implements ActionBarDrawerToggle$Delegate
{
    final CharSequence mDefaultContentDescription;
    final Drawable mDefaultUpIndicator;
    final Toolbar mToolbar;
    
    ActionBarDrawerToggle$ToolbarCompatDelegate(final Toolbar mToolbar) {
        this.mToolbar = mToolbar;
        this.mDefaultUpIndicator = mToolbar.getNavigationIcon();
        this.mDefaultContentDescription = mToolbar.getNavigationContentDescription();
    }
    
    public Context getActionBarThemedContext() {
        return this.mToolbar.getContext();
    }
    
    public Drawable getThemeUpIndicator() {
        return this.mDefaultUpIndicator;
    }
    
    public boolean isNavigationVisible() {
        return true;
    }
    
    public void setActionBarDescription(final int navigationContentDescription) {
        if (navigationContentDescription == 0) {
            this.mToolbar.setNavigationContentDescription(this.mDefaultContentDescription);
        }
        else {
            this.mToolbar.setNavigationContentDescription(navigationContentDescription);
        }
    }
    
    public void setActionBarUpIndicator(final Drawable navigationIcon, final int actionBarDescription) {
        this.mToolbar.setNavigationIcon(navigationIcon);
        this.setActionBarDescription(actionBarDescription);
    }
}
