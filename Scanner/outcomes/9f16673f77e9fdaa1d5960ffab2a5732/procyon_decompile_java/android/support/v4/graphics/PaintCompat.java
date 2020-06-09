// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics;

import android.os.Build$VERSION;
import android.graphics.Paint;

public final class PaintCompat
{
    public static boolean hasGlyph(final Paint paint, final String s) {
        if (Build$VERSION.SDK_INT >= 23) {
            return PaintCompatApi23.hasGlyph(paint, s);
        }
        return PaintCompatGingerbread.hasGlyph(paint, s);
    }
}
