// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.Notification;

class NotificationManagerCompat$NotifyTask implements NotificationManagerCompat$Task
{
    final int id;
    final Notification notif;
    final String packageName;
    final String tag;
    
    public NotificationManagerCompat$NotifyTask(final String packageName, final int id, final String tag, final Notification notif) {
        this.packageName = packageName;
        this.id = id;
        this.tag = tag;
        this.notif = notif;
    }
    
    public void send(final INotificationSideChannel notificationSideChannel) {
        notificationSideChannel.notify(this.packageName, this.id, this.tag, this.notif);
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotifyTask[");
        sb.append("packageName:");
        sb.append(this.packageName);
        sb.append(", id:");
        sb.append(this.id);
        sb.append(", tag:");
        sb.append(this.tag);
        sb.append("]");
        return sb.toString();
    }
}
