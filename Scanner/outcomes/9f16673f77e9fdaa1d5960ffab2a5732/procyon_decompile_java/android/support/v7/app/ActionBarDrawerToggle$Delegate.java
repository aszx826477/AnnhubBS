// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.graphics.drawable.Drawable;
import android.content.Context;

public interface ActionBarDrawerToggle$Delegate
{
    Context getActionBarThemedContext();
    
    Drawable getThemeUpIndicator();
    
    boolean isNavigationVisible();
    
    void setActionBarDescription(final int p0);
    
    void setActionBarUpIndicator(final Drawable p0, final int p1);
}
