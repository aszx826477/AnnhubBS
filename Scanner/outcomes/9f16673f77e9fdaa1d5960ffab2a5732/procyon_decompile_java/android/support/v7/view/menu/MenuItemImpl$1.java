// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import android.support.v4.view.ActionProvider$VisibilityListener;

class MenuItemImpl$1 implements ActionProvider$VisibilityListener
{
    final /* synthetic */ MenuItemImpl this$0;
    
    MenuItemImpl$1(final MenuItemImpl this$0) {
        this.this$0 = this$0;
    }
    
    public void onActionProviderVisibilityChanged(final boolean b) {
        this.this$0.mMenu.onItemVisibleChanged(this.this$0);
    }
}
