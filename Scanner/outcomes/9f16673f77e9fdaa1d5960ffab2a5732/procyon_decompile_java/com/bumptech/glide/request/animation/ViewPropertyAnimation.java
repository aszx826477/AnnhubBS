// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.animation;

public class ViewPropertyAnimation implements GlideAnimation
{
    private final ViewPropertyAnimation$Animator animator;
    
    public ViewPropertyAnimation(final ViewPropertyAnimation$Animator animator) {
        this.animator = animator;
    }
    
    public boolean animate(final Object o, final GlideAnimation$ViewAdapter glideAnimation$ViewAdapter) {
        if (glideAnimation$ViewAdapter.getView() != null) {
            this.animator.animate(glideAnimation$ViewAdapter.getView());
        }
        return false;
    }
}
