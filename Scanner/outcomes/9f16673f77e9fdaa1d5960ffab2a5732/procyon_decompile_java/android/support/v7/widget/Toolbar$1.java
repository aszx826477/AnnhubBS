// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.MenuItem;

class Toolbar$1 implements ActionMenuView$OnMenuItemClickListener
{
    final /* synthetic */ Toolbar this$0;
    
    Toolbar$1(final Toolbar this$0) {
        this.this$0 = this$0;
    }
    
    public boolean onMenuItemClick(final MenuItem menuItem) {
        return this.this$0.mOnMenuItemClickListener != null && this.this$0.mOnMenuItemClickListener.onMenuItemClick(menuItem);
    }
}
