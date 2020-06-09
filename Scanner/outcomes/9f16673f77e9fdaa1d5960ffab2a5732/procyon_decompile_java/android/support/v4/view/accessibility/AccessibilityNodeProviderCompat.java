// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.List;
import android.os.Build$VERSION;

public class AccessibilityNodeProviderCompat
{
    public static final int HOST_VIEW_ID = 255;
    private static final AccessibilityNodeProviderCompat$AccessibilityNodeProviderImpl IMPL;
    private final Object mProvider;
    
    static {
        if (Build$VERSION.SDK_INT >= 19) {
            IMPL = new AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl();
        }
        else if (Build$VERSION.SDK_INT >= 16) {
            IMPL = new AccessibilityNodeProviderCompat$AccessibilityNodeProviderJellyBeanImpl();
        }
        else {
            IMPL = new AccessibilityNodeProviderCompat$AccessibilityNodeProviderStubImpl();
        }
    }
    
    public AccessibilityNodeProviderCompat() {
        this.mProvider = AccessibilityNodeProviderCompat.IMPL.newAccessibilityNodeProviderBridge(this);
    }
    
    public AccessibilityNodeProviderCompat(final Object mProvider) {
        this.mProvider = mProvider;
    }
    
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(final int n) {
        return null;
    }
    
    public List findAccessibilityNodeInfosByText(final String s, final int n) {
        return null;
    }
    
    public AccessibilityNodeInfoCompat findFocus(final int n) {
        return null;
    }
    
    public Object getProvider() {
        return this.mProvider;
    }
    
    public boolean performAction(final int n, final int n2, final Bundle bundle) {
        return false;
    }
}
