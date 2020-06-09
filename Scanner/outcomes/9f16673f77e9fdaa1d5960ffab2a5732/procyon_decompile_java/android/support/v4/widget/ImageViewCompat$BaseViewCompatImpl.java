// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.widget.ImageView;

class ImageViewCompat$BaseViewCompatImpl implements ImageViewCompat$ImageViewCompatImpl
{
    public ColorStateList getImageTintList(final ImageView imageView) {
        return ImageViewCompatBase.getImageTintList(imageView);
    }
    
    public PorterDuff$Mode getImageTintMode(final ImageView imageView) {
        return ImageViewCompatBase.getImageTintMode(imageView);
    }
    
    public void setImageTintList(final ImageView imageView, final ColorStateList list) {
        ImageViewCompatBase.setImageTintList(imageView, list);
    }
    
    public void setImageTintMode(final ImageView imageView, final PorterDuff$Mode porterDuff$Mode) {
        ImageViewCompatBase.setImageTintMode(imageView, porterDuff$Mode);
    }
}
