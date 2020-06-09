// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.util;

import java.util.Iterator;
import java.util.Collection;
import org.litepal.exceptions.DataSupportException;
import org.litepal.parser.LitePalAttr;
import java.util.Locale;
import android.text.TextUtils;

public class BaseUtility
{
    public static String capitalize(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            final StringBuilder sb = new StringBuilder();
            final int n = 1;
            sb.append(s.substring(0, n).toUpperCase(Locale.US));
            sb.append(s.substring(n));
            return sb.toString();
        }
        String s2;
        if (s == null) {
            s2 = null;
        }
        else {
            s2 = "";
        }
        return s2;
    }
    
    public static String changeCase(final String s) {
        if (s == null) {
            return null;
        }
        final String cases = LitePalAttr.getInstance().getCases();
        if ("keep".equals(cases)) {
            return s;
        }
        if ("upper".equals(cases)) {
            return s.toUpperCase(Locale.US);
        }
        return s.toLowerCase(Locale.US);
    }
    
    public static void checkConditionsCorrect(final String... array) {
        if (array != null) {
            final int length = array.length;
            if (length > 0) {
                if (length != count(array[0], "?") + 1) {
                    throw new DataSupportException("The parameters in conditions are incorrect.");
                }
            }
        }
    }
    
    public static boolean containsIgnoreCases(final Collection collection, final String s) {
        if (collection == null) {
            return false;
        }
        if (s == null) {
            return collection.contains(null);
        }
        boolean b = false;
        final Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (s.equalsIgnoreCase(iterator.next())) {
                b = true;
                break;
            }
        }
        return b;
    }
    
    public static int count(String substring, final String s) {
        if (!TextUtils.isEmpty((CharSequence)substring) && !TextUtils.isEmpty((CharSequence)s)) {
            int n = 0;
            for (int i = substring.indexOf(s); i != -1; i = substring.indexOf(s)) {
                ++n;
                substring = substring.substring(s.length() + i);
            }
            return n;
        }
        return 0;
    }
    
    public static boolean isFieldTypeSupported(final String s) {
        final boolean equals = "boolean".equals(s);
        final boolean b = true;
        if (equals || "java.lang.Boolean".equals(s)) {
            return b;
        }
        if ("float".equals(s) || "java.lang.Float".equals(s)) {
            return b;
        }
        if ("double".equals(s) || "java.lang.Double".equals(s)) {
            return b;
        }
        if ("int".equals(s) || "java.lang.Integer".equals(s)) {
            return b;
        }
        if ("long".equals(s) || "java.lang.Long".equals(s)) {
            return b;
        }
        if ("short".equals(s) || "java.lang.Short".equals(s)) {
            return b;
        }
        if ("char".equals(s) || "java.lang.Character".equals(s)) {
            return b;
        }
        if (!"[B".equals(s) && !"[Ljava.lang.Byte;".equals(s)) {
            return ("java.lang.String".equals(s) || "java.util.Date".equals(s)) && b;
        }
        return b;
    }
}
