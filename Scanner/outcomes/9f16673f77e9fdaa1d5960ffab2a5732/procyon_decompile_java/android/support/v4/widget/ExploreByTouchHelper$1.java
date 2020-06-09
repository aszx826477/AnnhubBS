// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

final class ExploreByTouchHelper$1 implements FocusStrategy$BoundsAdapter
{
    public void obtainBounds(final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, final Rect rect) {
        accessibilityNodeInfoCompat.getBoundsInParent(rect);
    }
}
