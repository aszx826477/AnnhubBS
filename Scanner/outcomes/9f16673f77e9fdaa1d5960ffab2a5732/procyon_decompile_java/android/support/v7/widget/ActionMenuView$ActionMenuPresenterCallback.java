// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter$Callback;

class ActionMenuView$ActionMenuPresenterCallback implements MenuPresenter$Callback
{
    final /* synthetic */ ActionMenuView this$0;
    
    ActionMenuView$ActionMenuPresenterCallback(final ActionMenuView this$0) {
        this.this$0 = this$0;
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
    }
    
    public boolean onOpenSubMenu(final MenuBuilder menuBuilder) {
        return false;
    }
}
