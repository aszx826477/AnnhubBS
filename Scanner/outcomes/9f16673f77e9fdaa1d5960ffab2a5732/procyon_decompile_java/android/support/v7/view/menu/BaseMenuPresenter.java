// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import java.util.ArrayList;
import android.support.v4.view.ViewCompat;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;
import android.content.Context;

public abstract class BaseMenuPresenter implements MenuPresenter
{
    private MenuPresenter$Callback mCallback;
    protected Context mContext;
    private int mId;
    protected LayoutInflater mInflater;
    private int mItemLayoutRes;
    protected MenuBuilder mMenu;
    private int mMenuLayoutRes;
    protected MenuView mMenuView;
    protected Context mSystemContext;
    protected LayoutInflater mSystemInflater;
    
    public BaseMenuPresenter(final Context mSystemContext, final int mMenuLayoutRes, final int mItemLayoutRes) {
        this.mSystemContext = mSystemContext;
        this.mSystemInflater = LayoutInflater.from(mSystemContext);
        this.mMenuLayoutRes = mMenuLayoutRes;
        this.mItemLayoutRes = mItemLayoutRes;
    }
    
    protected void addItemView(final View view, final int n) {
        final ViewGroup viewGroup = (ViewGroup)view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup)this.mMenuView).addView(view, n);
    }
    
    public abstract void bindItemView(final MenuItemImpl p0, final MenuView$ItemView p1);
    
    public boolean collapseItemActionView(final MenuBuilder menuBuilder, final MenuItemImpl menuItemImpl) {
        return false;
    }
    
    public MenuView$ItemView createItemView(final ViewGroup viewGroup) {
        return (MenuView$ItemView)this.mSystemInflater.inflate(this.mItemLayoutRes, viewGroup, false);
    }
    
    public boolean expandItemActionView(final MenuBuilder menuBuilder, final MenuItemImpl menuItemImpl) {
        return false;
    }
    
    protected boolean filterLeftoverView(final ViewGroup viewGroup, final int n) {
        viewGroup.removeViewAt(n);
        return true;
    }
    
    public boolean flagActionItems() {
        return false;
    }
    
    public MenuPresenter$Callback getCallback() {
        return this.mCallback;
    }
    
    public int getId() {
        return this.mId;
    }
    
    public View getItemView(final MenuItemImpl menuItemImpl, final View view, final ViewGroup viewGroup) {
        MenuView$ItemView itemView;
        if (view instanceof MenuView$ItemView) {
            itemView = (MenuView$ItemView)view;
        }
        else {
            itemView = this.createItemView(viewGroup);
        }
        this.bindItemView(menuItemImpl, itemView);
        return (View)itemView;
    }
    
    public MenuView getMenuView(final ViewGroup viewGroup) {
        if (this.mMenuView == null) {
            (this.mMenuView = (MenuView)this.mSystemInflater.inflate(this.mMenuLayoutRes, viewGroup, false)).initialize(this.mMenu);
            this.updateMenuView(true);
        }
        return this.mMenuView;
    }
    
    public void initForMenu(final Context mContext, final MenuBuilder mMenu) {
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mMenu = mMenu;
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        final MenuPresenter$Callback mCallback = this.mCallback;
        if (mCallback != null) {
            mCallback.onCloseMenu(menuBuilder, b);
        }
    }
    
    public boolean onSubMenuSelected(final SubMenuBuilder subMenuBuilder) {
        final MenuPresenter$Callback mCallback = this.mCallback;
        return mCallback != null && mCallback.onOpenSubMenu(subMenuBuilder);
    }
    
    public void setCallback(final MenuPresenter$Callback mCallback) {
        this.mCallback = mCallback;
    }
    
    public void setId(final int mId) {
        this.mId = mId;
    }
    
    public boolean shouldIncludeItem(final int n, final MenuItemImpl menuItemImpl) {
        return true;
    }
    
    public void updateMenuView(final boolean b) {
        final ViewGroup viewGroup = (ViewGroup)this.mMenuView;
        if (viewGroup == null) {
            return;
        }
        int i = 0;
        final MenuBuilder mMenu = this.mMenu;
        if (mMenu != null) {
            mMenu.flagActionItems();
            final ArrayList visibleItems = this.mMenu.getVisibleItems();
            for (int size = visibleItems.size(), j = 0; j < size; ++j) {
                final MenuItemImpl menuItemImpl = visibleItems.get(j);
                if (this.shouldIncludeItem(i, menuItemImpl)) {
                    final View child = viewGroup.getChildAt(i);
                    MenuItemImpl itemData;
                    if (child instanceof MenuView$ItemView) {
                        itemData = ((MenuView$ItemView)child).getItemData();
                    }
                    else {
                        itemData = null;
                    }
                    final View itemView = this.getItemView(menuItemImpl, child, viewGroup);
                    if (menuItemImpl != itemData) {
                        itemView.setPressed(false);
                        ViewCompat.jumpDrawablesToCurrentState(itemView);
                    }
                    if (itemView != child) {
                        this.addItemView(itemView, i);
                    }
                    ++i;
                }
            }
        }
        while (i < viewGroup.getChildCount()) {
            if (!this.filterLeftoverView(viewGroup, i)) {
                ++i;
            }
        }
    }
}
