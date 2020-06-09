// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.support.v4.view.AccessibilityDelegateCompat;

final class DrawerLayout$ChildAccessibilityDelegate extends AccessibilityDelegateCompat
{
    final /* synthetic */ DrawerLayout this$0;
    
    DrawerLayout$ChildAccessibilityDelegate(final DrawerLayout this$0) {
        this.this$0 = this$0;
    }
    
    public void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (!DrawerLayout.includeChildForAccessibility(view)) {
            accessibilityNodeInfoCompat.setParent(null);
        }
    }
}
