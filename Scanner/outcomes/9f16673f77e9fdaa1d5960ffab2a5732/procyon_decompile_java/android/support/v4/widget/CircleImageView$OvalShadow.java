// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Shader;
import android.graphics.Shader$TileMode;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.drawable.shapes.OvalShape;

class CircleImageView$OvalShadow extends OvalShape
{
    private RadialGradient mRadialGradient;
    private Paint mShadowPaint;
    final /* synthetic */ CircleImageView this$0;
    
    CircleImageView$OvalShadow(final CircleImageView this$0, final int mShadowRadius) {
        this.this$0 = this$0;
        this.mShadowPaint = new Paint();
        this$0.mShadowRadius = mShadowRadius;
        this.updateRadialGradient((int)this.rect().width());
    }
    
    private void updateRadialGradient(final int n) {
        final float n2 = n / 2;
        final float n3 = n / 2;
        final float n4 = this.this$0.mShadowRadius;
        final int[] array2;
        final int[] array = array2 = new int[2];
        array2[0] = 1023410176;
        array2[1] = 0;
        this.mRadialGradient = new RadialGradient(n2, n3, n4, array, (float[])null, Shader$TileMode.CLAMP);
        this.mShadowPaint.setShader((Shader)this.mRadialGradient);
    }
    
    public void draw(final Canvas canvas, final Paint paint) {
        final int width = this.this$0.getWidth();
        final int height = this.this$0.getHeight();
        canvas.drawCircle((float)(width / 2), (float)(height / 2), (float)(width / 2), this.mShadowPaint);
        canvas.drawCircle((float)(width / 2), (float)(height / 2), (float)(width / 2 - this.this$0.mShadowRadius), paint);
    }
    
    protected void onResize(final float n, final float n2) {
        super.onResize(n, n2);
        this.updateRadialGradient((int)n);
    }
}
