// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Resource;

public abstract class DrawableResource implements Resource
{
    protected final Drawable drawable;
    
    public DrawableResource(final Drawable drawable) {
        if (drawable != null) {
            this.drawable = drawable;
            return;
        }
        throw new NullPointerException("Drawable must not be null!");
    }
    
    public final Drawable get() {
        return this.drawable.getConstantState().newDrawable();
    }
}
