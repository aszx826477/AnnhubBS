// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.Notification;

public class NotificationCompat$BuilderExtender
{
    public Notification build(final NotificationCompat$Builder notificationCompat$Builder, final NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        final Notification build = notificationBuilderWithBuilderAccessor.build();
        if (notificationCompat$Builder.mContentView != null) {
            build.contentView = notificationCompat$Builder.mContentView;
        }
        return build;
    }
}
