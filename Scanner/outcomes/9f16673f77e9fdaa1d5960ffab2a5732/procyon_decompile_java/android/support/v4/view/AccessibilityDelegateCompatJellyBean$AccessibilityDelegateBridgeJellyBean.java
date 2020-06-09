// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;

public interface AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean
{
    boolean dispatchPopulateAccessibilityEvent(final View p0, final AccessibilityEvent p1);
    
    Object getAccessibilityNodeProvider(final View p0);
    
    void onInitializeAccessibilityEvent(final View p0, final AccessibilityEvent p1);
    
    void onInitializeAccessibilityNodeInfo(final View p0, final Object p1);
    
    void onPopulateAccessibilityEvent(final View p0, final AccessibilityEvent p1);
    
    boolean onRequestSendAccessibilityEvent(final ViewGroup p0, final View p1, final AccessibilityEvent p2);
    
    boolean performAccessibilityAction(final View p0, final int p1, final Bundle p2);
    
    void sendAccessibilityEvent(final View p0, final int p1);
    
    void sendAccessibilityEventUnchecked(final View p0, final AccessibilityEvent p1);
}
