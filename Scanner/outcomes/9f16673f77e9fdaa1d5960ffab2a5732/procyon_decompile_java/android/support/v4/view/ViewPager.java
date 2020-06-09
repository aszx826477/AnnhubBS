// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.support.v4.content.ContextCompat;
import android.database.DataSetObserver;
import android.content.res.Resources;
import android.content.res.Resources$NotFoundException;
import android.view.View$MeasureSpec;
import android.view.ViewConfiguration;
import android.os.Build$VERSION;
import android.graphics.Canvas;
import android.view.accessibility.AccessibilityEvent;
import android.view.KeyEvent;
import android.os.SystemClock;
import android.view.SoundEffectConstants;
import android.view.FocusFinder;
import android.util.Log;
import android.view.ViewGroup$LayoutParams;
import java.util.Collections;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.graphics.Paint;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.view.VelocityTracker;
import android.graphics.Rect;
import java.lang.reflect.Method;
import android.widget.Scroller;
import android.os.Parcelable;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.EdgeEffectCompat;
import java.util.ArrayList;
import java.util.List;
import android.view.animation.Interpolator;
import java.util.Comparator;
import android.view.ViewGroup;

public class ViewPager extends ViewGroup
{
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator COMPARATOR;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = 255;
    static final int[] LAYOUT_ATTRS;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator;
    private static final ViewPager$ViewPositionComparator sPositionComparator;
    private int mActivePointerId;
    PagerAdapter mAdapter;
    private List mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private ViewPager$OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffectCompat mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private ViewPager$PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private ViewPager$OnPageChangeListener mOnPageChangeListener;
    private List mOnPageChangeListeners;
    private int mPageMargin;
    private ViewPager$PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffectCompat mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final ViewPager$ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    
    static {
        LAYOUT_ATTRS = new int[] { 16842931 };
        COMPARATOR = new ViewPager$1();
        sInterpolator = (Interpolator)new ViewPager$2();
        sPositionComparator = new ViewPager$ViewPositionComparator();
    }
    
    public ViewPager(final Context context) {
        super(context);
        this.mItems = new ArrayList();
        this.mTempItem = new ViewPager$ItemInfo();
        this.mTempRect = new Rect();
        final int n = -1;
        this.mRestoredCurItem = n;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        final boolean b = true;
        this.mOffscreenPageLimit = (b ? 1 : 0);
        this.mActivePointerId = n;
        this.mFirstLayout = b;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new ViewPager$3(this);
        this.mScrollState = 0;
        this.initViewPager();
    }
    
    public ViewPager(final Context context, final AttributeSet set) {
        super(context, set);
        this.mItems = new ArrayList();
        this.mTempItem = new ViewPager$ItemInfo();
        this.mTempRect = new Rect();
        final int n = -1;
        this.mRestoredCurItem = n;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        final boolean b = true;
        this.mOffscreenPageLimit = (b ? 1 : 0);
        this.mActivePointerId = n;
        this.mFirstLayout = b;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new ViewPager$3(this);
        this.mScrollState = 0;
        this.initViewPager();
    }
    
    private void calculatePageOffsets(final ViewPager$ItemInfo viewPager$ItemInfo, final int n, final ViewPager$ItemInfo viewPager$ItemInfo2) {
        final int count = this.mAdapter.getCount();
        final int clientWidth = this.getClientWidth();
        float n2;
        if (clientWidth > 0) {
            n2 = this.mPageMargin / clientWidth;
        }
        else {
            n2 = 0.0f;
        }
        if (viewPager$ItemInfo2 != null) {
            final int position = viewPager$ItemInfo2.position;
            if (position < viewPager$ItemInfo.position) {
                int n3 = 0;
                float offset = viewPager$ItemInfo2.offset + viewPager$ItemInfo2.widthFactor + n2;
                for (int i = position + 1; i <= viewPager$ItemInfo.position && n3 < this.mItems.size(); ++i) {
                    ViewPager$ItemInfo viewPager$ItemInfo3;
                    for (viewPager$ItemInfo3 = this.mItems.get(n3); i > viewPager$ItemInfo3.position && n3 < this.mItems.size() - 1; ++n3, viewPager$ItemInfo3 = this.mItems.get(n3)) {}
                    while (i < viewPager$ItemInfo3.position) {
                        offset += this.mAdapter.getPageWidth(i) + n2;
                        ++i;
                    }
                    viewPager$ItemInfo3.offset = offset;
                    offset += viewPager$ItemInfo3.widthFactor + n2;
                }
            }
            else if (position > viewPager$ItemInfo.position) {
                int n4 = this.mItems.size() - 1;
                float offset2 = viewPager$ItemInfo2.offset;
                for (int j = position - 1; j >= viewPager$ItemInfo.position && n4 >= 0; --j) {
                    ViewPager$ItemInfo viewPager$ItemInfo4;
                    for (viewPager$ItemInfo4 = this.mItems.get(n4); j < viewPager$ItemInfo4.position && n4 > 0; --n4, viewPager$ItemInfo4 = this.mItems.get(n4)) {}
                    while (j > viewPager$ItemInfo4.position) {
                        offset2 -= this.mAdapter.getPageWidth(j) + n2;
                        --j;
                    }
                    offset2 -= viewPager$ItemInfo4.widthFactor + n2;
                    viewPager$ItemInfo4.offset = offset2;
                }
            }
        }
        final int size = this.mItems.size();
        float offset3 = viewPager$ItemInfo.offset;
        int k = viewPager$ItemInfo.position - 1;
        float offset4;
        if (viewPager$ItemInfo.position == 0) {
            offset4 = viewPager$ItemInfo.offset;
        }
        else {
            offset4 = -3.4028235E38f;
        }
        this.mFirstOffset = offset4;
        final int position2 = viewPager$ItemInfo.position;
        final int n5 = count - 1;
        final float n6 = 1.0f;
        float mLastOffset;
        if (position2 == n5) {
            mLastOffset = viewPager$ItemInfo.offset + viewPager$ItemInfo.widthFactor - n6;
        }
        else {
            mLastOffset = Float.MAX_VALUE;
        }
        this.mLastOffset = mLastOffset;
        for (int l = n - 1; l >= 0; --l, --k) {
            ViewPager$ItemInfo viewPager$ItemInfo5;
            int n7;
            for (viewPager$ItemInfo5 = this.mItems.get(l); k > viewPager$ItemInfo5.position; k = n7) {
                final PagerAdapter mAdapter = this.mAdapter;
                n7 = k - 1;
                offset3 -= mAdapter.getPageWidth(k) + n2;
            }
            offset3 -= viewPager$ItemInfo5.widthFactor + n2;
            viewPager$ItemInfo5.offset = offset3;
            if (viewPager$ItemInfo5.position == 0) {
                this.mFirstOffset = offset3;
            }
        }
        float offset5 = viewPager$ItemInfo.offset + viewPager$ItemInfo.widthFactor + n2;
        for (int n8 = viewPager$ItemInfo.position + 1, n9 = n + 1; n9 < size; ++n9, ++n8) {
            ViewPager$ItemInfo viewPager$ItemInfo6;
            int n10;
            for (viewPager$ItemInfo6 = this.mItems.get(n9); n8 < viewPager$ItemInfo6.position; n8 = n10) {
                final PagerAdapter mAdapter2 = this.mAdapter;
                n10 = n8 + 1;
                offset5 += mAdapter2.getPageWidth(n8) + n2;
            }
            if (viewPager$ItemInfo6.position == count - 1) {
                this.mLastOffset = viewPager$ItemInfo6.widthFactor + offset5 - n6;
            }
            viewPager$ItemInfo6.offset = offset5;
            offset5 += viewPager$ItemInfo6.widthFactor + n2;
        }
        this.mNeedCalculatePageOffsets = false;
    }
    
    private void completeScroll(final boolean b) {
        final int mScrollState = this.mScrollState;
        final boolean b2 = true;
        int n;
        if (mScrollState == 2) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n != 0) {
            this.setScrollingCacheEnabled(false);
            if (b2 ^ this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                final int scrollX = this.getScrollX();
                final int scrollY = this.getScrollY();
                final int currX = this.mScroller.getCurrX();
                final int currY = this.mScroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    this.scrollTo(currX, currY);
                    if (currX != scrollX) {
                        this.pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        for (int i = 0; i < this.mItems.size(); ++i) {
            final ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(i);
            if (viewPager$ItemInfo.scrolling) {
                n = 1;
                viewPager$ItemInfo.scrolling = false;
            }
        }
        if (n != 0) {
            if (b) {
                ViewCompat.postOnAnimation((View)this, this.mEndScrollRunnable);
            }
            else {
                this.mEndScrollRunnable.run();
            }
        }
    }
    
    private int determineTargetPage(final int n, final float n2, final int n3, final int n4) {
        int max;
        if (Math.abs(n4) > this.mFlingDistance && Math.abs(n3) > this.mMinimumVelocity) {
            if (n3 > 0) {
                max = n;
            }
            else {
                max = n + 1;
            }
        }
        else {
            float n5;
            if (n >= this.mCurItem) {
                n5 = 0.4f;
            }
            else {
                n5 = 0.6f;
            }
            max = n + (int)(n2 + n5);
        }
        if (this.mItems.size() > 0) {
            final ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(0);
            final ArrayList mItems = this.mItems;
            max = Math.max(viewPager$ItemInfo.position, Math.min(max, mItems.get(mItems.size() - 1).position));
        }
        return max;
    }
    
    private void dispatchOnPageScrolled(final int n, final float n2, final int n3) {
        final ViewPager$OnPageChangeListener mOnPageChangeListener = this.mOnPageChangeListener;
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageScrolled(n, n2, n3);
        }
        final List mOnPageChangeListeners = this.mOnPageChangeListeners;
        if (mOnPageChangeListeners != null) {
            for (int i = 0; i < mOnPageChangeListeners.size(); ++i) {
                final ViewPager$OnPageChangeListener viewPager$OnPageChangeListener = this.mOnPageChangeListeners.get(i);
                if (viewPager$OnPageChangeListener != null) {
                    viewPager$OnPageChangeListener.onPageScrolled(n, n2, n3);
                }
            }
        }
        final ViewPager$OnPageChangeListener mInternalPageChangeListener = this.mInternalPageChangeListener;
        if (mInternalPageChangeListener != null) {
            mInternalPageChangeListener.onPageScrolled(n, n2, n3);
        }
    }
    
    private void dispatchOnPageSelected(final int n) {
        final ViewPager$OnPageChangeListener mOnPageChangeListener = this.mOnPageChangeListener;
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageSelected(n);
        }
        final List mOnPageChangeListeners = this.mOnPageChangeListeners;
        if (mOnPageChangeListeners != null) {
            for (int i = 0; i < mOnPageChangeListeners.size(); ++i) {
                final ViewPager$OnPageChangeListener viewPager$OnPageChangeListener = this.mOnPageChangeListeners.get(i);
                if (viewPager$OnPageChangeListener != null) {
                    viewPager$OnPageChangeListener.onPageSelected(n);
                }
            }
        }
        final ViewPager$OnPageChangeListener mInternalPageChangeListener = this.mInternalPageChangeListener;
        if (mInternalPageChangeListener != null) {
            mInternalPageChangeListener.onPageSelected(n);
        }
    }
    
    private void dispatchOnScrollStateChanged(final int n) {
        final ViewPager$OnPageChangeListener mOnPageChangeListener = this.mOnPageChangeListener;
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageScrollStateChanged(n);
        }
        final List mOnPageChangeListeners = this.mOnPageChangeListeners;
        if (mOnPageChangeListeners != null) {
            for (int i = 0; i < mOnPageChangeListeners.size(); ++i) {
                final ViewPager$OnPageChangeListener viewPager$OnPageChangeListener = this.mOnPageChangeListeners.get(i);
                if (viewPager$OnPageChangeListener != null) {
                    viewPager$OnPageChangeListener.onPageScrollStateChanged(n);
                }
            }
        }
        final ViewPager$OnPageChangeListener mInternalPageChangeListener = this.mInternalPageChangeListener;
        if (mInternalPageChangeListener != null) {
            mInternalPageChangeListener.onPageScrollStateChanged(n);
        }
    }
    
    private void enableLayers(final boolean b) {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            int mPageTransformerLayerType;
            if (b) {
                mPageTransformerLayerType = this.mPageTransformerLayerType;
            }
            else {
                mPageTransformerLayerType = 0;
            }
            ViewCompat.setLayerType(this.getChildAt(i), mPageTransformerLayerType, null);
        }
    }
    
    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        final VelocityTracker mVelocityTracker = this.mVelocityTracker;
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }
    
    private Rect getChildRectInPagerCoordinates(Rect rect, final View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewPager viewPager;
        for (ViewParent viewParent = view.getParent(); viewParent instanceof ViewGroup && viewParent != this; viewParent = viewPager.getParent()) {
            viewPager = (ViewPager)viewParent;
            rect.left += viewPager.getLeft();
            rect.right += viewPager.getRight();
            rect.top += viewPager.getTop();
            rect.bottom += viewPager.getBottom();
        }
        return rect;
    }
    
    private int getClientWidth() {
        return this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
    }
    
    private ViewPager$ItemInfo infoForCurrentScrollPosition() {
        final int clientWidth = this.getClientWidth();
        float n = 0.0f;
        float n2;
        if (clientWidth > 0) {
            n2 = this.getScrollX() / clientWidth;
        }
        else {
            n2 = 0.0f;
        }
        if (clientWidth > 0) {
            n = this.mPageMargin / clientWidth;
        }
        int position = -1;
        float n3 = 0.0f;
        float widthFactor = 0.0f;
        int n4 = 1;
        ViewPager$ItemInfo viewPager$ItemInfo = null;
        for (int i = 0; i < this.mItems.size(); ++i) {
            ViewPager$ItemInfo mTempItem = this.mItems.get(i);
            if (n4 == 0 && mTempItem.position != position + 1) {
                mTempItem = this.mTempItem;
                mTempItem.offset = n3 + widthFactor + n;
                mTempItem.position = position + 1;
                mTempItem.widthFactor = this.mAdapter.getPageWidth(mTempItem.position);
                --i;
            }
            final float offset = mTempItem.offset;
            final float n5 = mTempItem.widthFactor + offset + n;
            if (n4 == 0 && n2 < offset) {
                return viewPager$ItemInfo;
            }
            if (n2 < n5 || i == this.mItems.size() - 1) {
                return mTempItem;
            }
            n4 = 0;
            position = mTempItem.position;
            n3 = offset;
            widthFactor = mTempItem.widthFactor;
            viewPager$ItemInfo = mTempItem;
        }
        return viewPager$ItemInfo;
    }
    
    private static boolean isDecorView(final View view) {
        return view.getClass().getAnnotation(ViewPager$DecorView.class) != null;
    }
    
    private boolean isGutterDrag(final float n, final float n2) {
        return (n < this.mGutterSize && n2 > 0.0f) || (n > this.getWidth() - this.mGutterSize && n2 < 0.0f);
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
            this.mLastMotionX = motionEvent.getX(n);
            this.mActivePointerId = motionEvent.getPointerId(n);
            final VelocityTracker mVelocityTracker = this.mVelocityTracker;
            if (mVelocityTracker != null) {
                mVelocityTracker.clear();
            }
        }
    }
    
    private boolean pageScrolled(final int n) {
        if (this.mItems.size() == 0) {
            if (this.mFirstLayout) {
                return false;
            }
            this.mCalledSuper = false;
            this.onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        else {
            final ViewPager$ItemInfo infoForCurrentScrollPosition = this.infoForCurrentScrollPosition();
            final int clientWidth = this.getClientWidth();
            final int mPageMargin = this.mPageMargin;
            final int n2 = clientWidth + mPageMargin;
            final float n3 = mPageMargin / clientWidth;
            final int position = infoForCurrentScrollPosition.position;
            final float n4 = (n / clientWidth - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + n3);
            final int n5 = (int)(n2 * n4);
            this.mCalledSuper = false;
            this.onPageScrolled(position, n4, n5);
            if (this.mCalledSuper) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }
    
    private boolean performDrag(final float mLastMotionX) {
        boolean b = false;
        final float n = this.mLastMotionX - mLastMotionX;
        this.mLastMotionX = mLastMotionX;
        float n2 = this.getScrollX() + n;
        final int clientWidth = this.getClientWidth();
        float n3 = clientWidth * this.mFirstOffset;
        float n4 = clientWidth * this.mLastOffset;
        boolean b2 = true;
        boolean b3 = true;
        final ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(0);
        final ArrayList mItems = this.mItems;
        final ViewPager$ItemInfo viewPager$ItemInfo2 = mItems.get(mItems.size() - 1);
        if (viewPager$ItemInfo.position != 0) {
            b2 = false;
            n3 = viewPager$ItemInfo.offset * clientWidth;
        }
        if (viewPager$ItemInfo2.position != this.mAdapter.getCount() - 1) {
            b3 = false;
            n4 = viewPager$ItemInfo2.offset * clientWidth;
        }
        if (n2 < n3) {
            if (b2) {
                b = this.mLeftEdge.onPull(Math.abs(n3 - n2) / clientWidth);
            }
            n2 = n3;
        }
        else if (n2 > n4) {
            if (b3) {
                b = this.mRightEdge.onPull(Math.abs(n2 - n4) / clientWidth);
            }
            n2 = n4;
        }
        this.mLastMotionX += n2 - (int)n2;
        this.scrollTo((int)n2, this.getScrollY());
        this.pageScrolled((int)n2);
        return b;
    }
    
    private void recomputeScrollPosition(final int n, final int n2, final int n3, final int n4) {
        if (n2 > 0 && !this.mItems.isEmpty()) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.setFinalX(this.getCurrentItem() * this.getClientWidth());
            }
            else {
                this.scrollTo((int)((n - this.getPaddingLeft() - this.getPaddingRight() + n3) * (this.getScrollX() / (n2 - this.getPaddingLeft() - this.getPaddingRight() + n4))), this.getScrollY());
            }
        }
        else {
            final ViewPager$ItemInfo infoForPosition = this.infoForPosition(this.mCurItem);
            float min;
            if (infoForPosition != null) {
                min = Math.min(infoForPosition.offset, this.mLastOffset);
            }
            else {
                min = 0.0f;
            }
            final int n5 = (int)((n - this.getPaddingLeft() - this.getPaddingRight()) * min);
            if (n5 != this.getScrollX()) {
                this.completeScroll(false);
                this.scrollTo(n5, this.getScrollY());
            }
        }
    }
    
    private void removeNonDecorViews() {
        for (int i = 0; i < this.getChildCount(); ++i) {
            if (!((ViewPager$LayoutParams)this.getChildAt(i).getLayoutParams()).isDecor) {
                this.removeViewAt(i);
                --i;
            }
        }
    }
    
    private void requestParentDisallowInterceptTouchEvent(final boolean b) {
        final ViewParent parent = this.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(b);
        }
    }
    
    private boolean resetTouch() {
        this.mActivePointerId = -1;
        this.endDrag();
        return this.mLeftEdge.onRelease() | this.mRightEdge.onRelease();
    }
    
    private void scrollToItem(final int n, final boolean b, final int n2, final boolean b2) {
        final ViewPager$ItemInfo infoForPosition = this.infoForPosition(n);
        int n3 = 0;
        if (infoForPosition != null) {
            n3 = (int)(this.getClientWidth() * Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset)));
        }
        if (b) {
            this.smoothScrollTo(n3, 0, n2);
            if (b2) {
                this.dispatchOnPageSelected(n);
            }
        }
        else {
            if (b2) {
                this.dispatchOnPageSelected(n);
            }
            this.completeScroll(false);
            this.scrollTo(n3, 0);
            this.pageScrolled(n3);
        }
    }
    
    private void setScrollingCacheEnabled(final boolean mScrollingCacheEnabled) {
        if (this.mScrollingCacheEnabled != mScrollingCacheEnabled) {
            this.mScrollingCacheEnabled = mScrollingCacheEnabled;
        }
    }
    
    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            final ArrayList mDrawingOrderedChildren = this.mDrawingOrderedChildren;
            if (mDrawingOrderedChildren == null) {
                this.mDrawingOrderedChildren = new ArrayList();
            }
            else {
                mDrawingOrderedChildren.clear();
            }
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                this.mDrawingOrderedChildren.add(this.getChildAt(i));
            }
            Collections.sort((List<Object>)this.mDrawingOrderedChildren, ViewPager.sPositionComparator);
        }
    }
    
    public void addFocusables(final ArrayList list, final int n, final int n2) {
        final int size = list.size();
        final int descendantFocusability = this.getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                final View child = this.getChildAt(i);
                if (child.getVisibility() == 0) {
                    final ViewPager$ItemInfo infoForChild = this.infoForChild(child);
                    if (infoForChild != null && infoForChild.position == this.mCurItem) {
                        child.addFocusables(list, n, n2);
                    }
                }
            }
        }
        if (descendantFocusability != 262144 || size == list.size()) {
            if (!this.isFocusable()) {
                return;
            }
            if ((n2 & 0x1) == 0x1 && (this.isInTouchMode() && !this.isFocusableInTouchMode())) {
                return;
            }
            if (list != null) {
                list.add(this);
            }
        }
    }
    
    ViewPager$ItemInfo addNewItem(final int position, final int n) {
        final ViewPager$ItemInfo viewPager$ItemInfo = new ViewPager$ItemInfo();
        viewPager$ItemInfo.position = position;
        viewPager$ItemInfo.object = this.mAdapter.instantiateItem(this, position);
        viewPager$ItemInfo.widthFactor = this.mAdapter.getPageWidth(position);
        if (n >= 0 && n < this.mItems.size()) {
            this.mItems.add(n, viewPager$ItemInfo);
        }
        else {
            this.mItems.add(viewPager$ItemInfo);
        }
        return viewPager$ItemInfo;
    }
    
    public void addOnAdapterChangeListener(final ViewPager$OnAdapterChangeListener viewPager$OnAdapterChangeListener) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(viewPager$OnAdapterChangeListener);
    }
    
    public void addOnPageChangeListener(final ViewPager$OnPageChangeListener viewPager$OnPageChangeListener) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(viewPager$OnPageChangeListener);
    }
    
    public void addTouchables(final ArrayList list) {
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 0) {
                final ViewPager$ItemInfo infoForChild = this.infoForChild(child);
                if (infoForChild != null && infoForChild.position == this.mCurItem) {
                    child.addTouchables(list);
                }
            }
        }
    }
    
    public void addView(final View view, final int n, ViewGroup$LayoutParams generateLayoutParams) {
        if (!this.checkLayoutParams(generateLayoutParams)) {
            generateLayoutParams = this.generateLayoutParams(generateLayoutParams);
        }
        final ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)generateLayoutParams;
        viewPager$LayoutParams.isDecor |= isDecorView(view);
        if (this.mInLayout) {
            if (viewPager$LayoutParams != null && viewPager$LayoutParams.isDecor) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            viewPager$LayoutParams.needsMeasure = true;
            this.addViewInLayout(view, n, generateLayoutParams);
        }
        else {
            super.addView(view, n, generateLayoutParams);
        }
    }
    
    public boolean arrowScroll(final int n) {
        Object focus = this.findFocus();
        if (focus == this) {
            focus = null;
        }
        else if (focus != null) {
            boolean b = false;
            for (ViewParent viewParent = ((View)focus).getParent(); viewParent instanceof ViewGroup; viewParent = viewParent.getParent()) {
                if (viewParent == this) {
                    b = true;
                    break;
                }
            }
            if (!b) {
                final StringBuilder sb = new StringBuilder();
                sb.append(((View)focus).getClass().getSimpleName());
                for (ViewParent viewParent2 = ((View)focus).getParent(); viewParent2 instanceof ViewGroup; viewParent2 = viewParent2.getParent()) {
                    sb.append(" => ");
                    sb.append(viewParent2.getClass().getSimpleName());
                }
                final String s = "ViewPager";
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("arrowScroll tried to find focus based on non-child current focused view ");
                sb2.append(sb.toString());
                Log.e(s, sb2.toString());
                focus = null;
            }
        }
        boolean b2 = false;
        final View nextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup)this, (View)focus, n);
        final int n2 = 66;
        final int n3 = 17;
        if (nextFocus != null && nextFocus != focus) {
            if (n == n3) {
                final int left = this.getChildRectInPagerCoordinates(this.mTempRect, nextFocus).left;
                final int left2 = this.getChildRectInPagerCoordinates(this.mTempRect, (View)focus).left;
                if (focus != null && left >= left2) {
                    b2 = this.pageLeft();
                }
                else {
                    b2 = nextFocus.requestFocus();
                }
            }
            else if (n == n2) {
                final int left3 = this.getChildRectInPagerCoordinates(this.mTempRect, nextFocus).left;
                final int left4 = this.getChildRectInPagerCoordinates(this.mTempRect, (View)focus).left;
                if (focus != null && left3 <= left4) {
                    b2 = this.pageRight();
                }
                else {
                    b2 = nextFocus.requestFocus();
                }
            }
        }
        else if (n != n3 && n != 1) {
            if (n == n2 || n == 2) {
                b2 = this.pageRight();
            }
        }
        else {
            b2 = this.pageLeft();
        }
        if (b2) {
            this.playSoundEffect(SoundEffectConstants.getContantForFocusDirection(n));
        }
        return b2;
    }
    
    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        final boolean mFakeDragging = true;
        this.setScrollState((this.mFakeDragging = mFakeDragging) ? 1 : 0);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        final VelocityTracker mVelocityTracker = this.mVelocityTracker;
        if (mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        else {
            mVelocityTracker.clear();
        }
        final long uptimeMillis = SystemClock.uptimeMillis();
        final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return mFakeDragging;
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
            if (ViewCompat.canScrollHorizontally(view, -n)) {
                return b3;
            }
        }
        b3 = false;
        return b3;
    }
    
    public boolean canScrollHorizontally(final int n) {
        final PagerAdapter mAdapter = this.mAdapter;
        boolean b = false;
        if (mAdapter == null) {
            return false;
        }
        final int clientWidth = this.getClientWidth();
        final int scrollX = this.getScrollX();
        if (n < 0) {
            if (scrollX > (int)(clientWidth * this.mFirstOffset)) {
                b = true;
            }
            return b;
        }
        if (n > 0) {
            if (scrollX < (int)(clientWidth * this.mLastOffset)) {
                b = true;
            }
            return b;
        }
        return false;
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof ViewPager$LayoutParams && super.checkLayoutParams((ViewGroup$LayoutParams)viewGroup$LayoutParams);
    }
    
    public void clearOnPageChangeListeners() {
        final List mOnPageChangeListeners = this.mOnPageChangeListeners;
        if (mOnPageChangeListeners != null) {
            mOnPageChangeListeners.clear();
        }
    }
    
    public void computeScroll() {
        final boolean mIsScrollStarted = true;
        this.mIsScrollStarted = mIsScrollStarted;
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            final int scrollX = this.getScrollX();
            final int scrollY = this.getScrollY();
            final int currX = this.mScroller.getCurrX();
            final int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.scrollTo(currX, currY);
                if (!this.pageScrolled(currX)) {
                    this.mScroller.abortAnimation();
                    this.scrollTo(0, currY);
                }
            }
            ViewCompat.postInvalidateOnAnimation((View)this);
            return;
        }
        this.completeScroll(mIsScrollStarted);
    }
    
    void dataSetChanged() {
        final int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        final int size = this.mItems.size();
        final int n = this.mOffscreenPageLimit * 2;
        final int n2 = 1;
        boolean b = size < n + n2 && this.mItems.size() < count;
        int n3 = this.mCurItem;
        int n4 = 0;
        for (int i = 0; i < this.mItems.size(); i += n2) {
            final ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(i);
            final int itemPosition = this.mAdapter.getItemPosition(viewPager$ItemInfo.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i);
                    --i;
                    if (n4 == 0) {
                        this.mAdapter.startUpdate(this);
                        n4 = 1;
                    }
                    this.mAdapter.destroyItem(this, viewPager$ItemInfo.position, viewPager$ItemInfo.object);
                    b = true;
                    if (this.mCurItem == viewPager$ItemInfo.position) {
                        n3 = Math.max(0, Math.min(this.mCurItem, count - 1));
                        b = true;
                    }
                }
                else if (viewPager$ItemInfo.position != itemPosition) {
                    if (viewPager$ItemInfo.position == this.mCurItem) {
                        n3 = itemPosition;
                    }
                    viewPager$ItemInfo.position = itemPosition;
                    b = true;
                }
            }
        }
        if (n4 != 0) {
            this.mAdapter.finishUpdate(this);
        }
        Collections.sort((List<Object>)this.mItems, ViewPager.COMPARATOR);
        if (b) {
            for (int childCount = this.getChildCount(), j = 0; j < childCount; ++j) {
                final ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)this.getChildAt(j).getLayoutParams();
                if (!viewPager$LayoutParams.isDecor) {
                    viewPager$LayoutParams.widthFactor = 0.0f;
                }
            }
            this.setCurrentItemInternal(n3, false, n2 != 0);
            this.requestLayout();
        }
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || this.executeKeyEvent(keyEvent);
    }
    
    public boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 0) {
                final ViewPager$ItemInfo infoForChild = this.infoForChild(child);
                if (infoForChild != null && infoForChild.position == this.mCurItem) {
                    if (child.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    float distanceInfluenceForSnapDuration(final float n) {
        final double n2 = n - 0.5f;
        Double.isNaN(n2);
        return (float)Math.sin((float)(n2 * 0.4712389167638204));
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        boolean b = false;
        final int overScrollMode = this.getOverScrollMode();
        Label_0376: {
            Label_0077: {
                if (overScrollMode != 0) {
                    final int n = 1;
                    if (overScrollMode == n) {
                        final PagerAdapter mAdapter = this.mAdapter;
                        if (mAdapter != null) {
                            if (mAdapter.getCount() > n) {
                                break Label_0077;
                            }
                        }
                    }
                    this.mLeftEdge.finish();
                    this.mRightEdge.finish();
                    break Label_0376;
                }
            }
            if (!this.mLeftEdge.isFinished()) {
                final int save = canvas.save();
                final int n2 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                final int width = this.getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float)(-n2 + this.getPaddingTop()), this.mFirstOffset * width);
                this.mLeftEdge.setSize(n2, width);
                b = (false | this.mLeftEdge.draw(canvas));
                canvas.restoreToCount(save);
            }
            if (!this.mRightEdge.isFinished()) {
                final int save2 = canvas.save();
                final int width2 = this.getWidth();
                final int n3 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float)(-this.getPaddingTop()), -(this.mLastOffset + 1.0f) * width2);
                this.mRightEdge.setSize(n3, width2);
                b |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (b) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final Drawable mMarginDrawable = this.mMarginDrawable;
        if (mMarginDrawable != null && mMarginDrawable.isStateful()) {
            mMarginDrawable.setState(this.getDrawableState());
        }
    }
    
    public void endFakeDrag() {
        if (this.mFakeDragging) {
            if (this.mAdapter != null) {
                final VelocityTracker mVelocityTracker = this.mVelocityTracker;
                mVelocityTracker.computeCurrentVelocity(1000, (float)this.mMaximumVelocity);
                final int n = (int)VelocityTrackerCompat.getXVelocity(mVelocityTracker, this.mActivePointerId);
                final boolean mPopulatePending = true;
                this.mPopulatePending = mPopulatePending;
                final int clientWidth = this.getClientWidth();
                final int scrollX = this.getScrollX();
                final ViewPager$ItemInfo infoForCurrentScrollPosition = this.infoForCurrentScrollPosition();
                this.setCurrentItemInternal(this.determineTargetPage(infoForCurrentScrollPosition.position, (scrollX / clientWidth - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor, n, (int)(this.mLastMotionX - this.mInitialMotionX)), mPopulatePending, mPopulatePending, n);
            }
            this.endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }
    
    public boolean executeKeyEvent(final KeyEvent keyEvent) {
        boolean b = false;
        if (keyEvent.getAction() == 0) {
            final int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                switch (keyCode) {
                    case 22: {
                        b = this.arrowScroll(66);
                        break;
                    }
                    case 21: {
                        b = this.arrowScroll(17);
                        break;
                    }
                }
            }
            else if (Build$VERSION.SDK_INT >= 11) {
                if (KeyEventCompat.hasNoModifiers(keyEvent)) {
                    b = this.arrowScroll(2);
                }
                else {
                    final int n = 1;
                    if (KeyEventCompat.hasModifiers(keyEvent, n)) {
                        b = this.arrowScroll(n);
                    }
                }
            }
        }
        return b;
    }
    
    public void fakeDragBy(final float n) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.mAdapter == null) {
            return;
        }
        this.mLastMotionX += n;
        float n2 = this.getScrollX() - n;
        final int clientWidth = this.getClientWidth();
        float n3 = clientWidth * this.mFirstOffset;
        float n4 = clientWidth * this.mLastOffset;
        final ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(0);
        final ArrayList mItems = this.mItems;
        final ViewPager$ItemInfo viewPager$ItemInfo2 = mItems.get(mItems.size() - 1);
        if (viewPager$ItemInfo.position != 0) {
            n3 = viewPager$ItemInfo.offset * clientWidth;
        }
        if (viewPager$ItemInfo2.position != this.mAdapter.getCount() - 1) {
            n4 = viewPager$ItemInfo2.offset * clientWidth;
        }
        if (n2 < n3) {
            n2 = n3;
        }
        else if (n2 > n4) {
            n2 = n4;
        }
        this.mLastMotionX += n2 - (int)n2;
        this.scrollTo((int)n2, this.getScrollY());
        this.pageScrolled((int)n2);
        final MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return new ViewPager$LayoutParams();
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return new ViewPager$LayoutParams(this.getContext(), set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return this.generateDefaultLayoutParams();
    }
    
    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }
    
    protected int getChildDrawingOrder(final int n, final int n2) {
        int n3;
        if (this.mDrawingOrder == 2) {
            n3 = n - 1 - n2;
        }
        else {
            n3 = n2;
        }
        return ((ViewPager$LayoutParams)((View)this.mDrawingOrderedChildren.get(n3)).getLayoutParams()).childIndex;
    }
    
    public int getCurrentItem() {
        return this.mCurItem;
    }
    
    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }
    
    public int getPageMargin() {
        return this.mPageMargin;
    }
    
    ViewPager$ItemInfo infoForAnyChild(View view) {
        while (true) {
            final ViewParent parent = view.getParent();
            if (parent == this) {
                return this.infoForChild(view);
            }
            if (parent == null || parent instanceof View) {
                return null;
            }
            view = (View)parent;
        }
    }
    
    ViewPager$ItemInfo infoForChild(final View view) {
        for (int i = 0; i < this.mItems.size(); ++i) {
            final ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(i);
            if (this.mAdapter.isViewFromObject(view, viewPager$ItemInfo.object)) {
                return viewPager$ItemInfo;
            }
        }
        return null;
    }
    
    ViewPager$ItemInfo infoForPosition(final int n) {
        for (int i = 0; i < this.mItems.size(); ++i) {
            final ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(i);
            if (viewPager$ItemInfo.position == n) {
                return viewPager$ItemInfo;
            }
        }
        return null;
    }
    
    void initViewPager() {
        this.setWillNotDraw(false);
        this.setDescendantFocusability(262144);
        final int focusable = 1;
        this.setFocusable((boolean)(focusable != 0));
        final Context context = this.getContext();
        this.mScroller = new Scroller(context, ViewPager.sInterpolator);
        final ViewConfiguration value = ViewConfiguration.get(context);
        final float density = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = value.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int)(400.0f * density);
        this.mMaximumVelocity = value.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffectCompat(context);
        this.mRightEdge = new EdgeEffectCompat(context);
        this.mFlingDistance = (int)(25.0f * density);
        this.mCloseEnough = (int)(2.0f * density);
        this.mDefaultGutterSize = (int)(16.0f * density);
        ViewCompat.setAccessibilityDelegate((View)this, new ViewPager$MyAccessibilityDelegate(this));
        if (ViewCompat.getImportantForAccessibility((View)this) == 0) {
            ViewCompat.setImportantForAccessibility((View)this, focusable);
        }
        ViewCompat.setOnApplyWindowInsetsListener((View)this, new ViewPager$4(this));
    }
    
    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }
    
    protected void onDetachedFromWindow() {
        this.removeCallbacks(this.mEndScrollRunnable);
        final Scroller mScroller = this.mScroller;
        if (mScroller != null && !mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }
    
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            final int scrollX = this.getScrollX();
            final int width = this.getWidth();
            float n = this.mPageMargin / width;
            int n2 = 0;
            ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(0);
            float offset = viewPager$ItemInfo.offset;
            final int size = this.mItems.size();
            final int position = viewPager$ItemInfo.position;
            float n5;
            for (int position2 = this.mItems.get(size - 1).position, i = position; i < position2; ++i, n = n5) {
                while (i > viewPager$ItemInfo.position && n2 < size) {
                    final ArrayList mItems = this.mItems;
                    ++n2;
                    viewPager$ItemInfo = mItems.get(n2);
                }
                float n3;
                if (i == viewPager$ItemInfo.position) {
                    n3 = (viewPager$ItemInfo.offset + viewPager$ItemInfo.widthFactor) * width;
                    offset = viewPager$ItemInfo.offset + viewPager$ItemInfo.widthFactor + n;
                }
                else {
                    final float pageWidth = this.mAdapter.getPageWidth(i);
                    final float n4 = (offset + pageWidth) * width;
                    offset += pageWidth + n;
                    n3 = n4;
                }
                if (this.mPageMargin + n3 > scrollX) {
                    final Drawable mMarginDrawable = this.mMarginDrawable;
                    final int round = Math.round(n3);
                    final int mTopPageBounds = this.mTopPageBounds;
                    final int round2 = Math.round(this.mPageMargin + n3);
                    n5 = n;
                    mMarginDrawable.setBounds(round, mTopPageBounds, round2, this.mBottomPageBounds);
                    this.mMarginDrawable.draw(canvas);
                }
                else {
                    n5 = n;
                }
                if (n3 > scrollX + width) {
                    break;
                }
            }
        }
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int n = motionEvent.getAction() & 0xFF;
        if (n != 3) {
            final int n2 = 1;
            if (n != n2) {
                if (n != 0) {
                    if (this.mIsBeingDragged) {
                        return n2 != 0;
                    }
                    if (this.mIsUnableToDrag) {
                        return false;
                    }
                }
                final int n3 = 2;
                if (n != 0) {
                    if (n != n3) {
                        if (n == 6) {
                            this.onSecondaryPointerUp(motionEvent);
                        }
                    }
                    else {
                        final int mActivePointerId = this.mActivePointerId;
                        if (mActivePointerId != -1) {
                            final int pointerIndex = motionEvent.findPointerIndex(mActivePointerId);
                            final float x = motionEvent.getX(pointerIndex);
                            final float n4 = x - this.mLastMotionX;
                            final float abs = Math.abs(n4);
                            final float y = motionEvent.getY(pointerIndex);
                            final float abs2 = Math.abs(y - this.mInitialMotionY);
                            float mLastMotionY;
                            if (n4 != 0.0f && !this.isGutterDrag(this.mLastMotionX, n4)) {
                                final int n5 = (int)n4;
                                final int n6 = (int)x;
                                final int n7 = (int)y;
                                mLastMotionY = y;
                                if (this.canScroll((View)this, false, n5, n6, n7)) {
                                    this.mLastMotionX = x;
                                    this.mLastMotionY = y;
                                    this.mIsUnableToDrag = (n2 != 0);
                                    return false;
                                }
                            }
                            else {
                                mLastMotionY = y;
                            }
                            if (abs > this.mTouchSlop && 0.5f * abs > abs2) {
                                this.requestParentDisallowInterceptTouchEvent(this.mIsBeingDragged = (n2 != 0));
                                this.setScrollState(n2);
                                float mLastMotionX;
                                if (n4 > 0.0f) {
                                    mLastMotionX = this.mInitialMotionX + this.mTouchSlop;
                                }
                                else {
                                    mLastMotionX = this.mInitialMotionX - this.mTouchSlop;
                                }
                                this.mLastMotionX = mLastMotionX;
                                this.mLastMotionY = mLastMotionY;
                                this.setScrollingCacheEnabled(n2 != 0);
                            }
                            else if (abs2 > this.mTouchSlop) {
                                this.mIsUnableToDrag = (n2 != 0);
                            }
                            if (this.mIsBeingDragged) {
                                if (this.performDrag(x)) {
                                    ViewCompat.postInvalidateOnAnimation((View)this);
                                }
                            }
                        }
                    }
                }
                else {
                    final float x2 = motionEvent.getX();
                    this.mInitialMotionX = x2;
                    this.mLastMotionX = x2;
                    final float y2 = motionEvent.getY();
                    this.mInitialMotionY = y2;
                    this.mLastMotionY = y2;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    this.mIsUnableToDrag = false;
                    this.mIsScrollStarted = (n2 != 0);
                    this.mScroller.computeScrollOffset();
                    if (this.mScrollState == n3 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
                        this.mScroller.abortAnimation();
                        this.mPopulatePending = false;
                        this.populate();
                        this.requestParentDisallowInterceptTouchEvent(this.mIsBeingDragged = (n2 != 0));
                        this.setScrollState(n2);
                    }
                    else {
                        this.completeScroll(false);
                        this.mIsBeingDragged = false;
                    }
                }
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.addMovement(motionEvent);
                return this.mIsBeingDragged;
            }
        }
        this.resetTouch();
        return false;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        int childCount = this.getChildCount();
        int n5 = n3 - n;
        final int n6 = n4 - n2;
        int paddingLeft = this.getPaddingLeft();
        int paddingTop = this.getPaddingTop();
        int paddingRight = this.getPaddingRight();
        int paddingBottom = this.getPaddingBottom();
        final int scrollX = this.getScrollX();
        int mDecorChildCount = 0;
        int n7 = 0;
        int n8;
        while (true) {
            n8 = 8;
            if (n7 >= childCount) {
                break;
            }
            final View child = this.getChildAt(n7);
            if (child.getVisibility() != n8) {
                final ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)child.getLayoutParams();
                if (viewPager$LayoutParams.isDecor) {
                    final int n9 = viewPager$LayoutParams.gravity & 0x7;
                    final int n10 = viewPager$LayoutParams.gravity & 0x70;
                    int max;
                    if (n9 != 1) {
                        if (n9 != 3) {
                            if (n9 != 5) {
                                max = paddingLeft;
                            }
                            else {
                                max = n5 - paddingRight - child.getMeasuredWidth();
                                paddingRight += child.getMeasuredWidth();
                            }
                        }
                        else {
                            max = paddingLeft;
                            paddingLeft += child.getMeasuredWidth();
                        }
                    }
                    else {
                        max = Math.max((n5 - child.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    final int n11 = paddingLeft;
                    int max2;
                    if (n10 != 16) {
                        if (n10 != 48) {
                            if (n10 != 80) {
                                max2 = paddingTop;
                            }
                            else {
                                max2 = n6 - paddingBottom - child.getMeasuredHeight();
                                paddingBottom += child.getMeasuredHeight();
                            }
                        }
                        else {
                            max2 = paddingTop;
                            paddingTop += child.getMeasuredHeight();
                        }
                    }
                    else {
                        max2 = Math.max((n6 - child.getMeasuredHeight()) / 2, paddingTop);
                    }
                    final int n12 = max + scrollX;
                    final int n13 = child.getMeasuredWidth() + n12;
                    final int measuredHeight = child.getMeasuredHeight();
                    final int n14 = paddingTop;
                    child.layout(n12, max2, n13, max2 + measuredHeight);
                    ++mDecorChildCount;
                    paddingLeft = n11;
                    paddingTop = n14;
                }
            }
            ++n7;
        }
        final int n15 = n5 - paddingLeft - paddingRight;
        int n17;
        int n21;
        int n25;
        for (int i = 0; i < childCount; ++i, childCount = n17, n5 = n21, paddingLeft = n25, n8 = 8) {
            final View child2 = this.getChildAt(i);
            if (child2.getVisibility() != n8) {
                final ViewPager$LayoutParams viewPager$LayoutParams2 = (ViewPager$LayoutParams)child2.getLayoutParams();
                if (!viewPager$LayoutParams2.isDecor) {
                    final ViewPager$ItemInfo infoForChild = this.infoForChild(child2);
                    if (infoForChild != null) {
                        final float n16 = n15;
                        n17 = childCount;
                        final int n18 = paddingLeft + (int)(n16 * infoForChild.offset);
                        final int n19 = paddingTop;
                        if (viewPager$LayoutParams2.needsMeasure) {
                            viewPager$LayoutParams2.needsMeasure = false;
                            final float n20 = n15;
                            n21 = n5;
                            final int n22 = (int)(n20 * viewPager$LayoutParams2.widthFactor);
                            final int n23 = 1073741824;
                            final int measureSpec = View$MeasureSpec.makeMeasureSpec(n22, n23);
                            final int n24 = n6 - paddingTop;
                            n25 = paddingLeft;
                            child2.measure(measureSpec, View$MeasureSpec.makeMeasureSpec(n24 - paddingBottom, n23));
                        }
                        else {
                            n21 = n5;
                            n25 = paddingLeft;
                        }
                        child2.layout(n18, n19, child2.getMeasuredWidth() + n18, child2.getMeasuredHeight() + n19);
                    }
                    else {
                        n21 = n5;
                        n25 = paddingLeft;
                        n17 = childCount;
                    }
                }
                else {
                    n17 = childCount;
                    n21 = n5;
                    n25 = paddingLeft;
                }
            }
            else {
                n17 = childCount;
                n21 = n5;
                n25 = paddingLeft;
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = n6 - paddingBottom;
        this.mDecorChildCount = mDecorChildCount;
        if (this.mFirstLayout) {
            this.scrollToItem(this.mCurItem, false, 0, false);
        }
        this.mFirstLayout = false;
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.setMeasuredDimension(getDefaultSize(0, n), getDefaultSize(0, n2));
        int measuredWidth = this.getMeasuredWidth();
        int n3 = measuredWidth / 10;
        this.mGutterSize = Math.min(n3, this.mDefaultGutterSize);
        int n4 = measuredWidth - this.getPaddingLeft() - this.getPaddingRight();
        int n5 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
        final int childCount = this.getChildCount();
        int n6 = 0;
        int n7;
        while (true) {
            n7 = 8;
            if (n6 >= childCount) {
                break;
            }
            final View child = this.getChildAt(n6);
            int n13;
            int n16;
            if (child.getVisibility() != n7) {
                final ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)child.getLayoutParams();
                if (viewPager$LayoutParams != null && viewPager$LayoutParams.isDecor) {
                    final int n8 = viewPager$LayoutParams.gravity & 0x7;
                    final int n9 = viewPager$LayoutParams.gravity & 0x70;
                    int n10 = -1 << -1;
                    int n11 = -1 << -1;
                    final boolean b = n9 == 48 || n9 == 80;
                    final boolean b2 = n8 == 3 || n8 == 5;
                    if (b) {
                        n10 = 1073741824;
                    }
                    else if (b2) {
                        n11 = 1073741824;
                    }
                    final int n12 = n5;
                    final int width = viewPager$LayoutParams.width;
                    n13 = measuredWidth;
                    int width2;
                    if (width != -2) {
                        n10 = 1073741824;
                        if (viewPager$LayoutParams.width != -1) {
                            width2 = viewPager$LayoutParams.width;
                        }
                        else {
                            width2 = n4;
                        }
                    }
                    else {
                        width2 = n4;
                    }
                    int height;
                    int n15;
                    if (viewPager$LayoutParams.height != -2) {
                        final int n14 = 1073741824;
                        if (viewPager$LayoutParams.height != -1) {
                            height = viewPager$LayoutParams.height;
                            n15 = n14;
                        }
                        else {
                            n15 = n14;
                            height = n12;
                        }
                    }
                    else {
                        n15 = n11;
                        height = n12;
                    }
                    n16 = n3;
                    child.measure(View$MeasureSpec.makeMeasureSpec(width2, n10), View$MeasureSpec.makeMeasureSpec(height, n15));
                    if (b) {
                        n5 -= child.getMeasuredHeight();
                    }
                    else if (b2) {
                        n4 -= child.getMeasuredWidth();
                    }
                }
                else {
                    n13 = measuredWidth;
                    n16 = n3;
                }
            }
            else {
                n13 = measuredWidth;
                n16 = n3;
            }
            ++n6;
            n3 = n16;
            measuredWidth = n13;
        }
        final int n17 = 1073741824;
        this.mChildWidthMeasureSpec = View$MeasureSpec.makeMeasureSpec(n4, n17);
        this.mChildHeightMeasureSpec = View$MeasureSpec.makeMeasureSpec(n5, n17);
        this.mInLayout = true;
        this.populate();
        this.mInLayout = false;
        for (int childCount2 = this.getChildCount(), i = 0; i < childCount2; ++i) {
            final View child2 = this.getChildAt(i);
            if (child2.getVisibility() != n7) {
                final ViewPager$LayoutParams viewPager$LayoutParams2 = (ViewPager$LayoutParams)child2.getLayoutParams();
                if (viewPager$LayoutParams2 == null || viewPager$LayoutParams2.isDecor) {
                    child2.measure(View$MeasureSpec.makeMeasureSpec((int)(n4 * viewPager$LayoutParams2.widthFactor), n17), this.mChildHeightMeasureSpec);
                }
            }
        }
    }
    
    protected void onPageScrolled(final int n, final float n2, final int n3) {
        final int mDecorChildCount = this.mDecorChildCount;
        final boolean mCalledSuper = true;
        if (mDecorChildCount > 0) {
            final int scrollX = this.getScrollX();
            int paddingLeft = this.getPaddingLeft();
            int paddingRight = this.getPaddingRight();
            final int width = this.getWidth();
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                final View child = this.getChildAt(i);
                final ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)child.getLayoutParams();
                if (viewPager$LayoutParams.isDecor) {
                    final int n4 = viewPager$LayoutParams.gravity & 0x7;
                    int max;
                    if (n4 != (mCalledSuper ? 1 : 0)) {
                        if (n4 != 3) {
                            if (n4 != 5) {
                                max = paddingLeft;
                            }
                            else {
                                max = width - paddingRight - child.getMeasuredWidth();
                                paddingRight += child.getMeasuredWidth();
                            }
                        }
                        else {
                            max = paddingLeft;
                            paddingLeft += child.getWidth();
                        }
                    }
                    else {
                        max = Math.max((width - child.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    final int n5 = max + scrollX - child.getLeft();
                    if (n5 != 0) {
                        child.offsetLeftAndRight(n5);
                    }
                }
            }
        }
        this.dispatchOnPageScrolled(n, n2, n3);
        if (this.mPageTransformer != null) {
            final int scrollX2 = this.getScrollX();
            for (int childCount2 = this.getChildCount(), j = 0; j < childCount2; ++j) {
                final View child2 = this.getChildAt(j);
                if (!((ViewPager$LayoutParams)child2.getLayoutParams()).isDecor) {
                    this.mPageTransformer.transformPage(child2, (child2.getLeft() - scrollX2) / this.getClientWidth());
                }
            }
        }
        this.mCalledSuper = mCalledSuper;
    }
    
    protected boolean onRequestFocusInDescendants(final int n, final Rect rect) {
        final int childCount = this.getChildCount();
        int n2;
        int n3;
        int n4;
        if ((n & 0x2) != 0x0) {
            n2 = 0;
            n3 = 1;
            n4 = childCount;
        }
        else {
            n2 = childCount - 1;
            n3 = -1;
            n4 = -1;
        }
        for (int i = n2; i != n4; i += n3) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 0) {
                final ViewPager$ItemInfo infoForChild = this.infoForChild(child);
                if (infoForChild != null && infoForChild.position == this.mCurItem) {
                    if (child.requestFocus(n, rect)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof ViewPager$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final ViewPager$SavedState viewPager$SavedState = (ViewPager$SavedState)parcelable;
        super.onRestoreInstanceState(viewPager$SavedState.getSuperState());
        final PagerAdapter mAdapter = this.mAdapter;
        if (mAdapter != null) {
            mAdapter.restoreState(viewPager$SavedState.adapterState, viewPager$SavedState.loader);
            this.setCurrentItemInternal(viewPager$SavedState.position, false, true);
        }
        else {
            this.mRestoredCurItem = viewPager$SavedState.position;
            this.mRestoredAdapterState = viewPager$SavedState.adapterState;
            this.mRestoredClassLoader = viewPager$SavedState.loader;
        }
    }
    
    public Parcelable onSaveInstanceState() {
        final ViewPager$SavedState viewPager$SavedState = new ViewPager$SavedState(super.onSaveInstanceState());
        viewPager$SavedState.position = this.mCurItem;
        final PagerAdapter mAdapter = this.mAdapter;
        if (mAdapter != null) {
            viewPager$SavedState.adapterState = mAdapter.saveState();
        }
        return (Parcelable)viewPager$SavedState;
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        if (n != n3) {
            final int mPageMargin = this.mPageMargin;
            this.recomputeScrollPosition(n, n3, mPageMargin, mPageMargin);
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final boolean mFakeDragging = this.mFakeDragging;
        final int n = 1;
        if (mFakeDragging) {
            return n != 0;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        final PagerAdapter mAdapter = this.mAdapter;
        if (mAdapter != null && mAdapter.getCount() != 0) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            final int action = motionEvent.getAction();
            boolean b = false;
            switch (action & 0xFF) {
                case 6: {
                    this.onSecondaryPointerUp(motionEvent);
                    this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                    break;
                }
                case 5: {
                    final int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    this.mLastMotionX = motionEvent.getX(actionIndex);
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                    break;
                }
                case 3: {
                    if (this.mIsBeingDragged) {
                        this.scrollToItem(this.mCurItem, n != 0, 0, false);
                        b = this.resetTouch();
                        break;
                    }
                    break;
                }
                case 2: {
                    if (!this.mIsBeingDragged) {
                        final int pointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (pointerIndex == -1) {
                            b = this.resetTouch();
                            break;
                        }
                        final float x = motionEvent.getX(pointerIndex);
                        final float abs = Math.abs(x - this.mLastMotionX);
                        final float y = motionEvent.getY(pointerIndex);
                        final float abs2 = Math.abs(y - this.mLastMotionY);
                        if (abs > this.mTouchSlop && abs > abs2) {
                            this.requestParentDisallowInterceptTouchEvent(this.mIsBeingDragged = (n != 0));
                            final float mInitialMotionX = this.mInitialMotionX;
                            float mLastMotionX;
                            if (x - mInitialMotionX > 0.0f) {
                                mLastMotionX = mInitialMotionX + this.mTouchSlop;
                            }
                            else {
                                mLastMotionX = mInitialMotionX - this.mTouchSlop;
                            }
                            this.mLastMotionX = mLastMotionX;
                            this.mLastMotionY = y;
                            this.setScrollState(n);
                            this.setScrollingCacheEnabled(n != 0);
                            final ViewParent parent = this.getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent((boolean)(n != 0));
                            }
                        }
                    }
                    if (this.mIsBeingDragged) {
                        b = (false | this.performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId))));
                        break;
                    }
                    break;
                }
                case 1: {
                    if (this.mIsBeingDragged) {
                        final VelocityTracker mVelocityTracker = this.mVelocityTracker;
                        mVelocityTracker.computeCurrentVelocity(1000, (float)this.mMaximumVelocity);
                        final int n2 = (int)VelocityTrackerCompat.getXVelocity(mVelocityTracker, this.mActivePointerId);
                        this.mPopulatePending = (n != 0);
                        final int clientWidth = this.getClientWidth();
                        final int scrollX = this.getScrollX();
                        final ViewPager$ItemInfo infoForCurrentScrollPosition = this.infoForCurrentScrollPosition();
                        this.setCurrentItemInternal(this.determineTargetPage(infoForCurrentScrollPosition.position, (scrollX / clientWidth - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + this.mPageMargin / clientWidth), n2, (int)(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), n != 0, n != 0, n2);
                        b = this.resetTouch();
                        break;
                    }
                    break;
                }
                case 0: {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    this.populate();
                    final float x2 = motionEvent.getX();
                    this.mInitialMotionX = x2;
                    this.mLastMotionX = x2;
                    final float y2 = motionEvent.getY();
                    this.mInitialMotionY = y2;
                    this.mLastMotionY = y2;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    break;
                }
            }
            if (b) {
                ViewCompat.postInvalidateOnAnimation((View)this);
            }
            return n != 0;
        }
        return false;
    }
    
    boolean pageLeft() {
        final int mCurItem = this.mCurItem;
        if (mCurItem > 0) {
            final int n = 1;
            this.setCurrentItem(mCurItem - n, n != 0);
            return n != 0;
        }
        return false;
    }
    
    boolean pageRight() {
        final PagerAdapter mAdapter = this.mAdapter;
        if (mAdapter != null) {
            final int mCurItem = this.mCurItem;
            final int count = mAdapter.getCount();
            final int n = 1;
            if (mCurItem < count - n) {
                this.setCurrentItem(this.mCurItem + n, n != 0);
                return n != 0;
            }
        }
        return false;
    }
    
    void populate() {
        this.populate(this.mCurItem);
    }
    
    void populate(final int mCurItem) {
        final int mCurItem2 = this.mCurItem;
        ViewPager$ItemInfo viewPager$ItemInfo;
        if (mCurItem2 != mCurItem) {
            final ViewPager$ItemInfo infoForPosition = this.infoForPosition(mCurItem2);
            this.mCurItem = mCurItem;
            viewPager$ItemInfo = infoForPosition;
        }
        else {
            viewPager$ItemInfo = null;
        }
        if (this.mAdapter == null) {
            this.sortChildDrawingOrder();
            return;
        }
        if (this.mPopulatePending) {
            this.sortChildDrawingOrder();
            return;
        }
        if (this.getWindowToken() == null) {
            return;
        }
        this.mAdapter.startUpdate(this);
        int mOffscreenPageLimit = this.mOffscreenPageLimit;
        int max = Math.max(0, this.mCurItem - mOffscreenPageLimit);
        final int count = this.mAdapter.getCount();
        final int min = Math.min(count - 1, this.mCurItem + mOffscreenPageLimit);
        if (count == this.mExpectedAdapterCount) {
            ViewPager$ItemInfo addNewItem = null;
            int i = 0;
            while (i < this.mItems.size()) {
                final ViewPager$ItemInfo viewPager$ItemInfo2 = this.mItems.get(i);
                if (viewPager$ItemInfo2.position >= this.mCurItem) {
                    if (viewPager$ItemInfo2.position == this.mCurItem) {
                        addNewItem = viewPager$ItemInfo2;
                        break;
                    }
                    break;
                }
                else {
                    ++i;
                }
            }
            if (addNewItem == null && count > 0) {
                addNewItem = this.addNewItem(this.mCurItem, i);
            }
            if (addNewItem != null) {
                float n = 0.0f;
                int n2 = i - 1;
                ViewPager$ItemInfo viewPager$ItemInfo3;
                if (n2 >= 0) {
                    viewPager$ItemInfo3 = this.mItems.get(n2);
                }
                else {
                    viewPager$ItemInfo3 = null;
                }
                final int clientWidth = this.getClientWidth();
                final float n3 = 2.0f;
                float n4;
                if (clientWidth <= 0) {
                    n4 = 0.0f;
                }
                else {
                    n4 = this.getPaddingLeft() / clientWidth + (n3 - addNewItem.widthFactor);
                }
                for (int j = this.mCurItem - 1; j >= 0; --j) {
                    if (n >= n4 && j < max) {
                        if (viewPager$ItemInfo3 == null) {
                            break;
                        }
                        if (j == viewPager$ItemInfo3.position && !viewPager$ItemInfo3.scrolling) {
                            this.mItems.remove(n2);
                            this.mAdapter.destroyItem(this, j, viewPager$ItemInfo3.object);
                            --n2;
                            --i;
                            ViewPager$ItemInfo viewPager$ItemInfo4;
                            if (n2 >= 0) {
                                viewPager$ItemInfo4 = this.mItems.get(n2);
                            }
                            else {
                                viewPager$ItemInfo4 = null;
                            }
                            viewPager$ItemInfo3 = viewPager$ItemInfo4;
                        }
                    }
                    else if (viewPager$ItemInfo3 != null && j == viewPager$ItemInfo3.position) {
                        n += viewPager$ItemInfo3.widthFactor;
                        --n2;
                        ViewPager$ItemInfo viewPager$ItemInfo5;
                        if (n2 >= 0) {
                            viewPager$ItemInfo5 = this.mItems.get(n2);
                        }
                        else {
                            viewPager$ItemInfo5 = null;
                        }
                        viewPager$ItemInfo3 = viewPager$ItemInfo5;
                    }
                    else {
                        n += this.addNewItem(j, n2 + 1).widthFactor;
                        ++i;
                        if (n2 >= 0) {
                            viewPager$ItemInfo3 = this.mItems.get(n2);
                        }
                        else {
                            viewPager$ItemInfo3 = null;
                        }
                    }
                }
                float widthFactor = addNewItem.widthFactor;
                int n5 = i + 1;
                if (widthFactor < 2.0f) {
                    ViewPager$ItemInfo viewPager$ItemInfo6;
                    if (n5 < this.mItems.size()) {
                        viewPager$ItemInfo6 = this.mItems.get(n5);
                    }
                    else {
                        viewPager$ItemInfo6 = null;
                    }
                    float n6;
                    if (clientWidth <= 0) {
                        n6 = 0.0f;
                    }
                    else {
                        n6 = this.getPaddingRight() / clientWidth + 2.0f;
                    }
                    int n7;
                    int n8;
                    for (int k = this.mCurItem + 1; k < count; ++k, mOffscreenPageLimit = n7, max = n8) {
                        if (widthFactor >= n6 && k > min) {
                            if (viewPager$ItemInfo6 == null) {
                                break;
                            }
                            n7 = mOffscreenPageLimit;
                            if (k == viewPager$ItemInfo6.position && !viewPager$ItemInfo6.scrolling) {
                                this.mItems.remove(n5);
                                final PagerAdapter mAdapter = this.mAdapter;
                                n8 = max;
                                mAdapter.destroyItem(this, k, viewPager$ItemInfo6.object);
                                ViewPager$ItemInfo viewPager$ItemInfo7;
                                if (n5 < this.mItems.size()) {
                                    viewPager$ItemInfo7 = this.mItems.get(n5);
                                }
                                else {
                                    viewPager$ItemInfo7 = null;
                                }
                                viewPager$ItemInfo6 = viewPager$ItemInfo7;
                            }
                            else {
                                n8 = max;
                            }
                        }
                        else {
                            n7 = mOffscreenPageLimit;
                            n8 = max;
                            if (viewPager$ItemInfo6 != null && k == viewPager$ItemInfo6.position) {
                                widthFactor += viewPager$ItemInfo6.widthFactor;
                                ++n5;
                                ViewPager$ItemInfo viewPager$ItemInfo8;
                                if (n5 < this.mItems.size()) {
                                    viewPager$ItemInfo8 = this.mItems.get(n5);
                                }
                                else {
                                    viewPager$ItemInfo8 = null;
                                }
                                viewPager$ItemInfo6 = viewPager$ItemInfo8;
                            }
                            else {
                                final ViewPager$ItemInfo addNewItem2 = this.addNewItem(k, n5);
                                ++n5;
                                widthFactor += addNewItem2.widthFactor;
                                ViewPager$ItemInfo viewPager$ItemInfo9;
                                if (n5 < this.mItems.size()) {
                                    viewPager$ItemInfo9 = this.mItems.get(n5);
                                }
                                else {
                                    viewPager$ItemInfo9 = null;
                                }
                                viewPager$ItemInfo6 = viewPager$ItemInfo9;
                            }
                        }
                    }
                }
                this.calculatePageOffsets(addNewItem, i, viewPager$ItemInfo);
            }
            final PagerAdapter mAdapter2 = this.mAdapter;
            final int mCurItem3 = this.mCurItem;
            Object object;
            if (addNewItem != null) {
                object = addNewItem.object;
            }
            else {
                object = null;
            }
            mAdapter2.setPrimaryItem(this, mCurItem3, object);
            this.mAdapter.finishUpdate(this);
            for (int childCount = this.getChildCount(), l = 0; l < childCount; ++l) {
                final View child = this.getChildAt(l);
                final ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)child.getLayoutParams();
                viewPager$LayoutParams.childIndex = l;
                if (!viewPager$LayoutParams.isDecor) {
                    if (viewPager$LayoutParams.widthFactor == 0.0f) {
                        final ViewPager$ItemInfo infoForChild = this.infoForChild(child);
                        if (infoForChild != null) {
                            viewPager$LayoutParams.widthFactor = infoForChild.widthFactor;
                            viewPager$LayoutParams.position = infoForChild.position;
                        }
                    }
                }
            }
            this.sortChildDrawingOrder();
            if (this.hasFocus()) {
                final View focus = this.findFocus();
                ViewPager$ItemInfo infoForAnyChild;
                if (focus != null) {
                    infoForAnyChild = this.infoForAnyChild(focus);
                }
                else {
                    infoForAnyChild = null;
                }
                if (infoForAnyChild == null || infoForAnyChild.position != this.mCurItem) {
                    for (int n9 = 0; n9 < this.getChildCount(); ++n9) {
                        final View child2 = this.getChildAt(n9);
                        final ViewPager$ItemInfo infoForChild2 = this.infoForChild(child2);
                        if (infoForChild2 != null && infoForChild2.position == this.mCurItem && child2.requestFocus(2)) {
                            break;
                        }
                    }
                }
            }
            return;
        }
        String s = null;
        try {
            final Resources resources = this.getResources();
            try {
                s = resources.getResourceName(this.getId());
            }
            catch (Resources$NotFoundException ex) {
                s = Integer.toHexString(this.getId());
            }
        }
        catch (Resources$NotFoundException ex2) {}
        final StringBuilder sb = new StringBuilder();
        sb.append("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
        sb.append(this.mExpectedAdapterCount);
        sb.append(", found: ");
        sb.append(count);
        sb.append(" Pager id: ");
        sb.append(s);
        sb.append(" Pager class: ");
        sb.append(this.getClass());
        sb.append(" Problematic adapter: ");
        sb.append(this.mAdapter.getClass());
        throw new IllegalStateException(sb.toString());
    }
    
    public void removeOnAdapterChangeListener(final ViewPager$OnAdapterChangeListener viewPager$OnAdapterChangeListener) {
        final List mAdapterChangeListeners = this.mAdapterChangeListeners;
        if (mAdapterChangeListeners != null) {
            mAdapterChangeListeners.remove(viewPager$OnAdapterChangeListener);
        }
    }
    
    public void removeOnPageChangeListener(final ViewPager$OnPageChangeListener viewPager$OnPageChangeListener) {
        final List mOnPageChangeListeners = this.mOnPageChangeListeners;
        if (mOnPageChangeListeners != null) {
            mOnPageChangeListeners.remove(viewPager$OnPageChangeListener);
        }
    }
    
    public void removeView(final View view) {
        if (this.mInLayout) {
            this.removeViewInLayout(view);
        }
        else {
            super.removeView(view);
        }
    }
    
    public void setAdapter(final PagerAdapter mAdapter) {
        final PagerAdapter mAdapter2 = this.mAdapter;
        if (mAdapter2 != null) {
            mAdapter2.setViewPagerObserver(null);
            this.mAdapter.startUpdate(this);
            for (int i = 0; i < this.mItems.size(); ++i) {
                final ViewPager$ItemInfo viewPager$ItemInfo = this.mItems.get(i);
                this.mAdapter.destroyItem(this, viewPager$ItemInfo.position, viewPager$ItemInfo.object);
            }
            this.mAdapter.finishUpdate(this);
            this.mItems.clear();
            this.removeNonDecorViews();
            this.scrollTo(this.mCurItem = 0, 0);
        }
        final PagerAdapter mAdapter3 = this.mAdapter;
        this.mAdapter = mAdapter;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new ViewPager$PagerObserver(this);
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            final boolean mFirstLayout = this.mFirstLayout;
            final boolean mFirstLayout2 = true;
            this.mFirstLayout = mFirstLayout2;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                this.setCurrentItemInternal(this.mRestoredCurItem, false, mFirstLayout2);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            }
            else if (!mFirstLayout) {
                this.populate();
            }
            else {
                this.requestLayout();
            }
        }
        final List mAdapterChangeListeners = this.mAdapterChangeListeners;
        if (mAdapterChangeListeners != null && !mAdapterChangeListeners.isEmpty()) {
            for (int j = 0; j < this.mAdapterChangeListeners.size(); ++j) {
                ((ViewPager$OnAdapterChangeListener)this.mAdapterChangeListeners.get(j)).onAdapterChanged(this, mAdapter3, mAdapter);
            }
        }
    }
    
    void setChildrenDrawingOrderEnabledCompat(final boolean b) {
        if (Build$VERSION.SDK_INT >= 7) {
            final Method mSetChildrenDrawingOrderEnabled = this.mSetChildrenDrawingOrderEnabled;
            final int n = 1;
            if (mSetChildrenDrawingOrderEnabled == null) {
                final Class<ViewGroup> clazz = ViewGroup.class;
                final String s = "setChildrenDrawingOrderEnabled";
                try {
                    final Class[] array = new Class[n];
                    try {
                        array[0] = Boolean.TYPE;
                        this.mSetChildrenDrawingOrderEnabled = clazz.getDeclaredMethod(s, (Class[])array);
                    }
                    catch (NoSuchMethodException ex) {
                        Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", (Throwable)ex);
                    }
                }
                catch (NoSuchMethodException ex3) {}
            }
            try {
                final Method mSetChildrenDrawingOrderEnabled2 = this.mSetChildrenDrawingOrderEnabled;
                try {
                    final Object[] array2 = new Object[n];
                    try {
                        array2[0] = b;
                        mSetChildrenDrawingOrderEnabled2.invoke(this, array2);
                    }
                    catch (Exception ex2) {
                        Log.e("ViewPager", "Error changing children drawing order", (Throwable)ex2);
                    }
                }
                catch (Exception ex4) {}
            }
            catch (Exception ex5) {}
        }
    }
    
    public void setCurrentItem(final int n) {
        this.mPopulatePending = false;
        this.setCurrentItemInternal(n, this.mFirstLayout ^ true, false);
    }
    
    public void setCurrentItem(final int n, final boolean b) {
        this.setCurrentItemInternal(n, b, this.mPopulatePending = false);
    }
    
    void setCurrentItemInternal(final int n, final boolean b, final boolean b2) {
        this.setCurrentItemInternal(n, b, b2, 0);
    }
    
    void setCurrentItemInternal(int mCurItem, final boolean b, final boolean b2, final int n) {
        final PagerAdapter mAdapter = this.mAdapter;
        if (mAdapter == null || mAdapter.getCount() <= 0) {
            this.setScrollingCacheEnabled(false);
            return;
        }
        if (!b2 && this.mCurItem == mCurItem && this.mItems.size() != 0) {
            this.setScrollingCacheEnabled(false);
            return;
        }
        boolean scrolling = true;
        if (mCurItem < 0) {
            mCurItem = 0;
        }
        else if (mCurItem >= this.mAdapter.getCount()) {
            mCurItem = this.mAdapter.getCount() - 1;
        }
        final int mOffscreenPageLimit = this.mOffscreenPageLimit;
        final int mCurItem2 = this.mCurItem;
        if (mCurItem > mCurItem2 + mOffscreenPageLimit || mCurItem < mCurItem2 - mOffscreenPageLimit) {
            for (int i = 0; i < this.mItems.size(); ++i) {
                ((ViewPager$ItemInfo)this.mItems.get(i)).scrolling = scrolling;
            }
        }
        if (this.mCurItem == mCurItem) {
            scrolling = false;
        }
        if (this.mFirstLayout) {
            this.mCurItem = mCurItem;
            if (scrolling) {
                this.dispatchOnPageSelected(mCurItem);
            }
            this.requestLayout();
        }
        else {
            this.populate(mCurItem);
            this.scrollToItem(mCurItem, b, n, scrolling);
        }
    }
    
    ViewPager$OnPageChangeListener setInternalPageChangeListener(final ViewPager$OnPageChangeListener mInternalPageChangeListener) {
        final ViewPager$OnPageChangeListener mInternalPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = mInternalPageChangeListener;
        return mInternalPageChangeListener2;
    }
    
    public void setOffscreenPageLimit(int mOffscreenPageLimit) {
        final int n = 1;
        if (mOffscreenPageLimit < n) {
            final String s = "ViewPager";
            final StringBuilder sb = new StringBuilder();
            sb.append("Requested offscreen page limit ");
            sb.append(mOffscreenPageLimit);
            sb.append(" too small; defaulting to ");
            sb.append(n);
            Log.w(s, sb.toString());
            mOffscreenPageLimit = 1;
        }
        if (mOffscreenPageLimit != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = mOffscreenPageLimit;
            this.populate();
        }
    }
    
    public void setOnPageChangeListener(final ViewPager$OnPageChangeListener mOnPageChangeListener) {
        this.mOnPageChangeListener = mOnPageChangeListener;
    }
    
    public void setPageMargin(final int mPageMargin) {
        final int mPageMargin2 = this.mPageMargin;
        this.mPageMargin = mPageMargin;
        final int width = this.getWidth();
        this.recomputeScrollPosition(width, width, mPageMargin, mPageMargin2);
        this.requestLayout();
    }
    
    public void setPageMarginDrawable(final int n) {
        this.setPageMarginDrawable(ContextCompat.getDrawable(this.getContext(), n));
    }
    
    public void setPageMarginDrawable(final Drawable mMarginDrawable) {
        this.mMarginDrawable = mMarginDrawable;
        if (mMarginDrawable != null) {
            this.refreshDrawableState();
        }
        this.setWillNotDraw(mMarginDrawable == null);
        this.invalidate();
    }
    
    public void setPageTransformer(final boolean b, final ViewPager$PageTransformer viewPager$PageTransformer) {
        this.setPageTransformer(b, viewPager$PageTransformer, 2);
    }
    
    public void setPageTransformer(final boolean b, final ViewPager$PageTransformer mPageTransformer, final int mPageTransformerLayerType) {
        if (Build$VERSION.SDK_INT >= 11) {
            int mDrawingOrder = 1;
            final boolean childrenDrawingOrderEnabledCompat = mPageTransformer != null;
            final boolean b2 = childrenDrawingOrderEnabledCompat != (this.mPageTransformer != null);
            this.mPageTransformer = mPageTransformer;
            this.setChildrenDrawingOrderEnabledCompat(childrenDrawingOrderEnabledCompat);
            if (childrenDrawingOrderEnabledCompat) {
                if (b) {
                    mDrawingOrder = 2;
                }
                this.mDrawingOrder = mDrawingOrder;
                this.mPageTransformerLayerType = mPageTransformerLayerType;
            }
            else {
                this.mDrawingOrder = 0;
            }
            if (b2) {
                this.populate();
            }
        }
    }
    
    void setScrollState(final int mScrollState) {
        if (this.mScrollState == mScrollState) {
            return;
        }
        this.mScrollState = mScrollState;
        if (this.mPageTransformer != null) {
            this.enableLayers(mScrollState != 0);
        }
        this.dispatchOnScrollStateChanged(mScrollState);
    }
    
    void smoothScrollTo(final int n, final int n2) {
        this.smoothScrollTo(n, n2, 0);
    }
    
    void smoothScrollTo(final int n, final int n2, final int n3) {
        if (this.getChildCount() == 0) {
            this.setScrollingCacheEnabled(false);
            return;
        }
        final Scroller mScroller = this.mScroller;
        final boolean scrollingCacheEnabled = true;
        int n4;
        if (mScroller != null && !mScroller.isFinished()) {
            if (this.mIsScrollStarted) {
                n4 = this.mScroller.getCurrX();
            }
            else {
                n4 = this.mScroller.getStartX();
            }
            this.mScroller.abortAnimation();
            this.setScrollingCacheEnabled(false);
        }
        else {
            n4 = this.getScrollX();
        }
        final int scrollY = this.getScrollY();
        final int n5 = n - n4;
        final int n6 = n2 - scrollY;
        if (n5 == 0 && n6 == 0) {
            this.completeScroll(false);
            this.populate();
            this.setScrollState(0);
            return;
        }
        this.setScrollingCacheEnabled(scrollingCacheEnabled);
        this.setScrollState(2);
        final int clientWidth = this.getClientWidth();
        final int n7 = clientWidth / 2;
        final float n8 = Math.abs(n5);
        final float n9 = 1.0f;
        final float n10 = n7 + n7 * this.distanceInfluenceForSnapDuration(Math.min(n9, n8 * n9 / clientWidth));
        final int abs = Math.abs(n3);
        int n11;
        if (abs > 0) {
            n11 = Math.round(Math.abs(n10 / abs) * 1000.0f) * 4;
        }
        else {
            n11 = (int)((n9 + Math.abs(n5) / (this.mPageMargin + clientWidth * this.mAdapter.getPageWidth(this.mCurItem))) * 100.0f);
        }
        final int min = Math.min(n11, 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(n4, scrollY, n5, n6, min);
        ViewCompat.postInvalidateOnAnimation((View)this);
    }
    
    protected boolean verifyDrawable(final Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }
}
