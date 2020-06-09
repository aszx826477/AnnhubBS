// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.content.res.Resources;

class DrawableWrapperGingerbread$DrawableWrapperStateBase extends DrawableWrapperGingerbread$DrawableWrapperState
{
    DrawableWrapperGingerbread$DrawableWrapperStateBase(final DrawableWrapperGingerbread$DrawableWrapperState drawableWrapperGingerbread$DrawableWrapperState, final Resources resources) {
        super(drawableWrapperGingerbread$DrawableWrapperState, resources);
    }
    
    public Drawable newDrawable(final Resources resources) {
        return new DrawableWrapperGingerbread(this, resources);
    }
}
