// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.hardware.display;

import android.view.Display;
import android.content.Context;

class DisplayManagerCompat$JellybeanMr1Impl extends DisplayManagerCompat
{
    private final Object mDisplayManagerObj;
    
    public DisplayManagerCompat$JellybeanMr1Impl(final Context context) {
        this.mDisplayManagerObj = DisplayManagerJellybeanMr1.getDisplayManager(context);
    }
    
    public Display getDisplay(final int n) {
        return DisplayManagerJellybeanMr1.getDisplay(this.mDisplayManagerObj, n);
    }
    
    public Display[] getDisplays() {
        return DisplayManagerJellybeanMr1.getDisplays(this.mDisplayManagerObj);
    }
    
    public Display[] getDisplays(final String s) {
        return DisplayManagerJellybeanMr1.getDisplays(this.mDisplayManagerObj, s);
    }
}
