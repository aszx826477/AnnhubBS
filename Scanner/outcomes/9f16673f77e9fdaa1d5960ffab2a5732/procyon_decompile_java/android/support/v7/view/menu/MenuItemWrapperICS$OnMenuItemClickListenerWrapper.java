// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import android.view.MenuItem;
import android.view.MenuItem$OnMenuItemClickListener;

class MenuItemWrapperICS$OnMenuItemClickListenerWrapper extends BaseWrapper implements MenuItem$OnMenuItemClickListener
{
    final /* synthetic */ MenuItemWrapperICS this$0;
    
    MenuItemWrapperICS$OnMenuItemClickListenerWrapper(final MenuItemWrapperICS this$0, final MenuItem$OnMenuItemClickListener menuItem$OnMenuItemClickListener) {
        this.this$0 = this$0;
        super(menuItem$OnMenuItemClickListener);
    }
    
    public boolean onMenuItemClick(final MenuItem menuItem) {
        return ((MenuItem$OnMenuItemClickListener)this.mWrappedObject).onMenuItemClick(this.this$0.getMenuItemWrapper(menuItem));
    }
}
