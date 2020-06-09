// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.request.animation.GlideAnimation;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.request.target.ViewTarget;

class Glide$ClearTarget extends ViewTarget
{
    public Glide$ClearTarget(final View view) {
        super(view);
    }
    
    public void onLoadCleared(final Drawable drawable) {
    }
    
    public void onLoadFailed(final Exception ex, final Drawable drawable) {
    }
    
    public void onLoadStarted(final Drawable drawable) {
    }
    
    public void onResourceReady(final Object o, final GlideAnimation glideAnimation) {
    }
}
