// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

class DrawableCompat$MDrawableImpl extends DrawableCompat$LollipopDrawableImpl
{
    public void clearColorFilter(final Drawable drawable) {
        drawable.clearColorFilter();
    }
    
    public int getLayoutDirection(final Drawable drawable) {
        return DrawableCompatApi23.getLayoutDirection(drawable);
    }
    
    public boolean setLayoutDirection(final Drawable drawable, final int n) {
        return DrawableCompatApi23.setLayoutDirection(drawable, n);
    }
    
    public Drawable wrap(final Drawable drawable) {
        return drawable;
    }
}
