// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Parcelable;
import android.os.Bundle;
import android.app.Notification;
import java.util.ArrayList;
import java.util.List;

public class NotificationCompat$MessagingStyle extends NotificationCompat$Style
{
    public static final int MAXIMUM_RETAINED_MESSAGES = 25;
    CharSequence mConversationTitle;
    List mMessages;
    CharSequence mUserDisplayName;
    
    NotificationCompat$MessagingStyle() {
        this.mMessages = new ArrayList();
    }
    
    public NotificationCompat$MessagingStyle(final CharSequence mUserDisplayName) {
        this.mMessages = new ArrayList();
        this.mUserDisplayName = mUserDisplayName;
    }
    
    public static NotificationCompat$MessagingStyle extractMessagingStyleFromNotification(final Notification notification) {
        final Bundle extras = NotificationCompat.IMPL.getExtras(notification);
        NotificationCompat$MessagingStyle notificationCompat$MessagingStyle = null;
        if (extras != null && !extras.containsKey("android.selfDisplayName")) {
            notificationCompat$MessagingStyle = null;
        }
        else {
            try {
                notificationCompat$MessagingStyle = new(android.support.v4.app.NotificationCompat$MessagingStyle.class);
                try {
                    new NotificationCompat$MessagingStyle();
                    final NotificationCompat$MessagingStyle notificationCompat$MessagingStyle2 = notificationCompat$MessagingStyle;
                    try {
                        notificationCompat$MessagingStyle2.restoreFromCompatExtras(extras);
                    }
                    catch (ClassCastException ex) {
                        notificationCompat$MessagingStyle = null;
                    }
                }
                catch (ClassCastException ex2) {}
            }
            catch (ClassCastException ex3) {}
        }
        return notificationCompat$MessagingStyle;
    }
    
    public void addCompatExtras(final Bundle bundle) {
        super.addCompatExtras(bundle);
        final CharSequence mUserDisplayName = this.mUserDisplayName;
        if (mUserDisplayName != null) {
            bundle.putCharSequence("android.selfDisplayName", mUserDisplayName);
        }
        final CharSequence mConversationTitle = this.mConversationTitle;
        if (mConversationTitle != null) {
            bundle.putCharSequence("android.conversationTitle", mConversationTitle);
        }
        if (!this.mMessages.isEmpty()) {
            bundle.putParcelableArray("android.messages", (Parcelable[])NotificationCompat$MessagingStyle$Message.getBundleArrayForMessages(this.mMessages));
        }
    }
    
    public NotificationCompat$MessagingStyle addMessage(final NotificationCompat$MessagingStyle$Message notificationCompat$MessagingStyle$Message) {
        this.mMessages.add(notificationCompat$MessagingStyle$Message);
        if (this.mMessages.size() > 25) {
            this.mMessages.remove(0);
        }
        return this;
    }
    
    public NotificationCompat$MessagingStyle addMessage(final CharSequence charSequence, final long n, final CharSequence charSequence2) {
        this.mMessages.add(new NotificationCompat$MessagingStyle$Message(charSequence, n, charSequence2));
        if (this.mMessages.size() > 25) {
            this.mMessages.remove(0);
        }
        return this;
    }
    
    public CharSequence getConversationTitle() {
        return this.mConversationTitle;
    }
    
    public List getMessages() {
        return this.mMessages;
    }
    
    public CharSequence getUserDisplayName() {
        return this.mUserDisplayName;
    }
    
    protected void restoreFromCompatExtras(final Bundle bundle) {
        this.mMessages.clear();
        this.mUserDisplayName = bundle.getString("android.selfDisplayName");
        this.mConversationTitle = bundle.getString("android.conversationTitle");
        final Parcelable[] parcelableArray = bundle.getParcelableArray("android.messages");
        if (parcelableArray != null) {
            this.mMessages = NotificationCompat$MessagingStyle$Message.getMessagesFromBundleArray(parcelableArray);
        }
    }
    
    public NotificationCompat$MessagingStyle setConversationTitle(final CharSequence mConversationTitle) {
        this.mConversationTitle = mConversationTitle;
        return this;
    }
}
