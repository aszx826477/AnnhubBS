// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Date;
import java.util.TimeZone;

public class ISO8601Utils
{
    private static final TimeZone TIMEZONE_UTC;
    private static final String UTC_ID = "UTC";
    
    static {
        TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
    }
    
    private static boolean checkOffset(final String s, final int n, final char c) {
        return n < s.length() && s.charAt(n) == c;
    }
    
    public static String format(final Date date) {
        return format(date, false, ISO8601Utils.TIMEZONE_UTC);
    }
    
    public static String format(final Date date, final boolean b) {
        return format(date, b, ISO8601Utils.TIMEZONE_UTC);
    }
    
    public static String format(final Date time, final boolean b, final TimeZone timeZone) {
        final GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(time);
        final int length = "yyyy-MM-ddThh:mm:ss".length();
        int length2;
        if (b) {
            length2 = ".sss".length();
        }
        else {
            length2 = 0;
        }
        final int n = length + length2;
        String s;
        if (timeZone.getRawOffset() == 0) {
            s = "Z";
        }
        else {
            s = "+hh:mm";
        }
        final StringBuilder sb = new StringBuilder(n + s.length());
        final int n2 = 1;
        padInt(sb, gregorianCalendar.get(n2), "yyyy".length());
        char c = '-';
        sb.append(c);
        padInt(sb, gregorianCalendar.get(2) + n2, "MM".length());
        sb.append(c);
        padInt(sb, gregorianCalendar.get(5), "dd".length());
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), "hh".length());
        final char c2 = ':';
        sb.append(c2);
        padInt(sb, gregorianCalendar.get(12), "mm".length());
        sb.append(c2);
        padInt(sb, gregorianCalendar.get(13), "ss".length());
        if (b) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), "sss".length());
        }
        final int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            final int n3 = 60000;
            final int abs = Math.abs(offset / n3 / 60);
            final int abs2 = Math.abs(offset / n3 % 60);
            if (offset >= 0) {
                c = '+';
            }
            sb.append(c);
            padInt(sb, abs, "hh".length());
            sb.append(c2);
            padInt(sb, abs2, "mm".length());
        }
        else {
            sb.append('Z');
        }
        return sb.toString();
    }
    
    private static int indexOfNonDigit(final String s, final int n) {
        for (int i = n; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 < '0' || char1 > '9') {
                return i;
            }
        }
        return s.length();
    }
    
    private static void padInt(final StringBuilder sb, final int n, final int n2) {
        final String string = Integer.toString(n);
        for (int i = n2 - string.length(); i > 0; --i) {
            sb.append('0');
        }
        sb.append(string);
    }
    
    public static Date parse(final String s, final ParsePosition parsePosition) {
        try {
            final int index = parsePosition.getIndex();
            int n = index + 4;
            final int int1 = parseInt(s, index, n);
            final char c = '-';
            if (checkOffset(s, n, c)) {
                ++n;
            }
            int n2 = n + 2;
            final int int2 = parseInt(s, n, n2);
            if (checkOffset(s, n2, c)) {
                ++n2;
            }
            final int index2 = n2 + 2;
            final int int3 = parseInt(s, n2, index2);
            int int4 = 0;
            int int5 = 0;
            int n3 = 0;
            int n4 = 0;
            final boolean checkOffset = checkOffset(s, index2, 'T');
            if (!checkOffset) {
                try {
                    if (s.length() <= index2) {
                        final GregorianCalendar gregorianCalendar = new GregorianCalendar(int1, int2 - 1, int3);
                        try {
                            parsePosition.setIndex(index2);
                            return gregorianCalendar.getTime();
                        }
                        catch (IllegalArgumentException ex4) {}
                        catch (NumberFormatException ex5) {}
                        catch (IndexOutOfBoundsException ex2) {}
                    }
                }
                catch (IllegalArgumentException ex6) {}
                catch (NumberFormatException ex7) {}
                catch (IndexOutOfBoundsException ex8) {}
            }
            final char c2 = '+';
            final char c3 = 'Z';
            int n9 = 0;
            Label_0572: {
                if (checkOffset) {
                    final int n5 = index2 + 1;
                    int n6 = n5 + 2;
                    int4 = parseInt(s, n5, n6);
                    final char c4 = ':';
                    if (checkOffset(s, n6, c4)) {
                        ++n6;
                    }
                    final int n7 = n6 + 2;
                    int5 = parseInt(s, n6, n7);
                    int n8;
                    if (checkOffset(s, n7, c4)) {
                        n8 = n7 + 1;
                    }
                    else {
                        n8 = n7;
                    }
                    if (s.length() > n8) {
                        final char char1 = s.charAt(n8);
                        if (char1 != c3 && char1 != c2 && char1 != '-') {
                            n9 = n8 + 2;
                            final int int6 = parseInt(s, n8, n9);
                            if (int6 > 59 && int6 < 63) {
                                n3 = 59;
                            }
                            else {
                                n3 = int6;
                            }
                            if (checkOffset(s, n9, '.')) {
                                final int n10 = n9 + 1;
                                final int indexOfNonDigit = indexOfNonDigit(s, n10 + 1);
                                final int min = Math.min(indexOfNonDigit, n10 + 3);
                                final int int7 = parseInt(s, n10, min);
                                switch (min - n10) {
                                    default: {
                                        n4 = int7;
                                        break;
                                    }
                                    case 2: {
                                        n4 = int7 * 10;
                                        break;
                                    }
                                    case 1: {
                                        n4 = int7 * 100;
                                        break;
                                    }
                                }
                                n9 = indexOfNonDigit;
                            }
                            break Label_0572;
                        }
                    }
                    n9 = n8;
                }
                else {
                    n9 = index2;
                }
            }
            Label_1181: {
                if (s.length() <= n9) {
                    break Label_1181;
                }
                final char char2 = s.charAt(n9);
                final int n11 = 1;
                Label_1051: {
                    if (char2 == c3) {
                        final TimeZone timeZone = ISO8601Utils.TIMEZONE_UTC;
                        final int index3 = n9 + n11;
                        break Label_1051;
                    }
                    Label_0726: {
                        if (char2 == '+') {
                            break Label_0726;
                        }
                        Label_0729: {
                            if (char2 == '-') {
                                break Label_0729;
                            }
                            try {
                                try {
                                    final StringBuilder sb = new StringBuilder();
                                    final String s2 = "Invalid time zone indicator '";
                                    final StringBuilder sb2 = sb;
                                    try {
                                        sb2.append(s2);
                                        final StringBuilder sb3 = sb;
                                        try {
                                            sb3.append(char2);
                                            sb.append("'");
                                            throw new IndexOutOfBoundsException(sb.toString());
                                            final String substring = s.substring(n9);
                                            try {
                                                Label_0798: {
                                                    if (substring.length() >= 5) {
                                                        final String string = substring;
                                                        break Label_0798;
                                                    }
                                                    try {
                                                        final StringBuilder sb5;
                                                        final StringBuilder sb4 = sb5 = new StringBuilder();
                                                        try {
                                                            sb5.append(substring);
                                                            sb4.append("00");
                                                            final String string = sb4.toString();
                                                            final String s3 = string;
                                                            final int index3 = n9 + string.length();
                                                            Label_1042: {
                                                                if ("+0000".equals(s3) || "+00:00".equals(s3)) {
                                                                    break Label_1042;
                                                                }
                                                                try {
                                                                    final StringBuilder sb6 = new StringBuilder();
                                                                    sb6.append("GMT");
                                                                    final StringBuilder sb7 = sb6;
                                                                    try {
                                                                        sb7.append(s3);
                                                                        final String string2 = sb6.toString();
                                                                        try {
                                                                            TimeZone timeZone;
                                                                            final String id = (timeZone = TimeZone.getTimeZone(string2)).getID();
                                                                            Label_1039: {
                                                                                if (id.equals(string2)) {
                                                                                    break Label_1039;
                                                                                }
                                                                                if (id.replace(":", "").equals(string2)) {
                                                                                    break Label_1051;
                                                                                }
                                                                                try {
                                                                                    try {
                                                                                        final StringBuilder sb8 = new StringBuilder();
                                                                                        sb8.append("Mismatching time zone indicator: ");
                                                                                        final StringBuilder sb9 = sb8;
                                                                                        try {
                                                                                            sb9.append(string2);
                                                                                            sb8.append(" given, resolves to ");
                                                                                            sb8.append(timeZone.getID());
                                                                                            throw new IndexOutOfBoundsException(sb8.toString());
                                                                                            break Label_1051;
                                                                                            timeZone = ISO8601Utils.TIMEZONE_UTC;
                                                                                            final GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                                                                                            gregorianCalendar2.setLenient(false);
                                                                                            gregorianCalendar2.set(1, int1);
                                                                                            gregorianCalendar2.set(2, int2 - 1);
                                                                                            gregorianCalendar2.set(5, int3);
                                                                                            gregorianCalendar2.set(11, int4);
                                                                                            gregorianCalendar2.set(12, int5);
                                                                                            gregorianCalendar2.set(13, n3);
                                                                                            gregorianCalendar2.set(14, n4);
                                                                                            try {
                                                                                                parsePosition.setIndex(index3);
                                                                                                return gregorianCalendar2.getTime();
                                                                                                throw new IllegalArgumentException("No time zone indicator");
                                                                                            }
                                                                                            catch (IllegalArgumentException ex4) {}
                                                                                            catch (NumberFormatException ex5) {}
                                                                                            catch (IndexOutOfBoundsException ex2) {}
                                                                                        }
                                                                                        catch (IllegalArgumentException ex9) {}
                                                                                        catch (NumberFormatException ex10) {}
                                                                                        catch (IndexOutOfBoundsException ex11) {}
                                                                                    }
                                                                                    catch (IllegalArgumentException ex12) {}
                                                                                    catch (NumberFormatException ex13) {}
                                                                                    catch (IndexOutOfBoundsException ex14) {}
                                                                                }
                                                                                catch (IllegalArgumentException ex15) {}
                                                                                catch (NumberFormatException ex16) {}
                                                                                catch (IndexOutOfBoundsException ex17) {}
                                                                            }
                                                                        }
                                                                        catch (IllegalArgumentException ex18) {}
                                                                        catch (NumberFormatException ex19) {}
                                                                        catch (IndexOutOfBoundsException ex20) {}
                                                                    }
                                                                    catch (IllegalArgumentException ex21) {}
                                                                    catch (NumberFormatException ex22) {}
                                                                    catch (IndexOutOfBoundsException ex23) {}
                                                                }
                                                                catch (IllegalArgumentException ex24) {}
                                                                catch (NumberFormatException ex25) {}
                                                                catch (IndexOutOfBoundsException ex26) {}
                                                            }
                                                        }
                                                        catch (IllegalArgumentException ex27) {}
                                                        catch (NumberFormatException ex28) {}
                                                        catch (IndexOutOfBoundsException ex29) {}
                                                    }
                                                    catch (IllegalArgumentException ex30) {}
                                                    catch (NumberFormatException ex31) {}
                                                    catch (IndexOutOfBoundsException ex32) {}
                                                }
                                            }
                                            catch (IllegalArgumentException ex33) {}
                                            catch (NumberFormatException ex34) {}
                                            catch (IndexOutOfBoundsException ex35) {}
                                        }
                                        catch (IllegalArgumentException ex36) {}
                                        catch (NumberFormatException ex37) {}
                                        catch (IndexOutOfBoundsException ex38) {}
                                    }
                                    catch (IllegalArgumentException ex39) {}
                                    catch (NumberFormatException ex40) {}
                                    catch (IndexOutOfBoundsException ex41) {}
                                }
                                catch (IllegalArgumentException ex4) {}
                                catch (NumberFormatException ex5) {}
                                catch (IndexOutOfBoundsException ex2) {}
                            }
                            catch (IllegalArgumentException ex42) {}
                            catch (NumberFormatException ex43) {}
                            catch (IndexOutOfBoundsException ex44) {}
                        }
                    }
                }
            }
        }
        catch (IllegalArgumentException ex45) {}
        catch (NumberFormatException ex46) {}
        catch (IndexOutOfBoundsException ex47) {}
        final IndexOutOfBoundsException ex2;
        final IndexOutOfBoundsException ex = ex2;
        String string3;
        if (s == null) {
            string3 = null;
        }
        else {
            final StringBuilder sb10 = new StringBuilder();
            sb10.append('\"');
            sb10.append(s);
            sb10.append("'");
            string3 = sb10.toString();
        }
        String s4 = ex.getMessage();
        if (s4 == null || s4.isEmpty()) {
            final StringBuilder sb11 = new StringBuilder();
            sb11.append("(");
            sb11.append(ex.getClass().getName());
            sb11.append(")");
            s4 = sb11.toString();
        }
        final StringBuilder sb12 = new StringBuilder();
        sb12.append("Failed to parse date [");
        sb12.append(string3);
        sb12.append("]: ");
        sb12.append(s4);
        final ParseException ex3 = new ParseException(sb12.toString(), parsePosition.getIndex());
        ex3.initCause(ex);
        throw ex3;
    }
    
    private static int parseInt(final String s, final int n, final int n2) {
        if (n >= 0 && n2 <= s.length() && n <= n2) {
            int i = n;
            int n3 = 0;
            final int n4 = 10;
            if (n < n2) {
                final int n5 = n + 1;
                final int digit = Character.digit(s.charAt(n), n4);
                if (digit < 0) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Invalid number: ");
                    sb.append(s.substring(n, n2));
                    throw new NumberFormatException(sb.toString());
                }
                n3 = -digit;
                i = n5;
            }
            while (i < n2) {
                final int n6 = i + 1;
                final int digit2 = Character.digit(s.charAt(i), n4);
                if (digit2 < 0) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid number: ");
                    sb2.append(s.substring(n, n2));
                    throw new NumberFormatException(sb2.toString());
                }
                n3 = n3 * 10 - digit2;
                i = n6;
            }
            return -n3;
        }
        throw new NumberFormatException(s);
    }
}
