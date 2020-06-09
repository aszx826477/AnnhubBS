// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import java.lang.reflect.InvocationTargetException;
import android.util.Log;
import android.os.IBinder;
import android.os.Bundle;
import java.lang.reflect.Method;

class BundleCompatGingerbread
{
    private static final String TAG = "BundleCompatGingerbread";
    private static Method sGetIBinderMethod;
    private static boolean sGetIBinderMethodFetched;
    private static Method sPutIBinderMethod;
    private static boolean sPutIBinderMethodFetched;
    
    public static IBinder getBinder(final Bundle bundle, final String s) {
        final boolean sGetIBinderMethodFetched = BundleCompatGingerbread.sGetIBinderMethodFetched;
        final int n = 1;
        if (!sGetIBinderMethodFetched) {
            final Class<Bundle> clazz = Bundle.class;
            final String s2 = "getIBinder";
            try {
                final Class[] array = new Class[n];
                array[0] = String.class;
                final Method method = clazz.getMethod(s2, (Class[])array);
                try {
                    (BundleCompatGingerbread.sGetIBinderMethod = method).setAccessible(n != 0);
                }
                catch (NoSuchMethodException ex) {
                    Log.i("BundleCompatGingerbread", "Failed to retrieve getIBinder method", (Throwable)ex);
                }
            }
            catch (NoSuchMethodException ex2) {}
            BundleCompatGingerbread.sGetIBinderMethodFetched = (n != 0);
        }
        Object o = BundleCompatGingerbread.sGetIBinderMethod;
        if (o != null) {
            try {
                final Object[] array2 = new Object[n];
                array2[0] = s;
                o = ((Method)o).invoke(bundle, array2);
                try {
                    return (IBinder)o;
                }
                catch (IllegalArgumentException o) {}
                catch (IllegalAccessException o) {}
                catch (InvocationTargetException ex3) {}
            }
            catch (IllegalArgumentException ex4) {}
            catch (IllegalAccessException ex5) {}
            catch (InvocationTargetException ex6) {}
            Log.i("BundleCompatGingerbread", "Failed to invoke getIBinder via reflection", (Throwable)o);
            BundleCompatGingerbread.sGetIBinderMethod = null;
        }
        return null;
    }
    
    public static void putBinder(final Bundle bundle, final String s, final IBinder binder) {
        final boolean sPutIBinderMethodFetched = BundleCompatGingerbread.sPutIBinderMethodFetched;
        final int n = 2;
        final int n2 = 1;
        if (!sPutIBinderMethodFetched) {
            final Class<Bundle> clazz = Bundle.class;
            final String s2 = "putIBinder";
            try {
                final Class[] array = new Class[n];
                array[0] = String.class;
                array[n2] = IBinder.class;
                final Method method = clazz.getMethod(s2, (Class[])array);
                try {
                    (BundleCompatGingerbread.sPutIBinderMethod = method).setAccessible(n2 != 0);
                }
                catch (NoSuchMethodException ex) {
                    Log.i("BundleCompatGingerbread", "Failed to retrieve putIBinder method", (Throwable)ex);
                }
            }
            catch (NoSuchMethodException ex2) {}
            BundleCompatGingerbread.sPutIBinderMethodFetched = (n2 != 0);
        }
        final Method sPutIBinderMethod = BundleCompatGingerbread.sPutIBinderMethod;
        if (sPutIBinderMethod != null) {
            try {
                final Object[] array2 = new Object[n];
                array2[0] = s;
                array2[n2] = binder;
                sPutIBinderMethod.invoke(bundle, array2);
                return;
            }
            catch (IllegalArgumentException sPutIBinderMethod) {}
            catch (IllegalAccessException sPutIBinderMethod) {}
            catch (InvocationTargetException ex3) {}
            Log.i("BundleCompatGingerbread", "Failed to invoke putIBinder via reflection", (Throwable)sPutIBinderMethod);
            BundleCompatGingerbread.sPutIBinderMethod = null;
        }
    }
}
