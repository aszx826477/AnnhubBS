// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;

interface EdgeEffectCompat$EdgeEffectImpl
{
    boolean draw(final Object p0, final Canvas p1);
    
    void finish(final Object p0);
    
    boolean isFinished(final Object p0);
    
    Object newEdgeEffect(final Context p0);
    
    boolean onAbsorb(final Object p0, final int p1);
    
    boolean onPull(final Object p0, final float p1);
    
    boolean onPull(final Object p0, final float p1, final float p2);
    
    boolean onRelease(final Object p0);
    
    void setSize(final Object p0, final int p1, final int p2);
}
