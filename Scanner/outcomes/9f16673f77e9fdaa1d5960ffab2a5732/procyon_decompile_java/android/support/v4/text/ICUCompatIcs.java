// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.text;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import android.util.Log;
import java.lang.reflect.Method;

class ICUCompatIcs
{
    private static final String TAG = "ICUCompatIcs";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;
    
    static {
        final String s = "libcore.icu.ICU";
        try {
            final Class<?> forName = Class.forName(s);
            Label_0074: {
                if (forName == null) {
                    break Label_0074;
                }
                final String s2 = "getScript";
                final int n = 1;
                final Class[] array = new Class[n];
                array[0] = String.class;
                final Method method = forName.getMethod(s2, (Class<?>[])array);
                try {
                    ICUCompatIcs.sGetScriptMethod = method;
                    final String s3 = "addLikelySubtags";
                    final Class[] array2 = new Class[n];
                    array2[0] = String.class;
                    final Method method2 = forName.getMethod(s3, (Class<?>[])array2);
                    try {
                        ICUCompatIcs.sAddLikelySubtagsMethod = method2;
                    }
                    catch (Exception ex) {
                        ICUCompatIcs.sGetScriptMethod = null;
                        ICUCompatIcs.sAddLikelySubtagsMethod = null;
                        Log.w("ICUCompatIcs", (Throwable)ex);
                    }
                }
                catch (Exception ex2) {}
            }
        }
        catch (Exception ex3) {}
    }
    
    private static String addLikelySubtags(final Locale locale) {
        final String string = locale.toString();
        try {
            if (ICUCompatIcs.sAddLikelySubtagsMethod != null) {
                final Object invoke = ICUCompatIcs.sAddLikelySubtagsMethod.invoke(null, string);
                try {
                    return (String)invoke;
                }
                catch (InvocationTargetException ex) {
                    Log.w("ICUCompatIcs", (Throwable)ex);
                }
                catch (IllegalAccessException ex2) {
                    Log.w("ICUCompatIcs", (Throwable)ex2);
                }
            }
        }
        catch (InvocationTargetException ex3) {}
        catch (IllegalAccessException ex4) {}
        return string;
    }
    
    private static String getScript(final String s) {
        try {
            if (ICUCompatIcs.sGetScriptMethod != null) {
                final Object invoke = ICUCompatIcs.sGetScriptMethod.invoke(null, s);
                try {
                    return (String)invoke;
                }
                catch (InvocationTargetException ex) {
                    Log.w("ICUCompatIcs", (Throwable)ex);
                }
                catch (IllegalAccessException ex2) {
                    Log.w("ICUCompatIcs", (Throwable)ex2);
                }
            }
        }
        catch (InvocationTargetException ex3) {}
        catch (IllegalAccessException ex4) {}
        return null;
    }
    
    public static String maximizeAndGetScript(final Locale locale) {
        final String addLikelySubtags = addLikelySubtags(locale);
        if (addLikelySubtags != null) {
            return getScript(addLikelySubtags);
        }
        return null;
    }
}
