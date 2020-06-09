// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;

public interface TintableImageSourceView
{
    ColorStateList getSupportImageTintList();
    
    PorterDuff$Mode getSupportImageTintMode();
    
    void setSupportImageTintList(final ColorStateList p0);
    
    void setSupportImageTintMode(final PorterDuff$Mode p0);
}
