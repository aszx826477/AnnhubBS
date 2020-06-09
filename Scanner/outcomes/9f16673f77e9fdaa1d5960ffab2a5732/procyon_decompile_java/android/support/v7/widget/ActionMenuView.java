// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.ContextThemeWrapper;
import android.content.res.Configuration;
import android.view.MenuItem;
import android.support.v7.view.menu.MenuItemImpl;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.MenuPresenter;
import android.view.Menu;
import android.view.accessibility.AccessibilityEvent;
import android.view.ViewGroup$LayoutParams;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View$MeasureSpec;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v7.view.menu.MenuBuilder$Callback;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.MenuBuilder$ItemInvoker;

public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder$ItemInvoker, MenuView
{
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private MenuPresenter$Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    MenuBuilder$Callback mMenuBuilderCallback;
    private int mMinCellSize;
    ActionMenuView$OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;
    
    public ActionMenuView(final Context context) {
        this(context, null);
    }
    
    public ActionMenuView(final Context mPopupContext, final AttributeSet set) {
        super(mPopupContext, set);
        this.setBaselineAligned(false);
        final float density = mPopupContext.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int)(56.0f * density);
        this.mGeneratedItemPadding = (int)(4.0f * density);
        this.mPopupContext = mPopupContext;
        this.mPopupTheme = 0;
    }
    
    static int measureChildForCells(final View view, final int n, final int n2, final int n3, final int n4) {
        final ActionMenuView$LayoutParams actionMenuView$LayoutParams = (ActionMenuView$LayoutParams)view.getLayoutParams();
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(View$MeasureSpec.getSize(n3) - n4, View$MeasureSpec.getMode(n3));
        ActionMenuItemView actionMenuItemView;
        if (view instanceof ActionMenuItemView) {
            actionMenuItemView = (ActionMenuItemView)view;
        }
        else {
            actionMenuItemView = null;
        }
        boolean expandable = false;
        final boolean b = actionMenuItemView != null && actionMenuItemView.hasText();
        int cellsUsed = 0;
        if (n2 > 0) {
            final int n5 = 2;
            if (!b || n2 >= n5) {
                view.measure(View$MeasureSpec.makeMeasureSpec(n * n2, -1 << -1), measureSpec);
                final int measuredWidth = view.getMeasuredWidth();
                cellsUsed = measuredWidth / n;
                if (measuredWidth % n != 0) {
                    ++cellsUsed;
                }
                if (b && cellsUsed < n5) {
                    cellsUsed = 2;
                }
            }
        }
        if (!actionMenuView$LayoutParams.isOverflowButton && b) {
            expandable = true;
        }
        actionMenuView$LayoutParams.expandable = expandable;
        actionMenuView$LayoutParams.cellsUsed = cellsUsed;
        view.measure(View$MeasureSpec.makeMeasureSpec(cellsUsed * n, 1073741824), measureSpec);
        return cellsUsed;
    }
    
    private void onMeasureExactFormat(final int n, final int n2) {
        final int mode = View$MeasureSpec.getMode(n2);
        final int size = View$MeasureSpec.getSize(n);
        final int size2 = View$MeasureSpec.getSize(n2);
        int n3 = this.getPaddingLeft() + this.getPaddingRight();
        int n4 = this.getPaddingTop() + this.getPaddingBottom();
        final int childMeasureSpec = getChildMeasureSpec(n2, n4, -2);
        int n5 = size - n3;
        final int mMinCellSize = this.mMinCellSize;
        int n6 = n5 / mMinCellSize;
        int n7 = n5 % mMinCellSize;
        if (n6 == 0) {
            this.setMeasuredDimension(n5, 0);
            return;
        }
        final int n8 = mMinCellSize + n7 / n6;
        boolean b = false;
        final long n9 = 0L;
        int childCount = this.getChildCount();
        final int n10 = size2;
        int max = 0;
        int n11 = 0;
        int n12 = 0;
        int max2 = 0;
        int n13 = n6;
        int n14 = 0;
        long n15 = n9;
        while (true) {
            final int n16 = n3;
            if (n14 >= childCount) {
                break;
            }
            final View child = this.getChildAt(n14);
            final int visibility = child.getVisibility();
            final int n17 = n6;
            int n18;
            int n19;
            if (visibility == 8) {
                n18 = n4;
                n19 = n7;
            }
            else {
                final boolean b2 = child instanceof ActionMenuItemView;
                ++n11;
                if (b2) {
                    final int mGeneratedItemPadding = this.mGeneratedItemPadding;
                    n19 = n7;
                    child.setPadding(mGeneratedItemPadding, 0, mGeneratedItemPadding, 0);
                }
                else {
                    n19 = n7;
                }
                final ActionMenuView$LayoutParams actionMenuView$LayoutParams = (ActionMenuView$LayoutParams)child.getLayoutParams();
                actionMenuView$LayoutParams.expanded = false;
                actionMenuView$LayoutParams.extraPixels = 0;
                actionMenuView$LayoutParams.cellsUsed = 0;
                actionMenuView$LayoutParams.expandable = false;
                actionMenuView$LayoutParams.leftMargin = 0;
                actionMenuView$LayoutParams.rightMargin = 0;
                actionMenuView$LayoutParams.preventEdgeOffset = (b2 && ((ActionMenuItemView)child).hasText());
                int n20;
                if (actionMenuView$LayoutParams.isOverflowButton) {
                    n20 = 1;
                }
                else {
                    n20 = n13;
                }
                final int measureChildForCells = measureChildForCells(child, n8, n20, childMeasureSpec, n4);
                max2 = Math.max(max2, measureChildForCells);
                n18 = n4;
                if (actionMenuView$LayoutParams.expandable) {
                    ++n12;
                }
                if (actionMenuView$LayoutParams.isOverflowButton) {
                    b = true;
                }
                n13 -= measureChildForCells;
                max = Math.max(max, child.getMeasuredHeight());
                final int n21 = 1;
                if (measureChildForCells == n21) {
                    n15 |= n21 << n14;
                }
            }
            ++n14;
            n3 = n16;
            n6 = n17;
            n7 = n19;
            n4 = n18;
        }
        final int n22 = 2;
        final boolean b3 = b && n11 == n22;
        int n23 = 0;
        float n24 = 0.0f;
        while (true) {
            while (n12 > 0 && n13 > 0) {
                long n25 = 0L;
                int n26 = -1 >>> 1;
                int n27 = 0;
                int n28;
                float n29;
                int n30;
                for (int i = 0; i < childCount; ++i, n23 = n28, n24 = n29, childCount = n30) {
                    final ViewGroup$LayoutParams layoutParams = this.getChildAt(i).getLayoutParams();
                    n28 = n23;
                    n29 = n24;
                    final ActionMenuView$LayoutParams actionMenuView$LayoutParams2 = (ActionMenuView$LayoutParams)layoutParams;
                    if (!actionMenuView$LayoutParams2.expandable) {
                        n30 = childCount;
                    }
                    else if (actionMenuView$LayoutParams2.cellsUsed < n26) {
                        final int cellsUsed = actionMenuView$LayoutParams2.cellsUsed;
                        final int n31 = 1 << i;
                        n30 = childCount;
                        final long n32 = n31;
                        n27 = 1;
                        n25 = n32;
                        n26 = cellsUsed;
                    }
                    else {
                        n30 = childCount;
                        if (actionMenuView$LayoutParams2.cellsUsed == n26) {
                            final long n33 = n25 | 1 << i;
                            ++n27;
                            n25 = n33;
                        }
                    }
                }
                int n34 = n23;
                int n35 = childCount;
                n15 |= n25;
                if (n27 > n13) {
                    final int n36 = max;
                    final int n37 = childCount;
                    final int n38 = n5;
                    final boolean b4 = !b && n11 == 1;
                    if (n13 > 0 && n15 != 0L && (n13 < n11 - 1 || b4 || max2 > 1)) {
                        float n39 = Long.bitCount(n15);
                        int n42;
                        if (!b4) {
                            final long n40 = n15 & 0x1L;
                            final float n41 = 0.5f;
                            if (n40 != 0L) {
                                n42 = 0;
                                if (!((ActionMenuView$LayoutParams)this.getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                                    n39 -= n41;
                                }
                            }
                            else {
                                n42 = 0;
                            }
                            if ((n15 & 1 << n37 - 1) != 0x0L) {
                                if (!((ActionMenuView$LayoutParams)this.getChildAt(n37 - 1).getLayoutParams()).preventEdgeOffset) {
                                    n39 -= n41;
                                }
                            }
                        }
                        else {
                            n42 = 0;
                        }
                        if (n39 > 0.0f) {
                            n42 = (int)(n13 * n8 / n39);
                        }
                        final int n43 = n42;
                        for (int j = 0; j < n37; ++j) {
                            if ((n15 & 1 << j) != 0x0L) {
                                final View child2 = this.getChildAt(j);
                                final ActionMenuView$LayoutParams actionMenuView$LayoutParams3 = (ActionMenuView$LayoutParams)child2.getLayoutParams();
                                if (child2 instanceof ActionMenuItemView) {
                                    actionMenuView$LayoutParams3.extraPixels = n43;
                                    actionMenuView$LayoutParams3.expanded = true;
                                    if (j == 0 && !actionMenuView$LayoutParams3.preventEdgeOffset) {
                                        actionMenuView$LayoutParams3.leftMargin = -n43 / 2;
                                    }
                                    n34 = 1;
                                }
                                else if (actionMenuView$LayoutParams3.isOverflowButton) {
                                    actionMenuView$LayoutParams3.extraPixels = n43;
                                    actionMenuView$LayoutParams3.expanded = true;
                                    actionMenuView$LayoutParams3.rightMargin = -n43 / 2;
                                    n34 = 1;
                                }
                                else {
                                    if (j != 0) {
                                        actionMenuView$LayoutParams3.leftMargin = n43 / 2;
                                    }
                                    if (j != n37 - 1) {
                                        actionMenuView$LayoutParams3.rightMargin = n43 / 2;
                                    }
                                }
                            }
                        }
                    }
                    final int n44 = 1073741824;
                    if (n34 != 0) {
                        for (int k = 0; k < n37; ++k) {
                            final View child3 = this.getChildAt(k);
                            final ActionMenuView$LayoutParams actionMenuView$LayoutParams4 = (ActionMenuView$LayoutParams)child3.getLayoutParams();
                            if (actionMenuView$LayoutParams4.expanded) {
                                child3.measure(View$MeasureSpec.makeMeasureSpec(actionMenuView$LayoutParams4.cellsUsed * n8 + actionMenuView$LayoutParams4.extraPixels, n44), childMeasureSpec);
                            }
                        }
                    }
                    int n45;
                    if (mode != n44) {
                        n45 = n36;
                    }
                    else {
                        n45 = n10;
                    }
                    this.setMeasuredDimension(n38, n45);
                    return;
                }
                final int n46 = n26 + 1;
                int n47 = 0;
                int n48;
                while (true) {
                    n48 = n35;
                    if (n47 >= n35) {
                        break;
                    }
                    final View child4 = this.getChildAt(n47);
                    final ActionMenuView$LayoutParams actionMenuView$LayoutParams5 = (ActionMenuView$LayoutParams)child4.getLayoutParams();
                    final int n49 = n27;
                    final int n50 = 1;
                    final int n51 = n50 << n47;
                    final int n52 = n5;
                    final int n53 = max;
                    if ((n25 & n51) == 0x0L) {
                        if (actionMenuView$LayoutParams5.cellsUsed == n46) {
                            n15 |= n50 << n47;
                        }
                    }
                    else {
                        if (b3 && actionMenuView$LayoutParams5.preventEdgeOffset && n13 == 1) {
                            final int mGeneratedItemPadding2 = this.mGeneratedItemPadding;
                            child4.setPadding(mGeneratedItemPadding2 + n8, 0, mGeneratedItemPadding2, 0);
                        }
                        final int cellsUsed2 = actionMenuView$LayoutParams5.cellsUsed;
                        final int expanded = 1;
                        actionMenuView$LayoutParams5.cellsUsed = cellsUsed2 + expanded;
                        actionMenuView$LayoutParams5.expanded = (expanded != 0);
                        --n13;
                    }
                    ++n47;
                    n27 = n49;
                    n5 = n52;
                    max = n53;
                    n35 = n48;
                }
                n23 = 1;
                n24 = Float.MIN_VALUE;
                childCount = n48;
            }
            final int n38 = n5;
            final int n36 = max;
            int n34 = n23;
            final int n37 = childCount;
            continue;
        }
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams != null && viewGroup$LayoutParams instanceof ActionMenuView$LayoutParams;
    }
    
    public void dismissPopupMenus() {
        final ActionMenuPresenter mPresenter = this.mPresenter;
        if (mPresenter != null) {
            mPresenter.dismissPopupMenus();
        }
    }
    
    public boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        return false;
    }
    
    protected ActionMenuView$LayoutParams generateDefaultLayoutParams() {
        final int n = -2;
        final ActionMenuView$LayoutParams actionMenuView$LayoutParams = new ActionMenuView$LayoutParams(n, n);
        actionMenuView$LayoutParams.gravity = 16;
        return actionMenuView$LayoutParams;
    }
    
    public ActionMenuView$LayoutParams generateLayoutParams(final AttributeSet set) {
        return new ActionMenuView$LayoutParams(this.getContext(), set);
    }
    
    protected ActionMenuView$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams != null) {
            ActionMenuView$LayoutParams actionMenuView$LayoutParams;
            if (viewGroup$LayoutParams instanceof ActionMenuView$LayoutParams) {
                actionMenuView$LayoutParams = new ActionMenuView$LayoutParams((ActionMenuView$LayoutParams)viewGroup$LayoutParams);
            }
            else {
                actionMenuView$LayoutParams = new ActionMenuView$LayoutParams(viewGroup$LayoutParams);
            }
            if (actionMenuView$LayoutParams.gravity <= 0) {
                actionMenuView$LayoutParams.gravity = 16;
            }
            return actionMenuView$LayoutParams;
        }
        return this.generateDefaultLayoutParams();
    }
    
    public ActionMenuView$LayoutParams generateOverflowButtonLayoutParams() {
        final ActionMenuView$LayoutParams generateDefaultLayoutParams = this.generateDefaultLayoutParams();
        generateDefaultLayoutParams.isOverflowButton = true;
        return generateDefaultLayoutParams;
    }
    
    public Menu getMenu() {
        if (this.mMenu == null) {
            final Context context = this.getContext();
            (this.mMenu = new MenuBuilder(context)).setCallback(new ActionMenuView$MenuBuilderCallback(this));
            (this.mPresenter = new ActionMenuPresenter(context)).setReserveOverflow(true);
            final ActionMenuPresenter mPresenter = this.mPresenter;
            MenuPresenter$Callback mActionMenuPresenterCallback = this.mActionMenuPresenterCallback;
            if (mActionMenuPresenterCallback == null) {
                mActionMenuPresenterCallback = new ActionMenuView$ActionMenuPresenterCallback(this);
            }
            mPresenter.setCallback(mActionMenuPresenterCallback);
            this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
            this.mPresenter.setMenuView(this);
        }
        return (Menu)this.mMenu;
    }
    
    public Drawable getOverflowIcon() {
        this.getMenu();
        return this.mPresenter.getOverflowIcon();
    }
    
    public int getPopupTheme() {
        return this.mPopupTheme;
    }
    
    public int getWindowAnimations() {
        return 0;
    }
    
    protected boolean hasSupportDividerBeforeChildAt(final int n) {
        if (n == 0) {
            return false;
        }
        final View child = this.getChildAt(n - 1);
        final View child2 = this.getChildAt(n);
        boolean b = false;
        if (n < this.getChildCount() && child instanceof ActionMenuView$ActionMenuChildView) {
            b = (false | ((ActionMenuView$ActionMenuChildView)child).needsDividerAfter());
        }
        if (n > 0 && child2 instanceof ActionMenuView$ActionMenuChildView) {
            b |= ((ActionMenuView$ActionMenuChildView)child2).needsDividerBefore();
        }
        return b;
    }
    
    public boolean hideOverflowMenu() {
        final ActionMenuPresenter mPresenter = this.mPresenter;
        return mPresenter != null && mPresenter.hideOverflowMenu();
    }
    
    public void initialize(final MenuBuilder mMenu) {
        this.mMenu = mMenu;
    }
    
    public boolean invokeItem(final MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction((MenuItem)menuItemImpl, 0);
    }
    
    public boolean isOverflowMenuShowPending() {
        final ActionMenuPresenter mPresenter = this.mPresenter;
        return mPresenter != null && mPresenter.isOverflowMenuShowPending();
    }
    
    public boolean isOverflowMenuShowing() {
        final ActionMenuPresenter mPresenter = this.mPresenter;
        return mPresenter != null && mPresenter.isOverflowMenuShowing();
    }
    
    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        final ActionMenuPresenter mPresenter = this.mPresenter;
        if (mPresenter != null) {
            mPresenter.updateMenuView(false);
            if (this.mPresenter.isOverflowMenuShowing()) {
                this.mPresenter.hideOverflowMenu();
                this.mPresenter.showOverflowMenu();
            }
        }
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dismissPopupMenus();
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        ActionMenuView actionMenuView = this;
        if (!this.mFormatItems) {
            super.onLayout(b, n, n2, n3, n4);
            return;
        }
        final int childCount = this.getChildCount();
        int n5 = (n4 - n2) / 2;
        int dividerWidth = this.getDividerWidth();
        int measuredWidth = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = n3 - n - this.getPaddingRight() - this.getPaddingLeft();
        boolean b2 = false;
        int layoutRtl = ViewUtils.isLayoutRtl((View)this) ? 1 : 0;
        int n9 = 0;
        int n10;
        while (true) {
            n10 = 8;
            if (n9 >= childCount) {
                break;
            }
            final View child = actionMenuView.getChildAt(n9);
            int n11;
            int n12;
            if (child.getVisibility() == n10) {
                n11 = n5;
                n12 = layoutRtl;
            }
            else {
                final ActionMenuView$LayoutParams actionMenuView$LayoutParams = (ActionMenuView$LayoutParams)child.getLayoutParams();
                if (actionMenuView$LayoutParams.isOverflowButton) {
                    measuredWidth = child.getMeasuredWidth();
                    if (actionMenuView.hasSupportDividerBeforeChildAt(n9)) {
                        measuredWidth += dividerWidth;
                    }
                    final int measuredHeight = child.getMeasuredHeight();
                    int n13;
                    int n14;
                    if (layoutRtl != 0) {
                        n13 = this.getPaddingLeft() + actionMenuView$LayoutParams.leftMargin;
                        n14 = n13 + measuredWidth;
                    }
                    else {
                        n14 = this.getWidth() - this.getPaddingRight() - actionMenuView$LayoutParams.rightMargin;
                        n13 = n14 - measuredWidth;
                    }
                    final int n15 = measuredHeight / 2;
                    n12 = layoutRtl;
                    final int n16 = n5 - n15;
                    n11 = n5;
                    child.layout(n13, n16, n14, n16 + measuredHeight);
                    n8 -= measuredWidth;
                    b2 = true;
                }
                else {
                    n11 = n5;
                    n12 = layoutRtl;
                    final int n17 = child.getMeasuredWidth() + actionMenuView$LayoutParams.leftMargin + actionMenuView$LayoutParams.rightMargin;
                    n6 += n17;
                    n8 -= n17;
                    if (actionMenuView.hasSupportDividerBeforeChildAt(n9)) {
                        n6 += dividerWidth;
                    }
                    ++n7;
                }
            }
            ++n9;
            n5 = n11;
            layoutRtl = n12;
        }
        final int n18 = n5;
        final int n19 = layoutRtl;
        int n20 = 1;
        if (childCount == n20 && !b2) {
            final View child2 = actionMenuView.getChildAt(0);
            final int measuredWidth2 = child2.getMeasuredWidth();
            final int measuredHeight2 = child2.getMeasuredHeight();
            final int n21 = (n3 - n) / 2 - measuredWidth2 / 2;
            final int n22 = n18 - measuredHeight2 / 2;
            child2.layout(n21, n22, n21 + measuredWidth2, n22 + measuredHeight2);
            return;
        }
        if (b2) {
            n20 = 0;
        }
        final int n23 = n7 - n20;
        int n24;
        if (n23 > 0) {
            n24 = n8 / n23;
        }
        else {
            n24 = 0;
        }
        final int max = Math.max(0, n24);
        if (n19 != 0) {
            int n25 = this.getWidth() - this.getPaddingRight();
            int n26;
            int n27;
            for (int i = 0; i < childCount; ++i, dividerWidth = n26, measuredWidth = n27, n10 = 8) {
                final View child3 = actionMenuView.getChildAt(i);
                final ActionMenuView$LayoutParams actionMenuView$LayoutParams2 = (ActionMenuView$LayoutParams)child3.getLayoutParams();
                if (child3.getVisibility() != n10) {
                    if (actionMenuView$LayoutParams2.isOverflowButton) {
                        n26 = dividerWidth;
                        n27 = measuredWidth;
                    }
                    else {
                        final int n28 = n25 - actionMenuView$LayoutParams2.rightMargin;
                        final int measuredWidth3 = child3.getMeasuredWidth();
                        final int measuredHeight3 = child3.getMeasuredHeight();
                        final int n29 = n18 - measuredHeight3 / 2;
                        n26 = dividerWidth;
                        final int n30 = n28 - measuredWidth3;
                        n27 = measuredWidth;
                        child3.layout(n30, n29, n28, n29 + measuredHeight3);
                        n25 = n28 - (actionMenuView$LayoutParams2.leftMargin + measuredWidth3 + max);
                    }
                }
                else {
                    n26 = dividerWidth;
                    n27 = measuredWidth;
                }
            }
        }
        else {
            int paddingLeft = this.getPaddingLeft();
            for (int j = 0; j < childCount; ++j, actionMenuView = this) {
                final View child4 = actionMenuView.getChildAt(j);
                final ActionMenuView$LayoutParams actionMenuView$LayoutParams3 = (ActionMenuView$LayoutParams)child4.getLayoutParams();
                if (child4.getVisibility() != 8) {
                    if (!actionMenuView$LayoutParams3.isOverflowButton) {
                        final int n31 = paddingLeft + actionMenuView$LayoutParams3.leftMargin;
                        final int measuredWidth4 = child4.getMeasuredWidth();
                        final int measuredHeight4 = child4.getMeasuredHeight();
                        final int n32 = n18 - measuredHeight4 / 2;
                        child4.layout(n31, n32, n31 + measuredWidth4, n32 + measuredHeight4);
                        paddingLeft = n31 + (actionMenuView$LayoutParams3.rightMargin + measuredWidth4 + max);
                    }
                }
            }
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        final boolean mFormatItems = this.mFormatItems;
        final int mode = View$MeasureSpec.getMode(n);
        final boolean b = true;
        this.mFormatItems = (mode == 1073741824);
        if (mFormatItems != this.mFormatItems) {
            this.mFormatItemsWidth = 0;
        }
        final int size = View$MeasureSpec.getSize(n);
        if (this.mFormatItems) {
            final MenuBuilder mMenu = this.mMenu;
            if (mMenu != null && size != this.mFormatItemsWidth) {
                this.mFormatItemsWidth = size;
                mMenu.onItemsChanged(b);
            }
        }
        final int childCount = this.getChildCount();
        if (this.mFormatItems && childCount > 0) {
            this.onMeasureExactFormat(n, n2);
        }
        else {
            for (int i = 0; i < childCount; ++i) {
                final ActionMenuView$LayoutParams actionMenuView$LayoutParams = (ActionMenuView$LayoutParams)this.getChildAt(i).getLayoutParams();
                actionMenuView$LayoutParams.rightMargin = 0;
                actionMenuView$LayoutParams.leftMargin = 0;
            }
            super.onMeasure(n, n2);
        }
    }
    
    public MenuBuilder peekMenu() {
        return this.mMenu;
    }
    
    public void setExpandedActionViewsExclusive(final boolean expandedActionViewsExclusive) {
        this.mPresenter.setExpandedActionViewsExclusive(expandedActionViewsExclusive);
    }
    
    public void setMenuCallbacks(final MenuPresenter$Callback mActionMenuPresenterCallback, final MenuBuilder$Callback mMenuBuilderCallback) {
        this.mActionMenuPresenterCallback = mActionMenuPresenterCallback;
        this.mMenuBuilderCallback = mMenuBuilderCallback;
    }
    
    public void setOnMenuItemClickListener(final ActionMenuView$OnMenuItemClickListener mOnMenuItemClickListener) {
        this.mOnMenuItemClickListener = mOnMenuItemClickListener;
    }
    
    public void setOverflowIcon(final Drawable overflowIcon) {
        this.getMenu();
        this.mPresenter.setOverflowIcon(overflowIcon);
    }
    
    public void setOverflowReserved(final boolean mReserveOverflow) {
        this.mReserveOverflow = mReserveOverflow;
    }
    
    public void setPopupTheme(final int mPopupTheme) {
        if (this.mPopupTheme != mPopupTheme) {
            if ((this.mPopupTheme = mPopupTheme) == 0) {
                this.mPopupContext = this.getContext();
            }
            else {
                this.mPopupContext = (Context)new ContextThemeWrapper(this.getContext(), mPopupTheme);
            }
        }
    }
    
    public void setPresenter(final ActionMenuPresenter mPresenter) {
        (this.mPresenter = mPresenter).setMenuView(this);
    }
    
    public boolean showOverflowMenu() {
        final ActionMenuPresenter mPresenter = this.mPresenter;
        return mPresenter != null && mPresenter.showOverflowMenu();
    }
}
