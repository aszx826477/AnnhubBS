// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.content.Context;

class AppOpsManagerCompat$AppOpsManager23 extends AppOpsManagerCompat$AppOpsManagerImpl
{
    public int noteOp(final Context context, final String s, final int n, final String s2) {
        return AppOpsManagerCompat23.noteOp(context, s, n, s2);
    }
    
    public int noteProxyOp(final Context context, final String s, final String s2) {
        return AppOpsManagerCompat23.noteProxyOp(context, s, s2);
    }
    
    public String permissionToOp(final String s) {
        return AppOpsManagerCompat23.permissionToOp(s);
    }
}
