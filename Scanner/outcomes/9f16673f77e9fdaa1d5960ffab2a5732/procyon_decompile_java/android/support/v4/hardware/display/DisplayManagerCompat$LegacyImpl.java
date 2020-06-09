// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.hardware.display;

import android.view.Display;
import android.content.Context;
import android.view.WindowManager;

class DisplayManagerCompat$LegacyImpl extends DisplayManagerCompat
{
    private final WindowManager mWindowManager;
    
    public DisplayManagerCompat$LegacyImpl(final Context context) {
        this.mWindowManager = (WindowManager)context.getSystemService("window");
    }
    
    public Display getDisplay(final int n) {
        final Display defaultDisplay = this.mWindowManager.getDefaultDisplay();
        if (defaultDisplay.getDisplayId() == n) {
            return defaultDisplay;
        }
        return null;
    }
    
    public Display[] getDisplays() {
        return new Display[] { this.mWindowManager.getDefaultDisplay() };
    }
    
    public Display[] getDisplays(final String s) {
        Display[] displays;
        if (s == null) {
            displays = this.getDisplays();
        }
        else {
            displays = new Display[0];
        }
        return displays;
    }
}
