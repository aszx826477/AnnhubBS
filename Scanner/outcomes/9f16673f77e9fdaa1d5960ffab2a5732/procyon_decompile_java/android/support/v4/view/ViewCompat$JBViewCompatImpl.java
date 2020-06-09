// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewParent;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;

class ViewCompat$JBViewCompatImpl extends ViewCompat$ICSMr1ViewCompatImpl
{
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(final View view) {
        final Object accessibilityNodeProvider = ViewCompatJB.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return null;
    }
    
    public boolean getFitsSystemWindows(final View view) {
        return ViewCompatJB.getFitsSystemWindows(view);
    }
    
    public int getImportantForAccessibility(final View view) {
        return ViewCompatJB.getImportantForAccessibility(view);
    }
    
    public int getMinimumHeight(final View view) {
        return ViewCompatJB.getMinimumHeight(view);
    }
    
    public int getMinimumWidth(final View view) {
        return ViewCompatJB.getMinimumWidth(view);
    }
    
    public ViewParent getParentForAccessibility(final View view) {
        return ViewCompatJB.getParentForAccessibility(view);
    }
    
    public boolean hasOverlappingRendering(final View view) {
        return ViewCompatJB.hasOverlappingRendering(view);
    }
    
    public boolean hasTransientState(final View view) {
        return ViewCompatJB.hasTransientState(view);
    }
    
    public boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
        return ViewCompatJB.performAccessibilityAction(view, n, bundle);
    }
    
    public void postInvalidateOnAnimation(final View view) {
        ViewCompatJB.postInvalidateOnAnimation(view);
    }
    
    public void postInvalidateOnAnimation(final View view, final int n, final int n2, final int n3, final int n4) {
        ViewCompatJB.postInvalidateOnAnimation(view, n, n2, n3, n4);
    }
    
    public void postOnAnimation(final View view, final Runnable runnable) {
        ViewCompatJB.postOnAnimation(view, runnable);
    }
    
    public void postOnAnimationDelayed(final View view, final Runnable runnable, final long n) {
        ViewCompatJB.postOnAnimationDelayed(view, runnable, n);
    }
    
    public void requestApplyInsets(final View view) {
        ViewCompatJB.requestApplyInsets(view);
    }
    
    public void setBackground(final View view, final Drawable drawable) {
        ViewCompatJB.setBackground(view, drawable);
    }
    
    public void setHasTransientState(final View view, final boolean b) {
        ViewCompatJB.setHasTransientState(view, b);
    }
    
    public void setImportantForAccessibility(final View view, int n) {
        if (n == 4) {
            n = 2;
        }
        ViewCompatJB.setImportantForAccessibility(view, n);
    }
}
