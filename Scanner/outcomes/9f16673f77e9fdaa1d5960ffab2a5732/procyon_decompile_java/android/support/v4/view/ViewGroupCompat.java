// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build$VERSION;

public final class ViewGroupCompat
{
    static final ViewGroupCompat$ViewGroupCompatImpl IMPL;
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 21) {
            IMPL = new ViewGroupCompat$ViewGroupCompatLollipopImpl();
        }
        else if (sdk_INT >= 18) {
            IMPL = new ViewGroupCompat$ViewGroupCompatJellybeanMR2Impl();
        }
        else if (sdk_INT >= 14) {
            IMPL = new ViewGroupCompat$ViewGroupCompatIcsImpl();
        }
        else if (sdk_INT >= 11) {
            IMPL = new ViewGroupCompat$ViewGroupCompatHCImpl();
        }
        else {
            IMPL = new ViewGroupCompat$ViewGroupCompatStubImpl();
        }
    }
    
    public static int getLayoutMode(final ViewGroup viewGroup) {
        return ViewGroupCompat.IMPL.getLayoutMode(viewGroup);
    }
    
    public static int getNestedScrollAxes(final ViewGroup viewGroup) {
        return ViewGroupCompat.IMPL.getNestedScrollAxes(viewGroup);
    }
    
    public static boolean isTransitionGroup(final ViewGroup viewGroup) {
        return ViewGroupCompat.IMPL.isTransitionGroup(viewGroup);
    }
    
    public static boolean onRequestSendAccessibilityEvent(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return ViewGroupCompat.IMPL.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }
    
    public static void setLayoutMode(final ViewGroup viewGroup, final int n) {
        ViewGroupCompat.IMPL.setLayoutMode(viewGroup, n);
    }
    
    public static void setMotionEventSplittingEnabled(final ViewGroup viewGroup, final boolean b) {
        ViewGroupCompat.IMPL.setMotionEventSplittingEnabled(viewGroup, b);
    }
    
    public static void setTransitionGroup(final ViewGroup viewGroup, final boolean b) {
        ViewGroupCompat.IMPL.setTransitionGroup(viewGroup, b);
    }
}
