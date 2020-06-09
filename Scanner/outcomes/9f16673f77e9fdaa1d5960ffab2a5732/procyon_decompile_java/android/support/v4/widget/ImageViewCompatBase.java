// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.widget.ImageView;

class ImageViewCompatBase
{
    static ColorStateList getImageTintList(final ImageView imageView) {
        ColorStateList supportImageTintList;
        if (imageView instanceof TintableImageSourceView) {
            supportImageTintList = ((TintableImageSourceView)imageView).getSupportImageTintList();
        }
        else {
            supportImageTintList = null;
        }
        return supportImageTintList;
    }
    
    static PorterDuff$Mode getImageTintMode(final ImageView imageView) {
        PorterDuff$Mode supportImageTintMode;
        if (imageView instanceof TintableImageSourceView) {
            supportImageTintMode = ((TintableImageSourceView)imageView).getSupportImageTintMode();
        }
        else {
            supportImageTintMode = null;
        }
        return supportImageTintMode;
    }
    
    static void setImageTintList(final ImageView imageView, final ColorStateList supportImageTintList) {
        if (imageView instanceof TintableImageSourceView) {
            ((TintableImageSourceView)imageView).setSupportImageTintList(supportImageTintList);
        }
    }
    
    static void setImageTintMode(final ImageView imageView, final PorterDuff$Mode supportImageTintMode) {
        if (imageView instanceof TintableImageSourceView) {
            ((TintableImageSourceView)imageView).setSupportImageTintMode(supportImageTintMode);
        }
    }
}
