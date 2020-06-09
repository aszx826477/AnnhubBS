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
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.appcompat.R$layout;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.support.v4.view.ActionProvider$SubUiVisibilityListener;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.view.View;

class ActionMenuPresenter$OpenOverflowRunnable implements Runnable
{
    private ActionMenuPresenter$OverflowPopup mPopup;
    final /* synthetic */ ActionMenuPresenter this$0;
    
    public ActionMenuPresenter$OpenOverflowRunnable(final ActionMenuPresenter this$0, final ActionMenuPresenter$OverflowPopup mPopup) {
        this.this$0 = this$0;
        this.mPopup = mPopup;
    }
    
    public void run() {
        if (this.this$0.mMenu != null) {
            this.this$0.mMenu.changeMenuMode();
        }
        final View view = (View)this.this$0.mMenuView;
        if (view != null && view.getWindowToken() != null && this.mPopup.tryShow()) {
            this.this$0.mOverflowPopup = this.mPopup;
        }
        this.this$0.mPostedOpenRunnable = null;
    }
}
