// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.support.v4.view.VelocityTrackerCompat;
import android.util.Log;
import android.support.v4.view.ViewCompat;
import java.util.Arrays;
import android.view.ViewConfiguration;
import android.content.Context;
import android.view.VelocityTracker;
import android.view.ViewGroup;
import android.view.View;
import android.view.animation.Interpolator;

public class ViewDragHelper
{
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = 255;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator;
    private int mActivePointerId;
    private final ViewDragHelper$Callback mCallback;
    private View mCapturedView;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private ScrollerCompat mScroller;
    private final Runnable mSetIdleRunnable;
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;
    
    static {
        sInterpolator = (Interpolator)new ViewDragHelper$1();
    }
    
    private ViewDragHelper(final Context context, final ViewGroup mParentView, final ViewDragHelper$Callback mCallback) {
        this.mActivePointerId = -1;
        this.mSetIdleRunnable = new ViewDragHelper$2(this);
        if (mParentView == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (mCallback != null) {
            this.mParentView = mParentView;
            this.mCallback = mCallback;
            final ViewConfiguration value = ViewConfiguration.get(context);
            this.mEdgeSize = (int)(20.0f * context.getResources().getDisplayMetrics().density + 0.5f);
            this.mTouchSlop = value.getScaledTouchSlop();
            this.mMaxVelocity = value.getScaledMaximumFlingVelocity();
            this.mMinVelocity = value.getScaledMinimumFlingVelocity();
            this.mScroller = ScrollerCompat.create(context, ViewDragHelper.sInterpolator);
            return;
        }
        throw new IllegalArgumentException("Callback may not be null");
    }
    
    private boolean checkNewEdgeDrag(final float n, final float n2, final int n3, final int n4) {
        final float abs = Math.abs(n);
        final float abs2 = Math.abs(n2);
        final int n5 = this.mInitialEdgesTouched[n3] & n4;
        boolean b = false;
        if (n5 == n4 && (this.mTrackingEdges & n4) != 0x0 && (this.mEdgeDragsLocked[n3] & n4) != n4 && (this.mEdgeDragsInProgress[n3] & n4) != n4) {
            final int mTouchSlop = this.mTouchSlop;
            if (abs > mTouchSlop || abs2 > mTouchSlop) {
                if (abs < 0.5f * abs2 && this.mCallback.onEdgeLock(n4)) {
                    final int[] mEdgeDragsLocked = this.mEdgeDragsLocked;
                    mEdgeDragsLocked[n3] |= n4;
                    return false;
                }
                if ((this.mEdgeDragsInProgress[n3] & n4) == 0x0 && abs > this.mTouchSlop) {
                    b = true;
                }
                return b;
            }
        }
        return false;
    }
    
    private boolean checkTouchSlop(final View view, final float n, final float n2) {
        boolean b = false;
        if (view == null) {
            return false;
        }
        final boolean b2 = this.mCallback.getViewHorizontalDragRange(view) > 0;
        final boolean b3 = this.mCallback.getViewVerticalDragRange(view) > 0;
        if (b2 && b3) {
            final float n3 = n * n + n2 * n2;
            final int mTouchSlop = this.mTouchSlop;
            if (n3 > mTouchSlop * mTouchSlop) {
                b = true;
            }
            return b;
        }
        if (b2) {
            if (Math.abs(n) > this.mTouchSlop) {
                b = true;
            }
            return b;
        }
        if (b3) {
            if (Math.abs(n2) > this.mTouchSlop) {
                b = true;
            }
            return b;
        }
        return false;
    }
    
    private float clampMag(final float n, final float n2, final float n3) {
        final float abs = Math.abs(n);
        if (abs < n2) {
            return 0.0f;
        }
        if (abs > n3) {
            float n4;
            if (n > 0.0f) {
                n4 = n3;
            }
            else {
                n4 = -n3;
            }
            return n4;
        }
        return n;
    }
    
    private int clampMag(final int n, final int n2, final int n3) {
        final int abs = Math.abs(n);
        if (abs < n2) {
            return 0;
        }
        if (abs > n3) {
            int n4;
            if (n > 0) {
                n4 = n3;
            }
            else {
                n4 = -n3;
            }
            return n4;
        }
        return n;
    }
    
    private void clearMotionHistory() {
        final float[] mInitialMotionX = this.mInitialMotionX;
        if (mInitialMotionX == null) {
            return;
        }
        Arrays.fill(mInitialMotionX, 0.0f);
        Arrays.fill(this.mInitialMotionY, 0.0f);
        Arrays.fill(this.mLastMotionX, 0.0f);
        Arrays.fill(this.mLastMotionY, 0.0f);
        Arrays.fill(this.mInitialEdgesTouched, 0);
        Arrays.fill(this.mEdgeDragsInProgress, 0);
        Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }
    
    private void clearMotionHistory(final int n) {
        if (this.mInitialMotionX != null && this.isPointerDown(n)) {
            this.mInitialMotionX[n] = 0.0f;
            this.mInitialMotionY[n] = 0.0f;
            this.mLastMotionX[n] = 0.0f;
            this.mLastMotionY[n] = 0.0f;
            this.mInitialEdgesTouched[n] = 0;
            this.mEdgeDragsInProgress[n] = 0;
            this.mEdgeDragsLocked[n] = 0;
            this.mPointersDown &= ~(1 << n);
        }
    }
    
    private int computeAxisDuration(final int n, int abs, final int n2) {
        if (n == 0) {
            return 0;
        }
        final int width = this.mParentView.getWidth();
        final int n3 = width / 2;
        final float n4 = Math.abs(n) / width;
        final float n5 = 1.0f;
        final float n6 = n3 + n3 * this.distanceInfluenceForSnapDuration(Math.min(n5, n4));
        abs = Math.abs(abs);
        int n7;
        if (abs > 0) {
            n7 = Math.round(Math.abs(n6 / abs) * 1000.0f) * 4;
        }
        else {
            n7 = (int)((n5 + Math.abs(n) / n2) * 256.0f);
        }
        return Math.min(n7, 600);
    }
    
    private int computeSettleDuration(final View view, final int n, final int n2, final int n3, final int n4) {
        final int clampMag = this.clampMag(n3, (int)this.mMinVelocity, (int)this.mMaxVelocity);
        final int clampMag2 = this.clampMag(n4, (int)this.mMinVelocity, (int)this.mMaxVelocity);
        final int abs = Math.abs(n);
        final int abs2 = Math.abs(n2);
        final int abs3 = Math.abs(clampMag);
        final int abs4 = Math.abs(clampMag2);
        final int n5 = abs3 + abs4;
        final int n6 = abs + abs2;
        float n7;
        float n8;
        if (clampMag != 0) {
            n7 = abs3;
            n8 = n5;
        }
        else {
            n7 = abs;
            n8 = n6;
        }
        final float n9 = n7 / n8;
        float n10;
        float n11;
        if (clampMag2 != 0) {
            n10 = abs4;
            n11 = n5;
        }
        else {
            n10 = abs2;
            n11 = n6;
        }
        return (int)(this.computeAxisDuration(n, clampMag, this.mCallback.getViewHorizontalDragRange(view)) * n9 + this.computeAxisDuration(n2, clampMag2, this.mCallback.getViewVerticalDragRange(view)) * (n10 / n11));
    }
    
    public static ViewDragHelper create(final ViewGroup viewGroup, final float n, final ViewDragHelper$Callback viewDragHelper$Callback) {
        final ViewDragHelper create = create(viewGroup, viewDragHelper$Callback);
        create.mTouchSlop *= (int)(1.0f / n);
        return create;
    }
    
    public static ViewDragHelper create(final ViewGroup viewGroup, final ViewDragHelper$Callback viewDragHelper$Callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, viewDragHelper$Callback);
    }
    
    private void dispatchViewReleased(final float n, final float n2) {
        final boolean mReleaseInProgress = true;
        this.mReleaseInProgress = mReleaseInProgress;
        this.mCallback.onViewReleased(this.mCapturedView, n, n2);
        this.mReleaseInProgress = false;
        if (this.mDragState == (mReleaseInProgress ? 1 : 0)) {
            this.setDragState(0);
        }
    }
    
    private float distanceInfluenceForSnapDuration(final float n) {
        final double n2 = n - 0.5f;
        Double.isNaN(n2);
        return (float)Math.sin((float)(n2 * 0.4712389167638204));
    }
    
    private void dragTo(final int n, final int n2, final int n3, final int n4) {
        int clampViewPositionHorizontal = n;
        int clampViewPositionVertical = n2;
        final int left = this.mCapturedView.getLeft();
        final int top = this.mCapturedView.getTop();
        if (n3 != 0) {
            clampViewPositionHorizontal = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, n, n3);
            ViewCompat.offsetLeftAndRight(this.mCapturedView, clampViewPositionHorizontal - left);
        }
        if (n4 != 0) {
            clampViewPositionVertical = this.mCallback.clampViewPositionVertical(this.mCapturedView, n2, n4);
            ViewCompat.offsetTopAndBottom(this.mCapturedView, clampViewPositionVertical - top);
        }
        if (n3 != 0 || n4 != 0) {
            this.mCallback.onViewPositionChanged(this.mCapturedView, clampViewPositionHorizontal, clampViewPositionVertical, clampViewPositionHorizontal - left, clampViewPositionVertical - top);
        }
    }
    
    private void ensureMotionHistorySizeForId(final int n) {
        final float[] mInitialMotionX = this.mInitialMotionX;
        if (mInitialMotionX == null || mInitialMotionX.length <= n) {
            final float[] mInitialMotionX2 = new float[n + 1];
            final float[] mInitialMotionY = new float[n + 1];
            final float[] mLastMotionX = new float[n + 1];
            final float[] mLastMotionY = new float[n + 1];
            final int[] mInitialEdgesTouched = new int[n + 1];
            final int[] mEdgeDragsInProgress = new int[n + 1];
            final int[] mEdgeDragsLocked = new int[n + 1];
            final float[] mInitialMotionX3 = this.mInitialMotionX;
            if (mInitialMotionX3 != null) {
                System.arraycopy(mInitialMotionX3, 0, mInitialMotionX2, 0, mInitialMotionX3.length);
                final float[] mInitialMotionY2 = this.mInitialMotionY;
                System.arraycopy(mInitialMotionY2, 0, mInitialMotionY, 0, mInitialMotionY2.length);
                final float[] mLastMotionX2 = this.mLastMotionX;
                System.arraycopy(mLastMotionX2, 0, mLastMotionX, 0, mLastMotionX2.length);
                final float[] mLastMotionY2 = this.mLastMotionY;
                System.arraycopy(mLastMotionY2, 0, mLastMotionY, 0, mLastMotionY2.length);
                final int[] mInitialEdgesTouched2 = this.mInitialEdgesTouched;
                System.arraycopy(mInitialEdgesTouched2, 0, mInitialEdgesTouched, 0, mInitialEdgesTouched2.length);
                final int[] mEdgeDragsInProgress2 = this.mEdgeDragsInProgress;
                System.arraycopy(mEdgeDragsInProgress2, 0, mEdgeDragsInProgress, 0, mEdgeDragsInProgress2.length);
                final int[] mEdgeDragsLocked2 = this.mEdgeDragsLocked;
                System.arraycopy(mEdgeDragsLocked2, 0, mEdgeDragsLocked, 0, mEdgeDragsLocked2.length);
            }
            this.mInitialMotionX = mInitialMotionX2;
            this.mInitialMotionY = mInitialMotionY;
            this.mLastMotionX = mLastMotionX;
            this.mLastMotionY = mLastMotionY;
            this.mInitialEdgesTouched = mInitialEdgesTouched;
            this.mEdgeDragsInProgress = mEdgeDragsInProgress;
            this.mEdgeDragsLocked = mEdgeDragsLocked;
        }
    }
    
    private boolean forceSettleCapturedViewAt(final int n, final int n2, final int n3, final int n4) {
        final int left = this.mCapturedView.getLeft();
        final int top = this.mCapturedView.getTop();
        final int n5 = n - left;
        final int n6 = n2 - top;
        if (n5 == 0 && n6 == 0) {
            this.mScroller.abortAnimation();
            this.setDragState(0);
            return false;
        }
        this.mScroller.startScroll(left, top, n5, n6, this.computeSettleDuration(this.mCapturedView, n5, n6, n3, n4));
        this.setDragState(2);
        return true;
    }
    
    private int getEdgesTouched(final int n, final int n2) {
        int n3 = 0;
        if (n < this.mParentView.getLeft() + this.mEdgeSize) {
            n3 = ((false | true) ? 1 : 0);
        }
        if (n2 < this.mParentView.getTop() + this.mEdgeSize) {
            n3 |= 0x4;
        }
        if (n > this.mParentView.getRight() - this.mEdgeSize) {
            n3 |= 0x2;
        }
        if (n2 > this.mParentView.getBottom() - this.mEdgeSize) {
            n3 |= 0x8;
        }
        return n3;
    }
    
    private boolean isValidPointerForActionMove(final int n) {
        if (!this.isPointerDown(n)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Ignoring pointerId=");
            sb.append(n);
            sb.append(" because ACTION_DOWN was not received ");
            sb.append("for this pointer before ACTION_MOVE. It likely happened because ");
            sb.append(" ViewDragHelper did not receive all the events in the event stream.");
            Log.e("ViewDragHelper", sb.toString());
            return false;
        }
        return true;
    }
    
    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        this.dispatchViewReleased(this.clampMag(VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), this.clampMag(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }
    
    private void reportNewEdgeDrags(final float n, final float n2, final int n3) {
        int n4 = 0;
        if (this.checkNewEdgeDrag(n, n2, n3, 1)) {
            n4 = ((false | true) ? 1 : 0);
        }
        if (this.checkNewEdgeDrag(n2, n, n3, 4)) {
            n4 |= 0x4;
        }
        if (this.checkNewEdgeDrag(n, n2, n3, 2)) {
            n4 |= 0x2;
        }
        if (this.checkNewEdgeDrag(n2, n, n3, 8)) {
            n4 |= 0x8;
        }
        if (n4 != 0) {
            final int[] mEdgeDragsInProgress = this.mEdgeDragsInProgress;
            mEdgeDragsInProgress[n3] |= n4;
            this.mCallback.onEdgeDragStarted(n4, n3);
        }
    }
    
    private void saveInitialMotion(final float n, final float n2, final int n3) {
        this.ensureMotionHistorySizeForId(n3);
        this.mInitialMotionX[n3] = (this.mLastMotionX[n3] = n);
        this.mInitialMotionY[n3] = (this.mLastMotionY[n3] = n2);
        this.mInitialEdgesTouched[n3] = this.getEdgesTouched((int)n, (int)n2);
        this.mPointersDown |= 1 << n3;
    }
    
    private void saveLastMotion(final MotionEvent motionEvent) {
        for (int pointerCount = motionEvent.getPointerCount(), i = 0; i < pointerCount; ++i) {
            final int pointerId = motionEvent.getPointerId(i);
            if (this.isValidPointerForActionMove(pointerId)) {
                final float x = motionEvent.getX(i);
                final float y = motionEvent.getY(i);
                this.mLastMotionX[pointerId] = x;
                this.mLastMotionY[pointerId] = y;
            }
        }
    }
    
    public void abort() {
        this.cancel();
        if (this.mDragState == 2) {
            final int currX = this.mScroller.getCurrX();
            final int currY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            final int currX2 = this.mScroller.getCurrX();
            final int currY2 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        this.setDragState(0);
    }
    
    protected boolean canScroll(final View view, final boolean b, final int n, final int n2, final int n3, final int n4) {
        final boolean b2 = view instanceof ViewGroup;
        boolean b3 = true;
        if (b2) {
            final ViewGroup viewGroup = (ViewGroup)view;
            final int scrollX = view.getScrollX();
            final int scrollY = view.getScrollY();
            for (int i = viewGroup.getChildCount() - 1; i >= 0; --i) {
                final View child = viewGroup.getChildAt(i);
                if (n3 + scrollX >= child.getLeft() && n3 + scrollX < child.getRight()) {
                    if (n4 + scrollY >= child.getTop() && n4 + scrollY < child.getBottom()) {
                        if (this.canScroll(child, true, n, n2, n3 + scrollX - child.getLeft(), n4 + scrollY - child.getTop())) {
                            return b3;
                        }
                    }
                }
            }
        }
        if (b) {
            if (!ViewCompat.canScrollHorizontally(view, -n)) {
                if (!ViewCompat.canScrollVertically(view, -n2)) {
                    return false;
                }
            }
            return b3;
        }
        b3 = false;
        return b3;
    }
    
    public void cancel() {
        this.mActivePointerId = -1;
        this.clearMotionHistory();
        final VelocityTracker mVelocityTracker = this.mVelocityTracker;
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
    
    public void captureChildView(final View mCapturedView, final int mActivePointerId) {
        if (mCapturedView.getParent() == this.mParentView) {
            this.mCapturedView = mCapturedView;
            this.mActivePointerId = mActivePointerId;
            this.mCallback.onViewCaptured(mCapturedView, mActivePointerId);
            this.setDragState(1);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
        sb.append(this.mParentView);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public boolean checkTouchSlop(final int n) {
        for (int length = this.mInitialMotionX.length, i = 0; i < length; ++i) {
            if (this.checkTouchSlop(n, i)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkTouchSlop(final int n, final int n2) {
        final boolean pointerDown = this.isPointerDown(n2);
        boolean b = false;
        if (!pointerDown) {
            return false;
        }
        final boolean b2 = (n & 0x1) == 0x1;
        final boolean b3 = (n & 0x2) == 0x2;
        final float n3 = this.mLastMotionX[n2] - this.mInitialMotionX[n2];
        final float n4 = this.mLastMotionY[n2] - this.mInitialMotionY[n2];
        if (b2 && b3) {
            final float n5 = n3 * n3 + n4 * n4;
            final int mTouchSlop = this.mTouchSlop;
            if (n5 > mTouchSlop * mTouchSlop) {
                b = true;
            }
            return b;
        }
        if (b2) {
            if (Math.abs(n3) > this.mTouchSlop) {
                b = true;
            }
            return b;
        }
        if (b3) {
            if (Math.abs(n4) > this.mTouchSlop) {
                b = true;
            }
            return b;
        }
        return false;
    }
    
    public boolean continueSettling(final boolean b) {
        final int mDragState = this.mDragState;
        boolean b2 = false;
        final int n = 2;
        if (mDragState == n) {
            int computeScrollOffset = this.mScroller.computeScrollOffset() ? 1 : 0;
            final int currX = this.mScroller.getCurrX();
            final int currY = this.mScroller.getCurrY();
            final int n2 = currX - this.mCapturedView.getLeft();
            final int n3 = currY - this.mCapturedView.getTop();
            if (n2 != 0) {
                ViewCompat.offsetLeftAndRight(this.mCapturedView, n2);
            }
            if (n3 != 0) {
                ViewCompat.offsetTopAndBottom(this.mCapturedView, n3);
            }
            if (n2 != 0 || n3 != 0) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY, n2, n3);
            }
            if (computeScrollOffset != 0 && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                computeScrollOffset = 0;
            }
            if (computeScrollOffset == 0) {
                if (b) {
                    this.mParentView.post(this.mSetIdleRunnable);
                }
                else {
                    this.setDragState(0);
                }
            }
        }
        if (this.mDragState == n) {
            b2 = true;
        }
        return b2;
    }
    
    public View findTopChildUnder(final int n, final int n2) {
        for (int i = this.mParentView.getChildCount() - 1; i >= 0; --i) {
            final View child = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(i));
            if (n >= child.getLeft() && n < child.getRight() && (n2 >= child.getTop() && n2 < child.getBottom())) {
                return child;
            }
        }
        return null;
    }
    
    public void flingCapturedView(final int n, final int n2, final int n3, final int n4) {
        if (this.mReleaseInProgress) {
            this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), n, n3, n2, n4);
            this.setDragState(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }
    
    public int getActivePointerId() {
        return this.mActivePointerId;
    }
    
    public View getCapturedView() {
        return this.mCapturedView;
    }
    
    public int getEdgeSize() {
        return this.mEdgeSize;
    }
    
    public float getMinVelocity() {
        return this.mMinVelocity;
    }
    
    public int getTouchSlop() {
        return this.mTouchSlop;
    }
    
    public int getViewDragState() {
        return this.mDragState;
    }
    
    public boolean isCapturedViewUnder(final int n, final int n2) {
        return this.isViewUnder(this.mCapturedView, n, n2);
    }
    
    public boolean isEdgeTouched(final int n) {
        for (int length = this.mInitialEdgesTouched.length, i = 0; i < length; ++i) {
            if (this.isEdgeTouched(n, i)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isEdgeTouched(final int n, final int n2) {
        return this.isPointerDown(n2) && (this.mInitialEdgesTouched[n2] & n) != 0x0;
    }
    
    public boolean isPointerDown(final int n) {
        final int mPointersDown = this.mPointersDown;
        int n2 = 1;
        if ((mPointersDown & n2 << n) == 0x0) {
            n2 = 0;
        }
        return n2 != 0;
    }
    
    public boolean isViewUnder(final View view, final int n, final int n2) {
        boolean b = false;
        if (view == null) {
            return false;
        }
        if (n >= view.getLeft()) {
            if (n < view.getRight()) {
                if (n2 >= view.getTop()) {
                    if (n2 < view.getBottom()) {
                        b = true;
                    }
                }
            }
        }
        return b;
    }
    
    public void processTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        final int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            this.cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        final boolean b = true;
        switch (actionMasked) {
            case 6: {
                final int pointerId = motionEvent.getPointerId(actionIndex);
                if (this.mDragState == (b ? 1 : 0) && pointerId == this.mActivePointerId) {
                    int mActivePointerId = -1;
                    for (int pointerCount = motionEvent.getPointerCount(), i = 0; i < pointerCount; ++i) {
                        final int pointerId2 = motionEvent.getPointerId(i);
                        if (pointerId2 != this.mActivePointerId) {
                            final View topChildUnder = this.findTopChildUnder((int)motionEvent.getX(i), (int)motionEvent.getY(i));
                            final View mCapturedView = this.mCapturedView;
                            if (topChildUnder == mCapturedView) {
                                if (this.tryCaptureViewForDrag(mCapturedView, pointerId2)) {
                                    mActivePointerId = this.mActivePointerId;
                                    break;
                                }
                            }
                        }
                    }
                    if (mActivePointerId == -1) {
                        this.releaseViewForPointerUp();
                    }
                }
                this.clearMotionHistory(pointerId);
                break;
            }
            case 5: {
                final int pointerId3 = motionEvent.getPointerId(actionIndex);
                final float x = motionEvent.getX(actionIndex);
                final float y = motionEvent.getY(actionIndex);
                this.saveInitialMotion(x, y, pointerId3);
                if (this.mDragState == 0) {
                    this.tryCaptureViewForDrag(this.findTopChildUnder((int)x, (int)y), pointerId3);
                    final int n = this.mInitialEdgesTouched[pointerId3];
                    final int mTrackingEdges = this.mTrackingEdges;
                    if ((n & mTrackingEdges) != 0x0) {
                        this.mCallback.onEdgeTouched(mTrackingEdges & n, pointerId3);
                    }
                }
                else if (this.isCapturedViewUnder((int)x, (int)y)) {
                    this.tryCaptureViewForDrag(this.mCapturedView, pointerId3);
                }
                break;
            }
            case 3: {
                if (this.mDragState == (b ? 1 : 0)) {
                    this.dispatchViewReleased(0.0f, 0.0f);
                }
                this.cancel();
                break;
            }
            case 2: {
                if (this.mDragState != (b ? 1 : 0)) {
                    for (int pointerCount2 = motionEvent.getPointerCount(), j = 0; j < pointerCount2; ++j) {
                        final int pointerId4 = motionEvent.getPointerId(j);
                        if (this.isValidPointerForActionMove(pointerId4)) {
                            final float x2 = motionEvent.getX(j);
                            final float y2 = motionEvent.getY(j);
                            final float n2 = x2 - this.mInitialMotionX[pointerId4];
                            final float n3 = y2 - this.mInitialMotionY[pointerId4];
                            this.reportNewEdgeDrags(n2, n3, pointerId4);
                            if (this.mDragState == (b ? 1 : 0)) {
                                break;
                            }
                            final View topChildUnder2 = this.findTopChildUnder((int)x2, (int)y2);
                            if (this.checkTouchSlop(topChildUnder2, n2, n3)) {
                                if (this.tryCaptureViewForDrag(topChildUnder2, pointerId4)) {
                                    break;
                                }
                            }
                        }
                    }
                    this.saveLastMotion(motionEvent);
                    break;
                }
                if (!this.isValidPointerForActionMove(this.mActivePointerId)) {
                    break;
                }
                final int pointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                final float x3 = motionEvent.getX(pointerIndex);
                final float y3 = motionEvent.getY(pointerIndex);
                final float[] mLastMotionX = this.mLastMotionX;
                final int mActivePointerId2 = this.mActivePointerId;
                final int n4 = (int)(x3 - mLastMotionX[mActivePointerId2]);
                final int n5 = (int)(y3 - this.mLastMotionY[mActivePointerId2]);
                this.dragTo(this.mCapturedView.getLeft() + n4, this.mCapturedView.getTop() + n5, n4, n5);
                this.saveLastMotion(motionEvent);
                break;
            }
            case 1: {
                if (this.mDragState == (b ? 1 : 0)) {
                    this.releaseViewForPointerUp();
                }
                this.cancel();
                break;
            }
            case 0: {
                final float x4 = motionEvent.getX();
                final float y4 = motionEvent.getY();
                final int pointerId5 = motionEvent.getPointerId(0);
                final View topChildUnder3 = this.findTopChildUnder((int)x4, (int)y4);
                this.saveInitialMotion(x4, y4, pointerId5);
                this.tryCaptureViewForDrag(topChildUnder3, pointerId5);
                final int n6 = this.mInitialEdgesTouched[pointerId5];
                final int mTrackingEdges2 = this.mTrackingEdges;
                if ((n6 & mTrackingEdges2) != 0x0) {
                    this.mCallback.onEdgeTouched(mTrackingEdges2 & n6, pointerId5);
                    break;
                }
                break;
            }
        }
    }
    
    void setDragState(final int mDragState) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState != mDragState) {
            this.mDragState = mDragState;
            this.mCallback.onViewDragStateChanged(mDragState);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }
    
    public void setEdgeTrackingEnabled(final int mTrackingEdges) {
        this.mTrackingEdges = mTrackingEdges;
    }
    
    public void setMinVelocity(final float mMinVelocity) {
        this.mMinVelocity = mMinVelocity;
    }
    
    public boolean settleCapturedViewAt(final int n, final int n2) {
        if (this.mReleaseInProgress) {
            return this.forceSettleCapturedViewAt(n, n2, (int)VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int)VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    
    public boolean shouldInterceptTouchEvent(final MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            this.cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        final int n = 2;
        Label_1032: {
            switch (actionMasked) {
                case 6: {
                    this.clearMotionHistory(motionEvent.getPointerId(actionIndex));
                    break;
                }
                case 5: {
                    final int pointerId = motionEvent.getPointerId(actionIndex);
                    final float x = motionEvent.getX(actionIndex);
                    final float y = motionEvent.getY(actionIndex);
                    this.saveInitialMotion(x, y, pointerId);
                    final int mDragState = this.mDragState;
                    if (mDragState == 0) {
                        final int n2 = this.mInitialEdgesTouched[pointerId];
                        final int mTrackingEdges = this.mTrackingEdges;
                        if ((n2 & mTrackingEdges) != 0x0) {
                            this.mCallback.onEdgeTouched(mTrackingEdges & n2, pointerId);
                        }
                    }
                    else if (mDragState == n) {
                        final View topChildUnder = this.findTopChildUnder((int)x, (int)y);
                        if (topChildUnder == this.mCapturedView) {
                            this.tryCaptureViewForDrag(topChildUnder, pointerId);
                        }
                    }
                    break;
                }
                case 2: {
                    if (this.mInitialMotionX == null) {
                        break;
                    }
                    if (this.mInitialMotionY == null) {
                        break;
                    }
                    while (true) {
                        int n6;
                        int n7;
                        int n9;
                        for (int pointerCount = motionEvent.getPointerCount(), i = 0; i < pointerCount; ++i, actionMasked = n6, actionIndex = n7, pointerCount = n9) {
                            final int pointerId2 = motionEvent.getPointerId(i);
                            if (this.isValidPointerForActionMove(pointerId2)) {
                                final float x2 = motionEvent.getX(i);
                                final float y2 = motionEvent.getY(i);
                                final float n3 = x2 - this.mInitialMotionX[pointerId2];
                                final float n4 = y2 - this.mInitialMotionY[pointerId2];
                                final View topChildUnder2 = this.findTopChildUnder((int)x2, (int)y2);
                                final boolean b = topChildUnder2 != null && this.checkTouchSlop(topChildUnder2, n3, n4);
                                if (b) {
                                    final int left = topChildUnder2.getLeft();
                                    final int n5 = (int)n3 + left;
                                    final ViewDragHelper$Callback mCallback = this.mCallback;
                                    n6 = actionMasked;
                                    final int clampViewPositionHorizontal = mCallback.clampViewPositionHorizontal(topChildUnder2, n5, (int)n3);
                                    final int top = topChildUnder2.getTop();
                                    n7 = actionIndex;
                                    final int n8 = (int)n4 + top;
                                    n9 = pointerCount;
                                    final int clampViewPositionVertical = this.mCallback.clampViewPositionVertical(topChildUnder2, n8, (int)n4);
                                    final int viewHorizontalDragRange = this.mCallback.getViewHorizontalDragRange(topChildUnder2);
                                    final int viewVerticalDragRange = this.mCallback.getViewVerticalDragRange(topChildUnder2);
                                    if (viewHorizontalDragRange == 0 || (viewHorizontalDragRange > 0 && clampViewPositionHorizontal == left)) {
                                        if (viewVerticalDragRange == 0) {
                                            break;
                                        }
                                        if (viewVerticalDragRange > 0 && clampViewPositionVertical == top) {
                                            break;
                                        }
                                    }
                                }
                                else {
                                    n6 = actionMasked;
                                    n7 = actionIndex;
                                    n9 = pointerCount;
                                }
                                this.reportNewEdgeDrags(n3, n4, pointerId2);
                                if (this.mDragState != 1) {
                                    if (!b || !this.tryCaptureViewForDrag(topChildUnder2, pointerId2)) {
                                        continue;
                                    }
                                }
                                this.saveLastMotion(motionEvent);
                                break Label_1032;
                            }
                            n6 = actionMasked;
                            n7 = actionIndex;
                            n9 = pointerCount;
                        }
                        continue;
                    }
                }
                case 1:
                case 3: {
                    this.cancel();
                    break;
                }
                case 0: {
                    final float x3 = motionEvent.getX();
                    final float y3 = motionEvent.getY();
                    final int pointerId3 = motionEvent.getPointerId(0);
                    this.saveInitialMotion(x3, y3, pointerId3);
                    final View topChildUnder3 = this.findTopChildUnder((int)x3, (int)y3);
                    if (topChildUnder3 == this.mCapturedView && this.mDragState == n) {
                        this.tryCaptureViewForDrag(topChildUnder3, pointerId3);
                    }
                    final int n10 = this.mInitialEdgesTouched[pointerId3];
                    final int mTrackingEdges2 = this.mTrackingEdges;
                    if ((n10 & mTrackingEdges2) != 0x0) {
                        this.mCallback.onEdgeTouched(mTrackingEdges2 & n10, pointerId3);
                        break;
                    }
                    break;
                }
            }
        }
        final int mDragState2 = this.mDragState;
        boolean b2 = true;
        if (mDragState2 != (b2 ? 1 : 0)) {
            b2 = false;
        }
        return b2;
    }
    
    public boolean smoothSlideViewTo(final View mCapturedView, final int n, final int n2) {
        this.mCapturedView = mCapturedView;
        this.mActivePointerId = -1;
        final boolean forceSettleCapturedView = this.forceSettleCapturedViewAt(n, n2, 0, 0);
        if (!forceSettleCapturedView && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return forceSettleCapturedView;
    }
    
    boolean tryCaptureViewForDrag(final View view, final int mActivePointerId) {
        final View mCapturedView = this.mCapturedView;
        final boolean b = true;
        if (view == mCapturedView && this.mActivePointerId == mActivePointerId) {
            return b;
        }
        if (view != null && this.mCallback.tryCaptureView(view, mActivePointerId)) {
            this.captureChildView(view, this.mActivePointerId = mActivePointerId);
            return b;
        }
        return false;
    }
}
