// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Bundle;
import android.app.Notification;

class NotificationCompat$NotificationCompatImplApi21 extends NotificationCompat$NotificationCompatImplApi20
{
    public Notification build(final NotificationCompat$Builder notificationCompat$Builder, final NotificationCompat$BuilderExtender notificationCompat$BuilderExtender) {
        final NotificationCompatApi21$Builder notificationCompatApi21$Builder = new NotificationCompatApi21$Builder(notificationCompat$Builder.mContext, notificationCompat$Builder.mNotification, notificationCompat$Builder.resolveTitle(), notificationCompat$Builder.resolveText(), notificationCompat$Builder.mContentInfo, notificationCompat$Builder.mTickerView, notificationCompat$Builder.mNumber, notificationCompat$Builder.mContentIntent, notificationCompat$Builder.mFullScreenIntent, notificationCompat$Builder.mLargeIcon, notificationCompat$Builder.mProgressMax, notificationCompat$Builder.mProgress, notificationCompat$Builder.mProgressIndeterminate, notificationCompat$Builder.mShowWhen, notificationCompat$Builder.mUseChronometer, notificationCompat$Builder.mPriority, notificationCompat$Builder.mSubText, notificationCompat$Builder.mLocalOnly, notificationCompat$Builder.mCategory, notificationCompat$Builder.mPeople, notificationCompat$Builder.mExtras, notificationCompat$Builder.mColor, notificationCompat$Builder.mVisibility, notificationCompat$Builder.mPublicVersion, notificationCompat$Builder.mGroupKey, notificationCompat$Builder.mGroupSummary, notificationCompat$Builder.mSortKey, notificationCompat$Builder.mContentView, notificationCompat$Builder.mBigContentView, notificationCompat$Builder.mHeadsUpContentView);
        NotificationCompat.addActionsToBuilder(notificationCompatApi21$Builder, notificationCompat$Builder.mActions);
        NotificationCompat.addStyleToBuilderJellybean(notificationCompatApi21$Builder, notificationCompat$Builder.mStyle);
        final Notification build = notificationCompat$BuilderExtender.build(notificationCompat$Builder, notificationCompatApi21$Builder);
        if (notificationCompat$Builder.mStyle != null) {
            notificationCompat$Builder.mStyle.addCompatExtras(this.getExtras(build));
        }
        return build;
    }
    
    public Bundle getBundleForUnreadConversation(final NotificationCompatBase$UnreadConversation notificationCompatBase$UnreadConversation) {
        return NotificationCompatApi21.getBundleForUnreadConversation(notificationCompatBase$UnreadConversation);
    }
    
    public String getCategory(final Notification notification) {
        return NotificationCompatApi21.getCategory(notification);
    }
    
    public NotificationCompatBase$UnreadConversation getUnreadConversationFromBundle(final Bundle bundle, final NotificationCompatBase$UnreadConversation$Factory notificationCompatBase$UnreadConversation$Factory, final RemoteInputCompatBase$RemoteInput$Factory remoteInputCompatBase$RemoteInput$Factory) {
        return NotificationCompatApi21.getUnreadConversationFromBundle(bundle, notificationCompatBase$UnreadConversation$Factory, remoteInputCompatBase$RemoteInput$Factory);
    }
}
