// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.widget.ImageView;
import android.os.Build$VERSION;

public class ImageViewCompat
{
    static final ImageViewCompat$ImageViewCompatImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 21) {
            IMPL = new ImageViewCompat$LollipopViewCompatImpl();
        }
        else {
            IMPL = new ImageViewCompat$BaseViewCompatImpl();
        }
    }
    
    public static ColorStateList getImageTintList(final ImageView imageView) {
        return ImageViewCompat.IMPL.getImageTintList(imageView);
    }
    
    public static PorterDuff$Mode getImageTintMode(final ImageView imageView) {
        return ImageViewCompat.IMPL.getImageTintMode(imageView);
    }
    
    public static void setImageTintList(final ImageView imageView, final ColorStateList list) {
        ImageViewCompat.IMPL.setImageTintList(imageView, list);
    }
    
    public static void setImageTintMode(final ImageView imageView, final PorterDuff$Mode porterDuff$Mode) {
        ImageViewCompat.IMPL.setImageTintMode(imageView, porterDuff$Mode);
    }
}
