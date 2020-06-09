// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.animation;

import android.view.animation.Animation;
import android.content.Context;

public class ViewAnimationFactory implements GlideAnimationFactory
{
    private final ViewAnimation$AnimationFactory animationFactory;
    private GlideAnimation glideAnimation;
    
    public ViewAnimationFactory(final Context context, final int n) {
        this(new ViewAnimationFactory$ResourceAnimationFactory(context, n));
    }
    
    public ViewAnimationFactory(final Animation animation) {
        this(new ViewAnimationFactory$ConcreteAnimationFactory(animation));
    }
    
    ViewAnimationFactory(final ViewAnimation$AnimationFactory animationFactory) {
        this.animationFactory = animationFactory;
    }
    
    public GlideAnimation build(final boolean b, final boolean b2) {
        if (!b && b2) {
            if (this.glideAnimation == null) {
                this.glideAnimation = new ViewAnimation(this.animationFactory);
            }
            return this.glideAnimation;
        }
        return NoAnimation.get();
    }
}
