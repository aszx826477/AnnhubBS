// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.graphics.Rect;

class WindowInsetsCompat$WindowInsetsCompatApi21Impl extends WindowInsetsCompat$WindowInsetsCompatApi20Impl
{
    public WindowInsetsCompat consumeStableInsets(final Object o) {
        return new WindowInsetsCompat(WindowInsetsCompatApi21.consumeStableInsets(o));
    }
    
    public int getStableInsetBottom(final Object o) {
        return WindowInsetsCompatApi21.getStableInsetBottom(o);
    }
    
    public int getStableInsetLeft(final Object o) {
        return WindowInsetsCompatApi21.getStableInsetLeft(o);
    }
    
    public int getStableInsetRight(final Object o) {
        return WindowInsetsCompatApi21.getStableInsetRight(o);
    }
    
    public int getStableInsetTop(final Object o) {
        return WindowInsetsCompatApi21.getStableInsetTop(o);
    }
    
    public boolean hasStableInsets(final Object o) {
        return WindowInsetsCompatApi21.hasStableInsets(o);
    }
    
    public boolean isConsumed(final Object o) {
        return WindowInsetsCompatApi21.isConsumed(o);
    }
    
    public WindowInsetsCompat replaceSystemWindowInsets(final Object o, final Rect rect) {
        return new WindowInsetsCompat(WindowInsetsCompatApi21.replaceSystemWindowInsets(o, rect));
    }
}
