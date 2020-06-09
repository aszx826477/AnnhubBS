// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.graphics.Bitmap;
import android.app.PendingIntent;
import android.widget.RemoteViews;
import android.app.Notification;
import android.content.Context;
import android.app.Notification$Builder;

public class NotificationCompatIceCreamSandwich$Builder implements NotificationBuilderWithBuilderAccessor
{
    private Notification$Builder b;
    
    public NotificationCompatIceCreamSandwich$Builder(final Context context, final Notification notification, final CharSequence contentTitle, final CharSequence contentText, final CharSequence contentInfo, final RemoteViews remoteViews, final int number, final PendingIntent contentIntent, final PendingIntent pendingIntent, final Bitmap largeIcon, final int n, final int n2, final boolean b) {
        final Notification$Builder setLights = new Notification$Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        final int n3 = notification.flags & 0x2;
        boolean b2 = true;
        final Notification$Builder setDeleteIntent = setLights.setOngoing(n3 != 0).setOnlyAlertOnce((notification.flags & 0x8) != 0x0).setAutoCancel((notification.flags & 0x10) != 0x0).setDefaults(notification.defaults).setContentTitle(contentTitle).setContentText(contentText).setContentInfo(contentInfo).setContentIntent(contentIntent).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & 0x80) == 0x0) {
            b2 = false;
        }
        this.b = setDeleteIntent.setFullScreenIntent(pendingIntent, b2).setLargeIcon(largeIcon).setNumber(number).setProgress(n, n2, b);
    }
    
    public Notification build() {
        return this.b.getNotification();
    }
    
    public Notification$Builder getBuilder() {
        return this.b;
    }
}
