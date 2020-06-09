// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.view.View;

class ViewCompat$LollipopViewCompatImpl extends ViewCompat$KitKatViewCompatImpl
{
    public WindowInsetsCompat dispatchApplyWindowInsets(final View view, final WindowInsetsCompat windowInsetsCompat) {
        return WindowInsetsCompat.wrap(ViewCompatLollipop.dispatchApplyWindowInsets(view, WindowInsetsCompat.unwrap(windowInsetsCompat)));
    }
    
    public boolean dispatchNestedFling(final View view, final float n, final float n2, final boolean b) {
        return ViewCompatLollipop.dispatchNestedFling(view, n, n2, b);
    }
    
    public boolean dispatchNestedPreFling(final View view, final float n, final float n2) {
        return ViewCompatLollipop.dispatchNestedPreFling(view, n, n2);
    }
    
    public boolean dispatchNestedPreScroll(final View view, final int n, final int n2, final int[] array, final int[] array2) {
        return ViewCompatLollipop.dispatchNestedPreScroll(view, n, n2, array, array2);
    }
    
    public boolean dispatchNestedScroll(final View view, final int n, final int n2, final int n3, final int n4, final int[] array) {
        return ViewCompatLollipop.dispatchNestedScroll(view, n, n2, n3, n4, array);
    }
    
    public ColorStateList getBackgroundTintList(final View view) {
        return ViewCompatLollipop.getBackgroundTintList(view);
    }
    
    public PorterDuff$Mode getBackgroundTintMode(final View view) {
        return ViewCompatLollipop.getBackgroundTintMode(view);
    }
    
    public float getElevation(final View view) {
        return ViewCompatLollipop.getElevation(view);
    }
    
    public String getTransitionName(final View view) {
        return ViewCompatLollipop.getTransitionName(view);
    }
    
    public float getTranslationZ(final View view) {
        return ViewCompatLollipop.getTranslationZ(view);
    }
    
    public float getZ(final View view) {
        return ViewCompatLollipop.getZ(view);
    }
    
    public boolean hasNestedScrollingParent(final View view) {
        return ViewCompatLollipop.hasNestedScrollingParent(view);
    }
    
    public boolean isImportantForAccessibility(final View view) {
        return ViewCompatLollipop.isImportantForAccessibility(view);
    }
    
    public boolean isNestedScrollingEnabled(final View view) {
        return ViewCompatLollipop.isNestedScrollingEnabled(view);
    }
    
    public void offsetLeftAndRight(final View view, final int n) {
        ViewCompatLollipop.offsetLeftAndRight(view, n);
    }
    
    public void offsetTopAndBottom(final View view, final int n) {
        ViewCompatLollipop.offsetTopAndBottom(view, n);
    }
    
    public WindowInsetsCompat onApplyWindowInsets(final View view, final WindowInsetsCompat windowInsetsCompat) {
        return WindowInsetsCompat.wrap(ViewCompatLollipop.onApplyWindowInsets(view, WindowInsetsCompat.unwrap(windowInsetsCompat)));
    }
    
    public void requestApplyInsets(final View view) {
        ViewCompatLollipop.requestApplyInsets(view);
    }
    
    public void setBackgroundTintList(final View view, final ColorStateList list) {
        ViewCompatLollipop.setBackgroundTintList(view, list);
    }
    
    public void setBackgroundTintMode(final View view, final PorterDuff$Mode porterDuff$Mode) {
        ViewCompatLollipop.setBackgroundTintMode(view, porterDuff$Mode);
    }
    
    public void setElevation(final View view, final float n) {
        ViewCompatLollipop.setElevation(view, n);
    }
    
    public void setNestedScrollingEnabled(final View view, final boolean b) {
        ViewCompatLollipop.setNestedScrollingEnabled(view, b);
    }
    
    public void setOnApplyWindowInsetsListener(final View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (onApplyWindowInsetsListener == null) {
            ViewCompatLollipop.setOnApplyWindowInsetsListener(view, null);
            return;
        }
        ViewCompatLollipop.setOnApplyWindowInsetsListener(view, new ViewCompat$LollipopViewCompatImpl$1(this, onApplyWindowInsetsListener));
    }
    
    public void setTransitionName(final View view, final String s) {
        ViewCompatLollipop.setTransitionName(view, s);
    }
    
    public void setTranslationZ(final View view, final float n) {
        ViewCompatLollipop.setTranslationZ(view, n);
    }
    
    public void setZ(final View view, final float n) {
        ViewCompatLollipop.setZ(view, n);
    }
    
    public boolean startNestedScroll(final View view, final int n) {
        return ViewCompatLollipop.startNestedScroll(view, n);
    }
    
    public void stopNestedScroll(final View view) {
        ViewCompatLollipop.stopNestedScroll(view);
    }
}
