// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;

public interface TintableCompoundButton
{
    ColorStateList getSupportButtonTintList();
    
    PorterDuff$Mode getSupportButtonTintMode();
    
    void setSupportButtonTintList(final ColorStateList p0);
    
    void setSupportButtonTintMode(final PorterDuff$Mode p0);
}
