// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class DrawableWrapperKitKat extends DrawableWrapperHoneycomb
{
    DrawableWrapperKitKat(final Drawable drawable) {
        super(drawable);
    }
    
    DrawableWrapperKitKat(final DrawableWrapperGingerbread$DrawableWrapperState drawableWrapperGingerbread$DrawableWrapperState, final Resources resources) {
        super(drawableWrapperGingerbread$DrawableWrapperState, resources);
    }
    
    public boolean isAutoMirrored() {
        return this.mDrawable.isAutoMirrored();
    }
    
    DrawableWrapperGingerbread$DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperKitKat$DrawableWrapperStateKitKat(this.mState, null);
    }
    
    public void setAutoMirrored(final boolean autoMirrored) {
        this.mDrawable.setAutoMirrored(autoMirrored);
    }
}
