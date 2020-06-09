// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import java.util.ArrayList;
import android.app.PendingIntent;
import java.util.List;

public class NotificationCompat$CarExtender$UnreadConversation$Builder
{
    private long mLatestTimestamp;
    private final List mMessages;
    private final String mParticipant;
    private PendingIntent mReadPendingIntent;
    private RemoteInput mRemoteInput;
    private PendingIntent mReplyPendingIntent;
    
    public NotificationCompat$CarExtender$UnreadConversation$Builder(final String mParticipant) {
        this.mMessages = new ArrayList();
        this.mParticipant = mParticipant;
    }
    
    public NotificationCompat$CarExtender$UnreadConversation$Builder addMessage(final String s) {
        this.mMessages.add(s);
        return this;
    }
    
    public NotificationCompat$CarExtender$UnreadConversation build() {
        final List mMessages = this.mMessages;
        return new NotificationCompat$CarExtender$UnreadConversation(mMessages.toArray(new String[mMessages.size()]), this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, new String[] { this.mParticipant }, this.mLatestTimestamp);
    }
    
    public NotificationCompat$CarExtender$UnreadConversation$Builder setLatestTimestamp(final long mLatestTimestamp) {
        this.mLatestTimestamp = mLatestTimestamp;
        return this;
    }
    
    public NotificationCompat$CarExtender$UnreadConversation$Builder setReadPendingIntent(final PendingIntent mReadPendingIntent) {
        this.mReadPendingIntent = mReadPendingIntent;
        return this;
    }
    
    public NotificationCompat$CarExtender$UnreadConversation$Builder setReplyAction(final PendingIntent mReplyPendingIntent, final RemoteInput mRemoteInput) {
        this.mRemoteInput = mRemoteInput;
        this.mReplyPendingIntent = mReplyPendingIntent;
        return this;
    }
}
