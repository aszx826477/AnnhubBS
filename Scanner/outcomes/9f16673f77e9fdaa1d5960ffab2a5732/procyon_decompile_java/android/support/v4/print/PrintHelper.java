// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.print;

import android.net.Uri;
import android.graphics.Bitmap;
import android.os.Build$VERSION;
import android.content.Context;

public final class PrintHelper
{
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    PrintHelper$PrintHelperVersionImpl mImpl;
    
    public PrintHelper(final Context context) {
        if (systemSupportsPrint()) {
            if (Build$VERSION.SDK_INT >= 24) {
                this.mImpl = new PrintHelper$PrintHelperApi24Impl(context);
            }
            else if (Build$VERSION.SDK_INT >= 23) {
                this.mImpl = new PrintHelper$PrintHelperApi23Impl(context);
            }
            else if (Build$VERSION.SDK_INT >= 20) {
                this.mImpl = new PrintHelper$PrintHelperApi20Impl(context);
            }
            else {
                this.mImpl = new PrintHelper$PrintHelperKitkatImpl(context);
            }
        }
        else {
            this.mImpl = new PrintHelper$PrintHelperStubImpl(null);
        }
    }
    
    public static boolean systemSupportsPrint() {
        return Build$VERSION.SDK_INT >= 19;
    }
    
    public int getColorMode() {
        return this.mImpl.getColorMode();
    }
    
    public int getOrientation() {
        return this.mImpl.getOrientation();
    }
    
    public int getScaleMode() {
        return this.mImpl.getScaleMode();
    }
    
    public void printBitmap(final String s, final Bitmap bitmap) {
        this.mImpl.printBitmap(s, bitmap, null);
    }
    
    public void printBitmap(final String s, final Bitmap bitmap, final PrintHelper$OnPrintFinishCallback printHelper$OnPrintFinishCallback) {
        this.mImpl.printBitmap(s, bitmap, printHelper$OnPrintFinishCallback);
    }
    
    public void printBitmap(final String s, final Uri uri) {
        this.mImpl.printBitmap(s, uri, null);
    }
    
    public void printBitmap(final String s, final Uri uri, final PrintHelper$OnPrintFinishCallback printHelper$OnPrintFinishCallback) {
        this.mImpl.printBitmap(s, uri, printHelper$OnPrintFinishCallback);
    }
    
    public void setColorMode(final int colorMode) {
        this.mImpl.setColorMode(colorMode);
    }
    
    public void setOrientation(final int orientation) {
        this.mImpl.setOrientation(orientation);
    }
    
    public void setScaleMode(final int scaleMode) {
        this.mImpl.setScaleMode(scaleMode);
    }
}
