// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.VelocityTracker;
import android.os.Build$VERSION;

public final class VelocityTrackerCompat
{
    static final VelocityTrackerCompat$VelocityTrackerVersionImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            IMPL = new VelocityTrackerCompat$HoneycombVelocityTrackerVersionImpl();
        }
        else {
            IMPL = new VelocityTrackerCompat$BaseVelocityTrackerVersionImpl();
        }
    }
    
    public static float getXVelocity(final VelocityTracker velocityTracker, final int n) {
        return VelocityTrackerCompat.IMPL.getXVelocity(velocityTracker, n);
    }
    
    public static float getYVelocity(final VelocityTracker velocityTracker, final int n) {
        return VelocityTrackerCompat.IMPL.getYVelocity(velocityTracker, n);
    }
}
