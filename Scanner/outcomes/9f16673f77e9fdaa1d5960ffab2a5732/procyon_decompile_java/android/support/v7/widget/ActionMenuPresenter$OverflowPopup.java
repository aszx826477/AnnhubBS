// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v4.view.ActionProvider;
import android.support.v7.transition.ActionBarTransition;
import android.support.v7.view.menu.SubMenuBuilder;
import android.os.Parcelable;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.view.ActionBarPolicy;
import android.view.ViewGroup$LayoutParams;
import java.util.ArrayList;
import android.view.View$MeasureSpec;
import android.support.v7.view.menu.ActionMenuItemView$PopupCallback;
import android.support.v7.view.menu.MenuBuilder$ItemInvoker;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView$ItemView;
import android.view.ViewGroup;
import android.view.MenuItem;
import android.support.v7.view.menu.MenuView;
import android.support.v7.appcompat.R$layout;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.support.v4.view.ActionProvider$SubUiVisibilityListener;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.support.v7.appcompat.R$attr;
import android.view.View;
import android.support.v7.view.menu.MenuBuilder;
import android.content.Context;
import android.support.v7.view.menu.MenuPopupHelper;

class ActionMenuPresenter$OverflowPopup extends MenuPopupHelper
{
    final /* synthetic */ ActionMenuPresenter this$0;
    
    public ActionMenuPresenter$OverflowPopup(final ActionMenuPresenter this$0, final Context context, final MenuBuilder menuBuilder, final View view, final boolean b) {
        this.this$0 = this$0;
        super(context, menuBuilder, view, b, R$attr.actionOverflowMenuStyle);
        this.setGravity(8388613);
        this.setPresenterCallback(this$0.mPopupPresenterCallback);
    }
    
    protected void onDismiss() {
        if (this.this$0.mMenu != null) {
            this.this$0.mMenu.close();
        }
        this.this$0.mOverflowPopup = null;
        super.onDismiss();
    }
}
