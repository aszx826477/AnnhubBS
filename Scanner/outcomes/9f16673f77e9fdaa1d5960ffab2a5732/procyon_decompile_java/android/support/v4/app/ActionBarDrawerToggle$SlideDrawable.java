// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.support.v4.view.ViewCompat;
import android.graphics.Canvas;
import android.os.Build$VERSION;
import android.graphics.drawable.Drawable;
import android.graphics.Rect;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.InsetDrawable;

class ActionBarDrawerToggle$SlideDrawable extends InsetDrawable implements Drawable$Callback
{
    private final boolean mHasMirroring;
    private float mOffset;
    private float mPosition;
    private final Rect mTmpRect;
    final /* synthetic */ ActionBarDrawerToggle this$0;
    
    ActionBarDrawerToggle$SlideDrawable(final ActionBarDrawerToggle this$0, final Drawable drawable) {
        this.this$0 = this$0;
        boolean mHasMirroring = false;
        super(drawable, 0);
        if (Build$VERSION.SDK_INT > 18) {
            mHasMirroring = true;
        }
        this.mHasMirroring = mHasMirroring;
        this.mTmpRect = new Rect();
    }
    
    public void draw(final Canvas canvas) {
        this.copyBounds(this.mTmpRect);
        canvas.save();
        final int layoutDirection = ViewCompat.getLayoutDirection(this.this$0.mActivity.getWindow().getDecorView());
        int n = 1;
        final boolean b = layoutDirection == n;
        if (b) {
            n = -1;
        }
        final int width = this.mTmpRect.width();
        canvas.translate(-this.mOffset * width * this.mPosition * n, 0.0f);
        if (b && !this.mHasMirroring) {
            canvas.translate((float)width, 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        super.draw(canvas);
        canvas.restore();
    }
    
    public float getPosition() {
        return this.mPosition;
    }
    
    public void setOffset(final float mOffset) {
        this.mOffset = mOffset;
        this.invalidateSelf();
    }
    
    public void setPosition(final float mPosition) {
        this.mPosition = mPosition;
        this.invalidateSelf();
    }
}
