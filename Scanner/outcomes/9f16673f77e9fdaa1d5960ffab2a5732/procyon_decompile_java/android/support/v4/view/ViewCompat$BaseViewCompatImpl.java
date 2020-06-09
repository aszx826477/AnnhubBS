// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.graphics.Paint;
import java.lang.reflect.InvocationTargetException;
import android.view.ViewGroup;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.accessibility.AccessibilityEvent;
import android.view.ViewParent;
import android.graphics.Matrix;
import android.view.Display;
import android.graphics.Rect;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.util.Log;
import android.view.View;
import java.util.WeakHashMap;
import java.lang.reflect.Method;

class ViewCompat$BaseViewCompatImpl implements ViewCompat$ViewCompatImpl
{
    private static Method sChildrenDrawingOrderMethod;
    private Method mDispatchFinishTemporaryDetach;
    private Method mDispatchStartTemporaryDetach;
    private boolean mTempDetachBound;
    WeakHashMap mViewPropertyAnimatorCompatMap;
    
    ViewCompat$BaseViewCompatImpl() {
        this.mViewPropertyAnimatorCompatMap = null;
    }
    
    private void bindTempDetach() {
        final Class<View> clazz = View.class;
        final String s = "dispatchStartTemporaryDetach";
        try {
            this.mDispatchStartTemporaryDetach = clazz.getDeclaredMethod(s, (Class[])new Class[0]);
            this.mDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", (Class<?>[])new Class[0]);
        }
        catch (NoSuchMethodException ex) {
            Log.e("ViewCompat", "Couldn't find method", (Throwable)ex);
        }
        this.mTempDetachBound = true;
    }
    
    private boolean canScrollingViewScrollHorizontally(final ScrollingView scrollingView, final int n) {
        final int computeHorizontalScrollOffset = scrollingView.computeHorizontalScrollOffset();
        final int n2 = scrollingView.computeHorizontalScrollRange() - scrollingView.computeHorizontalScrollExtent();
        boolean b = false;
        if (n2 == 0) {
            return false;
        }
        if (n < 0) {
            if (computeHorizontalScrollOffset > 0) {
                b = true;
            }
            return b;
        }
        if (computeHorizontalScrollOffset < n2 - 1) {
            b = true;
        }
        return b;
    }
    
    private boolean canScrollingViewScrollVertically(final ScrollingView scrollingView, final int n) {
        final int computeVerticalScrollOffset = scrollingView.computeVerticalScrollOffset();
        final int n2 = scrollingView.computeVerticalScrollRange() - scrollingView.computeVerticalScrollExtent();
        boolean b = false;
        if (n2 == 0) {
            return false;
        }
        if (n < 0) {
            if (computeVerticalScrollOffset > 0) {
                b = true;
            }
            return b;
        }
        if (computeVerticalScrollOffset < n2 - 1) {
            b = true;
        }
        return b;
    }
    
    public ViewPropertyAnimatorCompat animate(final View view) {
        return new ViewPropertyAnimatorCompat(view);
    }
    
    public boolean canScrollHorizontally(final View view, final int n) {
        return view instanceof ScrollingView && this.canScrollingViewScrollHorizontally((ScrollingView)view, n);
    }
    
    public boolean canScrollVertically(final View view, final int n) {
        return view instanceof ScrollingView && this.canScrollingViewScrollVertically((ScrollingView)view, n);
    }
    
    public int combineMeasuredStates(final int n, final int n2) {
        return n | n2;
    }
    
    public WindowInsetsCompat dispatchApplyWindowInsets(final View view, final WindowInsetsCompat windowInsetsCompat) {
        return windowInsetsCompat;
    }
    
    public void dispatchFinishTemporaryDetach(final View view) {
        if (!this.mTempDetachBound) {
            this.bindTempDetach();
        }
        final Method mDispatchFinishTemporaryDetach = this.mDispatchFinishTemporaryDetach;
        if (mDispatchFinishTemporaryDetach != null) {
            try {
                mDispatchFinishTemporaryDetach.invoke(view, new Object[0]);
            }
            catch (Exception ex) {
                Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", (Throwable)ex);
            }
        }
        else {
            view.onFinishTemporaryDetach();
        }
    }
    
    public boolean dispatchNestedFling(final View view, final float n, final float n2, final boolean b) {
        return view instanceof NestedScrollingChild && ((NestedScrollingChild)view).dispatchNestedFling(n, n2, b);
    }
    
    public boolean dispatchNestedPreFling(final View view, final float n, final float n2) {
        return view instanceof NestedScrollingChild && ((NestedScrollingChild)view).dispatchNestedPreFling(n, n2);
    }
    
    public boolean dispatchNestedPreScroll(final View view, final int n, final int n2, final int[] array, final int[] array2) {
        return view instanceof NestedScrollingChild && ((NestedScrollingChild)view).dispatchNestedPreScroll(n, n2, array, array2);
    }
    
    public boolean dispatchNestedScroll(final View view, final int n, final int n2, final int n3, final int n4, final int[] array) {
        return view instanceof NestedScrollingChild && ((NestedScrollingChild)view).dispatchNestedScroll(n, n2, n3, n4, array);
    }
    
    public void dispatchStartTemporaryDetach(final View view) {
        if (!this.mTempDetachBound) {
            this.bindTempDetach();
        }
        final Method mDispatchStartTemporaryDetach = this.mDispatchStartTemporaryDetach;
        if (mDispatchStartTemporaryDetach != null) {
            try {
                mDispatchStartTemporaryDetach.invoke(view, new Object[0]);
            }
            catch (Exception ex) {
                Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", (Throwable)ex);
            }
        }
        else {
            view.onStartTemporaryDetach();
        }
    }
    
    public int getAccessibilityLiveRegion(final View view) {
        return 0;
    }
    
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(final View view) {
        return null;
    }
    
    public float getAlpha(final View view) {
        return 1.0f;
    }
    
    public ColorStateList getBackgroundTintList(final View view) {
        return ViewCompatBase.getBackgroundTintList(view);
    }
    
    public PorterDuff$Mode getBackgroundTintMode(final View view) {
        return ViewCompatBase.getBackgroundTintMode(view);
    }
    
    public Rect getClipBounds(final View view) {
        return null;
    }
    
    public Display getDisplay(final View view) {
        return ViewCompatBase.getDisplay(view);
    }
    
    public float getElevation(final View view) {
        return 0.0f;
    }
    
    public boolean getFitsSystemWindows(final View view) {
        return false;
    }
    
    long getFrameTime() {
        return 10;
    }
    
    public int getImportantForAccessibility(final View view) {
        return 0;
    }
    
    public int getLabelFor(final View view) {
        return 0;
    }
    
    public int getLayerType(final View view) {
        return 0;
    }
    
    public int getLayoutDirection(final View view) {
        return 0;
    }
    
    public Matrix getMatrix(final View view) {
        return null;
    }
    
    public int getMeasuredHeightAndState(final View view) {
        return view.getMeasuredHeight();
    }
    
    public int getMeasuredState(final View view) {
        return 0;
    }
    
    public int getMeasuredWidthAndState(final View view) {
        return view.getMeasuredWidth();
    }
    
    public int getMinimumHeight(final View view) {
        return ViewCompatBase.getMinimumHeight(view);
    }
    
    public int getMinimumWidth(final View view) {
        return ViewCompatBase.getMinimumWidth(view);
    }
    
    public int getPaddingEnd(final View view) {
        return view.getPaddingRight();
    }
    
    public int getPaddingStart(final View view) {
        return view.getPaddingLeft();
    }
    
    public ViewParent getParentForAccessibility(final View view) {
        return view.getParent();
    }
    
    public float getPivotX(final View view) {
        return 0.0f;
    }
    
    public float getPivotY(final View view) {
        return 0.0f;
    }
    
    public float getRotation(final View view) {
        return 0.0f;
    }
    
    public float getRotationX(final View view) {
        return 0.0f;
    }
    
    public float getRotationY(final View view) {
        return 0.0f;
    }
    
    public float getScaleX(final View view) {
        return 0.0f;
    }
    
    public float getScaleY(final View view) {
        return 0.0f;
    }
    
    public int getScrollIndicators(final View view) {
        return 0;
    }
    
    public String getTransitionName(final View view) {
        return null;
    }
    
    public float getTranslationX(final View view) {
        return 0.0f;
    }
    
    public float getTranslationY(final View view) {
        return 0.0f;
    }
    
    public float getTranslationZ(final View view) {
        return 0.0f;
    }
    
    public int getWindowSystemUiVisibility(final View view) {
        return 0;
    }
    
    public float getX(final View view) {
        return view.getLeft();
    }
    
    public float getY(final View view) {
        return view.getTop();
    }
    
    public float getZ(final View view) {
        return this.getTranslationZ(view) + this.getElevation(view);
    }
    
    public boolean hasAccessibilityDelegate(final View view) {
        return false;
    }
    
    public boolean hasNestedScrollingParent(final View view) {
        return view instanceof NestedScrollingChild && ((NestedScrollingChild)view).hasNestedScrollingParent();
    }
    
    public boolean hasOnClickListeners(final View view) {
        return false;
    }
    
    public boolean hasOverlappingRendering(final View view) {
        return true;
    }
    
    public boolean hasTransientState(final View view) {
        return false;
    }
    
    public boolean isAttachedToWindow(final View view) {
        return ViewCompatBase.isAttachedToWindow(view);
    }
    
    public boolean isImportantForAccessibility(final View view) {
        return true;
    }
    
    public boolean isInLayout(final View view) {
        return false;
    }
    
    public boolean isLaidOut(final View view) {
        return ViewCompatBase.isLaidOut(view);
    }
    
    public boolean isLayoutDirectionResolved(final View view) {
        return false;
    }
    
    public boolean isNestedScrollingEnabled(final View view) {
        return view instanceof NestedScrollingChild && ((NestedScrollingChild)view).isNestedScrollingEnabled();
    }
    
    public boolean isPaddingRelative(final View view) {
        return false;
    }
    
    public void jumpDrawablesToCurrentState(final View view) {
    }
    
    public void offsetLeftAndRight(final View view, final int n) {
        ViewCompatBase.offsetLeftAndRight(view, n);
    }
    
    public void offsetTopAndBottom(final View view, final int n) {
        ViewCompatBase.offsetTopAndBottom(view, n);
    }
    
    public WindowInsetsCompat onApplyWindowInsets(final View view, final WindowInsetsCompat windowInsetsCompat) {
        return windowInsetsCompat;
    }
    
    public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
    }
    
    public void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }
    
    public void onPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
    }
    
    public boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
        return false;
    }
    
    public void postInvalidateOnAnimation(final View view) {
        view.invalidate();
    }
    
    public void postInvalidateOnAnimation(final View view, final int n, final int n2, final int n3, final int n4) {
        view.invalidate(n, n2, n3, n4);
    }
    
    public void postOnAnimation(final View view, final Runnable runnable) {
        view.postDelayed(runnable, this.getFrameTime());
    }
    
    public void postOnAnimationDelayed(final View view, final Runnable runnable, final long n) {
        view.postDelayed(runnable, this.getFrameTime() + n);
    }
    
    public void requestApplyInsets(final View view) {
    }
    
    public int resolveSizeAndState(final int n, final int n2, final int n3) {
        return View.resolveSize(n, n2);
    }
    
    public void setAccessibilityDelegate(final View view, final AccessibilityDelegateCompat accessibilityDelegateCompat) {
    }
    
    public void setAccessibilityLiveRegion(final View view, final int n) {
    }
    
    public void setActivated(final View view, final boolean b) {
    }
    
    public void setAlpha(final View view, final float n) {
    }
    
    public void setBackground(final View view, final Drawable backgroundDrawable) {
        view.setBackgroundDrawable(backgroundDrawable);
    }
    
    public void setBackgroundTintList(final View view, final ColorStateList list) {
        ViewCompatBase.setBackgroundTintList(view, list);
    }
    
    public void setBackgroundTintMode(final View view, final PorterDuff$Mode porterDuff$Mode) {
        ViewCompatBase.setBackgroundTintMode(view, porterDuff$Mode);
    }
    
    public void setChildrenDrawingOrderEnabled(final ViewGroup viewGroup, final boolean b) {
        final Method sChildrenDrawingOrderMethod = ViewCompat$BaseViewCompatImpl.sChildrenDrawingOrderMethod;
        final int accessible = 1;
        if (sChildrenDrawingOrderMethod == null) {
            final Class<ViewGroup> clazz = ViewGroup.class;
            final String s = "setChildrenDrawingOrderEnabled";
            try {
                final Class[] array = new Class[accessible];
                try {
                    array[0] = Boolean.TYPE;
                    final Method declaredMethod = clazz.getDeclaredMethod(s, (Class[])array);
                    try {
                        ViewCompat$BaseViewCompatImpl.sChildrenDrawingOrderMethod = declaredMethod;
                    }
                    catch (NoSuchMethodException ex) {
                        Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", (Throwable)ex);
                    }
                }
                catch (NoSuchMethodException ex5) {}
            }
            catch (NoSuchMethodException ex6) {}
            ViewCompat$BaseViewCompatImpl.sChildrenDrawingOrderMethod.setAccessible(accessible != 0);
        }
        try {
            final Method sChildrenDrawingOrderMethod2 = ViewCompat$BaseViewCompatImpl.sChildrenDrawingOrderMethod;
            try {
                final Object[] array2 = new Object[accessible];
                try {
                    array2[0] = b;
                    sChildrenDrawingOrderMethod2.invoke(viewGroup, array2);
                }
                catch (InvocationTargetException ex2) {
                    Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", (Throwable)ex2);
                }
                catch (IllegalArgumentException ex3) {
                    Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", (Throwable)ex3);
                }
                catch (IllegalAccessException ex4) {
                    Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", (Throwable)ex4);
                }
            }
            catch (InvocationTargetException ex7) {}
            catch (IllegalArgumentException ex8) {}
            catch (IllegalAccessException ex9) {}
        }
        catch (InvocationTargetException ex10) {}
        catch (IllegalArgumentException ex11) {}
        catch (IllegalAccessException ex12) {}
    }
    
    public void setClipBounds(final View view, final Rect rect) {
    }
    
    public void setElevation(final View view, final float n) {
    }
    
    public void setFitsSystemWindows(final View view, final boolean b) {
    }
    
    public void setHasTransientState(final View view, final boolean b) {
    }
    
    public void setImportantForAccessibility(final View view, final int n) {
    }
    
    public void setLabelFor(final View view, final int n) {
    }
    
    public void setLayerPaint(final View view, final Paint paint) {
    }
    
    public void setLayerType(final View view, final int n, final Paint paint) {
    }
    
    public void setLayoutDirection(final View view, final int n) {
    }
    
    public void setNestedScrollingEnabled(final View view, final boolean nestedScrollingEnabled) {
        if (view instanceof NestedScrollingChild) {
            ((NestedScrollingChild)view).setNestedScrollingEnabled(nestedScrollingEnabled);
        }
    }
    
    public void setOnApplyWindowInsetsListener(final View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
    }
    
    public void setPaddingRelative(final View view, final int n, final int n2, final int n3, final int n4) {
        view.setPadding(n, n2, n3, n4);
    }
    
    public void setPivotX(final View view, final float n) {
    }
    
    public void setPivotY(final View view, final float n) {
    }
    
    public void setPointerIcon(final View view, final PointerIconCompat pointerIconCompat) {
    }
    
    public void setRotation(final View view, final float n) {
    }
    
    public void setRotationX(final View view, final float n) {
    }
    
    public void setRotationY(final View view, final float n) {
    }
    
    public void setSaveFromParentEnabled(final View view, final boolean b) {
    }
    
    public void setScaleX(final View view, final float n) {
    }
    
    public void setScaleY(final View view, final float n) {
    }
    
    public void setScrollIndicators(final View view, final int n) {
    }
    
    public void setScrollIndicators(final View view, final int n, final int n2) {
    }
    
    public void setTransitionName(final View view, final String s) {
    }
    
    public void setTranslationX(final View view, final float n) {
    }
    
    public void setTranslationY(final View view, final float n) {
    }
    
    public void setTranslationZ(final View view, final float n) {
    }
    
    public void setX(final View view, final float n) {
    }
    
    public void setY(final View view, final float n) {
    }
    
    public void setZ(final View view, final float n) {
    }
    
    public boolean startNestedScroll(final View view, final int n) {
        return view instanceof NestedScrollingChild && ((NestedScrollingChild)view).startNestedScroll(n);
    }
    
    public void stopNestedScroll(final View view) {
        if (view instanceof NestedScrollingChild) {
            ((NestedScrollingChild)view).stopNestedScroll();
        }
    }
}
