// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Animatable2$AnimationCallback;

class Animatable2Compat$AnimationCallback$1 extends Animatable2$AnimationCallback
{
    final /* synthetic */ Animatable2Compat$AnimationCallback this$0;
    
    Animatable2Compat$AnimationCallback$1(final Animatable2Compat$AnimationCallback this$0) {
        this.this$0 = this$0;
    }
    
    public void onAnimationEnd(final Drawable drawable) {
        this.this$0.onAnimationEnd(drawable);
    }
    
    public void onAnimationStart(final Drawable drawable) {
        this.this$0.onAnimationStart(drawable);
    }
}
