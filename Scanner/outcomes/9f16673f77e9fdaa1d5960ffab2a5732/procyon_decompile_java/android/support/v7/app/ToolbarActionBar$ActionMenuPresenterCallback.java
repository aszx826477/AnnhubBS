// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.view.Menu;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter$Callback;

final class ToolbarActionBar$ActionMenuPresenterCallback implements MenuPresenter$Callback
{
    private boolean mClosingActionMenu;
    final /* synthetic */ ToolbarActionBar this$0;
    
    ToolbarActionBar$ActionMenuPresenterCallback(final ToolbarActionBar this$0) {
        this.this$0 = this$0;
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        if (this.mClosingActionMenu) {
            return;
        }
        this.mClosingActionMenu = true;
        this.this$0.mDecorToolbar.dismissPopupMenus();
        if (this.this$0.mWindowCallback != null) {
            this.this$0.mWindowCallback.onPanelClosed(108, (Menu)menuBuilder);
        }
        this.mClosingActionMenu = false;
    }
    
    public boolean onOpenSubMenu(final MenuBuilder menuBuilder) {
        if (this.this$0.mWindowCallback != null) {
            this.this$0.mWindowCallback.onMenuOpened(108, (Menu)menuBuilder);
            return true;
        }
        return false;
    }
}
