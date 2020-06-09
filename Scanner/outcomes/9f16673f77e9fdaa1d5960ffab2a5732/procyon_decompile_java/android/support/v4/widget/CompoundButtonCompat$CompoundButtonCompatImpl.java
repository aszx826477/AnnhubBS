// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

interface CompoundButtonCompat$CompoundButtonCompatImpl
{
    Drawable getButtonDrawable(final CompoundButton p0);
    
    ColorStateList getButtonTintList(final CompoundButton p0);
    
    PorterDuff$Mode getButtonTintMode(final CompoundButton p0);
    
    void setButtonTintList(final CompoundButton p0, final ColorStateList p1);
    
    void setButtonTintMode(final CompoundButton p0, final PorterDuff$Mode p1);
}
