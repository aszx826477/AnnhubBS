// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.NotificationManager;
import android.content.Context;

class NotificationManagerCompat$ImplKitKat extends NotificationManagerCompat$ImplIceCreamSandwich
{
    public boolean areNotificationsEnabled(final Context context, final NotificationManager notificationManager) {
        return NotificationManagerCompatKitKat.areNotificationsEnabled(context);
    }
}
