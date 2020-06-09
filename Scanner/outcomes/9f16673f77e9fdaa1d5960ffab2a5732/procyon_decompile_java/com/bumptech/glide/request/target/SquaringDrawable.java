// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.target;

import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.Canvas;
import android.content.res.Resources;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;

public class SquaringDrawable extends GlideDrawable
{
    private boolean mutated;
    private SquaringDrawable$State state;
    private GlideDrawable wrapped;
    
    public SquaringDrawable(final GlideDrawable glideDrawable, final int n) {
        this(new SquaringDrawable$State(glideDrawable.getConstantState(), n), glideDrawable, null);
    }
    
    SquaringDrawable(final SquaringDrawable$State state, final GlideDrawable wrapped, final Resources resources) {
        this.state = state;
        if (wrapped == null) {
            if (resources != null) {
                this.wrapped = (GlideDrawable)state.wrapped.newDrawable(resources);
            }
            else {
                this.wrapped = (GlideDrawable)state.wrapped.newDrawable();
            }
        }
        else {
            this.wrapped = wrapped;
        }
    }
    
    public void clearColorFilter() {
        this.wrapped.clearColorFilter();
    }
    
    public void draw(final Canvas canvas) {
        this.wrapped.draw(canvas);
    }
    
    public int getAlpha() {
        return this.wrapped.getAlpha();
    }
    
    public Drawable$Callback getCallback() {
        return this.wrapped.getCallback();
    }
    
    public int getChangingConfigurations() {
        return this.wrapped.getChangingConfigurations();
    }
    
    public Drawable$ConstantState getConstantState() {
        return this.state;
    }
    
    public Drawable getCurrent() {
        return this.wrapped.getCurrent();
    }
    
    public int getIntrinsicHeight() {
        return this.state.side;
    }
    
    public int getIntrinsicWidth() {
        return this.state.side;
    }
    
    public int getMinimumHeight() {
        return this.wrapped.getMinimumHeight();
    }
    
    public int getMinimumWidth() {
        return this.wrapped.getMinimumWidth();
    }
    
    public int getOpacity() {
        return this.wrapped.getOpacity();
    }
    
    public boolean getPadding(final Rect rect) {
        return this.wrapped.getPadding(rect);
    }
    
    public void invalidateSelf() {
        super.invalidateSelf();
        this.wrapped.invalidateSelf();
    }
    
    public boolean isAnimated() {
        return this.wrapped.isAnimated();
    }
    
    public boolean isRunning() {
        return this.wrapped.isRunning();
    }
    
    public Drawable mutate() {
        if (!this.mutated && super.mutate() == this) {
            this.wrapped = (GlideDrawable)this.wrapped.mutate();
            this.state = new SquaringDrawable$State(this.state);
            this.mutated = true;
        }
        return this;
    }
    
    public void scheduleSelf(final Runnable runnable, final long n) {
        super.scheduleSelf(runnable, n);
        this.wrapped.scheduleSelf(runnable, n);
    }
    
    public void setAlpha(final int alpha) {
        this.wrapped.setAlpha(alpha);
    }
    
    public void setBounds(final int n, final int n2, final int n3, final int n4) {
        super.setBounds(n, n2, n3, n4);
        this.wrapped.setBounds(n, n2, n3, n4);
    }
    
    public void setBounds(final Rect rect) {
        super.setBounds(rect);
        this.wrapped.setBounds(rect);
    }
    
    public void setChangingConfigurations(final int changingConfigurations) {
        this.wrapped.setChangingConfigurations(changingConfigurations);
    }
    
    public void setColorFilter(final int n, final PorterDuff$Mode porterDuff$Mode) {
        this.wrapped.setColorFilter(n, porterDuff$Mode);
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        this.wrapped.setColorFilter(colorFilter);
    }
    
    public void setDither(final boolean dither) {
        this.wrapped.setDither(dither);
    }
    
    public void setFilterBitmap(final boolean filterBitmap) {
        this.wrapped.setFilterBitmap(filterBitmap);
    }
    
    public void setLoopCount(final int loopCount) {
        this.wrapped.setLoopCount(loopCount);
    }
    
    public boolean setVisible(final boolean b, final boolean b2) {
        return this.wrapped.setVisible(b, b2);
    }
    
    public void start() {
        this.wrapped.start();
    }
    
    public void stop() {
        this.wrapped.stop();
    }
    
    public void unscheduleSelf(final Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.wrapped.unscheduleSelf(runnable);
    }
}
