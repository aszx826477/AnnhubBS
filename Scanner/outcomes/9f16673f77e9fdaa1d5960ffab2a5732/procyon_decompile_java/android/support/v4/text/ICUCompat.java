// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.text;

import java.util.Locale;
import android.os.Build$VERSION;

public final class ICUCompat
{
    private static final ICUCompat$ICUCompatImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 21) {
            IMPL = new ICUCompat$ICUCompatImplLollipop();
        }
        else if (sdk_INT >= 14) {
            IMPL = new ICUCompat$ICUCompatImplIcs();
        }
        else {
            IMPL = new ICUCompat$ICUCompatImplBase();
        }
    }
    
    public static String maximizeAndGetScript(final Locale locale) {
        return ICUCompat.IMPL.maximizeAndGetScript(locale);
    }
}
