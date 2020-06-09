// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.List;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

final class AccessibilityNodeProviderCompatJellyBean$1 extends AccessibilityNodeProvider
{
    final /* synthetic */ AccessibilityNodeProviderCompatJellyBean$AccessibilityNodeInfoBridge val$bridge;
    
    AccessibilityNodeProviderCompatJellyBean$1(final AccessibilityNodeProviderCompatJellyBean$AccessibilityNodeInfoBridge val$bridge) {
        this.val$bridge = val$bridge;
    }
    
    public AccessibilityNodeInfo createAccessibilityNodeInfo(final int n) {
        return (AccessibilityNodeInfo)this.val$bridge.createAccessibilityNodeInfo(n);
    }
    
    public List findAccessibilityNodeInfosByText(final String s, final int n) {
        return this.val$bridge.findAccessibilityNodeInfosByText(s, n);
    }
    
    public boolean performAction(final int n, final int n2, final Bundle bundle) {
        return this.val$bridge.performAction(n, n2, bundle);
    }
}
