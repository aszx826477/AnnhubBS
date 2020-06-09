// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

class NotificationManagerCompat$CancelTask implements NotificationManagerCompat$Task
{
    final boolean all;
    final int id;
    final String packageName;
    final String tag;
    
    public NotificationManagerCompat$CancelTask(final String packageName) {
        this.packageName = packageName;
        this.id = 0;
        this.tag = null;
        this.all = true;
    }
    
    public NotificationManagerCompat$CancelTask(final String packageName, final int id, final String tag) {
        this.packageName = packageName;
        this.id = id;
        this.tag = tag;
        this.all = false;
    }
    
    public void send(final INotificationSideChannel notificationSideChannel) {
        if (this.all) {
            notificationSideChannel.cancelAll(this.packageName);
        }
        else {
            notificationSideChannel.cancel(this.packageName, this.id, this.tag);
        }
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder("CancelTask[");
        sb.append("packageName:");
        sb.append(this.packageName);
        sb.append(", id:");
        sb.append(this.id);
        sb.append(", tag:");
        sb.append(this.tag);
        sb.append(", all:");
        sb.append(this.all);
        sb.append("]");
        return sb.toString();
    }
}
