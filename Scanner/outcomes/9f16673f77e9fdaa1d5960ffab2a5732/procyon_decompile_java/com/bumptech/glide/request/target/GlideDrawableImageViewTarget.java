// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;

public class GlideDrawableImageViewTarget extends ImageViewTarget
{
    private static final float SQUARE_RATIO_MARGIN = 0.05f;
    private int maxLoopCount;
    private GlideDrawable resource;
    
    public GlideDrawableImageViewTarget(final ImageView imageView) {
        this(imageView, -1);
    }
    
    public GlideDrawableImageViewTarget(final ImageView imageView, final int maxLoopCount) {
        super(imageView);
        this.maxLoopCount = maxLoopCount;
    }
    
    public void onResourceReady(GlideDrawable resource, final GlideAnimation glideAnimation) {
        if (!resource.isAnimated()) {
            final float n = ((ImageView)this.view).getWidth() / ((ImageView)this.view).getHeight();
            final float n2 = resource.getIntrinsicWidth() / resource.getIntrinsicHeight();
            final float n3 = 1.0f;
            final float abs = Math.abs(n - n3);
            final float n4 = 0.05f;
            if (abs <= n4 && Math.abs(n2 - n3) <= n4) {
                resource = new SquaringDrawable(resource, ((ImageView)this.view).getWidth());
            }
        }
        super.onResourceReady(resource, glideAnimation);
        (this.resource = resource).setLoopCount(this.maxLoopCount);
        resource.start();
    }
    
    public void onStart() {
        final GlideDrawable resource = this.resource;
        if (resource != null) {
            resource.start();
        }
    }
    
    public void onStop() {
        final GlideDrawable resource = this.resource;
        if (resource != null) {
            resource.stop();
        }
    }
    
    protected void setResource(final GlideDrawable imageDrawable) {
        ((ImageView)this.view).setImageDrawable((Drawable)imageDrawable);
    }
}
