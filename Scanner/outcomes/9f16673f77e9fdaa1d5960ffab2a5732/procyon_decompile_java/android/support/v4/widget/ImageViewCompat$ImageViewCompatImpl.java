// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.widget.ImageView;

interface ImageViewCompat$ImageViewCompatImpl
{
    ColorStateList getImageTintList(final ImageView p0);
    
    PorterDuff$Mode getImageTintMode(final ImageView p0);
    
    void setImageTintList(final ImageView p0, final ColorStateList p1);
    
    void setImageTintMode(final ImageView p0, final PorterDuff$Mode p1);
}
