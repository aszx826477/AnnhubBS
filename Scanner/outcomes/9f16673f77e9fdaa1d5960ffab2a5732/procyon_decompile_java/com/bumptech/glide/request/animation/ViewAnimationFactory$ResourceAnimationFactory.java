// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.animation;

import android.view.animation.AnimationUtils;
import android.view.animation.Animation;
import android.content.Context;

class ViewAnimationFactory$ResourceAnimationFactory implements ViewAnimation$AnimationFactory
{
    private final int animationId;
    private final Context context;
    
    public ViewAnimationFactory$ResourceAnimationFactory(final Context context, final int animationId) {
        this.context = context.getApplicationContext();
        this.animationId = animationId;
    }
    
    public Animation build() {
        return AnimationUtils.loadAnimation(this.context, this.animationId);
    }
}
