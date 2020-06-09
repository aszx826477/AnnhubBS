// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.os.SystemClock;
import android.view.ViewParent;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.View$OnAttachStateChangeListener;
import android.view.ViewConfiguration;
import android.os.Build$VERSION;
import android.view.View;
import android.view.View$OnTouchListener;

public abstract class ForwardingListener implements View$OnTouchListener
{
    private int mActivePointerId;
    private Runnable mDisallowIntercept;
    private boolean mForwarding;
    private final int mLongPressTimeout;
    private final float mScaledTouchSlop;
    final View mSrc;
    private final int mTapTimeout;
    private final int[] mTmpLocation;
    private Runnable mTriggerLongPress;
    
    public ForwardingListener(final View mSrc) {
        final int n = 2;
        this.mTmpLocation = new int[n];
        (this.mSrc = mSrc).setLongClickable(true);
        if (Build$VERSION.SDK_INT >= 12) {
            this.addDetachListenerApi12(mSrc);
        }
        else {
            this.addDetachListenerBase(mSrc);
        }
        this.mScaledTouchSlop = ViewConfiguration.get(mSrc.getContext()).getScaledTouchSlop();
        this.mTapTimeout = ViewConfiguration.getTapTimeout();
        this.mLongPressTimeout = (this.mTapTimeout + ViewConfiguration.getLongPressTimeout()) / n;
    }
    
    private void addDetachListenerApi12(final View view) {
        view.addOnAttachStateChangeListener((View$OnAttachStateChangeListener)new ForwardingListener$1(this));
    }
    
    private void addDetachListenerBase(final View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)new ForwardingListener$2(this));
    }
    
    private void clearCallbacks() {
        final Runnable mTriggerLongPress = this.mTriggerLongPress;
        if (mTriggerLongPress != null) {
            this.mSrc.removeCallbacks(mTriggerLongPress);
        }
        final Runnable mDisallowIntercept = this.mDisallowIntercept;
        if (mDisallowIntercept != null) {
            this.mSrc.removeCallbacks(mDisallowIntercept);
        }
    }
    
    private void onDetachedFromWindow() {
        this.mForwarding = false;
        this.mActivePointerId = -1;
        final Runnable mDisallowIntercept = this.mDisallowIntercept;
        if (mDisallowIntercept != null) {
            this.mSrc.removeCallbacks(mDisallowIntercept);
        }
    }
    
    private boolean onTouchForwarded(final MotionEvent motionEvent) {
        final View mSrc = this.mSrc;
        final ShowableListMenu popup = this.getPopup();
        boolean b = false;
        if (popup == null || popup.isShowing()) {
            return false;
        }
        final DropDownListView dropDownListView = (DropDownListView)popup.getListView();
        if (dropDownListView != null && dropDownListView.isShown()) {
            final MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            this.toGlobalMotionEvent(mSrc, obtainNoHistory);
            this.toLocalMotionEvent((View)dropDownListView, obtainNoHistory);
            final boolean onForwardedEvent = dropDownListView.onForwardedEvent(obtainNoHistory, this.mActivePointerId);
            obtainNoHistory.recycle();
            final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            final boolean b2 = actionMasked != 1 && actionMasked != 3;
            if (onForwardedEvent && b2) {
                b = true;
            }
            return b;
        }
        return false;
    }
    
    private boolean onTouchObserved(final MotionEvent motionEvent) {
        final View mSrc = this.mSrc;
        if (!mSrc.isEnabled()) {
            return false;
        }
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 2: {
                final int pointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (pointerIndex < 0) {
                    break;
                }
                if (!pointInView(mSrc, motionEvent.getX(pointerIndex), motionEvent.getY(pointerIndex), this.mScaledTouchSlop)) {
                    this.clearCallbacks();
                    final ViewParent parent = mSrc.getParent();
                    final boolean b = true;
                    parent.requestDisallowInterceptTouchEvent(b);
                    return b;
                }
                break;
            }
            case 1:
            case 3: {
                this.clearCallbacks();
                break;
            }
            case 0: {
                this.mActivePointerId = motionEvent.getPointerId(0);
                if (this.mDisallowIntercept == null) {
                    this.mDisallowIntercept = new ForwardingListener$DisallowIntercept(this);
                }
                mSrc.postDelayed(this.mDisallowIntercept, (long)this.mTapTimeout);
                if (this.mTriggerLongPress == null) {
                    this.mTriggerLongPress = new ForwardingListener$TriggerLongPress(this);
                }
                mSrc.postDelayed(this.mTriggerLongPress, (long)this.mLongPressTimeout);
                break;
            }
        }
        return false;
    }
    
    private static boolean pointInView(final View view, final float n, final float n2, final float n3) {
        if (n >= -n3 && n2 >= -n3) {
            if (n < view.getRight() - view.getLeft() + n3) {
                if (n2 < view.getBottom() - view.getTop() + n3) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean toGlobalMotionEvent(final View view, final MotionEvent motionEvent) {
        final int[] mTmpLocation = this.mTmpLocation;
        view.getLocationOnScreen(mTmpLocation);
        final float n = mTmpLocation[0];
        final int n2 = 1;
        motionEvent.offsetLocation(n, (float)mTmpLocation[n2]);
        return n2 != 0;
    }
    
    private boolean toLocalMotionEvent(final View view, final MotionEvent motionEvent) {
        final int[] mTmpLocation = this.mTmpLocation;
        view.getLocationOnScreen(mTmpLocation);
        final float n = -mTmpLocation[0];
        final int n2 = 1;
        motionEvent.offsetLocation(n, (float)(-mTmpLocation[n2]));
        return n2 != 0;
    }
    
    public abstract ShowableListMenu getPopup();
    
    protected boolean onForwardingStarted() {
        final ShowableListMenu popup = this.getPopup();
        if (popup != null && !popup.isShowing()) {
            popup.show();
        }
        return true;
    }
    
    protected boolean onForwardingStopped() {
        final ShowableListMenu popup = this.getPopup();
        if (popup != null && popup.isShowing()) {
            popup.dismiss();
        }
        return true;
    }
    
    void onLongPress() {
        this.clearCallbacks();
        final View mSrc = this.mSrc;
        if (!mSrc.isEnabled() || mSrc.isLongClickable()) {
            return;
        }
        if (!this.onForwardingStarted()) {
            return;
        }
        final ViewParent parent = mSrc.getParent();
        final boolean mForwarding = true;
        parent.requestDisallowInterceptTouchEvent(mForwarding);
        final long uptimeMillis = SystemClock.uptimeMillis();
        final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        mSrc.onTouchEvent(obtain);
        obtain.recycle();
        this.mForwarding = mForwarding;
    }
    
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        final boolean mForwarding = this.mForwarding;
        boolean b = true;
        boolean mForwarding2;
        if (mForwarding) {
            mForwarding2 = (this.onTouchForwarded(motionEvent) || !this.onForwardingStopped());
        }
        else {
            mForwarding2 = (this.onTouchObserved(motionEvent) && this.onForwardingStarted());
            if (mForwarding2) {
                final long uptimeMillis = SystemClock.uptimeMillis();
                final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.mSrc.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        if (!(this.mForwarding = mForwarding2)) {
            if (!mForwarding) {
                b = false;
            }
        }
        return b;
    }
}
