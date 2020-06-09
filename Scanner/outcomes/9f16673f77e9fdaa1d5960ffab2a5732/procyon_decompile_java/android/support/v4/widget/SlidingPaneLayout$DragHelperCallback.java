// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.View;

class SlidingPaneLayout$DragHelperCallback extends ViewDragHelper$Callback
{
    final /* synthetic */ SlidingPaneLayout this$0;
    
    SlidingPaneLayout$DragHelperCallback(final SlidingPaneLayout this$0) {
        this.this$0 = this$0;
    }
    
    public int clampViewPositionHorizontal(final View view, final int n, final int n2) {
        final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)this.this$0.mSlideableView.getLayoutParams();
        int n4;
        if (this.this$0.isLayoutRtlSupport()) {
            final int n3 = this.this$0.getWidth() - (this.this$0.getPaddingRight() + slidingPaneLayout$LayoutParams.rightMargin + this.this$0.mSlideableView.getWidth());
            n4 = Math.max(Math.min(n, n3), n3 - this.this$0.mSlideRange);
        }
        else {
            final int n5 = this.this$0.getPaddingLeft() + slidingPaneLayout$LayoutParams.leftMargin;
            n4 = Math.min(Math.max(n, n5), this.this$0.mSlideRange + n5);
        }
        return n4;
    }
    
    public int clampViewPositionVertical(final View view, final int n, final int n2) {
        return view.getTop();
    }
    
    public int getViewHorizontalDragRange(final View view) {
        return this.this$0.mSlideRange;
    }
    
    public void onEdgeDragStarted(final int n, final int n2) {
        this.this$0.mDragHelper.captureChildView(this.this$0.mSlideableView, n2);
    }
    
    public void onViewCaptured(final View view, final int n) {
        this.this$0.setAllChildrenVisible();
    }
    
    public void onViewDragStateChanged(final int n) {
        if (this.this$0.mDragHelper.getViewDragState() == 0) {
            if (this.this$0.mSlideOffset == 0.0f) {
                final SlidingPaneLayout this$0 = this.this$0;
                this$0.updateObscuredViewsVisibility(this$0.mSlideableView);
                final SlidingPaneLayout this$2 = this.this$0;
                this$2.dispatchOnPanelClosed(this$2.mSlideableView);
                this.this$0.mPreservedOpenState = false;
            }
            else {
                final SlidingPaneLayout this$3 = this.this$0;
                this$3.dispatchOnPanelOpened(this$3.mSlideableView);
                this.this$0.mPreservedOpenState = true;
            }
        }
    }
    
    public void onViewPositionChanged(final View view, final int n, final int n2, final int n3, final int n4) {
        this.this$0.onPanelDragged(n);
        this.this$0.invalidate();
    }
    
    public void onViewReleased(final View view, final float n, final float n2) {
        final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)view.getLayoutParams();
        final boolean layoutRtlSupport = this.this$0.isLayoutRtlSupport();
        final float n3 = 0.5f;
        int n5;
        if (layoutRtlSupport) {
            int n4 = this.this$0.getPaddingRight() + slidingPaneLayout$LayoutParams.rightMargin;
            if (n < 0.0f || (n == 0.0f && this.this$0.mSlideOffset > n3)) {
                n4 += this.this$0.mSlideRange;
            }
            n5 = this.this$0.getWidth() - n4 - this.this$0.mSlideableView.getWidth();
        }
        else {
            final int n6 = this.this$0.getPaddingLeft() + slidingPaneLayout$LayoutParams.leftMargin;
            if (n <= 0.0f && (n != 0.0f || this.this$0.mSlideOffset <= n3)) {
                n5 = n6;
            }
            else {
                n5 = n6 + this.this$0.mSlideRange;
            }
        }
        this.this$0.mDragHelper.settleCapturedViewAt(n5, view.getTop());
        this.this$0.invalidate();
    }
    
    public boolean tryCaptureView(final View view, final int n) {
        return !this.this$0.mIsUnableToDrag && ((SlidingPaneLayout$LayoutParams)view.getLayoutParams()).slideable;
    }
}
