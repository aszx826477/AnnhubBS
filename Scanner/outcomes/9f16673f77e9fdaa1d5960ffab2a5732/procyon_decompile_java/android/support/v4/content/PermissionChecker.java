// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import android.support.v4.app.AppOpsManagerCompat;
import android.os.Process;
import android.os.Binder;
import android.content.Context;

public final class PermissionChecker
{
    public static final int PERMISSION_DENIED = 255;
    public static final int PERMISSION_DENIED_APP_OP = 254;
    public static final int PERMISSION_GRANTED;
    
    public static int checkCallingOrSelfPermission(final Context context, final String s) {
        String packageName;
        if (Binder.getCallingPid() == Process.myPid()) {
            packageName = context.getPackageName();
        }
        else {
            packageName = null;
        }
        return checkPermission(context, s, Binder.getCallingPid(), Binder.getCallingUid(), packageName);
    }
    
    public static int checkCallingPermission(final Context context, final String s, final String s2) {
        if (Binder.getCallingPid() == Process.myPid()) {
            return -1;
        }
        return checkPermission(context, s, Binder.getCallingPid(), Binder.getCallingUid(), s2);
    }
    
    public static int checkPermission(final Context context, final String s, final int n, final int n2, String s2) {
        final int checkPermission = context.checkPermission(s, n, n2);
        final int n3 = -1;
        if (checkPermission == n3) {
            return n3;
        }
        final String permissionToOp = AppOpsManagerCompat.permissionToOp(s);
        if (permissionToOp == null) {
            return 0;
        }
        if (s2 == null) {
            final String[] packagesForUid = context.getPackageManager().getPackagesForUid(n2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return n3;
            }
            s2 = packagesForUid[0];
        }
        if (AppOpsManagerCompat.noteProxyOp(context, permissionToOp, s2) != 0) {
            return -2;
        }
        return 0;
    }
    
    public static int checkSelfPermission(final Context context, final String s) {
        return checkPermission(context, s, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
