// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.widget.ImageView;

class ImageViewCompat$LollipopViewCompatImpl extends ImageViewCompat$BaseViewCompatImpl
{
    public ColorStateList getImageTintList(final ImageView imageView) {
        return ImageViewCompatLollipop.getImageTintList(imageView);
    }
    
    public PorterDuff$Mode getImageTintMode(final ImageView imageView) {
        return ImageViewCompatLollipop.getImageTintMode(imageView);
    }
    
    public void setImageTintList(final ImageView imageView, final ColorStateList list) {
        ImageViewCompatLollipop.setImageTintList(imageView, list);
    }
    
    public void setImageTintMode(final ImageView imageView, final PorterDuff$Mode porterDuff$Mode) {
        ImageViewCompatLollipop.setImageTintMode(imageView, porterDuff$Mode);
    }
}
