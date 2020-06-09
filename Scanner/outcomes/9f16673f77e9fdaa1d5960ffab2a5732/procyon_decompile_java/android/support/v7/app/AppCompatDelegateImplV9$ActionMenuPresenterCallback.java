// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.view.Window$Callback;
import android.view.Menu;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter$Callback;

final class AppCompatDelegateImplV9$ActionMenuPresenterCallback implements MenuPresenter$Callback
{
    final /* synthetic */ AppCompatDelegateImplV9 this$0;
    
    AppCompatDelegateImplV9$ActionMenuPresenterCallback(final AppCompatDelegateImplV9 this$0) {
        this.this$0 = this$0;
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        this.this$0.checkCloseActionMenu(menuBuilder);
    }
    
    public boolean onOpenSubMenu(final MenuBuilder menuBuilder) {
        final Window$Callback windowCallback = this.this$0.getWindowCallback();
        if (windowCallback != null) {
            windowCallback.onMenuOpened(108, (Menu)menuBuilder);
        }
        return true;
    }
}
