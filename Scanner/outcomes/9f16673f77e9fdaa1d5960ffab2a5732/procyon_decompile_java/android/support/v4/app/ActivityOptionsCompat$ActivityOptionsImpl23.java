// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Bundle;
import android.app.PendingIntent;

class ActivityOptionsCompat$ActivityOptionsImpl23 extends ActivityOptionsCompat
{
    private final ActivityOptionsCompat23 mImpl;
    
    ActivityOptionsCompat$ActivityOptionsImpl23(final ActivityOptionsCompat23 mImpl) {
        this.mImpl = mImpl;
    }
    
    public void requestUsageTimeReport(final PendingIntent pendingIntent) {
        this.mImpl.requestUsageTimeReport(pendingIntent);
    }
    
    public Bundle toBundle() {
        return this.mImpl.toBundle();
    }
    
    public void update(final ActivityOptionsCompat activityOptionsCompat) {
        if (activityOptionsCompat instanceof ActivityOptionsCompat$ActivityOptionsImpl23) {
            this.mImpl.update(((ActivityOptionsCompat$ActivityOptionsImpl23)activityOptionsCompat).mImpl);
        }
    }
}
