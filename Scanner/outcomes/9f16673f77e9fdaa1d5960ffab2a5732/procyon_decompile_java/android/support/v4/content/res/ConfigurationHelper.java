// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content.res;

import android.content.res.Resources;
import android.os.Build$VERSION;

public final class ConfigurationHelper
{
    private static final ConfigurationHelper$ConfigurationHelperImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 17) {
            IMPL = new ConfigurationHelper$JellybeanMr1Impl();
        }
        else if (sdk_INT >= 13) {
            IMPL = new ConfigurationHelper$HoneycombMr2Impl();
        }
        else {
            IMPL = new ConfigurationHelper$GingerbreadImpl();
        }
    }
    
    public static int getDensityDpi(final Resources resources) {
        return ConfigurationHelper.IMPL.getDensityDpi(resources);
    }
    
    public static int getScreenHeightDp(final Resources resources) {
        return ConfigurationHelper.IMPL.getScreenHeightDp(resources);
    }
    
    public static int getScreenWidthDp(final Resources resources) {
        return ConfigurationHelper.IMPL.getScreenWidthDp(resources);
    }
    
    public static int getSmallestScreenWidthDp(final Resources resources) {
        return ConfigurationHelper.IMPL.getSmallestScreenWidthDp(resources);
    }
}
