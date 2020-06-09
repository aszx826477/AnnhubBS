// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.view.animation.Transformation;
import android.view.animation.Animation;

class MaterialProgressDrawable$1 extends Animation
{
    final /* synthetic */ MaterialProgressDrawable this$0;
    final /* synthetic */ MaterialProgressDrawable$Ring val$ring;
    
    MaterialProgressDrawable$1(final MaterialProgressDrawable this$0, final MaterialProgressDrawable$Ring val$ring) {
        this.this$0 = this$0;
        this.val$ring = val$ring;
    }
    
    public void applyTransformation(final float n, final Transformation transformation) {
        if (this.this$0.mFinishing) {
            this.this$0.applyFinishTranslation(n, this.val$ring);
        }
        else {
            final float minProgressArc = this.this$0.getMinProgressArc(this.val$ring);
            final float startingEndTrim = this.val$ring.getStartingEndTrim();
            final float startingStartTrim = this.val$ring.getStartingStartTrim();
            final float startingRotation = this.val$ring.getStartingRotation();
            this.this$0.updateRingColor(n, this.val$ring);
            final float n2 = 0.8f;
            final float n3 = 0.5f;
            if (n <= n3) {
                this.val$ring.setStartTrim((n2 - minProgressArc) * MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation(n / n3) + startingStartTrim);
            }
            if (n > n3) {
                this.val$ring.setEndTrim(MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation((n - n3) / n3) * (n2 - minProgressArc) + startingEndTrim);
            }
            this.val$ring.setRotation(0.25f * n + startingRotation);
            this.this$0.setRotation(216.0f * n + this.this$0.mRotationCount / 5.0f * 1080.0f);
        }
    }
}
