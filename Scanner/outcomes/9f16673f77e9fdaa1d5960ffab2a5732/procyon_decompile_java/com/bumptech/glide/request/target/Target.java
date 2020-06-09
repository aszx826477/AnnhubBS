// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.target;

import com.bumptech.glide.request.animation.GlideAnimation;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.manager.LifecycleListener;

public interface Target extends LifecycleListener
{
    public static final int SIZE_ORIGINAL = Integer.MIN_VALUE;
    
    Request getRequest();
    
    void getSize(final SizeReadyCallback p0);
    
    void onLoadCleared(final Drawable p0);
    
    void onLoadFailed(final Exception p0, final Drawable p1);
    
    void onLoadStarted(final Drawable p0);
    
    void onResourceReady(final Object p0, final GlideAnimation p1);
    
    void setRequest(final Request p0);
}
