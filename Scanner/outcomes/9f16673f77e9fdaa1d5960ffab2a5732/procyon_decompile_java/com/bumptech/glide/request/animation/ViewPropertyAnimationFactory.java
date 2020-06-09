// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.animation;

public class ViewPropertyAnimationFactory implements GlideAnimationFactory
{
    private ViewPropertyAnimation animation;
    private final ViewPropertyAnimation$Animator animator;
    
    public ViewPropertyAnimationFactory(final ViewPropertyAnimation$Animator animator) {
        this.animator = animator;
    }
    
    public GlideAnimation build(final boolean b, final boolean b2) {
        if (!b && b2) {
            if (this.animation == null) {
                this.animation = new ViewPropertyAnimation(this.animator);
            }
            return this.animation;
        }
        return NoAnimation.get();
    }
}
