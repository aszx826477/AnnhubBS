// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.MenuItem;
import android.view.View;
import android.support.v7.view.menu.ActionMenuItem;
import android.view.View$OnClickListener;

class ToolbarWidgetWrapper$1 implements View$OnClickListener
{
    final ActionMenuItem mNavItem;
    final /* synthetic */ ToolbarWidgetWrapper this$0;
    
    ToolbarWidgetWrapper$1(final ToolbarWidgetWrapper this$0) {
        this.this$0 = this$0;
        this.mNavItem = new ActionMenuItem(this.this$0.mToolbar.getContext(), 0, 16908332, 0, 0, this.this$0.mTitle);
    }
    
    public void onClick(final View view) {
        if (this.this$0.mWindowCallback != null && this.this$0.mMenuPrepared) {
            this.this$0.mWindowCallback.onMenuItemSelected(0, (MenuItem)this.mNavItem);
        }
    }
}
