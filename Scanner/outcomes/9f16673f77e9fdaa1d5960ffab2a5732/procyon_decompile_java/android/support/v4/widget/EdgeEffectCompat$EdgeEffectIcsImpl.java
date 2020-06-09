// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;

class EdgeEffectCompat$EdgeEffectIcsImpl implements EdgeEffectCompat$EdgeEffectImpl
{
    public boolean draw(final Object o, final Canvas canvas) {
        return EdgeEffectCompatIcs.draw(o, canvas);
    }
    
    public void finish(final Object o) {
        EdgeEffectCompatIcs.finish(o);
    }
    
    public boolean isFinished(final Object o) {
        return EdgeEffectCompatIcs.isFinished(o);
    }
    
    public Object newEdgeEffect(final Context context) {
        return EdgeEffectCompatIcs.newEdgeEffect(context);
    }
    
    public boolean onAbsorb(final Object o, final int n) {
        return EdgeEffectCompatIcs.onAbsorb(o, n);
    }
    
    public boolean onPull(final Object o, final float n) {
        return EdgeEffectCompatIcs.onPull(o, n);
    }
    
    public boolean onPull(final Object o, final float n, final float n2) {
        return EdgeEffectCompatIcs.onPull(o, n);
    }
    
    public boolean onRelease(final Object o) {
        return EdgeEffectCompatIcs.onRelease(o);
    }
    
    public void setSize(final Object o, final int n, final int n2) {
        EdgeEffectCompatIcs.setSize(o, n, n2);
    }
}
