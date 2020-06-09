// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.PendingIntent;

final class NotificationCompat$CarExtender$UnreadConversation$1 implements NotificationCompatBase$UnreadConversation$Factory
{
    public NotificationCompat$CarExtender$UnreadConversation build(final String[] array, final RemoteInputCompatBase$RemoteInput remoteInputCompatBase$RemoteInput, final PendingIntent pendingIntent, final PendingIntent pendingIntent2, final String[] array2, final long n) {
        return new NotificationCompat$CarExtender$UnreadConversation(array, (RemoteInput)remoteInputCompatBase$RemoteInput, pendingIntent, pendingIntent2, array2, n);
    }
}
