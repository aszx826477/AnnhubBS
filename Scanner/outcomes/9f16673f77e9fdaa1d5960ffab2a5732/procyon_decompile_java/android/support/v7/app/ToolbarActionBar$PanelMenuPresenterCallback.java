// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.view.Menu;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter$Callback;

final class ToolbarActionBar$PanelMenuPresenterCallback implements MenuPresenter$Callback
{
    final /* synthetic */ ToolbarActionBar this$0;
    
    ToolbarActionBar$PanelMenuPresenterCallback(final ToolbarActionBar this$0) {
        this.this$0 = this$0;
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        if (this.this$0.mWindowCallback != null) {
            this.this$0.mWindowCallback.onPanelClosed(0, (Menu)menuBuilder);
        }
    }
    
    public boolean onOpenSubMenu(final MenuBuilder menuBuilder) {
        if (menuBuilder == null && this.this$0.mWindowCallback != null) {
            this.this$0.mWindowCallback.onMenuOpened(0, (Menu)menuBuilder);
        }
        return true;
    }
}
