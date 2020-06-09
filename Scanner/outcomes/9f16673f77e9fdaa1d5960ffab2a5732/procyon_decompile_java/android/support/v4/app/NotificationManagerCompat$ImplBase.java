// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

class NotificationManagerCompat$ImplBase implements NotificationManagerCompat$Impl
{
    public boolean areNotificationsEnabled(final Context context, final NotificationManager notificationManager) {
        return true;
    }
    
    public void cancelNotification(final NotificationManager notificationManager, final String s, final int n) {
        notificationManager.cancel(s, n);
    }
    
    public int getImportance(final NotificationManager notificationManager) {
        return -1000;
    }
    
    public int getSideChannelBindFlags() {
        return 1;
    }
    
    public void postNotification(final NotificationManager notificationManager, final String s, final int n, final Notification notification) {
        notificationManager.notify(s, n, notification);
    }
}
