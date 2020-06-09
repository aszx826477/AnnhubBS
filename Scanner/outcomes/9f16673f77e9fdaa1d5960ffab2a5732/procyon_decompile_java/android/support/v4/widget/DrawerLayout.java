// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.view.KeyEvent;
import android.support.v4.view.MotionEventCompat;
import android.view.ViewGroup$MarginLayoutParams;
import android.support.v4.view.GravityCompat;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.os.SystemClock;
import android.view.ViewGroup$LayoutParams;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.view.View;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import android.graphics.drawable.Drawable;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.List;
import android.view.ViewGroup;

public class DrawerLayout extends ViewGroup implements DrawerLayoutImpl
{
    private static final boolean ALLOW_EDGE_LOCK = false;
    static final boolean CAN_HIDE_DESCENDANTS = false;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    private static final int DRAWER_ELEVATION = 10;
    static final DrawerLayout$DrawerLayoutCompatImpl IMPL;
    static final int[] LAYOUT_ATTRS;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 160;
    private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION = false;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final float TOUCH_SLOP_SENSITIVITY = 1.0f;
    private final DrawerLayout$ChildAccessibilityDelegate mChildAccessibilityDelegate;
    private boolean mChildrenCanceledTouch;
    private boolean mDisallowInterceptRequested;
    private boolean mDrawStatusBarBackground;
    private float mDrawerElevation;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final DrawerLayout$ViewDragCallback mLeftCallback;
    private final ViewDragHelper mLeftDragger;
    private DrawerLayout$DrawerListener mListener;
    private List mListeners;
    private int mLockModeEnd;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mLockModeStart;
    private int mMinDrawerMargin;
    private final ArrayList mNonDrawerViews;
    private final DrawerLayout$ViewDragCallback mRightCallback;
    private final ViewDragHelper mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private Drawable mShadowEnd;
    private Drawable mShadowLeft;
    private Drawable mShadowLeftResolved;
    private Drawable mShadowRight;
    private Drawable mShadowRightResolved;
    private Drawable mShadowStart;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;
    
    static {
        int set_DRAWER_SHADOW_FROM_ELEVATION = 1;
        final int[] layout_ATTRS = new int[set_DRAWER_SHADOW_FROM_ELEVATION];
        layout_ATTRS[0] = 16842931;
        LAYOUT_ATTRS = layout_ATTRS;
        final int sdk_INT = Build$VERSION.SDK_INT;
        final int n = 21;
        if (sdk_INT < n) {
            set_DRAWER_SHADOW_FROM_ELEVATION = 0;
        }
        if (Build$VERSION.SDK_INT >= n) {
            IMPL = new DrawerLayout$DrawerLayoutCompatImplApi21();
        }
        else {
            IMPL = new DrawerLayout$DrawerLayoutCompatImplBase();
        }
    }
    
    public DrawerLayout(final Context context) {
        this(context, null);
    }
    
    public DrawerLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public DrawerLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mChildAccessibilityDelegate = new DrawerLayout$ChildAccessibilityDelegate(this);
        this.mScrimColor = -1728053248;
        this.mScrimPaint = new Paint();
        final int focusableInTouchMode = 1;
        this.mFirstLayout = (focusableInTouchMode != 0);
        final int n2 = 3;
        this.mLockModeLeft = n2;
        this.mLockModeRight = n2;
        this.mLockModeStart = n2;
        this.mLockModeEnd = n2;
        this.mShadowStart = null;
        this.mShadowEnd = null;
        this.mShadowLeft = null;
        this.mShadowRight = null;
        this.setDescendantFocusability(262144);
        final float density = this.getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int)(64.0f * density + 0.5f);
        final float n3 = 400.0f * density;
        this.mLeftCallback = new DrawerLayout$ViewDragCallback(this, n2);
        this.mRightCallback = new DrawerLayout$ViewDragCallback(this, 5);
        final DrawerLayout$ViewDragCallback mLeftCallback = this.mLeftCallback;
        final float n4 = 1.0f;
        (this.mLeftDragger = ViewDragHelper.create(this, n4, mLeftCallback)).setEdgeTrackingEnabled(focusableInTouchMode);
        this.mLeftDragger.setMinVelocity(n3);
        this.mLeftCallback.setDragger(this.mLeftDragger);
        (this.mRightDragger = ViewDragHelper.create(this, n4, this.mRightCallback)).setEdgeTrackingEnabled(2);
        this.mRightDragger.setMinVelocity(n3);
        this.mRightCallback.setDragger(this.mRightDragger);
        this.setFocusableInTouchMode((boolean)(focusableInTouchMode != 0));
        ViewCompat.setImportantForAccessibility((View)this, focusableInTouchMode);
        ViewCompat.setAccessibilityDelegate((View)this, new DrawerLayout$AccessibilityDelegate(this));
        ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
        if (ViewCompat.getFitsSystemWindows((View)this)) {
            DrawerLayout.IMPL.configureApplyInsets((View)this);
            this.mStatusBarBackground = DrawerLayout.IMPL.getDefaultStatusBarBackground(context);
        }
        this.mDrawerElevation = 10.0f * density;
        this.mNonDrawerViews = new ArrayList();
    }
    
    static String gravityToString(final int n) {
        if ((n & 0x3) == 0x3) {
            return "LEFT";
        }
        if ((n & 0x5) == 0x5) {
            return "RIGHT";
        }
        return Integer.toHexString(n);
    }
    
    private static boolean hasOpaqueBackground(final View view) {
        final Drawable background = view.getBackground();
        boolean b = false;
        if (background != null) {
            if (background.getOpacity() == -1) {
                b = true;
            }
            return b;
        }
        return false;
    }
    
    private boolean hasPeekingDrawer() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            if (((DrawerLayout$LayoutParams)this.getChildAt(i).getLayoutParams()).isPeeking) {
                return true;
            }
        }
        return false;
    }
    
    private boolean hasVisibleDrawer() {
        return this.findVisibleDrawer() != null;
    }
    
    static boolean includeChildForAccessibility(final View view) {
        return ViewCompat.getImportantForAccessibility(view) != 4 && ViewCompat.getImportantForAccessibility(view) != 2;
    }
    
    private boolean mirror(final Drawable drawable, final int n) {
        if (drawable != null && DrawableCompat.isAutoMirrored(drawable)) {
            DrawableCompat.setLayoutDirection(drawable, n);
            return true;
        }
        return false;
    }
    
    private Drawable resolveLeftShadow() {
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        if (layoutDirection == 0) {
            final Drawable mShadowStart = this.mShadowStart;
            if (mShadowStart != null) {
                this.mirror(mShadowStart, layoutDirection);
                return this.mShadowStart;
            }
        }
        else {
            final Drawable mShadowEnd = this.mShadowEnd;
            if (mShadowEnd != null) {
                this.mirror(mShadowEnd, layoutDirection);
                return this.mShadowEnd;
            }
        }
        return this.mShadowLeft;
    }
    
    private Drawable resolveRightShadow() {
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        if (layoutDirection == 0) {
            final Drawable mShadowEnd = this.mShadowEnd;
            if (mShadowEnd != null) {
                this.mirror(mShadowEnd, layoutDirection);
                return this.mShadowEnd;
            }
        }
        else {
            final Drawable mShadowStart = this.mShadowStart;
            if (mShadowStart != null) {
                this.mirror(mShadowStart, layoutDirection);
                return this.mShadowStart;
            }
        }
        return this.mShadowRight;
    }
    
    private void resolveShadowDrawables() {
        if (DrawerLayout.SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return;
        }
        this.mShadowLeftResolved = this.resolveLeftShadow();
        this.mShadowRightResolved = this.resolveRightShadow();
    }
    
    private void updateChildrenImportantForAccessibility(final View view, final boolean b) {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if ((b || this.isDrawerView(child)) && (!b || child != view)) {
                ViewCompat.setImportantForAccessibility(child, 4);
            }
            else {
                ViewCompat.setImportantForAccessibility(child, 1);
            }
        }
    }
    
    public void addDrawerListener(final DrawerLayout$DrawerListener drawerLayout$DrawerListener) {
        if (drawerLayout$DrawerListener == null) {
            return;
        }
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(drawerLayout$DrawerListener);
    }
    
    public void addFocusables(final ArrayList list, final int n, final int n2) {
        if (this.getDescendantFocusability() == 393216) {
            return;
        }
        final int childCount = this.getChildCount();
        boolean b = false;
        for (int i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (this.isDrawerView(child)) {
                if (this.isDrawerOpen(child)) {
                    b = true;
                    child.addFocusables(list, n, n2);
                }
            }
            else {
                this.mNonDrawerViews.add(child);
            }
        }
        if (!b) {
            for (int size = this.mNonDrawerViews.size(), j = 0; j < size; ++j) {
                final View view = this.mNonDrawerViews.get(j);
                if (view.getVisibility() == 0) {
                    view.addFocusables(list, n, n2);
                }
            }
        }
        this.mNonDrawerViews.clear();
    }
    
    public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super.addView(view, n, viewGroup$LayoutParams);
        if (this.findOpenDrawer() == null && !this.isDrawerView(view)) {
            ViewCompat.setImportantForAccessibility(view, 1);
        }
        else {
            ViewCompat.setImportantForAccessibility(view, 4);
        }
        if (!DrawerLayout.CAN_HIDE_DESCENDANTS) {
            ViewCompat.setAccessibilityDelegate(view, this.mChildAccessibilityDelegate);
        }
    }
    
    void cancelChildViewTouch() {
        if (!this.mChildrenCanceledTouch) {
            final long uptimeMillis = SystemClock.uptimeMillis();
            final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                this.getChildAt(i).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.mChildrenCanceledTouch = true;
        }
    }
    
    boolean checkDrawerViewAbsoluteGravity(final View view, final int n) {
        return (this.getDrawerViewAbsoluteGravity(view) & n) == n;
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof DrawerLayout$LayoutParams && super.checkLayoutParams((ViewGroup$LayoutParams)viewGroup$LayoutParams);
    }
    
    public void closeDrawer(final int n) {
        this.closeDrawer(n, true);
    }
    
    public void closeDrawer(final int n, final boolean b) {
        final View drawerWithGravity = this.findDrawerWithGravity(n);
        if (drawerWithGravity != null) {
            this.closeDrawer(drawerWithGravity, b);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("No drawer view found with gravity ");
        sb.append(gravityToString(n));
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void closeDrawer(final View view) {
        this.closeDrawer(view, true);
    }
    
    public void closeDrawer(final View view, final boolean b) {
        if (this.isDrawerView(view)) {
            final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
            if (this.mFirstLayout) {
                drawerLayout$LayoutParams.onScreen = 0.0f;
                drawerLayout$LayoutParams.openState = 0;
            }
            else {
                final int visibility = 4;
                if (b) {
                    drawerLayout$LayoutParams.openState |= visibility;
                    if (this.checkDrawerViewAbsoluteGravity(view, 3)) {
                        this.mLeftDragger.smoothSlideViewTo(view, -view.getWidth(), view.getTop());
                    }
                    else {
                        this.mRightDragger.smoothSlideViewTo(view, this.getWidth(), view.getTop());
                    }
                }
                else {
                    this.moveDrawerToOffset(view, 0.0f);
                    this.updateDrawerState(drawerLayout$LayoutParams.gravity, 0, view);
                    view.setVisibility(visibility);
                }
            }
            this.invalidate();
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a sliding drawer");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void closeDrawers() {
        this.closeDrawers(false);
    }
    
    void closeDrawers(final boolean b) {
        boolean b2 = false;
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)child.getLayoutParams();
            if (this.isDrawerView(child)) {
                if (!b || drawerLayout$LayoutParams.isPeeking) {
                    final int width = child.getWidth();
                    if (this.checkDrawerViewAbsoluteGravity(child, 3)) {
                        b2 |= this.mLeftDragger.smoothSlideViewTo(child, -width, child.getTop());
                    }
                    else {
                        b2 |= this.mRightDragger.smoothSlideViewTo(child, this.getWidth(), child.getTop());
                    }
                    drawerLayout$LayoutParams.isPeeking = false;
                }
            }
        }
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        if (b2) {
            this.invalidate();
        }
    }
    
    public void computeScroll() {
        final int childCount = this.getChildCount();
        float max = 0.0f;
        for (int i = 0; i < childCount; ++i) {
            max = Math.max(max, ((DrawerLayout$LayoutParams)this.getChildAt(i).getLayoutParams()).onScreen);
        }
        this.mScrimOpacity = max;
        final ViewDragHelper mLeftDragger = this.mLeftDragger;
        final boolean b = true;
        if (mLeftDragger.continueSettling(b) | this.mRightDragger.continueSettling(b)) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    void dispatchOnDrawerClosed(final View view) {
        final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
        final int openState = drawerLayout$LayoutParams.openState;
        final boolean b = true;
        if ((openState & (b ? 1 : 0)) == (b ? 1 : 0)) {
            drawerLayout$LayoutParams.openState = 0;
            final List mListeners = this.mListeners;
            if (mListeners != null) {
                for (int i = mListeners.size() - 1; i >= 0; --i) {
                    ((DrawerLayout$DrawerListener)this.mListeners.get(i)).onDrawerClosed(view);
                }
            }
            this.updateChildrenImportantForAccessibility(view, false);
            if (this.hasWindowFocus()) {
                final View rootView = this.getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }
    
    void dispatchOnDrawerOpened(final View view) {
        final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
        final int openState = drawerLayout$LayoutParams.openState;
        final boolean openState2 = true;
        if ((openState & (openState2 ? 1 : 0)) == 0x0) {
            drawerLayout$LayoutParams.openState = (openState2 ? 1 : 0);
            final List mListeners = this.mListeners;
            if (mListeners != null) {
                for (int i = mListeners.size() - 1; i >= 0; --i) {
                    ((DrawerLayout$DrawerListener)this.mListeners.get(i)).onDrawerOpened(view);
                }
            }
            this.updateChildrenImportantForAccessibility(view, openState2);
            if (this.hasWindowFocus()) {
                this.sendAccessibilityEvent(32);
            }
        }
    }
    
    void dispatchOnDrawerSlide(final View view, final float n) {
        final List mListeners = this.mListeners;
        if (mListeners != null) {
            for (int i = mListeners.size() - 1; i >= 0; --i) {
                ((DrawerLayout$DrawerListener)this.mListeners.get(i)).onDrawerSlide(view, n);
            }
        }
    }
    
    protected boolean drawChild(final Canvas canvas, final View view, final long n) {
        final int height = this.getHeight();
        final boolean contentView = this.isContentView(view);
        int n2 = 0;
        int width = this.getWidth();
        final int save = canvas.save();
        final int n3 = 3;
        int n4;
        int n5;
        if (contentView) {
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                final View child = this.getChildAt(i);
                if (child != view && child.getVisibility() == 0) {
                    if (hasOpaqueBackground(child) && this.isDrawerView(child)) {
                        if (child.getHeight() >= height) {
                            if (this.checkDrawerViewAbsoluteGravity(child, n3)) {
                                final int right = child.getRight();
                                if (right > n2) {
                                    n2 = right;
                                }
                            }
                            else {
                                final int left = child.getLeft();
                                if (left < width) {
                                    width = left;
                                }
                            }
                        }
                    }
                }
            }
            canvas.clipRect(n2, 0, width, this.getHeight());
            n4 = n2;
            n5 = width;
        }
        else {
            n4 = 0;
            n5 = width;
        }
        final boolean drawChild = super.drawChild(canvas, view, n);
        canvas.restoreToCount(save);
        final float mScrimOpacity = this.mScrimOpacity;
        if (mScrimOpacity > 0.0f && contentView) {
            final int mScrimColor = this.mScrimColor;
            this.mScrimPaint.setColor((int)(((0xFF000000 & mScrimColor) >>> 24) * mScrimOpacity) << 24 | (mScrimColor & 0xFFFFFF));
            canvas.drawRect((float)n4, 0.0f, (float)n5, (float)this.getHeight(), this.mScrimPaint);
        }
        else {
            final Drawable mShadowLeftResolved = this.mShadowLeftResolved;
            final float n6 = 1.0f;
            if (mShadowLeftResolved != null && this.checkDrawerViewAbsoluteGravity(view, n3)) {
                final int intrinsicWidth = this.mShadowLeftResolved.getIntrinsicWidth();
                final int right2 = view.getRight();
                final float max = Math.max(0.0f, Math.min(right2 / this.mLeftDragger.getEdgeSize(), n6));
                this.mShadowLeftResolved.setBounds(right2, view.getTop(), right2 + intrinsicWidth, view.getBottom());
                this.mShadowLeftResolved.setAlpha((int)(255.0f * max));
                this.mShadowLeftResolved.draw(canvas);
            }
            else if (this.mShadowRightResolved != null) {
                if (this.checkDrawerViewAbsoluteGravity(view, 5)) {
                    final int intrinsicWidth2 = this.mShadowRightResolved.getIntrinsicWidth();
                    final int left2 = view.getLeft();
                    final float max2 = Math.max(0.0f, Math.min((this.getWidth() - left2) / this.mRightDragger.getEdgeSize(), n6));
                    this.mShadowRightResolved.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
                    this.mShadowRightResolved.setAlpha((int)(255.0f * max2));
                    this.mShadowRightResolved.draw(canvas);
                }
            }
        }
        return drawChild;
    }
    
    View findDrawerWithGravity(final int n) {
        final int n2 = GravityCompat.getAbsoluteGravity(n, ViewCompat.getLayoutDirection((View)this)) & 0x7;
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if ((this.getDrawerViewAbsoluteGravity(child) & 0x7) == n2) {
                return child;
            }
        }
        return null;
    }
    
    View findOpenDrawer() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final int openState = ((DrawerLayout$LayoutParams)child.getLayoutParams()).openState;
            final boolean b = true;
            if ((openState & (b ? 1 : 0)) == (b ? 1 : 0)) {
                return child;
            }
        }
        return null;
    }
    
    View findVisibleDrawer() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (this.isDrawerView(child) && this.isDrawerVisible(child)) {
                return child;
            }
        }
        return null;
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        final int n = -1;
        return (ViewGroup$LayoutParams)new DrawerLayout$LayoutParams(n, n);
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)new DrawerLayout$LayoutParams(this.getContext(), set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        DrawerLayout$LayoutParams drawerLayout$LayoutParams;
        if (viewGroup$LayoutParams instanceof DrawerLayout$LayoutParams) {
            drawerLayout$LayoutParams = new DrawerLayout$LayoutParams((DrawerLayout$LayoutParams)viewGroup$LayoutParams);
        }
        else if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            drawerLayout$LayoutParams = new DrawerLayout$LayoutParams((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        else {
            drawerLayout$LayoutParams = new DrawerLayout$LayoutParams(viewGroup$LayoutParams);
        }
        return (ViewGroup$LayoutParams)drawerLayout$LayoutParams;
    }
    
    public float getDrawerElevation() {
        if (DrawerLayout.SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return this.mDrawerElevation;
        }
        return 0.0f;
    }
    
    public int getDrawerLockMode(final int n) {
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        final int n2 = 3;
        if (n != n2) {
            if (n != 5) {
                if (n != 8388611) {
                    if (n == 8388613) {
                        final int mLockModeEnd = this.mLockModeEnd;
                        if (mLockModeEnd != n2) {
                            return mLockModeEnd;
                        }
                        int n3;
                        if (layoutDirection == 0) {
                            n3 = this.mLockModeRight;
                        }
                        else {
                            n3 = this.mLockModeLeft;
                        }
                        if (n3 != n2) {
                            return n3;
                        }
                    }
                }
                else {
                    final int mLockModeStart = this.mLockModeStart;
                    if (mLockModeStart != n2) {
                        return mLockModeStart;
                    }
                    int n4;
                    if (layoutDirection == 0) {
                        n4 = this.mLockModeLeft;
                    }
                    else {
                        n4 = this.mLockModeRight;
                    }
                    if (n4 != n2) {
                        return n4;
                    }
                }
            }
            else {
                final int mLockModeRight = this.mLockModeRight;
                if (mLockModeRight != n2) {
                    return mLockModeRight;
                }
                int n5;
                if (layoutDirection == 0) {
                    n5 = this.mLockModeEnd;
                }
                else {
                    n5 = this.mLockModeStart;
                }
                if (n5 != n2) {
                    return n5;
                }
            }
        }
        else {
            final int mLockModeLeft = this.mLockModeLeft;
            if (mLockModeLeft != n2) {
                return mLockModeLeft;
            }
            int n6;
            if (layoutDirection == 0) {
                n6 = this.mLockModeStart;
            }
            else {
                n6 = this.mLockModeEnd;
            }
            if (n6 != n2) {
                return n6;
            }
        }
        return 0;
    }
    
    public int getDrawerLockMode(final View view) {
        if (this.isDrawerView(view)) {
            return this.getDrawerLockMode(((DrawerLayout$LayoutParams)view.getLayoutParams()).gravity);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a drawer");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public CharSequence getDrawerTitle(final int n) {
        final int absoluteGravity = GravityCompat.getAbsoluteGravity(n, ViewCompat.getLayoutDirection((View)this));
        if (absoluteGravity == 3) {
            return this.mTitleLeft;
        }
        if (absoluteGravity == 5) {
            return this.mTitleRight;
        }
        return null;
    }
    
    int getDrawerViewAbsoluteGravity(final View view) {
        return GravityCompat.getAbsoluteGravity(((DrawerLayout$LayoutParams)view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection((View)this));
    }
    
    float getDrawerViewOffset(final View view) {
        return ((DrawerLayout$LayoutParams)view.getLayoutParams()).onScreen;
    }
    
    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }
    
    boolean isContentView(final View view) {
        return ((DrawerLayout$LayoutParams)view.getLayoutParams()).gravity == 0;
    }
    
    public boolean isDrawerOpen(final int n) {
        final View drawerWithGravity = this.findDrawerWithGravity(n);
        return drawerWithGravity != null && this.isDrawerOpen(drawerWithGravity);
    }
    
    public boolean isDrawerOpen(final View view) {
        if (this.isDrawerView(view)) {
            final int openState = ((DrawerLayout$LayoutParams)view.getLayoutParams()).openState;
            boolean b = true;
            if ((openState & (b ? 1 : 0)) != (b ? 1 : 0)) {
                b = false;
            }
            return b;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a drawer");
        throw new IllegalArgumentException(sb.toString());
    }
    
    boolean isDrawerView(final View view) {
        final int absoluteGravity = GravityCompat.getAbsoluteGravity(((DrawerLayout$LayoutParams)view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(view));
        final int n = absoluteGravity & 0x3;
        final boolean b = true;
        if (n != 0) {
            return b;
        }
        return (absoluteGravity & 0x5) != 0x0 && b;
    }
    
    public boolean isDrawerVisible(final int n) {
        final View drawerWithGravity = this.findDrawerWithGravity(n);
        return drawerWithGravity != null && this.isDrawerVisible(drawerWithGravity);
    }
    
    public boolean isDrawerVisible(final View view) {
        if (this.isDrawerView(view)) {
            return ((DrawerLayout$LayoutParams)view.getLayoutParams()).onScreen > 0.0f;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a drawer");
        throw new IllegalArgumentException(sb.toString());
    }
    
    void moveDrawerToOffset(final View view, final float n) {
        final float drawerViewOffset = this.getDrawerViewOffset(view);
        final int width = view.getWidth();
        final int n2 = (int)(width * n) - (int)(width * drawerViewOffset);
        int n3;
        if (this.checkDrawerViewAbsoluteGravity(view, 3)) {
            n3 = n2;
        }
        else {
            n3 = -n2;
        }
        view.offsetLeftAndRight(n3);
        this.setDrawerViewOffset(view, n);
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }
    
    public void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            final int topInset = DrawerLayout.IMPL.getTopInset(this.mLastInsets);
            if (topInset > 0) {
                this.mStatusBarBackground.setBounds(0, 0, this.getWidth(), topInset);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        final boolean b = this.mLeftDragger.shouldInterceptTouchEvent(motionEvent) | this.mRightDragger.shouldInterceptTouchEvent(motionEvent);
        boolean b2 = false;
        boolean b3 = true;
        switch (actionMasked) {
            case 2: {
                if (this.mLeftDragger.checkTouchSlop(3)) {
                    this.mLeftCallback.removeCallbacks();
                    this.mRightCallback.removeCallbacks();
                    break;
                }
                break;
            }
            case 1:
            case 3: {
                this.closeDrawers(b3);
                this.mDisallowInterceptRequested = false;
                this.mChildrenCanceledTouch = false;
                break;
            }
            case 0: {
                final float x = motionEvent.getX();
                final float y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                if (this.mScrimOpacity > 0.0f) {
                    final View topChildUnder = this.mLeftDragger.findTopChildUnder((int)x, (int)y);
                    if (topChildUnder != null && this.isContentView(topChildUnder)) {
                        b2 = true;
                    }
                }
                this.mDisallowInterceptRequested = false;
                this.mChildrenCanceledTouch = false;
                break;
            }
        }
        if (!b && !b2 && !this.hasPeekingDrawer()) {
            if (!this.mChildrenCanceledTouch) {
                b3 = false;
            }
        }
        return b3;
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (n == 4 && this.hasVisibleDrawer()) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        if (n == 4) {
            final View visibleDrawer = this.findVisibleDrawer();
            if (visibleDrawer != null && this.getDrawerLockMode(visibleDrawer) == 0) {
                this.closeDrawers();
            }
            return visibleDrawer != null;
        }
        return super.onKeyUp(n, keyEvent);
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        this.mInLayout = true;
        final int n5 = n3 - n;
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)child.getLayoutParams();
                if (this.isContentView(child)) {
                    child.layout(drawerLayout$LayoutParams.leftMargin, drawerLayout$LayoutParams.topMargin, drawerLayout$LayoutParams.leftMargin + child.getMeasuredWidth(), drawerLayout$LayoutParams.topMargin + child.getMeasuredHeight());
                }
                else {
                    final int measuredWidth = child.getMeasuredWidth();
                    final int measuredHeight = child.getMeasuredHeight();
                    int n6;
                    float n7;
                    if (this.checkDrawerViewAbsoluteGravity(child, 3)) {
                        n6 = -measuredWidth + (int)(measuredWidth * drawerLayout$LayoutParams.onScreen);
                        n7 = (measuredWidth + n6) / measuredWidth;
                    }
                    else {
                        n6 = n5 - (int)(measuredWidth * drawerLayout$LayoutParams.onScreen);
                        n7 = (n5 - n6) / measuredWidth;
                    }
                    final boolean b2 = n7 != drawerLayout$LayoutParams.onScreen;
                    final int n8 = drawerLayout$LayoutParams.gravity & 0x70;
                    if (n8 != 16) {
                        if (n8 != 80) {
                            child.layout(n6, drawerLayout$LayoutParams.topMargin, n6 + measuredWidth, drawerLayout$LayoutParams.topMargin + measuredHeight);
                        }
                        else {
                            final int n9 = n4 - n2;
                            child.layout(n6, n9 - drawerLayout$LayoutParams.bottomMargin - child.getMeasuredHeight(), n6 + measuredWidth, n9 - drawerLayout$LayoutParams.bottomMargin);
                        }
                    }
                    else {
                        final int n10 = n4 - n2;
                        int topMargin = (n10 - measuredHeight) / 2;
                        if (topMargin < drawerLayout$LayoutParams.topMargin) {
                            topMargin = drawerLayout$LayoutParams.topMargin;
                        }
                        else if (topMargin + measuredHeight > n10 - drawerLayout$LayoutParams.bottomMargin) {
                            topMargin = n10 - drawerLayout$LayoutParams.bottomMargin - measuredHeight;
                        }
                        child.layout(n6, topMargin, n6 + measuredWidth, topMargin + measuredHeight);
                    }
                    if (b2) {
                        this.setDrawerViewOffset(child, n7);
                    }
                    int visibility;
                    if (drawerLayout$LayoutParams.onScreen > 0.0f) {
                        visibility = 0;
                    }
                    else {
                        visibility = 4;
                    }
                    if (child.getVisibility() != visibility) {
                        child.setVisibility(visibility);
                    }
                }
            }
        }
        this.mInLayout = false;
        this.mFirstLayout = false;
    }
    
    protected void onMeasure(final int n, final int n2) {
        DrawerLayout drawerLayout = this;
        int mode = View$MeasureSpec.getMode(n);
        int mode2 = View$MeasureSpec.getMode(n2);
        int size = View$MeasureSpec.getSize(n);
        int size2 = View$MeasureSpec.getSize(n2);
        final int n3 = 1073741824;
        if (mode != n3 || mode2 != n3) {
            if (!this.isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            final int n4 = -1 << -1;
            if (mode == n4) {
                mode = 1073741824;
            }
            else if (mode == 0) {
                mode = 1073741824;
                size = 300;
            }
            if (mode2 == n4) {
                mode2 = 1073741824;
            }
            else if (mode2 == 0) {
                mode2 = 1073741824;
                size2 = 300;
            }
        }
        drawerLayout.setMeasuredDimension(size, size2);
        final boolean b = drawerLayout.mLastInsets != null && ViewCompat.getFitsSystemWindows((View)this);
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        int n5 = 0;
        int n6 = 0;
        int n7;
        int n12;
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i, mode = n7, mode2 = n12, drawerLayout = this) {
            final View child = drawerLayout.getChildAt(i);
            if (child.getVisibility() == 8) {
                n7 = mode;
            }
            else {
                final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)child.getLayoutParams();
                if (b) {
                    final int absoluteGravity = GravityCompat.getAbsoluteGravity(drawerLayout$LayoutParams.gravity, layoutDirection);
                    if (ViewCompat.getFitsSystemWindows(child)) {
                        DrawerLayout.IMPL.dispatchChildInsets(child, drawerLayout.mLastInsets, absoluteGravity);
                    }
                    else {
                        DrawerLayout.IMPL.applyMarginInsets(drawerLayout$LayoutParams, drawerLayout.mLastInsets, absoluteGravity);
                    }
                }
                if (drawerLayout.isContentView(child)) {
                    final int n8 = size - drawerLayout$LayoutParams.leftMargin - drawerLayout$LayoutParams.rightMargin;
                    final int n9 = 1073741824;
                    final int measureSpec = View$MeasureSpec.makeMeasureSpec(n8, n9);
                    final int n10 = size2 - drawerLayout$LayoutParams.topMargin;
                    n7 = mode;
                    child.measure(measureSpec, View$MeasureSpec.makeMeasureSpec(n10 - drawerLayout$LayoutParams.bottomMargin, n9));
                }
                else {
                    n7 = mode;
                    if (drawerLayout.isDrawerView(child)) {
                        if (DrawerLayout.SET_DRAWER_SHADOW_FROM_ELEVATION) {
                            final float elevation = ViewCompat.getElevation(child);
                            final float mDrawerElevation = drawerLayout.mDrawerElevation;
                            if (elevation != mDrawerElevation) {
                                ViewCompat.setElevation(child, mDrawerElevation);
                            }
                        }
                        final int n11 = drawerLayout.getDrawerViewAbsoluteGravity(child) & 0x7;
                        final boolean b2 = n11 == 3;
                        Label_0594: {
                            if (!b2 || n5 == 0) {
                                if (!b2) {
                                    if (n6 != 0) {
                                        break Label_0594;
                                    }
                                    n12 = mode2;
                                }
                                else {
                                    n12 = mode2;
                                }
                                if (b2) {
                                    n5 = 1;
                                }
                                else {
                                    n6 = 1;
                                }
                                child.measure(getChildMeasureSpec(n, drawerLayout.mMinDrawerMargin + drawerLayout$LayoutParams.leftMargin + drawerLayout$LayoutParams.rightMargin, drawerLayout$LayoutParams.width), getChildMeasureSpec(n2, drawerLayout$LayoutParams.topMargin + drawerLayout$LayoutParams.bottomMargin, drawerLayout$LayoutParams.height));
                                continue;
                            }
                        }
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Child drawer has absolute gravity ");
                        sb.append(gravityToString(n11));
                        sb.append(" but this ");
                        sb.append("DrawerLayout");
                        sb.append(" already has a ");
                        sb.append("drawer view along that edge");
                        throw new IllegalStateException(sb.toString());
                    }
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Child ");
                    sb2.append(child);
                    sb2.append(" at index ");
                    sb2.append(i);
                    sb2.append(" does not have a valid layout_gravity - must be Gravity.LEFT, ");
                    sb2.append("Gravity.RIGHT or Gravity.NO_GRAVITY");
                    throw new IllegalStateException(sb2.toString());
                }
            }
            n12 = mode2;
        }
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof DrawerLayout$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final DrawerLayout$SavedState drawerLayout$SavedState = (DrawerLayout$SavedState)parcelable;
        super.onRestoreInstanceState(drawerLayout$SavedState.getSuperState());
        if (drawerLayout$SavedState.openDrawerGravity != 0) {
            final View drawerWithGravity = this.findDrawerWithGravity(drawerLayout$SavedState.openDrawerGravity);
            if (drawerWithGravity != null) {
                this.openDrawer(drawerWithGravity);
            }
        }
        final int lockModeLeft = drawerLayout$SavedState.lockModeLeft;
        final int n = 3;
        if (lockModeLeft != n) {
            this.setDrawerLockMode(drawerLayout$SavedState.lockModeLeft, n);
        }
        if (drawerLayout$SavedState.lockModeRight != n) {
            this.setDrawerLockMode(drawerLayout$SavedState.lockModeRight, 5);
        }
        if (drawerLayout$SavedState.lockModeStart != n) {
            this.setDrawerLockMode(drawerLayout$SavedState.lockModeStart, 8388611);
        }
        if (drawerLayout$SavedState.lockModeEnd != n) {
            this.setDrawerLockMode(drawerLayout$SavedState.lockModeEnd, 8388613);
        }
    }
    
    public void onRtlPropertiesChanged(final int n) {
        this.resolveShadowDrawables();
    }
    
    protected Parcelable onSaveInstanceState() {
        final DrawerLayout$SavedState drawerLayout$SavedState = new DrawerLayout$SavedState(super.onSaveInstanceState());
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)this.getChildAt(i).getLayoutParams();
            final int openState = drawerLayout$LayoutParams.openState;
            boolean b = false;
            final boolean b2 = openState == 1;
            if (drawerLayout$LayoutParams.openState == 2) {
                b = true;
            }
            if (b2 || b) {
                drawerLayout$SavedState.openDrawerGravity = drawerLayout$LayoutParams.gravity;
                break;
            }
        }
        drawerLayout$SavedState.lockModeLeft = this.mLockModeLeft;
        drawerLayout$SavedState.lockModeRight = this.mLockModeRight;
        drawerLayout$SavedState.lockModeStart = this.mLockModeStart;
        drawerLayout$SavedState.lockModeEnd = this.mLockModeEnd;
        return (Parcelable)drawerLayout$SavedState;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        this.mLeftDragger.processTouchEvent(motionEvent);
        this.mRightDragger.processTouchEvent(motionEvent);
        final int action = motionEvent.getAction();
        final boolean b = true;
        final int n = action & 0xFF;
        final int n2 = 3;
        boolean b2 = true;
        if (n != n2) {
            switch (n) {
                case 1: {
                    final float x = motionEvent.getX();
                    final float y = motionEvent.getY();
                    boolean b3 = true;
                    final View topChildUnder = this.mLeftDragger.findTopChildUnder((int)x, (int)y);
                    if (topChildUnder != null && this.isContentView(topChildUnder)) {
                        final float n3 = x - this.mInitialMotionX;
                        final float n4 = y - this.mInitialMotionY;
                        final int touchSlop = this.mLeftDragger.getTouchSlop();
                        if (n3 * n3 + n4 * n4 < touchSlop * touchSlop) {
                            final View openDrawer = this.findOpenDrawer();
                            if (openDrawer != null) {
                                if (this.getDrawerLockMode(openDrawer) != 2) {
                                    b2 = false;
                                }
                                b3 = b2;
                            }
                        }
                    }
                    this.closeDrawers(b3);
                    this.mDisallowInterceptRequested = false;
                    break;
                }
                case 0: {
                    final float x2 = motionEvent.getX();
                    final float y2 = motionEvent.getY();
                    this.mInitialMotionX = x2;
                    this.mInitialMotionY = y2;
                    this.mDisallowInterceptRequested = false;
                    this.mChildrenCanceledTouch = false;
                    break;
                }
            }
        }
        else {
            this.closeDrawers(b2);
            this.mDisallowInterceptRequested = false;
            this.mChildrenCanceledTouch = false;
        }
        return b;
    }
    
    public void openDrawer(final int n) {
        this.openDrawer(n, true);
    }
    
    public void openDrawer(final int n, final boolean b) {
        final View drawerWithGravity = this.findDrawerWithGravity(n);
        if (drawerWithGravity != null) {
            this.openDrawer(drawerWithGravity, b);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("No drawer view found with gravity ");
        sb.append(gravityToString(n));
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void openDrawer(final View view) {
        this.openDrawer(view, true);
    }
    
    public void openDrawer(final View view, final boolean b) {
        if (this.isDrawerView(view)) {
            final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
            final boolean mFirstLayout = this.mFirstLayout;
            final float onScreen = 1.0f;
            if (mFirstLayout) {
                drawerLayout$LayoutParams.onScreen = onScreen;
                this.updateChildrenImportantForAccessibility(view, (drawerLayout$LayoutParams.openState = 1) != 0);
            }
            else if (b) {
                drawerLayout$LayoutParams.openState |= 0x2;
                if (this.checkDrawerViewAbsoluteGravity(view, 3)) {
                    this.mLeftDragger.smoothSlideViewTo(view, 0, view.getTop());
                }
                else {
                    this.mRightDragger.smoothSlideViewTo(view, this.getWidth() - view.getWidth(), view.getTop());
                }
            }
            else {
                this.moveDrawerToOffset(view, onScreen);
                this.updateDrawerState(drawerLayout$LayoutParams.gravity, 0, view);
                view.setVisibility(0);
            }
            this.invalidate();
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a sliding drawer");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void removeDrawerListener(final DrawerLayout$DrawerListener drawerLayout$DrawerListener) {
        if (drawerLayout$DrawerListener == null) {
            return;
        }
        final List mListeners = this.mListeners;
        if (mListeners == null) {
            return;
        }
        mListeners.remove(drawerLayout$DrawerListener);
    }
    
    public void requestDisallowInterceptTouchEvent(final boolean mDisallowInterceptRequested) {
        super.requestDisallowInterceptTouchEvent(mDisallowInterceptRequested);
        this.mDisallowInterceptRequested = mDisallowInterceptRequested;
        if (mDisallowInterceptRequested) {
            this.closeDrawers(true);
        }
    }
    
    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }
    
    public void setChildInsets(final Object mLastInsets, final boolean mDrawStatusBarBackground) {
        this.mLastInsets = mLastInsets;
        this.setWillNotDraw(!(this.mDrawStatusBarBackground = mDrawStatusBarBackground) && this.getBackground() == null);
        this.requestLayout();
    }
    
    public void setDrawerElevation(final float mDrawerElevation) {
        this.mDrawerElevation = mDrawerElevation;
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            if (this.isDrawerView(child)) {
                ViewCompat.setElevation(child, this.mDrawerElevation);
            }
        }
    }
    
    public void setDrawerListener(final DrawerLayout$DrawerListener mListener) {
        final DrawerLayout$DrawerListener mListener2 = this.mListener;
        if (mListener2 != null) {
            this.removeDrawerListener(mListener2);
        }
        if (mListener != null) {
            this.addDrawerListener(mListener);
        }
        this.mListener = mListener;
    }
    
    public void setDrawerLockMode(final int n) {
        this.setDrawerLockMode(n, 3);
        this.setDrawerLockMode(n, 5);
    }
    
    public void setDrawerLockMode(final int n, final int n2) {
        final int absoluteGravity = GravityCompat.getAbsoluteGravity(n2, ViewCompat.getLayoutDirection((View)this));
        final int n3 = 3;
        if (n2 != n3) {
            if (n2 != 5) {
                if (n2 != 8388611) {
                    if (n2 == 8388613) {
                        this.mLockModeEnd = n;
                    }
                }
                else {
                    this.mLockModeStart = n;
                }
            }
            else {
                this.mLockModeRight = n;
            }
        }
        else {
            this.mLockModeLeft = n;
        }
        if (n != 0) {
            ViewDragHelper viewDragHelper;
            if (absoluteGravity == n3) {
                viewDragHelper = this.mLeftDragger;
            }
            else {
                viewDragHelper = this.mRightDragger;
            }
            viewDragHelper.cancel();
        }
        switch (n) {
            case 2: {
                final View drawerWithGravity = this.findDrawerWithGravity(absoluteGravity);
                if (drawerWithGravity != null) {
                    this.openDrawer(drawerWithGravity);
                    break;
                }
                break;
            }
            case 1: {
                final View drawerWithGravity2 = this.findDrawerWithGravity(absoluteGravity);
                if (drawerWithGravity2 != null) {
                    this.closeDrawer(drawerWithGravity2);
                    break;
                }
                break;
            }
        }
    }
    
    public void setDrawerLockMode(final int n, final View view) {
        if (this.isDrawerView(view)) {
            this.setDrawerLockMode(n, ((DrawerLayout$LayoutParams)view.getLayoutParams()).gravity);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a ");
        sb.append("drawer with appropriate layout_gravity");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void setDrawerShadow(final int n, final int n2) {
        this.setDrawerShadow(ContextCompat.getDrawable(this.getContext(), n), n2);
    }
    
    public void setDrawerShadow(final Drawable drawable, final int n) {
        if (DrawerLayout.SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return;
        }
        final int n2 = 8388611;
        if ((n & n2) == n2) {
            this.mShadowStart = drawable;
        }
        else {
            final int n3 = 8388613;
            if ((n & n3) == n3) {
                this.mShadowEnd = drawable;
            }
            else if ((n & 0x3) == 0x3) {
                this.mShadowLeft = drawable;
            }
            else {
                if ((n & 0x5) != 0x5) {
                    return;
                }
                this.mShadowRight = drawable;
            }
        }
        this.resolveShadowDrawables();
        this.invalidate();
    }
    
    public void setDrawerTitle(final int n, final CharSequence charSequence) {
        final int absoluteGravity = GravityCompat.getAbsoluteGravity(n, ViewCompat.getLayoutDirection((View)this));
        if (absoluteGravity == 3) {
            this.mTitleLeft = charSequence;
        }
        else if (absoluteGravity == 5) {
            this.mTitleRight = charSequence;
        }
    }
    
    void setDrawerViewOffset(final View view, final float onScreen) {
        final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
        if (onScreen == drawerLayout$LayoutParams.onScreen) {
            return;
        }
        this.dispatchOnDrawerSlide(view, drawerLayout$LayoutParams.onScreen = onScreen);
    }
    
    public void setScrimColor(final int mScrimColor) {
        this.mScrimColor = mScrimColor;
        this.invalidate();
    }
    
    public void setStatusBarBackground(final int n) {
        Drawable drawable;
        if (n != 0) {
            drawable = ContextCompat.getDrawable(this.getContext(), n);
        }
        else {
            drawable = null;
        }
        this.mStatusBarBackground = drawable;
        this.invalidate();
    }
    
    public void setStatusBarBackground(final Drawable mStatusBarBackground) {
        this.mStatusBarBackground = mStatusBarBackground;
        this.invalidate();
    }
    
    public void setStatusBarBackgroundColor(final int n) {
        this.mStatusBarBackground = (Drawable)new ColorDrawable(n);
        this.invalidate();
    }
    
    void updateDrawerState(final int n, final int n2, final View view) {
        final int viewDragState = this.mLeftDragger.getViewDragState();
        final int viewDragState2 = this.mRightDragger.getViewDragState();
        final boolean b = true;
        int mDrawerState;
        if (viewDragState != (b ? 1 : 0) && viewDragState2 != (b ? 1 : 0)) {
            final int n3 = 2;
            if (viewDragState != n3 && viewDragState2 != n3) {
                mDrawerState = 0;
            }
            else {
                mDrawerState = 2;
            }
        }
        else {
            mDrawerState = 1;
        }
        if (view != null && n2 == 0) {
            final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
            if (drawerLayout$LayoutParams.onScreen == 0.0f) {
                this.dispatchOnDrawerClosed(view);
            }
            else if (drawerLayout$LayoutParams.onScreen == 1.0f) {
                this.dispatchOnDrawerOpened(view);
            }
        }
        if (mDrawerState != this.mDrawerState) {
            this.mDrawerState = mDrawerState;
            final List mListeners = this.mListeners;
            if (mListeners != null) {
                for (int i = mListeners.size() - 1; i >= 0; --i) {
                    ((DrawerLayout$DrawerListener)this.mListeners.get(i)).onDrawerStateChanged(mDrawerState);
                }
            }
        }
    }
}
