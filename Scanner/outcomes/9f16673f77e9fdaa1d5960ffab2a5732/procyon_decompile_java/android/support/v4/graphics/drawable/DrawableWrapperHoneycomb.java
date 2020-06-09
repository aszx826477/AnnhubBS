// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class DrawableWrapperHoneycomb extends DrawableWrapperGingerbread
{
    DrawableWrapperHoneycomb(final Drawable drawable) {
        super(drawable);
    }
    
    DrawableWrapperHoneycomb(final DrawableWrapperGingerbread$DrawableWrapperState drawableWrapperGingerbread$DrawableWrapperState, final Resources resources) {
        super(drawableWrapperGingerbread$DrawableWrapperState, resources);
    }
    
    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }
    
    DrawableWrapperGingerbread$DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperHoneycomb$DrawableWrapperStateHoneycomb(this.mState, null);
    }
}
