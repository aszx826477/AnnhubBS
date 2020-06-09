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

class DrawableCompat$BaseDrawableImpl implements DrawableCompat$DrawableImpl
{
    public void applyTheme(final Drawable drawable, final Resources$Theme resources$Theme) {
    }
    
    public boolean canApplyTheme(final Drawable drawable) {
        return false;
    }
    
    public void clearColorFilter(final Drawable drawable) {
        drawable.clearColorFilter();
    }
    
    public int getAlpha(final Drawable drawable) {
        return 0;
    }
    
    public ColorFilter getColorFilter(final Drawable drawable) {
        return null;
    }
    
    public int getLayoutDirection(final Drawable drawable) {
        return 0;
    }
    
    public void inflate(final Drawable drawable, final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) {
        DrawableCompatBase.inflate(drawable, resources, xmlPullParser, set, resources$Theme);
    }
    
    public boolean isAutoMirrored(final Drawable drawable) {
        return false;
    }
    
    public void jumpToCurrentState(final Drawable drawable) {
    }
    
    public void setAutoMirrored(final Drawable drawable, final boolean b) {
    }
    
    public void setHotspot(final Drawable drawable, final float n, final float n2) {
    }
    
    public void setHotspotBounds(final Drawable drawable, final int n, final int n2, final int n3, final int n4) {
    }
    
    public boolean setLayoutDirection(final Drawable drawable, final int n) {
        return false;
    }
    
    public void setTint(final Drawable drawable, final int n) {
        DrawableCompatBase.setTint(drawable, n);
    }
    
    public void setTintList(final Drawable drawable, final ColorStateList list) {
        DrawableCompatBase.setTintList(drawable, list);
    }
    
    public void setTintMode(final Drawable drawable, final PorterDuff$Mode porterDuff$Mode) {
        DrawableCompatBase.setTintMode(drawable, porterDuff$Mode);
    }
    
    public Drawable wrap(final Drawable drawable) {
        return DrawableCompatBase.wrapForTinting(drawable);
    }
}
