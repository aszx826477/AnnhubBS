// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo;

class AccessibilityNodeInfoCompatKitKat$CollectionItemInfo
{
    static int getColumnIndex(final Object o) {
        return ((AccessibilityNodeInfo$CollectionItemInfo)o).getColumnIndex();
    }
    
    static int getColumnSpan(final Object o) {
        return ((AccessibilityNodeInfo$CollectionItemInfo)o).getColumnSpan();
    }
    
    static int getRowIndex(final Object o) {
        return ((AccessibilityNodeInfo$CollectionItemInfo)o).getRowIndex();
    }
    
    static int getRowSpan(final Object o) {
        return ((AccessibilityNodeInfo$CollectionItemInfo)o).getRowSpan();
    }
    
    static boolean isHeading(final Object o) {
        return ((AccessibilityNodeInfo$CollectionItemInfo)o).isHeading();
    }
}
