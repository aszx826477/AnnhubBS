// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

class WindowInsetsCompat$WindowInsetsCompatApi20Impl extends WindowInsetsCompat$WindowInsetsCompatBaseImpl
{
    public WindowInsetsCompat consumeSystemWindowInsets(final Object o) {
        return new WindowInsetsCompat(WindowInsetsCompatApi20.consumeSystemWindowInsets(o));
    }
    
    public Object getSourceWindowInsets(final Object o) {
        return WindowInsetsCompatApi20.getSourceWindowInsets(o);
    }
    
    public int getSystemWindowInsetBottom(final Object o) {
        return WindowInsetsCompatApi20.getSystemWindowInsetBottom(o);
    }
    
    public int getSystemWindowInsetLeft(final Object o) {
        return WindowInsetsCompatApi20.getSystemWindowInsetLeft(o);
    }
    
    public int getSystemWindowInsetRight(final Object o) {
        return WindowInsetsCompatApi20.getSystemWindowInsetRight(o);
    }
    
    public int getSystemWindowInsetTop(final Object o) {
        return WindowInsetsCompatApi20.getSystemWindowInsetTop(o);
    }
    
    public boolean hasInsets(final Object o) {
        return WindowInsetsCompatApi20.hasInsets(o);
    }
    
    public boolean hasSystemWindowInsets(final Object o) {
        return WindowInsetsCompatApi20.hasSystemWindowInsets(o);
    }
    
    public boolean isRound(final Object o) {
        return WindowInsetsCompatApi20.isRound(o);
    }
    
    public WindowInsetsCompat replaceSystemWindowInsets(final Object o, final int n, final int n2, final int n3, final int n4) {
        return new WindowInsetsCompat(WindowInsetsCompatApi20.replaceSystemWindowInsets(o, n, n2, n3, n4));
    }
}
