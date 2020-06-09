// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.animation;

import android.view.View;

public class ViewAnimation implements GlideAnimation
{
    private final ViewAnimation$AnimationFactory animationFactory;
    
    ViewAnimation(final ViewAnimation$AnimationFactory animationFactory) {
        this.animationFactory = animationFactory;
    }
    
    public boolean animate(final Object o, final GlideAnimation$ViewAdapter glideAnimation$ViewAdapter) {
        final View view = glideAnimation$ViewAdapter.getView();
        if (view != null) {
            view.clearAnimation();
            view.startAnimation(this.animationFactory.build());
        }
        return false;
    }
}
