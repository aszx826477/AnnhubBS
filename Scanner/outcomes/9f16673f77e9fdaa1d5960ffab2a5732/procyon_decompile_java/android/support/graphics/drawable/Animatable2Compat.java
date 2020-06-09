// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.graphics.drawable.Animatable;

public interface Animatable2Compat extends Animatable
{
    void clearAnimationCallbacks();
    
    void registerAnimationCallback(final Animatable2Compat$AnimationCallback p0);
    
    boolean unregisterAnimationCallback(final Animatable2Compat$AnimationCallback p0);
}
