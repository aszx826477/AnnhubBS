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
import android.view.View;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.support.v4.view.ActionProvider$SubUiVisibilityListener;
import android.support.v7.view.menu.BaseMenuPresenter;

class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider$SubUiVisibilityListener
{
    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups;
    ActionMenuPresenter$ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    ActionMenuPresenter$OverflowMenuButton mOverflowButton;
    ActionMenuPresenter$OverflowPopup mOverflowPopup;
    private Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private ActionMenuPresenter$ActionMenuPopupCallback mPopupCallback;
    final ActionMenuPresenter$PopupPresenterCallback mPopupPresenterCallback;
    ActionMenuPresenter$OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private View mScrapActionButtonView;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;
    
    public ActionMenuPresenter(final Context context) {
        super(context, R$layout.abc_action_menu_layout, R$layout.abc_action_menu_item_layout);
        this.mActionButtonGroups = new SparseBooleanArray();
        this.mPopupPresenterCallback = new ActionMenuPresenter$PopupPresenterCallback(this);
    }
    
    private View findViewForItem(final MenuItem menuItem) {
        final ViewGroup viewGroup = (ViewGroup)this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = viewGroup.getChildAt(i);
            if (child instanceof MenuView$ItemView && ((MenuView$ItemView)child).getItemData() == menuItem) {
                return child;
            }
        }
        return null;
    }
    
    public void bindItemView(final MenuItemImpl menuItemImpl, final MenuView$ItemView menuView$ItemView) {
        menuView$ItemView.initialize(menuItemImpl, 0);
        final ActionMenuView itemInvoker = (ActionMenuView)this.mMenuView;
        final ActionMenuItemView actionMenuItemView = (ActionMenuItemView)menuView$ItemView;
        actionMenuItemView.setItemInvoker(itemInvoker);
        if (this.mPopupCallback == null) {
            this.mPopupCallback = new ActionMenuPresenter$ActionMenuPopupCallback(this);
        }
        actionMenuItemView.setPopupCallback(this.mPopupCallback);
    }
    
    public boolean dismissPopupMenus() {
        return this.hideOverflowMenu() | this.hideSubMenus();
    }
    
    public boolean filterLeftoverView(final ViewGroup viewGroup, final int n) {
        return viewGroup.getChildAt(n) != this.mOverflowButton && super.filterLeftoverView(viewGroup, n);
    }
    
    public boolean flagActionItems() {
        ActionMenuPresenter actionMenuPresenter = this;
        ArrayList<MenuItemImpl> visibleItems;
        int size;
        if (this.mMenu != null) {
            visibleItems = (ArrayList<MenuItemImpl>)this.mMenu.getVisibleItems();
            size = visibleItems.size();
        }
        else {
            visibleItems = null;
            size = 0;
        }
        int mMaxItems = actionMenuPresenter.mMaxItems;
        int mActionItemWidthLimit = actionMenuPresenter.mActionItemWidthLimit;
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup)actionMenuPresenter.mMenuView;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        boolean b = false;
        for (int i = 0; i < size; ++i) {
            final MenuItemImpl menuItemImpl = visibleItems.get(i);
            if (menuItemImpl.requiresActionButton()) {
                ++n;
            }
            else if (menuItemImpl.requestsActionButton()) {
                ++n2;
            }
            else {
                b = true;
            }
            if (actionMenuPresenter.mExpandedActionViewsExclusive && menuItemImpl.isActionViewExpanded()) {
                mMaxItems = 0;
            }
        }
        if (actionMenuPresenter.mReserveOverflow && (b || n + n2 > mMaxItems)) {
            --mMaxItems;
        }
        int n4 = mMaxItems - n;
        final SparseBooleanArray mActionButtonGroups = actionMenuPresenter.mActionButtonGroups;
        mActionButtonGroups.clear();
        int n5 = 0;
        int n6 = 0;
        if (actionMenuPresenter.mStrictWidthLimit) {
            final int mMinCellSize = actionMenuPresenter.mMinCellSize;
            n6 = mActionItemWidthLimit / mMinCellSize;
            n5 = mMinCellSize + mActionItemWidthLimit % mMinCellSize / n6;
        }
        int n7;
        int n8;
        ViewGroup viewGroup2;
        ArrayList<MenuItemImpl> list;
        for (int j = 0; j < size; ++j, size = n7, n = n8, visibleItems = list, viewGroup = viewGroup2, actionMenuPresenter = this) {
            final MenuItemImpl menuItemImpl2 = visibleItems.get(j);
            if (menuItemImpl2.requiresActionButton()) {
                n7 = size;
                final View itemView = actionMenuPresenter.getItemView(menuItemImpl2, actionMenuPresenter.mScrapActionButtonView, viewGroup);
                n8 = n;
                if (actionMenuPresenter.mScrapActionButtonView == null) {
                    actionMenuPresenter.mScrapActionButtonView = itemView;
                }
                if (actionMenuPresenter.mStrictWidthLimit) {
                    n6 -= ActionMenuView.measureChildForCells(itemView, n5, n6, measureSpec, 0);
                }
                else {
                    itemView.measure(measureSpec, measureSpec);
                }
                final int measuredWidth = itemView.getMeasuredWidth();
                final int n9 = mActionItemWidthLimit - measuredWidth;
                if (n3 == 0) {
                    n3 = measuredWidth;
                }
                final int groupId = menuItemImpl2.getGroupId();
                int n10;
                boolean isActionButton;
                if (groupId != 0) {
                    n10 = n9;
                    isActionButton = true;
                    mActionButtonGroups.put(groupId, isActionButton);
                }
                else {
                    n10 = n9;
                    isActionButton = true;
                }
                menuItemImpl2.setIsActionButton(isActionButton);
                viewGroup2 = viewGroup;
                mActionItemWidthLimit = n10;
                list = visibleItems;
            }
            else {
                n7 = size;
                n8 = n;
                if (menuItemImpl2.requestsActionButton()) {
                    final int groupId2 = menuItemImpl2.getGroupId();
                    final boolean value = mActionButtonGroups.get(groupId2);
                    int n11 = 0;
                    boolean isActionButton2 = false;
                    Label_0617: {
                        if (n4 <= 0 && !value) {
                            n11 = n4;
                        }
                        else if (mActionItemWidthLimit > 0) {
                            n11 = n4;
                            if (!actionMenuPresenter.mStrictWidthLimit || n6 > 0) {
                                isActionButton2 = true;
                                break Label_0617;
                            }
                        }
                        else {
                            n11 = n4;
                        }
                        isActionButton2 = false;
                    }
                    if (isActionButton2) {
                        boolean b2 = isActionButton2;
                        final View itemView2 = actionMenuPresenter.getItemView(menuItemImpl2, actionMenuPresenter.mScrapActionButtonView, viewGroup);
                        viewGroup2 = viewGroup;
                        if (actionMenuPresenter.mScrapActionButtonView == null) {
                            actionMenuPresenter.mScrapActionButtonView = itemView2;
                        }
                        if (actionMenuPresenter.mStrictWidthLimit) {
                            final int measureChildForCells = ActionMenuView.measureChildForCells(itemView2, n5, n6, measureSpec, 0);
                            n6 -= measureChildForCells;
                            if (measureChildForCells == 0) {
                                b2 = false;
                            }
                        }
                        else {
                            itemView2.measure(measureSpec, measureSpec);
                        }
                        final int measuredWidth2 = itemView2.getMeasuredWidth();
                        mActionItemWidthLimit -= measuredWidth2;
                        if (n3 == 0) {
                            n3 = measuredWidth2;
                        }
                        if (actionMenuPresenter.mStrictWidthLimit) {
                            isActionButton2 = (b2 & mActionItemWidthLimit >= 0);
                        }
                        else {
                            isActionButton2 = (b2 & mActionItemWidthLimit + n3 > 0);
                        }
                    }
                    else {
                        viewGroup2 = viewGroup;
                    }
                    if (isActionButton2 && groupId2 != 0) {
                        mActionButtonGroups.put(groupId2, true);
                        list = visibleItems;
                    }
                    else if (value) {
                        mActionButtonGroups.put(groupId2, false);
                        ArrayList<MenuItemImpl> list2;
                        for (int k = 0; k < j; ++k, visibleItems = list2) {
                            final MenuItemImpl menuItemImpl3 = visibleItems.get(k);
                            list2 = visibleItems;
                            if (menuItemImpl3.getGroupId() == groupId2) {
                                if (menuItemImpl3.isActionButton()) {
                                    ++n11;
                                }
                                menuItemImpl3.setIsActionButton(false);
                            }
                        }
                        list = visibleItems;
                    }
                    else {
                        list = visibleItems;
                    }
                    if (isActionButton2) {
                        --n11;
                    }
                    menuItemImpl2.setIsActionButton(isActionButton2);
                    n4 = n11;
                }
                else {
                    list = visibleItems;
                    viewGroup2 = viewGroup;
                    menuItemImpl2.setIsActionButton(false);
                }
            }
        }
        return true;
    }
    
    public View getItemView(final MenuItemImpl menuItemImpl, final View view, final ViewGroup viewGroup) {
        View view2 = menuItemImpl.getActionView();
        if (view2 == null || menuItemImpl.hasCollapsibleActionView()) {
            view2 = super.getItemView(menuItemImpl, view, viewGroup);
        }
        int visibility;
        if (menuItemImpl.isActionViewExpanded()) {
            visibility = 8;
        }
        else {
            visibility = 0;
        }
        view2.setVisibility(visibility);
        final ActionMenuView actionMenuView = (ActionMenuView)viewGroup;
        final ViewGroup$LayoutParams layoutParams = view2.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            view2.setLayoutParams((ViewGroup$LayoutParams)actionMenuView.generateLayoutParams(layoutParams));
        }
        return view2;
    }
    
    public MenuView getMenuView(final ViewGroup viewGroup) {
        final MenuView mMenuView = this.mMenuView;
        final MenuView menuView = super.getMenuView(viewGroup);
        if (mMenuView != menuView) {
            ((ActionMenuView)menuView).setPresenter(this);
        }
        return menuView;
    }
    
    public Drawable getOverflowIcon() {
        final ActionMenuPresenter$OverflowMenuButton mOverflowButton = this.mOverflowButton;
        if (mOverflowButton != null) {
            return mOverflowButton.getDrawable();
        }
        if (this.mPendingOverflowIconSet) {
            return this.mPendingOverflowIcon;
        }
        return null;
    }
    
    public boolean hideOverflowMenu() {
        final ActionMenuPresenter$OpenOverflowRunnable mPostedOpenRunnable = this.mPostedOpenRunnable;
        final boolean b = true;
        if (mPostedOpenRunnable != null && this.mMenuView != null) {
            ((View)this.mMenuView).removeCallbacks((Runnable)this.mPostedOpenRunnable);
            this.mPostedOpenRunnable = null;
            return b;
        }
        final ActionMenuPresenter$OverflowPopup mOverflowPopup = this.mOverflowPopup;
        if (mOverflowPopup != null) {
            mOverflowPopup.dismiss();
            return b;
        }
        return false;
    }
    
    public boolean hideSubMenus() {
        final ActionMenuPresenter$ActionButtonSubmenu mActionButtonPopup = this.mActionButtonPopup;
        if (mActionButtonPopup != null) {
            mActionButtonPopup.dismiss();
            return true;
        }
        return false;
    }
    
    public void initForMenu(final Context context, final MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        final Resources resources = context.getResources();
        final ActionBarPolicy value = ActionBarPolicy.get(context);
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = value.showsOverflowMenuButton();
        }
        if (!this.mWidthLimitSet) {
            this.mWidthLimit = value.getEmbeddedMenuWidthLimit();
        }
        if (!this.mMaxItemsSet) {
            this.mMaxItems = value.getMaxActionButtons();
        }
        int mWidthLimit = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new ActionMenuPresenter$OverflowMenuButton(this, this.mSystemContext);
                if (this.mPendingOverflowIconSet) {
                    this.mOverflowButton.setImageDrawable(this.mPendingOverflowIcon);
                    this.mPendingOverflowIcon = null;
                    this.mPendingOverflowIconSet = false;
                }
                final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
                this.mOverflowButton.measure(measureSpec, measureSpec);
            }
            mWidthLimit -= this.mOverflowButton.getMeasuredWidth();
        }
        else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = mWidthLimit;
        this.mMinCellSize = (int)(resources.getDisplayMetrics().density * 56.0f);
        this.mScrapActionButtonView = null;
    }
    
    public boolean isOverflowMenuShowPending() {
        return this.mPostedOpenRunnable != null || this.isOverflowMenuShowing();
    }
    
    public boolean isOverflowMenuShowing() {
        final ActionMenuPresenter$OverflowPopup mOverflowPopup = this.mOverflowPopup;
        return mOverflowPopup != null && mOverflowPopup.isShowing();
    }
    
    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        this.dismissPopupMenus();
        super.onCloseMenu(menuBuilder, b);
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        if (!this.mMaxItemsSet) {
            this.mMaxItems = ActionBarPolicy.get(this.mContext).getMaxActionButtons();
        }
        if (this.mMenu != null) {
            this.mMenu.onItemsChanged(true);
        }
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof ActionMenuPresenter$SavedState)) {
            return;
        }
        final ActionMenuPresenter$SavedState actionMenuPresenter$SavedState = (ActionMenuPresenter$SavedState)parcelable;
        if (actionMenuPresenter$SavedState.openSubMenuId > 0) {
            final MenuItem item = this.mMenu.findItem(actionMenuPresenter$SavedState.openSubMenuId);
            if (item != null) {
                this.onSubMenuSelected((SubMenuBuilder)item.getSubMenu());
            }
        }
    }
    
    public Parcelable onSaveInstanceState() {
        final ActionMenuPresenter$SavedState actionMenuPresenter$SavedState = new ActionMenuPresenter$SavedState();
        actionMenuPresenter$SavedState.openSubMenuId = this.mOpenSubMenuId;
        return (Parcelable)actionMenuPresenter$SavedState;
    }
    
    public boolean onSubMenuSelected(final SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2;
        for (subMenuBuilder2 = subMenuBuilder; subMenuBuilder2.getParentMenu() != this.mMenu; subMenuBuilder2 = (SubMenuBuilder)subMenuBuilder2.getParentMenu()) {}
        final View viewForItem = this.findViewForItem(subMenuBuilder2.getItem());
        if (viewForItem == null) {
            return false;
        }
        this.mOpenSubMenuId = subMenuBuilder.getItem().getItemId();
        boolean forceShowIcon = false;
        for (int size = subMenuBuilder.size(), i = 0; i < size; ++i) {
            final MenuItem item = subMenuBuilder.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                forceShowIcon = true;
                break;
            }
        }
        (this.mActionButtonPopup = new ActionMenuPresenter$ActionButtonSubmenu(this, this.mContext, subMenuBuilder, viewForItem)).setForceShowIcon(forceShowIcon);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }
    
    public void onSubUiVisibilityChanged(final boolean b) {
        if (b) {
            super.onSubMenuSelected(null);
        }
        else if (this.mMenu != null) {
            this.mMenu.close(false);
        }
    }
    
    public void setExpandedActionViewsExclusive(final boolean mExpandedActionViewsExclusive) {
        this.mExpandedActionViewsExclusive = mExpandedActionViewsExclusive;
    }
    
    public void setItemLimit(final int mMaxItems) {
        this.mMaxItems = mMaxItems;
        this.mMaxItemsSet = true;
    }
    
    public void setMenuView(final ActionMenuView mMenuView) {
        ((ActionMenuView)(this.mMenuView = mMenuView)).initialize(this.mMenu);
    }
    
    public void setOverflowIcon(final Drawable drawable) {
        final ActionMenuPresenter$OverflowMenuButton mOverflowButton = this.mOverflowButton;
        if (mOverflowButton != null) {
            mOverflowButton.setImageDrawable(drawable);
        }
        else {
            this.mPendingOverflowIconSet = true;
            this.mPendingOverflowIcon = drawable;
        }
    }
    
    public void setReserveOverflow(final boolean mReserveOverflow) {
        this.mReserveOverflow = mReserveOverflow;
        this.mReserveOverflowSet = true;
    }
    
    public void setWidthLimit(final int mWidthLimit, final boolean mStrictWidthLimit) {
        this.mWidthLimit = mWidthLimit;
        this.mStrictWidthLimit = mStrictWidthLimit;
        this.mWidthLimitSet = true;
    }
    
    public boolean shouldIncludeItem(final int n, final MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }
    
    public boolean showOverflowMenu() {
        if (this.mReserveOverflow && !this.isOverflowMenuShowing() && this.mMenu != null && this.mMenuView != null && this.mPostedOpenRunnable == null && !this.mMenu.getNonActionItems().isEmpty()) {
            this.mPostedOpenRunnable = new ActionMenuPresenter$OpenOverflowRunnable(this, new ActionMenuPresenter$OverflowPopup(this, this.mContext, this.mMenu, (View)this.mOverflowButton, true));
            ((View)this.mMenuView).post((Runnable)this.mPostedOpenRunnable);
            super.onSubMenuSelected(null);
            return true;
        }
        return false;
    }
    
    public void updateMenuView(final boolean b) {
        final ViewGroup viewGroup = (ViewGroup)((View)this.mMenuView).getParent();
        if (viewGroup != null) {
            ActionBarTransition.beginDelayedTransition(viewGroup);
        }
        super.updateMenuView(b);
        ((View)this.mMenuView).requestLayout();
        if (this.mMenu != null) {
            final ArrayList actionItems = this.mMenu.getActionItems();
            for (int size = actionItems.size(), i = 0; i < size; ++i) {
                final ActionProvider supportActionProvider = actionItems.get(i).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        ArrayList<MenuItemImpl> nonActionItems;
        if (this.mMenu != null) {
            nonActionItems = (ArrayList<MenuItemImpl>)this.mMenu.getNonActionItems();
        }
        else {
            nonActionItems = null;
        }
        int n = 0;
        if (this.mReserveOverflow && nonActionItems != null) {
            final int size2 = nonActionItems.size();
            int n2 = 0;
            final boolean b2 = true;
            if (size2 == (b2 ? 1 : 0)) {
                n = ((nonActionItems.get(0).isActionViewExpanded() ^ b2) ? 1 : 0);
            }
            else {
                if (size2 > 0) {
                    n2 = 1;
                }
                n = n2;
            }
        }
        if (n != 0) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new ActionMenuPresenter$OverflowMenuButton(this, this.mSystemContext);
            }
            final ViewGroup viewGroup2 = (ViewGroup)this.mOverflowButton.getParent();
            if (viewGroup2 != this.mMenuView) {
                if (viewGroup2 != null) {
                    viewGroup2.removeView((View)this.mOverflowButton);
                }
                final ActionMenuView actionMenuView = (ActionMenuView)this.mMenuView;
                actionMenuView.addView((View)this.mOverflowButton, (ViewGroup$LayoutParams)actionMenuView.generateOverflowButtonLayoutParams());
            }
        }
        else {
            final ActionMenuPresenter$OverflowMenuButton mOverflowButton = this.mOverflowButton;
            if (mOverflowButton != null && mOverflowButton.getParent() == this.mMenuView) {
                ((ViewGroup)this.mMenuView).removeView((View)this.mOverflowButton);
            }
        }
        ((ActionMenuView)this.mMenuView).setOverflowReserved(this.mReserveOverflow);
    }
}
