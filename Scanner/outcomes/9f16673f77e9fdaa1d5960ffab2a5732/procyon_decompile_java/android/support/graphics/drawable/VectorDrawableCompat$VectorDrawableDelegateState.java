// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.graphics.drawable.VectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$ConstantState;

class VectorDrawableCompat$VectorDrawableDelegateState extends Drawable$ConstantState
{
    private final Drawable$ConstantState mDelegateState;
    
    public VectorDrawableCompat$VectorDrawableDelegateState(final Drawable$ConstantState mDelegateState) {
        this.mDelegateState = mDelegateState;
    }
    
    public boolean canApplyTheme() {
        return this.mDelegateState.canApplyTheme();
    }
    
    public int getChangingConfigurations() {
        return this.mDelegateState.getChangingConfigurations();
    }
    
    public Drawable newDrawable() {
        final VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable();
        return vectorDrawableCompat;
    }
    
    public Drawable newDrawable(final Resources resources) {
        final VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable(resources);
        return vectorDrawableCompat;
    }
    
    public Drawable newDrawable(final Resources resources, final Resources$Theme resources$Theme) {
        final VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable(resources, resources$Theme);
        return vectorDrawableCompat;
    }
}
