// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.print;

import android.net.Uri;
import android.graphics.Bitmap;

final class PrintHelper$PrintHelperStubImpl implements PrintHelper$PrintHelperVersionImpl
{
    int mColorMode;
    int mOrientation;
    int mScaleMode;
    
    private PrintHelper$PrintHelperStubImpl() {
        final int n = 2;
        this.mScaleMode = n;
        this.mColorMode = n;
        this.mOrientation = 1;
    }
    
    public int getColorMode() {
        return this.mColorMode;
    }
    
    public int getOrientation() {
        return this.mOrientation;
    }
    
    public int getScaleMode() {
        return this.mScaleMode;
    }
    
    public void printBitmap(final String s, final Bitmap bitmap, final PrintHelper$OnPrintFinishCallback printHelper$OnPrintFinishCallback) {
    }
    
    public void printBitmap(final String s, final Uri uri, final PrintHelper$OnPrintFinishCallback printHelper$OnPrintFinishCallback) {
    }
    
    public void setColorMode(final int mColorMode) {
        this.mColorMode = mColorMode;
    }
    
    public void setOrientation(final int mOrientation) {
        this.mOrientation = mOrientation;
    }
    
    public void setScaleMode(final int mScaleMode) {
        this.mScaleMode = mScaleMode;
    }
}
