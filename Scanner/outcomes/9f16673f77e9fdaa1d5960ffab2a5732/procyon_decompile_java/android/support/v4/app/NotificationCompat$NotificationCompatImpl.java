// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Bundle;
import java.util.ArrayList;
import android.app.Notification;

interface NotificationCompat$NotificationCompatImpl
{
    Notification build(final NotificationCompat$Builder p0, final NotificationCompat$BuilderExtender p1);
    
    NotificationCompat$Action getAction(final Notification p0, final int p1);
    
    int getActionCount(final Notification p0);
    
    NotificationCompat$Action[] getActionsFromParcelableArrayList(final ArrayList p0);
    
    Bundle getBundleForUnreadConversation(final NotificationCompatBase$UnreadConversation p0);
    
    String getCategory(final Notification p0);
    
    Bundle getExtras(final Notification p0);
    
    String getGroup(final Notification p0);
    
    boolean getLocalOnly(final Notification p0);
    
    ArrayList getParcelableArrayListForActions(final NotificationCompat$Action[] p0);
    
    String getSortKey(final Notification p0);
    
    NotificationCompatBase$UnreadConversation getUnreadConversationFromBundle(final Bundle p0, final NotificationCompatBase$UnreadConversation$Factory p1, final RemoteInputCompatBase$RemoteInput$Factory p2);
    
    boolean isGroupSummary(final Notification p0);
}
