// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

class DrawableCompatHoneycomb
{
    public static void jumpToCurrentState(final Drawable drawable) {
        drawable.jumpToCurrentState();
    }
    
    public static Drawable wrapForTinting(final Drawable drawable) {
        if (!(drawable instanceof TintAwareDrawable)) {
            return new DrawableWrapperHoneycomb(drawable);
        }
        return drawable;
    }
}
