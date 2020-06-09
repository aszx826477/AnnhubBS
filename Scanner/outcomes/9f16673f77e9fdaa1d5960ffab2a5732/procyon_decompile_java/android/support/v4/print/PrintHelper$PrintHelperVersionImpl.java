// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.print;

import android.net.Uri;
import android.graphics.Bitmap;

interface PrintHelper$PrintHelperVersionImpl
{
    int getColorMode();
    
    int getOrientation();
    
    int getScaleMode();
    
    void printBitmap(final String p0, final Bitmap p1, final PrintHelper$OnPrintFinishCallback p2);
    
    void printBitmap(final String p0, final Uri p1, final PrintHelper$OnPrintFinishCallback p2);
    
    void setColorMode(final int p0);
    
    void setOrientation(final int p0);
    
    void setScaleMode(final int p0);
}
