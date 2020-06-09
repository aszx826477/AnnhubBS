// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.View;
import android.graphics.Rect;
import android.view.TouchDelegate;

class SearchView$UpdatableTouchDelegate extends TouchDelegate
{
    private final Rect mActualBounds;
    private boolean mDelegateTargeted;
    private final View mDelegateView;
    private final int mSlop;
    private final Rect mSlopBounds;
    private final Rect mTargetBounds;
    
    public SearchView$UpdatableTouchDelegate(final Rect rect, final Rect rect2, final View mDelegateView) {
        super(rect, mDelegateView);
        this.mSlop = ViewConfiguration.get(mDelegateView.getContext()).getScaledTouchSlop();
        this.mTargetBounds = new Rect();
        this.mSlopBounds = new Rect();
        this.mActualBounds = new Rect();
        this.setBounds(rect, rect2);
        this.mDelegateView = mDelegateView;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final int n = (int)motionEvent.getX();
        final int n2 = (int)motionEvent.getY();
        int n3 = 0;
        boolean b = true;
        boolean dispatchTouchEvent = false;
        switch (motionEvent.getAction()) {
            case 3: {
                n3 = (this.mDelegateTargeted ? 1 : 0);
                this.mDelegateTargeted = false;
                break;
            }
            case 1:
            case 2: {
                n3 = (this.mDelegateTargeted ? 1 : 0);
                if (n3 == 0) {
                    break;
                }
                if (!this.mSlopBounds.contains(n, n2)) {
                    b = false;
                    break;
                }
                break;
            }
            case 0: {
                if (this.mTargetBounds.contains(n, n2)) {
                    this.mDelegateTargeted = true;
                    n3 = 1;
                    break;
                }
                break;
            }
        }
        if (n3 != 0) {
            if (b && !this.mActualBounds.contains(n, n2)) {
                motionEvent.setLocation((float)(this.mDelegateView.getWidth() / 2), (float)(this.mDelegateView.getHeight() / 2));
            }
            else {
                motionEvent.setLocation((float)(n - this.mActualBounds.left), (float)(n2 - this.mActualBounds.top));
            }
            dispatchTouchEvent = this.mDelegateView.dispatchTouchEvent(motionEvent);
        }
        return dispatchTouchEvent;
    }
    
    public void setBounds(final Rect rect, final Rect rect2) {
        this.mTargetBounds.set(rect);
        this.mSlopBounds.set(rect);
        final Rect mSlopBounds = this.mSlopBounds;
        final int mSlop = this.mSlop;
        mSlopBounds.inset(-mSlop, -mSlop);
        this.mActualBounds.set(rect2);
    }
}
