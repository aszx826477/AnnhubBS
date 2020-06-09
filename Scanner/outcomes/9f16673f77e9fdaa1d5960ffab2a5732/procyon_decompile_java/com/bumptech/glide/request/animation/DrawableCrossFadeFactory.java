// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.animation;

import android.view.animation.Animation;
import android.content.Context;

public class DrawableCrossFadeFactory implements GlideAnimationFactory
{
    private static final int DEFAULT_DURATION_MS = 300;
    private final ViewAnimationFactory animationFactory;
    private final int duration;
    private DrawableCrossFadeViewAnimation firstResourceAnimation;
    private DrawableCrossFadeViewAnimation secondResourceAnimation;
    
    public DrawableCrossFadeFactory() {
        this(300);
    }
    
    public DrawableCrossFadeFactory(final int n) {
        this(new ViewAnimationFactory(new DrawableCrossFadeFactory$DefaultAnimationFactory(n)), n);
    }
    
    public DrawableCrossFadeFactory(final Context context, final int n, final int n2) {
        this(new ViewAnimationFactory(context, n), n2);
    }
    
    public DrawableCrossFadeFactory(final Animation animation, final int n) {
        this(new ViewAnimationFactory(animation), n);
    }
    
    DrawableCrossFadeFactory(final ViewAnimationFactory animationFactory, final int duration) {
        this.animationFactory = animationFactory;
        this.duration = duration;
    }
    
    private GlideAnimation getFirstResourceAnimation() {
        if (this.firstResourceAnimation == null) {
            this.firstResourceAnimation = new DrawableCrossFadeViewAnimation(this.animationFactory.build(false, true), this.duration);
        }
        return this.firstResourceAnimation;
    }
    
    private GlideAnimation getSecondResourceAnimation() {
        if (this.secondResourceAnimation == null) {
            this.secondResourceAnimation = new DrawableCrossFadeViewAnimation(this.animationFactory.build(false, false), this.duration);
        }
        return this.secondResourceAnimation;
    }
    
    public GlideAnimation build(final boolean b, final boolean b2) {
        if (b) {
            return NoAnimation.get();
        }
        if (b2) {
            return this.getFirstResourceAnimation();
        }
        return this.getSecondResourceAnimation();
    }
}
