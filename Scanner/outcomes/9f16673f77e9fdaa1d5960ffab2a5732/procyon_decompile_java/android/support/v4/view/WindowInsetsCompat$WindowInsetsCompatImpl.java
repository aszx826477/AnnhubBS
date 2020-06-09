// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.graphics.Rect;

interface WindowInsetsCompat$WindowInsetsCompatImpl
{
    WindowInsetsCompat consumeStableInsets(final Object p0);
    
    WindowInsetsCompat consumeSystemWindowInsets(final Object p0);
    
    Object getSourceWindowInsets(final Object p0);
    
    int getStableInsetBottom(final Object p0);
    
    int getStableInsetLeft(final Object p0);
    
    int getStableInsetRight(final Object p0);
    
    int getStableInsetTop(final Object p0);
    
    int getSystemWindowInsetBottom(final Object p0);
    
    int getSystemWindowInsetLeft(final Object p0);
    
    int getSystemWindowInsetRight(final Object p0);
    
    int getSystemWindowInsetTop(final Object p0);
    
    boolean hasInsets(final Object p0);
    
    boolean hasStableInsets(final Object p0);
    
    boolean hasSystemWindowInsets(final Object p0);
    
    boolean isConsumed(final Object p0);
    
    boolean isRound(final Object p0);
    
    WindowInsetsCompat replaceSystemWindowInsets(final Object p0, final int p1, final int p2, final int p3, final int p4);
    
    WindowInsetsCompat replaceSystemWindowInsets(final Object p0, final Rect p1);
}
