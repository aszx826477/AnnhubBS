// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.PendingIntent;

public class NotificationCompat$CarExtender$UnreadConversation extends NotificationCompatBase$UnreadConversation
{
    static final NotificationCompatBase$UnreadConversation$Factory FACTORY;
    private final long mLatestTimestamp;
    private final String[] mMessages;
    private final String[] mParticipants;
    private final PendingIntent mReadPendingIntent;
    private final RemoteInput mRemoteInput;
    private final PendingIntent mReplyPendingIntent;
    
    static {
        FACTORY = new NotificationCompat$CarExtender$UnreadConversation$1();
    }
    
    NotificationCompat$CarExtender$UnreadConversation(final String[] mMessages, final RemoteInput mRemoteInput, final PendingIntent mReplyPendingIntent, final PendingIntent mReadPendingIntent, final String[] mParticipants, final long mLatestTimestamp) {
        this.mMessages = mMessages;
        this.mRemoteInput = mRemoteInput;
        this.mReadPendingIntent = mReadPendingIntent;
        this.mReplyPendingIntent = mReplyPendingIntent;
        this.mParticipants = mParticipants;
        this.mLatestTimestamp = mLatestTimestamp;
    }
    
    public long getLatestTimestamp() {
        return this.mLatestTimestamp;
    }
    
    public String[] getMessages() {
        return this.mMessages;
    }
    
    public String getParticipant() {
        final String[] mParticipants = this.mParticipants;
        String s;
        if (mParticipants.length > 0) {
            s = mParticipants[0];
        }
        else {
            s = null;
        }
        return s;
    }
    
    public String[] getParticipants() {
        return this.mParticipants;
    }
    
    public PendingIntent getReadPendingIntent() {
        return this.mReadPendingIntent;
    }
    
    public RemoteInput getRemoteInput() {
        return this.mRemoteInput;
    }
    
    public PendingIntent getReplyPendingIntent() {
        return this.mReplyPendingIntent;
    }
}
