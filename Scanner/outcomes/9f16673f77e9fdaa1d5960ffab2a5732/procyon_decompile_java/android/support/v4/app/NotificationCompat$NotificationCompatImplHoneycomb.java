// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.Notification;

class NotificationCompat$NotificationCompatImplHoneycomb extends NotificationCompat$NotificationCompatImplBase
{
    public Notification build(final NotificationCompat$Builder notificationCompat$Builder, final NotificationCompat$BuilderExtender notificationCompat$BuilderExtender) {
        final Notification add = NotificationCompatHoneycomb.add(notificationCompat$Builder.mContext, notificationCompat$Builder.mNotification, notificationCompat$Builder.resolveTitle(), notificationCompat$Builder.resolveText(), notificationCompat$Builder.mContentInfo, notificationCompat$Builder.mTickerView, notificationCompat$Builder.mNumber, notificationCompat$Builder.mContentIntent, notificationCompat$Builder.mFullScreenIntent, notificationCompat$Builder.mLargeIcon);
        if (notificationCompat$Builder.mContentView != null) {
            add.contentView = notificationCompat$Builder.mContentView;
        }
        return add;
    }
}
