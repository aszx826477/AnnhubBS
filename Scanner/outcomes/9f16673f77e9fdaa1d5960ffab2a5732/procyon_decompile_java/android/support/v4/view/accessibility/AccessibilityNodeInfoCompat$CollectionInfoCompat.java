// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

public class AccessibilityNodeInfoCompat$CollectionInfoCompat
{
    public static final int SELECTION_MODE_MULTIPLE = 2;
    public static final int SELECTION_MODE_NONE = 0;
    public static final int SELECTION_MODE_SINGLE = 1;
    final Object mInfo;
    
    AccessibilityNodeInfoCompat$CollectionInfoCompat(final Object mInfo) {
        this.mInfo = mInfo;
    }
    
    public static AccessibilityNodeInfoCompat$CollectionInfoCompat obtain(final int n, final int n2, final boolean b) {
        return new AccessibilityNodeInfoCompat$CollectionInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionInfo(n, n2, b));
    }
    
    public static AccessibilityNodeInfoCompat$CollectionInfoCompat obtain(final int n, final int n2, final boolean b, final int n3) {
        return new AccessibilityNodeInfoCompat$CollectionInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionInfo(n, n2, b, n3));
    }
    
    public int getColumnCount() {
        return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoColumnCount(this.mInfo);
    }
    
    public int getRowCount() {
        return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoRowCount(this.mInfo);
    }
    
    public int getSelectionMode() {
        return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoSelectionMode(this.mInfo);
    }
    
    public boolean isHierarchical() {
        return AccessibilityNodeInfoCompat.IMPL.isCollectionInfoHierarchical(this.mInfo);
    }
}
