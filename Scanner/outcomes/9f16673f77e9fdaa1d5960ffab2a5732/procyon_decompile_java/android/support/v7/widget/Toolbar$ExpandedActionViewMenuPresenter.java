// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v7.view.menu.MenuPresenter$Callback;
import android.support.v7.view.menu.SubMenuBuilder;
import android.os.Parcelable;
import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;

class Toolbar$ExpandedActionViewMenuPresenter implements MenuPresenter
{
    MenuItemImpl mCurrentExpandedItem;
    MenuBuilder mMenu;
    final /* synthetic */ Toolbar this$0;
    
    Toolbar$ExpandedActionViewMenuPresenter(final Toolbar this$0) {
        this.this$0 = this$0;
    }
    
    public boolean collapseItemActionView(final MenuBuilder menuBuilder, final MenuItemImpl menuItemImpl) {
        if (this.this$0.mExpandedActionView instanceof CollapsibleActionView) {
            ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewCollapsed();
        }
        final Toolbar this$0 = this.this$0;
        this$0.removeView(this$0.mExpandedActionView);
        final Toolbar this$2 = this.this$0;
        this$2.removeView((View)this$2.mCollapseButtonView);
        final Toolbar this$3 = this.this$0;
        this$3.mExpandedActionView = null;
        this$3.addChildrenForExpandedActionView();
        this.mCurrentExpandedItem = null;
        this.this$0.requestLayout();
        menuItemImpl.setActionViewExpanded(false);
        return true;
    }
    
    public boolean expandItemActionView(final MenuBuilder menuBuilder, final MenuItemImpl mCurrentExpandedItem) {
        this.this$0.ensureCollapseButtonView();
        final ViewParent parent = this.this$0.mCollapseButtonView.getParent();
        final Toolbar this$0 = this.this$0;
        if (parent != this$0) {
            this$0.addView((View)this$0.mCollapseButtonView);
        }
        this.this$0.mExpandedActionView = mCurrentExpandedItem.getActionView();
        this.mCurrentExpandedItem = mCurrentExpandedItem;
        final ViewParent parent2 = this.this$0.mExpandedActionView.getParent();
        final Toolbar this$2 = this.this$0;
        if (parent2 != this$2) {
            final Toolbar$LayoutParams generateDefaultLayoutParams = this$2.generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (0x800003 | (this.this$0.mButtonGravity & 0x70));
            generateDefaultLayoutParams.mViewType = 2;
            this.this$0.mExpandedActionView.setLayoutParams((ViewGroup$LayoutParams)generateDefaultLayoutParams);
            final Toolbar this$3 = this.this$0;
            this$3.addView(this$3.mExpandedActionView);
        }
        this.this$0.removeChildrenForExpandedActionView();
        this.this$0.requestLayout();
        final boolean actionViewExpanded = true;
        mCurrentExpandedItem.setActionViewExpanded(actionViewExpanded);
        if (this.this$0.mExpandedActionView instanceof CollapsibleActionView) {
            ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewExpanded();
        }
        return actionViewExpanded;
    }
    
    public boolean flagActionItems() {
        return false;
    }
    
    public int getId() {
        return 0;
    }
    
    public MenuView getMenuView(final ViewGroup viewGroup) {
        return null;
    }
    
    public void initForMenu(final Context context, final MenuBuilder mMenu) {
        final MenuBuilder mMenu2 = this.mMenu;
        if (mMenu2 != null) {
            final MenuItemImpl mCurrentExpandedItem = this.mCurrentExpandedItem;
            if (mCurrentExpandedItem != null) {
                mMenu2.collapseItemActionView(mCurrentExpandedItem);
            }
        }
        this.mMenu = mMenu;
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
    }
    
    public Parcelable onSaveInstanceState() {
        return null;
    }
    
    public boolean onSubMenuSelected(final SubMenuBuilder subMenuBuilder) {
        return false;
    }
    
    public void setCallback(final MenuPresenter$Callback menuPresenter$Callback) {
    }
    
    public void updateMenuView(final boolean b) {
        if (this.mCurrentExpandedItem != null) {
            boolean b2 = false;
            final MenuBuilder mMenu = this.mMenu;
            if (mMenu != null) {
                for (int size = mMenu.size(), i = 0; i < size; ++i) {
                    if (this.mMenu.getItem(i) == this.mCurrentExpandedItem) {
                        b2 = true;
                        break;
                    }
                }
            }
            if (!b2) {
                this.collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
            }
        }
    }
}
