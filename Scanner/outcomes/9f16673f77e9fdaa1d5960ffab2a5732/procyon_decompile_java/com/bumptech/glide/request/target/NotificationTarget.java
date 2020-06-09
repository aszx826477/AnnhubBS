// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.target;

import com.bumptech.glide.request.animation.GlideAnimation;
import android.graphics.Bitmap;
import android.app.NotificationManager;
import android.widget.RemoteViews;
import android.app.Notification;
import android.content.Context;

public class NotificationTarget extends SimpleTarget
{
    private final Context context;
    private final Notification notification;
    private final int notificationId;
    private final RemoteViews remoteViews;
    private final int viewId;
    
    public NotificationTarget(final Context context, final RemoteViews remoteViews, final int viewId, final int n, final int n2, final Notification notification, final int notificationId) {
        super(n, n2);
        if (context == null) {
            throw new NullPointerException("Context must not be null!");
        }
        if (notification == null) {
            throw new NullPointerException("Notification object can not be null!");
        }
        if (remoteViews != null) {
            this.context = context;
            this.viewId = viewId;
            this.notification = notification;
            this.notificationId = notificationId;
            this.remoteViews = remoteViews;
            return;
        }
        throw new NullPointerException("RemoteViews object can not be null!");
    }
    
    public NotificationTarget(final Context context, final RemoteViews remoteViews, final int n, final Notification notification, final int n2) {
        this(context, remoteViews, n, -1 << -1, -1 << -1, notification, n2);
    }
    
    private void update() {
        ((NotificationManager)this.context.getSystemService("notification")).notify(this.notificationId, this.notification);
    }
    
    public void onResourceReady(final Bitmap bitmap, final GlideAnimation glideAnimation) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        this.update();
    }
}
