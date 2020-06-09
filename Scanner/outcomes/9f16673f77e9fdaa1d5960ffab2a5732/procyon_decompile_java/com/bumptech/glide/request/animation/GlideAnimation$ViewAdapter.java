// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.animation;

import android.view.View;
import android.graphics.drawable.Drawable;

public interface GlideAnimation$ViewAdapter
{
    Drawable getCurrentDrawable();
    
    View getView();
    
    void setDrawable(final Drawable p0);
}
