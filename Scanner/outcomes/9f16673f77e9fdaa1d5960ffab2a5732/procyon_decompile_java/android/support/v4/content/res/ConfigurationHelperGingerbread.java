// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content.res;

import android.util.DisplayMetrics;
import android.content.res.Resources;

class ConfigurationHelperGingerbread
{
    static int getDensityDpi(final Resources resources) {
        return resources.getDisplayMetrics().densityDpi;
    }
    
    static int getScreenHeightDp(final Resources resources) {
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int)(displayMetrics.heightPixels / displayMetrics.density);
    }
    
    static int getScreenWidthDp(final Resources resources) {
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return (int)(displayMetrics.widthPixels / displayMetrics.density);
    }
    
    static int getSmallestScreenWidthDp(final Resources resources) {
        return Math.min(getScreenWidthDp(resources), getScreenHeightDp(resources));
    }
}
