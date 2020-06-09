// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

public class AccessibilityNodeInfoCompat$RangeInfoCompat
{
    public static final int RANGE_TYPE_FLOAT = 1;
    public static final int RANGE_TYPE_INT = 0;
    public static final int RANGE_TYPE_PERCENT = 2;
    final Object mInfo;
    
    AccessibilityNodeInfoCompat$RangeInfoCompat(final Object mInfo) {
        this.mInfo = mInfo;
    }
    
    public static AccessibilityNodeInfoCompat$RangeInfoCompat obtain(final int n, final float n2, final float n3, final float n4) {
        return new AccessibilityNodeInfoCompat$RangeInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainRangeInfo(n, n2, n3, n4));
    }
    
    public float getCurrent() {
        return AccessibilityNodeInfoCompatKitKat$RangeInfo.getCurrent(this.mInfo);
    }
    
    public float getMax() {
        return AccessibilityNodeInfoCompatKitKat$RangeInfo.getMax(this.mInfo);
    }
    
    public float getMin() {
        return AccessibilityNodeInfoCompatKitKat$RangeInfo.getMin(this.mInfo);
    }
    
    public int getType() {
        return AccessibilityNodeInfoCompatKitKat$RangeInfo.getType(this.mInfo);
    }
}
