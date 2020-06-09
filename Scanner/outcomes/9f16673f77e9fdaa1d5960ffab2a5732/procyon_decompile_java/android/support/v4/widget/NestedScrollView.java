// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.animation.AnimationUtils;
import android.support.v4.view.VelocityTrackerCompat;
import android.os.Parcelable;
import android.widget.FrameLayout$LayoutParams;
import android.util.Log;
import android.support.v4.view.MotionEventCompat;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.View$MeasureSpec;
import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.FocusFinder;
import android.view.ViewGroup$LayoutParams;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.util.TypedValue;
import java.util.ArrayList;
import android.content.res.TypedArray;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.view.ViewGroup;
import android.util.AttributeSet;
import android.content.Context;
import android.view.VelocityTracker;
import android.graphics.Rect;
import android.support.v4.view.NestedScrollingParentHelper;
import android.view.View;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingParent;
import android.widget.FrameLayout;

public class NestedScrollView extends FrameLayout implements NestedScrollingParent, NestedScrollingChild, ScrollingView
{
    private static final NestedScrollView$AccessibilityDelegate ACCESSIBILITY_DELEGATE;
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final int INVALID_POINTER = 255;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final int[] SCROLLVIEW_STYLEABLE;
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;
    private EdgeEffectCompat mEdgeGlowBottom;
    private EdgeEffectCompat mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private NestedScrollView$OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private NestedScrollView$SavedState mSavedState;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private ScrollerCompat mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;
    
    static {
        ACCESSIBILITY_DELEGATE = new NestedScrollView$AccessibilityDelegate();
        SCROLLVIEW_STYLEABLE = new int[] { 16843130 };
    }
    
    public NestedScrollView(final Context context) {
        this(context, null);
    }
    
    public NestedScrollView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public NestedScrollView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mTempRect = new Rect();
        final boolean nestedScrollingEnabled = true;
        this.mIsLayoutDirty = nestedScrollingEnabled;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = nestedScrollingEnabled;
        this.mActivePointerId = -1;
        final int n2 = 2;
        this.mScrollOffset = new int[n2];
        this.mScrollConsumed = new int[n2];
        this.initScrollView();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, NestedScrollView.SCROLLVIEW_STYLEABLE, n, 0);
        this.setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.mParentHelper = new NestedScrollingParentHelper((ViewGroup)this);
        this.mChildHelper = new NestedScrollingChildHelper((View)this);
        this.setNestedScrollingEnabled(nestedScrollingEnabled);
        ViewCompat.setAccessibilityDelegate((View)this, NestedScrollView.ACCESSIBILITY_DELEGATE);
    }
    
    private boolean canScroll() {
        boolean b = false;
        final View child = this.getChildAt(0);
        if (child != null) {
            if (this.getHeight() < this.getPaddingTop() + child.getHeight() + this.getPaddingBottom()) {
                b = true;
            }
            return b;
        }
        return false;
    }
    
    private static int clamp(final int n, final int n2, final int n3) {
        if (n2 >= n3 || n < 0) {
            return 0;
        }
        if (n2 + n > n3) {
            return n3 - n2;
        }
        return n;
    }
    
    private void doScrollY(final int n) {
        if (n != 0) {
            if (this.mSmoothScrollingEnabled) {
                this.smoothScrollBy(0, n);
            }
            else {
                this.scrollBy(0, n);
            }
        }
    }
    
    private void endDrag() {
        this.mIsBeingDragged = false;
        this.recycleVelocityTracker();
        this.stopNestedScroll();
        final EdgeEffectCompat mEdgeGlowTop = this.mEdgeGlowTop;
        if (mEdgeGlowTop != null) {
            mEdgeGlowTop.onRelease();
            this.mEdgeGlowBottom.onRelease();
        }
    }
    
    private void ensureGlows() {
        if (this.getOverScrollMode() != 2) {
            if (this.mEdgeGlowTop == null) {
                final Context context = this.getContext();
                this.mEdgeGlowTop = new EdgeEffectCompat(context);
                this.mEdgeGlowBottom = new EdgeEffectCompat(context);
            }
        }
        else {
            this.mEdgeGlowTop = null;
            this.mEdgeGlowBottom = null;
        }
    }
    
    private View findFocusableViewInBounds(final boolean b, final int n, final int n2) {
        final ArrayList focusables = this.getFocusables(2);
        View view = null;
        int n3 = 0;
        for (int size = focusables.size(), i = 0; i < size; ++i) {
            final View view2 = focusables.get(i);
            final int top = view2.getTop();
            final int bottom = view2.getBottom();
            if (n < bottom && top < n2) {
                boolean b2 = false;
                final boolean b3 = n < top && bottom < n2;
                if (view == null) {
                    view = view2;
                    n3 = (b3 ? 1 : 0);
                }
                else {
                    Label_0167: {
                        if (!b || top >= view.getTop()) {
                            if (b) {
                                break Label_0167;
                            }
                            if (bottom <= view.getBottom()) {
                                break Label_0167;
                            }
                        }
                        b2 = true;
                    }
                    if (n3 != 0) {
                        if (b3 && b2) {
                            view = view2;
                        }
                    }
                    else if (b3) {
                        view = view2;
                        n3 = 1;
                    }
                    else if (b2) {
                        view = view2;
                    }
                }
            }
        }
        return view;
    }
    
    private void flingWithNestedDispatch(final int n) {
        final int scrollY = this.getScrollY();
        boolean b = false;
        Label_0043: {
            if (scrollY > 0 || n > 0) {
                if (scrollY < this.getScrollRange() || n < 0) {
                    b = true;
                    break Label_0043;
                }
            }
            b = false;
        }
        if (!this.dispatchNestedPreFling(0.0f, n)) {
            this.dispatchNestedFling(0.0f, n, b);
            if (b) {
                this.fling(n);
            }
        }
    }
    
    private float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor == 0.0f) {
            final TypedValue typedValue = new TypedValue();
            final Context context = this.getContext();
            if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.mVerticalScrollFactor;
    }
    
    private boolean inChild(final int n, final int n2) {
        final int childCount = this.getChildCount();
        boolean b = false;
        if (childCount > 0) {
            final int scrollY = this.getScrollY();
            final View child = this.getChildAt(0);
            if (n2 >= child.getTop() - scrollY) {
                if (n2 < child.getBottom() - scrollY) {
                    if (n >= child.getLeft()) {
                        if (n < child.getRight()) {
                            b = true;
                        }
                    }
                }
            }
            return b;
        }
        return false;
    }
    
    private void initOrResetVelocityTracker() {
        final VelocityTracker mVelocityTracker = this.mVelocityTracker;
        if (mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        else {
            mVelocityTracker.clear();
        }
    }
    
    private void initScrollView() {
        this.mScroller = ScrollerCompat.create(this.getContext(), null);
        this.setFocusable(true);
        this.setDescendantFocusability(262144);
        this.setWillNotDraw(false);
        final ViewConfiguration value = ViewConfiguration.get(this.getContext());
        this.mTouchSlop = value.getScaledTouchSlop();
        this.mMinimumVelocity = value.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = value.getScaledMaximumFlingVelocity();
    }
    
    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }
    
    private boolean isOffScreen(final View view) {
        return this.isWithinDeltaOfScreen(view, 0, this.getHeight()) ^ true;
    }
    
    private static boolean isViewDescendantOf(final View view, final View view2) {
        boolean b = true;
        if (view == view2) {
            return b;
        }
        final ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup) || !isViewDescendantOf((View)parent, view2)) {
            b = false;
        }
        return b;
    }
    
    private boolean isWithinDeltaOfScreen(final View view, final int n, final int n2) {
        view.getDrawingRect(this.mTempRect);
        this.offsetDescendantRectToMyCoords(view, this.mTempRect);
        return this.mTempRect.bottom + n >= this.getScrollY() && this.mTempRect.top - n <= this.getScrollY() + n2;
    }
    
    private void onSecondaryPointerUp(final MotionEvent motionEvent) {
        final int n = (motionEvent.getAction() & 0xFF00) >> 8;
        if (motionEvent.getPointerId(n) == this.mActivePointerId) {
            int n2;
            if (n == 0) {
                n2 = 1;
            }
            else {
                n2 = 0;
            }
            this.mLastMotionY = (int)motionEvent.getY(n2);
            this.mActivePointerId = motionEvent.getPointerId(n2);
            final VelocityTracker mVelocityTracker = this.mVelocityTracker;
            if (mVelocityTracker != null) {
                mVelocityTracker.clear();
            }
        }
    }
    
    private void recycleVelocityTracker() {
        final VelocityTracker mVelocityTracker = this.mVelocityTracker;
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
    
    private boolean scrollAndFocus(final int n, final int n2, final int n3) {
        boolean b = true;
        final int height = this.getHeight();
        final int scrollY = this.getScrollY();
        final int n4 = scrollY + height;
        final boolean b2 = n == 33;
        Object focusableViewInBounds = this.findFocusableViewInBounds(b2, n2, n3);
        if (focusableViewInBounds == null) {
            focusableViewInBounds = this;
        }
        if (n2 >= scrollY && n3 <= n4) {
            b = false;
        }
        else {
            int n5;
            if (b2) {
                n5 = n2 - scrollY;
            }
            else {
                n5 = n3 - n4;
            }
            this.doScrollY(n5);
        }
        if (focusableViewInBounds != this.findFocus()) {
            ((View)focusableViewInBounds).requestFocus(n);
        }
        return b;
    }
    
    private void scrollToChild(final View view) {
        view.getDrawingRect(this.mTempRect);
        this.offsetDescendantRectToMyCoords(view, this.mTempRect);
        final int computeScrollDeltaToGetChildRectOnScreen = this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            this.scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }
    
    private boolean scrollToChildRect(final Rect rect, final boolean b) {
        final int computeScrollDeltaToGetChildRectOnScreen = this.computeScrollDeltaToGetChildRectOnScreen(rect);
        final boolean b2 = computeScrollDeltaToGetChildRectOnScreen != 0;
        if (b2) {
            if (b) {
                this.scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
            else {
                this.smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return b2;
    }
    
    public void addView(final View view) {
        if (this.getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
    
    public void addView(final View view, final int n) {
        if (this.getChildCount() <= 0) {
            super.addView(view, n);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
    
    public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (this.getChildCount() <= 0) {
            super.addView(view, n, viewGroup$LayoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
    
    public void addView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (this.getChildCount() <= 0) {
            super.addView(view, viewGroup$LayoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
    
    public boolean arrowScroll(final int n) {
        Object focus = this.findFocus();
        if (focus == this) {
            focus = null;
        }
        final View nextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup)this, (View)focus, n);
        final int maxScrollAmount = this.getMaxScrollAmount();
        if (nextFocus != null && this.isWithinDeltaOfScreen(nextFocus, maxScrollAmount, this.getHeight())) {
            nextFocus.getDrawingRect(this.mTempRect);
            this.offsetDescendantRectToMyCoords(nextFocus, this.mTempRect);
            this.doScrollY(this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
            nextFocus.requestFocus(n);
        }
        else {
            int scrollY = maxScrollAmount;
            final int n2 = 33;
            final int n3 = 130;
            if (n == n2 && this.getScrollY() < maxScrollAmount) {
                scrollY = this.getScrollY();
            }
            else if (n == n3) {
                if (this.getChildCount() > 0) {
                    final int bottom = this.getChildAt(0).getBottom();
                    final int n4 = this.getScrollY() + this.getHeight() - this.getPaddingBottom();
                    if (bottom - n4 < maxScrollAmount) {
                        scrollY = bottom - n4;
                    }
                }
            }
            if (scrollY == 0) {
                return false;
            }
            int n5;
            if (n == n3) {
                n5 = scrollY;
            }
            else {
                n5 = -scrollY;
            }
            this.doScrollY(n5);
        }
        if (focus != null && ((View)focus).isFocused()) {
            if (this.isOffScreen((View)focus)) {
                final int descendantFocusability = this.getDescendantFocusability();
                this.setDescendantFocusability(131072);
                this.requestFocus();
                this.setDescendantFocusability(descendantFocusability);
            }
        }
        return true;
    }
    
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }
    
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }
    
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }
    
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            final int scrollX = this.getScrollX();
            final int scrollY = this.getScrollY();
            final int currX = this.mScroller.getCurrX();
            final int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                final int scrollRange = this.getScrollRange();
                final int overScrollMode = this.getOverScrollMode();
                int n = 1;
                if (overScrollMode != 0) {
                    if (overScrollMode != n || scrollRange <= 0) {
                        n = 0;
                    }
                }
                this.overScrollByCompat(currX - scrollX, currY - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (n != 0) {
                    this.ensureGlows();
                    if (currY <= 0 && scrollY > 0) {
                        this.mEdgeGlowTop.onAbsorb((int)this.mScroller.getCurrVelocity());
                    }
                    else if (currY >= scrollRange && scrollY < scrollRange) {
                        this.mEdgeGlowBottom.onAbsorb((int)this.mScroller.getCurrVelocity());
                    }
                }
            }
        }
    }
    
    protected int computeScrollDeltaToGetChildRectOnScreen(final Rect rect) {
        if (this.getChildCount() == 0) {
            return 0;
        }
        final int height = this.getHeight();
        int scrollY = this.getScrollY();
        int n = scrollY + height;
        final int verticalFadingEdgeLength = this.getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < this.getChildAt(0).getHeight()) {
            n -= verticalFadingEdgeLength;
        }
        int n2 = 0;
        if (rect.bottom > n && rect.top > scrollY) {
            int n3;
            if (rect.height() > height) {
                n3 = 0 + (rect.top - scrollY);
            }
            else {
                n3 = 0 + (rect.bottom - n);
            }
            n2 = Math.min(n3, this.getChildAt(0).getBottom() - n);
        }
        else if (rect.top < scrollY && rect.bottom < n) {
            int n4;
            if (rect.height() > height) {
                n4 = 0 - (n - rect.bottom);
            }
            else {
                n4 = 0 - (scrollY - rect.top);
            }
            n2 = Math.max(n4, -this.getScrollY());
        }
        return n2;
    }
    
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }
    
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }
    
    public int computeVerticalScrollRange() {
        final int childCount = this.getChildCount();
        final int n = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
        if (childCount == 0) {
            return n;
        }
        int bottom = this.getChildAt(0).getBottom();
        final int scrollY = this.getScrollY();
        final int max = Math.max(0, bottom - n);
        if (scrollY < 0) {
            bottom -= scrollY;
        }
        else if (scrollY > max) {
            bottom += scrollY - max;
        }
        return bottom;
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || this.executeKeyEvent(keyEvent);
    }
    
    public boolean dispatchNestedFling(final float n, final float n2, final boolean b) {
        return this.mChildHelper.dispatchNestedFling(n, n2, b);
    }
    
    public boolean dispatchNestedPreFling(final float n, final float n2) {
        return this.mChildHelper.dispatchNestedPreFling(n, n2);
    }
    
    public boolean dispatchNestedPreScroll(final int n, final int n2, final int[] array, final int[] array2) {
        return this.mChildHelper.dispatchNestedPreScroll(n, n2, array, array2);
    }
    
    public boolean dispatchNestedScroll(final int n, final int n2, final int n3, final int n4, final int[] array) {
        return this.mChildHelper.dispatchNestedScroll(n, n2, n3, n4, array);
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        if (this.mEdgeGlowTop != null) {
            final int scrollY = this.getScrollY();
            if (!this.mEdgeGlowTop.isFinished()) {
                final int save = canvas.save();
                final int n = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
                canvas.translate((float)this.getPaddingLeft(), (float)Math.min(0, scrollY));
                this.mEdgeGlowTop.setSize(n, this.getHeight());
                if (this.mEdgeGlowTop.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation((View)this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.mEdgeGlowBottom.isFinished()) {
                final int save2 = canvas.save();
                final int n2 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
                final int height = this.getHeight();
                canvas.translate((float)(-n2 + this.getPaddingLeft()), (float)(Math.max(this.getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float)n2, 0.0f);
                this.mEdgeGlowBottom.setSize(n2, height);
                if (this.mEdgeGlowBottom.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation((View)this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }
    
    public boolean executeKeyEvent(final KeyEvent keyEvent) {
        this.mTempRect.setEmpty();
        final boolean canScroll = this.canScroll();
        int n = 130;
        if (canScroll) {
            boolean b = false;
            if (keyEvent.getAction() == 0) {
                final int keyCode = keyEvent.getKeyCode();
                final int n2 = 62;
                final int n3 = 33;
                if (keyCode != n2) {
                    switch (keyCode) {
                        case 20: {
                            if (!keyEvent.isAltPressed()) {
                                b = this.arrowScroll(n);
                                break;
                            }
                            b = this.fullScroll(n);
                            break;
                        }
                        case 19: {
                            if (!keyEvent.isAltPressed()) {
                                b = this.arrowScroll(n3);
                                break;
                            }
                            b = this.fullScroll(n3);
                            break;
                        }
                    }
                }
                else {
                    if (keyEvent.isShiftPressed()) {
                        n = 33;
                    }
                    this.pageScroll(n);
                }
            }
            return b;
        }
        final boolean focused = this.isFocused();
        boolean b2 = false;
        if (focused && keyEvent.getKeyCode() != 4) {
            Object focus = this.findFocus();
            if (focus == this) {
                focus = null;
            }
            final View nextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup)this, (View)focus, n);
            if (nextFocus != null && nextFocus != this) {
                if (nextFocus.requestFocus(n)) {
                    b2 = true;
                }
            }
            return b2;
        }
        return false;
    }
    
    public void fling(final int n) {
        if (this.getChildCount() > 0) {
            final int n2 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
            this.mScroller.fling(this.getScrollX(), this.getScrollY(), 0, n, 0, 0, 0, Math.max(0, this.getChildAt(0).getHeight() - n2), 0, n2 / 2);
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    public boolean fullScroll(final int n) {
        final boolean b = n == 130;
        final int height = this.getHeight();
        final Rect mTempRect = this.mTempRect;
        mTempRect.top = 0;
        mTempRect.bottom = height;
        if (b) {
            final int childCount = this.getChildCount();
            if (childCount > 0) {
                this.mTempRect.bottom = this.getChildAt(childCount - 1).getBottom() + this.getPaddingBottom();
                final Rect mTempRect2 = this.mTempRect;
                mTempRect2.top = mTempRect2.bottom - height;
            }
        }
        return this.scrollAndFocus(n, this.mTempRect.top, this.mTempRect.bottom);
    }
    
    protected float getBottomFadingEdgeStrength() {
        if (this.getChildCount() == 0) {
            return 0.0f;
        }
        final int verticalFadingEdgeLength = this.getVerticalFadingEdgeLength();
        final int n = this.getChildAt(0).getBottom() - this.getScrollY() - (this.getHeight() - this.getPaddingBottom());
        if (n < verticalFadingEdgeLength) {
            return n / verticalFadingEdgeLength;
        }
        return 1.0f;
    }
    
    public int getMaxScrollAmount() {
        return (int)(this.getHeight() * 0.5f);
    }
    
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }
    
    int getScrollRange() {
        int max = 0;
        if (this.getChildCount() > 0) {
            max = Math.max(0, this.getChildAt(0).getHeight() - (this.getHeight() - this.getPaddingBottom() - this.getPaddingTop()));
        }
        return max;
    }
    
    protected float getTopFadingEdgeStrength() {
        if (this.getChildCount() == 0) {
            return 0.0f;
        }
        final int verticalFadingEdgeLength = this.getVerticalFadingEdgeLength();
        final int scrollY = this.getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }
    
    public boolean hasNestedScrollingParent() {
        return this.mChildHelper.hasNestedScrollingParent();
    }
    
    public boolean isFillViewport() {
        return this.mFillViewport;
    }
    
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }
    
    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }
    
    protected void measureChild(final View view, final int n, final int n2) {
        view.measure(getChildMeasureSpec(n, this.getPaddingLeft() + this.getPaddingRight(), view.getLayoutParams().width), View$MeasureSpec.makeMeasureSpec(0, 0));
    }
    
    protected void measureChildWithMargins(final View view, final int n, final int n2, final int n3, final int n4) {
        final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)view.getLayoutParams();
        view.measure(getChildMeasureSpec(n, this.getPaddingLeft() + this.getPaddingRight() + viewGroup$MarginLayoutParams.leftMargin + viewGroup$MarginLayoutParams.rightMargin + n2, viewGroup$MarginLayoutParams.width), View$MeasureSpec.makeMeasureSpec(viewGroup$MarginLayoutParams.topMargin + viewGroup$MarginLayoutParams.bottomMargin, 0));
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }
    
    public boolean onGenericMotionEvent(final MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 0x2) != 0x0) {
            if (motionEvent.getAction() == 8) {
                if (!this.mIsBeingDragged) {
                    final float axisValue = MotionEventCompat.getAxisValue(motionEvent, 9);
                    if (axisValue != 0.0f) {
                        final int n = (int)(this.getVerticalScrollFactorCompat() * axisValue);
                        final int scrollRange = this.getScrollRange();
                        final int scrollY = this.getScrollY();
                        int n2 = scrollY - n;
                        if (n2 < 0) {
                            n2 = 0;
                        }
                        else if (n2 > scrollRange) {
                            n2 = scrollRange;
                        }
                        if (n2 != scrollY) {
                            super.scrollTo(this.getScrollX(), n2);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int action = motionEvent.getAction();
        final int n = 2;
        final boolean mIsBeingDragged = true;
        if (action == n && this.mIsBeingDragged) {
            return mIsBeingDragged;
        }
        final int n2 = action & 0xFF;
        if (n2 != 6) {
            final int mActivePointerId = -1;
            switch (n2) {
                case 2: {
                    final int mActivePointerId2 = this.mActivePointerId;
                    if (mActivePointerId2 == mActivePointerId) {
                        break;
                    }
                    final int pointerIndex = motionEvent.findPointerIndex(mActivePointerId2);
                    if (pointerIndex == mActivePointerId) {
                        final String s = "NestedScrollView";
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Invalid pointerId=");
                        sb.append(mActivePointerId2);
                        sb.append(" in onInterceptTouchEvent");
                        Log.e(s, sb.toString());
                        break;
                    }
                    final int mLastMotionY = (int)motionEvent.getY(pointerIndex);
                    if (Math.abs(mLastMotionY - this.mLastMotionY) <= this.mTouchSlop) {
                        break;
                    }
                    if ((n & this.getNestedScrollAxes()) == 0x0) {
                        this.mIsBeingDragged = mIsBeingDragged;
                        this.mLastMotionY = mLastMotionY;
                        this.initVelocityTrackerIfNotExists();
                        this.mVelocityTracker.addMovement(motionEvent);
                        this.mNestedYOffset = 0;
                        final ViewParent parent = this.getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(mIsBeingDragged);
                        }
                        break;
                    }
                    break;
                }
                case 1:
                case 3: {
                    this.mIsBeingDragged = false;
                    this.mActivePointerId = mActivePointerId;
                    this.recycleVelocityTracker();
                    if (this.mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                        ViewCompat.postInvalidateOnAnimation((View)this);
                    }
                    this.stopNestedScroll();
                    break;
                }
                case 0: {
                    final int mLastMotionY2 = (int)motionEvent.getY();
                    if (!this.inChild((int)motionEvent.getX(), mLastMotionY2)) {
                        this.mIsBeingDragged = false;
                        this.recycleVelocityTracker();
                        break;
                    }
                    this.mLastMotionY = mLastMotionY2;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    this.initOrResetVelocityTracker();
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mScroller.computeScrollOffset();
                    this.mIsBeingDragged = (mIsBeingDragged ^ this.mScroller.isFinished());
                    this.startNestedScroll(n);
                    break;
                }
            }
        }
        else {
            this.onSecondaryPointerUp(motionEvent);
        }
        return this.mIsBeingDragged;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        this.mIsLayoutDirty = false;
        final View mChildToScrollTo = this.mChildToScrollTo;
        if (mChildToScrollTo != null && isViewDescendantOf(mChildToScrollTo, (View)this)) {
            this.scrollToChild(this.mChildToScrollTo);
        }
        this.mChildToScrollTo = null;
        if (!this.mIsLaidOut) {
            if (this.mSavedState != null) {
                this.scrollTo(this.getScrollX(), this.mSavedState.scrollPosition);
                this.mSavedState = null;
            }
            int measuredHeight;
            if (this.getChildCount() > 0) {
                measuredHeight = this.getChildAt(0).getMeasuredHeight();
            }
            else {
                measuredHeight = 0;
            }
            final int max = Math.max(0, measuredHeight - (n4 - n2 - this.getPaddingBottom() - this.getPaddingTop()));
            if (this.getScrollY() > max) {
                this.scrollTo(this.getScrollX(), max);
            }
            else if (this.getScrollY() < 0) {
                this.scrollTo(this.getScrollX(), 0);
            }
        }
        this.scrollTo(this.getScrollX(), this.getScrollY());
        this.mIsLaidOut = true;
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if (!this.mFillViewport) {
            return;
        }
        if (View$MeasureSpec.getMode(n2) == 0) {
            return;
        }
        if (this.getChildCount() > 0) {
            final View child = this.getChildAt(0);
            final int measuredHeight = this.getMeasuredHeight();
            if (child.getMeasuredHeight() < measuredHeight) {
                child.measure(getChildMeasureSpec(n, this.getPaddingLeft() + this.getPaddingRight(), ((FrameLayout$LayoutParams)child.getLayoutParams()).width), View$MeasureSpec.makeMeasureSpec(measuredHeight - this.getPaddingTop() - this.getPaddingBottom(), 1073741824));
            }
        }
    }
    
    public boolean onNestedFling(final View view, final float n, final float n2, final boolean b) {
        if (!b) {
            this.flingWithNestedDispatch((int)n2);
            return true;
        }
        return false;
    }
    
    public boolean onNestedPreFling(final View view, final float n, final float n2) {
        return this.dispatchNestedPreFling(n, n2);
    }
    
    public void onNestedPreScroll(final View view, final int n, final int n2, final int[] array) {
        this.dispatchNestedPreScroll(n, n2, array, null);
    }
    
    public void onNestedScroll(final View view, final int n, final int n2, final int n3, final int n4) {
        final int scrollY = this.getScrollY();
        this.scrollBy(0, n4);
        final int n5 = this.getScrollY() - scrollY;
        this.dispatchNestedScroll(0, n5, 0, n4 - n5, null);
    }
    
    public void onNestedScrollAccepted(final View view, final View view2, final int n) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, n);
        this.startNestedScroll(2);
    }
    
    protected void onOverScrolled(final int n, final int n2, final boolean b, final boolean b2) {
        super.scrollTo(n, n2);
    }
    
    protected boolean onRequestFocusInDescendants(int n, final Rect rect) {
        if (n == 2) {
            n = 130;
        }
        else if (n == 1) {
            n = 33;
        }
        View view;
        if (rect == null) {
            view = FocusFinder.getInstance().findNextFocus((ViewGroup)this, (View)null, n);
        }
        else {
            view = FocusFinder.getInstance().findNextFocusFromRect((ViewGroup)this, rect, n);
        }
        return view != null && !this.isOffScreen(view) && view.requestFocus(n, rect);
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof NestedScrollView$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final NestedScrollView$SavedState mSavedState = (NestedScrollView$SavedState)parcelable;
        super.onRestoreInstanceState(mSavedState.getSuperState());
        this.mSavedState = mSavedState;
        this.requestLayout();
    }
    
    protected Parcelable onSaveInstanceState() {
        final NestedScrollView$SavedState nestedScrollView$SavedState = new NestedScrollView$SavedState(super.onSaveInstanceState());
        nestedScrollView$SavedState.scrollPosition = this.getScrollY();
        return (Parcelable)nestedScrollView$SavedState;
    }
    
    protected void onScrollChanged(final int n, final int n2, final int n3, final int n4) {
        super.onScrollChanged(n, n2, n3, n4);
        final NestedScrollView$OnScrollChangeListener mOnScrollChangeListener = this.mOnScrollChangeListener;
        if (mOnScrollChangeListener != null) {
            mOnScrollChangeListener.onScrollChange(this, n, n2, n3, n4);
        }
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        final View focus = this.findFocus();
        if (focus != null && this != focus) {
            if (this.isWithinDeltaOfScreen(focus, 0, n4)) {
                focus.getDrawingRect(this.mTempRect);
                this.offsetDescendantRectToMyCoords(focus, this.mTempRect);
                this.doScrollY(this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
            }
        }
    }
    
    public boolean onStartNestedScroll(final View view, final View view2, final int n) {
        return (n & 0x2) != 0x0;
    }
    
    public void onStopNestedScroll(final View view) {
        this.mParentHelper.onStopNestedScroll(view);
        this.stopNestedScroll();
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        this.initVelocityTrackerIfNotExists();
        final MotionEvent obtain = MotionEvent.obtain(motionEvent);
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean b = false;
        if (actionMasked == 0) {
            this.mNestedYOffset = 0;
        }
        obtain.offsetLocation(0.0f, (float)this.mNestedYOffset);
        final int n = -1;
        final int mIsBeingDragged = 1;
        switch (actionMasked) {
            case 6: {
                this.onSecondaryPointerUp(motionEvent);
                this.mLastMotionY = (int)motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
                break;
            }
            case 5: {
                final int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mLastMotionY = (int)motionEvent.getY(actionIndex);
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                break;
            }
            case 3: {
                if (this.mIsBeingDragged && this.getChildCount() > 0) {
                    if (this.mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                        ViewCompat.postInvalidateOnAnimation((View)this);
                    }
                }
                this.mActivePointerId = n;
                this.endDrag();
                break;
            }
            case 2: {
                final int pointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (pointerIndex == n) {
                    final String s = "NestedScrollView";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Invalid pointerId=");
                    sb.append(this.mActivePointerId);
                    sb.append(" in onTouchEvent");
                    Log.e(s, sb.toString());
                    break;
                }
                final int n2 = (int)motionEvent.getY(pointerIndex);
                int n3 = this.mLastMotionY - n2;
                if (this.dispatchNestedPreScroll(0, n3, this.mScrollConsumed, this.mScrollOffset)) {
                    n3 -= this.mScrollConsumed[mIsBeingDragged];
                    obtain.offsetLocation(0.0f, (float)this.mScrollOffset[mIsBeingDragged]);
                    this.mNestedYOffset += this.mScrollOffset[mIsBeingDragged];
                }
                int n4;
                if (!this.mIsBeingDragged && Math.abs(n3) > this.mTouchSlop) {
                    final ViewParent parent = this.getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent((boolean)(mIsBeingDragged != 0));
                    }
                    this.mIsBeingDragged = (mIsBeingDragged != 0);
                    if (n3 > 0) {
                        n4 = n3 - this.mTouchSlop;
                    }
                    else {
                        n4 = n3 + this.mTouchSlop;
                    }
                }
                else {
                    n4 = n3;
                }
                if (this.mIsBeingDragged) {
                    this.mLastMotionY = n2 - this.mScrollOffset[mIsBeingDragged];
                    final int scrollY = this.getScrollY();
                    final int scrollRange = this.getScrollRange();
                    final int overScrollMode = this.getOverScrollMode();
                    if (overScrollMode == 0 || (overScrollMode == mIsBeingDragged && scrollRange > 0)) {
                        b = true;
                    }
                    final boolean b2 = b;
                    final int scrollY2 = this.getScrollY();
                    final boolean b3 = true;
                    final int n5 = n4;
                    final int n6 = scrollRange;
                    final int n7 = n4;
                    final int n8 = pointerIndex;
                    if (this.overScrollByCompat(0, n5, 0, scrollY2, 0, scrollRange, 0, 0, b3)) {
                        if (!this.hasNestedScrollingParent()) {
                            this.mVelocityTracker.clear();
                        }
                    }
                    final int n9 = this.getScrollY() - scrollY;
                    if (this.dispatchNestedScroll(0, n9, 0, n7 - n9, this.mScrollOffset)) {
                        final int mLastMotionY = this.mLastMotionY;
                        final int[] mScrollOffset = this.mScrollOffset;
                        this.mLastMotionY = mLastMotionY - mScrollOffset[mIsBeingDragged];
                        obtain.offsetLocation(0.0f, (float)mScrollOffset[mIsBeingDragged]);
                        this.mNestedYOffset += this.mScrollOffset[mIsBeingDragged];
                    }
                    else if (b2) {
                        this.ensureGlows();
                        final int n10 = scrollY + n7;
                        if (n10 < 0) {
                            this.mEdgeGlowTop.onPull(n7 / this.getHeight(), motionEvent.getX(n8) / this.getWidth());
                            if (!this.mEdgeGlowBottom.isFinished()) {
                                this.mEdgeGlowBottom.onRelease();
                            }
                        }
                        else if (n10 > n6) {
                            this.mEdgeGlowBottom.onPull(n7 / this.getHeight(), 1.0f - motionEvent.getX(n8) / this.getWidth());
                            if (!this.mEdgeGlowTop.isFinished()) {
                                this.mEdgeGlowTop.onRelease();
                            }
                        }
                        final EdgeEffectCompat mEdgeGlowTop = this.mEdgeGlowTop;
                        if (mEdgeGlowTop != null) {
                            if (!mEdgeGlowTop.isFinished() || !this.mEdgeGlowBottom.isFinished()) {
                                ViewCompat.postInvalidateOnAnimation((View)this);
                            }
                        }
                    }
                    break;
                }
                break;
            }
            case 1: {
                if (this.mIsBeingDragged) {
                    final VelocityTracker mVelocityTracker = this.mVelocityTracker;
                    mVelocityTracker.computeCurrentVelocity(1000, (float)this.mMaximumVelocity);
                    final int n11 = (int)VelocityTrackerCompat.getYVelocity(mVelocityTracker, this.mActivePointerId);
                    if (Math.abs(n11) > this.mMinimumVelocity) {
                        this.flingWithNestedDispatch(-n11);
                    }
                    else if (this.mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                        ViewCompat.postInvalidateOnAnimation((View)this);
                    }
                }
                this.mActivePointerId = n;
                this.endDrag();
                break;
            }
            case 0: {
                if (this.getChildCount() == 0) {
                    return false;
                }
                final boolean mIsBeingDragged2 = ((this.mScroller.isFinished() ? 1 : 0) ^ mIsBeingDragged) != 0x0;
                this.mIsBeingDragged = mIsBeingDragged2;
                if (mIsBeingDragged2) {
                    final ViewParent parent2 = this.getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent((boolean)(mIsBeingDragged != 0));
                    }
                }
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                this.mLastMotionY = (int)motionEvent.getY();
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.startNestedScroll(2);
                break;
            }
        }
        final VelocityTracker mVelocityTracker2 = this.mVelocityTracker;
        if (mVelocityTracker2 != null) {
            mVelocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return mIsBeingDragged != 0;
    }
    
    boolean overScrollByCompat(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, int n7, final int n8, final boolean b) {
        final int overScrollMode = this.getOverScrollMode();
        final int computeHorizontalScrollRange = this.computeHorizontalScrollRange();
        final int computeHorizontalScrollExtent = this.computeHorizontalScrollExtent();
        final boolean b2 = true;
        final boolean b3 = computeHorizontalScrollRange > computeHorizontalScrollExtent;
        final boolean b4 = this.computeVerticalScrollRange() > this.computeVerticalScrollExtent();
        final boolean b5 = overScrollMode == 0 || (overScrollMode == (b2 ? 1 : 0) && b3);
        final boolean b6 = overScrollMode == 0 || (overScrollMode == (b2 ? 1 : 0) && b4);
        int n9 = n3 + n;
        int n10;
        if (!b5) {
            n10 = 0;
        }
        else {
            n10 = n7;
        }
        final int n11 = n4 + n2;
        int n12;
        if (!b6) {
            n12 = 0;
        }
        else {
            n12 = n8;
        }
        final int n13 = -n10;
        final int n14 = n10 + n5;
        final int n15 = -n12;
        final int n16 = n12 + n6;
        boolean b7;
        if (n9 > n14) {
            n9 = n14;
            b7 = true;
        }
        else if (n9 < n13) {
            n9 = n13;
            b7 = true;
        }
        else {
            b7 = false;
        }
        boolean b9;
        if (n11 > n16) {
            final boolean b8 = true;
            n7 = n16;
            b9 = b8;
        }
        else if (n11 < n15) {
            final boolean b10 = true;
            n7 = n15;
            b9 = b10;
        }
        else {
            n7 = n11;
            b9 = false;
        }
        if (b9) {
            this.mScroller.springBack(n9, n7, 0, 0, 0, this.getScrollRange());
        }
        this.onOverScrolled(n9, n7, b7, b9);
        return b7 || b9;
    }
    
    public boolean pageScroll(final int n) {
        final boolean b = n == 130;
        final int height = this.getHeight();
        if (b) {
            this.mTempRect.top = this.getScrollY() + height;
            final int childCount = this.getChildCount();
            if (childCount > 0) {
                final View child = this.getChildAt(childCount - 1);
                if (this.mTempRect.top + height > child.getBottom()) {
                    this.mTempRect.top = child.getBottom() - height;
                }
            }
        }
        else {
            this.mTempRect.top = this.getScrollY() - height;
            if (this.mTempRect.top < 0) {
                this.mTempRect.top = 0;
            }
        }
        final Rect mTempRect = this.mTempRect;
        mTempRect.bottom = mTempRect.top + height;
        return this.scrollAndFocus(n, this.mTempRect.top, this.mTempRect.bottom);
    }
    
    public void requestChildFocus(final View view, final View mChildToScrollTo) {
        if (!this.mIsLayoutDirty) {
            this.scrollToChild(mChildToScrollTo);
        }
        else {
            this.mChildToScrollTo = mChildToScrollTo;
        }
        super.requestChildFocus(view, mChildToScrollTo);
    }
    
    public boolean requestChildRectangleOnScreen(final View view, final Rect rect, final boolean b) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return this.scrollToChildRect(rect, b);
    }
    
    public void requestDisallowInterceptTouchEvent(final boolean b) {
        if (b) {
            this.recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(b);
    }
    
    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }
    
    public void scrollTo(int clamp, int clamp2) {
        if (this.getChildCount() > 0) {
            final View child = this.getChildAt(0);
            clamp = clamp(clamp, this.getWidth() - this.getPaddingRight() - this.getPaddingLeft(), child.getWidth());
            clamp2 = clamp(clamp2, this.getHeight() - this.getPaddingBottom() - this.getPaddingTop(), child.getHeight());
            if (clamp != this.getScrollX() || clamp2 != this.getScrollY()) {
                super.scrollTo(clamp, clamp2);
            }
        }
    }
    
    public void setFillViewport(final boolean mFillViewport) {
        if (mFillViewport != this.mFillViewport) {
            this.mFillViewport = mFillViewport;
            this.requestLayout();
        }
    }
    
    public void setNestedScrollingEnabled(final boolean nestedScrollingEnabled) {
        this.mChildHelper.setNestedScrollingEnabled(nestedScrollingEnabled);
    }
    
    public void setOnScrollChangeListener(final NestedScrollView$OnScrollChangeListener mOnScrollChangeListener) {
        this.mOnScrollChangeListener = mOnScrollChangeListener;
    }
    
    public void setSmoothScrollingEnabled(final boolean mSmoothScrollingEnabled) {
        this.mSmoothScrollingEnabled = mSmoothScrollingEnabled;
    }
    
    public boolean shouldDelayChildPressedState() {
        return true;
    }
    
    public final void smoothScrollBy(final int n, int n2) {
        if (this.getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250L) {
            final int max = Math.max(0, this.getChildAt(0).getHeight() - (this.getHeight() - this.getPaddingBottom() - this.getPaddingTop()));
            final int scrollY = this.getScrollY();
            n2 = Math.max(0, Math.min(scrollY + n2, max)) - scrollY;
            this.mScroller.startScroll(this.getScrollX(), scrollY, 0, n2);
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
        else {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            this.scrollBy(n, n2);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }
    
    public final void smoothScrollTo(final int n, final int n2) {
        this.smoothScrollBy(n - this.getScrollX(), n2 - this.getScrollY());
    }
    
    public boolean startNestedScroll(final int n) {
        return this.mChildHelper.startNestedScroll(n);
    }
    
    public void stopNestedScroll() {
        this.mChildHelper.stopNestedScroll();
    }
}
