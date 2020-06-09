// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.target;

import com.bumptech.glide.request.animation.GlideAnimation;
import android.graphics.Bitmap;
import android.appwidget.AppWidgetManager;
import android.widget.RemoteViews;
import android.content.Context;
import android.content.ComponentName;

public class AppWidgetTarget extends SimpleTarget
{
    private final ComponentName componentName;
    private final Context context;
    private final RemoteViews remoteViews;
    private final int viewId;
    private final int[] widgetIds;
    
    public AppWidgetTarget(final Context context, final RemoteViews remoteViews, final int viewId, final int n, final int n2, final ComponentName componentName) {
        super(n, n2);
        if (context == null) {
            throw new NullPointerException("Context can not be null!");
        }
        if (componentName == null) {
            throw new NullPointerException("ComponentName can not be null!");
        }
        if (remoteViews != null) {
            this.context = context;
            this.remoteViews = remoteViews;
            this.viewId = viewId;
            this.componentName = componentName;
            this.widgetIds = null;
            return;
        }
        throw new NullPointerException("RemoteViews object can not be null!");
    }
    
    public AppWidgetTarget(final Context context, final RemoteViews remoteViews, final int viewId, final int n, final int n2, final int... widgetIds) {
        super(n, n2);
        if (context == null) {
            throw new NullPointerException("Context can not be null!");
        }
        if (widgetIds == null) {
            throw new NullPointerException("WidgetIds can not be null!");
        }
        if (widgetIds.length == 0) {
            throw new IllegalArgumentException("WidgetIds must have length > 0");
        }
        if (remoteViews != null) {
            this.context = context;
            this.remoteViews = remoteViews;
            this.viewId = viewId;
            this.widgetIds = widgetIds;
            this.componentName = null;
            return;
        }
        throw new NullPointerException("RemoteViews object can not be null!");
    }
    
    public AppWidgetTarget(final Context context, final RemoteViews remoteViews, final int n, final ComponentName componentName) {
        this(context, remoteViews, n, -1 << -1, -1 << -1, componentName);
    }
    
    public AppWidgetTarget(final Context context, final RemoteViews remoteViews, final int n, final int... array) {
        this(context, remoteViews, n, -1 << -1, -1 << -1, array);
    }
    
    private void update() {
        final AppWidgetManager instance = AppWidgetManager.getInstance(this.context);
        final ComponentName componentName = this.componentName;
        if (componentName != null) {
            instance.updateAppWidget(componentName, this.remoteViews);
        }
        else {
            instance.updateAppWidget(this.widgetIds, this.remoteViews);
        }
    }
    
    public void onResourceReady(final Bitmap bitmap, final GlideAnimation glideAnimation) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        this.update();
    }
}
