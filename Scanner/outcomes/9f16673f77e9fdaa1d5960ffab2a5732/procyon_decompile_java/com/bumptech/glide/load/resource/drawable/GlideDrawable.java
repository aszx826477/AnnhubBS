// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

public abstract class GlideDrawable extends Drawable implements Animatable
{
    public static final int LOOP_FOREVER = 255;
    public static final int LOOP_INTRINSIC;
    
    public abstract boolean isAnimated();
    
    public abstract void setLoopCount(final int p0);
}
