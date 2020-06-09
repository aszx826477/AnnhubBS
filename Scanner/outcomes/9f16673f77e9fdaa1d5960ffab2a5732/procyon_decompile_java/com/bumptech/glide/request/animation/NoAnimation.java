// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.animation;

public class NoAnimation implements GlideAnimation
{
    private static final NoAnimation NO_ANIMATION;
    private static final GlideAnimationFactory NO_ANIMATION_FACTORY;
    
    static {
        NO_ANIMATION = new NoAnimation();
        NO_ANIMATION_FACTORY = new NoAnimation$NoAnimationFactory();
    }
    
    public static GlideAnimation get() {
        return NoAnimation.NO_ANIMATION;
    }
    
    public static GlideAnimationFactory getFactory() {
        return NoAnimation.NO_ANIMATION_FACTORY;
    }
    
    public boolean animate(final Object o, final GlideAnimation$ViewAdapter glideAnimation$ViewAdapter) {
        return false;
    }
}
