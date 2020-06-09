// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.MotionEvent;

class MotionEventCompat$ICSMotionEventVersionImpl extends MotionEventCompat$HoneycombMr1MotionEventVersionImpl
{
    public int getButtonState(final MotionEvent motionEvent) {
        return MotionEventCompatICS.getButtonState(motionEvent);
    }
}
