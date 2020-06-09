// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable$ConstantState;

public abstract class DrawableWrapperGingerbread$DrawableWrapperState extends Drawable$ConstantState
{
    int mChangingConfigurations;
    Drawable$ConstantState mDrawableState;
    ColorStateList mTint;
    PorterDuff$Mode mTintMode;
    
    DrawableWrapperGingerbread$DrawableWrapperState(final DrawableWrapperGingerbread$DrawableWrapperState drawableWrapperGingerbread$DrawableWrapperState, final Resources resources) {
        this.mTint = null;
        this.mTintMode = DrawableWrapperGingerbread.DEFAULT_TINT_MODE;
        if (drawableWrapperGingerbread$DrawableWrapperState != null) {
            this.mChangingConfigurations = drawableWrapperGingerbread$DrawableWrapperState.mChangingConfigurations;
            this.mDrawableState = drawableWrapperGingerbread$DrawableWrapperState.mDrawableState;
            this.mTint = drawableWrapperGingerbread$DrawableWrapperState.mTint;
            this.mTintMode = drawableWrapperGingerbread$DrawableWrapperState.mTintMode;
        }
    }
    
    boolean canConstantState() {
        return this.mDrawableState != null;
    }
    
    public int getChangingConfigurations() {
        final int mChangingConfigurations = this.mChangingConfigurations;
        final Drawable$ConstantState mDrawableState = this.mDrawableState;
        int changingConfigurations;
        if (mDrawableState != null) {
            changingConfigurations = mDrawableState.getChangingConfigurations();
        }
        else {
            changingConfigurations = 0;
        }
        return mChangingConfigurations | changingConfigurations;
    }
    
    public Drawable newDrawable() {
        return this.newDrawable(null);
    }
    
    public abstract Drawable newDrawable(final Resources p0);
}
