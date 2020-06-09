// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.view.Window$Callback;
import android.view.Menu;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter$Callback;

final class AppCompatDelegateImplV9$PanelMenuPresenterCallback implements MenuPresenter$Callback
{
    final /* synthetic */ AppCompatDelegateImplV9 this$0;
    
    AppCompatDelegateImplV9$PanelMenuPresenterCallback(final AppCompatDelegateImplV9 this$0) {
        this.this$0 = this$0;
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        final MenuBuilder rootMenu = menuBuilder.getRootMenu();
        final boolean b2 = true;
        final boolean b3 = rootMenu != menuBuilder;
        final AppCompatDelegateImplV9 this$0 = this.this$0;
        Object o;
        if (b3) {
            o = rootMenu;
        }
        else {
            o = menuBuilder;
        }
        final AppCompatDelegateImplV9$PanelFeatureState menuPanel = this$0.findMenuPanel((Menu)o);
        if (menuPanel != null) {
            if (b3) {
                this.this$0.callOnPanelClosed(menuPanel.featureId, menuPanel, (Menu)rootMenu);
                this.this$0.closePanel(menuPanel, b2);
            }
            else {
                this.this$0.closePanel(menuPanel, b);
            }
        }
    }
    
    public boolean onOpenSubMenu(final MenuBuilder menuBuilder) {
        if (menuBuilder == null && this.this$0.mHasActionBar) {
            final Window$Callback windowCallback = this.this$0.getWindowCallback();
            if (windowCallback != null && !this.this$0.isDestroyed()) {
                windowCallback.onMenuOpened(108, (Menu)menuBuilder);
            }
        }
        return true;
    }
}
