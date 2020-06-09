// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.widget.ImageView;

class ImageViewCompatLollipop
{
    static ColorStateList getImageTintList(final ImageView imageView) {
        return imageView.getImageTintList();
    }
    
    static PorterDuff$Mode getImageTintMode(final ImageView imageView) {
        return imageView.getImageTintMode();
    }
    
    static void setImageTintList(final ImageView imageView, final ColorStateList imageTintList) {
        imageView.setImageTintList(imageTintList);
        if (Build$VERSION.SDK_INT == 21) {
            final Drawable drawable = imageView.getDrawable();
            final boolean b = imageView.getImageTintList() != null && imageView.getImageTintMode() != null;
            if (drawable != null && b) {
                if (drawable.isStateful()) {
                    drawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(drawable);
            }
        }
    }
    
    static void setImageTintMode(final ImageView imageView, final PorterDuff$Mode imageTintMode) {
        imageView.setImageTintMode(imageTintMode);
        if (Build$VERSION.SDK_INT == 21) {
            final Drawable drawable = imageView.getDrawable();
            final boolean b = imageView.getImageTintList() != null && imageView.getImageTintMode() != null;
            if (drawable != null && b) {
                if (drawable.isStateful()) {
                    drawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(drawable);
            }
        }
    }
}
