// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.text.TextUtils$TruncateAt;
import android.view.ContextThemeWrapper;
import android.support.v7.content.res.AppCompatResources;
import android.os.Build$VERSION;
import android.view.MenuItem;
import android.support.v4.view.MenuItemCompat;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.text.Layout;
import android.view.Menu;
import android.support.v7.app.ActionBar$LayoutParams;
import android.view.View$OnClickListener;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.View$MeasureSpec;
import android.support.v7.view.SupportMenuInflater;
import android.view.MenuInflater;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.view.ViewGroup$MarginLayoutParams;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.view.ViewGroup$LayoutParams;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import java.util.List;
import android.text.TextUtils;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.appcompat.R$attr;
import android.util.AttributeSet;
import android.widget.TextView;
import android.content.Context;
import android.support.v7.view.menu.MenuBuilder$Callback;
import android.widget.ImageView;
import java.util.ArrayList;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.widget.ImageButton;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.view.ViewGroup;

public class Toolbar extends ViewGroup
{
    private static final String TAG = "Toolbar";
    private MenuPresenter$Callback mActionMenuPresenterCallback;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private RtlSpacingHelper mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private Toolbar$ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private MenuBuilder$Callback mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final ActionMenuView$OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    Toolbar$OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private int mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private int mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;
    
    public Toolbar(final Context context) {
        this(context, null);
    }
    
    public Toolbar(final Context context, final AttributeSet set) {
        this(context, set, R$attr.toolbarStyle);
    }
    
    public Toolbar(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList();
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new Toolbar$1(this);
        this.mShowOverflowMenuRunnable = new Toolbar$2(this);
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.getContext(), set, R$styleable.Toolbar, n, 0);
        this.mTitleTextAppearance = obtainStyledAttributes.getResourceId(R$styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = obtainStyledAttributes.getResourceId(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = obtainStyledAttributes.getInteger(R$styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = obtainStyledAttributes.getInteger(R$styleable.Toolbar_buttonGravity, 48);
        int n2 = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.Toolbar_titleMargin, 0);
        if (obtainStyledAttributes.hasValue(R$styleable.Toolbar_titleMargins)) {
            n2 = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.Toolbar_titleMargins, n2);
        }
        this.mTitleMarginBottom = n2;
        this.mTitleMarginTop = n2;
        this.mTitleMarginEnd = n2;
        this.mTitleMarginStart = n2;
        final int toolbar_titleMarginStart = R$styleable.Toolbar_titleMarginStart;
        final int n3 = -1;
        final int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(toolbar_titleMarginStart, n3);
        if (dimensionPixelOffset >= 0) {
            this.mTitleMarginStart = dimensionPixelOffset;
        }
        final int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.Toolbar_titleMarginEnd, n3);
        if (dimensionPixelOffset2 >= 0) {
            this.mTitleMarginEnd = dimensionPixelOffset2;
        }
        final int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.Toolbar_titleMarginTop, n3);
        if (dimensionPixelOffset3 >= 0) {
            this.mTitleMarginTop = dimensionPixelOffset3;
        }
        final int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.Toolbar_titleMarginBottom, n3);
        if (dimensionPixelOffset4 >= 0) {
            this.mTitleMarginBottom = dimensionPixelOffset4;
        }
        this.mMaxButtonHeight = obtainStyledAttributes.getDimensionPixelSize(R$styleable.Toolbar_maxButtonHeight, n3);
        final int toolbar_contentInsetStart = R$styleable.Toolbar_contentInsetStart;
        final int n4 = -1 << -1;
        final int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(toolbar_contentInsetStart, n4);
        final int dimensionPixelOffset6 = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.Toolbar_contentInsetEnd, n4);
        final int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.Toolbar_contentInsetLeft, 0);
        final int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.Toolbar_contentInsetRight, 0);
        this.ensureContentInsets();
        this.mContentInsets.setAbsolute(dimensionPixelSize, dimensionPixelSize2);
        if (dimensionPixelOffset5 != n4 || dimensionPixelOffset6 != n4) {
            this.mContentInsets.setRelative(dimensionPixelOffset5, dimensionPixelOffset6);
        }
        this.mContentInsetStartWithNavigation = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.Toolbar_contentInsetStartWithNavigation, n4);
        this.mContentInsetEndWithActions = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.Toolbar_contentInsetEndWithActions, n4);
        this.mCollapseIcon = obtainStyledAttributes.getDrawable(R$styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = obtainStyledAttributes.getText(R$styleable.Toolbar_collapseContentDescription);
        final CharSequence text = obtainStyledAttributes.getText(R$styleable.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            this.setTitle(text);
        }
        final CharSequence text2 = obtainStyledAttributes.getText(R$styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            this.setSubtitle(text2);
        }
        this.mPopupContext = this.getContext();
        this.setPopupTheme(obtainStyledAttributes.getResourceId(R$styleable.Toolbar_popupTheme, 0));
        final Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.Toolbar_navigationIcon);
        if (drawable != null) {
            this.setNavigationIcon(drawable);
        }
        final CharSequence text3 = obtainStyledAttributes.getText(R$styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            this.setNavigationContentDescription(text3);
        }
        final Drawable drawable2 = obtainStyledAttributes.getDrawable(R$styleable.Toolbar_logo);
        if (drawable2 != null) {
            this.setLogo(drawable2);
        }
        final CharSequence text4 = obtainStyledAttributes.getText(R$styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            this.setLogoDescription(text4);
        }
        int n5;
        if (obtainStyledAttributes.hasValue(R$styleable.Toolbar_titleTextColor)) {
            final int toolbar_titleTextColor = R$styleable.Toolbar_titleTextColor;
            n5 = -1;
            this.setTitleTextColor(obtainStyledAttributes.getColor(toolbar_titleTextColor, n5));
        }
        else {
            n5 = -1;
        }
        if (obtainStyledAttributes.hasValue(R$styleable.Toolbar_subtitleTextColor)) {
            this.setSubtitleTextColor(obtainStyledAttributes.getColor(R$styleable.Toolbar_subtitleTextColor, n5));
        }
        obtainStyledAttributes.recycle();
    }
    
    private void addCustomViewsWithGravity(final List list, final int n) {
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        int n2 = 1;
        if (layoutDirection != n2) {
            n2 = 0;
        }
        final int n3 = n2;
        final int childCount = this.getChildCount();
        final int absoluteGravity = GravityCompat.getAbsoluteGravity(n, ViewCompat.getLayoutDirection((View)this));
        list.clear();
        if (n3 != 0) {
            for (int i = childCount - 1; i >= 0; --i) {
                final View child = this.getChildAt(i);
                final Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)child.getLayoutParams();
                if (toolbar$LayoutParams.mViewType == 0 && this.shouldLayout(child)) {
                    if (this.getChildHorizontalGravity(toolbar$LayoutParams.gravity) == absoluteGravity) {
                        list.add(child);
                    }
                }
            }
        }
        else {
            for (int j = 0; j < childCount; ++j) {
                final View child2 = this.getChildAt(j);
                final Toolbar$LayoutParams toolbar$LayoutParams2 = (Toolbar$LayoutParams)child2.getLayoutParams();
                if (toolbar$LayoutParams2.mViewType == 0 && this.shouldLayout(child2)) {
                    if (this.getChildHorizontalGravity(toolbar$LayoutParams2.gravity) == absoluteGravity) {
                        list.add(child2);
                    }
                }
            }
        }
    }
    
    private void addSystemView(final View view, final boolean b) {
        final ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        Toolbar$LayoutParams layoutParams2;
        if (layoutParams == null) {
            layoutParams2 = this.generateDefaultLayoutParams();
        }
        else if (!this.checkLayoutParams(layoutParams)) {
            layoutParams2 = this.generateLayoutParams(layoutParams);
        }
        else {
            layoutParams2 = (Toolbar$LayoutParams)layoutParams;
        }
        layoutParams2.mViewType = 1;
        if (b && this.mExpandedActionView != null) {
            view.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
            this.mHiddenViews.add(view);
        }
        else {
            this.addView(view, (ViewGroup$LayoutParams)layoutParams2);
        }
    }
    
    private void ensureContentInsets() {
        if (this.mContentInsets == null) {
            this.mContentInsets = new RtlSpacingHelper();
        }
    }
    
    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new AppCompatImageView(this.getContext());
        }
    }
    
    private void ensureMenu() {
        this.ensureMenuView();
        if (this.mMenuView.peekMenu() == null) {
            final MenuBuilder menuBuilder = (MenuBuilder)this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new Toolbar$ExpandedActionViewMenuPresenter(this);
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }
    
    private void ensureMenuView() {
        if (this.mMenuView == null) {
            (this.mMenuView = new ActionMenuView(this.getContext())).setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            final Toolbar$LayoutParams generateDefaultLayoutParams = this.generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (0x800005 | (this.mButtonGravity & 0x70));
            this.mMenuView.setLayoutParams((ViewGroup$LayoutParams)generateDefaultLayoutParams);
            this.addSystemView((View)this.mMenuView, false);
        }
    }
    
    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new AppCompatImageButton(this.getContext(), null, R$attr.toolbarNavigationButtonStyle);
            final Toolbar$LayoutParams generateDefaultLayoutParams = this.generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (0x800003 | (this.mButtonGravity & 0x70));
            this.mNavButtonView.setLayoutParams((ViewGroup$LayoutParams)generateDefaultLayoutParams);
        }
    }
    
    private int getChildHorizontalGravity(final int n) {
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        final int n2 = GravityCompat.getAbsoluteGravity(n, layoutDirection) & 0x7;
        final boolean b = true;
        if (n2 != (b ? 1 : 0)) {
            int n3 = 3;
            if (n2 != n3 && n2 != 5) {
                if (layoutDirection == (b ? 1 : 0)) {
                    n3 = 5;
                }
                return n3;
            }
        }
        return n2;
    }
    
    private int getChildTop(final View view, final int n) {
        final Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)view.getLayoutParams();
        final int measuredHeight = view.getMeasuredHeight();
        int n2;
        if (n > 0) {
            n2 = (measuredHeight - n) / 2;
        }
        else {
            n2 = 0;
        }
        final int childVerticalGravity = this.getChildVerticalGravity(toolbar$LayoutParams.gravity);
        if (childVerticalGravity == 48) {
            return this.getPaddingTop() - n2;
        }
        if (childVerticalGravity != 80) {
            final int paddingTop = this.getPaddingTop();
            final int paddingBottom = this.getPaddingBottom();
            final int height = this.getHeight();
            int n3 = (height - paddingTop - paddingBottom - measuredHeight) / 2;
            if (n3 < toolbar$LayoutParams.topMargin) {
                n3 = toolbar$LayoutParams.topMargin;
            }
            else {
                final int n4 = height - paddingBottom - measuredHeight - n3 - paddingTop;
                if (n4 < toolbar$LayoutParams.bottomMargin) {
                    n3 = Math.max(0, n3 - (toolbar$LayoutParams.bottomMargin - n4));
                }
            }
            return paddingTop + n3;
        }
        return this.getHeight() - this.getPaddingBottom() - measuredHeight - toolbar$LayoutParams.bottomMargin - n2;
    }
    
    private int getChildVerticalGravity(final int n) {
        final int n2 = n & 0x70;
        if (n2 != 16 && n2 != 48 && n2 != 80) {
            return this.mGravity & 0x70;
        }
        return n2;
    }
    
    private int getHorizontalMargins(final View view) {
        final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)view.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginStart(viewGroup$MarginLayoutParams) + MarginLayoutParamsCompat.getMarginEnd(viewGroup$MarginLayoutParams);
    }
    
    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.getContext());
    }
    
    private int getVerticalMargins(final View view) {
        final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)view.getLayoutParams();
        return viewGroup$MarginLayoutParams.topMargin + viewGroup$MarginLayoutParams.bottomMargin;
    }
    
    private int getViewListMeasuredWidth(final List list, final int[] array) {
        int max = array[0];
        int max2 = array[1];
        int n = 0;
        for (int size = list.size(), i = 0; i < size; ++i) {
            final View view = list.get(i);
            final Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)view.getLayoutParams();
            final int n2 = toolbar$LayoutParams.leftMargin - max;
            final int n3 = toolbar$LayoutParams.rightMargin - max2;
            final int max3 = Math.max(0, n2);
            final int max4 = Math.max(0, n3);
            max = Math.max(0, -n2);
            max2 = Math.max(0, -n3);
            n += view.getMeasuredWidth() + max3 + max4;
        }
        return n;
    }
    
    private boolean isChildOrHidden(final View view) {
        return view.getParent() == this || this.mHiddenViews.contains(view);
    }
    
    private static boolean isCustomView(final View view) {
        return ((Toolbar$LayoutParams)view.getLayoutParams()).mViewType == 0;
    }
    
    private int layoutChildLeft(final View view, int n, final int[] array, final int n2) {
        final Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)view.getLayoutParams();
        final int n3 = toolbar$LayoutParams.leftMargin - array[0];
        n += Math.max(0, n3);
        array[0] = Math.max(0, -n3);
        final int childTop = this.getChildTop(view, n2);
        final int measuredWidth = view.getMeasuredWidth();
        view.layout(n, childTop, n + measuredWidth, view.getMeasuredHeight() + childTop);
        return n + (toolbar$LayoutParams.rightMargin + measuredWidth);
    }
    
    private int layoutChildRight(final View view, int n, final int[] array, final int n2) {
        final Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)view.getLayoutParams();
        final int rightMargin = toolbar$LayoutParams.rightMargin;
        final int n3 = 1;
        final int n4 = rightMargin - array[n3];
        n -= Math.max(0, n4);
        array[n3] = Math.max(0, -n4);
        final int childTop = this.getChildTop(view, n2);
        final int measuredWidth = view.getMeasuredWidth();
        view.layout(n - measuredWidth, childTop, n, view.getMeasuredHeight() + childTop);
        return n - (toolbar$LayoutParams.leftMargin + measuredWidth);
    }
    
    private int measureChildCollapseMargins(final View view, final int n, final int n2, final int n3, final int n4, final int[] array) {
        final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)view.getLayoutParams();
        final int n5 = viewGroup$MarginLayoutParams.leftMargin - array[0];
        final int rightMargin = viewGroup$MarginLayoutParams.rightMargin;
        final int n6 = 1;
        final int n7 = rightMargin - array[n6];
        final int n8 = Math.max(0, n5) + Math.max(0, n7);
        array[0] = Math.max(0, -n5);
        array[n6] = Math.max(0, -n7);
        view.measure(getChildMeasureSpec(n, this.getPaddingLeft() + this.getPaddingRight() + n8 + n2, viewGroup$MarginLayoutParams.width), getChildMeasureSpec(n3, this.getPaddingTop() + this.getPaddingBottom() + viewGroup$MarginLayoutParams.topMargin + viewGroup$MarginLayoutParams.bottomMargin + n4, viewGroup$MarginLayoutParams.height));
        return view.getMeasuredWidth() + n8;
    }
    
    private void measureChildConstrained(final View view, final int n, final int n2, final int n3, final int n4, final int n5) {
        final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)view.getLayoutParams();
        final int childMeasureSpec = getChildMeasureSpec(n, this.getPaddingLeft() + this.getPaddingRight() + viewGroup$MarginLayoutParams.leftMargin + viewGroup$MarginLayoutParams.rightMargin + n2, viewGroup$MarginLayoutParams.width);
        int n6 = getChildMeasureSpec(n3, this.getPaddingTop() + this.getPaddingBottom() + viewGroup$MarginLayoutParams.topMargin + viewGroup$MarginLayoutParams.bottomMargin + n4, viewGroup$MarginLayoutParams.height);
        final int mode = View$MeasureSpec.getMode(n6);
        final int n7 = 1073741824;
        if (mode != n7 && n5 >= 0) {
            int min;
            if (mode != 0) {
                min = Math.min(View$MeasureSpec.getSize(n6), n5);
            }
            else {
                min = n5;
            }
            n6 = View$MeasureSpec.makeMeasureSpec(min, n7);
        }
        view.measure(childMeasureSpec, n6);
    }
    
    private void postShowOverflowMenu() {
        this.removeCallbacks(this.mShowOverflowMenuRunnable);
        this.post(this.mShowOverflowMenuRunnable);
    }
    
    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (this.shouldLayout(child) && child.getMeasuredWidth() > 0 && child.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }
    
    private boolean shouldLayout(final View view) {
        return view != null && view.getParent() == this && view.getVisibility() != 8;
    }
    
    void addChildrenForExpandedActionView() {
        for (int i = this.mHiddenViews.size() - 1; i >= 0; --i) {
            this.addView((View)this.mHiddenViews.get(i));
        }
        this.mHiddenViews.clear();
    }
    
    public boolean canShowOverflowMenu() {
        if (this.getVisibility() == 0) {
            final ActionMenuView mMenuView = this.mMenuView;
            if (mMenuView != null && mMenuView.isOverflowReserved()) {
                return true;
            }
        }
        return false;
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return super.checkLayoutParams(viewGroup$LayoutParams) && viewGroup$LayoutParams instanceof Toolbar$LayoutParams;
    }
    
    public void collapseActionView() {
        final Toolbar$ExpandedActionViewMenuPresenter mExpandedMenuPresenter = this.mExpandedMenuPresenter;
        MenuItemImpl mCurrentExpandedItem;
        if (mExpandedMenuPresenter == null) {
            mCurrentExpandedItem = null;
        }
        else {
            mCurrentExpandedItem = mExpandedMenuPresenter.mCurrentExpandedItem;
        }
        if (mCurrentExpandedItem != null) {
            mCurrentExpandedItem.collapseActionView();
        }
    }
    
    public void dismissPopupMenus() {
        final ActionMenuView mMenuView = this.mMenuView;
        if (mMenuView != null) {
            mMenuView.dismissPopupMenus();
        }
    }
    
    void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            (this.mCollapseButtonView = new AppCompatImageButton(this.getContext(), null, R$attr.toolbarNavigationButtonStyle)).setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            final Toolbar$LayoutParams generateDefaultLayoutParams = this.generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (0x800003 | (this.mButtonGravity & 0x70));
            generateDefaultLayoutParams.mViewType = 2;
            this.mCollapseButtonView.setLayoutParams((ViewGroup$LayoutParams)generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener((View$OnClickListener)new Toolbar$3(this));
        }
    }
    
    protected Toolbar$LayoutParams generateDefaultLayoutParams() {
        final int n = -2;
        return new Toolbar$LayoutParams(n, n);
    }
    
    public Toolbar$LayoutParams generateLayoutParams(final AttributeSet set) {
        return new Toolbar$LayoutParams(this.getContext(), set);
    }
    
    protected Toolbar$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof Toolbar$LayoutParams) {
            return new Toolbar$LayoutParams((Toolbar$LayoutParams)viewGroup$LayoutParams);
        }
        if (viewGroup$LayoutParams instanceof ActionBar$LayoutParams) {
            return new Toolbar$LayoutParams((ActionBar$LayoutParams)viewGroup$LayoutParams);
        }
        if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            return new Toolbar$LayoutParams((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        return new Toolbar$LayoutParams(viewGroup$LayoutParams);
    }
    
    public int getContentInsetEnd() {
        final RtlSpacingHelper mContentInsets = this.mContentInsets;
        int end;
        if (mContentInsets != null) {
            end = mContentInsets.getEnd();
        }
        else {
            end = 0;
        }
        return end;
    }
    
    public int getContentInsetEndWithActions() {
        int n = this.mContentInsetEndWithActions;
        if (n == -1 << -1) {
            n = this.getContentInsetEnd();
        }
        return n;
    }
    
    public int getContentInsetLeft() {
        final RtlSpacingHelper mContentInsets = this.mContentInsets;
        int left;
        if (mContentInsets != null) {
            left = mContentInsets.getLeft();
        }
        else {
            left = 0;
        }
        return left;
    }
    
    public int getContentInsetRight() {
        final RtlSpacingHelper mContentInsets = this.mContentInsets;
        int right;
        if (mContentInsets != null) {
            right = mContentInsets.getRight();
        }
        else {
            right = 0;
        }
        return right;
    }
    
    public int getContentInsetStart() {
        final RtlSpacingHelper mContentInsets = this.mContentInsets;
        int start;
        if (mContentInsets != null) {
            start = mContentInsets.getStart();
        }
        else {
            start = 0;
        }
        return start;
    }
    
    public int getContentInsetStartWithNavigation() {
        int n = this.mContentInsetStartWithNavigation;
        if (n == -1 << -1) {
            n = this.getContentInsetStart();
        }
        return n;
    }
    
    public int getCurrentContentInsetEnd() {
        int n = 0;
        final ActionMenuView mMenuView = this.mMenuView;
        if (mMenuView != null) {
            final MenuBuilder peekMenu = mMenuView.peekMenu();
            n = ((peekMenu != null && peekMenu.hasVisibleItems()) ? 1 : 0);
        }
        int n2;
        if (n != 0) {
            n2 = Math.max(this.getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
        }
        else {
            n2 = this.getContentInsetEnd();
        }
        return n2;
    }
    
    public int getCurrentContentInsetLeft() {
        int n;
        if (ViewCompat.getLayoutDirection((View)this) == 1) {
            n = this.getCurrentContentInsetEnd();
        }
        else {
            n = this.getCurrentContentInsetStart();
        }
        return n;
    }
    
    public int getCurrentContentInsetRight() {
        int n;
        if (ViewCompat.getLayoutDirection((View)this) == 1) {
            n = this.getCurrentContentInsetStart();
        }
        else {
            n = this.getCurrentContentInsetEnd();
        }
        return n;
    }
    
    public int getCurrentContentInsetStart() {
        int n;
        if (this.getNavigationIcon() != null) {
            n = Math.max(this.getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
        }
        else {
            n = this.getContentInsetStart();
        }
        return n;
    }
    
    public Drawable getLogo() {
        final ImageView mLogoView = this.mLogoView;
        Drawable drawable;
        if (mLogoView != null) {
            drawable = mLogoView.getDrawable();
        }
        else {
            drawable = null;
        }
        return drawable;
    }
    
    public CharSequence getLogoDescription() {
        final ImageView mLogoView = this.mLogoView;
        CharSequence contentDescription;
        if (mLogoView != null) {
            contentDescription = mLogoView.getContentDescription();
        }
        else {
            contentDescription = null;
        }
        return contentDescription;
    }
    
    public Menu getMenu() {
        this.ensureMenu();
        return this.mMenuView.getMenu();
    }
    
    public CharSequence getNavigationContentDescription() {
        final ImageButton mNavButtonView = this.mNavButtonView;
        CharSequence contentDescription;
        if (mNavButtonView != null) {
            contentDescription = mNavButtonView.getContentDescription();
        }
        else {
            contentDescription = null;
        }
        return contentDescription;
    }
    
    public Drawable getNavigationIcon() {
        final ImageButton mNavButtonView = this.mNavButtonView;
        Drawable drawable;
        if (mNavButtonView != null) {
            drawable = mNavButtonView.getDrawable();
        }
        else {
            drawable = null;
        }
        return drawable;
    }
    
    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }
    
    public Drawable getOverflowIcon() {
        this.ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }
    
    Context getPopupContext() {
        return this.mPopupContext;
    }
    
    public int getPopupTheme() {
        return this.mPopupTheme;
    }
    
    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }
    
    public CharSequence getTitle() {
        return this.mTitleText;
    }
    
    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }
    
    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }
    
    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }
    
    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }
    
    public DecorToolbar getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new ToolbarWidgetWrapper(this, true);
        }
        return this.mWrapper;
    }
    
    public boolean hasExpandedActionView() {
        final Toolbar$ExpandedActionViewMenuPresenter mExpandedMenuPresenter = this.mExpandedMenuPresenter;
        return mExpandedMenuPresenter != null && mExpandedMenuPresenter.mCurrentExpandedItem != null;
    }
    
    public boolean hideOverflowMenu() {
        final ActionMenuView mMenuView = this.mMenuView;
        return mMenuView != null && mMenuView.hideOverflowMenu();
    }
    
    public void inflateMenu(final int n) {
        this.getMenuInflater().inflate(n, this.getMenu());
    }
    
    public boolean isOverflowMenuShowPending() {
        final ActionMenuView mMenuView = this.mMenuView;
        return mMenuView != null && mMenuView.isOverflowMenuShowPending();
    }
    
    public boolean isOverflowMenuShowing() {
        final ActionMenuView mMenuView = this.mMenuView;
        return mMenuView != null && mMenuView.isOverflowMenuShowing();
    }
    
    public boolean isTitleTruncated() {
        final TextView mTitleTextView = this.mTitleTextView;
        if (mTitleTextView == null) {
            return false;
        }
        final Layout layout = mTitleTextView.getLayout();
        if (layout == null) {
            return false;
        }
        for (int lineCount = layout.getLineCount(), i = 0; i < lineCount; ++i) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks(this.mShowOverflowMenuRunnable);
    }
    
    public boolean onHoverEvent(final MotionEvent motionEvent) {
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        final int n = 9;
        if (actionMasked == n) {
            this.mEatingHover = false;
        }
        final boolean mEatingHover = this.mEatingHover;
        final boolean mEatingHover2 = true;
        if (!mEatingHover) {
            final boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == n && !onHoverEvent) {
                this.mEatingHover = mEatingHover2;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return mEatingHover2;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        final int n5 = 1;
        final boolean b2 = layoutDirection == n5;
        final int width = this.getWidth();
        final int height = this.getHeight();
        final int paddingLeft = this.getPaddingLeft();
        final int paddingRight = this.getPaddingRight();
        final int paddingTop = this.getPaddingTop();
        final int paddingBottom = this.getPaddingBottom();
        int n6 = paddingLeft;
        int n7 = width - paddingRight;
        final int[] mTempMargins = this.mTempMargins;
        mTempMargins[mTempMargins[n5] = 0] = 0;
        final int minimumHeight = ViewCompat.getMinimumHeight((View)this);
        int min;
        if (minimumHeight >= 0) {
            min = Math.min(minimumHeight, n4 - n2);
        }
        else {
            min = 0;
        }
        if (this.shouldLayout((View)this.mNavButtonView)) {
            if (b2) {
                n7 = this.layoutChildRight((View)this.mNavButtonView, n7, mTempMargins, min);
            }
            else {
                n6 = this.layoutChildLeft((View)this.mNavButtonView, n6, mTempMargins, min);
            }
        }
        if (this.shouldLayout((View)this.mCollapseButtonView)) {
            if (b2) {
                n7 = this.layoutChildRight((View)this.mCollapseButtonView, n7, mTempMargins, min);
            }
            else {
                n6 = this.layoutChildLeft((View)this.mCollapseButtonView, n6, mTempMargins, min);
            }
        }
        if (this.shouldLayout((View)this.mMenuView)) {
            if (b2) {
                n6 = this.layoutChildLeft((View)this.mMenuView, n6, mTempMargins, min);
            }
            else {
                n7 = this.layoutChildRight((View)this.mMenuView, n7, mTempMargins, min);
            }
        }
        final int currentContentInsetLeft = this.getCurrentContentInsetLeft();
        final int currentContentInsetRight = this.getCurrentContentInsetRight();
        mTempMargins[0] = Math.max(0, currentContentInsetLeft - n6);
        mTempMargins[1] = Math.max(0, currentContentInsetRight - (width - paddingRight - n7));
        int n8 = Math.max(n6, currentContentInsetLeft);
        int n9 = Math.min(n7, width - paddingRight - currentContentInsetRight);
        if (this.shouldLayout(this.mExpandedActionView)) {
            if (b2) {
                n9 = this.layoutChildRight(this.mExpandedActionView, n9, mTempMargins, min);
            }
            else {
                n8 = this.layoutChildLeft(this.mExpandedActionView, n8, mTempMargins, min);
            }
        }
        if (this.shouldLayout((View)this.mLogoView)) {
            if (b2) {
                n9 = this.layoutChildRight((View)this.mLogoView, n9, mTempMargins, min);
            }
            else {
                n8 = this.layoutChildLeft((View)this.mLogoView, n8, mTempMargins, min);
            }
        }
        final boolean shouldLayout = this.shouldLayout((View)this.mTitleTextView);
        final boolean shouldLayout2 = this.shouldLayout((View)this.mSubtitleTextView);
        int n10 = 0;
        int n11;
        if (shouldLayout) {
            final Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)this.mTitleTextView.getLayoutParams();
            final int topMargin = toolbar$LayoutParams.topMargin;
            n11 = paddingRight;
            n10 = 0 + (topMargin + this.mTitleTextView.getMeasuredHeight() + toolbar$LayoutParams.bottomMargin);
        }
        else {
            n11 = paddingRight;
        }
        if (shouldLayout2) {
            final Toolbar$LayoutParams toolbar$LayoutParams2 = (Toolbar$LayoutParams)this.mSubtitleTextView.getLayoutParams();
            n10 += toolbar$LayoutParams2.topMargin + this.mSubtitleTextView.getMeasuredHeight() + toolbar$LayoutParams2.bottomMargin;
        }
        int max;
        int n12;
        int n13;
        int n14;
        if (!shouldLayout && !shouldLayout2) {
            max = n8;
            n12 = width;
            n13 = paddingLeft;
            n14 = min;
        }
        else {
            TextView textView;
            if (shouldLayout) {
                textView = this.mTitleTextView;
            }
            else {
                textView = this.mSubtitleTextView;
            }
            TextView textView2;
            if (shouldLayout2) {
                textView2 = this.mSubtitleTextView;
            }
            else {
                textView2 = this.mTitleTextView;
            }
            final Toolbar$LayoutParams toolbar$LayoutParams3 = (Toolbar$LayoutParams)((View)textView).getLayoutParams();
            final Toolbar$LayoutParams toolbar$LayoutParams4 = (Toolbar$LayoutParams)((View)textView2).getLayoutParams();
            boolean b3 = false;
            Label_0976: {
                Label_0961: {
                    if (shouldLayout) {
                        if (this.mTitleTextView.getMeasuredWidth() > 0) {
                            break Label_0961;
                        }
                    }
                    if (!shouldLayout2 || this.mSubtitleTextView.getMeasuredWidth() <= 0) {
                        b3 = false;
                        break Label_0976;
                    }
                }
                b3 = true;
            }
            n12 = width;
            final int n15 = this.mGravity & 0x70;
            n13 = paddingLeft;
            int n17;
            if (n15 != 48) {
                if (n15 != 80) {
                    int max2 = (height - paddingTop - paddingBottom - n10) / 2;
                    final int topMargin2 = toolbar$LayoutParams3.topMargin;
                    n14 = min;
                    if (max2 < topMargin2 + this.mTitleMarginTop) {
                        max2 = toolbar$LayoutParams3.topMargin + this.mTitleMarginTop;
                        max = n8;
                    }
                    else {
                        final int n16 = height - paddingBottom - n10 - max2 - paddingTop;
                        final int bottomMargin = toolbar$LayoutParams3.bottomMargin;
                        max = n8;
                        if (n16 < bottomMargin + this.mTitleMarginBottom) {
                            max2 = Math.max(0, max2 - (toolbar$LayoutParams4.bottomMargin + this.mTitleMarginBottom - n16));
                        }
                    }
                    n17 = paddingTop + max2;
                }
                else {
                    max = n8;
                    n14 = min;
                    n17 = height - paddingBottom - toolbar$LayoutParams4.bottomMargin - this.mTitleMarginBottom - n10;
                }
            }
            else {
                max = n8;
                n14 = min;
                n17 = this.getPaddingTop() + toolbar$LayoutParams3.topMargin + this.mTitleMarginTop;
            }
            if (b2) {
                int mTitleMarginStart;
                if (b3) {
                    mTitleMarginStart = this.mTitleMarginStart;
                }
                else {
                    mTitleMarginStart = 0;
                }
                final int n18 = 1;
                final int n19 = mTitleMarginStart - mTempMargins[n18];
                n9 -= Math.max(0, n19);
                mTempMargins[n18] = Math.max(0, -n19);
                int n20 = n9;
                int n21 = n9;
                if (shouldLayout) {
                    final Toolbar$LayoutParams toolbar$LayoutParams5 = (Toolbar$LayoutParams)this.mTitleTextView.getLayoutParams();
                    final int n22 = n9 - this.mTitleTextView.getMeasuredWidth();
                    final int n23 = this.mTitleTextView.getMeasuredHeight() + n17;
                    this.mTitleTextView.layout(n22, n17, n9, n23);
                    n20 = n22 - this.mTitleMarginEnd;
                    n17 = n23 + toolbar$LayoutParams5.bottomMargin;
                }
                if (shouldLayout2) {
                    final Toolbar$LayoutParams toolbar$LayoutParams6 = (Toolbar$LayoutParams)this.mSubtitleTextView.getLayoutParams();
                    final int n24 = n17 + toolbar$LayoutParams6.topMargin;
                    final int n25 = n21 - this.mSubtitleTextView.getMeasuredWidth();
                    final int n26 = this.mSubtitleTextView.getMeasuredHeight() + n24;
                    this.mSubtitleTextView.layout(n25, n24, n21, n26);
                    n21 -= this.mTitleMarginEnd;
                    final int n27 = n26 + toolbar$LayoutParams6.bottomMargin;
                }
                if (b3) {
                    n9 = Math.min(n20, n21);
                }
            }
            else {
                int mTitleMarginStart2;
                if (b3) {
                    mTitleMarginStart2 = this.mTitleMarginStart;
                }
                else {
                    mTitleMarginStart2 = 0;
                }
                final int n28 = mTitleMarginStart2 - mTempMargins[0];
                final int n29 = max + Math.max(0, n28);
                mTempMargins[0] = Math.max(0, -n28);
                int n30 = n29;
                int n31 = n29;
                if (shouldLayout) {
                    final Toolbar$LayoutParams toolbar$LayoutParams7 = (Toolbar$LayoutParams)this.mTitleTextView.getLayoutParams();
                    final int n32 = this.mTitleTextView.getMeasuredWidth() + n29;
                    final int n33 = this.mTitleTextView.getMeasuredHeight() + n17;
                    max = n29;
                    this.mTitleTextView.layout(n29, n17, n32, n33);
                    n30 = n32 + this.mTitleMarginEnd;
                    n17 = n33 + toolbar$LayoutParams7.bottomMargin;
                }
                else {
                    max = n29;
                }
                if (shouldLayout2) {
                    final Toolbar$LayoutParams toolbar$LayoutParams8 = (Toolbar$LayoutParams)this.mSubtitleTextView.getLayoutParams();
                    final int n34 = n17 + toolbar$LayoutParams8.topMargin;
                    final int n35 = this.mSubtitleTextView.getMeasuredWidth() + n31;
                    final int n36 = this.mSubtitleTextView.getMeasuredHeight() + n34;
                    this.mSubtitleTextView.layout(n31, n34, n35, n36);
                    n31 = n35 + this.mTitleMarginEnd;
                    final int n37 = n36 + toolbar$LayoutParams8.bottomMargin;
                }
                if (b3) {
                    max = Math.max(n30, n31);
                }
            }
        }
        this.addCustomViewsWithGravity(this.mTempViews, 3);
        final int size = this.mTempViews.size();
        int i = 0;
        int layoutChildLeft = max;
        while (i < size) {
            layoutChildLeft = this.layoutChildLeft(this.mTempViews.get(i), layoutChildLeft, mTempMargins, n14);
            ++i;
        }
        final int n38 = n14;
        this.addCustomViewsWithGravity(this.mTempViews, 5);
        for (int size2 = this.mTempViews.size(), j = 0; j < size2; ++j) {
            n9 = this.layoutChildRight((View)this.mTempViews.get(j), n9, mTempMargins, n38);
        }
        this.addCustomViewsWithGravity(this.mTempViews, 1);
        final int viewListMeasuredWidth = this.getViewListMeasuredWidth(this.mTempViews, mTempMargins);
        int n39 = n13 + (n12 - n13 - n11) / 2 - viewListMeasuredWidth / 2;
        final int n40 = n39 + viewListMeasuredWidth;
        if (n39 < layoutChildLeft) {
            n39 = layoutChildLeft;
        }
        else if (n40 > n9) {
            n39 -= n40 - n9;
        }
        final int size3 = this.mTempViews.size();
        int layoutChildLeft2 = n39;
        for (int k = 0; k < size3; ++k) {
            layoutChildLeft2 = this.layoutChildLeft((View)this.mTempViews.get(k), layoutChildLeft2, mTempMargins, n38);
        }
        this.mTempViews.clear();
    }
    
    protected void onMeasure(final int n, final int n2) {
        int n3 = 0;
        int n4 = 0;
        final int[] mTempMargins = this.mTempMargins;
        int n5;
        int n6;
        if (ViewUtils.isLayoutRtl((View)this)) {
            n5 = 1;
            n6 = 0;
        }
        else {
            final int n7 = 1;
            n5 = 0;
            n6 = n7;
        }
        int n8 = 0;
        if (this.shouldLayout((View)this.mNavButtonView)) {
            this.measureChildConstrained((View)this.mNavButtonView, n, 0, n2, 0, this.mMaxButtonHeight);
            n8 = this.mNavButtonView.getMeasuredWidth() + this.getHorizontalMargins((View)this.mNavButtonView);
            n3 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + this.getVerticalMargins((View)this.mNavButtonView));
            n4 = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState((View)this.mNavButtonView));
        }
        if (this.shouldLayout((View)this.mCollapseButtonView)) {
            this.measureChildConstrained((View)this.mCollapseButtonView, n, 0, n2, 0, this.mMaxButtonHeight);
            n8 = this.mCollapseButtonView.getMeasuredWidth() + this.getHorizontalMargins((View)this.mCollapseButtonView);
            n3 = Math.max(n3, this.mCollapseButtonView.getMeasuredHeight() + this.getVerticalMargins((View)this.mCollapseButtonView));
            n4 = ViewUtils.combineMeasuredStates(n4, ViewCompat.getMeasuredState((View)this.mCollapseButtonView));
        }
        final int currentContentInsetStart = this.getCurrentContentInsetStart();
        final int n9 = 0 + Math.max(currentContentInsetStart, n8);
        mTempMargins[n5] = Math.max(0, currentContentInsetStart - n8);
        int combineMeasuredStates;
        int n11;
        int n12;
        if (this.shouldLayout((View)this.mMenuView)) {
            this.measureChildConstrained((View)this.mMenuView, n, n9, n2, 0, this.mMaxButtonHeight);
            final int n10 = this.mMenuView.getMeasuredWidth() + this.getHorizontalMargins((View)this.mMenuView);
            final int max = Math.max(n3, this.mMenuView.getMeasuredHeight() + this.getVerticalMargins((View)this.mMenuView));
            combineMeasuredStates = ViewUtils.combineMeasuredStates(n4, ViewCompat.getMeasuredState((View)this.mMenuView));
            n11 = max;
            n12 = n10;
        }
        else {
            combineMeasuredStates = n4;
            n11 = n3;
            n12 = 0;
        }
        final int currentContentInsetEnd = this.getCurrentContentInsetEnd();
        int n13 = n9 + Math.max(currentContentInsetEnd, n12);
        mTempMargins[n6] = Math.max(0, currentContentInsetEnd - n12);
        int n14;
        if (this.shouldLayout(this.mExpandedActionView)) {
            n13 += this.measureChildCollapseMargins(this.mExpandedActionView, n, n13, n2, 0, mTempMargins);
            n11 = Math.max(n11, this.mExpandedActionView.getMeasuredHeight() + this.getVerticalMargins(this.mExpandedActionView));
            n14 = ViewUtils.combineMeasuredStates(combineMeasuredStates, ViewCompat.getMeasuredState(this.mExpandedActionView));
        }
        else {
            n14 = combineMeasuredStates;
        }
        if (this.shouldLayout((View)this.mLogoView)) {
            n13 += this.measureChildCollapseMargins((View)this.mLogoView, n, n13, n2, 0, mTempMargins);
            n11 = Math.max(n11, this.mLogoView.getMeasuredHeight() + this.getVerticalMargins((View)this.mLogoView));
            n14 = ViewUtils.combineMeasuredStates(n14, ViewCompat.getMeasuredState((View)this.mLogoView));
        }
        int childCount = this.getChildCount();
        int n15 = n11;
        int n16 = n13;
        int n17;
        int n18;
        for (int i = 0; i < childCount; ++i, childCount = n18, n12 = n17) {
            final View child = this.getChildAt(i);
            int n19;
            if (((Toolbar$LayoutParams)child.getLayoutParams()).mViewType == 0) {
                if (this.shouldLayout(child)) {
                    n17 = n12;
                    n18 = childCount;
                    n16 += this.measureChildCollapseMargins(child, n, n16, n2, 0, mTempMargins);
                    final int max2 = Math.max(n15, child.getMeasuredHeight() + this.getVerticalMargins(child));
                    final int combineMeasuredStates2 = ViewUtils.combineMeasuredStates(n14, ViewCompat.getMeasuredState(child));
                    n15 = max2;
                    n14 = combineMeasuredStates2;
                    continue;
                }
                n18 = childCount;
                n17 = n12;
                n19 = n15;
            }
            else {
                n18 = childCount;
                n17 = n12;
                n19 = n15;
            }
            n15 = n19;
        }
        final int n20 = n15;
        int max3 = 0;
        int n21 = 0;
        final int n22 = this.mTitleMarginTop + this.mTitleMarginBottom;
        final int n23 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (this.shouldLayout((View)this.mTitleTextView)) {
            this.measureChildCollapseMargins((View)this.mTitleTextView, n, n16 + n23, n2, n22, mTempMargins);
            max3 = this.mTitleTextView.getMeasuredWidth() + this.getHorizontalMargins((View)this.mTitleTextView);
            n21 = this.mTitleTextView.getMeasuredHeight() + this.getVerticalMargins((View)this.mTitleTextView);
            n14 = ViewUtils.combineMeasuredStates(n14, ViewCompat.getMeasuredState((View)this.mTitleTextView));
        }
        int n25;
        if (this.shouldLayout((View)this.mSubtitleTextView)) {
            max3 = Math.max(max3, this.measureChildCollapseMargins((View)this.mSubtitleTextView, n, n16 + n23, n2, n21 + n22, mTempMargins));
            final int n24 = n21 + (this.mSubtitleTextView.getMeasuredHeight() + this.getVerticalMargins((View)this.mSubtitleTextView));
            n14 = ViewUtils.combineMeasuredStates(n14, ViewCompat.getMeasuredState((View)this.mSubtitleTextView));
            n25 = n24;
        }
        else {
            n25 = n21;
        }
        final int n26 = n16 + max3;
        final int max4 = Math.max(n20, n25);
        final int n27 = n26 + (this.getPaddingLeft() + this.getPaddingRight());
        final int n28 = max4 + (this.getPaddingTop() + this.getPaddingBottom());
        final int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(n27, this.getSuggestedMinimumWidth()), n, 0xFF000000 & n14);
        final int resolveSizeAndState2 = ViewCompat.resolveSizeAndState(Math.max(n28, this.getSuggestedMinimumHeight()), n2, n14 << 16);
        int n29;
        if (this.shouldCollapse()) {
            n29 = 0;
        }
        else {
            n29 = resolveSizeAndState2;
        }
        this.setMeasuredDimension(resolveSizeAndState, n29);
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof Toolbar$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final Toolbar$SavedState toolbar$SavedState = (Toolbar$SavedState)parcelable;
        super.onRestoreInstanceState(toolbar$SavedState.getSuperState());
        final ActionMenuView mMenuView = this.mMenuView;
        Object peekMenu;
        if (mMenuView != null) {
            peekMenu = mMenuView.peekMenu();
        }
        else {
            peekMenu = null;
        }
        if (toolbar$SavedState.expandedMenuItemId != 0 && this.mExpandedMenuPresenter != null && peekMenu != null) {
            final MenuItem item = ((Menu)peekMenu).findItem(toolbar$SavedState.expandedMenuItemId);
            if (item != null) {
                MenuItemCompat.expandActionView(item);
            }
        }
        if (toolbar$SavedState.isOverflowOpen) {
            this.postShowOverflowMenu();
        }
    }
    
    public void onRtlPropertiesChanged(final int n) {
        if (Build$VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(n);
        }
        this.ensureContentInsets();
        final RtlSpacingHelper mContentInsets = this.mContentInsets;
        boolean direction = true;
        if (n != (direction ? 1 : 0)) {
            direction = false;
        }
        mContentInsets.setDirection(direction);
    }
    
    protected Parcelable onSaveInstanceState() {
        final Toolbar$SavedState toolbar$SavedState = new Toolbar$SavedState(super.onSaveInstanceState());
        final Toolbar$ExpandedActionViewMenuPresenter mExpandedMenuPresenter = this.mExpandedMenuPresenter;
        if (mExpandedMenuPresenter != null && mExpandedMenuPresenter.mCurrentExpandedItem != null) {
            toolbar$SavedState.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        }
        toolbar$SavedState.isOverflowOpen = this.isOverflowMenuShowing();
        return (Parcelable)toolbar$SavedState;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        final boolean mEatingTouch = this.mEatingTouch;
        final boolean mEatingTouch2 = true;
        if (!mEatingTouch) {
            final boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.mEatingTouch = mEatingTouch2;
            }
        }
        if (actionMasked == (mEatingTouch2 ? 1 : 0) || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return mEatingTouch2;
    }
    
    void removeChildrenForExpandedActionView() {
        for (int i = this.getChildCount() - 1; i >= 0; --i) {
            final View child = this.getChildAt(i);
            if (((Toolbar$LayoutParams)child.getLayoutParams()).mViewType != 2 && child != this.mMenuView) {
                this.removeViewAt(i);
                this.mHiddenViews.add(child);
            }
        }
    }
    
    public void setCollapsible(final boolean mCollapsible) {
        this.mCollapsible = mCollapsible;
        this.requestLayout();
    }
    
    public void setContentInsetEndWithActions(int mContentInsetEndWithActions) {
        if (mContentInsetEndWithActions < 0) {
            mContentInsetEndWithActions = -1 << -1;
        }
        if (mContentInsetEndWithActions != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = mContentInsetEndWithActions;
            if (this.getNavigationIcon() != null) {
                this.requestLayout();
            }
        }
    }
    
    public void setContentInsetStartWithNavigation(int mContentInsetStartWithNavigation) {
        if (mContentInsetStartWithNavigation < 0) {
            mContentInsetStartWithNavigation = -1 << -1;
        }
        if (mContentInsetStartWithNavigation != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = mContentInsetStartWithNavigation;
            if (this.getNavigationIcon() != null) {
                this.requestLayout();
            }
        }
    }
    
    public void setContentInsetsAbsolute(final int n, final int n2) {
        this.ensureContentInsets();
        this.mContentInsets.setAbsolute(n, n2);
    }
    
    public void setContentInsetsRelative(final int n, final int n2) {
        this.ensureContentInsets();
        this.mContentInsets.setRelative(n, n2);
    }
    
    public void setLogo(final int n) {
        this.setLogo(AppCompatResources.getDrawable(this.getContext(), n));
    }
    
    public void setLogo(final Drawable imageDrawable) {
        if (imageDrawable != null) {
            this.ensureLogoView();
            if (!this.isChildOrHidden((View)this.mLogoView)) {
                this.addSystemView((View)this.mLogoView, true);
            }
        }
        else {
            final ImageView mLogoView = this.mLogoView;
            if (mLogoView != null && this.isChildOrHidden((View)mLogoView)) {
                this.removeView((View)this.mLogoView);
                this.mHiddenViews.remove(this.mLogoView);
            }
        }
        final ImageView mLogoView2 = this.mLogoView;
        if (mLogoView2 != null) {
            mLogoView2.setImageDrawable(imageDrawable);
        }
    }
    
    public void setLogoDescription(final int n) {
        this.setLogoDescription(this.getContext().getText(n));
    }
    
    public void setLogoDescription(final CharSequence contentDescription) {
        if (!TextUtils.isEmpty(contentDescription)) {
            this.ensureLogoView();
        }
        final ImageView mLogoView = this.mLogoView;
        if (mLogoView != null) {
            mLogoView.setContentDescription(contentDescription);
        }
    }
    
    public void setMenu(final MenuBuilder menuBuilder, final ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder == null && this.mMenuView == null) {
            return;
        }
        this.ensureMenuView();
        final MenuBuilder peekMenu = this.mMenuView.peekMenu();
        if (peekMenu == menuBuilder) {
            return;
        }
        if (peekMenu != null) {
            peekMenu.removeMenuPresenter(this.mOuterActionMenuPresenter);
            peekMenu.removeMenuPresenter(this.mExpandedMenuPresenter);
        }
        if (this.mExpandedMenuPresenter == null) {
            this.mExpandedMenuPresenter = new Toolbar$ExpandedActionViewMenuPresenter(this);
        }
        final boolean expandedActionViewsExclusive = true;
        actionMenuPresenter.setExpandedActionViewsExclusive(expandedActionViewsExclusive);
        if (menuBuilder != null) {
            menuBuilder.addMenuPresenter(actionMenuPresenter, this.mPopupContext);
            menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        }
        else {
            actionMenuPresenter.initForMenu(this.mPopupContext, null);
            this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
            actionMenuPresenter.updateMenuView(expandedActionViewsExclusive);
            this.mExpandedMenuPresenter.updateMenuView(expandedActionViewsExclusive);
        }
        this.mMenuView.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setPresenter(actionMenuPresenter);
        this.mOuterActionMenuPresenter = actionMenuPresenter;
    }
    
    public void setMenuCallbacks(final MenuPresenter$Callback mActionMenuPresenterCallback, final MenuBuilder$Callback mMenuBuilderCallback) {
        this.mActionMenuPresenterCallback = mActionMenuPresenterCallback;
        this.mMenuBuilderCallback = mMenuBuilderCallback;
        final ActionMenuView mMenuView = this.mMenuView;
        if (mMenuView != null) {
            mMenuView.setMenuCallbacks(mActionMenuPresenterCallback, mMenuBuilderCallback);
        }
    }
    
    public void setNavigationContentDescription(final int n) {
        CharSequence text;
        if (n != 0) {
            text = this.getContext().getText(n);
        }
        else {
            text = null;
        }
        this.setNavigationContentDescription(text);
    }
    
    public void setNavigationContentDescription(final CharSequence contentDescription) {
        if (!TextUtils.isEmpty(contentDescription)) {
            this.ensureNavButtonView();
        }
        final ImageButton mNavButtonView = this.mNavButtonView;
        if (mNavButtonView != null) {
            mNavButtonView.setContentDescription(contentDescription);
        }
    }
    
    public void setNavigationIcon(final int n) {
        this.setNavigationIcon(AppCompatResources.getDrawable(this.getContext(), n));
    }
    
    public void setNavigationIcon(final Drawable imageDrawable) {
        if (imageDrawable != null) {
            this.ensureNavButtonView();
            if (!this.isChildOrHidden((View)this.mNavButtonView)) {
                this.addSystemView((View)this.mNavButtonView, true);
            }
        }
        else {
            final ImageButton mNavButtonView = this.mNavButtonView;
            if (mNavButtonView != null && this.isChildOrHidden((View)mNavButtonView)) {
                this.removeView((View)this.mNavButtonView);
                this.mHiddenViews.remove(this.mNavButtonView);
            }
        }
        final ImageButton mNavButtonView2 = this.mNavButtonView;
        if (mNavButtonView2 != null) {
            mNavButtonView2.setImageDrawable(imageDrawable);
        }
    }
    
    public void setNavigationOnClickListener(final View$OnClickListener onClickListener) {
        this.ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }
    
    public void setOnMenuItemClickListener(final Toolbar$OnMenuItemClickListener mOnMenuItemClickListener) {
        this.mOnMenuItemClickListener = mOnMenuItemClickListener;
    }
    
    public void setOverflowIcon(final Drawable overflowIcon) {
        this.ensureMenu();
        this.mMenuView.setOverflowIcon(overflowIcon);
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
    
    public void setSubtitle(final int n) {
        this.setSubtitle(this.getContext().getText(n));
    }
    
    public void setSubtitle(final CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                final Context context = this.getContext();
                (this.mSubtitleTextView = new AppCompatTextView(context)).setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils$TruncateAt.END);
                final int mSubtitleTextAppearance = this.mSubtitleTextAppearance;
                if (mSubtitleTextAppearance != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, mSubtitleTextAppearance);
                }
                final int mSubtitleTextColor = this.mSubtitleTextColor;
                if (mSubtitleTextColor != 0) {
                    this.mSubtitleTextView.setTextColor(mSubtitleTextColor);
                }
            }
            if (!this.isChildOrHidden((View)this.mSubtitleTextView)) {
                this.addSystemView((View)this.mSubtitleTextView, true);
            }
        }
        else {
            final TextView mSubtitleTextView = this.mSubtitleTextView;
            if (mSubtitleTextView != null && this.isChildOrHidden((View)mSubtitleTextView)) {
                this.removeView((View)this.mSubtitleTextView);
                this.mHiddenViews.remove(this.mSubtitleTextView);
            }
        }
        final TextView mSubtitleTextView2 = this.mSubtitleTextView;
        if (mSubtitleTextView2 != null) {
            mSubtitleTextView2.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }
    
    public void setSubtitleTextAppearance(final Context context, final int mSubtitleTextAppearance) {
        this.mSubtitleTextAppearance = mSubtitleTextAppearance;
        final TextView mSubtitleTextView = this.mSubtitleTextView;
        if (mSubtitleTextView != null) {
            mSubtitleTextView.setTextAppearance(context, mSubtitleTextAppearance);
        }
    }
    
    public void setSubtitleTextColor(final int n) {
        this.mSubtitleTextColor = n;
        final TextView mSubtitleTextView = this.mSubtitleTextView;
        if (mSubtitleTextView != null) {
            mSubtitleTextView.setTextColor(n);
        }
    }
    
    public void setTitle(final int n) {
        this.setTitle(this.getContext().getText(n));
    }
    
    public void setTitle(final CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mTitleTextView == null) {
                final Context context = this.getContext();
                (this.mTitleTextView = new AppCompatTextView(context)).setSingleLine();
                this.mTitleTextView.setEllipsize(TextUtils$TruncateAt.END);
                final int mTitleTextAppearance = this.mTitleTextAppearance;
                if (mTitleTextAppearance != 0) {
                    this.mTitleTextView.setTextAppearance(context, mTitleTextAppearance);
                }
                final int mTitleTextColor = this.mTitleTextColor;
                if (mTitleTextColor != 0) {
                    this.mTitleTextView.setTextColor(mTitleTextColor);
                }
            }
            if (!this.isChildOrHidden((View)this.mTitleTextView)) {
                this.addSystemView((View)this.mTitleTextView, true);
            }
        }
        else {
            final TextView mTitleTextView = this.mTitleTextView;
            if (mTitleTextView != null && this.isChildOrHidden((View)mTitleTextView)) {
                this.removeView((View)this.mTitleTextView);
                this.mHiddenViews.remove(this.mTitleTextView);
            }
        }
        final TextView mTitleTextView2 = this.mTitleTextView;
        if (mTitleTextView2 != null) {
            mTitleTextView2.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }
    
    public void setTitleMargin(final int mTitleMarginStart, final int mTitleMarginTop, final int mTitleMarginEnd, final int mTitleMarginBottom) {
        this.mTitleMarginStart = mTitleMarginStart;
        this.mTitleMarginTop = mTitleMarginTop;
        this.mTitleMarginEnd = mTitleMarginEnd;
        this.mTitleMarginBottom = mTitleMarginBottom;
        this.requestLayout();
    }
    
    public void setTitleMarginBottom(final int mTitleMarginBottom) {
        this.mTitleMarginBottom = mTitleMarginBottom;
        this.requestLayout();
    }
    
    public void setTitleMarginEnd(final int mTitleMarginEnd) {
        this.mTitleMarginEnd = mTitleMarginEnd;
        this.requestLayout();
    }
    
    public void setTitleMarginStart(final int mTitleMarginStart) {
        this.mTitleMarginStart = mTitleMarginStart;
        this.requestLayout();
    }
    
    public void setTitleMarginTop(final int mTitleMarginTop) {
        this.mTitleMarginTop = mTitleMarginTop;
        this.requestLayout();
    }
    
    public void setTitleTextAppearance(final Context context, final int mTitleTextAppearance) {
        this.mTitleTextAppearance = mTitleTextAppearance;
        final TextView mTitleTextView = this.mTitleTextView;
        if (mTitleTextView != null) {
            mTitleTextView.setTextAppearance(context, mTitleTextAppearance);
        }
    }
    
    public void setTitleTextColor(final int n) {
        this.mTitleTextColor = n;
        final TextView mTitleTextView = this.mTitleTextView;
        if (mTitleTextView != null) {
            mTitleTextView.setTextColor(n);
        }
    }
    
    public boolean showOverflowMenu() {
        final ActionMenuView mMenuView = this.mMenuView;
        return mMenuView != null && mMenuView.showOverflowMenu();
    }
}
