// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public class NestedScrollingChildHelper
{
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParent;
    private int[] mTempNestedScrollConsumed;
    private final View mView;
    
    public NestedScrollingChildHelper(final View mView) {
        this.mView = mView;
    }
    
    public boolean dispatchNestedFling(final float n, final float n2, final boolean b) {
        if (this.isNestedScrollingEnabled()) {
            final ViewParent mNestedScrollingParent = this.mNestedScrollingParent;
            if (mNestedScrollingParent != null) {
                return ViewParentCompat.onNestedFling(mNestedScrollingParent, this.mView, n, n2, b);
            }
        }
        return false;
    }
    
    public boolean dispatchNestedPreFling(final float n, final float n2) {
        if (this.isNestedScrollingEnabled()) {
            final ViewParent mNestedScrollingParent = this.mNestedScrollingParent;
            if (mNestedScrollingParent != null) {
                return ViewParentCompat.onNestedPreFling(mNestedScrollingParent, this.mView, n, n2);
            }
        }
        return false;
    }
    
    public boolean dispatchNestedPreScroll(final int n, final int n2, int[] mTempNestedScrollConsumed, final int[] array) {
        if (this.isNestedScrollingEnabled() && this.mNestedScrollingParent != null) {
            int n3 = 1;
            if (n != 0 || n2 != 0) {
                int n4 = 0;
                int n5 = 0;
                if (array != null) {
                    this.mView.getLocationInWindow(array);
                    n4 = array[0];
                    n5 = array[n3];
                }
                if (mTempNestedScrollConsumed == null) {
                    if (this.mTempNestedScrollConsumed == null) {
                        this.mTempNestedScrollConsumed = new int[2];
                    }
                    mTempNestedScrollConsumed = this.mTempNestedScrollConsumed;
                }
                mTempNestedScrollConsumed[n3] = (mTempNestedScrollConsumed[0] = 0);
                ViewParentCompat.onNestedPreScroll(this.mNestedScrollingParent, this.mView, n, n2, mTempNestedScrollConsumed);
                if (array != null) {
                    this.mView.getLocationInWindow(array);
                    array[0] -= n4;
                    array[n3] -= n5;
                }
                if (mTempNestedScrollConsumed[0] == 0) {
                    if (mTempNestedScrollConsumed[n3] == 0) {
                        n3 = 0;
                    }
                }
                return n3 != 0;
            }
            if (array != null) {
                array[n3] = (array[0] = 0);
            }
        }
        return false;
    }
    
    public boolean dispatchNestedScroll(final int n, final int n2, final int n3, final int n4, final int[] array) {
        if (this.isNestedScrollingEnabled() && this.mNestedScrollingParent != null) {
            final int n5 = 1;
            if (n != 0 || n2 != 0 || n3 != 0 || n4 != 0) {
                int n6 = 0;
                int n7 = 0;
                if (array != null) {
                    this.mView.getLocationInWindow(array);
                    n6 = array[0];
                    n7 = array[n5];
                }
                ViewParentCompat.onNestedScroll(this.mNestedScrollingParent, this.mView, n, n2, n3, n4);
                if (array != null) {
                    this.mView.getLocationInWindow(array);
                    array[0] -= n6;
                    array[n5] -= n7;
                }
                return n5 != 0;
            }
            if (array != null) {
                array[n5] = (array[0] = 0);
            }
        }
        return false;
    }
    
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingParent != null;
    }
    
    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }
    
    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }
    
    public void onStopNestedScroll(final View view) {
        ViewCompat.stopNestedScroll(this.mView);
    }
    
    public void setNestedScrollingEnabled(final boolean mIsNestedScrollingEnabled) {
        if (this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(this.mView);
        }
        this.mIsNestedScrollingEnabled = mIsNestedScrollingEnabled;
    }
    
    public boolean startNestedScroll(final int n) {
        final boolean hasNestedScrollingParent = this.hasNestedScrollingParent();
        final boolean b = true;
        if (hasNestedScrollingParent) {
            return b;
        }
        if (this.isNestedScrollingEnabled()) {
            ViewParent mNestedScrollingParent = this.mView.getParent();
            View mView = this.mView;
            while (mNestedScrollingParent != null) {
                if (ViewParentCompat.onStartNestedScroll(mNestedScrollingParent, mView, this.mView, n)) {
                    ViewParentCompat.onNestedScrollAccepted(this.mNestedScrollingParent = mNestedScrollingParent, mView, this.mView, n);
                    return b;
                }
                if (mNestedScrollingParent instanceof View) {
                    mView = (View)mNestedScrollingParent;
                }
                mNestedScrollingParent = mNestedScrollingParent.getParent();
            }
        }
        return false;
    }
    
    public void stopNestedScroll() {
        final ViewParent mNestedScrollingParent = this.mNestedScrollingParent;
        if (mNestedScrollingParent != null) {
            ViewParentCompat.onStopNestedScroll(mNestedScrollingParent, this.mView);
            this.mNestedScrollingParent = null;
        }
    }
}
