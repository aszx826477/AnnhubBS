// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import java.lang.reflect.InvocationTargetException;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.graphics.Rect;
import android.view.View;
import android.os.Build$VERSION;
import java.lang.reflect.Method;

public class ViewUtils
{
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;
    
    static {
        if (Build$VERSION.SDK_INT >= 18) {
            final Class<View> clazz = View.class;
            final String s = "computeFitSystemWindows";
            final int n = 2;
            try {
                final Class[] array = new Class[n];
                array[0] = Rect.class;
                final Class<Rect> clazz2 = Rect.class;
                final int accessible = 1;
                array[accessible] = clazz2;
                final Method declaredMethod = clazz.getDeclaredMethod(s, (Class[])array);
                try {
                    ViewUtils.sComputeFitSystemWindowsMethod = declaredMethod;
                    final Method sComputeFitSystemWindowsMethod = ViewUtils.sComputeFitSystemWindowsMethod;
                    try {
                        if (!sComputeFitSystemWindowsMethod.isAccessible()) {
                            ViewUtils.sComputeFitSystemWindowsMethod.setAccessible(accessible != 0);
                        }
                    }
                    catch (NoSuchMethodException ex) {
                        Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
                    }
                }
                catch (NoSuchMethodException ex2) {}
            }
            catch (NoSuchMethodException ex3) {}
        }
    }
    
    public static int combineMeasuredStates(final int n, final int n2) {
        return n | n2;
    }
    
    public static void computeFitSystemWindows(final View view, final Rect rect, final Rect rect2) {
        final Method sComputeFitSystemWindowsMethod = ViewUtils.sComputeFitSystemWindowsMethod;
        if (sComputeFitSystemWindowsMethod != null) {
            final int n = 2;
            try {
                final Object[] array = new Object[n];
                array[0] = rect;
                array[1] = rect2;
                sComputeFitSystemWindowsMethod.invoke(view, array);
            }
            catch (Exception ex) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", (Throwable)ex);
            }
        }
    }
    
    public static boolean isLayoutRtl(final View view) {
        final int layoutDirection = ViewCompat.getLayoutDirection(view);
        boolean b = true;
        if (layoutDirection != (b ? 1 : 0)) {
            b = false;
        }
        return b;
    }
    
    public static void makeOptionalFitsSystemWindows(final View view) {
        if (Build$VERSION.SDK_INT >= 16) {
            try {
                final Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", (Class<?>[])new Class[0]);
                try {
                    if (!method.isAccessible()) {
                        method.setAccessible(true);
                    }
                    method.invoke(view, new Object[0]);
                }
                catch (IllegalAccessException ex) {
                    Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", (Throwable)ex);
                }
                catch (InvocationTargetException ex2) {
                    Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", (Throwable)ex2);
                }
                catch (NoSuchMethodException ex3) {
                    Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
                }
            }
            catch (IllegalAccessException ex4) {}
            catch (InvocationTargetException ex5) {}
            catch (NoSuchMethodException ex6) {}
        }
    }
}
