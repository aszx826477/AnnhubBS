// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.hardware.display;

import android.view.Display;
import android.os.Build$VERSION;
import android.content.Context;
import java.util.WeakHashMap;

public abstract class DisplayManagerCompat
{
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap sInstances;
    
    static {
        sInstances = new WeakHashMap();
    }
    
    public static DisplayManagerCompat getInstance(final Context context) {
        synchronized (DisplayManagerCompat.sInstances) {
            DisplayManagerCompat displayManagerCompat = DisplayManagerCompat.sInstances.get(context);
            if (displayManagerCompat == null) {
                if (Build$VERSION.SDK_INT >= 17) {
                    displayManagerCompat = new DisplayManagerCompat$JellybeanMr1Impl(context);
                }
                else {
                    displayManagerCompat = new DisplayManagerCompat$LegacyImpl(context);
                }
                DisplayManagerCompat.sInstances.put(context, displayManagerCompat);
            }
            return displayManagerCompat;
        }
    }
    
    public abstract Display getDisplay(final int p0);
    
    public abstract Display[] getDisplays();
    
    public abstract Display[] getDisplays(final String p0);
}
