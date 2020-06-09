// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;
import android.view.MenuItem;

class MenuItemCompat$BaseMenuVersionImpl implements MenuItemCompat$MenuVersionImpl
{
    public boolean collapseActionView(final MenuItem menuItem) {
        return false;
    }
    
    public boolean expandActionView(final MenuItem menuItem) {
        return false;
    }
    
    public View getActionView(final MenuItem menuItem) {
        return null;
    }
    
    public boolean isActionViewExpanded(final MenuItem menuItem) {
        return false;
    }
    
    public MenuItem setActionView(final MenuItem menuItem, final int n) {
        return menuItem;
    }
    
    public MenuItem setActionView(final MenuItem menuItem, final View view) {
        return menuItem;
    }
    
    public MenuItem setOnActionExpandListener(final MenuItem menuItem, final MenuItemCompat$OnActionExpandListener menuItemCompat$OnActionExpandListener) {
        return menuItem;
    }
    
    public void setShowAsAction(final MenuItem menuItem, final int n) {
    }
}
