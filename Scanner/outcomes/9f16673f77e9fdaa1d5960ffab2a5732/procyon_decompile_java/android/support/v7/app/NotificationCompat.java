// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.support.v7.appcompat.R$id;
import android.support.v7.appcompat.R$color;
import android.support.v4.text.BidiFormatter;
import android.content.res.ColorStateList;
import android.text.style.TextAppearanceSpan;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.text.TextUtils;
import android.os.Build$VERSION;
import android.text.SpannableStringBuilder;
import android.support.v7.appcompat.R$layout;
import java.util.ArrayList;
import android.graphics.Bitmap;
import android.content.Context;
import android.app.PendingIntent;
import java.util.List;
import android.app.Notification;
import android.widget.RemoteViews;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$MessagingStyle$Message;
import android.support.v4.app.NotificationCompat$MessagingStyle;

public class NotificationCompat extends android.support.v4.app.NotificationCompat
{
    private static void addBigStyleToBuilderJellybean(final Notification notification, final NotificationCompat$Builder notificationCompat$Builder) {
        if (notificationCompat$Builder.mStyle instanceof NotificationCompat$MediaStyle) {
            final NotificationCompat$MediaStyle notificationCompat$MediaStyle = (NotificationCompat$MediaStyle)notificationCompat$Builder.mStyle;
            RemoteViews remoteViews;
            if (notificationCompat$Builder.getBigContentView() != null) {
                remoteViews = notificationCompat$Builder.getBigContentView();
            }
            else {
                remoteViews = notificationCompat$Builder.getContentView();
            }
            final boolean b = notificationCompat$Builder.mStyle instanceof NotificationCompat$DecoratedMediaCustomViewStyle && remoteViews != null;
            NotificationCompatImplBase.overrideMediaBigContentView(notification, notificationCompat$Builder.mContext, notificationCompat$Builder.mContentTitle, notificationCompat$Builder.mContentText, notificationCompat$Builder.mContentInfo, notificationCompat$Builder.mNumber, notificationCompat$Builder.mLargeIcon, notificationCompat$Builder.mSubText, notificationCompat$Builder.mUseChronometer, notificationCompat$Builder.getWhenIfShowing(), notificationCompat$Builder.getPriority(), 0, notificationCompat$Builder.mActions, notificationCompat$MediaStyle.mShowCancelButton, notificationCompat$MediaStyle.mCancelButtonIntent, b);
            if (b) {
                NotificationCompatImplBase.buildIntoRemoteViews(notificationCompat$Builder.mContext, notification.bigContentView, remoteViews);
            }
        }
        else if (notificationCompat$Builder.mStyle instanceof NotificationCompat$DecoratedCustomViewStyle) {
            addDecoratedBigStyleToBuilderJellybean(notification, notificationCompat$Builder);
        }
    }
    
    private static void addBigStyleToBuilderLollipop(final Notification notification, final NotificationCompat$Builder notificationCompat$Builder) {
        RemoteViews remoteViews;
        if (notificationCompat$Builder.getBigContentView() != null) {
            remoteViews = notificationCompat$Builder.getBigContentView();
        }
        else {
            remoteViews = notificationCompat$Builder.getContentView();
        }
        final RemoteViews remoteViews2 = remoteViews;
        if (notificationCompat$Builder.mStyle instanceof NotificationCompat$DecoratedMediaCustomViewStyle && remoteViews2 != null) {
            final Context mContext = notificationCompat$Builder.mContext;
            final CharSequence mContentTitle = notificationCompat$Builder.mContentTitle;
            final CharSequence mContentText = notificationCompat$Builder.mContentText;
            final CharSequence mContentInfo = notificationCompat$Builder.mContentInfo;
            final int mNumber = notificationCompat$Builder.mNumber;
            final Bitmap mLargeIcon = notificationCompat$Builder.mLargeIcon;
            final CharSequence mSubText = notificationCompat$Builder.mSubText;
            final boolean mUseChronometer = notificationCompat$Builder.mUseChronometer;
            final long whenIfShowing = notificationCompat$Builder.getWhenIfShowing();
            final int priority = notificationCompat$Builder.getPriority();
            final ArrayList mActions = notificationCompat$Builder.mActions;
            final RemoteViews remoteViews3 = remoteViews2;
            NotificationCompatImplBase.overrideMediaBigContentView(notification, mContext, mContentTitle, mContentText, mContentInfo, mNumber, mLargeIcon, mSubText, mUseChronometer, whenIfShowing, priority, 0, mActions, false, null, true);
            NotificationCompatImplBase.buildIntoRemoteViews(notificationCompat$Builder.mContext, notification.bigContentView, remoteViews3);
            setBackgroundColor(notificationCompat$Builder.mContext, notification.bigContentView, notificationCompat$Builder.getColor());
        }
        else if (notificationCompat$Builder.mStyle instanceof NotificationCompat$DecoratedCustomViewStyle) {
            addDecoratedBigStyleToBuilderJellybean(notification, notificationCompat$Builder);
        }
    }
    
    private static void addDecoratedBigStyleToBuilderJellybean(final Notification notification, final NotificationCompat$Builder notificationCompat$Builder) {
        final RemoteViews bigContentView = notificationCompat$Builder.getBigContentView();
        RemoteViews contentView;
        if (bigContentView != null) {
            contentView = bigContentView;
        }
        else {
            contentView = notificationCompat$Builder.getContentView();
        }
        if (contentView == null) {
            return;
        }
        final RemoteViews applyStandardTemplateWithActions = NotificationCompatImplBase.applyStandardTemplateWithActions(notificationCompat$Builder.mContext, notificationCompat$Builder.mContentTitle, notificationCompat$Builder.mContentText, notificationCompat$Builder.mContentInfo, notificationCompat$Builder.mNumber, notification.icon, notificationCompat$Builder.mLargeIcon, notificationCompat$Builder.mSubText, notificationCompat$Builder.mUseChronometer, notificationCompat$Builder.getWhenIfShowing(), notificationCompat$Builder.getPriority(), notificationCompat$Builder.getColor(), R$layout.notification_template_custom_big, false, notificationCompat$Builder.mActions);
        NotificationCompatImplBase.buildIntoRemoteViews(notificationCompat$Builder.mContext, applyStandardTemplateWithActions, contentView);
        notification.bigContentView = applyStandardTemplateWithActions;
    }
    
    private static void addDecoratedHeadsUpToBuilderLollipop(final Notification notification, final NotificationCompat$Builder notificationCompat$Builder) {
        final RemoteViews headsUpContentView = notificationCompat$Builder.getHeadsUpContentView();
        RemoteViews contentView;
        if (headsUpContentView != null) {
            contentView = headsUpContentView;
        }
        else {
            contentView = notificationCompat$Builder.getContentView();
        }
        if (headsUpContentView == null) {
            return;
        }
        final RemoteViews applyStandardTemplateWithActions = NotificationCompatImplBase.applyStandardTemplateWithActions(notificationCompat$Builder.mContext, notificationCompat$Builder.mContentTitle, notificationCompat$Builder.mContentText, notificationCompat$Builder.mContentInfo, notificationCompat$Builder.mNumber, notification.icon, notificationCompat$Builder.mLargeIcon, notificationCompat$Builder.mSubText, notificationCompat$Builder.mUseChronometer, notificationCompat$Builder.getWhenIfShowing(), notificationCompat$Builder.getPriority(), notificationCompat$Builder.getColor(), R$layout.notification_template_custom_big, false, notificationCompat$Builder.mActions);
        NotificationCompatImplBase.buildIntoRemoteViews(notificationCompat$Builder.mContext, applyStandardTemplateWithActions, contentView);
        notification.headsUpContentView = applyStandardTemplateWithActions;
    }
    
    private static void addHeadsUpToBuilderLollipop(final Notification notification, final NotificationCompat$Builder notificationCompat$Builder) {
        RemoteViews remoteViews;
        if (notificationCompat$Builder.getHeadsUpContentView() != null) {
            remoteViews = notificationCompat$Builder.getHeadsUpContentView();
        }
        else {
            remoteViews = notificationCompat$Builder.getContentView();
        }
        if (notificationCompat$Builder.mStyle instanceof NotificationCompat$DecoratedMediaCustomViewStyle && remoteViews != null) {
            notification.headsUpContentView = NotificationCompatImplBase.generateMediaBigView(notificationCompat$Builder.mContext, notificationCompat$Builder.mContentTitle, notificationCompat$Builder.mContentText, notificationCompat$Builder.mContentInfo, notificationCompat$Builder.mNumber, notificationCompat$Builder.mLargeIcon, notificationCompat$Builder.mSubText, notificationCompat$Builder.mUseChronometer, notificationCompat$Builder.getWhenIfShowing(), notificationCompat$Builder.getPriority(), 0, notificationCompat$Builder.mActions, false, null, true);
            NotificationCompatImplBase.buildIntoRemoteViews(notificationCompat$Builder.mContext, notification.headsUpContentView, remoteViews);
            setBackgroundColor(notificationCompat$Builder.mContext, notification.headsUpContentView, notificationCompat$Builder.getColor());
        }
        else if (notificationCompat$Builder.mStyle instanceof NotificationCompat$DecoratedCustomViewStyle) {
            addDecoratedHeadsUpToBuilderLollipop(notification, notificationCompat$Builder);
        }
    }
    
    private static void addMessagingFallBackStyle(final NotificationCompat$MessagingStyle notificationCompat$MessagingStyle, final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, final NotificationCompat$Builder notificationCompat$Builder) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        final List messages = notificationCompat$MessagingStyle.getMessages();
        final CharSequence conversationTitle = notificationCompat$MessagingStyle.getConversationTitle();
        final int n = 1;
        final boolean b = conversationTitle != null || hasMessagesWithoutSender(notificationCompat$MessagingStyle.getMessages());
        for (int i = messages.size() - n; i >= 0; --i) {
            final NotificationCompat$MessagingStyle$Message notificationCompat$MessagingStyle$Message = messages.get(i);
            CharSequence charSequence;
            if (b) {
                charSequence = makeMessageLine(notificationCompat$Builder, notificationCompat$MessagingStyle, notificationCompat$MessagingStyle$Message);
            }
            else {
                charSequence = notificationCompat$MessagingStyle$Message.getText();
            }
            if (i != messages.size() - n) {
                spannableStringBuilder.insert(0, (CharSequence)"\n");
            }
            spannableStringBuilder.insert(0, charSequence);
        }
        NotificationCompatImplJellybean.addBigTextStyle(notificationBuilderWithBuilderAccessor, (CharSequence)spannableStringBuilder);
    }
    
    private static RemoteViews addStyleGetContentViewIcs(final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, final NotificationCompat$Builder notificationCompat$Builder) {
        if (notificationCompat$Builder.mStyle instanceof NotificationCompat$MediaStyle) {
            final NotificationCompat$MediaStyle notificationCompat$MediaStyle = (NotificationCompat$MediaStyle)notificationCompat$Builder.mStyle;
            final boolean b = notificationCompat$Builder.mStyle instanceof NotificationCompat$DecoratedMediaCustomViewStyle && notificationCompat$Builder.getContentView() != null;
            final RemoteViews overrideContentViewMedia = NotificationCompatImplBase.overrideContentViewMedia(notificationBuilderWithBuilderAccessor, notificationCompat$Builder.mContext, notificationCompat$Builder.mContentTitle, notificationCompat$Builder.mContentText, notificationCompat$Builder.mContentInfo, notificationCompat$Builder.mNumber, notificationCompat$Builder.mLargeIcon, notificationCompat$Builder.mSubText, notificationCompat$Builder.mUseChronometer, notificationCompat$Builder.getWhenIfShowing(), notificationCompat$Builder.getPriority(), notificationCompat$Builder.mActions, notificationCompat$MediaStyle.mActionsToShowInCompact, notificationCompat$MediaStyle.mShowCancelButton, notificationCompat$MediaStyle.mCancelButtonIntent, b);
            if (b) {
                NotificationCompatImplBase.buildIntoRemoteViews(notificationCompat$Builder.mContext, overrideContentViewMedia, notificationCompat$Builder.getContentView());
                return overrideContentViewMedia;
            }
        }
        else if (notificationCompat$Builder.mStyle instanceof NotificationCompat$DecoratedCustomViewStyle) {
            return getDecoratedContentView(notificationCompat$Builder);
        }
        return null;
    }
    
    private static RemoteViews addStyleGetContentViewJellybean(final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, final NotificationCompat$Builder notificationCompat$Builder) {
        if (notificationCompat$Builder.mStyle instanceof NotificationCompat$MessagingStyle) {
            addMessagingFallBackStyle((NotificationCompat$MessagingStyle)notificationCompat$Builder.mStyle, notificationBuilderWithBuilderAccessor, notificationCompat$Builder);
        }
        return addStyleGetContentViewIcs(notificationBuilderWithBuilderAccessor, notificationCompat$Builder);
    }
    
    private static RemoteViews addStyleGetContentViewLollipop(final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, final NotificationCompat$Builder notificationCompat$Builder) {
        if (notificationCompat$Builder.mStyle instanceof NotificationCompat$MediaStyle) {
            final NotificationCompat$MediaStyle notificationCompat$MediaStyle = (NotificationCompat$MediaStyle)notificationCompat$Builder.mStyle;
            final int[] mActionsToShowInCompact = notificationCompat$MediaStyle.mActionsToShowInCompact;
            Object token;
            if (notificationCompat$MediaStyle.mToken != null) {
                token = notificationCompat$MediaStyle.mToken.getToken();
            }
            else {
                token = null;
            }
            NotificationCompatImpl21.addMediaStyle(notificationBuilderWithBuilderAccessor, mActionsToShowInCompact, token);
            final RemoteViews contentView = notificationCompat$Builder.getContentView();
            boolean b = true;
            final boolean b2 = contentView != null;
            final boolean b3 = Build$VERSION.SDK_INT >= 21 && Build$VERSION.SDK_INT <= 23;
            if (!b2) {
                if (!b3 || notificationCompat$Builder.getBigContentView() == null) {
                    b = false;
                }
            }
            if (notificationCompat$Builder.mStyle instanceof NotificationCompat$DecoratedMediaCustomViewStyle && b) {
                final RemoteViews overrideContentViewMedia = NotificationCompatImplBase.overrideContentViewMedia(notificationBuilderWithBuilderAccessor, notificationCompat$Builder.mContext, notificationCompat$Builder.mContentTitle, notificationCompat$Builder.mContentText, notificationCompat$Builder.mContentInfo, notificationCompat$Builder.mNumber, notificationCompat$Builder.mLargeIcon, notificationCompat$Builder.mSubText, notificationCompat$Builder.mUseChronometer, notificationCompat$Builder.getWhenIfShowing(), notificationCompat$Builder.getPriority(), notificationCompat$Builder.mActions, notificationCompat$MediaStyle.mActionsToShowInCompact, false, null, b2);
                if (b2) {
                    NotificationCompatImplBase.buildIntoRemoteViews(notificationCompat$Builder.mContext, overrideContentViewMedia, notificationCompat$Builder.getContentView());
                }
                setBackgroundColor(notificationCompat$Builder.mContext, overrideContentViewMedia, notificationCompat$Builder.getColor());
                return overrideContentViewMedia;
            }
            return null;
        }
        else {
            if (notificationCompat$Builder.mStyle instanceof NotificationCompat$DecoratedCustomViewStyle) {
                return getDecoratedContentView(notificationCompat$Builder);
            }
            return addStyleGetContentViewJellybean(notificationBuilderWithBuilderAccessor, notificationCompat$Builder);
        }
    }
    
    private static void addStyleToBuilderApi24(final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, final NotificationCompat$Builder notificationCompat$Builder) {
        if (notificationCompat$Builder.mStyle instanceof NotificationCompat$DecoratedCustomViewStyle) {
            NotificationCompatImpl24.addDecoratedCustomViewStyle(notificationBuilderWithBuilderAccessor);
        }
        else if (notificationCompat$Builder.mStyle instanceof NotificationCompat$DecoratedMediaCustomViewStyle) {
            NotificationCompatImpl24.addDecoratedMediaCustomViewStyle(notificationBuilderWithBuilderAccessor);
        }
        else if (!(notificationCompat$Builder.mStyle instanceof NotificationCompat$MessagingStyle)) {
            addStyleGetContentViewLollipop(notificationBuilderWithBuilderAccessor, notificationCompat$Builder);
        }
    }
    
    private static NotificationCompat$MessagingStyle$Message findLatestIncomingMessage(final NotificationCompat$MessagingStyle notificationCompat$MessagingStyle) {
        final List messages = notificationCompat$MessagingStyle.getMessages();
        for (int i = messages.size() - 1; i >= 0; --i) {
            final NotificationCompat$MessagingStyle$Message notificationCompat$MessagingStyle$Message = messages.get(i);
            if (!TextUtils.isEmpty(notificationCompat$MessagingStyle$Message.getSender())) {
                return notificationCompat$MessagingStyle$Message;
            }
        }
        if (!messages.isEmpty()) {
            return messages.get(messages.size() - 1);
        }
        return null;
    }
    
    private static RemoteViews getDecoratedContentView(final NotificationCompat$Builder notificationCompat$Builder) {
        if (notificationCompat$Builder.getContentView() == null) {
            return null;
        }
        final RemoteViews applyStandardTemplateWithActions = NotificationCompatImplBase.applyStandardTemplateWithActions(notificationCompat$Builder.mContext, notificationCompat$Builder.mContentTitle, notificationCompat$Builder.mContentText, notificationCompat$Builder.mContentInfo, notificationCompat$Builder.mNumber, notificationCompat$Builder.mNotification.icon, notificationCompat$Builder.mLargeIcon, notificationCompat$Builder.mSubText, notificationCompat$Builder.mUseChronometer, notificationCompat$Builder.getWhenIfShowing(), notificationCompat$Builder.getPriority(), notificationCompat$Builder.getColor(), R$layout.notification_template_custom_big, false, null);
        NotificationCompatImplBase.buildIntoRemoteViews(notificationCompat$Builder.mContext, applyStandardTemplateWithActions, notificationCompat$Builder.getContentView());
        return applyStandardTemplateWithActions;
    }
    
    public static MediaSessionCompat$Token getMediaSession(final Notification notification) {
        final Bundle extras = android.support.v4.app.NotificationCompat.getExtras(notification);
        if (extras != null) {
            if (Build$VERSION.SDK_INT >= 21) {
                final Parcelable parcelable = extras.getParcelable("android.mediaSession");
                if (parcelable != null) {
                    return MediaSessionCompat$Token.fromToken(parcelable);
                }
            }
            else {
                final IBinder binder = BundleCompat.getBinder(extras, "android.mediaSession");
                if (binder != null) {
                    final Parcel obtain = Parcel.obtain();
                    obtain.writeStrongBinder(binder);
                    obtain.setDataPosition(0);
                    final MediaSessionCompat$Token mediaSessionCompat$Token = (MediaSessionCompat$Token)MediaSessionCompat$Token.CREATOR.createFromParcel(obtain);
                    obtain.recycle();
                    return mediaSessionCompat$Token;
                }
            }
        }
        return null;
    }
    
    private static boolean hasMessagesWithoutSender(final List list) {
        final int size = list.size();
        final int n = 1;
        for (int i = size - n; i >= 0; --i) {
            if (list.get(i).getSender() == null) {
                return n != 0;
            }
        }
        return false;
    }
    
    private static TextAppearanceSpan makeFontColorSpan(final int n) {
        return new TextAppearanceSpan((String)null, 0, 0, ColorStateList.valueOf(n), (ColorStateList)null);
    }
    
    private static CharSequence makeMessageLine(final NotificationCompat$Builder notificationCompat$Builder, final NotificationCompat$MessagingStyle notificationCompat$MessagingStyle, final NotificationCompat$MessagingStyle$Message notificationCompat$MessagingStyle$Message) {
        final BidiFormatter instance = BidiFormatter.getInstance();
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        final boolean b = Build$VERSION.SDK_INT >= 21;
        int n;
        if (!b && Build$VERSION.SDK_INT > 10) {
            n = -1;
        }
        else {
            n = -16777216;
        }
        CharSequence sender = notificationCompat$MessagingStyle$Message.getSender();
        if (TextUtils.isEmpty(notificationCompat$MessagingStyle$Message.getSender())) {
            CharSequence userDisplayName;
            if (notificationCompat$MessagingStyle.getUserDisplayName() == null) {
                userDisplayName = "";
            }
            else {
                userDisplayName = notificationCompat$MessagingStyle.getUserDisplayName();
            }
            sender = userDisplayName;
            int color;
            if (b && notificationCompat$Builder.getColor() != 0) {
                color = notificationCompat$Builder.getColor();
            }
            else {
                color = n;
            }
            n = color;
        }
        final CharSequence unicodeWrap = instance.unicodeWrap(sender);
        spannableStringBuilder.append(unicodeWrap);
        spannableStringBuilder.setSpan((Object)makeFontColorSpan(n), spannableStringBuilder.length() - unicodeWrap.length(), spannableStringBuilder.length(), 33);
        CharSequence text;
        if (notificationCompat$MessagingStyle$Message.getText() == null) {
            text = "";
        }
        else {
            text = notificationCompat$MessagingStyle$Message.getText();
        }
        spannableStringBuilder.append((CharSequence)"  ").append(instance.unicodeWrap(text));
        return (CharSequence)spannableStringBuilder;
    }
    
    private static void setBackgroundColor(final Context context, final RemoteViews remoteViews, int color) {
        if (color == 0) {
            color = context.getResources().getColor(R$color.notification_material_background_media_default_color);
        }
        remoteViews.setInt(R$id.status_bar_latest_event_content, "setBackgroundColor", color);
    }
}
