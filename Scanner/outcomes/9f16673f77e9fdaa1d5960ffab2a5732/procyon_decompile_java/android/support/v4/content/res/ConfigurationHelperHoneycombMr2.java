// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content.res;

import android.content.res.Resources;

class ConfigurationHelperHoneycombMr2
{
    static int getScreenHeightDp(final Resources resources) {
        return resources.getConfiguration().screenHeightDp;
    }
    
    static int getScreenWidthDp(final Resources resources) {
        return resources.getConfiguration().screenWidthDp;
    }
    
    static int getSmallestScreenWidthDp(final Resources resources) {
        return resources.getConfiguration().smallestScreenWidthDp;
    }
}
