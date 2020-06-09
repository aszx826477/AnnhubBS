// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.os.Build$VERSION;

public final class ScaleGestureDetectorCompat
{
    static final ScaleGestureDetectorCompat$ScaleGestureDetectorImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 19) {
            IMPL = new ScaleGestureDetectorCompat$ScaleGestureDetectorCompatKitKatImpl();
        }
        else {
            IMPL = new ScaleGestureDetectorCompat$BaseScaleGestureDetectorImpl();
        }
    }
    
    public static boolean isQuickScaleEnabled(final Object o) {
        return ScaleGestureDetectorCompat.IMPL.isQuickScaleEnabled(o);
    }
    
    public static void setQuickScaleEnabled(final Object o, final boolean b) {
        ScaleGestureDetectorCompat.IMPL.setQuickScaleEnabled(o, b);
    }
}
