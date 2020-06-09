// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.target;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;

public final class PreloadTarget extends SimpleTarget
{
    private PreloadTarget(final int n, final int n2) {
        super(n, n2);
    }
    
    public static PreloadTarget obtain(final int n, final int n2) {
        return new PreloadTarget(n, n2);
    }
    
    public void onResourceReady(final Object o, final GlideAnimation glideAnimation) {
        Glide.clear(this);
    }
}
