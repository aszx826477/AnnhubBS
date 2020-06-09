// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.BaseTarget;

class ListPreloader$PreloadTarget extends BaseTarget
{
    private int photoHeight;
    private int photoWidth;
    
    public void getSize(final SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.photoWidth, this.photoHeight);
    }
    
    public void onResourceReady(final Object o, final GlideAnimation glideAnimation) {
    }
}
