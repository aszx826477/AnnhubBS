// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.view.MenuItem;
import android.support.v7.widget.Toolbar$OnMenuItemClickListener;

class ToolbarActionBar$2 implements Toolbar$OnMenuItemClickListener
{
    final /* synthetic */ ToolbarActionBar this$0;
    
    ToolbarActionBar$2(final ToolbarActionBar this$0) {
        this.this$0 = this$0;
    }
    
    public boolean onMenuItemClick(final MenuItem menuItem) {
        return this.this$0.mWindowCallback.onMenuItemSelected(0, menuItem);
    }
}
