// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.MenuItem;

class MenuItemCompat$IcsMenuVersionImpl$1 implements MenuItemCompatIcs$SupportActionExpandProxy
{
    final /* synthetic */ MenuItemCompat$IcsMenuVersionImpl this$0;
    final /* synthetic */ MenuItemCompat$OnActionExpandListener val$listener;
    
    MenuItemCompat$IcsMenuVersionImpl$1(final MenuItemCompat$IcsMenuVersionImpl this$0, final MenuItemCompat$OnActionExpandListener val$listener) {
        this.this$0 = this$0;
        this.val$listener = val$listener;
    }
    
    public boolean onMenuItemActionCollapse(final MenuItem menuItem) {
        return this.val$listener.onMenuItemActionCollapse(menuItem);
    }
    
    public boolean onMenuItemActionExpand(final MenuItem menuItem) {
        return this.val$listener.onMenuItemActionExpand(menuItem);
    }
}
