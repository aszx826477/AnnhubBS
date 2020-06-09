// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import android.os.Build$VERSION;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.graphics.Bitmap$Config;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Bitmap;

public final class TransformationUtils
{
    public static final int PAINT_FLAGS = 6;
    private static final String TAG = "TransformationUtils";
    
    public static Bitmap centerCrop(final Bitmap bitmap, final Bitmap bitmap2, final int n, final int n2) {
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == n && bitmap2.getHeight() == n2) {
            return bitmap2;
        }
        float n3 = 0.0f;
        float n4 = 0.0f;
        final Matrix matrix = new Matrix();
        final int n5 = bitmap2.getWidth() * n2;
        final int n6 = bitmap2.getHeight() * n;
        final float n7 = 0.5f;
        float n8;
        if (n5 > n6) {
            n8 = n2 / bitmap2.getHeight();
            n3 = (n - bitmap2.getWidth() * n8) * n7;
        }
        else {
            n8 = n / bitmap2.getWidth();
            n4 = (n2 - bitmap2.getHeight() * n8) * n7;
        }
        matrix.setScale(n8, n8);
        matrix.postTranslate((float)(int)(n3 + n7), (float)(int)(n7 + n4));
        Bitmap bitmap3;
        if (bitmap != null) {
            bitmap3 = bitmap;
        }
        else {
            bitmap3 = Bitmap.createBitmap(n, n2, getSafeConfig(bitmap2));
        }
        setAlpha(bitmap2, bitmap3);
        new Canvas(bitmap3).drawBitmap(bitmap2, matrix, new Paint(6));
        return bitmap3;
    }
    
    public static Bitmap fitCenter(final Bitmap bitmap, final BitmapPool bitmapPool, final int n, final int n2) {
        final int width = bitmap.getWidth();
        final int n3 = 2;
        if (width == n && bitmap.getHeight() == n2) {
            if (Log.isLoggable("TransformationUtils", n3)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        final float min = Math.min(n / bitmap.getWidth(), n2 / bitmap.getHeight());
        final int n4 = (int)(bitmap.getWidth() * min);
        final int n5 = (int)(bitmap.getHeight() * min);
        if (bitmap.getWidth() == n4 && bitmap.getHeight() == n5) {
            if (Log.isLoggable("TransformationUtils", n3)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        final Bitmap$Config safeConfig = getSafeConfig(bitmap);
        Bitmap bitmap2 = bitmapPool.get(n4, n5, safeConfig);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(n4, n5, safeConfig);
        }
        setAlpha(bitmap, bitmap2);
        if (Log.isLoggable("TransformationUtils", n3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("request: ");
            sb.append(n);
            sb.append("x");
            sb.append(n2);
            Log.v("TransformationUtils", sb.toString());
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("toFit:   ");
            sb2.append(bitmap.getWidth());
            sb2.append("x");
            sb2.append(bitmap.getHeight());
            Log.v("TransformationUtils", sb2.toString());
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("toReuse: ");
            sb3.append(bitmap2.getWidth());
            sb3.append("x");
            sb3.append(bitmap2.getHeight());
            Log.v("TransformationUtils", sb3.toString());
            final String s = "TransformationUtils";
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("minPct:   ");
            sb4.append(min);
            Log.v(s, sb4.toString());
        }
        final Canvas canvas = new Canvas(bitmap2);
        final Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        canvas.drawBitmap(bitmap, matrix, new Paint(6));
        return bitmap2;
    }
    
    public static int getExifOrientationDegrees(final int n) {
        int n2 = 0;
        switch (n) {
            default: {
                n2 = 0;
                break;
            }
            case 7:
            case 8: {
                n2 = 270;
                break;
            }
            case 5:
            case 6: {
                n2 = 90;
                break;
            }
            case 3:
            case 4: {
                n2 = 180;
                break;
            }
        }
        return n2;
    }
    
    public static int getOrientation(final String s) {
        try {
            final int attributeInt = new ExifInterface(s).getAttributeInt("Orientation", 0);
            try {
                return getExifOrientationDegrees(attributeInt);
            }
            catch (Exception ex) {
                if (Log.isLoggable("TransformationUtils", 6)) {
                    final String s2 = "TransformationUtils";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unable to get orientation for image with path=");
                    sb.append(s);
                    Log.e(s2, sb.toString(), (Throwable)ex);
                }
                return 0;
            }
        }
        catch (Exception ex2) {}
    }
    
    private static Bitmap$Config getSafeConfig(final Bitmap bitmap) {
        Bitmap$Config bitmap$Config;
        if (bitmap.getConfig() != null) {
            bitmap$Config = bitmap.getConfig();
        }
        else {
            bitmap$Config = Bitmap$Config.ARGB_8888;
        }
        return bitmap$Config;
    }
    
    static void initializeMatrixForRotation(final int n, final Matrix matrix) {
        final float n2 = -90.0f;
        final float n3 = 90.0f;
        final float n4 = 180.0f;
        final float n5 = 1.0f;
        final float n6 = -1.0f;
        switch (n) {
            case 8: {
                matrix.setRotate(n2);
                break;
            }
            case 7: {
                matrix.setRotate(n2);
                matrix.postScale(n6, n5);
                break;
            }
            case 6: {
                matrix.setRotate(n3);
                break;
            }
            case 5: {
                matrix.setRotate(n3);
                matrix.postScale(n6, n5);
                break;
            }
            case 4: {
                matrix.setRotate(n4);
                matrix.postScale(n6, n5);
                break;
            }
            case 3: {
                matrix.setRotate(n4);
                break;
            }
            case 2: {
                matrix.setScale(n6, n5);
                break;
            }
        }
    }
    
    public static Bitmap orientImage(final String s, final Bitmap bitmap) {
        return rotateImage(bitmap, getOrientation(s));
    }
    
    public static Bitmap rotateImage(final Bitmap bitmap, final int n) {
        Bitmap bitmap2 = bitmap;
        if (n != 0) {
            try {
                try {
                    final Matrix matrix = new Matrix();
                    matrix.setRotate((float)n);
                    final int width = bitmap.getWidth();
                    try {
                        bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, bitmap.getHeight(), matrix, true);
                        return bitmap2;
                    }
                    catch (Exception ex) {
                        if (Log.isLoggable("TransformationUtils", 6)) {
                            Log.e("TransformationUtils", "Exception when trying to orient image", (Throwable)ex);
                            return bitmap2;
                        }
                        return bitmap2;
                    }
                }
                catch (Exception ex2) {}
            }
            catch (Exception ex3) {}
        }
        return bitmap2;
    }
    
    public static Bitmap rotateImageExif(final Bitmap bitmap, final BitmapPool bitmapPool, final int n) {
        final Matrix matrix = new Matrix();
        initializeMatrixForRotation(n, matrix);
        if (matrix.isIdentity()) {
            return bitmap;
        }
        final RectF rectF = new RectF(0.0f, 0.0f, (float)bitmap.getWidth(), (float)bitmap.getHeight());
        matrix.mapRect(rectF);
        final int round = Math.round(rectF.width());
        final int round2 = Math.round(rectF.height());
        final Bitmap$Config safeConfig = getSafeConfig(bitmap);
        Bitmap bitmap2 = bitmapPool.get(round, round2, safeConfig);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(round, round2, safeConfig);
        }
        matrix.postTranslate(-rectF.left, -rectF.top);
        new Canvas(bitmap2).drawBitmap(bitmap, matrix, new Paint(6));
        return bitmap2;
    }
    
    public static void setAlpha(final Bitmap bitmap, final Bitmap bitmap2) {
        if (Build$VERSION.SDK_INT >= 12 && bitmap2 != null) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
    }
}
