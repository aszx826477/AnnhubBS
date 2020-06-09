// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build$VERSION;

public final class BitmapCompat
{
    static final BitmapCompat$BitmapImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 19) {
            IMPL = new BitmapCompat$KitKatBitmapCompatImpl();
        }
        else if (sdk_INT >= 18) {
            IMPL = new BitmapCompat$JbMr2BitmapCompatImpl();
        }
        else if (sdk_INT >= 12) {
            IMPL = new BitmapCompat$HcMr1BitmapCompatImpl();
        }
        else {
            IMPL = new BitmapCompat$BaseBitmapImpl();
        }
    }
    
    public static int getAllocationByteCount(final Bitmap bitmap) {
        return BitmapCompat.IMPL.getAllocationByteCount(bitmap);
    }
    
    public static boolean hasMipMap(final Bitmap bitmap) {
        return BitmapCompat.IMPL.hasMipMap(bitmap);
    }
    
    public static void setHasMipMap(final Bitmap bitmap, final boolean b) {
        BitmapCompat.IMPL.setHasMipMap(bitmap, b);
    }
}
