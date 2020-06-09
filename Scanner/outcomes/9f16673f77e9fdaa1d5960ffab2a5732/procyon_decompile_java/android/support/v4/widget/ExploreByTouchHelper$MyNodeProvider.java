// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.view.ViewParent;
import android.support.v4.util.SparseArrayCompat;
import java.util.List;
import java.util.ArrayList;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.accessibility.AccessibilityEvent;
import android.support.v4.view.ViewCompat;
import android.view.accessibility.AccessibilityManager;
import android.view.View;
import android.graphics.Rect;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;

class ExploreByTouchHelper$MyNodeProvider extends AccessibilityNodeProviderCompat
{
    final /* synthetic */ ExploreByTouchHelper this$0;
    
    ExploreByTouchHelper$MyNodeProvider(final ExploreByTouchHelper this$0) {
        this.this$0 = this$0;
    }
    
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(final int n) {
        return AccessibilityNodeInfoCompat.obtain(this.this$0.obtainAccessibilityNodeInfo(n));
    }
    
    public AccessibilityNodeInfoCompat findFocus(final int n) {
        int n2;
        if (n == 2) {
            n2 = this.this$0.mAccessibilityFocusedVirtualViewId;
        }
        else {
            n2 = this.this$0.mKeyboardFocusedVirtualViewId;
        }
        if (n2 == -1 << -1) {
            return null;
        }
        return this.createAccessibilityNodeInfo(n2);
    }
    
    public boolean performAction(final int n, final int n2, final Bundle bundle) {
        return this.this$0.performAction(n, n2, bundle);
    }
}
