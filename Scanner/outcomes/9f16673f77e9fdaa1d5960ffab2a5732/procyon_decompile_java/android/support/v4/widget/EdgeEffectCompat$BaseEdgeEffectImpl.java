// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;

class EdgeEffectCompat$BaseEdgeEffectImpl implements EdgeEffectCompat$EdgeEffectImpl
{
    public boolean draw(final Object o, final Canvas canvas) {
        return false;
    }
    
    public void finish(final Object o) {
    }
    
    public boolean isFinished(final Object o) {
        return true;
    }
    
    public Object newEdgeEffect(final Context context) {
        return null;
    }
    
    public boolean onAbsorb(final Object o, final int n) {
        return false;
    }
    
    public boolean onPull(final Object o, final float n) {
        return false;
    }
    
    public boolean onPull(final Object o, final float n, final float n2) {
        return false;
    }
    
    public boolean onRelease(final Object o) {
        return false;
    }
    
    public void setSize(final Object o, final int n, final int n2) {
    }
}
