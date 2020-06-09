// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.widget.ScrollView;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.support.v4.view.AccessibilityDelegateCompat;

class NestedScrollView$AccessibilityDelegate extends AccessibilityDelegateCompat
{
    public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        final NestedScrollView nestedScrollView = (NestedScrollView)view;
        accessibilityEvent.setClassName((CharSequence)ScrollView.class.getName());
        final AccessibilityRecordCompat record = AccessibilityEventCompat.asRecord(accessibilityEvent);
        record.setScrollable(nestedScrollView.getScrollRange() > 0);
        record.setScrollX(nestedScrollView.getScrollX());
        record.setScrollY(nestedScrollView.getScrollY());
        record.setMaxScrollX(nestedScrollView.getScrollX());
        record.setMaxScrollY(nestedScrollView.getScrollRange());
    }
    
    public void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        final NestedScrollView nestedScrollView = (NestedScrollView)view;
        accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
        if (nestedScrollView.isEnabled()) {
            final int scrollRange = nestedScrollView.getScrollRange();
            if (scrollRange > 0) {
                accessibilityNodeInfoCompat.setScrollable(true);
                if (nestedScrollView.getScrollY() > 0) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
        }
    }
    
    public boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
        final boolean performAccessibilityAction = super.performAccessibilityAction(view, n, bundle);
        final boolean b = true;
        if (performAccessibilityAction) {
            return b;
        }
        final NestedScrollView nestedScrollView = (NestedScrollView)view;
        if (!nestedScrollView.isEnabled()) {
            return false;
        }
        if (n != 4096) {
            if (n != 8192) {
                return false;
            }
            final int max = Math.max(nestedScrollView.getScrollY() - (nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom() - nestedScrollView.getPaddingTop()), 0);
            if (max != nestedScrollView.getScrollY()) {
                nestedScrollView.smoothScrollTo(0, max);
                return b;
            }
            return false;
        }
        else {
            final int min = Math.min(nestedScrollView.getScrollY() + (nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom() - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min != nestedScrollView.getScrollY()) {
                nestedScrollView.smoothScrollTo(0, min);
                return b;
            }
            return false;
        }
    }
}
