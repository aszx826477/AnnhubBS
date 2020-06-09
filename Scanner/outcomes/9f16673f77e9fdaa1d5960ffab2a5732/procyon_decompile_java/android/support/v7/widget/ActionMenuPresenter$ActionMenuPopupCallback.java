// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v7.view.menu.MenuPopup;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.view.menu.ActionMenuItemView$PopupCallback;

class ActionMenuPresenter$ActionMenuPopupCallback extends ActionMenuItemView$PopupCallback
{
    final /* synthetic */ ActionMenuPresenter this$0;
    
    ActionMenuPresenter$ActionMenuPopupCallback(final ActionMenuPresenter this$0) {
        this.this$0 = this$0;
    }
    
    public ShowableListMenu getPopup() {
        MenuPopup popup;
        if (this.this$0.mActionButtonPopup != null) {
            popup = this.this$0.mActionButtonPopup.getPopup();
        }
        else {
            popup = null;
        }
        return popup;
    }
}
