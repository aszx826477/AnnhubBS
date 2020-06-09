// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.print;

import android.print.PrintAttributes$MediaSize;
import android.print.PrintManager;
import android.print.PrintAttributes$Builder;
import android.print.PrintAttributes$Margins;
import java.io.InputStream;
import java.io.IOException;
import android.util.Log;
import android.graphics.Rect;
import android.graphics.BitmapFactory;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Bitmap$Config;
import android.net.Uri;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.BitmapFactory$Options;
import android.content.Context;
import android.print.PrintDocumentAdapter$WriteResultCallback;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintDocumentInfo$Builder;
import android.os.Bundle;
import android.print.PrintDocumentAdapter$LayoutResultCallback;
import android.os.CancellationSignal;
import android.graphics.Bitmap;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;

class PrintHelperKitkat$1 extends PrintDocumentAdapter
{
    private PrintAttributes mAttributes;
    final /* synthetic */ PrintHelperKitkat this$0;
    final /* synthetic */ Bitmap val$bitmap;
    final /* synthetic */ PrintHelperKitkat$OnPrintFinishCallback val$callback;
    final /* synthetic */ int val$fittingMode;
    final /* synthetic */ String val$jobName;
    
    PrintHelperKitkat$1(final PrintHelperKitkat this$0, final String val$jobName, final int val$fittingMode, final Bitmap val$bitmap, final PrintHelperKitkat$OnPrintFinishCallback val$callback) {
        this.this$0 = this$0;
        this.val$jobName = val$jobName;
        this.val$fittingMode = val$fittingMode;
        this.val$bitmap = val$bitmap;
        this.val$callback = val$callback;
    }
    
    public void onFinish() {
        final PrintHelperKitkat$OnPrintFinishCallback val$callback = this.val$callback;
        if (val$callback != null) {
            val$callback.onFinish();
        }
    }
    
    public void onLayout(final PrintAttributes printAttributes, final PrintAttributes mAttributes, final CancellationSignal cancellationSignal, final PrintDocumentAdapter$LayoutResultCallback printDocumentAdapter$LayoutResultCallback, final Bundle bundle) {
        this.mAttributes = mAttributes;
        final PrintDocumentInfo$Builder printDocumentInfo$Builder = new PrintDocumentInfo$Builder(this.val$jobName);
        final int n = 1;
        printDocumentAdapter$LayoutResultCallback.onLayoutFinished(printDocumentInfo$Builder.setContentType(n).setPageCount(n).build(), (boolean)((n ^ (mAttributes.equals((Object)printAttributes) ? 1 : 0)) != 0x0));
    }
    
    public void onWrite(final PageRange[] array, final ParcelFileDescriptor parcelFileDescriptor, final CancellationSignal cancellationSignal, final PrintDocumentAdapter$WriteResultCallback printDocumentAdapter$WriteResultCallback) {
        this.this$0.writeBitmap(this.mAttributes, this.val$fittingMode, this.val$bitmap, parcelFileDescriptor, cancellationSignal, printDocumentAdapter$WriteResultCallback);
    }
}
