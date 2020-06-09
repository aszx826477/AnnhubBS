// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.support.v4.content.ContextCompat;
import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.ViewGroup$MarginLayoutParams;
import android.graphics.Bitmap;
import android.util.Log;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.Paint;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.view.ViewConfiguration;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import android.graphics.Rect;
import android.view.View;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import android.view.ViewGroup;

public class SlidingPaneLayout extends ViewGroup
{
    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    static final SlidingPaneLayout$SlidingPanelLayoutImpl IMPL;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    final ViewDragHelper mDragHelper;
    private boolean mFirstLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private SlidingPaneLayout$PanelSlideListener mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    final ArrayList mPostedRunnables;
    boolean mPreservedOpenState;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    float mSlideOffset;
    int mSlideRange;
    View mSlideableView;
    private int mSliderFadeColor;
    private final Rect mTmpRect;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 17) {
            IMPL = new SlidingPaneLayout$SlidingPanelLayoutImplJBMR1();
        }
        else if (sdk_INT >= 16) {
            IMPL = new SlidingPaneLayout$SlidingPanelLayoutImplJB();
        }
        else {
            IMPL = new SlidingPaneLayout$SlidingPanelLayoutImplBase();
        }
    }
    
    public SlidingPaneLayout(final Context context) {
        this(context, null);
    }
    
    public SlidingPaneLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public SlidingPaneLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mSliderFadeColor = -858993460;
        final int mFirstLayout = 1;
        this.mFirstLayout = (mFirstLayout != 0);
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList();
        final float density = context.getResources().getDisplayMetrics().density;
        final float n2 = 32.0f * density;
        final float n3 = 0.5f;
        this.mOverhangSize = (int)(n2 + n3);
        ViewConfiguration.get(context);
        this.setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate((View)this, new SlidingPaneLayout$AccessibilityDelegate(this));
        ViewCompat.setImportantForAccessibility((View)this, mFirstLayout);
        (this.mDragHelper = ViewDragHelper.create(this, n3, new SlidingPaneLayout$DragHelperCallback(this))).setMinVelocity(400.0f * density);
    }
    
    private boolean closePane(final View view, final int n) {
        if (!this.mFirstLayout && !this.smoothSlideTo(0.0f, n)) {
            return false;
        }
        this.mPreservedOpenState = false;
        return true;
    }
    
    private void dimChildView(final View view, final float n, final int n2) {
        final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)view.getLayoutParams();
        if (n > 0.0f && n2 != 0) {
            final int n3 = (int)(((0xFF000000 & n2) >>> 24) * n) << 24 | (0xFFFFFF & n2);
            if (slidingPaneLayout$LayoutParams.dimPaint == null) {
                slidingPaneLayout$LayoutParams.dimPaint = new Paint();
            }
            slidingPaneLayout$LayoutParams.dimPaint.setColorFilter((ColorFilter)new PorterDuffColorFilter(n3, PorterDuff$Mode.SRC_OVER));
            final int layerType = ViewCompat.getLayerType(view);
            final int n4 = 2;
            if (layerType != n4) {
                ViewCompat.setLayerType(view, n4, slidingPaneLayout$LayoutParams.dimPaint);
            }
            this.invalidateChildRegion(view);
        }
        else if (ViewCompat.getLayerType(view) != 0) {
            if (slidingPaneLayout$LayoutParams.dimPaint != null) {
                slidingPaneLayout$LayoutParams.dimPaint.setColorFilter((ColorFilter)null);
            }
            final SlidingPaneLayout$DisableLayerRunnable slidingPaneLayout$DisableLayerRunnable = new SlidingPaneLayout$DisableLayerRunnable(this, view);
            this.mPostedRunnables.add(slidingPaneLayout$DisableLayerRunnable);
            ViewCompat.postOnAnimation((View)this, slidingPaneLayout$DisableLayerRunnable);
        }
    }
    
    private boolean openPane(final View view, final int n) {
        return (this.mFirstLayout || this.smoothSlideTo(1.0f, n)) && (this.mPreservedOpenState = true);
    }
    
    private void parallaxOtherViews(final float mParallaxOffset) {
        final boolean layoutRtlSupport = this.isLayoutRtlSupport();
        final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)this.mSlideableView.getLayoutParams();
        boolean b = false;
        Label_0060: {
            if (slidingPaneLayout$LayoutParams.dimWhenOffset) {
                int n;
                if (layoutRtlSupport) {
                    n = slidingPaneLayout$LayoutParams.rightMargin;
                }
                else {
                    n = slidingPaneLayout$LayoutParams.leftMargin;
                }
                if (n <= 0) {
                    b = true;
                    break Label_0060;
                }
            }
            b = false;
        }
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child != this.mSlideableView) {
                final float mParallaxOffset2 = this.mParallaxOffset;
                final float n2 = 1.0f;
                final float n3 = n2 - mParallaxOffset2;
                final int mParallaxBy = this.mParallaxBy;
                final int n4 = (int)(n3 * mParallaxBy);
                this.mParallaxOffset = mParallaxOffset;
                final int n5 = n4 - (int)((n2 - mParallaxOffset) * mParallaxBy);
                int n6;
                if (layoutRtlSupport) {
                    n6 = -n5;
                }
                else {
                    n6 = n5;
                }
                child.offsetLeftAndRight(n6);
                if (b) {
                    float n7;
                    if (layoutRtlSupport) {
                        n7 = this.mParallaxOffset - n2;
                    }
                    else {
                        n7 = n2 - this.mParallaxOffset;
                    }
                    this.dimChildView(child, n7, this.mCoveredFadeColor);
                }
            }
        }
    }
    
    private static boolean viewIsOpaque(final View view) {
        final boolean opaque = view.isOpaque();
        boolean b = true;
        if (opaque) {
            return b;
        }
        if (Build$VERSION.SDK_INT >= 18) {
            return false;
        }
        final Drawable background = view.getBackground();
        if (background != null) {
            if (background.getOpacity() != -1) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    protected boolean canScroll(final View view, final boolean b, final int n, final int n2, final int n3) {
        final boolean b2 = view instanceof ViewGroup;
        boolean b3 = true;
        if (b2) {
            final ViewGroup viewGroup = (ViewGroup)view;
            final int scrollX = view.getScrollX();
            final int scrollY = view.getScrollY();
            for (int i = viewGroup.getChildCount() - 1; i >= 0; --i) {
                final View child = viewGroup.getChildAt(i);
                if (n2 + scrollX >= child.getLeft() && n2 + scrollX < child.getRight()) {
                    if (n3 + scrollY >= child.getTop() && n3 + scrollY < child.getBottom()) {
                        if (this.canScroll(child, true, n, n2 + scrollX - child.getLeft(), n3 + scrollY - child.getTop())) {
                            return b3;
                        }
                    }
                }
            }
        }
        if (b) {
            int n4;
            if (this.isLayoutRtlSupport()) {
                n4 = n;
            }
            else {
                n4 = -n;
            }
            if (ViewCompat.canScrollHorizontally(view, n4)) {
                return b3;
            }
        }
        b3 = false;
        return b3;
    }
    
    public boolean canSlide() {
        return this.mCanSlide;
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof SlidingPaneLayout$LayoutParams && super.checkLayoutParams((ViewGroup$LayoutParams)viewGroup$LayoutParams);
    }
    
    public boolean closePane() {
        return this.closePane(this.mSlideableView, 0);
    }
    
    public void computeScroll() {
        if (this.mDragHelper.continueSettling(true)) {
            if (!this.mCanSlide) {
                this.mDragHelper.abort();
                return;
            }
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    void dispatchOnPanelClosed(final View view) {
        final SlidingPaneLayout$PanelSlideListener mPanelSlideListener = this.mPanelSlideListener;
        if (mPanelSlideListener != null) {
            mPanelSlideListener.onPanelClosed(view);
        }
        this.sendAccessibilityEvent(32);
    }
    
    void dispatchOnPanelOpened(final View view) {
        final SlidingPaneLayout$PanelSlideListener mPanelSlideListener = this.mPanelSlideListener;
        if (mPanelSlideListener != null) {
            mPanelSlideListener.onPanelOpened(view);
        }
        this.sendAccessibilityEvent(32);
    }
    
    void dispatchOnPanelSlide(final View view) {
        final SlidingPaneLayout$PanelSlideListener mPanelSlideListener = this.mPanelSlideListener;
        if (mPanelSlideListener != null) {
            mPanelSlideListener.onPanelSlide(view, this.mSlideOffset);
        }
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        Drawable drawable;
        if (this.isLayoutRtlSupport()) {
            drawable = this.mShadowDrawableRight;
        }
        else {
            drawable = this.mShadowDrawableLeft;
        }
        final int childCount = this.getChildCount();
        final int n = 1;
        View child;
        if (childCount > n) {
            child = this.getChildAt(n);
        }
        else {
            child = null;
        }
        if (child != null && drawable != null) {
            final int top = child.getTop();
            final int bottom = child.getBottom();
            final int intrinsicWidth = drawable.getIntrinsicWidth();
            int right;
            int left;
            if (this.isLayoutRtlSupport()) {
                right = child.getRight();
                left = right + intrinsicWidth;
            }
            else {
                left = child.getLeft();
                right = left - intrinsicWidth;
            }
            drawable.setBounds(right, top, left, bottom);
            drawable.draw(canvas);
        }
    }
    
    protected boolean drawChild(final Canvas canvas, final View view, final long n) {
        final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)view.getLayoutParams();
        final int save = canvas.save(2);
        if (this.mCanSlide && !slidingPaneLayout$LayoutParams.slideable && this.mSlideableView != null) {
            canvas.getClipBounds(this.mTmpRect);
            if (this.isLayoutRtlSupport()) {
                final Rect mTmpRect = this.mTmpRect;
                mTmpRect.left = Math.max(mTmpRect.left, this.mSlideableView.getRight());
            }
            else {
                final Rect mTmpRect2 = this.mTmpRect;
                mTmpRect2.right = Math.min(mTmpRect2.right, this.mSlideableView.getLeft());
            }
            canvas.clipRect(this.mTmpRect);
        }
        boolean b;
        if (Build$VERSION.SDK_INT >= 11) {
            b = super.drawChild(canvas, view, n);
        }
        else if (slidingPaneLayout$LayoutParams.dimWhenOffset && this.mSlideOffset > 0.0f) {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            final Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, (float)view.getLeft(), (float)view.getTop(), slidingPaneLayout$LayoutParams.dimPaint);
                b = false;
            }
            else {
                final String s = "SlidingPaneLayout";
                final StringBuilder sb = new StringBuilder();
                sb.append("drawChild: child view ");
                sb.append(view);
                sb.append(" returned null drawing cache");
                Log.e(s, sb.toString());
                b = super.drawChild(canvas, view, n);
            }
        }
        else {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            b = super.drawChild(canvas, view, n);
        }
        canvas.restoreToCount(save);
        return b;
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)new SlidingPaneLayout$LayoutParams();
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)new SlidingPaneLayout$LayoutParams(this.getContext(), set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams;
        if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            slidingPaneLayout$LayoutParams = new SlidingPaneLayout$LayoutParams((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        else {
            slidingPaneLayout$LayoutParams = new SlidingPaneLayout$LayoutParams(viewGroup$LayoutParams);
        }
        return (ViewGroup$LayoutParams)slidingPaneLayout$LayoutParams;
    }
    
    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }
    
    public int getParallaxDistance() {
        return this.mParallaxBy;
    }
    
    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }
    
    void invalidateChildRegion(final View view) {
        SlidingPaneLayout.IMPL.invalidateChildRegion(this, view);
    }
    
    boolean isDimmed(final View view) {
        boolean b = false;
        if (view == null) {
            return false;
        }
        final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)view.getLayoutParams();
        if (this.mCanSlide && slidingPaneLayout$LayoutParams.dimWhenOffset && this.mSlideOffset > 0.0f) {
            b = true;
        }
        return b;
    }
    
    boolean isLayoutRtlSupport() {
        final int layoutDirection = ViewCompat.getLayoutDirection((View)this);
        boolean b = true;
        if (layoutDirection != (b ? 1 : 0)) {
            b = false;
        }
        return b;
    }
    
    public boolean isOpen() {
        return !this.mCanSlide || this.mSlideOffset == 1.0f;
    }
    
    public boolean isSlideable() {
        return this.mCanSlide;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        for (int i = 0; i < this.mPostedRunnables.size(); ++i) {
            ((SlidingPaneLayout$DisableLayerRunnable)this.mPostedRunnables.get(i)).run();
        }
        this.mPostedRunnables.clear();
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        final boolean mCanSlide = this.mCanSlide;
        int mIsUnableToDrag = 1;
        if (!mCanSlide && actionMasked == 0 && this.getChildCount() > mIsUnableToDrag) {
            final View child = this.getChildAt(mIsUnableToDrag);
            if (child != null) {
                this.mPreservedOpenState = (((this.mDragHelper.isViewUnder(child, (int)motionEvent.getX(), (int)motionEvent.getY()) ? 1 : 0) ^ mIsUnableToDrag) != 0x0);
            }
        }
        if (!this.mCanSlide || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.mDragHelper.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked != 3 && actionMasked != mIsUnableToDrag) {
            boolean b = false;
            if (actionMasked != 0) {
                if (actionMasked == 2) {
                    final float x = motionEvent.getX();
                    final float y = motionEvent.getY();
                    final float abs = Math.abs(x - this.mInitialMotionX);
                    final float abs2 = Math.abs(y - this.mInitialMotionY);
                    if (abs > this.mDragHelper.getTouchSlop() && abs2 > abs) {
                        this.mDragHelper.cancel();
                        this.mIsUnableToDrag = (mIsUnableToDrag != 0);
                        return false;
                    }
                }
            }
            else {
                this.mIsUnableToDrag = false;
                final float x2 = motionEvent.getX();
                final float y2 = motionEvent.getY();
                this.mInitialMotionX = x2;
                this.mInitialMotionY = y2;
                if (this.mDragHelper.isViewUnder(this.mSlideableView, (int)x2, (int)y2)) {
                    if (this.isDimmed(this.mSlideableView)) {
                        b = true;
                    }
                }
            }
            if (!this.mDragHelper.shouldInterceptTouchEvent(motionEvent)) {
                if (!b) {
                    mIsUnableToDrag = 0;
                }
            }
            return mIsUnableToDrag != 0;
        }
        this.mDragHelper.cancel();
        return false;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final boolean layoutRtlSupport = this.isLayoutRtlSupport();
        final int edgeTrackingEnabled = 1;
        if (layoutRtlSupport) {
            this.mDragHelper.setEdgeTrackingEnabled(2);
        }
        else {
            this.mDragHelper.setEdgeTrackingEnabled(edgeTrackingEnabled);
        }
        final int n5 = n3 - n;
        int n6;
        if (layoutRtlSupport) {
            n6 = this.getPaddingRight();
        }
        else {
            n6 = this.getPaddingLeft();
        }
        int n7;
        if (layoutRtlSupport) {
            n7 = this.getPaddingLeft();
        }
        else {
            n7 = this.getPaddingRight();
        }
        final int paddingTop = this.getPaddingTop();
        final int childCount = this.getChildCount();
        int n8 = n6;
        int n9 = n6;
        if (this.mFirstLayout) {
            float mSlideOffset;
            if (this.mCanSlide && this.mPreservedOpenState) {
                mSlideOffset = 1.0f;
            }
            else {
                mSlideOffset = 0.0f;
            }
            this.mSlideOffset = mSlideOffset;
        }
        int n10;
        for (int i = 0; i < childCount; ++i, n6 = n10) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 8) {
                n10 = n6;
            }
            else {
                final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)child.getLayoutParams();
                final int measuredWidth = child.getMeasuredWidth();
                int n11 = 0;
                Label_0605: {
                    if (slidingPaneLayout$LayoutParams.slideable) {
                        final int mSlideRange = Math.min(n9, n5 - n7 - this.mOverhangSize) - n8 - (slidingPaneLayout$LayoutParams.leftMargin + slidingPaneLayout$LayoutParams.rightMargin);
                        this.mSlideRange = mSlideRange;
                        int n12;
                        if (layoutRtlSupport) {
                            n12 = slidingPaneLayout$LayoutParams.rightMargin;
                        }
                        else {
                            n12 = slidingPaneLayout$LayoutParams.leftMargin;
                        }
                        final int n13 = n8 + n12 + mSlideRange;
                        final int n14 = measuredWidth / 2;
                        n10 = n6;
                        slidingPaneLayout$LayoutParams.dimWhenOffset = (n13 + n14 > n5 - n7);
                        final int n15 = (int)(mSlideRange * this.mSlideOffset);
                        n8 += n15 + n12;
                        this.mSlideOffset = n15 / this.mSlideRange;
                    }
                    else {
                        n10 = n6;
                        if (this.mCanSlide) {
                            final int mParallaxBy = this.mParallaxBy;
                            if (mParallaxBy != 0) {
                                final int n16 = (int)((1.0f - this.mSlideOffset) * mParallaxBy);
                                n8 = n9;
                                n11 = n16;
                                break Label_0605;
                            }
                        }
                        n8 = n9;
                    }
                }
                int n17;
                int n18;
                if (layoutRtlSupport) {
                    n17 = n5 - n8 + n11;
                    n18 = n17 - measuredWidth;
                }
                else {
                    n18 = n8 - n11;
                    n17 = n18 + measuredWidth;
                }
                child.layout(n18, paddingTop, n17, child.getMeasuredHeight() + paddingTop);
                n9 += child.getWidth();
            }
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide) {
                if (this.mParallaxBy != 0) {
                    this.parallaxOtherViews(this.mSlideOffset);
                }
                if (((SlidingPaneLayout$LayoutParams)this.mSlideableView.getLayoutParams()).dimWhenOffset) {
                    this.dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
                }
            }
            else {
                for (int j = 0; j < childCount; ++j) {
                    this.dimChildView(this.getChildAt(j), 0.0f, this.mSliderFadeColor);
                }
            }
            this.updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.mFirstLayout = false;
    }
    
    protected void onMeasure(final int n, final int n2) {
        int mode = View$MeasureSpec.getMode(n);
        int size = View$MeasureSpec.getSize(n);
        int mode2 = View$MeasureSpec.getMode(n2);
        int size2 = View$MeasureSpec.getSize(n2);
        final int n3 = -1 << -1;
        final int n4 = 1073741824;
        if (mode != n4) {
            if (!this.isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
            if (mode == n3) {
                mode = 1073741824;
            }
            else if (mode == 0) {
                mode = 1073741824;
                size = 300;
            }
        }
        else if (mode2 == 0) {
            if (!this.isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
            if (mode2 == 0) {
                mode2 = -1 << -1;
                size2 = 300;
            }
        }
        int min = 0;
        int n5 = -1;
        if (mode2 != n3) {
            if (mode2 == n4) {
                n5 = (min = size2 - this.getPaddingTop() - this.getPaddingBottom());
            }
        }
        else {
            n5 = size2 - this.getPaddingTop() - this.getPaddingBottom();
        }
        float n6 = 0.0f;
        boolean mCanSlide = false;
        int n8;
        final int n7 = n8 = size - this.getPaddingLeft() - this.getPaddingRight();
        int childCount = this.getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.mSlideableView = null;
        int n9 = 0;
        int n10;
        while (true) {
            n10 = 8;
            if (n9 >= childCount) {
                break;
            }
            final View child = this.getChildAt(n9);
            final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)child.getLayoutParams();
            final int n11 = mode;
            int n12 = 0;
            Label_0843: {
                if (child.getVisibility() == n10) {
                    slidingPaneLayout$LayoutParams.dimWhenOffset = false;
                    n12 = size2;
                }
                else {
                    if (slidingPaneLayout$LayoutParams.weight > 0.0f) {
                        n6 += slidingPaneLayout$LayoutParams.weight;
                        if (slidingPaneLayout$LayoutParams.width == 0) {
                            n12 = size2;
                            break Label_0843;
                        }
                    }
                    final int n13 = slidingPaneLayout$LayoutParams.leftMargin + slidingPaneLayout$LayoutParams.rightMargin;
                    final int width = slidingPaneLayout$LayoutParams.width;
                    n12 = size2;
                    int n14;
                    if (width == -2) {
                        n14 = View$MeasureSpec.makeMeasureSpec(n7 - n13, -1 << -1);
                    }
                    else if (slidingPaneLayout$LayoutParams.width == -1) {
                        n14 = View$MeasureSpec.makeMeasureSpec(n7 - n13, 1073741824);
                    }
                    else {
                        n14 = View$MeasureSpec.makeMeasureSpec(slidingPaneLayout$LayoutParams.width, 1073741824);
                    }
                    int n15;
                    if (slidingPaneLayout$LayoutParams.height == -2) {
                        n15 = View$MeasureSpec.makeMeasureSpec(n5, -1 << -1);
                    }
                    else if (slidingPaneLayout$LayoutParams.height == -1) {
                        n15 = View$MeasureSpec.makeMeasureSpec(n5, 1073741824);
                    }
                    else {
                        n15 = View$MeasureSpec.makeMeasureSpec(slidingPaneLayout$LayoutParams.height, 1073741824);
                    }
                    child.measure(n14, n15);
                    final int measuredWidth = child.getMeasuredWidth();
                    final int measuredHeight = child.getMeasuredHeight();
                    final float n16 = n6;
                    if (mode2 == -1 << -1 && measuredHeight > min) {
                        min = Math.min(measuredHeight, n5);
                    }
                    n8 -= measuredWidth;
                    final boolean slideable = n8 < 0;
                    slidingPaneLayout$LayoutParams.slideable = slideable;
                    final boolean b = slideable | mCanSlide;
                    if (slidingPaneLayout$LayoutParams.slideable) {
                        this.mSlideableView = child;
                    }
                    mCanSlide = b;
                    n6 = n16;
                }
            }
            ++n9;
            mode = n11;
            size2 = n12;
        }
        if (mCanSlide || n6 > 0.0f) {
            int n17 = n7 - this.mOverhangSize;
            int n18;
            int n19;
            int n20;
            int n21;
            for (int i = 0; i < childCount; ++i, mode2 = n19, childCount = n21, n17 = n18, n5 = n20, n10 = 8) {
                final View child2 = this.getChildAt(i);
                if (child2.getVisibility() == n10) {
                    n18 = n17;
                    n19 = mode2;
                    n20 = n5;
                    n21 = childCount;
                }
                else {
                    final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams2 = (SlidingPaneLayout$LayoutParams)child2.getLayoutParams();
                    if (child2.getVisibility() == n10) {
                        n18 = n17;
                        n19 = mode2;
                        n20 = n5;
                        n21 = childCount;
                    }
                    else {
                        final boolean b2 = slidingPaneLayout$LayoutParams2.width == 0 && slidingPaneLayout$LayoutParams2.weight > 0.0f;
                        int measuredWidth2;
                        if (b2) {
                            measuredWidth2 = 0;
                        }
                        else {
                            measuredWidth2 = child2.getMeasuredWidth();
                        }
                        final int n22 = measuredWidth2;
                        if (mCanSlide && child2 != this.mSlideableView) {
                            if (slidingPaneLayout$LayoutParams2.width < 0) {
                                if (measuredWidth2 <= n17) {
                                    n19 = mode2;
                                    if (slidingPaneLayout$LayoutParams2.weight <= 0.0f) {
                                        n18 = n17;
                                        n20 = n5;
                                        n21 = childCount;
                                        continue;
                                    }
                                }
                                else {
                                    n19 = mode2;
                                }
                                int n23;
                                int n24;
                                if (b2) {
                                    final int height = slidingPaneLayout$LayoutParams2.height;
                                    n21 = childCount;
                                    if (height == -2) {
                                        n23 = View$MeasureSpec.makeMeasureSpec(n5, -1 << -1);
                                        n24 = 1073741824;
                                    }
                                    else if (slidingPaneLayout$LayoutParams2.height == -1) {
                                        n24 = 1073741824;
                                        n23 = View$MeasureSpec.makeMeasureSpec(n5, n24);
                                    }
                                    else {
                                        n24 = 1073741824;
                                        n23 = View$MeasureSpec.makeMeasureSpec(slidingPaneLayout$LayoutParams2.height, n24);
                                    }
                                }
                                else {
                                    n21 = childCount;
                                    n24 = 1073741824;
                                    n23 = View$MeasureSpec.makeMeasureSpec(child2.getMeasuredHeight(), n24);
                                }
                                child2.measure(View$MeasureSpec.makeMeasureSpec(n17, n24), n23);
                                n18 = n17;
                                n20 = n5;
                            }
                            else {
                                n21 = childCount;
                                n19 = mode2;
                                n18 = n17;
                                n20 = n5;
                            }
                        }
                        else {
                            n21 = childCount;
                            final int n25 = n22;
                            n19 = mode2;
                            if (slidingPaneLayout$LayoutParams2.weight > 0.0f) {
                                int n26;
                                if (slidingPaneLayout$LayoutParams2.width == 0) {
                                    if (slidingPaneLayout$LayoutParams2.height == -2) {
                                        n26 = View$MeasureSpec.makeMeasureSpec(n5, -1 << -1);
                                    }
                                    else if (slidingPaneLayout$LayoutParams2.height == -1) {
                                        n26 = View$MeasureSpec.makeMeasureSpec(n5, 1073741824);
                                    }
                                    else {
                                        n26 = View$MeasureSpec.makeMeasureSpec(slidingPaneLayout$LayoutParams2.height, 1073741824);
                                    }
                                }
                                else {
                                    n26 = View$MeasureSpec.makeMeasureSpec(child2.getMeasuredHeight(), 1073741824);
                                }
                                if (mCanSlide) {
                                    final int n27 = n7 - (slidingPaneLayout$LayoutParams2.leftMargin + slidingPaneLayout$LayoutParams2.rightMargin);
                                    n18 = n17;
                                    n20 = n5;
                                    final int measureSpec = View$MeasureSpec.makeMeasureSpec(n27, 1073741824);
                                    if (n25 != n27) {
                                        child2.measure(measureSpec, n26);
                                    }
                                }
                                else {
                                    n18 = n17;
                                    n20 = n5;
                                    child2.measure(View$MeasureSpec.makeMeasureSpec(n25 + (int)(slidingPaneLayout$LayoutParams2.weight * Math.max(0, n8) / n6), 1073741824), n26);
                                }
                            }
                            else {
                                n18 = n17;
                                n20 = n5;
                            }
                        }
                    }
                }
            }
        }
        this.setMeasuredDimension(size, this.getPaddingTop() + min + this.getPaddingBottom());
        this.mCanSlide = mCanSlide;
        if (this.mDragHelper.getViewDragState() != 0 && !mCanSlide) {
            this.mDragHelper.abort();
        }
    }
    
    void onPanelDragged(final int n) {
        if (this.mSlideableView == null) {
            this.mSlideOffset = 0.0f;
            return;
        }
        final boolean layoutRtlSupport = this.isLayoutRtlSupport();
        final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)this.mSlideableView.getLayoutParams();
        final int width = this.mSlideableView.getWidth();
        int n2;
        if (layoutRtlSupport) {
            n2 = this.getWidth() - n - width;
        }
        else {
            n2 = n;
        }
        int n3;
        if (layoutRtlSupport) {
            n3 = this.getPaddingRight();
        }
        else {
            n3 = this.getPaddingLeft();
        }
        int n4;
        if (layoutRtlSupport) {
            n4 = slidingPaneLayout$LayoutParams.rightMargin;
        }
        else {
            n4 = slidingPaneLayout$LayoutParams.leftMargin;
        }
        this.mSlideOffset = (n2 - (n3 + n4)) / this.mSlideRange;
        if (this.mParallaxBy != 0) {
            this.parallaxOtherViews(this.mSlideOffset);
        }
        if (slidingPaneLayout$LayoutParams.dimWhenOffset) {
            this.dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        }
        this.dispatchOnPanelSlide(this.mSlideableView);
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof SlidingPaneLayout$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final SlidingPaneLayout$SavedState slidingPaneLayout$SavedState = (SlidingPaneLayout$SavedState)parcelable;
        super.onRestoreInstanceState(slidingPaneLayout$SavedState.getSuperState());
        if (slidingPaneLayout$SavedState.isOpen) {
            this.openPane();
        }
        else {
            this.closePane();
        }
        this.mPreservedOpenState = slidingPaneLayout$SavedState.isOpen;
    }
    
    protected Parcelable onSaveInstanceState() {
        final SlidingPaneLayout$SavedState slidingPaneLayout$SavedState = new SlidingPaneLayout$SavedState(super.onSaveInstanceState());
        boolean isOpen;
        if (this.isSlideable()) {
            isOpen = this.isOpen();
        }
        else {
            isOpen = this.mPreservedOpenState;
        }
        slidingPaneLayout$SavedState.isOpen = isOpen;
        return (Parcelable)slidingPaneLayout$SavedState;
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        if (n != n3) {
            this.mFirstLayout = true;
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        this.mDragHelper.processTouchEvent(motionEvent);
        final int action = motionEvent.getAction();
        final boolean b = true;
        switch (action & 0xFF) {
            case 1: {
                if (!this.isDimmed(this.mSlideableView)) {
                    break;
                }
                final float x = motionEvent.getX();
                final float y = motionEvent.getY();
                final float n = x - this.mInitialMotionX;
                final float n2 = y - this.mInitialMotionY;
                final int touchSlop = this.mDragHelper.getTouchSlop();
                if (n * n + n2 * n2 >= touchSlop * touchSlop) {
                    break;
                }
                if (this.mDragHelper.isViewUnder(this.mSlideableView, (int)x, (int)y)) {
                    this.closePane(this.mSlideableView, 0);
                    break;
                }
                break;
            }
            case 0: {
                final float x2 = motionEvent.getX();
                final float y2 = motionEvent.getY();
                this.mInitialMotionX = x2;
                this.mInitialMotionY = y2;
                break;
            }
        }
        return b;
    }
    
    public boolean openPane() {
        return this.openPane(this.mSlideableView, 0);
    }
    
    public void requestChildFocus(final View view, final View view2) {
        super.requestChildFocus(view, view2);
        if (!this.isInTouchMode() && !this.mCanSlide) {
            this.mPreservedOpenState = (view == this.mSlideableView);
        }
    }
    
    void setAllChildrenVisible() {
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 4) {
                child.setVisibility(0);
            }
        }
    }
    
    public void setCoveredFadeColor(final int mCoveredFadeColor) {
        this.mCoveredFadeColor = mCoveredFadeColor;
    }
    
    public void setPanelSlideListener(final SlidingPaneLayout$PanelSlideListener mPanelSlideListener) {
        this.mPanelSlideListener = mPanelSlideListener;
    }
    
    public void setParallaxDistance(final int mParallaxBy) {
        this.mParallaxBy = mParallaxBy;
        this.requestLayout();
    }
    
    public void setShadowDrawable(final Drawable shadowDrawableLeft) {
        this.setShadowDrawableLeft(shadowDrawableLeft);
    }
    
    public void setShadowDrawableLeft(final Drawable mShadowDrawableLeft) {
        this.mShadowDrawableLeft = mShadowDrawableLeft;
    }
    
    public void setShadowDrawableRight(final Drawable mShadowDrawableRight) {
        this.mShadowDrawableRight = mShadowDrawableRight;
    }
    
    public void setShadowResource(final int n) {
        this.setShadowDrawable(this.getResources().getDrawable(n));
    }
    
    public void setShadowResourceLeft(final int n) {
        this.setShadowDrawableLeft(ContextCompat.getDrawable(this.getContext(), n));
    }
    
    public void setShadowResourceRight(final int n) {
        this.setShadowDrawableRight(ContextCompat.getDrawable(this.getContext(), n));
    }
    
    public void setSliderFadeColor(final int mSliderFadeColor) {
        this.mSliderFadeColor = mSliderFadeColor;
    }
    
    public void smoothSlideClosed() {
        this.closePane();
    }
    
    public void smoothSlideOpen() {
        this.openPane();
    }
    
    boolean smoothSlideTo(final float n, final int n2) {
        if (!this.mCanSlide) {
            return false;
        }
        final boolean layoutRtlSupport = this.isLayoutRtlSupport();
        final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)this.mSlideableView.getLayoutParams();
        int n3;
        if (layoutRtlSupport) {
            n3 = (int)(this.getWidth() - (this.getPaddingRight() + slidingPaneLayout$LayoutParams.rightMargin + this.mSlideRange * n + this.mSlideableView.getWidth()));
        }
        else {
            n3 = (int)(this.getPaddingLeft() + slidingPaneLayout$LayoutParams.leftMargin + this.mSlideRange * n);
        }
        final ViewDragHelper mDragHelper = this.mDragHelper;
        final View mSlideableView = this.mSlideableView;
        if (mDragHelper.smoothSlideViewTo(mSlideableView, n3, mSlideableView.getTop())) {
            this.setAllChildrenVisible();
            ViewCompat.postInvalidateOnAnimation((View)this);
            return true;
        }
        return false;
    }
    
    void updateObscuredViewsVisibility(final View view) {
        View view2 = view;
        int layoutRtlSupport = this.isLayoutRtlSupport() ? 1 : 0;
        int paddingLeft;
        if (layoutRtlSupport != 0) {
            paddingLeft = this.getWidth() - this.getPaddingRight();
        }
        else {
            paddingLeft = this.getPaddingLeft();
        }
        int paddingLeft2;
        if (layoutRtlSupport != 0) {
            paddingLeft2 = this.getPaddingLeft();
        }
        else {
            paddingLeft2 = this.getWidth() - this.getPaddingRight();
        }
        final int paddingTop = this.getPaddingTop();
        final int n = this.getHeight() - this.getPaddingBottom();
        int left;
        int right;
        int top;
        int bottom;
        if (view2 != null && viewIsOpaque(view)) {
            left = view.getLeft();
            right = view.getRight();
            top = view.getTop();
            bottom = view.getBottom();
        }
        else {
            left = 0;
            bottom = 0;
            top = 0;
            right = 0;
        }
        int n2;
        for (int i = 0; i < this.getChildCount(); ++i, layoutRtlSupport = n2, view2 = view) {
            final View child = this.getChildAt(i);
            if (child == view2) {
                return;
            }
            if (child.getVisibility() == 8) {
                n2 = layoutRtlSupport;
            }
            else {
                int n3;
                if (layoutRtlSupport != 0) {
                    n3 = paddingLeft2;
                }
                else {
                    n3 = paddingLeft;
                }
                final int max = Math.max(n3, child.getLeft());
                final int max2 = Math.max(paddingTop, child.getTop());
                int n4;
                if (layoutRtlSupport != 0) {
                    n4 = paddingLeft;
                }
                else {
                    n4 = paddingLeft2;
                }
                n2 = layoutRtlSupport;
                final int min = Math.min(n4, child.getRight());
                final int min2 = Math.min(n, child.getBottom());
                int visibility;
                if (max >= left && max2 >= top && min <= right && min2 <= bottom) {
                    visibility = 4;
                }
                else {
                    visibility = 0;
                }
                child.setVisibility(visibility);
            }
        }
    }
}
