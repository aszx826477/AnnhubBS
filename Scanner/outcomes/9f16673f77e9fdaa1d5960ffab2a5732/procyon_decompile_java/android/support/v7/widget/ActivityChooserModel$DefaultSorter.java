// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import java.util.Collections;
import android.content.ComponentName;
import java.util.List;
import android.content.Intent;
import java.util.HashMap;
import java.util.Map;

final class ActivityChooserModel$DefaultSorter implements ActivityChooserModel$ActivitySorter
{
    private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
    private final Map mPackageNameToActivityMap;
    final /* synthetic */ ActivityChooserModel this$0;
    
    ActivityChooserModel$DefaultSorter(final ActivityChooserModel this$0) {
        this.this$0 = this$0;
        this.mPackageNameToActivityMap = new HashMap();
    }
    
    public void sort(final Intent intent, final List list, final List list2) {
        final Map mPackageNameToActivityMap = this.mPackageNameToActivityMap;
        mPackageNameToActivityMap.clear();
        for (int size = list.size(), i = 0; i < size; ++i) {
            final ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo = list.get(i);
            activityChooserModel$ActivityResolveInfo.weight = 0.0f;
            mPackageNameToActivityMap.put(new ComponentName(activityChooserModel$ActivityResolveInfo.resolveInfo.activityInfo.packageName, activityChooserModel$ActivityResolveInfo.resolveInfo.activityInfo.name), activityChooserModel$ActivityResolveInfo);
        }
        final int n = list2.size() - 1;
        float n2 = 1.0f;
        for (int j = n; j >= 0; --j) {
            final ActivityChooserModel$HistoricalRecord activityChooserModel$HistoricalRecord = list2.get(j);
            final ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo2 = mPackageNameToActivityMap.get(activityChooserModel$HistoricalRecord.activity);
            if (activityChooserModel$ActivityResolveInfo2 != null) {
                activityChooserModel$ActivityResolveInfo2.weight += activityChooserModel$HistoricalRecord.weight * n2;
                n2 *= 0.95f;
            }
        }
        Collections.sort(list);
    }
}
