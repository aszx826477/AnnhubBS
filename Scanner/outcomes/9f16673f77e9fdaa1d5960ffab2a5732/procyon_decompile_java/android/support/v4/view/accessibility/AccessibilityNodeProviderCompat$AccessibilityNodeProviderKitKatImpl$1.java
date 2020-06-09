// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl$1 implements AccessibilityNodeProviderCompatKitKat$AccessibilityNodeInfoBridge
{
    final /* synthetic */ AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl this$0;
    final /* synthetic */ AccessibilityNodeProviderCompat val$compat;
    
    AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl$1(final AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl this$0, final AccessibilityNodeProviderCompat val$compat) {
        this.this$0 = this$0;
        this.val$compat = val$compat;
    }
    
    public Object createAccessibilityNodeInfo(final int n) {
        final AccessibilityNodeInfoCompat accessibilityNodeInfo = this.val$compat.createAccessibilityNodeInfo(n);
        if (accessibilityNodeInfo == null) {
            return null;
        }
        return accessibilityNodeInfo.getInfo();
    }
    
    public List findAccessibilityNodeInfosByText(final String s, final int n) {
        final List accessibilityNodeInfosByText = this.val$compat.findAccessibilityNodeInfosByText(s, n);
        if (accessibilityNodeInfosByText == null) {
            return null;
        }
        final ArrayList<Object> list = new ArrayList<Object>();
        for (int size = accessibilityNodeInfosByText.size(), i = 0; i < size; ++i) {
            list.add(accessibilityNodeInfosByText.get(i).getInfo());
        }
        return list;
    }
    
    public Object findFocus(final int n) {
        final AccessibilityNodeInfoCompat focus = this.val$compat.findFocus(n);
        if (focus == null) {
            return null;
        }
        return focus.getInfo();
    }
    
    public boolean performAction(final int n, final int n2, final Bundle bundle) {
        return this.val$compat.performAction(n, n2, bundle);
    }
}
