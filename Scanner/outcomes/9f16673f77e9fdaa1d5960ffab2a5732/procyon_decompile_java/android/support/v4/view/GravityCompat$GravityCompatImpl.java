// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.graphics.Rect;

interface GravityCompat$GravityCompatImpl
{
    void apply(final int p0, final int p1, final int p2, final Rect p3, final int p4, final int p5, final Rect p6, final int p7);
    
    void apply(final int p0, final int p1, final int p2, final Rect p3, final Rect p4, final int p5);
    
    void applyDisplay(final int p0, final Rect p1, final Rect p2, final int p3);
    
    int getAbsoluteGravity(final int p0, final int p1);
}
