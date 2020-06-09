// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.graphics.drawable.Drawable;
import android.app.Activity;

class ActionBarDrawerToggle$ActionBarDrawerToggleImplHC implements ActionBarDrawerToggle$ActionBarDrawerToggleImpl
{
    public Drawable getThemeUpIndicator(final Activity activity) {
        return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(activity);
    }
    
    public Object setActionBarDescription(final Object o, final Activity activity, final int n) {
        return ActionBarDrawerToggleHoneycomb.setActionBarDescription(o, activity, n);
    }
    
    public Object setActionBarUpIndicator(final Object o, final Activity activity, final Drawable drawable, final int n) {
        return ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(o, activity, drawable, n);
    }
}
