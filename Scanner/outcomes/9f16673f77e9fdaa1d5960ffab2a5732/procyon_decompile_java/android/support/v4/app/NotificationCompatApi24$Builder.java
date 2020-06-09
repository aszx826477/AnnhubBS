// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.RemoteInput;
import android.app.Notification$Action$Builder;
import java.util.Iterator;
import android.os.Bundle;
import java.util.ArrayList;
import android.graphics.Bitmap;
import android.app.PendingIntent;
import android.widget.RemoteViews;
import android.app.Notification;
import android.content.Context;
import android.app.Notification$Builder;

public class NotificationCompatApi24$Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions
{
    private Notification$Builder b;
    
    public NotificationCompatApi24$Builder(final Context context, final Notification notification, final CharSequence contentTitle, final CharSequence contentText, final CharSequence contentInfo, final RemoteViews remoteViews, final int number, final PendingIntent contentIntent, final PendingIntent pendingIntent, final Bitmap largeIcon, final int n, final int n2, final boolean b, final boolean showWhen, final boolean usesChronometer, final int priority, final CharSequence subText, final boolean localOnly, final String category, final ArrayList list, final Bundle extras, final int color, final int visibility, final Notification publicVersion, final String group, final boolean groupSummary, final String sortKey, final CharSequence[] remoteInputHistory, final RemoteViews customContentView, final RemoteViews customBigContentView, final RemoteViews customHeadsUpContentView) {
        final Notification$Builder setLights = new Notification$Builder(context).setWhen(notification.when).setShowWhen(showWhen).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        final int n3 = notification.flags & 0x2;
        boolean b2 = false;
        final Notification$Builder setDeleteIntent = setLights.setOngoing(n3 != 0).setOnlyAlertOnce((notification.flags & 0x8) != 0x0).setAutoCancel((notification.flags & 0x10) != 0x0).setDefaults(notification.defaults).setContentTitle(contentTitle).setContentText(contentText).setSubText(subText).setContentInfo(contentInfo).setContentIntent(contentIntent).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & 0x80) != 0x0) {
            b2 = true;
        }
        this.b = setDeleteIntent.setFullScreenIntent(pendingIntent, b2).setLargeIcon(largeIcon).setNumber(number).setUsesChronometer(usesChronometer).setPriority(priority).setProgress(n, n2, b).setLocalOnly(localOnly).setExtras(extras).setGroup(group).setGroupSummary(groupSummary).setSortKey(sortKey).setCategory(category).setColor(color).setVisibility(visibility).setPublicVersion(publicVersion).setRemoteInputHistory(remoteInputHistory);
        if (customContentView != null) {
            this.b.setCustomContentView(customContentView);
        }
        if (customBigContentView != null) {
            this.b.setCustomBigContentView(customBigContentView);
        }
        if (customHeadsUpContentView != null) {
            this.b.setCustomHeadsUpContentView(customHeadsUpContentView);
        }
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.b.addPerson((String)iterator.next());
        }
    }
    
    public void addAction(final NotificationCompatBase$Action notificationCompatBase$Action) {
        final Notification$Action$Builder notification$Action$Builder = new Notification$Action$Builder(notificationCompatBase$Action.getIcon(), notificationCompatBase$Action.getTitle(), notificationCompatBase$Action.getActionIntent());
        if (notificationCompatBase$Action.getRemoteInputs() != null) {
            final RemoteInput[] fromCompat = RemoteInputCompatApi20.fromCompat(notificationCompatBase$Action.getRemoteInputs());
            for (int length = fromCompat.length, i = 0; i < length; ++i) {
                notification$Action$Builder.addRemoteInput(fromCompat[i]);
            }
        }
        Bundle bundle;
        if (notificationCompatBase$Action.getExtras() != null) {
            bundle = new Bundle(notificationCompatBase$Action.getExtras());
        }
        else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", notificationCompatBase$Action.getAllowGeneratedReplies());
        notification$Action$Builder.addExtras(bundle);
        notification$Action$Builder.setAllowGeneratedReplies(notificationCompatBase$Action.getAllowGeneratedReplies());
        this.b.addAction(notification$Action$Builder.build());
    }
    
    public Notification build() {
        return this.b.build();
    }
    
    public Notification$Builder getBuilder() {
        return this.b;
    }
}
