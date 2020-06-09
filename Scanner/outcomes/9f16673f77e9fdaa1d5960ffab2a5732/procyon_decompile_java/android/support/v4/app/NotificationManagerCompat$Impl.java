// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

interface NotificationManagerCompat$Impl
{
    boolean areNotificationsEnabled(final Context p0, final NotificationManager p1);
    
    void cancelNotification(final NotificationManager p0, final String p1, final int p2);
    
    int getImportance(final NotificationManager p0);
    
    int getSideChannelBindFlags();
    
    void postNotification(final NotificationManager p0, final String p1, final int p2, final Notification p3);
}
