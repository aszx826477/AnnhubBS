// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import java.math.BigDecimal;
import android.content.ComponentName;

public final class ActivityChooserModel$HistoricalRecord
{
    public final ComponentName activity;
    public final long time;
    public final float weight;
    
    public ActivityChooserModel$HistoricalRecord(final ComponentName activity, final long time, final float weight) {
        this.activity = activity;
        this.time = time;
        this.weight = weight;
    }
    
    public ActivityChooserModel$HistoricalRecord(final String s, final long n, final float n2) {
        this(ComponentName.unflattenFromString(s), n, n2);
    }
    
    public boolean equals(final Object o) {
        final boolean b = true;
        if (this == o) {
            return b;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        final ActivityChooserModel$HistoricalRecord activityChooserModel$HistoricalRecord = (ActivityChooserModel$HistoricalRecord)o;
        final ComponentName activity = this.activity;
        if (activity == null) {
            if (activityChooserModel$HistoricalRecord.activity != null) {
                return false;
            }
        }
        else if (!activity.equals((Object)activityChooserModel$HistoricalRecord.activity)) {
            return false;
        }
        return this.time == activityChooserModel$HistoricalRecord.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(activityChooserModel$HistoricalRecord.weight) && b;
    }
    
    public int hashCode() {
        final int n = 1 * 31;
        final ComponentName activity = this.activity;
        int hashCode;
        if (activity == null) {
            hashCode = 0;
        }
        else {
            hashCode = activity.hashCode();
        }
        final int n2 = (n + hashCode) * 31;
        final long time = this.time;
        return (n2 + (int)(time ^ time >>> 32)) * 31 + Float.floatToIntBits(this.weight);
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("; activity:");
        sb.append(this.activity);
        sb.append("; time:");
        sb.append(this.time);
        sb.append("; weight:");
        sb.append(new BigDecimal(this.weight));
        sb.append("]");
        return sb.toString();
    }
}
