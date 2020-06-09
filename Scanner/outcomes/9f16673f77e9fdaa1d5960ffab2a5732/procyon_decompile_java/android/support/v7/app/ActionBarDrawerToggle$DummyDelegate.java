// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.graphics.drawable.Drawable;
import android.content.Context;
import android.app.Activity;

class ActionBarDrawerToggle$DummyDelegate implements ActionBarDrawerToggle$Delegate
{
    final Activity mActivity;
    
    ActionBarDrawerToggle$DummyDelegate(final Activity mActivity) {
        this.mActivity = mActivity;
    }
    
    public Context getActionBarThemedContext() {
        return (Context)this.mActivity;
    }
    
    public Drawable getThemeUpIndicator() {
        return null;
    }
    
    public boolean isNavigationVisible() {
        return true;
    }
    
    public void setActionBarDescription(final int n) {
    }
    
    public void setActionBarUpIndicator(final Drawable drawable, final int n) {
    }
}
