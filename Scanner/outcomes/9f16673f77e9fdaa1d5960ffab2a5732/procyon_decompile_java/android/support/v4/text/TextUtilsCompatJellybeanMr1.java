// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.text;

import android.text.TextUtils;
import java.util.Locale;

class TextUtilsCompatJellybeanMr1
{
    public static int getLayoutDirectionFromLocale(final Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
    
    public static String htmlEncode(final String s) {
        return TextUtils.htmlEncode(s);
    }
}
