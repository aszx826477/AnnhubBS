// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

public class AccessibilityNodeInfoCompat$CollectionItemInfoCompat
{
    final Object mInfo;
    
    AccessibilityNodeInfoCompat$CollectionItemInfoCompat(final Object mInfo) {
        this.mInfo = mInfo;
    }
    
    public static AccessibilityNodeInfoCompat$CollectionItemInfoCompat obtain(final int n, final int n2, final int n3, final int n4, final boolean b) {
        return new AccessibilityNodeInfoCompat$CollectionItemInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionItemInfo(n, n2, n3, n4, b));
    }
    
    public static AccessibilityNodeInfoCompat$CollectionItemInfoCompat obtain(final int n, final int n2, final int n3, final int n4, final boolean b, final boolean b2) {
        return new AccessibilityNodeInfoCompat$CollectionItemInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionItemInfo(n, n2, n3, n4, b, b2));
    }
    
    public int getColumnIndex() {
        return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnIndex(this.mInfo);
    }
    
    public int getColumnSpan() {
        return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnSpan(this.mInfo);
    }
    
    public int getRowIndex() {
        return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowIndex(this.mInfo);
    }
    
    public int getRowSpan() {
        return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowSpan(this.mInfo);
    }
    
    public boolean isHeading() {
        return AccessibilityNodeInfoCompat.IMPL.isCollectionItemHeading(this.mInfo);
    }
    
    public boolean isSelected() {
        return AccessibilityNodeInfoCompat.IMPL.isCollectionItemSelected(this.mInfo);
    }
}
