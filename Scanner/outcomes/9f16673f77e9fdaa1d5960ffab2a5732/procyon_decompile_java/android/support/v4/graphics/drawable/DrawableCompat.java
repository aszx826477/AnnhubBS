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
import android.os.Build$VERSION;

public final class DrawableCompat
{
    static final DrawableCompat$DrawableImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 23) {
            IMPL = new DrawableCompat$MDrawableImpl();
        }
        else if (sdk_INT >= 21) {
            IMPL = new DrawableCompat$LollipopDrawableImpl();
        }
        else if (sdk_INT >= 19) {
            IMPL = new DrawableCompat$KitKatDrawableImpl();
        }
        else if (sdk_INT >= 17) {
            IMPL = new DrawableCompat$JellybeanMr1DrawableImpl();
        }
        else if (sdk_INT >= 11) {
            IMPL = new DrawableCompat$HoneycombDrawableImpl();
        }
        else {
            IMPL = new DrawableCompat$BaseDrawableImpl();
        }
    }
    
    public static void applyTheme(final Drawable drawable, final Resources$Theme resources$Theme) {
        DrawableCompat.IMPL.applyTheme(drawable, resources$Theme);
    }
    
    public static boolean canApplyTheme(final Drawable drawable) {
        return DrawableCompat.IMPL.canApplyTheme(drawable);
    }
    
    public static void clearColorFilter(final Drawable drawable) {
        DrawableCompat.IMPL.clearColorFilter(drawable);
    }
    
    public static int getAlpha(final Drawable drawable) {
        return DrawableCompat.IMPL.getAlpha(drawable);
    }
    
    public static ColorFilter getColorFilter(final Drawable drawable) {
        return DrawableCompat.IMPL.getColorFilter(drawable);
    }
    
    public static int getLayoutDirection(final Drawable drawable) {
        return DrawableCompat.IMPL.getLayoutDirection(drawable);
    }
    
    public static void inflate(final Drawable drawable, final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) {
        DrawableCompat.IMPL.inflate(drawable, resources, xmlPullParser, set, resources$Theme);
    }
    
    public static boolean isAutoMirrored(final Drawable drawable) {
        return DrawableCompat.IMPL.isAutoMirrored(drawable);
    }
    
    public static void jumpToCurrentState(final Drawable drawable) {
        DrawableCompat.IMPL.jumpToCurrentState(drawable);
    }
    
    public static void setAutoMirrored(final Drawable drawable, final boolean b) {
        DrawableCompat.IMPL.setAutoMirrored(drawable, b);
    }
    
    public static void setHotspot(final Drawable drawable, final float n, final float n2) {
        DrawableCompat.IMPL.setHotspot(drawable, n, n2);
    }
    
    public static void setHotspotBounds(final Drawable drawable, final int n, final int n2, final int n3, final int n4) {
        DrawableCompat.IMPL.setHotspotBounds(drawable, n, n2, n3, n4);
    }
    
    public static boolean setLayoutDirection(final Drawable drawable, final int n) {
        return DrawableCompat.IMPL.setLayoutDirection(drawable, n);
    }
    
    public static void setTint(final Drawable drawable, final int n) {
        DrawableCompat.IMPL.setTint(drawable, n);
    }
    
    public static void setTintList(final Drawable drawable, final ColorStateList list) {
        DrawableCompat.IMPL.setTintList(drawable, list);
    }
    
    public static void setTintMode(final Drawable drawable, final PorterDuff$Mode porterDuff$Mode) {
        DrawableCompat.IMPL.setTintMode(drawable, porterDuff$Mode);
    }
    
    public static Drawable unwrap(final Drawable drawable) {
        if (drawable instanceof DrawableWrapper) {
            return ((DrawableWrapper)drawable).getWrappedDrawable();
        }
        return drawable;
    }
    
    public static Drawable wrap(final Drawable drawable) {
        return DrawableCompat.IMPL.wrap(drawable);
    }
}
