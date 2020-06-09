// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.print;

import android.print.PrintDocumentAdapter;
import android.print.PrintAttributes$MediaSize;
import android.print.PrintManager;
import android.print.PrintAttributes$Builder;
import android.print.PrintAttributes$Margins;
import java.io.InputStream;
import android.graphics.Rect;
import android.graphics.BitmapFactory;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.Canvas;
import android.graphics.Bitmap$Config;
import android.net.Uri;
import android.graphics.BitmapFactory$Options;
import android.content.Context;
import android.util.Log;
import android.print.PageRange;
import android.graphics.Matrix;
import android.graphics.pdf.PdfDocument$Page;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import android.graphics.Paint;
import android.graphics.RectF;
import android.print.pdf.PrintedPdfDocument;
import android.print.PrintDocumentAdapter$WriteResultCallback;
import android.os.ParcelFileDescriptor;
import android.os.CancellationSignal;
import android.graphics.Bitmap;
import android.print.PrintAttributes;
import android.os.AsyncTask;

class PrintHelperKitkat$2 extends AsyncTask
{
    final /* synthetic */ PrintHelperKitkat this$0;
    final /* synthetic */ PrintAttributes val$attributes;
    final /* synthetic */ Bitmap val$bitmap;
    final /* synthetic */ CancellationSignal val$cancellationSignal;
    final /* synthetic */ ParcelFileDescriptor val$fileDescriptor;
    final /* synthetic */ int val$fittingMode;
    final /* synthetic */ PrintAttributes val$pdfAttributes;
    final /* synthetic */ PrintDocumentAdapter$WriteResultCallback val$writeResultCallback;
    
    PrintHelperKitkat$2(final PrintHelperKitkat this$0, final CancellationSignal val$cancellationSignal, final PrintAttributes val$pdfAttributes, final Bitmap val$bitmap, final PrintAttributes val$attributes, final int val$fittingMode, final ParcelFileDescriptor val$fileDescriptor, final PrintDocumentAdapter$WriteResultCallback val$writeResultCallback) {
        this.this$0 = this$0;
        this.val$cancellationSignal = val$cancellationSignal;
        this.val$pdfAttributes = val$pdfAttributes;
        this.val$bitmap = val$bitmap;
        this.val$attributes = val$attributes;
        this.val$fittingMode = val$fittingMode;
        this.val$fileDescriptor = val$fileDescriptor;
        this.val$writeResultCallback = val$writeResultCallback;
    }
    
    protected Throwable doInBackground(final Void... array) {
        try {
            if (this.val$cancellationSignal.isCanceled()) {
                return null;
            }
            final PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(this.this$0.mContext, this.val$pdfAttributes);
            final Bitmap access$100 = this.this$0.convertBitmapForColorMode(this.val$bitmap, this.val$pdfAttributes.getColorMode());
            if (this.val$cancellationSignal.isCanceled()) {
                return null;
            }
            final int n = 1;
            final PrintedPdfDocument printedPdfDocument2 = printedPdfDocument;
            try {
                final PdfDocument$Page startPage = printedPdfDocument2.startPage(n);
                RectF rectF;
                if (this.this$0.mIsMinMarginsHandlingCorrect) {
                    rectF = new RectF(startPage.getInfo().getContentRect());
                }
                else {
                    final PrintedPdfDocument printedPdfDocument3 = new PrintedPdfDocument(this.this$0.mContext, this.val$attributes);
                    final PdfDocument$Page startPage2 = printedPdfDocument3.startPage(n);
                    final RectF rectF2 = new RectF(startPage2.getInfo().getContentRect());
                    printedPdfDocument3.finishPage(startPage2);
                    printedPdfDocument3.close();
                    rectF = rectF2;
                }
                final Matrix access$101 = this.this$0.getMatrix(access$100.getWidth(), access$100.getHeight(), rectF, this.val$fittingMode);
                if (!this.this$0.mIsMinMarginsHandlingCorrect) {
                    access$101.postTranslate(rectF.left, rectF.top);
                    startPage.getCanvas().clipRect(rectF);
                }
                startPage.getCanvas().drawBitmap(access$100, access$101, (Paint)null);
                printedPdfDocument.finishPage(startPage);
                if (this.val$cancellationSignal.isCanceled()) {
                    return null;
                }
                printedPdfDocument.writeTo((OutputStream)new FileOutputStream(this.val$fileDescriptor.getFileDescriptor()));
                return null;
            }
            finally {
                printedPdfDocument.close();
                if (this.val$fileDescriptor != null) {
                    try {
                        final ParcelFileDescriptor val$fileDescriptor = this.val$fileDescriptor;
                        try {
                            val$fileDescriptor.close();
                        }
                        catch (IOException ex) {}
                    }
                    catch (IOException ex2) {}
                }
                if (access$100 != this.val$bitmap) {
                    access$100.recycle();
                }
            }
        }
        finally {
            return loadexception(java.lang.Throwable.class);
        }
    }
    
    protected void onPostExecute(final Throwable t) {
        if (this.val$cancellationSignal.isCanceled()) {
            this.val$writeResultCallback.onWriteCancelled();
        }
        else if (t == null) {
            this.val$writeResultCallback.onWriteFinished(new PageRange[] { PageRange.ALL_PAGES });
        }
        else {
            Log.e("PrintHelperKitkat", "Error writing printed content", t);
            this.val$writeResultCallback.onWriteFailed((CharSequence)null);
        }
    }
}
