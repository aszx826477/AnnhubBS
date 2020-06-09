// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class BitmapImageViewTarget extends ImageViewTarget
{
    public BitmapImageViewTarget(final ImageView imageView) {
        super(imageView);
    }
    
    protected void setResource(final Bitmap imageBitmap) {
        ((ImageView)this.view).setImageBitmap(imageBitmap);
    }
}
