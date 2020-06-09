// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.IBinder;
import android.content.ComponentName;

class NotificationManagerCompat$ServiceConnectedEvent
{
    final ComponentName componentName;
    final IBinder iBinder;
    
    public NotificationManagerCompat$ServiceConnectedEvent(final ComponentName componentName, final IBinder iBinder) {
        this.componentName = componentName;
        this.iBinder = iBinder;
    }
}
