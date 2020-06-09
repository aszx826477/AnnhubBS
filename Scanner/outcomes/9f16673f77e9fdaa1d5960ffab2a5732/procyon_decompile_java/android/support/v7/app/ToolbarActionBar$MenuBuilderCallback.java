// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder$Callback;

final class ToolbarActionBar$MenuBuilderCallback implements MenuBuilder$Callback
{
    final /* synthetic */ ToolbarActionBar this$0;
    
    ToolbarActionBar$MenuBuilderCallback(final ToolbarActionBar this$0) {
        this.this$0 = this$0;
    }
    
    public boolean onMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        return false;
    }
    
    public void onMenuModeChange(final MenuBuilder menuBuilder) {
        if (this.this$0.mWindowCallback != null) {
            final boolean overflowMenuShowing = this.this$0.mDecorToolbar.isOverflowMenuShowing();
            final int n = 108;
            if (overflowMenuShowing) {
                this.this$0.mWindowCallback.onPanelClosed(n, (Menu)menuBuilder);
            }
            else if (this.this$0.mWindowCallback.onPreparePanel(0, (View)null, (Menu)menuBuilder)) {
                this.this$0.mWindowCallback.onMenuOpened(n, (Menu)menuBuilder);
            }
        }
    }
}
