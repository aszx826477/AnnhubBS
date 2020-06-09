// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics.drawable;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build$VERSION;
import android.graphics.Outline;
import android.graphics.Rect;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class DrawableWrapperLollipop extends DrawableWrapperKitKat
{
    DrawableWrapperLollipop(final Drawable drawable) {
        super(drawable);
    }
    
    DrawableWrapperLollipop(final DrawableWrapperGingerbread$DrawableWrapperState drawableWrapperGingerbread$DrawableWrapperState, final Resources resources) {
        super(drawableWrapperGingerbread$DrawableWrapperState, resources);
    }
    
    public Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }
    
    public void getOutline(final Outline outline) {
        this.mDrawable.getOutline(outline);
    }
    
    protected boolean isCompatTintEnabled() {
        final int sdk_INT = Build$VERSION.SDK_INT;
        boolean b = false;
        if (sdk_INT == 21) {
            final Drawable mDrawable = this.mDrawable;
            if (mDrawable instanceof GradientDrawable || mDrawable instanceof DrawableContainer || mDrawable instanceof InsetDrawable) {
                b = true;
            }
            return b;
        }
        return false;
    }
    
    DrawableWrapperGingerbread$DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperLollipop$DrawableWrapperStateLollipop(this.mState, null);
    }
    
    public void setHotspot(final float n, final float n2) {
        this.mDrawable.setHotspot(n, n2);
    }
    
    public void setHotspotBounds(final int n, final int n2, final int n3, final int n4) {
        this.mDrawable.setHotspotBounds(n, n2, n3, n4);
    }
    
    public boolean setState(final int[] state) {
        if (super.setState(state)) {
            this.invalidateSelf();
            return true;
        }
        return false;
    }
    
    public void setTint(final int n) {
        if (this.isCompatTintEnabled()) {
            super.setTint(n);
        }
        else {
            this.mDrawable.setTint(n);
        }
    }
    
    public void setTintList(final ColorStateList list) {
        if (this.isCompatTintEnabled()) {
            super.setTintList(list);
        }
        else {
            this.mDrawable.setTintList(list);
        }
    }
    
    public void setTintMode(final PorterDuff$Mode porterDuff$Mode) {
        if (this.isCompatTintEnabled()) {
            super.setTintMode(porterDuff$Mode);
        }
        else {
            this.mDrawable.setTintMode(porterDuff$Mode);
        }
    }
}
