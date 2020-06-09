// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics.drawable;

import android.util.Log;
import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;

class DrawableCompatJellybeanMr1
{
    private static final String TAG = "DrawableCompatJellybeanMr1";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;
    
    public static int getLayoutDirection(final Drawable drawable) {
        if (!DrawableCompatJellybeanMr1.sGetLayoutDirectionMethodFetched) {
            final boolean b = true;
            final Class<Drawable> clazz = Drawable.class;
            final String s = "getLayoutDirection";
            try {
                final Method declaredMethod = clazz.getDeclaredMethod(s, (Class[])new Class[0]);
                try {
                    (DrawableCompatJellybeanMr1.sGetLayoutDirectionMethod = declaredMethod).setAccessible(b);
                }
                catch (NoSuchMethodException ex) {
                    Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", (Throwable)ex);
                }
            }
            catch (NoSuchMethodException ex3) {}
            DrawableCompatJellybeanMr1.sGetLayoutDirectionMethodFetched = b;
        }
        final Method sGetLayoutDirectionMethod = DrawableCompatJellybeanMr1.sGetLayoutDirectionMethod;
        if (sGetLayoutDirectionMethod != null) {
            try {
                final Object invoke = sGetLayoutDirectionMethod.invoke(drawable, new Object[0]);
                try {
                    final Integer n = (Integer)invoke;
                    try {
                        return n;
                    }
                    catch (Exception ex2) {
                        Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", (Throwable)ex2);
                        DrawableCompatJellybeanMr1.sGetLayoutDirectionMethod = null;
                    }
                }
                catch (Exception ex4) {}
            }
            catch (Exception ex5) {}
        }
        return -1;
    }
    
    public static boolean setLayoutDirection(final Drawable drawable, final int n) {
        final boolean sSetLayoutDirectionMethodFetched = DrawableCompatJellybeanMr1.sSetLayoutDirectionMethodFetched;
        final int n2 = 1;
        if (!sSetLayoutDirectionMethodFetched) {
            final Class<Drawable> clazz = Drawable.class;
            final String s = "setLayoutDirection";
            try {
                final Class[] array = new Class[n2];
                try {
                    array[0] = Integer.TYPE;
                    final Method declaredMethod = clazz.getDeclaredMethod(s, (Class[])array);
                    try {
                        (DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod = declaredMethod).setAccessible(n2 != 0);
                    }
                    catch (NoSuchMethodException ex) {
                        Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", (Throwable)ex);
                    }
                }
                catch (NoSuchMethodException ex3) {}
            }
            catch (NoSuchMethodException ex4) {}
            DrawableCompatJellybeanMr1.sSetLayoutDirectionMethodFetched = (n2 != 0);
        }
        final Method sSetLayoutDirectionMethod = DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod;
        if (sSetLayoutDirectionMethod != null) {
            try {
                final Object[] array2 = new Object[n2];
                try {
                    array2[0] = n;
                    sSetLayoutDirectionMethod.invoke(drawable, array2);
                    return n2 != 0;
                }
                catch (Exception ex2) {
                    Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", (Throwable)ex2);
                    DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod = null;
                }
            }
            catch (Exception ex5) {}
        }
        return false;
    }
}
