// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Animatable2$AnimationCallback;

public abstract class Animatable2Compat$AnimationCallback
{
    Animatable2$AnimationCallback mPlatformCallback;
    
    Animatable2$AnimationCallback getPlatformCallback() {
        if (this.mPlatformCallback == null) {
            this.mPlatformCallback = new Animatable2Compat$AnimationCallback$1(this);
        }
        return this.mPlatformCallback;
    }
    
    public void onAnimationEnd(final Drawable drawable) {
    }
    
    public void onAnimationStart(final Drawable drawable) {
    }
}
