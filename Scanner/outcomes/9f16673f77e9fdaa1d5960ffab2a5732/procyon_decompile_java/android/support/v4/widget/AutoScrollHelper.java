// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.content.res.Resources;
import android.view.animation.AccelerateInterpolator;
import android.view.ViewConfiguration;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.View$OnTouchListener;

public abstract class AutoScrollHelper implements View$OnTouchListener
{
    private static final int DEFAULT_ACTIVATION_DELAY = 0;
    private static final int DEFAULT_EDGE_TYPE = 1;
    private static final float DEFAULT_MAXIMUM_EDGE = Float.MAX_VALUE;
    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    private static final int DEFAULT_RAMP_UP_DURATION = 500;
    private static final float DEFAULT_RELATIVE_EDGE = 0.2f;
    private static final float DEFAULT_RELATIVE_VELOCITY = 1.0f;
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    private static final int HORIZONTAL = 0;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;
    private static final int VERTICAL = 1;
    private int mActivationDelay;
    private boolean mAlreadyDelayed;
    boolean mAnimating;
    private final Interpolator mEdgeInterpolator;
    private int mEdgeType;
    private boolean mEnabled;
    private boolean mExclusive;
    private float[] mMaximumEdges;
    private float[] mMaximumVelocity;
    private float[] mMinimumVelocity;
    boolean mNeedsCancel;
    boolean mNeedsReset;
    private float[] mRelativeEdges;
    private float[] mRelativeVelocity;
    private Runnable mRunnable;
    final AutoScrollHelper$ClampedScroller mScroller;
    final View mTarget;
    
    public AutoScrollHelper(final View mTarget) {
        this.mScroller = new AutoScrollHelper$ClampedScroller();
        this.mEdgeInterpolator = (Interpolator)new AccelerateInterpolator();
        final int n = 2;
        final float[] array;
        final float[] mRelativeEdges = array = new float[n];
        array[1] = (array[0] = 0.0f);
        this.mRelativeEdges = mRelativeEdges;
        final float[] array2;
        final float[] mMaximumEdges = array2 = new float[n];
        array2[1] = (array2[0] = Float.MAX_VALUE);
        this.mMaximumEdges = mMaximumEdges;
        final float[] array3;
        final float[] mRelativeVelocity = array3 = new float[n];
        array3[1] = (array3[0] = 0.0f);
        this.mRelativeVelocity = mRelativeVelocity;
        final float[] array4;
        final float[] mMinimumVelocity = array4 = new float[n];
        array4[1] = (array4[0] = 0.0f);
        this.mMinimumVelocity = mMinimumVelocity;
        final float[] array5;
        final float[] mMaximumVelocity = array5 = new float[n];
        array5[1] = (array5[0] = Float.MAX_VALUE);
        this.mMaximumVelocity = mMaximumVelocity;
        this.mTarget = mTarget;
        final DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        final float n2 = displayMetrics.density * 1575.0f;
        final float n3 = 0.5f;
        final int n4 = (int)(n2 + n3);
        final int n5 = (int)(displayMetrics.density * 315.0f + n3);
        this.setMaximumVelocity(n4, n4);
        this.setMinimumVelocity(n5, n5);
        this.setEdgeType(1);
        final float n6 = Float.MAX_VALUE;
        this.setMaximumEdges(n6, n6);
        final float n7 = 0.2f;
        this.setRelativeEdges(n7, n7);
        final float n8 = 1.0f;
        this.setRelativeVelocity(n8, n8);
        this.setActivationDelay(AutoScrollHelper.DEFAULT_ACTIVATION_DELAY);
        final int n9 = 500;
        this.setRampUpDuration(n9);
        this.setRampDownDuration(n9);
    }
    
    private float computeTargetVelocity(final int n, final float n2, final float n3, final float n4) {
        final float edgeValue = this.getEdgeValue(this.mRelativeEdges[n], n3, this.mMaximumEdges[n], n2);
        if (edgeValue == 0.0f) {
            return 0.0f;
        }
        final float n5 = this.mRelativeVelocity[n];
        final float n6 = this.mMinimumVelocity[n];
        final float n7 = this.mMaximumVelocity[n];
        final float n8 = n5 * n4;
        if (edgeValue > 0.0f) {
            return constrain(edgeValue * n8, n6, n7);
        }
        return -constrain(-edgeValue * n8, n6, n7);
    }
    
    static float constrain(final float n, final float n2, final float n3) {
        if (n > n3) {
            return n3;
        }
        if (n < n2) {
            return n2;
        }
        return n;
    }
    
    static int constrain(final int n, final int n2, final int n3) {
        if (n > n3) {
            return n3;
        }
        if (n < n2) {
            return n2;
        }
        return n;
    }
    
    private float constrainEdgeValue(final float n, final float n2) {
        if (n2 == 0.0f) {
            return 0.0f;
        }
        final int mEdgeType = this.mEdgeType;
        switch (mEdgeType) {
            case 2: {
                if (n < 0.0f) {
                    return n / -n2;
                }
                break;
            }
            case 0:
            case 1: {
                if (n >= n2) {
                    break;
                }
                final float n3 = 1.0f;
                if (n >= 0.0f) {
                    return n3 - n / n2;
                }
                if (this.mAnimating && mEdgeType == 1) {
                    return n3;
                }
                break;
            }
        }
        return 0.0f;
    }
    
    private float getEdgeValue(final float n, final float n2, final float n3, final float n4) {
        final float constrain = constrain(n * n2, 0.0f, n3);
        final float n5 = this.constrainEdgeValue(n2 - n4, constrain) - this.constrainEdgeValue(n4, constrain);
        float interpolation;
        if (n5 < 0.0f) {
            interpolation = -this.mEdgeInterpolator.getInterpolation(-n5);
        }
        else {
            if (n5 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.mEdgeInterpolator.getInterpolation(n5);
        }
        return constrain(interpolation, -1.0f, 1.0f);
    }
    
    private void requestStop() {
        if (this.mNeedsReset) {
            this.mAnimating = false;
        }
        else {
            this.mScroller.requestStop();
        }
    }
    
    private void startAnimating() {
        if (this.mRunnable == null) {
            this.mRunnable = new AutoScrollHelper$ScrollAnimationRunnable(this);
        }
        final boolean mAlreadyDelayed = true;
        this.mAnimating = mAlreadyDelayed;
        this.mNeedsReset = mAlreadyDelayed;
        Label_0097: {
            if (!this.mAlreadyDelayed) {
                final int mActivationDelay = this.mActivationDelay;
                if (mActivationDelay > 0) {
                    ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, mActivationDelay);
                    break Label_0097;
                }
            }
            this.mRunnable.run();
        }
        this.mAlreadyDelayed = mAlreadyDelayed;
    }
    
    public abstract boolean canTargetScrollHorizontally(final int p0);
    
    public abstract boolean canTargetScrollVertically(final int p0);
    
    void cancelTargetTouch() {
        final long uptimeMillis = SystemClock.uptimeMillis();
        final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.mTarget.onTouchEvent(obtain);
        obtain.recycle();
    }
    
    public boolean isEnabled() {
        return this.mEnabled;
    }
    
    public boolean isExclusive() {
        return this.mExclusive;
    }
    
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        final boolean mEnabled = this.mEnabled;
        boolean b = false;
        if (!mEnabled) {
            return false;
        }
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        final int mNeedsCancel = 1;
        Label_0205: {
            switch (actionMasked) {
                default: {
                    break Label_0205;
                }
                case 2: {
                    break;
                }
                case 1:
                case 3: {
                    this.requestStop();
                    break Label_0205;
                }
                case 0: {
                    this.mNeedsCancel = (mNeedsCancel != 0);
                    this.mAlreadyDelayed = false;
                    break;
                }
            }
            this.mScroller.setTargetVelocity(this.computeTargetVelocity(0, motionEvent.getX(), view.getWidth(), this.mTarget.getWidth()), this.computeTargetVelocity(mNeedsCancel, motionEvent.getY(), view.getHeight(), this.mTarget.getHeight()));
            if (!this.mAnimating && this.shouldAnimate()) {
                this.startAnimating();
            }
        }
        if (this.mExclusive && this.mAnimating) {
            b = true;
        }
        return b;
    }
    
    public abstract void scrollTargetBy(final int p0, final int p1);
    
    public AutoScrollHelper setActivationDelay(final int mActivationDelay) {
        this.mActivationDelay = mActivationDelay;
        return this;
    }
    
    public AutoScrollHelper setEdgeType(final int mEdgeType) {
        this.mEdgeType = mEdgeType;
        return this;
    }
    
    public AutoScrollHelper setEnabled(final boolean mEnabled) {
        if (this.mEnabled && !mEnabled) {
            this.requestStop();
        }
        this.mEnabled = mEnabled;
        return this;
    }
    
    public AutoScrollHelper setExclusive(final boolean mExclusive) {
        this.mExclusive = mExclusive;
        return this;
    }
    
    public AutoScrollHelper setMaximumEdges(final float n, final float n2) {
        final float[] mMaximumEdges = this.mMaximumEdges;
        mMaximumEdges[0] = n;
        mMaximumEdges[1] = n2;
        return this;
    }
    
    public AutoScrollHelper setMaximumVelocity(final float n, final float n2) {
        final float[] mMaximumVelocity = this.mMaximumVelocity;
        final float n3 = 1000.0f;
        mMaximumVelocity[0] = n / n3;
        mMaximumVelocity[1] = n2 / n3;
        return this;
    }
    
    public AutoScrollHelper setMinimumVelocity(final float n, final float n2) {
        final float[] mMinimumVelocity = this.mMinimumVelocity;
        final float n3 = 1000.0f;
        mMinimumVelocity[0] = n / n3;
        mMinimumVelocity[1] = n2 / n3;
        return this;
    }
    
    public AutoScrollHelper setRampDownDuration(final int rampDownDuration) {
        this.mScroller.setRampDownDuration(rampDownDuration);
        return this;
    }
    
    public AutoScrollHelper setRampUpDuration(final int rampUpDuration) {
        this.mScroller.setRampUpDuration(rampUpDuration);
        return this;
    }
    
    public AutoScrollHelper setRelativeEdges(final float n, final float n2) {
        final float[] mRelativeEdges = this.mRelativeEdges;
        mRelativeEdges[0] = n;
        mRelativeEdges[1] = n2;
        return this;
    }
    
    public AutoScrollHelper setRelativeVelocity(final float n, final float n2) {
        final float[] mRelativeVelocity = this.mRelativeVelocity;
        final float n3 = 1000.0f;
        mRelativeVelocity[0] = n / n3;
        mRelativeVelocity[1] = n2 / n3;
        return this;
    }
    
    boolean shouldAnimate() {
        final AutoScrollHelper$ClampedScroller mScroller = this.mScroller;
        final int verticalDirection = mScroller.getVerticalDirection();
        final int horizontalDirection = mScroller.getHorizontalDirection();
        if (verticalDirection == 0 || this.canTargetScrollVertically(verticalDirection)) {
            if (horizontalDirection == 0 || !this.canTargetScrollHorizontally(horizontalDirection)) {
                return false;
            }
        }
        return true;
    }
}
