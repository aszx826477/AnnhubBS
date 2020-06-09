// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.net.Uri;
import android.app.Notification$MessagingStyle$Message;
import android.app.Notification$MessagingStyle;
import java.util.List;

class NotificationCompatApi24
{
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    
    public static void addMessagingStyle(final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, final CharSequence charSequence, final CharSequence conversationTitle, final List list, final List list2, final List list3, final List list4, final List list5) {
        final Notification$MessagingStyle setConversationTitle = new Notification$MessagingStyle(charSequence).setConversationTitle(conversationTitle);
        for (int i = 0; i < list.size(); ++i) {
            final Notification$MessagingStyle$Message notification$MessagingStyle$Message = new Notification$MessagingStyle$Message((CharSequence)list.get(i), (long)list2.get(i), (CharSequence)list3.get(i));
            if (list4.get(i) != null) {
                notification$MessagingStyle$Message.setData((String)list4.get(i), (Uri)list5.get(i));
            }
            setConversationTitle.addMessage(notification$MessagingStyle$Message);
        }
        setConversationTitle.setBuilder(notificationBuilderWithBuilderAccessor.getBuilder());
    }
}
