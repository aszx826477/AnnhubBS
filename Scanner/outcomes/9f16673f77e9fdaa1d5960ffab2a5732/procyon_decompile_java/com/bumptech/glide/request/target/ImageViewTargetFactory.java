// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import android.widget.ImageView;

public class ImageViewTargetFactory
{
    public Target buildTarget(final ImageView imageView, final Class clazz) {
        if (GlideDrawable.class.isAssignableFrom(clazz)) {
            return new GlideDrawableImageViewTarget(imageView);
        }
        if (Bitmap.class.equals(clazz)) {
            return new BitmapImageViewTarget(imageView);
        }
        if (Drawable.class.isAssignableFrom(clazz)) {
            return new DrawableImageViewTarget(imageView);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unhandled class: ");
        sb.append(clazz);
        sb.append(", try .as*(Class).transcode(ResourceTranscoder)");
        throw new IllegalArgumentException(sb.toString());
    }
}
