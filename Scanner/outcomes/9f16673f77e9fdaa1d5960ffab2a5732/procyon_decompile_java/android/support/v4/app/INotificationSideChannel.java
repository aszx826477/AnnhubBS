// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.Notification;
import android.os.IInterface;

public interface INotificationSideChannel extends IInterface
{
    void cancel(final String p0, final int p1, final String p2);
    
    void cancelAll(final String p0);
    
    void notify(final String p0, final int p1, final String p2, final Notification p3);
}
