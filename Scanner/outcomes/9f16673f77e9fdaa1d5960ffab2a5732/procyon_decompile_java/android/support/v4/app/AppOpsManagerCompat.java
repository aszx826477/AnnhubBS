// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.content.Context;
import android.os.Build$VERSION;

public final class AppOpsManagerCompat
{
    private static final AppOpsManagerCompat$AppOpsManagerImpl IMPL;
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_IGNORED = 1;
    
    static {
        if (Build$VERSION.SDK_INT >= 23) {
            IMPL = new AppOpsManagerCompat$AppOpsManager23();
        }
        else {
            IMPL = new AppOpsManagerCompat$AppOpsManagerImpl();
        }
    }
    
    public static int noteOp(final Context context, final String s, final int n, final String s2) {
        return AppOpsManagerCompat.IMPL.noteOp(context, s, n, s2);
    }
    
    public static int noteProxyOp(final Context context, final String s, final String s2) {
        return AppOpsManagerCompat.IMPL.noteProxyOp(context, s, s2);
    }
    
    public static String permissionToOp(final String s) {
        return AppOpsManagerCompat.IMPL.permissionToOp(s);
    }
}
