// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.animation;

import android.view.animation.Animation;

class ViewAnimationFactory$ConcreteAnimationFactory implements ViewAnimation$AnimationFactory
{
    private final Animation animation;
    
    public ViewAnimationFactory$ConcreteAnimationFactory(final Animation animation) {
        this.animation = animation;
    }
    
    public Animation build() {
        return this.animation;
    }
}
