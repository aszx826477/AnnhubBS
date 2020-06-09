// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo$CollectionInfo;

class AccessibilityNodeInfoCompatKitKat$CollectionInfo
{
    static int getColumnCount(final Object o) {
        return ((AccessibilityNodeInfo$CollectionInfo)o).getColumnCount();
    }
    
    static int getRowCount(final Object o) {
        return ((AccessibilityNodeInfo$CollectionInfo)o).getRowCount();
    }
    
    static boolean isHierarchical(final Object o) {
        return ((AccessibilityNodeInfo$CollectionInfo)o).isHierarchical();
    }
}
