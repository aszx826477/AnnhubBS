// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.print;

import android.net.Uri;
import android.graphics.Bitmap;

class PrintHelper$PrintHelperImpl implements PrintHelper$PrintHelperVersionImpl
{
    private final PrintHelperKitkat mPrintHelper;
    
    protected PrintHelper$PrintHelperImpl(final PrintHelperKitkat mPrintHelper) {
        this.mPrintHelper = mPrintHelper;
    }
    
    public int getColorMode() {
        return this.mPrintHelper.getColorMode();
    }
    
    public int getOrientation() {
        return this.mPrintHelper.getOrientation();
    }
    
    public int getScaleMode() {
        return this.mPrintHelper.getScaleMode();
    }
    
    public void printBitmap(final String s, final Bitmap bitmap, final PrintHelper$OnPrintFinishCallback printHelper$OnPrintFinishCallback) {
        PrintHelperKitkat$OnPrintFinishCallback printHelperKitkat$OnPrintFinishCallback = null;
        if (printHelper$OnPrintFinishCallback != null) {
            printHelperKitkat$OnPrintFinishCallback = new PrintHelper$PrintHelperImpl$1(this, printHelper$OnPrintFinishCallback);
        }
        this.mPrintHelper.printBitmap(s, bitmap, printHelperKitkat$OnPrintFinishCallback);
    }
    
    public void printBitmap(final String s, final Uri uri, final PrintHelper$OnPrintFinishCallback printHelper$OnPrintFinishCallback) {
        PrintHelperKitkat$OnPrintFinishCallback printHelperKitkat$OnPrintFinishCallback = null;
        if (printHelper$OnPrintFinishCallback != null) {
            printHelperKitkat$OnPrintFinishCallback = new PrintHelper$PrintHelperImpl$2(this, printHelper$OnPrintFinishCallback);
        }
        this.mPrintHelper.printBitmap(s, uri, printHelperKitkat$OnPrintFinishCallback);
    }
    
    public void setColorMode(final int colorMode) {
        this.mPrintHelper.setColorMode(colorMode);
    }
    
    public void setOrientation(final int orientation) {
        this.mPrintHelper.setOrientation(orientation);
    }
    
    public void setScaleMode(final int scaleMode) {
        this.mPrintHelper.setScaleMode(scaleMode);
    }
}
