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

interface ViewCompat$ViewCompatImpl
{
    ViewPropertyAnimatorCompat animate(final View p0);
    
    boolean canScrollHorizontally(final View p0, final int p1);
    
    boolean canScrollVertically(final View p0, final int p1);
    
    int combineMeasuredStates(final int p0, final int p1);
    
    WindowInsetsCompat dispatchApplyWindowInsets(final View p0, final WindowInsetsCompat p1);
    
    void dispatchFinishTemporaryDetach(final View p0);
    
    boolean dispatchNestedFling(final View p0, final float p1, final float p2, final boolean p3);
    
    boolean dispatchNestedPreFling(final View p0, final float p1, final float p2);
    
    boolean dispatchNestedPreScroll(final View p0, final int p1, final int p2, final int[] p3, final int[] p4);
    
    boolean dispatchNestedScroll(final View p0, final int p1, final int p2, final int p3, final int p4, final int[] p5);
    
    void dispatchStartTemporaryDetach(final View p0);
    
    int getAccessibilityLiveRegion(final View p0);
    
    AccessibilityNodeProviderCompat getAccessibilityNodeProvider(final View p0);
    
    float getAlpha(final View p0);
    
    ColorStateList getBackgroundTintList(final View p0);
    
    PorterDuff$Mode getBackgroundTintMode(final View p0);
    
    Rect getClipBounds(final View p0);
    
    Display getDisplay(final View p0);
    
    float getElevation(final View p0);
    
    boolean getFitsSystemWindows(final View p0);
    
    int getImportantForAccessibility(final View p0);
    
    int getLabelFor(final View p0);
    
    int getLayerType(final View p0);
    
    int getLayoutDirection(final View p0);
    
    Matrix getMatrix(final View p0);
    
    int getMeasuredHeightAndState(final View p0);
    
    int getMeasuredState(final View p0);
    
    int getMeasuredWidthAndState(final View p0);
    
    int getMinimumHeight(final View p0);
    
    int getMinimumWidth(final View p0);
    
    int getPaddingEnd(final View p0);
    
    int getPaddingStart(final View p0);
    
    ViewParent getParentForAccessibility(final View p0);
    
    float getPivotX(final View p0);
    
    float getPivotY(final View p0);
    
    float getRotation(final View p0);
    
    float getRotationX(final View p0);
    
    float getRotationY(final View p0);
    
    float getScaleX(final View p0);
    
    float getScaleY(final View p0);
    
    int getScrollIndicators(final View p0);
    
    String getTransitionName(final View p0);
    
    float getTranslationX(final View p0);
    
    float getTranslationY(final View p0);
    
    float getTranslationZ(final View p0);
    
    int getWindowSystemUiVisibility(final View p0);
    
    float getX(final View p0);
    
    float getY(final View p0);
    
    float getZ(final View p0);
    
    boolean hasAccessibilityDelegate(final View p0);
    
    boolean hasNestedScrollingParent(final View p0);
    
    boolean hasOnClickListeners(final View p0);
    
    boolean hasOverlappingRendering(final View p0);
    
    boolean hasTransientState(final View p0);
    
    boolean isAttachedToWindow(final View p0);
    
    boolean isImportantForAccessibility(final View p0);
    
    boolean isInLayout(final View p0);
    
    boolean isLaidOut(final View p0);
    
    boolean isLayoutDirectionResolved(final View p0);
    
    boolean isNestedScrollingEnabled(final View p0);
    
    boolean isPaddingRelative(final View p0);
    
    void jumpDrawablesToCurrentState(final View p0);
    
    void offsetLeftAndRight(final View p0, final int p1);
    
    void offsetTopAndBottom(final View p0, final int p1);
    
    WindowInsetsCompat onApplyWindowInsets(final View p0, final WindowInsetsCompat p1);
    
    void onInitializeAccessibilityEvent(final View p0, final AccessibilityEvent p1);
    
    void onInitializeAccessibilityNodeInfo(final View p0, final AccessibilityNodeInfoCompat p1);
    
    void onPopulateAccessibilityEvent(final View p0, final AccessibilityEvent p1);
    
    boolean performAccessibilityAction(final View p0, final int p1, final Bundle p2);
    
    void postInvalidateOnAnimation(final View p0);
    
    void postInvalidateOnAnimation(final View p0, final int p1, final int p2, final int p3, final int p4);
    
    void postOnAnimation(final View p0, final Runnable p1);
    
    void postOnAnimationDelayed(final View p0, final Runnable p1, final long p2);
    
    void requestApplyInsets(final View p0);
    
    int resolveSizeAndState(final int p0, final int p1, final int p2);
    
    void setAccessibilityDelegate(final View p0, final AccessibilityDelegateCompat p1);
    
    void setAccessibilityLiveRegion(final View p0, final int p1);
    
    void setActivated(final View p0, final boolean p1);
    
    void setAlpha(final View p0, final float p1);
    
    void setBackground(final View p0, final Drawable p1);
    
    void setBackgroundTintList(final View p0, final ColorStateList p1);
    
    void setBackgroundTintMode(final View p0, final PorterDuff$Mode p1);
    
    void setChildrenDrawingOrderEnabled(final ViewGroup p0, final boolean p1);
    
    void setClipBounds(final View p0, final Rect p1);
    
    void setElevation(final View p0, final float p1);
    
    void setFitsSystemWindows(final View p0, final boolean p1);
    
    void setHasTransientState(final View p0, final boolean p1);
    
    void setImportantForAccessibility(final View p0, final int p1);
    
    void setLabelFor(final View p0, final int p1);
    
    void setLayerPaint(final View p0, final Paint p1);
    
    void setLayerType(final View p0, final int p1, final Paint p2);
    
    void setLayoutDirection(final View p0, final int p1);
    
    void setNestedScrollingEnabled(final View p0, final boolean p1);
    
    void setOnApplyWindowInsetsListener(final View p0, final OnApplyWindowInsetsListener p1);
    
    void setPaddingRelative(final View p0, final int p1, final int p2, final int p3, final int p4);
    
    void setPivotX(final View p0, final float p1);
    
    void setPivotY(final View p0, final float p1);
    
    void setPointerIcon(final View p0, final PointerIconCompat p1);
    
    void setRotation(final View p0, final float p1);
    
    void setRotationX(final View p0, final float p1);
    
    void setRotationY(final View p0, final float p1);
    
    void setSaveFromParentEnabled(final View p0, final boolean p1);
    
    void setScaleX(final View p0, final float p1);
    
    void setScaleY(final View p0, final float p1);
    
    void setScrollIndicators(final View p0, final int p1);
    
    void setScrollIndicators(final View p0, final int p1, final int p2);
    
    void setTransitionName(final View p0, final String p1);
    
    void setTranslationX(final View p0, final float p1);
    
    void setTranslationY(final View p0, final float p1);
    
    void setTranslationZ(final View p0, final float p1);
    
    void setX(final View p0, final float p1);
    
    void setY(final View p0, final float p1);
    
    void setZ(final View p0, final float p1);
    
    boolean startNestedScroll(final View p0, final int p1);
    
    void stopNestedScroll(final View p0);
}
