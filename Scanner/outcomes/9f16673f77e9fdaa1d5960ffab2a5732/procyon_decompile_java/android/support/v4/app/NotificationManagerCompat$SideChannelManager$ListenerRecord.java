// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import java.util.LinkedList;
import android.content.ComponentName;

class NotificationManagerCompat$SideChannelManager$ListenerRecord
{
    public boolean bound;
    public final ComponentName componentName;
    public int retryCount;
    public INotificationSideChannel service;
    public LinkedList taskQueue;
    
    public NotificationManagerCompat$SideChannelManager$ListenerRecord(final ComponentName componentName) {
        this.bound = false;
        this.taskQueue = new LinkedList();
        this.retryCount = 0;
        this.componentName = componentName;
    }
}
