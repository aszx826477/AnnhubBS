// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$ConstantState;
import android.view.Gravity;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.content.res.Resources;
import android.graphics.Rect;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;

public class GlideBitmapDrawable extends GlideDrawable
{
    private boolean applyGravity;
    private final Rect destRect;
    private int height;
    private boolean mutated;
    private GlideBitmapDrawable$BitmapState state;
    private int width;
    
    public GlideBitmapDrawable(final Resources resources, final Bitmap bitmap) {
        this(resources, new GlideBitmapDrawable$BitmapState(bitmap));
    }
    
    GlideBitmapDrawable(final Resources resources, final GlideBitmapDrawable$BitmapState state) {
        this.destRect = new Rect();
        if (state != null) {
            this.state = state;
            int targetDensity;
            if (resources != null) {
                final int densityDpi = resources.getDisplayMetrics().densityDpi;
                if (densityDpi == 0) {
                    targetDensity = 160;
                }
                else {
                    targetDensity = densityDpi;
                }
                state.targetDensity = targetDensity;
            }
            else {
                targetDensity = state.targetDensity;
            }
            this.width = state.bitmap.getScaledWidth(targetDensity);
            this.height = state.bitmap.getScaledHeight(targetDensity);
            return;
        }
        throw new NullPointerException("BitmapState must not be null");
    }
    
    public void draw(final Canvas canvas) {
        if (this.applyGravity) {
            Gravity.apply(119, this.width, this.height, this.getBounds(), this.destRect);
            this.applyGravity = false;
        }
        canvas.drawBitmap(this.state.bitmap, (Rect)null, this.destRect, this.state.paint);
    }
    
    public Bitmap getBitmap() {
        return this.state.bitmap;
    }
    
    public Drawable$ConstantState getConstantState() {
        return this.state;
    }
    
    public int getIntrinsicHeight() {
        return this.height;
    }
    
    public int getIntrinsicWidth() {
        return this.width;
    }
    
    public int getOpacity() {
        final Bitmap bitmap = this.state.bitmap;
        int n;
        if (bitmap != null && !bitmap.hasAlpha() && this.state.paint.getAlpha() >= 255) {
            n = -1;
        }
        else {
            n = -3;
        }
        return n;
    }
    
    public boolean isAnimated() {
        return false;
    }
    
    public boolean isRunning() {
        return false;
    }
    
    public Drawable mutate() {
        if (!this.mutated && super.mutate() == this) {
            this.state = new GlideBitmapDrawable$BitmapState(this.state);
            this.mutated = true;
        }
        return this;
    }
    
    protected void onBoundsChange(final Rect rect) {
        super.onBoundsChange(rect);
        this.applyGravity = true;
    }
    
    public void setAlpha(final int alpha) {
        if (this.state.paint.getAlpha() != alpha) {
            this.state.setAlpha(alpha);
            this.invalidateSelf();
        }
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        this.state.setColorFilter(colorFilter);
        this.invalidateSelf();
    }
    
    public void setLoopCount(final int n) {
    }
    
    public void start() {
    }
    
    public void stop() {
    }
}
