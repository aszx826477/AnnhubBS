// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Bundle;
import android.app.PendingIntent;

public interface NotificationCompatBase$Action$Factory
{
    NotificationCompatBase$Action build(final int p0, final CharSequence p1, final PendingIntent p2, final Bundle p3, final RemoteInputCompatBase$RemoteInput[] p4, final boolean p5);
    
    NotificationCompatBase$Action[] newArray(final int p0);
}
