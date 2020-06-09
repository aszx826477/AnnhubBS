// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.util;

import android.os.SystemClock;
import android.os.Build$VERSION;

public final class LogTime
{
    private static final double MILLIS_MULTIPLIER;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        double millis_MULTIPLIER = 1.0;
        if (17 <= sdk_INT) {
            millis_MULTIPLIER /= Math.pow(10.0, 6.0);
        }
        MILLIS_MULTIPLIER = millis_MULTIPLIER;
    }
    
    public static double getElapsedMillis(final long n) {
        final double n2 = getLogTime() - n;
        final double millis_MULTIPLIER = LogTime.MILLIS_MULTIPLIER;
        Double.isNaN(n2);
        return n2 * millis_MULTIPLIER;
    }
    
    public static long getLogTime() {
        if (17 <= Build$VERSION.SDK_INT) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return System.currentTimeMillis();
    }
}
