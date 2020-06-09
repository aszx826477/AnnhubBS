// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.support.v4.content.ContextCompat;
import android.view.View$MeasureSpec;
import android.util.Log;
import android.widget.AbsListView;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.os.Build$VERSION;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import android.support.v4.view.ViewCompat;
import android.view.ViewConfiguration;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation$AnimationListener;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.NestedScrollingChildHelper;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Animation;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingParent;
import android.view.ViewGroup;

public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild
{
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    private static final int CIRCLE_BG_LIGHT = 16448250;
    static final int CIRCLE_DIAMETER = 40;
    static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = 255;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS;
    private static final String LOG_TAG;
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private SwipeRefreshLayout$OnChildScrollUpCallback mChildScrollUpCallback;
    private int mCircleDiameter;
    CircleImageView mCircleView;
    private int mCircleViewIndex;
    int mCurrentTargetOffsetTop;
    private final DecelerateInterpolator mDecelerateInterpolator;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    SwipeRefreshLayout$OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final NestedScrollingChildHelper mNestedScrollingChildHelper;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    boolean mNotify;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    MaterialProgressDrawable mProgress;
    private Animation$AnimationListener mRefreshListener;
    boolean mRefreshing;
    private boolean mReturningToStart;
    boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    int mSpinnerOffsetEnd;
    float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    boolean mUsingCustomStart;
    
    static {
        LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
        LAYOUT_ATTRS = new int[] { 16842766 };
    }
    
    public SwipeRefreshLayout(final Context context) {
        this(context, null);
    }
    
    public SwipeRefreshLayout(final Context context, final AttributeSet set) {
        super(context, set);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        final int n = 2;
        this.mParentScrollConsumed = new int[n];
        this.mParentOffsetInWindow = new int[n];
        final int n2 = -1;
        this.mActivePointerId = n2;
        this.mCircleViewIndex = n2;
        this.mRefreshListener = (Animation$AnimationListener)new SwipeRefreshLayout$1(this);
        this.mAnimateToCorrectPosition = new SwipeRefreshLayout$6(this);
        this.mAnimateToStartPosition = new SwipeRefreshLayout$7(this);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = this.getResources().getInteger(17694721);
        this.setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.0f);
        final DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        this.mCircleDiameter = (int)(displayMetrics.density * 40.0f);
        this.createProgressView();
        final boolean nestedScrollingEnabled = true;
        ViewCompat.setChildrenDrawingOrderEnabled(this, nestedScrollingEnabled);
        this.mSpinnerOffsetEnd = (int)(displayMetrics.density * 64.0f);
        this.mTotalDragDistance = this.mSpinnerOffsetEnd;
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.mNestedScrollingChildHelper = new NestedScrollingChildHelper((View)this);
        this.setNestedScrollingEnabled(nestedScrollingEnabled);
        final int n3 = -this.mCircleDiameter;
        this.mCurrentTargetOffsetTop = n3;
        this.mOriginalOffsetTop = n3;
        this.moveToStart(1.0f);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, SwipeRefreshLayout.LAYOUT_ATTRS);
        this.setEnabled(obtainStyledAttributes.getBoolean(0, nestedScrollingEnabled));
        obtainStyledAttributes.recycle();
    }
    
    private void animateOffsetToCorrectPosition(final int mFrom, final Animation$AnimationListener animationListener) {
        this.mFrom = mFrom;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200L);
        this.mAnimateToCorrectPosition.setInterpolator((Interpolator)this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }
    
    private void animateOffsetToStartPosition(final int mFrom, final Animation$AnimationListener animationListener) {
        if (this.mScale) {
            this.startScaleDownReturnToStartAnimation(mFrom, animationListener);
        }
        else {
            this.mFrom = mFrom;
            this.mAnimateToStartPosition.reset();
            this.mAnimateToStartPosition.setDuration(200L);
            this.mAnimateToStartPosition.setInterpolator((Interpolator)this.mDecelerateInterpolator);
            if (animationListener != null) {
                this.mCircleView.setAnimationListener(animationListener);
            }
            this.mCircleView.clearAnimation();
            this.mCircleView.startAnimation(this.mAnimateToStartPosition);
        }
    }
    
    private void createProgressView() {
        final Context context = this.getContext();
        final int backgroundColor = -328966;
        this.mCircleView = new CircleImageView(context, backgroundColor);
        (this.mProgress = new MaterialProgressDrawable(this.getContext(), (View)this)).setBackgroundColor(backgroundColor);
        this.mCircleView.setImageDrawable((Drawable)this.mProgress);
        this.mCircleView.setVisibility(8);
        this.addView((View)this.mCircleView);
    }
    
    private void ensureTarget() {
        if (this.mTarget == null) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                final View child = this.getChildAt(i);
                if (!child.equals(this.mCircleView)) {
                    this.mTarget = child;
                    break;
                }
            }
        }
    }
    
    private void finishSpinner(final float n) {
        if (n > this.mTotalDragDistance) {
            final boolean b = true;
            this.setRefreshing(b, b);
        }
        else {
            this.mRefreshing = false;
            this.mProgress.setStartEndTrim(0.0f, 0.0f);
            Object o = null;
            if (!this.mScale) {
                o = new SwipeRefreshLayout$5(this);
            }
            this.animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, (Animation$AnimationListener)o);
            this.mProgress.showArrow(false);
        }
    }
    
    private boolean isAlphaUsedForScale() {
        return Build$VERSION.SDK_INT < 11;
    }
    
    private boolean isAnimationRunning(final Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }
    
    private void moveSpinner(final float n) {
        this.mProgress.showArrow(true);
        final float abs = Math.abs(n / this.mTotalDragDistance);
        final float n2 = 1.0f;
        final float min = Math.min(n2, abs);
        final double n3 = min;
        Double.isNaN(n3);
        final float n4 = (float)Math.max(n3 - 0.4, 0.0) * 5.0f / 3.0f;
        final float n5 = Math.abs(n) - this.mTotalDragDistance;
        int mSpinnerOffsetEnd;
        if (this.mUsingCustomStart) {
            mSpinnerOffsetEnd = this.mSpinnerOffsetEnd - this.mOriginalOffsetTop;
        }
        else {
            mSpinnerOffsetEnd = this.mSpinnerOffsetEnd;
        }
        final float n6 = mSpinnerOffsetEnd;
        final float n7 = 2.0f;
        final float max = Math.max(0.0f, Math.min(n5, n6 * n7) / n6);
        final float n8 = 4.0f;
        final double n9 = max / n8;
        final double pow = Math.pow(max / n8, 2.0);
        Double.isNaN(n9);
        final float n10 = (float)(n9 - pow) * n7;
        final int n11 = this.mOriginalOffsetTop + (int)(n6 * min + n6 * n10 * n7);
        if (this.mCircleView.getVisibility() != 0) {
            this.mCircleView.setVisibility(0);
        }
        if (!this.mScale) {
            ViewCompat.setScaleX((View)this.mCircleView, n2);
            ViewCompat.setScaleY((View)this.mCircleView, n2);
        }
        if (this.mScale) {
            this.setAnimationProgress(Math.min(n2, n / this.mTotalDragDistance));
        }
        if (n < this.mTotalDragDistance) {
            if (this.mProgress.getAlpha() > 76) {
                if (!this.isAnimationRunning(this.mAlphaStartAnimation)) {
                    this.startProgressAlphaStartAnimation();
                }
            }
        }
        else if (this.mProgress.getAlpha() < 255 && !this.isAnimationRunning(this.mAlphaMaxAnimation)) {
            this.startProgressAlphaMaxAnimation();
        }
        final float n12 = 0.8f;
        this.mProgress.setStartEndTrim(0.0f, Math.min(n12, n4 * n12));
        this.mProgress.setArrowScale(Math.min(n2, n4));
        this.mProgress.setProgressRotation((0.4f * n4 - 0.25f + n7 * n10) * 0.5f);
        this.setTargetOffsetTopAndBottom(n11 - this.mCurrentTargetOffsetTop, true);
    }
    
    private void onSecondaryPointerUp(final MotionEvent motionEvent) {
        final int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int n;
            if (actionIndex == 0) {
                n = 1;
            }
            else {
                n = 0;
            }
            this.mActivePointerId = motionEvent.getPointerId(n);
        }
    }
    
    private void setColorViewAlpha(final int n) {
        this.mCircleView.getBackground().setAlpha(n);
        this.mProgress.setAlpha(n);
    }
    
    private void setRefreshing(final boolean mRefreshing, final boolean mNotify) {
        if (this.mRefreshing != mRefreshing) {
            this.mNotify = mNotify;
            this.ensureTarget();
            this.mRefreshing = mRefreshing;
            if (this.mRefreshing) {
                this.animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
            }
            else {
                this.startScaleDownAnimation(this.mRefreshListener);
            }
        }
    }
    
    private Animation startAlphaAnimation(final int n, final int n2) {
        if (this.mScale && this.isAlphaUsedForScale()) {
            return null;
        }
        final SwipeRefreshLayout$4 swipeRefreshLayout$4 = new SwipeRefreshLayout$4(this, n, n2);
        swipeRefreshLayout$4.setDuration(300L);
        this.mCircleView.setAnimationListener(null);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation((Animation)swipeRefreshLayout$4);
        return swipeRefreshLayout$4;
    }
    
    private void startDragging(final float n) {
        final float mInitialDownY = this.mInitialDownY;
        final float n2 = n - mInitialDownY;
        final int mTouchSlop = this.mTouchSlop;
        if (n2 > mTouchSlop && !this.mIsBeingDragged) {
            this.mInitialMotionY = mInitialDownY + mTouchSlop;
            this.mIsBeingDragged = true;
            this.mProgress.setAlpha(76);
        }
    }
    
    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = this.startAlphaAnimation(this.mProgress.getAlpha(), 255);
    }
    
    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = this.startAlphaAnimation(this.mProgress.getAlpha(), 76);
    }
    
    private void startScaleDownReturnToStartAnimation(final int mFrom, final Animation$AnimationListener animationListener) {
        this.mFrom = mFrom;
        if (this.isAlphaUsedForScale()) {
            this.mStartingScale = this.mProgress.getAlpha();
        }
        else {
            this.mStartingScale = ViewCompat.getScaleX((View)this.mCircleView);
        }
        (this.mScaleDownToStartAnimation = new SwipeRefreshLayout$8(this)).setDuration(150L);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }
    
    private void startScaleUpAnimation(final Animation$AnimationListener animationListener) {
        this.mCircleView.setVisibility(0);
        if (Build$VERSION.SDK_INT >= 11) {
            this.mProgress.setAlpha(255);
        }
        (this.mScaleAnimation = new SwipeRefreshLayout$2(this)).setDuration((long)this.mMediumAnimationDuration);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }
    
    public boolean canChildScrollUp() {
        final SwipeRefreshLayout$OnChildScrollUpCallback mChildScrollUpCallback = this.mChildScrollUpCallback;
        if (mChildScrollUpCallback != null) {
            return mChildScrollUpCallback.canChildScrollUp(this, this.mTarget);
        }
        final int sdk_INT = Build$VERSION.SDK_INT;
        final int n = 14;
        final int n2 = -1;
        if (sdk_INT >= n) {
            return ViewCompat.canScrollVertically(this.mTarget, n2);
        }
        final View mTarget = this.mTarget;
        final boolean b = mTarget instanceof AbsListView;
        boolean b2 = true;
        if (b) {
            final AbsListView absListView = (AbsListView)mTarget;
            if (absListView.getChildCount() <= 0 || (absListView.getFirstVisiblePosition() <= 0 && absListView.getChildAt(0).getTop() >= absListView.getPaddingTop())) {
                b2 = false;
            }
            return b2;
        }
        if (!ViewCompat.canScrollVertically(mTarget, n2)) {
            if (this.mTarget.getScrollY() <= 0) {
                b2 = false;
            }
        }
        return b2;
    }
    
    public boolean dispatchNestedFling(final float n, final float n2, final boolean b) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(n, n2, b);
    }
    
    public boolean dispatchNestedPreFling(final float n, final float n2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(n, n2);
    }
    
    public boolean dispatchNestedPreScroll(final int n, final int n2, final int[] array, final int[] array2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(n, n2, array, array2);
    }
    
    public boolean dispatchNestedScroll(final int n, final int n2, final int n3, final int n4, final int[] array) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(n, n2, n3, n4, array);
    }
    
    protected int getChildDrawingOrder(final int n, final int n2) {
        final int mCircleViewIndex = this.mCircleViewIndex;
        if (mCircleViewIndex < 0) {
            return n2;
        }
        if (n2 == n - 1) {
            return mCircleViewIndex;
        }
        if (n2 >= mCircleViewIndex) {
            return n2 + 1;
        }
        return n2;
    }
    
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }
    
    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }
    
    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }
    
    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }
    
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
    }
    
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }
    
    public boolean isRefreshing() {
        return this.mRefreshing;
    }
    
    void moveToStart(final float n) {
        final int mFrom = this.mFrom;
        this.setTargetOffsetTopAndBottom(mFrom + (int)((this.mOriginalOffsetTop - mFrom) * n) - this.mCircleView.getTop(), false);
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.reset();
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        this.ensureTarget();
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (this.isEnabled() && !this.mReturningToStart && !this.canChildScrollUp() && !this.mRefreshing && !this.mNestedScrollInProgress) {
            if (actionMasked != 6) {
                final int mActivePointerId = -1;
                switch (actionMasked) {
                    case 2: {
                        final int mActivePointerId2 = this.mActivePointerId;
                        if (mActivePointerId2 == mActivePointerId) {
                            Log.e(SwipeRefreshLayout.LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
                            return false;
                        }
                        final int pointerIndex = motionEvent.findPointerIndex(mActivePointerId2);
                        if (pointerIndex < 0) {
                            return false;
                        }
                        this.startDragging(motionEvent.getY(pointerIndex));
                        break;
                    }
                    case 1:
                    case 3: {
                        this.mIsBeingDragged = false;
                        this.mActivePointerId = mActivePointerId;
                        break;
                    }
                    case 0: {
                        this.setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop(), true);
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        this.mIsBeingDragged = false;
                        final int pointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (pointerIndex2 < 0) {
                            return false;
                        }
                        this.mInitialDownY = motionEvent.getY(pointerIndex2);
                        break;
                    }
                }
            }
            else {
                this.onSecondaryPointerUp(motionEvent);
            }
            return this.mIsBeingDragged;
        }
        return false;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final int measuredWidth = this.getMeasuredWidth();
        final int measuredHeight = this.getMeasuredHeight();
        if (this.getChildCount() == 0) {
            return;
        }
        if (this.mTarget == null) {
            this.ensureTarget();
        }
        if (this.mTarget == null) {
            return;
        }
        final View mTarget = this.mTarget;
        final int paddingLeft = this.getPaddingLeft();
        final int paddingTop = this.getPaddingTop();
        mTarget.layout(paddingLeft, paddingTop, paddingLeft + (measuredWidth - this.getPaddingLeft() - this.getPaddingRight()), paddingTop + (measuredHeight - this.getPaddingTop() - this.getPaddingBottom()));
        final int measuredWidth2 = this.mCircleView.getMeasuredWidth();
        final int measuredHeight2 = this.mCircleView.getMeasuredHeight();
        final CircleImageView mCircleView = this.mCircleView;
        final int n5 = measuredWidth / 2 - measuredWidth2 / 2;
        final int mCurrentTargetOffsetTop = this.mCurrentTargetOffsetTop;
        mCircleView.layout(n5, mCurrentTargetOffsetTop, measuredWidth / 2 + measuredWidth2 / 2, mCurrentTargetOffsetTop + measuredHeight2);
    }
    
    public void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if (this.mTarget == null) {
            this.ensureTarget();
        }
        final View mTarget = this.mTarget;
        if (mTarget == null) {
            return;
        }
        final int n3 = this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
        final int n4 = 1073741824;
        mTarget.measure(View$MeasureSpec.makeMeasureSpec(n3, n4), View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), n4));
        this.mCircleView.measure(View$MeasureSpec.makeMeasureSpec(this.mCircleDiameter, n4), View$MeasureSpec.makeMeasureSpec(this.mCircleDiameter, n4));
        this.mCircleViewIndex = -1;
        for (int i = 0; i < this.getChildCount(); ++i) {
            if (this.getChildAt(i) == this.mCircleView) {
                this.mCircleViewIndex = i;
                break;
            }
        }
    }
    
    public boolean onNestedFling(final View view, final float n, final float n2, final boolean b) {
        return this.dispatchNestedFling(n, n2, b);
    }
    
    public boolean onNestedPreFling(final View view, final float n, final float n2) {
        return this.dispatchNestedPreFling(n, n2);
    }
    
    public void onNestedPreScroll(final View view, final int n, final int n2, final int[] array) {
        final int n3 = 1;
        if (n2 > 0) {
            final float mTotalUnconsumed = this.mTotalUnconsumed;
            if (mTotalUnconsumed > 0.0f) {
                if (n2 > mTotalUnconsumed) {
                    array[n3] = n2 - (int)mTotalUnconsumed;
                    this.mTotalUnconsumed = 0.0f;
                }
                else {
                    this.mTotalUnconsumed = mTotalUnconsumed - n2;
                    array[n3] = n2;
                }
                this.moveSpinner(this.mTotalUnconsumed);
            }
        }
        if (this.mUsingCustomStart && n2 > 0 && this.mTotalUnconsumed == 0.0f) {
            if (Math.abs(n2 - array[n3]) > 0) {
                this.mCircleView.setVisibility(8);
            }
        }
        final int[] mParentScrollConsumed = this.mParentScrollConsumed;
        if (this.dispatchNestedPreScroll(n - array[0], n2 - array[n3], mParentScrollConsumed, null)) {
            array[0] += mParentScrollConsumed[0];
            array[n3] += mParentScrollConsumed[n3];
        }
    }
    
    public void onNestedScroll(final View view, final int n, final int n2, final int n3, final int n4) {
        this.dispatchNestedScroll(n, n2, n3, n4, this.mParentOffsetInWindow);
        final int n5 = this.mParentOffsetInWindow[1] + n4;
        if (n5 < 0 && !this.canChildScrollUp()) {
            this.moveSpinner(this.mTotalUnconsumed += Math.abs(n5));
        }
    }
    
    public void onNestedScrollAccepted(final View view, final View view2, final int n) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, n);
        this.startNestedScroll(n & 0x2);
        this.mTotalUnconsumed = 0.0f;
        this.mNestedScrollInProgress = true;
    }
    
    public boolean onStartNestedScroll(final View view, final View view2, final int n) {
        return this.isEnabled() && !this.mReturningToStart && !this.mRefreshing && (n & 0x2) != 0x0;
    }
    
    public void onStopNestedScroll(final View view) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view);
        this.mNestedScrollInProgress = false;
        final float mTotalUnconsumed = this.mTotalUnconsumed;
        if (mTotalUnconsumed > 0.0f) {
            this.finishSpinner(mTotalUnconsumed);
            this.mTotalUnconsumed = 0.0f;
        }
        this.stopNestedScroll();
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (this.isEnabled() && !this.mReturningToStart && !this.canChildScrollUp() && !this.mRefreshing && !this.mNestedScrollInProgress) {
            final float n = 0.5f;
            switch (actionMasked) {
                case 6: {
                    this.onSecondaryPointerUp(motionEvent);
                    break;
                }
                case 5: {
                    final int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    if (actionIndex < 0) {
                        Log.e(SwipeRefreshLayout.LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                    break;
                }
                case 3: {
                    return false;
                }
                case 2: {
                    final int pointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (pointerIndex < 0) {
                        Log.e(SwipeRefreshLayout.LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    final float y = motionEvent.getY(pointerIndex);
                    this.startDragging(y);
                    if (!this.mIsBeingDragged) {
                        break;
                    }
                    final float n2 = (y - this.mInitialMotionY) * n;
                    if (n2 > 0.0f) {
                        this.moveSpinner(n2);
                        break;
                    }
                    return false;
                }
                case 1: {
                    final int pointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (pointerIndex2 < 0) {
                        Log.e(SwipeRefreshLayout.LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
                        return false;
                    }
                    if (this.mIsBeingDragged) {
                        final float n3 = (motionEvent.getY(pointerIndex2) - this.mInitialMotionY) * n;
                        this.mIsBeingDragged = false;
                        this.finishSpinner(n3);
                    }
                    this.mActivePointerId = -1;
                    return false;
                }
                case 0: {
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    this.mIsBeingDragged = false;
                    break;
                }
            }
            return true;
        }
        return false;
    }
    
    public void requestDisallowInterceptTouchEvent(final boolean b) {
        if (Build$VERSION.SDK_INT >= 21 || this.mTarget instanceof AbsListView) {
            final View mTarget = this.mTarget;
            if (mTarget == null || ViewCompat.isNestedScrollingEnabled(mTarget)) {
                super.requestDisallowInterceptTouchEvent(b);
            }
        }
    }
    
    void reset() {
        this.mCircleView.clearAnimation();
        this.mProgress.stop();
        this.mCircleView.setVisibility(8);
        this.setColorViewAlpha(255);
        if (this.mScale) {
            this.setAnimationProgress(0.0f);
        }
        else {
            this.setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop, true);
        }
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }
    
    void setAnimationProgress(final float n) {
        if (this.isAlphaUsedForScale()) {
            this.setColorViewAlpha((int)(255.0f * n));
        }
        else {
            ViewCompat.setScaleX((View)this.mCircleView, n);
            ViewCompat.setScaleY((View)this.mCircleView, n);
        }
    }
    
    public void setColorScheme(final int... colorSchemeResources) {
        this.setColorSchemeResources(colorSchemeResources);
    }
    
    public void setColorSchemeColors(final int... colorSchemeColors) {
        this.ensureTarget();
        this.mProgress.setColorSchemeColors(colorSchemeColors);
    }
    
    public void setColorSchemeResources(final int... array) {
        final Context context = this.getContext();
        final int[] colorSchemeColors = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            colorSchemeColors[i] = ContextCompat.getColor(context, array[i]);
        }
        this.setColorSchemeColors(colorSchemeColors);
    }
    
    public void setDistanceToTriggerSync(final int n) {
        this.mTotalDragDistance = n;
    }
    
    public void setEnabled(final boolean enabled) {
        super.setEnabled(enabled);
        if (!enabled) {
            this.reset();
        }
    }
    
    public void setNestedScrollingEnabled(final boolean nestedScrollingEnabled) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(nestedScrollingEnabled);
    }
    
    public void setOnChildScrollUpCallback(final SwipeRefreshLayout$OnChildScrollUpCallback mChildScrollUpCallback) {
        this.mChildScrollUpCallback = mChildScrollUpCallback;
    }
    
    public void setOnRefreshListener(final SwipeRefreshLayout$OnRefreshListener mListener) {
        this.mListener = mListener;
    }
    
    public void setProgressBackgroundColor(final int progressBackgroundColorSchemeResource) {
        this.setProgressBackgroundColorSchemeResource(progressBackgroundColorSchemeResource);
    }
    
    public void setProgressBackgroundColorSchemeColor(final int n) {
        this.mCircleView.setBackgroundColor(n);
        this.mProgress.setBackgroundColor(n);
    }
    
    public void setProgressBackgroundColorSchemeResource(final int n) {
        this.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(this.getContext(), n));
    }
    
    public void setProgressViewEndTarget(final boolean mScale, final int mSpinnerOffsetEnd) {
        this.mSpinnerOffsetEnd = mSpinnerOffsetEnd;
        this.mScale = mScale;
        this.mCircleView.invalidate();
    }
    
    public void setProgressViewOffset(final boolean mScale, final int mOriginalOffsetTop, final int mSpinnerOffsetEnd) {
        this.mScale = mScale;
        this.mOriginalOffsetTop = mOriginalOffsetTop;
        this.mSpinnerOffsetEnd = mSpinnerOffsetEnd;
        this.mUsingCustomStart = true;
        this.reset();
        this.mRefreshing = false;
    }
    
    public void setRefreshing(final boolean mRefreshing) {
        if (mRefreshing && this.mRefreshing != mRefreshing) {
            this.mRefreshing = mRefreshing;
            int mSpinnerOffsetEnd;
            if (!this.mUsingCustomStart) {
                mSpinnerOffsetEnd = this.mSpinnerOffsetEnd + this.mOriginalOffsetTop;
            }
            else {
                mSpinnerOffsetEnd = this.mSpinnerOffsetEnd;
            }
            this.setTargetOffsetTopAndBottom(mSpinnerOffsetEnd - this.mCurrentTargetOffsetTop, true);
            this.mNotify = false;
            this.startScaleUpAnimation(this.mRefreshListener);
        }
        else {
            this.setRefreshing(mRefreshing, false);
        }
    }
    
    public void setSize(final int n) {
        if (n != 0 && n != 1) {
            return;
        }
        final DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        if (n == 0) {
            this.mCircleDiameter = (int)(displayMetrics.density * 56.0f);
        }
        else {
            this.mCircleDiameter = (int)(displayMetrics.density * 40.0f);
        }
        this.mCircleView.setImageDrawable((Drawable)null);
        this.mProgress.updateSizes(n);
        this.mCircleView.setImageDrawable((Drawable)this.mProgress);
    }
    
    void setTargetOffsetTopAndBottom(final int n, final boolean b) {
        this.mCircleView.bringToFront();
        ViewCompat.offsetTopAndBottom((View)this.mCircleView, n);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
        if (b && Build$VERSION.SDK_INT < 11) {
            this.invalidate();
        }
    }
    
    public boolean startNestedScroll(final int n) {
        return this.mNestedScrollingChildHelper.startNestedScroll(n);
    }
    
    void startScaleDownAnimation(final Animation$AnimationListener animationListener) {
        (this.mScaleDownAnimation = new SwipeRefreshLayout$3(this)).setDuration(150L);
        this.mCircleView.setAnimationListener(animationListener);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }
    
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
    }
}
