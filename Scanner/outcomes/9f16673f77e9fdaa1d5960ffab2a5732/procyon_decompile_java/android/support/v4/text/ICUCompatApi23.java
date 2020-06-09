// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.text;

import java.lang.reflect.InvocationTargetException;
import android.util.Log;
import java.util.Locale;
import java.lang.reflect.Method;

class ICUCompatApi23
{
    private static final String TAG = "ICUCompatIcs";
    private static Method sAddLikelySubtagsMethod;
    
    static {
        final String s = "libcore.icu.ICU";
        try {
            final Method method = Class.forName(s).getMethod("addLikelySubtags", Locale.class);
            try {
                ICUCompatApi23.sAddLikelySubtagsMethod = method;
            }
            catch (Exception ex) {
                throw new IllegalStateException(ex);
            }
        }
        catch (Exception ex2) {}
    }
    
    public static String maximizeAndGetScript(final Locale locale) {
        final int n = 1;
        try {
            final Object[] array = new Object[n];
            array[0] = locale;
            final Object invoke = ICUCompatApi23.sAddLikelySubtagsMethod.invoke(null, array);
            try {
                final Locale locale2 = (Locale)invoke;
                try {
                    return locale2.getScript();
                }
                catch (IllegalAccessException ex) {
                    Log.w("ICUCompatIcs", (Throwable)ex);
                }
                catch (InvocationTargetException ex2) {
                    Log.w("ICUCompatIcs", (Throwable)ex2);
                }
            }
            catch (IllegalAccessException ex3) {}
            catch (InvocationTargetException ex4) {}
        }
        catch (IllegalAccessException ex5) {}
        catch (InvocationTargetException ex6) {}
        return locale.getScript();
    }
}
