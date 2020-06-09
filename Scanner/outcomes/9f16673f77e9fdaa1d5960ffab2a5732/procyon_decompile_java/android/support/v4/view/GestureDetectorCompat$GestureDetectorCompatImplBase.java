// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.VelocityTracker;
import android.view.GestureDetector$OnGestureListener;
import android.os.Handler;
import android.view.GestureDetector$OnDoubleTapListener;
import android.view.MotionEvent;

class GestureDetectorCompat$GestureDetectorCompatImplBase implements GestureDetectorCompat$GestureDetectorCompatImpl
{
    private static final int DOUBLE_TAP_TIMEOUT = 0;
    private static final int LONGPRESS_TIMEOUT = 0;
    private static final int LONG_PRESS = 2;
    private static final int SHOW_PRESS = 1;
    private static final int TAP = 3;
    private static final int TAP_TIMEOUT;
    private boolean mAlwaysInBiggerTapRegion;
    private boolean mAlwaysInTapRegion;
    MotionEvent mCurrentDownEvent;
    boolean mDeferConfirmSingleTap;
    GestureDetector$OnDoubleTapListener mDoubleTapListener;
    private int mDoubleTapSlopSquare;
    private float mDownFocusX;
    private float mDownFocusY;
    private final Handler mHandler;
    private boolean mInLongPress;
    private boolean mIsDoubleTapping;
    private boolean mIsLongpressEnabled;
    private float mLastFocusX;
    private float mLastFocusY;
    final GestureDetector$OnGestureListener mListener;
    private int mMaximumFlingVelocity;
    private int mMinimumFlingVelocity;
    private MotionEvent mPreviousUpEvent;
    boolean mStillDown;
    private int mTouchSlopSquare;
    private VelocityTracker mVelocityTracker;
    
    static {
        TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    }
    
    public GestureDetectorCompat$GestureDetectorCompatImplBase(final Context context, final GestureDetector$OnGestureListener mListener, final Handler handler) {
        if (handler != null) {
            this.mHandler = new GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(this, handler);
        }
        else {
            this.mHandler = new GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(this);
        }
        this.mListener = mListener;
        if (mListener instanceof GestureDetector$OnDoubleTapListener) {
            this.setOnDoubleTapListener((GestureDetector$OnDoubleTapListener)mListener);
        }
        this.init(context);
    }
    
    private void cancel() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        this.mIsDoubleTapping = false;
        this.mStillDown = false;
        this.mAlwaysInTapRegion = false;
        this.mAlwaysInBiggerTapRegion = false;
        this.mDeferConfirmSingleTap = false;
        if (this.mInLongPress) {
            this.mInLongPress = false;
        }
    }
    
    private void cancelTaps() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mIsDoubleTapping = false;
        this.mAlwaysInTapRegion = false;
        this.mAlwaysInBiggerTapRegion = false;
        this.mDeferConfirmSingleTap = false;
        if (this.mInLongPress) {
            this.mInLongPress = false;
        }
    }
    
    private void init(final Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        if (this.mListener != null) {
            this.mIsLongpressEnabled = true;
            final ViewConfiguration value = ViewConfiguration.get(context);
            final int scaledTouchSlop = value.getScaledTouchSlop();
            final int scaledDoubleTapSlop = value.getScaledDoubleTapSlop();
            this.mMinimumFlingVelocity = value.getScaledMinimumFlingVelocity();
            this.mMaximumFlingVelocity = value.getScaledMaximumFlingVelocity();
            this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
            this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
            return;
        }
        throw new IllegalArgumentException("OnGestureListener must not be null");
    }
    
    private boolean isConsideredDoubleTap(final MotionEvent motionEvent, final MotionEvent motionEvent2, final MotionEvent motionEvent3) {
        final boolean mAlwaysInBiggerTapRegion = this.mAlwaysInBiggerTapRegion;
        boolean b = false;
        if (!mAlwaysInBiggerTapRegion) {
            return false;
        }
        if (motionEvent3.getEventTime() - motionEvent2.getEventTime() > GestureDetectorCompat$GestureDetectorCompatImplBase.DOUBLE_TAP_TIMEOUT) {
            return false;
        }
        final int n = (int)motionEvent.getX() - (int)motionEvent3.getX();
        final int n2 = (int)motionEvent.getY() - (int)motionEvent3.getY();
        if (n * n + n2 * n2 < this.mDoubleTapSlopSquare) {
            b = true;
        }
        return b;
    }
    
    void dispatchLongPress() {
        this.mHandler.removeMessages(3);
        this.mDeferConfirmSingleTap = false;
        this.mInLongPress = true;
        this.mListener.onLongPress(this.mCurrentDownEvent);
    }
    
    public boolean isLongpressEnabled() {
        return this.mIsLongpressEnabled;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final int action = motionEvent.getAction();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int n;
        float n2;
        if ((action & 0xFF) == 0x6) {
            n = 1;
            n2 = Float.MIN_VALUE;
        }
        else {
            n = 0;
            n2 = 0.0f;
        }
        int actionIndex;
        if (n != 0) {
            actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        }
        else {
            actionIndex = -1;
        }
        float n3 = 0.0f;
        float n4 = 0.0f;
        final int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; ++i) {
            if (actionIndex != i) {
                n3 += motionEvent.getX(i);
                n4 += motionEvent.getY(i);
            }
        }
        int n5;
        if (n != 0) {
            n5 = pointerCount - 1;
        }
        else {
            n5 = pointerCount;
        }
        final float n6 = n3 / n5;
        final float n7 = n4 / n5;
        boolean b = false;
        final int n8 = action & 0xFF;
        final int n9 = 1000;
        Label_1905: {
            switch (n8) {
                case 6: {
                    this.mLastFocusX = n6;
                    this.mDownFocusX = n6;
                    this.mLastFocusY = n7;
                    this.mDownFocusY = n7;
                    this.mVelocityTracker.computeCurrentVelocity(n9, (float)this.mMaximumFlingVelocity);
                    int actionIndex2 = MotionEventCompat.getActionIndex(motionEvent);
                    final int pointerId = motionEvent.getPointerId(actionIndex2);
                    final float xVelocity = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, pointerId);
                    final float yVelocity = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, pointerId);
                    while (true) {
                        int n10;
                        float n11;
                        int n12;
                        int n13;
                        for (int j = 0; j < pointerCount; ++j, actionIndex2 = n13, n = n10, n2 = n11, actionIndex = n12) {
                            if (j == actionIndex2) {
                                n10 = n;
                                n11 = n2;
                                n12 = actionIndex;
                                n13 = actionIndex2;
                            }
                            else {
                                n10 = n;
                                n11 = n2;
                                final int pointerId2 = motionEvent.getPointerId(j);
                                n12 = actionIndex;
                                final float n14 = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, pointerId2) * xVelocity;
                                n13 = actionIndex2;
                                if (n14 + VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, pointerId2) * yVelocity < 0.0f) {
                                    this.mVelocityTracker.clear();
                                    break Label_1905;
                                }
                            }
                        }
                        continue;
                    }
                }
                case 5: {
                    this.mLastFocusX = n6;
                    this.mDownFocusX = n6;
                    this.mLastFocusY = n7;
                    this.mDownFocusY = n7;
                    this.cancelTaps();
                    break;
                }
                case 3: {
                    this.cancel();
                    break;
                }
                case 2: {
                    if (this.mInLongPress) {
                        break;
                    }
                    final float n15 = this.mLastFocusX - n6;
                    final float n16 = this.mLastFocusY - n7;
                    if (this.mIsDoubleTapping) {
                        b = (false | this.mDoubleTapListener.onDoubleTapEvent(motionEvent));
                        break;
                    }
                    if (this.mAlwaysInTapRegion) {
                        final int n17 = (int)(n6 - this.mDownFocusX);
                        final int n18 = (int)(n7 - this.mDownFocusY);
                        final int n19 = n17 * n17 + n18 * n18;
                        if (n19 > this.mTouchSlopSquare) {
                            final boolean onScroll = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, n15, n16);
                            this.mLastFocusX = n6;
                            this.mLastFocusY = n7;
                            this.mAlwaysInTapRegion = false;
                            this.mHandler.removeMessages(3);
                            this.mHandler.removeMessages(1);
                            this.mHandler.removeMessages(2);
                            b = onScroll;
                        }
                        if (n19 > this.mTouchSlopSquare) {
                            this.mAlwaysInBiggerTapRegion = false;
                        }
                    }
                    else {
                        final float abs = Math.abs(n15);
                        final float n20 = 1.0f;
                        if (abs >= n20 || Math.abs(n16) >= n20) {
                            b = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, n15, n16);
                            this.mLastFocusX = n6;
                            this.mLastFocusY = n7;
                        }
                    }
                    break;
                }
                case 1: {
                    this.mStillDown = false;
                    final MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.mIsDoubleTapping) {
                        b = (false | this.mDoubleTapListener.onDoubleTapEvent(motionEvent));
                    }
                    else if (this.mInLongPress) {
                        this.mHandler.removeMessages(3);
                        this.mInLongPress = false;
                    }
                    else if (this.mAlwaysInTapRegion) {
                        b = this.mListener.onSingleTapUp(motionEvent);
                        if (this.mDeferConfirmSingleTap) {
                            final GestureDetector$OnDoubleTapListener mDoubleTapListener = this.mDoubleTapListener;
                            if (mDoubleTapListener != null) {
                                mDoubleTapListener.onSingleTapConfirmed(motionEvent);
                            }
                        }
                    }
                    else {
                        final VelocityTracker mVelocityTracker = this.mVelocityTracker;
                        final int pointerId3 = motionEvent.getPointerId(0);
                        mVelocityTracker.computeCurrentVelocity(n9, (float)this.mMaximumFlingVelocity);
                        final float yVelocity2 = VelocityTrackerCompat.getYVelocity(mVelocityTracker, pointerId3);
                        final float xVelocity2 = VelocityTrackerCompat.getXVelocity(mVelocityTracker, pointerId3);
                        if (Math.abs(yVelocity2) > this.mMinimumFlingVelocity || Math.abs(xVelocity2) > this.mMinimumFlingVelocity) {
                            b = this.mListener.onFling(this.mCurrentDownEvent, motionEvent, xVelocity2, yVelocity2);
                        }
                    }
                    final MotionEvent mPreviousUpEvent = this.mPreviousUpEvent;
                    if (mPreviousUpEvent != null) {
                        mPreviousUpEvent.recycle();
                    }
                    this.mPreviousUpEvent = obtain;
                    final VelocityTracker mVelocityTracker2 = this.mVelocityTracker;
                    if (mVelocityTracker2 != null) {
                        mVelocityTracker2.recycle();
                        this.mVelocityTracker = null;
                    }
                    this.mIsDoubleTapping = false;
                    this.mDeferConfirmSingleTap = false;
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                    break;
                }
                case 0: {
                    Label_1648: {
                        if (this.mDoubleTapListener != null) {
                            final Handler mHandler = this.mHandler;
                            final int n21 = 3;
                            final boolean hasMessages = mHandler.hasMessages(n21);
                            if (hasMessages) {
                                this.mHandler.removeMessages(n21);
                            }
                            final MotionEvent mCurrentDownEvent = this.mCurrentDownEvent;
                            if (mCurrentDownEvent != null) {
                                final MotionEvent mPreviousUpEvent2 = this.mPreviousUpEvent;
                                if (mPreviousUpEvent2 != null && hasMessages) {
                                    if (this.isConsideredDoubleTap(mCurrentDownEvent, mPreviousUpEvent2, motionEvent)) {
                                        this.mIsDoubleTapping = true;
                                        b = (this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | false | this.mDoubleTapListener.onDoubleTapEvent(motionEvent));
                                        break Label_1648;
                                    }
                                }
                            }
                            this.mHandler.sendEmptyMessageDelayed(3, (long)GestureDetectorCompat$GestureDetectorCompatImplBase.DOUBLE_TAP_TIMEOUT);
                        }
                    }
                    this.mLastFocusX = n6;
                    this.mDownFocusX = n6;
                    this.mLastFocusY = n7;
                    this.mDownFocusY = n7;
                    final MotionEvent mCurrentDownEvent2 = this.mCurrentDownEvent;
                    if (mCurrentDownEvent2 != null) {
                        mCurrentDownEvent2.recycle();
                    }
                    this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
                    final boolean mStillDown = true;
                    this.mAlwaysInTapRegion = mStillDown;
                    this.mAlwaysInBiggerTapRegion = mStillDown;
                    this.mStillDown = mStillDown;
                    this.mInLongPress = false;
                    this.mDeferConfirmSingleTap = false;
                    if (this.mIsLongpressEnabled) {
                        final Handler mHandler2 = this.mHandler;
                        final int n22 = 2;
                        mHandler2.removeMessages(n22);
                        this.mHandler.sendEmptyMessageAtTime(n22, this.mCurrentDownEvent.getDownTime() + GestureDetectorCompat$GestureDetectorCompatImplBase.TAP_TIMEOUT + GestureDetectorCompat$GestureDetectorCompatImplBase.LONGPRESS_TIMEOUT);
                    }
                    this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + GestureDetectorCompat$GestureDetectorCompatImplBase.TAP_TIMEOUT);
                    b |= this.mListener.onDown(motionEvent);
                    break;
                }
            }
        }
        return b;
    }
    
    public void setIsLongpressEnabled(final boolean mIsLongpressEnabled) {
        this.mIsLongpressEnabled = mIsLongpressEnabled;
    }
    
    public void setOnDoubleTapListener(final GestureDetector$OnDoubleTapListener mDoubleTapListener) {
        this.mDoubleTapListener = mDoubleTapListener;
    }
}
