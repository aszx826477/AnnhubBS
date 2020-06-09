// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.target;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$ConstantState;

class SquaringDrawable$State extends Drawable$ConstantState
{
    private final int side;
    private final Drawable$ConstantState wrapped;
    
    SquaringDrawable$State(final Drawable$ConstantState wrapped, final int side) {
        this.wrapped = wrapped;
        this.side = side;
    }
    
    SquaringDrawable$State(final SquaringDrawable$State squaringDrawable$State) {
        this(squaringDrawable$State.wrapped, squaringDrawable$State.side);
    }
    
    public int getChangingConfigurations() {
        return 0;
    }
    
    public Drawable newDrawable() {
        return this.newDrawable(null);
    }
    
    public Drawable newDrawable(final Resources resources) {
        return new SquaringDrawable(this, null, resources);
    }
}
