// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.print;

import android.print.PageRange;
import android.os.Bundle;
import android.print.PrintDocumentAdapter;
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
import android.graphics.RectF;
import android.print.PrintDocumentAdapter$WriteResultCallback;
import android.os.ParcelFileDescriptor;
import android.graphics.BitmapFactory$Options;
import android.content.Context;
import android.os.CancellationSignal$OnCancelListener;
import android.print.PrintAttributes$MediaSize;
import android.print.PrintDocumentInfo$Builder;
import android.graphics.Matrix;
import java.io.FileNotFoundException;
import android.graphics.Bitmap;
import android.net.Uri;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter$LayoutResultCallback;
import android.os.CancellationSignal;
import android.os.AsyncTask;

class PrintHelperKitkat$3$1 extends AsyncTask
{
    final /* synthetic */ PrintHelperKitkat$3 this$1;
    final /* synthetic */ CancellationSignal val$cancellationSignal;
    final /* synthetic */ PrintDocumentAdapter$LayoutResultCallback val$layoutResultCallback;
    final /* synthetic */ PrintAttributes val$newPrintAttributes;
    final /* synthetic */ PrintAttributes val$oldPrintAttributes;
    
    PrintHelperKitkat$3$1(final PrintHelperKitkat$3 this$1, final CancellationSignal val$cancellationSignal, final PrintAttributes val$newPrintAttributes, final PrintAttributes val$oldPrintAttributes, final PrintDocumentAdapter$LayoutResultCallback val$layoutResultCallback) {
        this.this$1 = this$1;
        this.val$cancellationSignal = val$cancellationSignal;
        this.val$newPrintAttributes = val$newPrintAttributes;
        this.val$oldPrintAttributes = val$oldPrintAttributes;
        this.val$layoutResultCallback = val$layoutResultCallback;
    }
    
    protected Bitmap doInBackground(final Uri... array) {
        try {
            final PrintHelperKitkat$3 this$1 = this.this$1;
            try {
                final PrintHelperKitkat this$2 = this$1.this$0;
                try {
                    final PrintHelperKitkat$3 this$3 = this.this$1;
                    try {
                        return this$2.loadConstrainedBitmap(this$3.val$imageFile, 3500);
                    }
                    catch (FileNotFoundException ex) {
                        return null;
                    }
                }
                catch (FileNotFoundException ex2) {}
            }
            catch (FileNotFoundException ex3) {}
        }
        catch (FileNotFoundException ex4) {}
    }
    
    protected void onCancelled(final Bitmap bitmap) {
        this.val$layoutResultCallback.onLayoutCancelled();
        this.this$1.mLoadBitmap = null;
    }
    
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute((Object)bitmap);
        Label_0179: {
            if (bitmap != null && (!this.this$1.this$0.mPrintActivityRespectsOrientation || this.this$1.this$0.mOrientation == 0)) {
                // monitorenter(this)
                try {
                    final PrintAttributes$MediaSize mediaSize = this.this$1.mAttributes.getMediaSize();
                    try {
                        // monitorexit(this)
                        if (mediaSize == null) {
                            break Label_0179;
                        }
                        if (mediaSize.isPortrait() != isPortrait(bitmap)) {
                            final Matrix matrix = new Matrix();
                            matrix.postRotate(90.0f);
                            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                        }
                        break Label_0179;
                    }
                    finally {}
                }
                finally {}
            }
            // monitorexit(this)
        }
        final PrintHelperKitkat$3 this$1 = this.this$1;
        if ((this$1.mBitmap = bitmap) != null) {
            final PrintDocumentInfo$Builder printDocumentInfo$Builder = new PrintDocumentInfo$Builder(this$1.val$jobName);
            final int n = 1;
            this.val$layoutResultCallback.onLayoutFinished(printDocumentInfo$Builder.setContentType(n).setPageCount(n).build(), (boolean)((n ^ (this.val$newPrintAttributes.equals((Object)this.val$oldPrintAttributes) ? 1 : 0)) != 0x0));
        }
        else {
            this.val$layoutResultCallback.onLayoutFailed((CharSequence)null);
        }
        this.this$1.mLoadBitmap = null;
    }
    
    protected void onPreExecute() {
        this.val$cancellationSignal.setOnCancelListener((CancellationSignal$OnCancelListener)new PrintHelperKitkat$3$1$1(this));
    }
}
