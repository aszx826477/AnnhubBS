// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import android.view.SubMenu;
import android.view.View;
import android.content.Context;
import android.support.v4.view.ActionProvider;

class MenuItemWrapperICS$ActionProviderWrapper extends ActionProvider
{
    final android.view.ActionProvider mInner;
    final /* synthetic */ MenuItemWrapperICS this$0;
    
    public MenuItemWrapperICS$ActionProviderWrapper(final MenuItemWrapperICS this$0, final Context context, final android.view.ActionProvider mInner) {
        this.this$0 = this$0;
        super(context);
        this.mInner = mInner;
    }
    
    public boolean hasSubMenu() {
        return this.mInner.hasSubMenu();
    }
    
    public View onCreateActionView() {
        return this.mInner.onCreateActionView();
    }
    
    public boolean onPerformDefaultAction() {
        return this.mInner.onPerformDefaultAction();
    }
    
    public void onPrepareSubMenu(final SubMenu subMenu) {
        this.mInner.onPrepareSubMenu(this.this$0.getSubMenuWrapper(subMenu));
    }
}
