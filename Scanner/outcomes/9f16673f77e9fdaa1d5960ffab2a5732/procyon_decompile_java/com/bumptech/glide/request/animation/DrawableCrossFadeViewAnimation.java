// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.animation;

import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.Drawable;

public class DrawableCrossFadeViewAnimation implements GlideAnimation
{
    private final GlideAnimation defaultAnimation;
    private final int duration;
    
    public DrawableCrossFadeViewAnimation(final GlideAnimation defaultAnimation, final int duration) {
        this.defaultAnimation = defaultAnimation;
        this.duration = duration;
    }
    
    public boolean animate(final Drawable drawable, final GlideAnimation$ViewAdapter glideAnimation$ViewAdapter) {
        final Drawable currentDrawable = glideAnimation$ViewAdapter.getCurrentDrawable();
        if (currentDrawable != null) {
            final Drawable[] array = { currentDrawable, null };
            final int crossFadeEnabled = 1;
            array[crossFadeEnabled] = drawable;
            final TransitionDrawable drawable2 = new TransitionDrawable(array);
            drawable2.setCrossFadeEnabled((boolean)(crossFadeEnabled != 0));
            drawable2.startTransition(this.duration);
            glideAnimation$ViewAdapter.setDrawable((Drawable)drawable2);
            return crossFadeEnabled != 0;
        }
        this.defaultAnimation.animate(drawable, glideAnimation$ViewAdapter);
        return false;
    }
}
