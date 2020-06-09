// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.util;

import android.util.Log;

public final class LogUtil
{
    public static final int DEBUG = 2;
    public static final int ERROR = 5;
    public static int level;
    
    static {
        LogUtil.level = 5;
    }
    
    public static void d(final String s, final String s2) {
        if (LogUtil.level <= 2) {
            Log.d(s, s2);
        }
    }
    
    public static void e(final String s, final Exception ex) {
        if (LogUtil.level <= 5) {
            Log.e(s, ex.getMessage(), (Throwable)ex);
        }
    }
}
