// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.View;

class DrawerLayout$ViewDragCallback extends ViewDragHelper$Callback
{
    private final int mAbsGravity;
    private ViewDragHelper mDragger;
    private final Runnable mPeekRunnable;
    final /* synthetic */ DrawerLayout this$0;
    
    DrawerLayout$ViewDragCallback(final DrawerLayout this$0, final int mAbsGravity) {
        this.this$0 = this$0;
        this.mPeekRunnable = new DrawerLayout$ViewDragCallback$1(this);
        this.mAbsGravity = mAbsGravity;
    }
    
    private void closeOtherDrawer() {
        final int mAbsGravity = this.mAbsGravity;
        int n = 3;
        if (mAbsGravity == n) {
            n = 5;
        }
        final View drawerWithGravity = this.this$0.findDrawerWithGravity(n);
        if (drawerWithGravity != null) {
            this.this$0.closeDrawer(drawerWithGravity);
        }
    }
    
    public int clampViewPositionHorizontal(final View view, final int n, final int n2) {
        if (this.this$0.checkDrawerViewAbsoluteGravity(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(n, 0));
        }
        final int width = this.this$0.getWidth();
        return Math.max(width - view.getWidth(), Math.min(n, width));
    }
    
    public int clampViewPositionVertical(final View view, final int n, final int n2) {
        return view.getTop();
    }
    
    public int getViewHorizontalDragRange(final View view) {
        int width;
        if (this.this$0.isDrawerView(view)) {
            width = view.getWidth();
        }
        else {
            width = 0;
        }
        return width;
    }
    
    public void onEdgeDragStarted(final int n, final int n2) {
        View view;
        if ((n & 0x1) == 0x1) {
            view = this.this$0.findDrawerWithGravity(3);
        }
        else {
            view = this.this$0.findDrawerWithGravity(5);
        }
        if (view != null && this.this$0.getDrawerLockMode(view) == 0) {
            this.mDragger.captureChildView(view, n2);
        }
    }
    
    public boolean onEdgeLock(final int n) {
        return false;
    }
    
    public void onEdgeTouched(final int n, final int n2) {
        this.this$0.postDelayed(this.mPeekRunnable, 160L);
    }
    
    public void onViewCaptured(final View view, final int n) {
        ((DrawerLayout$LayoutParams)view.getLayoutParams()).isPeeking = false;
        this.closeOtherDrawer();
    }
    
    public void onViewDragStateChanged(final int n) {
        this.this$0.updateDrawerState(this.mAbsGravity, n, this.mDragger.getCapturedView());
    }
    
    public void onViewPositionChanged(final View view, final int n, final int n2, final int n3, final int n4) {
        final int width = view.getWidth();
        float n5;
        if (this.this$0.checkDrawerViewAbsoluteGravity(view, 3)) {
            n5 = (width + n) / width;
        }
        else {
            n5 = (this.this$0.getWidth() - n) / width;
        }
        this.this$0.setDrawerViewOffset(view, n5);
        int visibility;
        if (n5 == 0.0f) {
            visibility = 4;
        }
        else {
            visibility = 0;
        }
        view.setVisibility(visibility);
        this.this$0.invalidate();
    }
    
    public void onViewReleased(final View view, final float n, final float n2) {
        final float drawerViewOffset = this.this$0.getDrawerViewOffset(view);
        final int width = view.getWidth();
        final boolean checkDrawerViewAbsoluteGravity = this.this$0.checkDrawerViewAbsoluteGravity(view, 3);
        final float n3 = 0.5f;
        int n4;
        if (checkDrawerViewAbsoluteGravity) {
            if (n <= 0.0f && (n != 0.0f || drawerViewOffset <= n3)) {
                n4 = -width;
            }
            else {
                n4 = 0;
            }
        }
        else {
            final int width2 = this.this$0.getWidth();
            int n5;
            if (n >= 0.0f && (n != 0.0f || drawerViewOffset <= n3)) {
                n5 = width2;
            }
            else {
                n5 = width2 - width;
            }
            n4 = n5;
        }
        this.mDragger.settleCapturedViewAt(n4, view.getTop());
        this.this$0.invalidate();
    }
    
    void peekDrawer() {
        final int edgeSize = this.mDragger.getEdgeSize();
        final int mAbsGravity = this.mAbsGravity;
        final boolean isPeeking = true;
        int n = 0;
        final int n2 = 3;
        final boolean b = mAbsGravity == n2;
        View view;
        int n3;
        if (b) {
            view = this.this$0.findDrawerWithGravity(n2);
            if (view != null) {
                n = -view.getWidth();
            }
            n3 = n + edgeSize;
        }
        else {
            view = this.this$0.findDrawerWithGravity(5);
            n3 = this.this$0.getWidth() - edgeSize;
        }
        if (view != null) {
            if (!b || view.getLeft() >= n3) {
                if (b) {
                    return;
                }
                if (view.getLeft() <= n3) {
                    return;
                }
            }
            if (this.this$0.getDrawerLockMode(view) == 0) {
                final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
                this.mDragger.smoothSlideViewTo(view, n3, view.getTop());
                drawerLayout$LayoutParams.isPeeking = isPeeking;
                this.this$0.invalidate();
                this.closeOtherDrawer();
                this.this$0.cancelChildViewTouch();
            }
        }
    }
    
    public void removeCallbacks() {
        this.this$0.removeCallbacks(this.mPeekRunnable);
    }
    
    public void setDragger(final ViewDragHelper mDragger) {
        this.mDragger = mDragger;
    }
    
    public boolean tryCaptureView(final View view, final int n) {
        return this.this$0.isDrawerView(view) && this.this$0.checkDrawerViewAbsoluteGravity(view, this.mAbsGravity) && this.this$0.getDrawerLockMode(view) == 0;
    }
}
