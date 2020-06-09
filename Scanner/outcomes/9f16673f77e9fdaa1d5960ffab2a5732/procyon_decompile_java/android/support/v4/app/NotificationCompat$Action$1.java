// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Bundle;
import android.app.PendingIntent;

final class NotificationCompat$Action$1 implements NotificationCompatBase$Action$Factory
{
    public NotificationCompatBase$Action build(final int n, final CharSequence charSequence, final PendingIntent pendingIntent, final Bundle bundle, final RemoteInputCompatBase$RemoteInput[] array, final boolean b) {
        return new NotificationCompat$Action(n, charSequence, pendingIntent, bundle, (RemoteInput[])array, b);
    }
    
    public NotificationCompat$Action[] newArray(final int n) {
        return new NotificationCompat$Action[n];
    }
}
