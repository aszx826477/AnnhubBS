// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import android.view.MenuItem;
import android.view.MenuItem$OnActionExpandListener;
import android.support.v4.view.MenuItemCompat$OnActionExpandListener;

class MenuItemWrapperICS$OnActionExpandListenerWrapper extends BaseWrapper implements MenuItemCompat$OnActionExpandListener
{
    final /* synthetic */ MenuItemWrapperICS this$0;
    
    MenuItemWrapperICS$OnActionExpandListenerWrapper(final MenuItemWrapperICS this$0, final MenuItem$OnActionExpandListener menuItem$OnActionExpandListener) {
        this.this$0 = this$0;
        super(menuItem$OnActionExpandListener);
    }
    
    public boolean onMenuItemActionCollapse(final MenuItem menuItem) {
        return ((MenuItem$OnActionExpandListener)this.mWrappedObject).onMenuItemActionCollapse(this.this$0.getMenuItemWrapper(menuItem));
    }
    
    public boolean onMenuItemActionExpand(final MenuItem menuItem) {
        return ((MenuItem$OnActionExpandListener)this.mWrappedObject).onMenuItemActionExpand(this.this$0.getMenuItemWrapper(menuItem));
    }
}
