// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.MenuItem;
import android.view.MenuItem$OnActionExpandListener;

class MenuItemCompatIcs$OnActionExpandListenerWrapper implements MenuItem$OnActionExpandListener
{
    private MenuItemCompatIcs$SupportActionExpandProxy mWrapped;
    
    public MenuItemCompatIcs$OnActionExpandListenerWrapper(final MenuItemCompatIcs$SupportActionExpandProxy mWrapped) {
        this.mWrapped = mWrapped;
    }
    
    public boolean onMenuItemActionCollapse(final MenuItem menuItem) {
        return this.mWrapped.onMenuItemActionCollapse(menuItem);
    }
    
    public boolean onMenuItemActionExpand(final MenuItem menuItem) {
        return this.mWrapped.onMenuItemActionExpand(menuItem);
    }
}
