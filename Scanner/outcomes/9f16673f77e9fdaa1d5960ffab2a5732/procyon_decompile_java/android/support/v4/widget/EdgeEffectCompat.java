// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.Canvas;
import android.content.Context;
import android.os.Build$VERSION;

public final class EdgeEffectCompat
{
    private static final EdgeEffectCompat$EdgeEffectImpl IMPL;
    private Object mEdgeEffect;
    
    static {
        if (Build$VERSION.SDK_INT >= 21) {
            IMPL = new EdgeEffectCompat$EdgeEffectLollipopImpl();
        }
        else if (Build$VERSION.SDK_INT >= 14) {
            IMPL = new EdgeEffectCompat$EdgeEffectIcsImpl();
        }
        else {
            IMPL = new EdgeEffectCompat$BaseEdgeEffectImpl();
        }
    }
    
    public EdgeEffectCompat(final Context context) {
        this.mEdgeEffect = EdgeEffectCompat.IMPL.newEdgeEffect(context);
    }
    
    public boolean draw(final Canvas canvas) {
        return EdgeEffectCompat.IMPL.draw(this.mEdgeEffect, canvas);
    }
    
    public void finish() {
        EdgeEffectCompat.IMPL.finish(this.mEdgeEffect);
    }
    
    public boolean isFinished() {
        return EdgeEffectCompat.IMPL.isFinished(this.mEdgeEffect);
    }
    
    public boolean onAbsorb(final int n) {
        return EdgeEffectCompat.IMPL.onAbsorb(this.mEdgeEffect, n);
    }
    
    public boolean onPull(final float n) {
        return EdgeEffectCompat.IMPL.onPull(this.mEdgeEffect, n);
    }
    
    public boolean onPull(final float n, final float n2) {
        return EdgeEffectCompat.IMPL.onPull(this.mEdgeEffect, n, n2);
    }
    
    public boolean onRelease() {
        return EdgeEffectCompat.IMPL.onRelease(this.mEdgeEffect);
    }
    
    public void setSize(final int n, final int n2) {
        EdgeEffectCompat.IMPL.setSize(this.mEdgeEffect, n, n2);
    }
}
