// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import java.util.Collection;
import android.graphics.drawable.Drawable;
import android.animation.Animator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable$Callback;
import android.content.Context;
import android.support.v4.util.ArrayMap;
import java.util.ArrayList;
import android.animation.AnimatorSet;
import android.graphics.drawable.Drawable$ConstantState;

class AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState extends Drawable$ConstantState
{
    AnimatorSet mAnimatorSet;
    private ArrayList mAnimators;
    int mChangingConfigurations;
    ArrayMap mTargetNameMap;
    VectorDrawableCompat mVectorDrawable;
    
    public AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState(final Context context, final AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState, final Drawable$Callback callback, final Resources resources) {
        if (animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState != null) {
            this.mChangingConfigurations = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mChangingConfigurations;
            final VectorDrawableCompat mVectorDrawable = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mVectorDrawable;
            if (mVectorDrawable != null) {
                final Drawable$ConstantState constantState = mVectorDrawable.getConstantState();
                if (resources != null) {
                    this.mVectorDrawable = (VectorDrawableCompat)constantState.newDrawable(resources);
                }
                else {
                    this.mVectorDrawable = (VectorDrawableCompat)constantState.newDrawable();
                }
                (this.mVectorDrawable = (VectorDrawableCompat)this.mVectorDrawable.mutate()).setCallback(callback);
                this.mVectorDrawable.setBounds(animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mVectorDrawable.getBounds());
                this.mVectorDrawable.setAllowCaching(false);
            }
            final ArrayList mAnimators = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mAnimators;
            if (mAnimators != null) {
                final int size = mAnimators.size();
                this.mAnimators = new ArrayList(size);
                this.mTargetNameMap = new ArrayMap(size);
                for (int i = 0; i < size; ++i) {
                    final Animator animator = animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mAnimators.get(i);
                    final Animator clone = animator.clone();
                    final String s = (String)animatedVectorDrawableCompat$AnimatedVectorDrawableCompatState.mTargetNameMap.get(animator);
                    clone.setTarget(this.mVectorDrawable.getTargetByName(s));
                    this.mAnimators.add(clone);
                    this.mTargetNameMap.put(clone, s);
                }
                this.setupAnimatorSet();
            }
        }
    }
    
    public int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }
    
    public Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }
    
    public Drawable newDrawable(final Resources resources) {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }
    
    public void setupAnimatorSet() {
        if (this.mAnimatorSet == null) {
            this.mAnimatorSet = new AnimatorSet();
        }
        this.mAnimatorSet.playTogether((Collection)this.mAnimators);
    }
}
