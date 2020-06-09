// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

class AccessibilityEventCompat$AccessibilityEventKitKatImpl extends AccessibilityEventCompat$AccessibilityEventJellyBeanImpl
{
    public int getContentChangeTypes(final AccessibilityEvent accessibilityEvent) {
        return AccessibilityEventCompatKitKat.getContentChangeTypes(accessibilityEvent);
    }
    
    public void setContentChangeTypes(final AccessibilityEvent accessibilityEvent, final int n) {
        AccessibilityEventCompatKitKat.setContentChangeTypes(accessibilityEvent, n);
    }
}
