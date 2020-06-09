// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics;

import android.graphics.Bitmap;

class BitmapCompat$BaseBitmapImpl implements BitmapCompat$BitmapImpl
{
    public int getAllocationByteCount(final Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }
    
    public boolean hasMipMap(final Bitmap bitmap) {
        return false;
    }
    
    public void setHasMipMap(final Bitmap bitmap, final boolean b) {
    }
}
