// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.http;

import okhttp3.internal.Util;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.text.ParsePosition;
import java.util.Date;
import java.text.DateFormat;

public final class HttpDate
{
    private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS;
    private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
    public static final long MAX_DATE = 253402300799999L;
    private static final ThreadLocal STANDARD_DATE_FORMAT;
    
    static {
        STANDARD_DATE_FORMAT = new HttpDate$1();
        BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = new String[] { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z" };
        BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[HttpDate.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length];
    }
    
    public static String format(final Date date) {
        return HttpDate.STANDARD_DATE_FORMAT.get().format(date);
    }
    
    public static Date parse(final String s) {
        if (s.length() == 0) {
            return null;
        }
        final ParsePosition parsePosition = new ParsePosition(0);
        final Date parse = HttpDate.STANDARD_DATE_FORMAT.get().parse(s, parsePosition);
        if (parsePosition.getIndex() == s.length()) {
            return parse;
        }
        final String[] browser_COMPATIBLE_DATE_FORMAT_STRINGS = HttpDate.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
        // monitorenter(browser_COMPATIBLE_DATE_FORMAT_STRINGS)
        int i = 0;
        try {
            while (i < HttpDate.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length) {
                DateFormat dateFormat = HttpDate.BROWSER_COMPATIBLE_DATE_FORMATS[i];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(HttpDate.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[i], Locale.US);
                    dateFormat.setTimeZone(Util.UTC);
                    HttpDate.BROWSER_COMPATIBLE_DATE_FORMATS[i] = dateFormat;
                }
                parsePosition.setIndex(0);
                final Date parse2 = dateFormat.parse(s, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
                ++i;
            }
            return null;
        }
        finally {
        }
        // monitorexit(browser_COMPATIBLE_DATE_FORMAT_STRINGS)
    }
}
