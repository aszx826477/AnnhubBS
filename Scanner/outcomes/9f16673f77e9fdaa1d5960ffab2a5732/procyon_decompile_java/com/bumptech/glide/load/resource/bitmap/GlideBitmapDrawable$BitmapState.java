// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.ColorFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable$ConstantState;

class GlideBitmapDrawable$BitmapState extends Drawable$ConstantState
{
    private static final Paint DEFAULT_PAINT;
    private static final int DEFAULT_PAINT_FLAGS = 6;
    private static final int GRAVITY = 119;
    final Bitmap bitmap;
    Paint paint;
    int targetDensity;
    
    static {
        DEFAULT_PAINT = new Paint(6);
    }
    
    public GlideBitmapDrawable$BitmapState(final Bitmap bitmap) {
        this.paint = GlideBitmapDrawable$BitmapState.DEFAULT_PAINT;
        this.bitmap = bitmap;
    }
    
    GlideBitmapDrawable$BitmapState(final GlideBitmapDrawable$BitmapState glideBitmapDrawable$BitmapState) {
        this(glideBitmapDrawable$BitmapState.bitmap);
        this.targetDensity = glideBitmapDrawable$BitmapState.targetDensity;
    }
    
    public int getChangingConfigurations() {
        return 0;
    }
    
    void mutatePaint() {
        if (GlideBitmapDrawable$BitmapState.DEFAULT_PAINT == this.paint) {
            this.paint = new Paint(6);
        }
    }
    
    public Drawable newDrawable() {
        return new GlideBitmapDrawable(null, this);
    }
    
    public Drawable newDrawable(final Resources resources) {
        return new GlideBitmapDrawable(resources, this);
    }
    
    void setAlpha(final int alpha) {
        this.mutatePaint();
        this.paint.setAlpha(alpha);
    }
    
    void setColorFilter(final ColorFilter colorFilter) {
        this.mutatePaint();
        this.paint.setColorFilter(colorFilter);
    }
}
