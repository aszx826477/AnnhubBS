// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.net.Uri;
import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.content.Context;
import android.app.PendingIntent;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class NotificationCompat$Builder
{
    private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
    public ArrayList mActions;
    RemoteViews mBigContentView;
    String mCategory;
    int mColor;
    public CharSequence mContentInfo;
    PendingIntent mContentIntent;
    public CharSequence mContentText;
    public CharSequence mContentTitle;
    RemoteViews mContentView;
    public Context mContext;
    Bundle mExtras;
    PendingIntent mFullScreenIntent;
    String mGroupKey;
    boolean mGroupSummary;
    RemoteViews mHeadsUpContentView;
    public Bitmap mLargeIcon;
    boolean mLocalOnly;
    public Notification mNotification;
    public int mNumber;
    public ArrayList mPeople;
    int mPriority;
    int mProgress;
    boolean mProgressIndeterminate;
    int mProgressMax;
    Notification mPublicVersion;
    public CharSequence[] mRemoteInputHistory;
    boolean mShowWhen;
    String mSortKey;
    public NotificationCompat$Style mStyle;
    public CharSequence mSubText;
    RemoteViews mTickerView;
    public boolean mUseChronometer;
    int mVisibility;
    
    public NotificationCompat$Builder(final Context mContext) {
        this.mShowWhen = true;
        this.mActions = new ArrayList();
        this.mLocalOnly = false;
        this.mColor = 0;
        this.mVisibility = 0;
        this.mNotification = new Notification();
        this.mContext = mContext;
        this.mNotification.when = System.currentTimeMillis();
        this.mNotification.audioStreamType = -1;
        this.mPriority = 0;
        this.mPeople = new ArrayList();
    }
    
    protected static CharSequence limitCharSequenceLength(CharSequence subSequence) {
        if (subSequence == null) {
            return subSequence;
        }
        final int length = subSequence.length();
        final int n = 5120;
        if (length > n) {
            subSequence = subSequence.subSequence(0, n);
        }
        return subSequence;
    }
    
    private void setFlag(final int n, final boolean b) {
        if (b) {
            final Notification mNotification = this.mNotification;
            mNotification.flags |= n;
        }
        else {
            final Notification mNotification2 = this.mNotification;
            mNotification2.flags &= ~n;
        }
    }
    
    public NotificationCompat$Builder addAction(final int n, final CharSequence charSequence, final PendingIntent pendingIntent) {
        this.mActions.add(new NotificationCompat$Action(n, charSequence, pendingIntent));
        return this;
    }
    
    public NotificationCompat$Builder addAction(final NotificationCompat$Action notificationCompat$Action) {
        this.mActions.add(notificationCompat$Action);
        return this;
    }
    
    public NotificationCompat$Builder addExtras(final Bundle bundle) {
        if (bundle != null) {
            final Bundle mExtras = this.mExtras;
            if (mExtras == null) {
                this.mExtras = new Bundle(bundle);
            }
            else {
                mExtras.putAll(bundle);
            }
        }
        return this;
    }
    
    public NotificationCompat$Builder addPerson(final String s) {
        this.mPeople.add(s);
        return this;
    }
    
    public Notification build() {
        return NotificationCompat.IMPL.build(this, this.getExtender());
    }
    
    public NotificationCompat$Builder extend(final NotificationCompat$Extender notificationCompat$Extender) {
        notificationCompat$Extender.extend(this);
        return this;
    }
    
    public RemoteViews getBigContentView() {
        return this.mBigContentView;
    }
    
    public int getColor() {
        return this.mColor;
    }
    
    public RemoteViews getContentView() {
        return this.mContentView;
    }
    
    protected NotificationCompat$BuilderExtender getExtender() {
        return new NotificationCompat$BuilderExtender();
    }
    
    public Bundle getExtras() {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        return this.mExtras;
    }
    
    public RemoteViews getHeadsUpContentView() {
        return this.mHeadsUpContentView;
    }
    
    public Notification getNotification() {
        return this.build();
    }
    
    public int getPriority() {
        return this.mPriority;
    }
    
    public long getWhenIfShowing() {
        long when;
        if (this.mShowWhen) {
            when = this.mNotification.when;
        }
        else {
            when = 0L;
        }
        return when;
    }
    
    protected CharSequence resolveText() {
        return this.mContentText;
    }
    
    protected CharSequence resolveTitle() {
        return this.mContentTitle;
    }
    
    public NotificationCompat$Builder setAutoCancel(final boolean b) {
        this.setFlag(16, b);
        return this;
    }
    
    public NotificationCompat$Builder setCategory(final String mCategory) {
        this.mCategory = mCategory;
        return this;
    }
    
    public NotificationCompat$Builder setColor(final int mColor) {
        this.mColor = mColor;
        return this;
    }
    
    public NotificationCompat$Builder setContent(final RemoteViews contentView) {
        this.mNotification.contentView = contentView;
        return this;
    }
    
    public NotificationCompat$Builder setContentInfo(final CharSequence charSequence) {
        this.mContentInfo = limitCharSequenceLength(charSequence);
        return this;
    }
    
    public NotificationCompat$Builder setContentIntent(final PendingIntent mContentIntent) {
        this.mContentIntent = mContentIntent;
        return this;
    }
    
    public NotificationCompat$Builder setContentText(final CharSequence charSequence) {
        this.mContentText = limitCharSequenceLength(charSequence);
        return this;
    }
    
    public NotificationCompat$Builder setContentTitle(final CharSequence charSequence) {
        this.mContentTitle = limitCharSequenceLength(charSequence);
        return this;
    }
    
    public NotificationCompat$Builder setCustomBigContentView(final RemoteViews mBigContentView) {
        this.mBigContentView = mBigContentView;
        return this;
    }
    
    public NotificationCompat$Builder setCustomContentView(final RemoteViews mContentView) {
        this.mContentView = mContentView;
        return this;
    }
    
    public NotificationCompat$Builder setCustomHeadsUpContentView(final RemoteViews mHeadsUpContentView) {
        this.mHeadsUpContentView = mHeadsUpContentView;
        return this;
    }
    
    public NotificationCompat$Builder setDefaults(final int defaults) {
        final Notification mNotification = this.mNotification;
        mNotification.defaults = defaults;
        if ((defaults & 0x4) != 0x0) {
            mNotification.flags |= 0x1;
        }
        return this;
    }
    
    public NotificationCompat$Builder setDeleteIntent(final PendingIntent deleteIntent) {
        this.mNotification.deleteIntent = deleteIntent;
        return this;
    }
    
    public NotificationCompat$Builder setExtras(final Bundle mExtras) {
        this.mExtras = mExtras;
        return this;
    }
    
    public NotificationCompat$Builder setFullScreenIntent(final PendingIntent mFullScreenIntent, final boolean b) {
        this.mFullScreenIntent = mFullScreenIntent;
        this.setFlag(128, b);
        return this;
    }
    
    public NotificationCompat$Builder setGroup(final String mGroupKey) {
        this.mGroupKey = mGroupKey;
        return this;
    }
    
    public NotificationCompat$Builder setGroupSummary(final boolean mGroupSummary) {
        this.mGroupSummary = mGroupSummary;
        return this;
    }
    
    public NotificationCompat$Builder setLargeIcon(final Bitmap mLargeIcon) {
        this.mLargeIcon = mLargeIcon;
        return this;
    }
    
    public NotificationCompat$Builder setLights(final int ledARGB, final int ledOnMS, final int ledOffMS) {
        final Notification mNotification = this.mNotification;
        mNotification.ledARGB = ledARGB;
        mNotification.ledOnMS = ledOnMS;
        mNotification.ledOffMS = ledOffMS;
        final int ledOnMS2 = mNotification.ledOnMS;
        boolean b = true;
        final boolean b2 = ledOnMS2 != 0 && this.mNotification.ledOffMS != 0;
        final Notification mNotification2 = this.mNotification;
        final int n = mNotification2.flags & 0xFFFFFFFE;
        if (!b2) {
            b = false;
        }
        mNotification2.flags = ((b ? 1 : 0) | n);
        return this;
    }
    
    public NotificationCompat$Builder setLocalOnly(final boolean mLocalOnly) {
        this.mLocalOnly = mLocalOnly;
        return this;
    }
    
    public NotificationCompat$Builder setNumber(final int mNumber) {
        this.mNumber = mNumber;
        return this;
    }
    
    public NotificationCompat$Builder setOngoing(final boolean b) {
        this.setFlag(2, b);
        return this;
    }
    
    public NotificationCompat$Builder setOnlyAlertOnce(final boolean b) {
        this.setFlag(8, b);
        return this;
    }
    
    public NotificationCompat$Builder setPriority(final int mPriority) {
        this.mPriority = mPriority;
        return this;
    }
    
    public NotificationCompat$Builder setProgress(final int mProgressMax, final int mProgress, final boolean mProgressIndeterminate) {
        this.mProgressMax = mProgressMax;
        this.mProgress = mProgress;
        this.mProgressIndeterminate = mProgressIndeterminate;
        return this;
    }
    
    public NotificationCompat$Builder setPublicVersion(final Notification mPublicVersion) {
        this.mPublicVersion = mPublicVersion;
        return this;
    }
    
    public NotificationCompat$Builder setRemoteInputHistory(final CharSequence[] mRemoteInputHistory) {
        this.mRemoteInputHistory = mRemoteInputHistory;
        return this;
    }
    
    public NotificationCompat$Builder setShowWhen(final boolean mShowWhen) {
        this.mShowWhen = mShowWhen;
        return this;
    }
    
    public NotificationCompat$Builder setSmallIcon(final int icon) {
        this.mNotification.icon = icon;
        return this;
    }
    
    public NotificationCompat$Builder setSmallIcon(final int icon, final int iconLevel) {
        final Notification mNotification = this.mNotification;
        mNotification.icon = icon;
        mNotification.iconLevel = iconLevel;
        return this;
    }
    
    public NotificationCompat$Builder setSortKey(final String mSortKey) {
        this.mSortKey = mSortKey;
        return this;
    }
    
    public NotificationCompat$Builder setSound(final Uri sound) {
        final Notification mNotification = this.mNotification;
        mNotification.sound = sound;
        mNotification.audioStreamType = -1;
        return this;
    }
    
    public NotificationCompat$Builder setSound(final Uri sound, final int audioStreamType) {
        final Notification mNotification = this.mNotification;
        mNotification.sound = sound;
        mNotification.audioStreamType = audioStreamType;
        return this;
    }
    
    public NotificationCompat$Builder setStyle(final NotificationCompat$Style mStyle) {
        if (this.mStyle != mStyle) {
            this.mStyle = mStyle;
            final NotificationCompat$Style mStyle2 = this.mStyle;
            if (mStyle2 != null) {
                mStyle2.setBuilder(this);
            }
        }
        return this;
    }
    
    public NotificationCompat$Builder setSubText(final CharSequence charSequence) {
        this.mSubText = limitCharSequenceLength(charSequence);
        return this;
    }
    
    public NotificationCompat$Builder setTicker(final CharSequence charSequence) {
        this.mNotification.tickerText = limitCharSequenceLength(charSequence);
        return this;
    }
    
    public NotificationCompat$Builder setTicker(final CharSequence charSequence, final RemoteViews mTickerView) {
        this.mNotification.tickerText = limitCharSequenceLength(charSequence);
        this.mTickerView = mTickerView;
        return this;
    }
    
    public NotificationCompat$Builder setUsesChronometer(final boolean mUseChronometer) {
        this.mUseChronometer = mUseChronometer;
        return this;
    }
    
    public NotificationCompat$Builder setVibrate(final long[] vibrate) {
        this.mNotification.vibrate = vibrate;
        return this;
    }
    
    public NotificationCompat$Builder setVisibility(final int mVisibility) {
        this.mVisibility = mVisibility;
        return this;
    }
    
    public NotificationCompat$Builder setWhen(final long when) {
        this.mNotification.when = when;
        return this;
    }
}
