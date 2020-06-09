// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;

public interface TintableBackgroundView
{
    ColorStateList getSupportBackgroundTintList();
    
    PorterDuff$Mode getSupportBackgroundTintMode();
    
    void setSupportBackgroundTintList(final ColorStateList p0);
    
    void setSupportBackgroundTintMode(final PorterDuff$Mode p0);
}
