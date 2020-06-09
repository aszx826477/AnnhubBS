// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.MenuItem;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder$Callback;

class ActionMenuView$MenuBuilderCallback implements MenuBuilder$Callback
{
    final /* synthetic */ ActionMenuView this$0;
    
    ActionMenuView$MenuBuilderCallback(final ActionMenuView this$0) {
        this.this$0 = this$0;
    }
    
    public boolean onMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        return this.this$0.mOnMenuItemClickListener != null && this.this$0.mOnMenuItemClickListener.onMenuItemClick(menuItem);
    }
    
    public void onMenuModeChange(final MenuBuilder menuBuilder) {
        if (this.this$0.mMenuBuilderCallback != null) {
            this.this$0.mMenuBuilderCallback.onMenuModeChange(menuBuilder);
        }
    }
}
