// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class DrawableImageViewTarget extends ImageViewTarget
{
    public DrawableImageViewTarget(final ImageView imageView) {
        super(imageView);
    }
    
    protected void setResource(final Drawable imageDrawable) {
        ((ImageView)this.view).setImageDrawable(imageDrawable);
    }
}
