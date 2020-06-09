// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.util.SparseArrayCompat;

final class ExploreByTouchHelper$2 implements FocusStrategy$CollectionAdapter
{
    public AccessibilityNodeInfoCompat get(final SparseArrayCompat sparseArrayCompat, final int n) {
        return (AccessibilityNodeInfoCompat)sparseArrayCompat.valueAt(n);
    }
    
    public int size(final SparseArrayCompat sparseArrayCompat) {
        return sparseArrayCompat.size();
    }
}
