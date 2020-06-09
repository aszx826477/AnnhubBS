// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.util;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SizeReadyCallback;
import android.view.View;
import com.bumptech.glide.request.target.ViewTarget;

final class ViewPreloadSizeProvider$SizeViewTarget extends ViewTarget
{
    public ViewPreloadSizeProvider$SizeViewTarget(final View view, final SizeReadyCallback sizeReadyCallback) {
        super(view);
        this.getSize(sizeReadyCallback);
    }
    
    public void onResourceReady(final Object o, final GlideAnimation glideAnimation) {
    }
}
