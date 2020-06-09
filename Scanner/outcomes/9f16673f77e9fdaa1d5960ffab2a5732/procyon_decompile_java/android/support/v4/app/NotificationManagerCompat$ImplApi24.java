// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.NotificationManager;
import android.content.Context;

class NotificationManagerCompat$ImplApi24 extends NotificationManagerCompat$ImplKitKat
{
    public boolean areNotificationsEnabled(final Context context, final NotificationManager notificationManager) {
        return NotificationManagerCompatApi24.areNotificationsEnabled(notificationManager);
    }
    
    public int getImportance(final NotificationManager notificationManager) {
        return NotificationManagerCompatApi24.getImportance(notificationManager);
    }
}
