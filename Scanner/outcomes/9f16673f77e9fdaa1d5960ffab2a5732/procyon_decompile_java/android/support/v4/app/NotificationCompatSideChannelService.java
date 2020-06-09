// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Build$VERSION;
import android.os.IBinder;
import android.content.Intent;
import android.app.Notification;
import android.app.Service;

public abstract class NotificationCompatSideChannelService extends Service
{
    public abstract void cancel(final String p0, final int p1, final String p2);
    
    public abstract void cancelAll(final String p0);
    
    void checkPermission(final int n, final String s) {
        final String[] packagesForUid = this.getPackageManager().getPackagesForUid(n);
        for (int length = packagesForUid.length, i = 0; i < length; ++i) {
            if (packagesForUid[i].equals(s)) {
                return;
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("NotificationSideChannelService: Uid ");
        sb.append(n);
        sb.append(" is not authorized for package ");
        sb.append(s);
        throw new SecurityException(sb.toString());
    }
    
    public abstract void notify(final String p0, final int p1, final String p2, final Notification p3);
    
    public IBinder onBind(final Intent intent) {
        if (!intent.getAction().equals("android.support.BIND_NOTIFICATION_SIDE_CHANNEL")) {
            return null;
        }
        if (Build$VERSION.SDK_INT > 19) {
            return null;
        }
        return (IBinder)new NotificationCompatSideChannelService$NotificationSideChannelStub(this);
    }
}
