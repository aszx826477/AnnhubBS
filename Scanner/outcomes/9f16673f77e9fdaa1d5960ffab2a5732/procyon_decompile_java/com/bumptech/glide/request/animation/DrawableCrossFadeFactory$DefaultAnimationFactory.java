// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.animation;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

class DrawableCrossFadeFactory$DefaultAnimationFactory implements ViewAnimation$AnimationFactory
{
    private final int duration;
    
    DrawableCrossFadeFactory$DefaultAnimationFactory(final int duration) {
        this.duration = duration;
    }
    
    public Animation build() {
        final AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration((long)this.duration);
        return (Animation)alphaAnimation;
    }
}
