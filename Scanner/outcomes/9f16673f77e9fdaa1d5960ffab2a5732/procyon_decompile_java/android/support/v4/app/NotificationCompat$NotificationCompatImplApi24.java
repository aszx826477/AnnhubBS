// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.Notification;

class NotificationCompat$NotificationCompatImplApi24 extends NotificationCompat$NotificationCompatImplApi21
{
    public Notification build(final NotificationCompat$Builder notificationCompat$Builder, final NotificationCompat$BuilderExtender notificationCompat$BuilderExtender) {
        final NotificationCompatApi24$Builder notificationCompatApi24$Builder = new NotificationCompatApi24$Builder(notificationCompat$Builder.mContext, notificationCompat$Builder.mNotification, notificationCompat$Builder.mContentTitle, notificationCompat$Builder.mContentText, notificationCompat$Builder.mContentInfo, notificationCompat$Builder.mTickerView, notificationCompat$Builder.mNumber, notificationCompat$Builder.mContentIntent, notificationCompat$Builder.mFullScreenIntent, notificationCompat$Builder.mLargeIcon, notificationCompat$Builder.mProgressMax, notificationCompat$Builder.mProgress, notificationCompat$Builder.mProgressIndeterminate, notificationCompat$Builder.mShowWhen, notificationCompat$Builder.mUseChronometer, notificationCompat$Builder.mPriority, notificationCompat$Builder.mSubText, notificationCompat$Builder.mLocalOnly, notificationCompat$Builder.mCategory, notificationCompat$Builder.mPeople, notificationCompat$Builder.mExtras, notificationCompat$Builder.mColor, notificationCompat$Builder.mVisibility, notificationCompat$Builder.mPublicVersion, notificationCompat$Builder.mGroupKey, notificationCompat$Builder.mGroupSummary, notificationCompat$Builder.mSortKey, notificationCompat$Builder.mRemoteInputHistory, notificationCompat$Builder.mContentView, notificationCompat$Builder.mBigContentView, notificationCompat$Builder.mHeadsUpContentView);
        NotificationCompat.addActionsToBuilder(notificationCompatApi24$Builder, notificationCompat$Builder.mActions);
        NotificationCompat.addStyleToBuilderApi24(notificationCompatApi24$Builder, notificationCompat$Builder.mStyle);
        final Notification build = notificationCompat$BuilderExtender.build(notificationCompat$Builder, notificationCompatApi24$Builder);
        if (notificationCompat$Builder.mStyle != null) {
            notificationCompat$Builder.mStyle.addCompatExtras(this.getExtras(build));
        }
        return build;
    }
}
