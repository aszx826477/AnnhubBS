// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.Window$Callback;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.view.Menu;
import android.util.SparseArray;
import android.support.v7.appcompat.R$id;
import android.os.Build$VERSION;
import android.content.res.Configuration;
import android.support.v4.view.ViewCompat;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v7.appcompat.R$attr;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.widget.ScrollerCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.graphics.Rect;
import android.support.v4.view.NestedScrollingParent;
import android.view.ViewGroup;

public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent
{
    static final int[] ATTRS;
    private static final String TAG = "ActionBarOverlayLayout";
    private final int ACTION_BAR_ANIMATE_DELAY;
    private int mActionBarHeight;
    ActionBarContainer mActionBarTop;
    private ActionBarOverlayLayout$ActionBarVisibilityCallback mActionBarVisibilityCallback;
    private final Runnable mAddActionBarHideOffset;
    boolean mAnimatingForFling;
    private final Rect mBaseContentInsets;
    private final Rect mBaseInnerInsets;
    private ContentFrameLayout mContent;
    private final Rect mContentInsets;
    ViewPropertyAnimatorCompat mCurrentActionBarTopAnimator;
    private DecorToolbar mDecorToolbar;
    private ScrollerCompat mFlingEstimator;
    private boolean mHasNonEmbeddedTabs;
    private boolean mHideOnContentScroll;
    private int mHideOnContentScrollReference;
    private boolean mIgnoreWindowContentOverlay;
    private final Rect mInnerInsets;
    private final Rect mLastBaseContentInsets;
    private final Rect mLastInnerInsets;
    private int mLastSystemUiVisibility;
    private boolean mOverlayMode;
    private final NestedScrollingParentHelper mParentHelper;
    private final Runnable mRemoveActionBarHideOffset;
    final ViewPropertyAnimatorListener mTopAnimatorListener;
    private Drawable mWindowContentOverlay;
    private int mWindowVisibility;
    
    static {
        ATTRS = new int[] { R$attr.actionBarSize, 16842841 };
    }
    
    public ActionBarOverlayLayout(final Context context) {
        this(context, null);
    }
    
    public ActionBarOverlayLayout(final Context context, final AttributeSet set) {
        super(context, set);
        this.mWindowVisibility = 0;
        this.mBaseContentInsets = new Rect();
        this.mLastBaseContentInsets = new Rect();
        this.mContentInsets = new Rect();
        this.mBaseInnerInsets = new Rect();
        this.mInnerInsets = new Rect();
        this.mLastInnerInsets = new Rect();
        this.ACTION_BAR_ANIMATE_DELAY = 600;
        this.mTopAnimatorListener = new ActionBarOverlayLayout$1(this);
        this.mRemoveActionBarHideOffset = new ActionBarOverlayLayout$2(this);
        this.mAddActionBarHideOffset = new ActionBarOverlayLayout$3(this);
        this.init(context);
        this.mParentHelper = new NestedScrollingParentHelper(this);
    }
    
    private void addActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        this.mAddActionBarHideOffset.run();
    }
    
    private boolean applyInsets(final View view, final Rect rect, final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        boolean b5 = false;
        final ActionBarOverlayLayout$LayoutParams actionBarOverlayLayout$LayoutParams = (ActionBarOverlayLayout$LayoutParams)view.getLayoutParams();
        if (b && actionBarOverlayLayout$LayoutParams.leftMargin != rect.left) {
            b5 = true;
            actionBarOverlayLayout$LayoutParams.leftMargin = rect.left;
        }
        if (b2 && actionBarOverlayLayout$LayoutParams.topMargin != rect.top) {
            b5 = true;
            actionBarOverlayLayout$LayoutParams.topMargin = rect.top;
        }
        if (b4 && actionBarOverlayLayout$LayoutParams.rightMargin != rect.right) {
            b5 = true;
            actionBarOverlayLayout$LayoutParams.rightMargin = rect.right;
        }
        if (b3 && actionBarOverlayLayout$LayoutParams.bottomMargin != rect.bottom) {
            b5 = true;
            actionBarOverlayLayout$LayoutParams.bottomMargin = rect.bottom;
        }
        return b5;
    }
    
    private DecorToolbar getDecorToolbar(final View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar)view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar)view).getWrapper();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view.getClass().getSimpleName());
        throw new IllegalStateException(sb.toString());
    }
    
    private void init(final Context context) {
        final TypedArray obtainStyledAttributes = this.getContext().getTheme().obtainStyledAttributes(ActionBarOverlayLayout.ATTRS);
        boolean mIgnoreWindowContentOverlay = false;
        this.mActionBarHeight = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.mWindowContentOverlay = obtainStyledAttributes.getDrawable(1);
        this.setWillNotDraw(this.mWindowContentOverlay == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            mIgnoreWindowContentOverlay = true;
        }
        this.mIgnoreWindowContentOverlay = mIgnoreWindowContentOverlay;
        this.mFlingEstimator = ScrollerCompat.create(context);
    }
    
    private void postAddActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        this.postDelayed(this.mAddActionBarHideOffset, 600L);
    }
    
    private void postRemoveActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        this.postDelayed(this.mRemoveActionBarHideOffset, 600L);
    }
    
    private void removeActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        this.mRemoveActionBarHideOffset.run();
    }
    
    private boolean shouldHideActionBarOnFling(final float n, final float n2) {
        this.mFlingEstimator.fling(0, 0, 0, (int)n2, 0, 0, -1 << -1, -1 >>> 1);
        return this.mFlingEstimator.getFinalY() > this.mActionBarTop.getHeight();
    }
    
    public boolean canShowOverflowMenu() {
        this.pullChildren();
        return this.mDecorToolbar.canShowOverflowMenu();
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof ActionBarOverlayLayout$LayoutParams;
    }
    
    public void dismissPopups() {
        this.pullChildren();
        this.mDecorToolbar.dismissPopupMenus();
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        if (this.mWindowContentOverlay != null && !this.mIgnoreWindowContentOverlay) {
            int n;
            if (this.mActionBarTop.getVisibility() == 0) {
                n = (int)(this.mActionBarTop.getBottom() + ViewCompat.getTranslationY((View)this.mActionBarTop) + 0.5f);
            }
            else {
                n = 0;
            }
            this.mWindowContentOverlay.setBounds(0, n, this.getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + n);
            this.mWindowContentOverlay.draw(canvas);
        }
    }
    
    protected boolean fitSystemWindows(final Rect rect) {
        this.pullChildren();
        final int n = ViewCompat.getWindowSystemUiVisibility((View)this) & 0x100;
        final boolean b = true;
        if (n != 0) {}
        boolean applyInsets = this.applyInsets((View)this.mActionBarTop, rect, true, true, false, true);
        this.mBaseInnerInsets.set(rect);
        ViewUtils.computeFitSystemWindows((View)this, this.mBaseInnerInsets, this.mBaseContentInsets);
        if (!this.mLastBaseContentInsets.equals((Object)this.mBaseContentInsets)) {
            applyInsets = true;
            this.mLastBaseContentInsets.set(this.mBaseContentInsets);
        }
        if (applyInsets) {
            this.requestLayout();
        }
        return b;
    }
    
    protected ActionBarOverlayLayout$LayoutParams generateDefaultLayoutParams() {
        final int n = -1;
        return new ActionBarOverlayLayout$LayoutParams(n, n);
    }
    
    public ActionBarOverlayLayout$LayoutParams generateLayoutParams(final AttributeSet set) {
        return new ActionBarOverlayLayout$LayoutParams(this.getContext(), set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return (ViewGroup$LayoutParams)new ActionBarOverlayLayout$LayoutParams(viewGroup$LayoutParams);
    }
    
    public int getActionBarHideOffset() {
        final ActionBarContainer mActionBarTop = this.mActionBarTop;
        int n;
        if (mActionBarTop != null) {
            n = -(int)ViewCompat.getTranslationY((View)mActionBarTop);
        }
        else {
            n = 0;
        }
        return n;
    }
    
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }
    
    public CharSequence getTitle() {
        this.pullChildren();
        return this.mDecorToolbar.getTitle();
    }
    
    void haltActionBarHideOffsetAnimations() {
        this.removeCallbacks(this.mRemoveActionBarHideOffset);
        this.removeCallbacks(this.mAddActionBarHideOffset);
        final ViewPropertyAnimatorCompat mCurrentActionBarTopAnimator = this.mCurrentActionBarTopAnimator;
        if (mCurrentActionBarTopAnimator != null) {
            mCurrentActionBarTopAnimator.cancel();
        }
    }
    
    public boolean hasIcon() {
        this.pullChildren();
        return this.mDecorToolbar.hasIcon();
    }
    
    public boolean hasLogo() {
        this.pullChildren();
        return this.mDecorToolbar.hasLogo();
    }
    
    public boolean hideOverflowMenu() {
        this.pullChildren();
        return this.mDecorToolbar.hideOverflowMenu();
    }
    
    public void initFeature(final int n) {
        this.pullChildren();
        if (n != 2) {
            if (n != 5) {
                if (n == 109) {
                    this.setOverlayMode(true);
                }
            }
            else {
                this.mDecorToolbar.initIndeterminateProgress();
            }
        }
        else {
            this.mDecorToolbar.initProgress();
        }
    }
    
    public boolean isHideOnContentScrollEnabled() {
        return this.mHideOnContentScroll;
    }
    
    public boolean isInOverlayMode() {
        return this.mOverlayMode;
    }
    
    public boolean isOverflowMenuShowPending() {
        this.pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowPending();
    }
    
    public boolean isOverflowMenuShowing() {
        this.pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowing();
    }
    
    protected void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.init(this.getContext());
        ViewCompat.requestApplyInsets((View)this);
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.haltActionBarHideOffsetAnimations();
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final int childCount = this.getChildCount();
        final int paddingLeft = this.getPaddingLeft();
        final int n5 = n3 - n - this.getPaddingRight();
        final int paddingTop = this.getPaddingTop();
        final int n6 = n4 - n2 - this.getPaddingBottom();
        for (int i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final ActionBarOverlayLayout$LayoutParams actionBarOverlayLayout$LayoutParams = (ActionBarOverlayLayout$LayoutParams)child.getLayoutParams();
                final int measuredWidth = child.getMeasuredWidth();
                final int measuredHeight = child.getMeasuredHeight();
                final int n7 = actionBarOverlayLayout$LayoutParams.leftMargin + paddingLeft;
                final int n8 = actionBarOverlayLayout$LayoutParams.topMargin + paddingTop;
                child.layout(n7, n8, n7 + measuredWidth, n8 + measuredHeight);
            }
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.pullChildren();
        int n3 = 0;
        this.measureChildWithMargins((View)this.mActionBarTop, n, 0, n2, 0);
        final ActionBarOverlayLayout$LayoutParams actionBarOverlayLayout$LayoutParams = (ActionBarOverlayLayout$LayoutParams)this.mActionBarTop.getLayoutParams();
        final int max = Math.max(0, this.mActionBarTop.getMeasuredWidth() + actionBarOverlayLayout$LayoutParams.leftMargin + actionBarOverlayLayout$LayoutParams.rightMargin);
        final int max2 = Math.max(0, this.mActionBarTop.getMeasuredHeight() + actionBarOverlayLayout$LayoutParams.topMargin + actionBarOverlayLayout$LayoutParams.bottomMargin);
        final int combineMeasuredStates = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState((View)this.mActionBarTop));
        final boolean b;
        if (b = ((ViewCompat.getWindowSystemUiVisibility((View)this) & 0x100) != 0x0)) {
            n3 = this.mActionBarHeight;
            if (this.mHasNonEmbeddedTabs) {
                if (this.mActionBarTop.getTabContainer() != null) {
                    n3 += this.mActionBarHeight;
                }
            }
        }
        else if (this.mActionBarTop.getVisibility() != 8) {
            n3 = this.mActionBarTop.getMeasuredHeight();
        }
        this.mContentInsets.set(this.mBaseContentInsets);
        this.mInnerInsets.set(this.mBaseInnerInsets);
        if (!this.mOverlayMode && !b) {
            final Rect mContentInsets = this.mContentInsets;
            mContentInsets.top += n3;
            final Rect mContentInsets2 = this.mContentInsets;
            mContentInsets2.bottom += 0;
        }
        else {
            final Rect mInnerInsets = this.mInnerInsets;
            mInnerInsets.top += n3;
            final Rect mInnerInsets2 = this.mInnerInsets;
            mInnerInsets2.bottom += 0;
        }
        this.applyInsets((View)this.mContent, this.mContentInsets, true, true, true, true);
        if (!this.mLastInnerInsets.equals((Object)this.mInnerInsets)) {
            this.mLastInnerInsets.set(this.mInnerInsets);
            this.mContent.dispatchFitSystemWindows(this.mInnerInsets);
        }
        this.measureChildWithMargins((View)this.mContent, n, 0, n2, 0);
        final ActionBarOverlayLayout$LayoutParams actionBarOverlayLayout$LayoutParams2 = (ActionBarOverlayLayout$LayoutParams)this.mContent.getLayoutParams();
        final int max3 = Math.max(max, this.mContent.getMeasuredWidth() + actionBarOverlayLayout$LayoutParams2.leftMargin + actionBarOverlayLayout$LayoutParams2.rightMargin);
        final int max4 = Math.max(max2, this.mContent.getMeasuredHeight() + actionBarOverlayLayout$LayoutParams2.topMargin + actionBarOverlayLayout$LayoutParams2.bottomMargin);
        final int combineMeasuredStates2 = ViewUtils.combineMeasuredStates(combineMeasuredStates, ViewCompat.getMeasuredState((View)this.mContent));
        this.setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(max3 + (this.getPaddingLeft() + this.getPaddingRight()), this.getSuggestedMinimumWidth()), n, combineMeasuredStates2), ViewCompat.resolveSizeAndState(Math.max(max4 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight()), n2, combineMeasuredStates2 << 16));
    }
    
    public boolean onNestedFling(final View view, final float n, final float n2, final boolean b) {
        if (this.mHideOnContentScroll && b) {
            if (this.shouldHideActionBarOnFling(n, n2)) {
                this.addActionBarHideOffset();
            }
            else {
                this.removeActionBarHideOffset();
            }
            return this.mAnimatingForFling = true;
        }
        return false;
    }
    
    public boolean onNestedPreFling(final View view, final float n, final float n2) {
        return false;
    }
    
    public void onNestedPreScroll(final View view, final int n, final int n2, final int[] array) {
    }
    
    public void onNestedScroll(final View view, final int n, final int n2, final int n3, final int n4) {
        this.setActionBarHideOffset(this.mHideOnContentScrollReference += n2);
    }
    
    public void onNestedScrollAccepted(final View view, final View view2, final int n) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, n);
        this.mHideOnContentScrollReference = this.getActionBarHideOffset();
        this.haltActionBarHideOffsetAnimations();
        final ActionBarOverlayLayout$ActionBarVisibilityCallback mActionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (mActionBarVisibilityCallback != null) {
            mActionBarVisibilityCallback.onContentScrollStarted();
        }
    }
    
    public boolean onStartNestedScroll(final View view, final View view2, final int n) {
        return (n & 0x2) != 0x0 && this.mActionBarTop.getVisibility() == 0 && this.mHideOnContentScroll;
    }
    
    public void onStopNestedScroll(final View view) {
        if (this.mHideOnContentScroll && !this.mAnimatingForFling) {
            if (this.mHideOnContentScrollReference <= this.mActionBarTop.getHeight()) {
                this.postRemoveActionBarHideOffset();
            }
            else {
                this.postAddActionBarHideOffset();
            }
        }
        final ActionBarOverlayLayout$ActionBarVisibilityCallback mActionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (mActionBarVisibilityCallback != null) {
            mActionBarVisibilityCallback.onContentScrollStopped();
        }
    }
    
    public void onWindowSystemUiVisibilityChanged(final int mLastSystemUiVisibility) {
        if (Build$VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(mLastSystemUiVisibility);
        }
        this.pullChildren();
        final int n = this.mLastSystemUiVisibility ^ mLastSystemUiVisibility;
        this.mLastSystemUiVisibility = mLastSystemUiVisibility;
        final int n2 = mLastSystemUiVisibility & 0x4;
        boolean b = true;
        final boolean b2 = n2 == 0;
        final boolean b3 = (mLastSystemUiVisibility & 0x100) != 0x0;
        final ActionBarOverlayLayout$ActionBarVisibilityCallback mActionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (mActionBarVisibilityCallback != null) {
            if (b3) {
                b = false;
            }
            mActionBarVisibilityCallback.enableContentAnimations(b);
            if (!b2 && b3) {
                this.mActionBarVisibilityCallback.hideForSystem();
            }
            else {
                this.mActionBarVisibilityCallback.showForSystem();
            }
        }
        if ((n & 0x100) != 0x0) {
            if (this.mActionBarVisibilityCallback != null) {
                ViewCompat.requestApplyInsets((View)this);
            }
        }
    }
    
    protected void onWindowVisibilityChanged(final int mWindowVisibility) {
        super.onWindowVisibilityChanged(mWindowVisibility);
        this.mWindowVisibility = mWindowVisibility;
        final ActionBarOverlayLayout$ActionBarVisibilityCallback mActionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (mActionBarVisibilityCallback != null) {
            mActionBarVisibilityCallback.onWindowVisibilityChanged(mWindowVisibility);
        }
    }
    
    void pullChildren() {
        if (this.mContent == null) {
            this.mContent = (ContentFrameLayout)this.findViewById(R$id.action_bar_activity_content);
            this.mActionBarTop = (ActionBarContainer)this.findViewById(R$id.action_bar_container);
            this.mDecorToolbar = this.getDecorToolbar(this.findViewById(R$id.action_bar));
        }
    }
    
    public void restoreToolbarHierarchyState(final SparseArray sparseArray) {
        this.pullChildren();
        this.mDecorToolbar.restoreHierarchyState(sparseArray);
    }
    
    public void saveToolbarHierarchyState(final SparseArray sparseArray) {
        this.pullChildren();
        this.mDecorToolbar.saveHierarchyState(sparseArray);
    }
    
    public void setActionBarHideOffset(int max) {
        this.haltActionBarHideOffsetAnimations();
        max = Math.max(0, Math.min(max, this.mActionBarTop.getHeight()));
        ViewCompat.setTranslationY((View)this.mActionBarTop, -max);
    }
    
    public void setActionBarVisibilityCallback(final ActionBarOverlayLayout$ActionBarVisibilityCallback mActionBarVisibilityCallback) {
        this.mActionBarVisibilityCallback = mActionBarVisibilityCallback;
        if (this.getWindowToken() != null) {
            this.mActionBarVisibilityCallback.onWindowVisibilityChanged(this.mWindowVisibility);
            if (this.mLastSystemUiVisibility != 0) {
                this.onWindowSystemUiVisibilityChanged(this.mLastSystemUiVisibility);
                ViewCompat.requestApplyInsets((View)this);
            }
        }
    }
    
    public void setHasNonEmbeddedTabs(final boolean mHasNonEmbeddedTabs) {
        this.mHasNonEmbeddedTabs = mHasNonEmbeddedTabs;
    }
    
    public void setHideOnContentScrollEnabled(final boolean mHideOnContentScroll) {
        if (mHideOnContentScroll != this.mHideOnContentScroll) {
            if (!(this.mHideOnContentScroll = mHideOnContentScroll)) {
                this.haltActionBarHideOffsetAnimations();
                this.setActionBarHideOffset(0);
            }
        }
    }
    
    public void setIcon(final int icon) {
        this.pullChildren();
        this.mDecorToolbar.setIcon(icon);
    }
    
    public void setIcon(final Drawable icon) {
        this.pullChildren();
        this.mDecorToolbar.setIcon(icon);
    }
    
    public void setLogo(final int logo) {
        this.pullChildren();
        this.mDecorToolbar.setLogo(logo);
    }
    
    public void setMenu(final Menu menu, final MenuPresenter$Callback menuPresenter$Callback) {
        this.pullChildren();
        this.mDecorToolbar.setMenu(menu, menuPresenter$Callback);
    }
    
    public void setMenuPrepared() {
        this.pullChildren();
        this.mDecorToolbar.setMenuPrepared();
    }
    
    public void setOverlayMode(final boolean mOverlayMode) {
        this.mOverlayMode = mOverlayMode;
        this.mIgnoreWindowContentOverlay = (mOverlayMode && this.getContext().getApplicationInfo().targetSdkVersion < 19);
    }
    
    public void setShowingForActionMode(final boolean b) {
    }
    
    public void setUiOptions(final int n) {
    }
    
    public void setWindowCallback(final Window$Callback windowCallback) {
        this.pullChildren();
        this.mDecorToolbar.setWindowCallback(windowCallback);
    }
    
    public void setWindowTitle(final CharSequence windowTitle) {
        this.pullChildren();
        this.mDecorToolbar.setWindowTitle(windowTitle);
    }
    
    public boolean shouldDelayChildPressedState() {
        return false;
    }
    
    public boolean showOverflowMenu() {
        this.pullChildren();
        return this.mDecorToolbar.showOverflowMenu();
    }
}
