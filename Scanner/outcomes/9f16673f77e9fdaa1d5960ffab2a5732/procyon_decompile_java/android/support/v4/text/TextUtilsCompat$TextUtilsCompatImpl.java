// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.text;

import java.util.Locale;

class TextUtilsCompat$TextUtilsCompatImpl
{
    private static int getLayoutDirectionFromFirstChar(final Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            default: {
                return 0;
            }
            case 1:
            case 2: {
                return 1;
            }
        }
    }
    
    public int getLayoutDirectionFromLocale(final Locale locale) {
        if (locale != null && !locale.equals(TextUtilsCompat.ROOT)) {
            final String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale);
            if (maximizeAndGetScript == null) {
                return getLayoutDirectionFromFirstChar(locale);
            }
            if (maximizeAndGetScript.equalsIgnoreCase(TextUtilsCompat.ARAB_SCRIPT_SUBTAG) || maximizeAndGetScript.equalsIgnoreCase(TextUtilsCompat.HEBR_SCRIPT_SUBTAG)) {
                return 1;
            }
        }
        return 0;
    }
    
    public String htmlEncode(final String s) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 != '\"') {
                if (char1 != '<') {
                    if (char1 != '>') {
                        switch (char1) {
                            default: {
                                sb.append(char1);
                                break;
                            }
                            case 39: {
                                sb.append("&#39;");
                                break;
                            }
                            case 38: {
                                sb.append("&amp;");
                                break;
                            }
                        }
                    }
                    else {
                        sb.append("&gt;");
                    }
                }
                else {
                    sb.append("&lt;");
                }
            }
            else {
                sb.append("&quot;");
            }
        }
        return sb.toString();
    }
}
