// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R$styleable;
import android.content.res.Configuration;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ContextThemeWrapper;
import android.support.v7.appcompat.R$attr;
import android.util.TypedValue;
import android.util.AttributeSet;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.content.Context;
import android.view.ViewGroup;

abstract class AbsActionBarView extends ViewGroup
{
    private static final int FADE_DURATION = 200;
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    protected ActionMenuView mMenuView;
    protected final Context mPopupContext;
    protected final AbsActionBarView$VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimatorCompat mVisibilityAnim;
    
    AbsActionBarView(final Context context) {
        this(context, null);
    }
    
    AbsActionBarView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    AbsActionBarView(final Context mPopupContext, final AttributeSet set, final int n) {
        super(mPopupContext, set, n);
        this.mVisAnimListener = new AbsActionBarView$VisibilityAnimListener(this);
        final TypedValue typedValue = new TypedValue();
        if (mPopupContext.getTheme().resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.mPopupContext = (Context)new ContextThemeWrapper(mPopupContext, typedValue.resourceId);
        }
        else {
            this.mPopupContext = mPopupContext;
        }
    }
    
    protected static int next(final int n, final int n2, final boolean b) {
        int n3;
        if (b) {
            n3 = n - n2;
        }
        else {
            n3 = n + n2;
        }
        return n3;
    }
    
    public void animateToVisibility(final int n) {
        this.setupAnimatorToVisibility(n, 200L).start();
    }
    
    public boolean canShowOverflowMenu() {
        return this.isOverflowReserved() && this.getVisibility() == 0;
    }
    
    public void dismissPopupMenus() {
        final ActionMenuPresenter mActionMenuPresenter = this.mActionMenuPresenter;
        if (mActionMenuPresenter != null) {
            mActionMenuPresenter.dismissPopupMenus();
        }
    }
    
    public int getAnimatedVisibility() {
        if (this.mVisibilityAnim != null) {
            return this.mVisAnimListener.mFinalVisibility;
        }
        return this.getVisibility();
    }
    
    public int getContentHeight() {
        return this.mContentHeight;
    }
    
    public boolean hideOverflowMenu() {
        final ActionMenuPresenter mActionMenuPresenter = this.mActionMenuPresenter;
        return mActionMenuPresenter != null && mActionMenuPresenter.hideOverflowMenu();
    }
    
    public boolean isOverflowMenuShowPending() {
        final ActionMenuPresenter mActionMenuPresenter = this.mActionMenuPresenter;
        return mActionMenuPresenter != null && mActionMenuPresenter.isOverflowMenuShowPending();
    }
    
    public boolean isOverflowMenuShowing() {
        final ActionMenuPresenter mActionMenuPresenter = this.mActionMenuPresenter;
        return mActionMenuPresenter != null && mActionMenuPresenter.isOverflowMenuShowing();
    }
    
    public boolean isOverflowReserved() {
        final ActionMenuPresenter mActionMenuPresenter = this.mActionMenuPresenter;
        return mActionMenuPresenter != null && mActionMenuPresenter.isOverflowReserved();
    }
    
    protected int measureChildView(final View view, int n, final int n2, final int n3) {
        view.measure(View$MeasureSpec.makeMeasureSpec(n, -1 << -1), n2);
        n = n - view.getMeasuredWidth() - n3;
        return Math.max(0, n);
    }
    
    protected void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes((AttributeSet)null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.setContentHeight(obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        final ActionMenuPresenter mActionMenuPresenter = this.mActionMenuPresenter;
        if (mActionMenuPresenter != null) {
            mActionMenuPresenter.onConfigurationChanged(configuration);
        }
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
    
    protected int positionChild(final View view, final int n, final int n2, final int n3, final boolean b) {
        final int measuredWidth = view.getMeasuredWidth();
        final int measuredHeight = view.getMeasuredHeight();
        final int n4 = (n3 - measuredHeight) / 2 + n2;
        if (b) {
            view.layout(n - measuredWidth, n4, n, n4 + measuredHeight);
        }
        else {
            view.layout(n, n4, n + measuredWidth, n4 + measuredHeight);
        }
        int n5;
        if (b) {
            n5 = -measuredWidth;
        }
        else {
            n5 = measuredWidth;
        }
        return n5;
    }
    
    public void postShowOverflowMenu() {
        this.post((Runnable)new AbsActionBarView$1(this));
    }
    
    public void setContentHeight(final int mContentHeight) {
        this.mContentHeight = mContentHeight;
        this.requestLayout();
    }
    
    public void setVisibility(final int visibility) {
        if (visibility != this.getVisibility()) {
            final ViewPropertyAnimatorCompat mVisibilityAnim = this.mVisibilityAnim;
            if (mVisibilityAnim != null) {
                mVisibilityAnim.cancel();
            }
            super.setVisibility(visibility);
        }
    }
    
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int n, final long n2) {
        final ViewPropertyAnimatorCompat mVisibilityAnim = this.mVisibilityAnim;
        if (mVisibilityAnim != null) {
            mVisibilityAnim.cancel();
        }
        if (n == 0) {
            if (this.getVisibility() != 0) {
                ViewCompat.setAlpha((View)this, 0.0f);
            }
            final ViewPropertyAnimatorCompat alpha = ViewCompat.animate((View)this).alpha(1.0f);
            alpha.setDuration(n2);
            alpha.setListener(this.mVisAnimListener.withFinalVisibility(alpha, n));
            return alpha;
        }
        final ViewPropertyAnimatorCompat alpha2 = ViewCompat.animate((View)this).alpha(0.0f);
        alpha2.setDuration(n2);
        alpha2.setListener(this.mVisAnimListener.withFinalVisibility(alpha2, n));
        return alpha2;
    }
    
    public boolean showOverflowMenu() {
        final ActionMenuPresenter mActionMenuPresenter = this.mActionMenuPresenter;
        return mActionMenuPresenter != null && mActionMenuPresenter.showOverflowMenu();
    }
}
