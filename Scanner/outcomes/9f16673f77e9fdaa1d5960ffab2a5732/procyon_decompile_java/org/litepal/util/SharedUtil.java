// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.util;

import android.content.SharedPreferences$Editor;
import org.litepal.LitePalApplication;

public class SharedUtil
{
    private static final String LITEPAL_PREPS = "litepal_prefs";
    private static final String VERSION = "litepal_version";
    
    public static int getLastVersion() {
        return LitePalApplication.getContext().getSharedPreferences("litepal_prefs", 0).getInt("litepal_version", 0);
    }
    
    public static void updateVersion(final int n) {
        final SharedPreferences$Editor edit = LitePalApplication.getContext().getSharedPreferences("litepal_prefs", 0).edit();
        edit.putInt("litepal_version", n);
        edit.apply();
    }
}
