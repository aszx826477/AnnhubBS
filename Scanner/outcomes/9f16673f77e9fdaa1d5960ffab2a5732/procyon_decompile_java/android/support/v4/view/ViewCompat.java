// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.graphics.Paint;
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
import android.view.View;
import android.support.v4.os.BuildCompat;
import android.os.Build$VERSION;

public class ViewCompat
{
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    private static final long FAKE_FRAME_TIME = 10L;
    static final ViewCompat$ViewCompatImpl IMPL;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int LAYER_TYPE_HARDWARE = 2;
    public static final int LAYER_TYPE_NONE = 0;
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    public static final int MEASURED_SIZE_MASK = 16777215;
    public static final int MEASURED_STATE_MASK = -16777216;
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (BuildCompat.isAtLeastN()) {
            IMPL = new ViewCompat$Api24ViewCompatImpl();
        }
        else if (sdk_INT >= 23) {
            IMPL = new ViewCompat$MarshmallowViewCompatImpl();
        }
        else if (sdk_INT >= 21) {
            IMPL = new ViewCompat$LollipopViewCompatImpl();
        }
        else if (sdk_INT >= 19) {
            IMPL = new ViewCompat$KitKatViewCompatImpl();
        }
        else if (sdk_INT >= 18) {
            IMPL = new ViewCompat$JbMr2ViewCompatImpl();
        }
        else if (sdk_INT >= 17) {
            IMPL = new ViewCompat$JbMr1ViewCompatImpl();
        }
        else if (sdk_INT >= 16) {
            IMPL = new ViewCompat$JBViewCompatImpl();
        }
        else if (sdk_INT >= 15) {
            IMPL = new ViewCompat$ICSMr1ViewCompatImpl();
        }
        else if (sdk_INT >= 14) {
            IMPL = new ViewCompat$ICSViewCompatImpl();
        }
        else if (sdk_INT >= 11) {
            IMPL = new ViewCompat$HCViewCompatImpl();
        }
        else {
            IMPL = new ViewCompat$BaseViewCompatImpl();
        }
    }
    
    public static ViewPropertyAnimatorCompat animate(final View view) {
        return ViewCompat.IMPL.animate(view);
    }
    
    public static boolean canScrollHorizontally(final View view, final int n) {
        return ViewCompat.IMPL.canScrollHorizontally(view, n);
    }
    
    public static boolean canScrollVertically(final View view, final int n) {
        return ViewCompat.IMPL.canScrollVertically(view, n);
    }
    
    public static int combineMeasuredStates(final int n, final int n2) {
        return ViewCompat.IMPL.combineMeasuredStates(n, n2);
    }
    
    public static WindowInsetsCompat dispatchApplyWindowInsets(final View view, final WindowInsetsCompat windowInsetsCompat) {
        return ViewCompat.IMPL.dispatchApplyWindowInsets(view, windowInsetsCompat);
    }
    
    public static void dispatchFinishTemporaryDetach(final View view) {
        ViewCompat.IMPL.dispatchFinishTemporaryDetach(view);
    }
    
    public static boolean dispatchNestedFling(final View view, final float n, final float n2, final boolean b) {
        return ViewCompat.IMPL.dispatchNestedFling(view, n, n2, b);
    }
    
    public static boolean dispatchNestedPreFling(final View view, final float n, final float n2) {
        return ViewCompat.IMPL.dispatchNestedPreFling(view, n, n2);
    }
    
    public static boolean dispatchNestedPreScroll(final View view, final int n, final int n2, final int[] array, final int[] array2) {
        return ViewCompat.IMPL.dispatchNestedPreScroll(view, n, n2, array, array2);
    }
    
    public static boolean dispatchNestedScroll(final View view, final int n, final int n2, final int n3, final int n4, final int[] array) {
        return ViewCompat.IMPL.dispatchNestedScroll(view, n, n2, n3, n4, array);
    }
    
    public static void dispatchStartTemporaryDetach(final View view) {
        ViewCompat.IMPL.dispatchStartTemporaryDetach(view);
    }
    
    public static int getAccessibilityLiveRegion(final View view) {
        return ViewCompat.IMPL.getAccessibilityLiveRegion(view);
    }
    
    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(final View view) {
        return ViewCompat.IMPL.getAccessibilityNodeProvider(view);
    }
    
    public static float getAlpha(final View view) {
        return ViewCompat.IMPL.getAlpha(view);
    }
    
    public static ColorStateList getBackgroundTintList(final View view) {
        return ViewCompat.IMPL.getBackgroundTintList(view);
    }
    
    public static PorterDuff$Mode getBackgroundTintMode(final View view) {
        return ViewCompat.IMPL.getBackgroundTintMode(view);
    }
    
    public static Rect getClipBounds(final View view) {
        return ViewCompat.IMPL.getClipBounds(view);
    }
    
    public static Display getDisplay(final View view) {
        return ViewCompat.IMPL.getDisplay(view);
    }
    
    public static float getElevation(final View view) {
        return ViewCompat.IMPL.getElevation(view);
    }
    
    public static boolean getFitsSystemWindows(final View view) {
        return ViewCompat.IMPL.getFitsSystemWindows(view);
    }
    
    public static int getImportantForAccessibility(final View view) {
        return ViewCompat.IMPL.getImportantForAccessibility(view);
    }
    
    public static int getLabelFor(final View view) {
        return ViewCompat.IMPL.getLabelFor(view);
    }
    
    public static int getLayerType(final View view) {
        return ViewCompat.IMPL.getLayerType(view);
    }
    
    public static int getLayoutDirection(final View view) {
        return ViewCompat.IMPL.getLayoutDirection(view);
    }
    
    public static Matrix getMatrix(final View view) {
        return ViewCompat.IMPL.getMatrix(view);
    }
    
    public static int getMeasuredHeightAndState(final View view) {
        return ViewCompat.IMPL.getMeasuredHeightAndState(view);
    }
    
    public static int getMeasuredState(final View view) {
        return ViewCompat.IMPL.getMeasuredState(view);
    }
    
    public static int getMeasuredWidthAndState(final View view) {
        return ViewCompat.IMPL.getMeasuredWidthAndState(view);
    }
    
    public static int getMinimumHeight(final View view) {
        return ViewCompat.IMPL.getMinimumHeight(view);
    }
    
    public static int getMinimumWidth(final View view) {
        return ViewCompat.IMPL.getMinimumWidth(view);
    }
    
    public static int getOverScrollMode(final View view) {
        return view.getOverScrollMode();
    }
    
    public static int getPaddingEnd(final View view) {
        return ViewCompat.IMPL.getPaddingEnd(view);
    }
    
    public static int getPaddingStart(final View view) {
        return ViewCompat.IMPL.getPaddingStart(view);
    }
    
    public static ViewParent getParentForAccessibility(final View view) {
        return ViewCompat.IMPL.getParentForAccessibility(view);
    }
    
    public static float getPivotX(final View view) {
        return ViewCompat.IMPL.getPivotX(view);
    }
    
    public static float getPivotY(final View view) {
        return ViewCompat.IMPL.getPivotY(view);
    }
    
    public static float getRotation(final View view) {
        return ViewCompat.IMPL.getRotation(view);
    }
    
    public static float getRotationX(final View view) {
        return ViewCompat.IMPL.getRotationX(view);
    }
    
    public static float getRotationY(final View view) {
        return ViewCompat.IMPL.getRotationY(view);
    }
    
    public static float getScaleX(final View view) {
        return ViewCompat.IMPL.getScaleX(view);
    }
    
    public static float getScaleY(final View view) {
        return ViewCompat.IMPL.getScaleY(view);
    }
    
    public static int getScrollIndicators(final View view) {
        return ViewCompat.IMPL.getScrollIndicators(view);
    }
    
    public static String getTransitionName(final View view) {
        return ViewCompat.IMPL.getTransitionName(view);
    }
    
    public static float getTranslationX(final View view) {
        return ViewCompat.IMPL.getTranslationX(view);
    }
    
    public static float getTranslationY(final View view) {
        return ViewCompat.IMPL.getTranslationY(view);
    }
    
    public static float getTranslationZ(final View view) {
        return ViewCompat.IMPL.getTranslationZ(view);
    }
    
    public static int getWindowSystemUiVisibility(final View view) {
        return ViewCompat.IMPL.getWindowSystemUiVisibility(view);
    }
    
    public static float getX(final View view) {
        return ViewCompat.IMPL.getX(view);
    }
    
    public static float getY(final View view) {
        return ViewCompat.IMPL.getY(view);
    }
    
    public static float getZ(final View view) {
        return ViewCompat.IMPL.getZ(view);
    }
    
    public static boolean hasAccessibilityDelegate(final View view) {
        return ViewCompat.IMPL.hasAccessibilityDelegate(view);
    }
    
    public static boolean hasNestedScrollingParent(final View view) {
        return ViewCompat.IMPL.hasNestedScrollingParent(view);
    }
    
    public static boolean hasOnClickListeners(final View view) {
        return ViewCompat.IMPL.hasOnClickListeners(view);
    }
    
    public static boolean hasOverlappingRendering(final View view) {
        return ViewCompat.IMPL.hasOverlappingRendering(view);
    }
    
    public static boolean hasTransientState(final View view) {
        return ViewCompat.IMPL.hasTransientState(view);
    }
    
    public static boolean isAttachedToWindow(final View view) {
        return ViewCompat.IMPL.isAttachedToWindow(view);
    }
    
    public static boolean isImportantForAccessibility(final View view) {
        return ViewCompat.IMPL.isImportantForAccessibility(view);
    }
    
    public static boolean isInLayout(final View view) {
        return ViewCompat.IMPL.isInLayout(view);
    }
    
    public static boolean isLaidOut(final View view) {
        return ViewCompat.IMPL.isLaidOut(view);
    }
    
    public static boolean isLayoutDirectionResolved(final View view) {
        return ViewCompat.IMPL.isLayoutDirectionResolved(view);
    }
    
    public static boolean isNestedScrollingEnabled(final View view) {
        return ViewCompat.IMPL.isNestedScrollingEnabled(view);
    }
    
    public static boolean isOpaque(final View view) {
        return view.isOpaque();
    }
    
    public static boolean isPaddingRelative(final View view) {
        return ViewCompat.IMPL.isPaddingRelative(view);
    }
    
    public static void jumpDrawablesToCurrentState(final View view) {
        ViewCompat.IMPL.jumpDrawablesToCurrentState(view);
    }
    
    public static void offsetLeftAndRight(final View view, final int n) {
        ViewCompat.IMPL.offsetLeftAndRight(view, n);
    }
    
    public static void offsetTopAndBottom(final View view, final int n) {
        ViewCompat.IMPL.offsetTopAndBottom(view, n);
    }
    
    public static WindowInsetsCompat onApplyWindowInsets(final View view, final WindowInsetsCompat windowInsetsCompat) {
        return ViewCompat.IMPL.onApplyWindowInsets(view, windowInsetsCompat);
    }
    
    public static void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        ViewCompat.IMPL.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }
    
    public static void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewCompat.IMPL.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
    }
    
    public static void onPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        ViewCompat.IMPL.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }
    
    public static boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
        return ViewCompat.IMPL.performAccessibilityAction(view, n, bundle);
    }
    
    public static void postInvalidateOnAnimation(final View view) {
        ViewCompat.IMPL.postInvalidateOnAnimation(view);
    }
    
    public static void postInvalidateOnAnimation(final View view, final int n, final int n2, final int n3, final int n4) {
        ViewCompat.IMPL.postInvalidateOnAnimation(view, n, n2, n3, n4);
    }
    
    public static void postOnAnimation(final View view, final Runnable runnable) {
        ViewCompat.IMPL.postOnAnimation(view, runnable);
    }
    
    public static void postOnAnimationDelayed(final View view, final Runnable runnable, final long n) {
        ViewCompat.IMPL.postOnAnimationDelayed(view, runnable, n);
    }
    
    public static void requestApplyInsets(final View view) {
        ViewCompat.IMPL.requestApplyInsets(view);
    }
    
    public static int resolveSizeAndState(final int n, final int n2, final int n3) {
        return ViewCompat.IMPL.resolveSizeAndState(n, n2, n3);
    }
    
    public static void setAccessibilityDelegate(final View view, final AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.IMPL.setAccessibilityDelegate(view, accessibilityDelegateCompat);
    }
    
    public static void setAccessibilityLiveRegion(final View view, final int n) {
        ViewCompat.IMPL.setAccessibilityLiveRegion(view, n);
    }
    
    public static void setActivated(final View view, final boolean b) {
        ViewCompat.IMPL.setActivated(view, b);
    }
    
    public static void setAlpha(final View view, final float n) {
        ViewCompat.IMPL.setAlpha(view, n);
    }
    
    public static void setBackground(final View view, final Drawable drawable) {
        ViewCompat.IMPL.setBackground(view, drawable);
    }
    
    public static void setBackgroundTintList(final View view, final ColorStateList list) {
        ViewCompat.IMPL.setBackgroundTintList(view, list);
    }
    
    public static void setBackgroundTintMode(final View view, final PorterDuff$Mode porterDuff$Mode) {
        ViewCompat.IMPL.setBackgroundTintMode(view, porterDuff$Mode);
    }
    
    public static void setChildrenDrawingOrderEnabled(final ViewGroup viewGroup, final boolean b) {
        ViewCompat.IMPL.setChildrenDrawingOrderEnabled(viewGroup, b);
    }
    
    public static void setClipBounds(final View view, final Rect rect) {
        ViewCompat.IMPL.setClipBounds(view, rect);
    }
    
    public static void setElevation(final View view, final float n) {
        ViewCompat.IMPL.setElevation(view, n);
    }
    
    public static void setFitsSystemWindows(final View view, final boolean b) {
        ViewCompat.IMPL.setFitsSystemWindows(view, b);
    }
    
    public static void setHasTransientState(final View view, final boolean b) {
        ViewCompat.IMPL.setHasTransientState(view, b);
    }
    
    public static void setImportantForAccessibility(final View view, final int n) {
        ViewCompat.IMPL.setImportantForAccessibility(view, n);
    }
    
    public static void setLabelFor(final View view, final int n) {
        ViewCompat.IMPL.setLabelFor(view, n);
    }
    
    public static void setLayerPaint(final View view, final Paint paint) {
        ViewCompat.IMPL.setLayerPaint(view, paint);
    }
    
    public static void setLayerType(final View view, final int n, final Paint paint) {
        ViewCompat.IMPL.setLayerType(view, n, paint);
    }
    
    public static void setLayoutDirection(final View view, final int n) {
        ViewCompat.IMPL.setLayoutDirection(view, n);
    }
    
    public static void setNestedScrollingEnabled(final View view, final boolean b) {
        ViewCompat.IMPL.setNestedScrollingEnabled(view, b);
    }
    
    public static void setOnApplyWindowInsetsListener(final View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        ViewCompat.IMPL.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
    }
    
    public static void setOverScrollMode(final View view, final int overScrollMode) {
        view.setOverScrollMode(overScrollMode);
    }
    
    public static void setPaddingRelative(final View view, final int n, final int n2, final int n3, final int n4) {
        ViewCompat.IMPL.setPaddingRelative(view, n, n2, n3, n4);
    }
    
    public static void setPivotX(final View view, final float n) {
        ViewCompat.IMPL.setPivotX(view, n);
    }
    
    public static void setPivotY(final View view, final float n) {
        ViewCompat.IMPL.setPivotY(view, n);
    }
    
    public static void setPointerIcon(final View view, final PointerIconCompat pointerIconCompat) {
        ViewCompat.IMPL.setPointerIcon(view, pointerIconCompat);
    }
    
    public static void setRotation(final View view, final float n) {
        ViewCompat.IMPL.setRotation(view, n);
    }
    
    public static void setRotationX(final View view, final float n) {
        ViewCompat.IMPL.setRotationX(view, n);
    }
    
    public static void setRotationY(final View view, final float n) {
        ViewCompat.IMPL.setRotationY(view, n);
    }
    
    public static void setSaveFromParentEnabled(final View view, final boolean b) {
        ViewCompat.IMPL.setSaveFromParentEnabled(view, b);
    }
    
    public static void setScaleX(final View view, final float n) {
        ViewCompat.IMPL.setScaleX(view, n);
    }
    
    public static void setScaleY(final View view, final float n) {
        ViewCompat.IMPL.setScaleY(view, n);
    }
    
    public static void setScrollIndicators(final View view, final int n) {
        ViewCompat.IMPL.setScrollIndicators(view, n);
    }
    
    public static void setScrollIndicators(final View view, final int n, final int n2) {
        ViewCompat.IMPL.setScrollIndicators(view, n, n2);
    }
    
    public static void setTransitionName(final View view, final String s) {
        ViewCompat.IMPL.setTransitionName(view, s);
    }
    
    public static void setTranslationX(final View view, final float n) {
        ViewCompat.IMPL.setTranslationX(view, n);
    }
    
    public static void setTranslationY(final View view, final float n) {
        ViewCompat.IMPL.setTranslationY(view, n);
    }
    
    public static void setTranslationZ(final View view, final float n) {
        ViewCompat.IMPL.setTranslationZ(view, n);
    }
    
    public static void setX(final View view, final float n) {
        ViewCompat.IMPL.setX(view, n);
    }
    
    public static void setY(final View view, final float n) {
        ViewCompat.IMPL.setY(view, n);
    }
    
    public static void setZ(final View view, final float n) {
        ViewCompat.IMPL.setZ(view, n);
    }
    
    public static boolean startNestedScroll(final View view, final int n) {
        return ViewCompat.IMPL.startNestedScroll(view, n);
    }
    
    public static void stopNestedScroll(final View view) {
        ViewCompat.IMPL.stopNestedScroll(view);
    }
}
