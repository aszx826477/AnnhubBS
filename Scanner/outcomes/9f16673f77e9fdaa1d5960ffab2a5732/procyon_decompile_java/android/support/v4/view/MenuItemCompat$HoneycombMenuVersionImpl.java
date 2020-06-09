// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;
import android.view.MenuItem;

class MenuItemCompat$HoneycombMenuVersionImpl implements MenuItemCompat$MenuVersionImpl
{
    public boolean collapseActionView(final MenuItem menuItem) {
        return false;
    }
    
    public boolean expandActionView(final MenuItem menuItem) {
        return false;
    }
    
    public View getActionView(final MenuItem menuItem) {
        return MenuItemCompatHoneycomb.getActionView(menuItem);
    }
    
    public boolean isActionViewExpanded(final MenuItem menuItem) {
        return false;
    }
    
    public MenuItem setActionView(final MenuItem menuItem, final int n) {
        return MenuItemCompatHoneycomb.setActionView(menuItem, n);
    }
    
    public MenuItem setActionView(final MenuItem menuItem, final View view) {
        return MenuItemCompatHoneycomb.setActionView(menuItem, view);
    }
    
    public MenuItem setOnActionExpandListener(final MenuItem menuItem, final MenuItemCompat$OnActionExpandListener menuItemCompat$OnActionExpandListener) {
        return menuItem;
    }
    
    public void setShowAsAction(final MenuItem menuItem, final int n) {
        MenuItemCompatHoneycomb.setShowAsAction(menuItem, n);
    }
}
