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

class DrawableCompat$LollipopDrawableImpl extends DrawableCompat$KitKatDrawableImpl
{
    public void applyTheme(final Drawable drawable, final Resources$Theme resources$Theme) {
        DrawableCompatLollipop.applyTheme(drawable, resources$Theme);
    }
    
    public boolean canApplyTheme(final Drawable drawable) {
        return DrawableCompatLollipop.canApplyTheme(drawable);
    }
    
    public void clearColorFilter(final Drawable drawable) {
        DrawableCompatLollipop.clearColorFilter(drawable);
    }
    
    public ColorFilter getColorFilter(final Drawable drawable) {
        return DrawableCompatLollipop.getColorFilter(drawable);
    }
    
    public void inflate(final Drawable drawable, final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) {
        DrawableCompatLollipop.inflate(drawable, resources, xmlPullParser, set, resources$Theme);
    }
    
    public void setHotspot(final Drawable drawable, final float n, final float n2) {
        DrawableCompatLollipop.setHotspot(drawable, n, n2);
    }
    
    public void setHotspotBounds(final Drawable drawable, final int n, final int n2, final int n3, final int n4) {
        DrawableCompatLollipop.setHotspotBounds(drawable, n, n2, n3, n4);
    }
    
    public void setTint(final Drawable drawable, final int n) {
        DrawableCompatLollipop.setTint(drawable, n);
    }
    
    public void setTintList(final Drawable drawable, final ColorStateList list) {
        DrawableCompatLollipop.setTintList(drawable, list);
    }
    
    public void setTintMode(final Drawable drawable, final PorterDuff$Mode porterDuff$Mode) {
        DrawableCompatLollipop.setTintMode(drawable, porterDuff$Mode);
    }
    
    public Drawable wrap(final Drawable drawable) {
        return DrawableCompatLollipop.wrapForTinting(drawable);
    }
}
