// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics.drawable;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.content.res.Resources$Theme;
import android.graphics.drawable.Drawable;

interface DrawableCompat$DrawableImpl
{
    void applyTheme(final Drawable p0, final Resources$Theme p1);
    
    boolean canApplyTheme(final Drawable p0);
    
    void clearColorFilter(final Drawable p0);
    
    int getAlpha(final Drawable p0);
    
    ColorFilter getColorFilter(final Drawable p0);
    
    int getLayoutDirection(final Drawable p0);
    
    void inflate(final Drawable p0, final Resources p1, final XmlPullParser p2, final AttributeSet p3, final Resources$Theme p4);
    
    boolean isAutoMirrored(final Drawable p0);
    
    void jumpToCurrentState(final Drawable p0);
    
    void setAutoMirrored(final Drawable p0, final boolean p1);
    
    void setHotspot(final Drawable p0, final float p1, final float p2);
    
    void setHotspotBounds(final Drawable p0, final int p1, final int p2, final int p3, final int p4);
    
    boolean setLayoutDirection(final Drawable p0, final int p1);
    
    void setTint(final Drawable p0, final int p1);
    
    void setTintList(final Drawable p0, final ColorStateList p1);
    
    void setTintMode(final Drawable p0, final PorterDuff$Mode p1);
    
    Drawable wrap(final Drawable p0);
}
