// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;

class MaterialProgressDrawable$2 implements Animation$AnimationListener
{
    final /* synthetic */ MaterialProgressDrawable this$0;
    final /* synthetic */ MaterialProgressDrawable$Ring val$ring;
    
    MaterialProgressDrawable$2(final MaterialProgressDrawable this$0, final MaterialProgressDrawable$Ring val$ring) {
        this.this$0 = this$0;
        this.val$ring = val$ring;
    }
    
    public void onAnimationEnd(final Animation animation) {
    }
    
    public void onAnimationRepeat(final Animation animation) {
        this.val$ring.storeOriginals();
        this.val$ring.goToNextColor();
        final MaterialProgressDrawable$Ring val$ring = this.val$ring;
        val$ring.setStartTrim(val$ring.getEndTrim());
        if (this.this$0.mFinishing) {
            this.this$0.mFinishing = false;
            animation.setDuration(1332L);
            this.val$ring.setShowArrow(false);
        }
        else {
            final MaterialProgressDrawable this$0 = this.this$0;
            this$0.mRotationCount = (this$0.mRotationCount + 1.0f) % 5.0f;
        }
    }
    
    public void onAnimationStart(final Animation animation) {
        this.this$0.mRotationCount = 0.0f;
    }
}
