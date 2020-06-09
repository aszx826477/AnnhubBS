// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import java.math.BigDecimal;
import android.content.pm.ResolveInfo;

public final class ActivityChooserModel$ActivityResolveInfo implements Comparable
{
    public final ResolveInfo resolveInfo;
    final /* synthetic */ ActivityChooserModel this$0;
    public float weight;
    
    public ActivityChooserModel$ActivityResolveInfo(final ActivityChooserModel this$0, final ResolveInfo resolveInfo) {
        this.this$0 = this$0;
        this.resolveInfo = resolveInfo;
    }
    
    public int compareTo(final ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo) {
        return Float.floatToIntBits(activityChooserModel$ActivityResolveInfo.weight) - Float.floatToIntBits(this.weight);
    }
    
    public boolean equals(final Object o) {
        final boolean b = true;
        if (this == o) {
            return b;
        }
        return o != null && this.getClass() == o.getClass() && Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityChooserModel$ActivityResolveInfo)o).weight) && b;
    }
    
    public int hashCode() {
        return Float.floatToIntBits(this.weight) + 31;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("resolveInfo:");
        sb.append(this.resolveInfo.toString());
        sb.append("; weight:");
        sb.append(new BigDecimal(this.weight));
        sb.append("]");
        return sb.toString();
    }
}
