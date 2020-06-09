// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.MenuItem;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder$Callback;

class PopupMenu$1 implements MenuBuilder$Callback
{
    final /* synthetic */ PopupMenu this$0;
    
    PopupMenu$1(final PopupMenu this$0) {
        this.this$0 = this$0;
    }
    
    public boolean onMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        return this.this$0.mMenuItemClickListener != null && this.this$0.mMenuItemClickListener.onMenuItemClick(menuItem);
    }
    
    public void onMenuModeChange(final MenuBuilder menuBuilder) {
    }
}
