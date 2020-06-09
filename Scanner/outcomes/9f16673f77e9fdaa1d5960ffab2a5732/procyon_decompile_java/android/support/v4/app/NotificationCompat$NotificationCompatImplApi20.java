// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import java.util.ArrayList;
import android.app.Notification;

class NotificationCompat$NotificationCompatImplApi20 extends NotificationCompat$NotificationCompatImplKitKat
{
    public Notification build(final NotificationCompat$Builder notificationCompat$Builder, final NotificationCompat$BuilderExtender notificationCompat$BuilderExtender) {
        final NotificationCompatApi20$Builder notificationCompatApi20$Builder = new NotificationCompatApi20$Builder(notificationCompat$Builder.mContext, notificationCompat$Builder.mNotification, notificationCompat$Builder.resolveTitle(), notificationCompat$Builder.resolveText(), notificationCompat$Builder.mContentInfo, notificationCompat$Builder.mTickerView, notificationCompat$Builder.mNumber, notificationCompat$Builder.mContentIntent, notificationCompat$Builder.mFullScreenIntent, notificationCompat$Builder.mLargeIcon, notificationCompat$Builder.mProgressMax, notificationCompat$Builder.mProgress, notificationCompat$Builder.mProgressIndeterminate, notificationCompat$Builder.mShowWhen, notificationCompat$Builder.mUseChronometer, notificationCompat$Builder.mPriority, notificationCompat$Builder.mSubText, notificationCompat$Builder.mLocalOnly, notificationCompat$Builder.mPeople, notificationCompat$Builder.mExtras, notificationCompat$Builder.mGroupKey, notificationCompat$Builder.mGroupSummary, notificationCompat$Builder.mSortKey, notificationCompat$Builder.mContentView, notificationCompat$Builder.mBigContentView);
        NotificationCompat.addActionsToBuilder(notificationCompatApi20$Builder, notificationCompat$Builder.mActions);
        NotificationCompat.addStyleToBuilderJellybean(notificationCompatApi20$Builder, notificationCompat$Builder.mStyle);
        final Notification build = notificationCompat$BuilderExtender.build(notificationCompat$Builder, notificationCompatApi20$Builder);
        if (notificationCompat$Builder.mStyle != null) {
            notificationCompat$Builder.mStyle.addCompatExtras(this.getExtras(build));
        }
        return build;
    }
    
    public NotificationCompat$Action getAction(final Notification notification, final int n) {
        return (NotificationCompat$Action)NotificationCompatApi20.getAction(notification, n, NotificationCompat$Action.FACTORY, RemoteInput.FACTORY);
    }
    
    public NotificationCompat$Action[] getActionsFromParcelableArrayList(final ArrayList list) {
        return (NotificationCompat$Action[])NotificationCompatApi20.getActionsFromParcelableArrayList(list, NotificationCompat$Action.FACTORY, RemoteInput.FACTORY);
    }
    
    public String getGroup(final Notification notification) {
        return NotificationCompatApi20.getGroup(notification);
    }
    
    public boolean getLocalOnly(final Notification notification) {
        return NotificationCompatApi20.getLocalOnly(notification);
    }
    
    public ArrayList getParcelableArrayListForActions(final NotificationCompat$Action[] array) {
        return NotificationCompatApi20.getParcelableArrayListForActions(array);
    }
    
    public String getSortKey(final Notification notification) {
        return NotificationCompatApi20.getSortKey(notification);
    }
    
    public boolean isGroupSummary(final Notification notification) {
        return NotificationCompatApi20.isGroupSummary(notification);
    }
}
