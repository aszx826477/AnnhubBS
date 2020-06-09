// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

class AccessibilityEventCompat$AccessibilityEventJellyBeanImpl extends AccessibilityEventCompat$AccessibilityEventIcsImpl
{
    public int getAction(final AccessibilityEvent accessibilityEvent) {
        return AccessibilityEventCompatJellyBean.getAction(accessibilityEvent);
    }
    
    public int getMovementGranularity(final AccessibilityEvent accessibilityEvent) {
        return AccessibilityEventCompatJellyBean.getMovementGranularity(accessibilityEvent);
    }
    
    public void setAction(final AccessibilityEvent accessibilityEvent, final int n) {
        AccessibilityEventCompatJellyBean.setAction(accessibilityEvent, n);
    }
    
    public void setMovementGranularity(final AccessibilityEvent accessibilityEvent, final int n) {
        AccessibilityEventCompatJellyBean.setMovementGranularity(accessibilityEvent, n);
    }
}
