// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$ConstantState;

class AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState extends Drawable$ConstantState
{
    private final Drawable$ConstantState mDelegateState;
    
    public AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState(final Drawable$ConstantState mDelegateState) {
        this.mDelegateState = mDelegateState;
    }
    
    public boolean canApplyTheme() {
        return this.mDelegateState.canApplyTheme();
    }
    
    public int getChangingConfigurations() {
        return this.mDelegateState.getChangingConfigurations();
    }
    
    public Drawable newDrawable() {
        final AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
        (animatedVectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable()).setCallback(animatedVectorDrawableCompat.mCallback);
        return animatedVectorDrawableCompat;
    }
    
    public Drawable newDrawable(final Resources resources) {
        final AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
        (animatedVectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable(resources)).setCallback(animatedVectorDrawableCompat.mCallback);
        return animatedVectorDrawableCompat;
    }
    
    public Drawable newDrawable(final Resources resources, final Resources$Theme resources$Theme) {
        final AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
        (animatedVectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable(resources, resources$Theme)).setCallback(animatedVectorDrawableCompat.mCallback);
        return animatedVectorDrawableCompat;
    }
}
