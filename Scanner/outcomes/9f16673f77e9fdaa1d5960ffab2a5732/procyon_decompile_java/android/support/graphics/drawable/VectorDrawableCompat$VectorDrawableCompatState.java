// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.graphics.Path$FillType;
import android.graphics.Paint$Style;
import android.support.v4.util.ArrayMap;
import android.graphics.PathMeasure;
import android.graphics.Path;
import android.graphics.Matrix;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.Rect;
import android.graphics.ColorFilter;
import android.graphics.Canvas;
import android.graphics.Bitmap$Config;
import android.graphics.Paint;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable$ConstantState;

class VectorDrawableCompat$VectorDrawableCompatState extends Drawable$ConstantState
{
    boolean mAutoMirrored;
    boolean mCacheDirty;
    boolean mCachedAutoMirrored;
    Bitmap mCachedBitmap;
    int mCachedRootAlpha;
    int[] mCachedThemeAttrs;
    ColorStateList mCachedTint;
    PorterDuff$Mode mCachedTintMode;
    int mChangingConfigurations;
    Paint mTempPaint;
    ColorStateList mTint;
    PorterDuff$Mode mTintMode;
    VectorDrawableCompat$VPathRenderer mVPathRenderer;
    
    public VectorDrawableCompat$VectorDrawableCompatState() {
        this.mTint = null;
        this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
        this.mVPathRenderer = new VectorDrawableCompat$VPathRenderer();
    }
    
    public VectorDrawableCompat$VectorDrawableCompatState(final VectorDrawableCompat$VectorDrawableCompatState vectorDrawableCompat$VectorDrawableCompatState) {
        this.mTint = null;
        this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
        if (vectorDrawableCompat$VectorDrawableCompatState != null) {
            this.mChangingConfigurations = vectorDrawableCompat$VectorDrawableCompatState.mChangingConfigurations;
            this.mVPathRenderer = new VectorDrawableCompat$VPathRenderer(vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer);
            if (vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer.mFillPaint != null) {
                this.mVPathRenderer.mFillPaint = new Paint(vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer.mFillPaint);
            }
            if (vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer.mStrokePaint != null) {
                this.mVPathRenderer.mStrokePaint = new Paint(vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer.mStrokePaint);
            }
            this.mTint = vectorDrawableCompat$VectorDrawableCompatState.mTint;
            this.mTintMode = vectorDrawableCompat$VectorDrawableCompatState.mTintMode;
            this.mAutoMirrored = vectorDrawableCompat$VectorDrawableCompatState.mAutoMirrored;
        }
    }
    
    public boolean canReuseBitmap(final int n, final int n2) {
        return n == this.mCachedBitmap.getWidth() && n2 == this.mCachedBitmap.getHeight();
    }
    
    public boolean canReuseCache() {
        return !this.mCacheDirty && this.mCachedTint == this.mTint && this.mCachedTintMode == this.mTintMode && this.mCachedAutoMirrored == this.mAutoMirrored && this.mCachedRootAlpha == this.mVPathRenderer.getRootAlpha();
    }
    
    public void createCachedBitmapIfNeeded(final int n, final int n2) {
        if (this.mCachedBitmap == null || this.canReuseBitmap(n, n2)) {
            this.mCachedBitmap = Bitmap.createBitmap(n, n2, Bitmap$Config.ARGB_8888);
            this.mCacheDirty = true;
        }
    }
    
    public void drawCachedBitmapWithRootAlpha(final Canvas canvas, final ColorFilter colorFilter, final Rect rect) {
        canvas.drawBitmap(this.mCachedBitmap, (Rect)null, rect, this.getPaint(colorFilter));
    }
    
    public int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }
    
    public Paint getPaint(final ColorFilter colorFilter) {
        if (!this.hasTranslucentRoot() && colorFilter == null) {
            return null;
        }
        if (this.mTempPaint == null) {
            (this.mTempPaint = new Paint()).setFilterBitmap(true);
        }
        this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
        this.mTempPaint.setColorFilter(colorFilter);
        return this.mTempPaint;
    }
    
    public boolean hasTranslucentRoot() {
        return this.mVPathRenderer.getRootAlpha() < 255;
    }
    
    public Drawable newDrawable() {
        return new VectorDrawableCompat(this);
    }
    
    public Drawable newDrawable(final Resources resources) {
        return new VectorDrawableCompat(this);
    }
    
    public void updateCacheStates() {
        this.mCachedTint = this.mTint;
        this.mCachedTintMode = this.mTintMode;
        this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
        this.mCachedAutoMirrored = this.mAutoMirrored;
        this.mCacheDirty = false;
    }
    
    public void updateCachedBitmap(final int n, final int n2) {
        this.mCachedBitmap.eraseColor(0);
        this.mVPathRenderer.draw(new Canvas(this.mCachedBitmap), n, n2, null);
    }
}
