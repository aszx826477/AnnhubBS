// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.graphics.PorterDuff$Mode;
import android.graphics.Region;
import android.graphics.Rect;
import android.graphics.ColorFilter;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.content.res.Resources$Theme;
import android.support.v4.graphics.drawable.TintAwareDrawable;
import android.graphics.drawable.Drawable;

abstract class VectorDrawableCommon extends Drawable implements TintAwareDrawable
{
    Drawable mDelegateDrawable;
    
    public void applyTheme(final Resources$Theme resources$Theme) {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            DrawableCompat.applyTheme(mDelegateDrawable, resources$Theme);
        }
    }
    
    public void clearColorFilter() {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            mDelegateDrawable.clearColorFilter();
            return;
        }
        super.clearColorFilter();
    }
    
    public ColorFilter getColorFilter() {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            return DrawableCompat.getColorFilter(mDelegateDrawable);
        }
        return null;
    }
    
    public Drawable getCurrent() {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getCurrent();
        }
        return super.getCurrent();
    }
    
    public int getMinimumHeight() {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }
    
    public int getMinimumWidth() {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }
    
    public boolean getPadding(final Rect rect) {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getPadding(rect);
        }
        return super.getPadding(rect);
    }
    
    public int[] getState() {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getState();
        }
        return super.getState();
    }
    
    public Region getTransparentRegion() {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }
    
    public void jumpToCurrentState() {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            DrawableCompat.jumpToCurrentState(mDelegateDrawable);
        }
    }
    
    protected void onBoundsChange(final Rect bounds) {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            mDelegateDrawable.setBounds(bounds);
            return;
        }
        super.onBoundsChange(bounds);
    }
    
    protected boolean onLevelChange(final int level) {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.setLevel(level);
        }
        return super.onLevelChange(level);
    }
    
    public void setChangingConfigurations(final int n) {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            mDelegateDrawable.setChangingConfigurations(n);
            return;
        }
        super.setChangingConfigurations(n);
    }
    
    public void setColorFilter(final int n, final PorterDuff$Mode porterDuff$Mode) {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            mDelegateDrawable.setColorFilter(n, porterDuff$Mode);
            return;
        }
        super.setColorFilter(n, porterDuff$Mode);
    }
    
    public void setFilterBitmap(final boolean filterBitmap) {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            mDelegateDrawable.setFilterBitmap(filterBitmap);
        }
    }
    
    public void setHotspot(final float n, final float n2) {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            DrawableCompat.setHotspot(mDelegateDrawable, n, n2);
        }
    }
    
    public void setHotspotBounds(final int n, final int n2, final int n3, final int n4) {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            DrawableCompat.setHotspotBounds(mDelegateDrawable, n, n2, n3, n4);
        }
    }
    
    public boolean setState(final int[] array) {
        final Drawable mDelegateDrawable = this.mDelegateDrawable;
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.setState(array);
        }
        return super.setState(array);
    }
}
