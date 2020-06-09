// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

interface AccessibilityEventCompat$AccessibilityEventVersionImpl
{
    void appendRecord(final AccessibilityEvent p0, final Object p1);
    
    int getAction(final AccessibilityEvent p0);
    
    int getContentChangeTypes(final AccessibilityEvent p0);
    
    int getMovementGranularity(final AccessibilityEvent p0);
    
    Object getRecord(final AccessibilityEvent p0, final int p1);
    
    int getRecordCount(final AccessibilityEvent p0);
    
    void setAction(final AccessibilityEvent p0, final int p1);
    
    void setContentChangeTypes(final AccessibilityEvent p0, final int p1);
    
    void setMovementGranularity(final AccessibilityEvent p0, final int p1);
}
