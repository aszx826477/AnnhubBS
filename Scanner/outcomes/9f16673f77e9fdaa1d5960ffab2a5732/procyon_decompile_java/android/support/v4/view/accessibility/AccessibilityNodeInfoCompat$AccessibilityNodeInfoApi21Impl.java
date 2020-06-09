// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.view.View;
import java.util.List;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi21Impl extends AccessibilityNodeInfoCompat$AccessibilityNodeInfoKitKatImpl
{
    public void addAction(final Object o, final Object o2) {
        AccessibilityNodeInfoCompatApi21.addAction(o, o2);
    }
    
    public int getAccessibilityActionId(final Object o) {
        return AccessibilityNodeInfoCompatApi21.getAccessibilityActionId(o);
    }
    
    public CharSequence getAccessibilityActionLabel(final Object o) {
        return AccessibilityNodeInfoCompatApi21.getAccessibilityActionLabel(o);
    }
    
    public List getActionList(final Object o) {
        return AccessibilityNodeInfoCompatApi21.getActionList(o);
    }
    
    public int getCollectionInfoSelectionMode(final Object o) {
        return AccessibilityNodeInfoCompatApi21$CollectionInfo.getSelectionMode(o);
    }
    
    public CharSequence getError(final Object o) {
        return AccessibilityNodeInfoCompatApi21.getError(o);
    }
    
    public int getMaxTextLength(final Object o) {
        return AccessibilityNodeInfoCompatApi21.getMaxTextLength(o);
    }
    
    public Object getWindow(final Object o) {
        return AccessibilityNodeInfoCompatApi21.getWindow(o);
    }
    
    public boolean isCollectionItemSelected(final Object o) {
        return AccessibilityNodeInfoCompatApi21$CollectionItemInfo.isSelected(o);
    }
    
    public Object newAccessibilityAction(final int n, final CharSequence charSequence) {
        return AccessibilityNodeInfoCompatApi21.newAccessibilityAction(n, charSequence);
    }
    
    public Object obtainCollectionInfo(final int n, final int n2, final boolean b, final int n3) {
        return AccessibilityNodeInfoCompatApi21.obtainCollectionInfo(n, n2, b, n3);
    }
    
    public Object obtainCollectionItemInfo(final int n, final int n2, final int n3, final int n4, final boolean b, final boolean b2) {
        return AccessibilityNodeInfoCompatApi21.obtainCollectionItemInfo(n, n2, n3, n4, b, b2);
    }
    
    public boolean removeAction(final Object o, final Object o2) {
        return AccessibilityNodeInfoCompatApi21.removeAction(o, o2);
    }
    
    public boolean removeChild(final Object o, final View view) {
        return AccessibilityNodeInfoCompatApi21.removeChild(o, view);
    }
    
    public boolean removeChild(final Object o, final View view, final int n) {
        return AccessibilityNodeInfoCompatApi21.removeChild(o, view, n);
    }
    
    public void setError(final Object o, final CharSequence charSequence) {
        AccessibilityNodeInfoCompatApi21.setError(o, charSequence);
    }
    
    public void setMaxTextLength(final Object o, final int n) {
        AccessibilityNodeInfoCompatApi21.setMaxTextLength(o, n);
    }
}
