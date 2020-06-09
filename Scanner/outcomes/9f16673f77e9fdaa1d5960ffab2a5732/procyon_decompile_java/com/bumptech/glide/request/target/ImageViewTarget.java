// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.target;

import com.bumptech.glide.request.animation.GlideAnimation;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.request.animation.GlideAnimation$ViewAdapter;

public abstract class ImageViewTarget extends ViewTarget implements GlideAnimation$ViewAdapter
{
    public ImageViewTarget(final ImageView imageView) {
        super((View)imageView);
    }
    
    public Drawable getCurrentDrawable() {
        return ((ImageView)this.view).getDrawable();
    }
    
    public void onLoadCleared(final Drawable imageDrawable) {
        ((ImageView)this.view).setImageDrawable(imageDrawable);
    }
    
    public void onLoadFailed(final Exception ex, final Drawable imageDrawable) {
        ((ImageView)this.view).setImageDrawable(imageDrawable);
    }
    
    public void onLoadStarted(final Drawable imageDrawable) {
        ((ImageView)this.view).setImageDrawable(imageDrawable);
    }
    
    public void onResourceReady(final Object resource, final GlideAnimation glideAnimation) {
        if (glideAnimation == null || glideAnimation.animate(resource, this)) {
            this.setResource(resource);
        }
    }
    
    public void setDrawable(final Drawable imageDrawable) {
        ((ImageView)this.view).setImageDrawable(imageDrawable);
    }
    
    protected abstract void setResource(final Object p0);
}
