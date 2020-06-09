// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.util.SparseArray;
import java.util.ArrayList;
import android.graphics.Bitmap;
import android.app.PendingIntent;
import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.List;
import android.app.Notification$Builder;

public class NotificationCompatKitKat$Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions
{
    private Notification$Builder b;
    private List mActionExtrasList;
    private RemoteViews mBigContentView;
    private RemoteViews mContentView;
    private Bundle mExtras;
    
    public NotificationCompatKitKat$Builder(final Context context, final Notification notification, final CharSequence contentTitle, final CharSequence contentText, final CharSequence contentInfo, final RemoteViews remoteViews, final int number, final PendingIntent contentIntent, final PendingIntent pendingIntent, final Bitmap largeIcon, final int n, final int n2, final boolean b, final boolean showWhen, final boolean usesChronometer, final int priority, final CharSequence subText, final boolean b2, final ArrayList list, final Bundle bundle, final String s, final boolean b3, final String s2, final RemoteViews mContentView, final RemoteViews mBigContentView) {
        this.mActionExtrasList = new ArrayList();
        this.b = new Notification$Builder(context).setWhen(notification.when).setShowWhen(showWhen).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 0x2) != 0x0).setOnlyAlertOnce((notification.flags & 0x8) != 0x0).setAutoCancel((notification.flags & 0x10) != 0x0).setDefaults(notification.defaults).setContentTitle(contentTitle).setContentText(contentText).setSubText(subText).setContentInfo(contentInfo).setContentIntent(contentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent, (notification.flags & 0x80) != 0x0).setLargeIcon(largeIcon).setNumber(number).setUsesChronometer(usesChronometer).setPriority(priority).setProgress(n, n2, b);
        this.mExtras = new Bundle();
        if (bundle != null) {
            this.mExtras.putAll(bundle);
        }
        if (list != null && !list.isEmpty()) {
            this.mExtras.putStringArray("android.people", (String[])list.toArray(new String[list.size()]));
        }
        if (b2) {
            this.mExtras.putBoolean("android.support.localOnly", true);
        }
        if (s != null) {
            this.mExtras.putString("android.support.groupKey", s);
            if (b3) {
                this.mExtras.putBoolean("android.support.isGroupSummary", true);
            }
            else {
                this.mExtras.putBoolean("android.support.useSideChannel", true);
            }
        }
        if (s2 != null) {
            this.mExtras.putString("android.support.sortKey", s2);
        }
        this.mContentView = mContentView;
        this.mBigContentView = mBigContentView;
    }
    
    public void addAction(final NotificationCompatBase$Action notificationCompatBase$Action) {
        this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.b, notificationCompatBase$Action));
    }
    
    public Notification build() {
        final SparseArray buildActionExtrasMap = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
        if (buildActionExtrasMap != null) {
            this.mExtras.putSparseParcelableArray("android.support.actionExtras", buildActionExtrasMap);
        }
        this.b.setExtras(this.mExtras);
        final Notification build = this.b.build();
        final RemoteViews mContentView = this.mContentView;
        if (mContentView != null) {
            build.contentView = mContentView;
        }
        final RemoteViews mBigContentView = this.mBigContentView;
        if (mBigContentView != null) {
            build.bigContentView = mBigContentView;
        }
        return build;
    }
    
    public Notification$Builder getBuilder() {
        return this.b;
    }
}
