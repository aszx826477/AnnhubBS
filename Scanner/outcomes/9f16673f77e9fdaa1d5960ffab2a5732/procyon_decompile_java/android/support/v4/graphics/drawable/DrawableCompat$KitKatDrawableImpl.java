// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

class DrawableCompat$KitKatDrawableImpl extends DrawableCompat$JellybeanMr1DrawableImpl
{
    public int getAlpha(final Drawable drawable) {
        return DrawableCompatKitKat.getAlpha(drawable);
    }
    
    public boolean isAutoMirrored(final Drawable drawable) {
        return DrawableCompatKitKat.isAutoMirrored(drawable);
    }
    
    public void setAutoMirrored(final Drawable drawable, final boolean b) {
        DrawableCompatKitKat.setAutoMirrored(drawable, b);
    }
    
    public Drawable wrap(final Drawable drawable) {
        return DrawableCompatKitKat.wrapForTinting(drawable);
    }
}
