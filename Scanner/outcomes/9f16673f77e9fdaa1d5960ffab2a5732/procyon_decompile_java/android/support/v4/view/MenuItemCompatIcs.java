// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.MenuItem$OnActionExpandListener;
import android.view.MenuItem;

class MenuItemCompatIcs
{
    public static boolean collapseActionView(final MenuItem menuItem) {
        return menuItem.collapseActionView();
    }
    
    public static boolean expandActionView(final MenuItem menuItem) {
        return menuItem.expandActionView();
    }
    
    public static boolean isActionViewExpanded(final MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }
    
    public static MenuItem setOnActionExpandListener(final MenuItem menuItem, final MenuItemCompatIcs$SupportActionExpandProxy menuItemCompatIcs$SupportActionExpandProxy) {
        return menuItem.setOnActionExpandListener((MenuItem$OnActionExpandListener)new MenuItemCompatIcs$OnActionExpandListenerWrapper(menuItemCompatIcs$SupportActionExpandProxy));
    }
}
