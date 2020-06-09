// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content.res;

import android.graphics.drawable.Drawable;
import android.content.res.ColorStateList;
import android.os.Build$VERSION;
import android.content.res.Resources$Theme;
import android.content.res.Resources;

public final class ResourcesCompat
{
    public static int getColor(final Resources resources, final int n, final Resources$Theme resources$Theme) {
        if (Build$VERSION.SDK_INT >= 23) {
            return ResourcesCompatApi23.getColor(resources, n, resources$Theme);
        }
        return resources.getColor(n);
    }
    
    public static ColorStateList getColorStateList(final Resources resources, final int n, final Resources$Theme resources$Theme) {
        if (Build$VERSION.SDK_INT >= 23) {
            return ResourcesCompatApi23.getColorStateList(resources, n, resources$Theme);
        }
        return resources.getColorStateList(n);
    }
    
    public static Drawable getDrawable(final Resources resources, final int n, final Resources$Theme resources$Theme) {
        if (Build$VERSION.SDK_INT >= 21) {
            return ResourcesCompatApi21.getDrawable(resources, n, resources$Theme);
        }
        return resources.getDrawable(n);
    }
    
    public static Drawable getDrawableForDensity(final Resources resources, final int n, final int n2, final Resources$Theme resources$Theme) {
        if (Build$VERSION.SDK_INT >= 21) {
            return ResourcesCompatApi21.getDrawableForDensity(resources, n, n2, resources$Theme);
        }
        if (Build$VERSION.SDK_INT >= 15) {
            return ResourcesCompatIcsMr1.getDrawableForDensity(resources, n, n2);
        }
        return resources.getDrawable(n);
    }
}
