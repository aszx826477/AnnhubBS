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
import android.text.SpannableStringBuilder;
import android.support.v7.appcompat.R$layout;
import java.util.ArrayList;
import android.graphics.Bitmap;
import android.app.PendingIntent;
import java.util.List;
import android.app.Notification;
import android.widget.RemoteViews;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat$MessagingStyle$Message;
import android.support.v4.app.NotificationCompat$MessagingStyle;
import android.os.Build$VERSION;
import android.support.v4.app.NotificationCompat$BuilderExtender;
import android.content.Context;

public class NotificationCompat$Builder extends android.support.v4.app.NotificationCompat$Builder
{
    public NotificationCompat$Builder(final Context context) {
        super(context);
    }
    
    protected NotificationCompat$BuilderExtender getExtender() {
        if (Build$VERSION.SDK_INT >= 24) {
            return new NotificationCompat$Api24Extender(null);
        }
        if (Build$VERSION.SDK_INT >= 21) {
            return new NotificationCompat$LollipopExtender();
        }
        if (Build$VERSION.SDK_INT >= 16) {
            return new NotificationCompat$JellybeanExtender();
        }
        if (Build$VERSION.SDK_INT >= 14) {
            return new NotificationCompat$IceCreamSandwichExtender();
        }
        return super.getExtender();
    }
    
    protected CharSequence resolveText() {
        if (this.mStyle instanceof NotificationCompat$MessagingStyle) {
            final NotificationCompat$MessagingStyle notificationCompat$MessagingStyle = (NotificationCompat$MessagingStyle)this.mStyle;
            final NotificationCompat$MessagingStyle$Message access$000 = findLatestIncomingMessage(notificationCompat$MessagingStyle);
            final CharSequence conversationTitle = notificationCompat$MessagingStyle.getConversationTitle();
            if (access$000 != null) {
                CharSequence charSequence;
                if (conversationTitle != null) {
                    charSequence = makeMessageLine(this, notificationCompat$MessagingStyle, access$000);
                }
                else {
                    charSequence = access$000.getText();
                }
                return charSequence;
            }
        }
        return super.resolveText();
    }
    
    protected CharSequence resolveTitle() {
        if (this.mStyle instanceof NotificationCompat$MessagingStyle) {
            final NotificationCompat$MessagingStyle notificationCompat$MessagingStyle = (NotificationCompat$MessagingStyle)this.mStyle;
            final NotificationCompat$MessagingStyle$Message access$000 = findLatestIncomingMessage(notificationCompat$MessagingStyle);
            final CharSequence conversationTitle = notificationCompat$MessagingStyle.getConversationTitle();
            if (conversationTitle != null || access$000 != null) {
                CharSequence sender;
                if (conversationTitle != null) {
                    sender = conversationTitle;
                }
                else {
                    sender = access$000.getSender();
                }
                return sender;
            }
        }
        return super.resolveTitle();
    }
}
