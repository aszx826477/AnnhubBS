// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.PendingIntent;

public abstract class NotificationCompatBase$UnreadConversation
{
    abstract long getLatestTimestamp();
    
    abstract String[] getMessages();
    
    abstract String getParticipant();
    
    abstract String[] getParticipants();
    
    abstract PendingIntent getReadPendingIntent();
    
    abstract RemoteInputCompatBase$RemoteInput getRemoteInput();
    
    abstract PendingIntent getReplyPendingIntent();
}
