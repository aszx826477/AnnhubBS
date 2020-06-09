// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

import java.io.PrintWriter;

public final class TimeUtils
{
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static char[] sFormatStr;
    private static final Object sFormatSync;
    
    static {
        sFormatSync = new Object();
        TimeUtils.sFormatStr = new char[24];
    }
    
    private static int accumField(final int n, final int n2, final boolean b, final int n3) {
        if (n > 99 || (b && n3 >= 3)) {
            return n2 + 3;
        }
        if (n > 9 || (b && n3 >= 2)) {
            return n2 + 2;
        }
        if (!b && n <= 0) {
            return 0;
        }
        return n2 + 1;
    }
    
    public static void formatDuration(final long n, final long n2, final PrintWriter printWriter) {
        if (n == 0L) {
            printWriter.print("--");
            return;
        }
        formatDuration(n - n2, printWriter, 0);
    }
    
    public static void formatDuration(final long n, final PrintWriter printWriter) {
        formatDuration(n, printWriter, 0);
    }
    
    public static void formatDuration(final long n, final PrintWriter printWriter, final int n2) {
        synchronized (TimeUtils.sFormatSync) {
            printWriter.print(new String(TimeUtils.sFormatStr, 0, formatDurationLocked(n, n2)));
        }
    }
    
    public static void formatDuration(final long n, final StringBuilder sb) {
        final Object sFormatSync = TimeUtils.sFormatSync;
        synchronized (sFormatSync) {
            sb.append(TimeUtils.sFormatStr, 0, formatDurationLocked(n, 0));
        }
    }
    
    private static int formatDurationLocked(final long n, final int n2) {
        long n3 = n;
        if (TimeUtils.sFormatStr.length < n2) {
            TimeUtils.sFormatStr = new char[n2];
        }
        final char[] sFormatStr = TimeUtils.sFormatStr;
        final char c = ' ';
        final long n4 = 0L;
        if (n3 == n4) {
            while (0 < n2 - 1) {
                sFormatStr[0] = c;
            }
            sFormatStr[0] = '0';
            return 0 + 1;
        }
        char c2;
        if (n3 > n4) {
            c2 = '+';
        }
        else {
            final char c3 = '-';
            n3 = -n3;
            c2 = c3;
        }
        final long n5 = 1000L;
        final int n6 = (int)(n3 % n5);
        int n7 = (int)Math.floor(n3 / n5);
        final int n8 = 86400;
        int n10;
        if (n7 > n8) {
            final int n9 = n7 / n8;
            n7 -= n8 * n9;
            n10 = n9;
        }
        else {
            n10 = 0;
        }
        int n12;
        if (n7 > 3600) {
            final int n11 = n7 / 3600;
            n7 -= n11 * 3600;
            n12 = n11;
        }
        else {
            n12 = 0;
        }
        int n14;
        int n15;
        if (n7 > 60) {
            final int n13 = n7 / 60;
            n14 = n7 - n13 * 60;
            n15 = n13;
        }
        else {
            n14 = n7;
            n15 = 0;
        }
        int n16 = 0;
        int n17 = 3;
        final int n18 = 2;
        boolean b = false;
        final int n19 = 1;
        if (n2 != 0) {
            final int accumField = accumField(n10, n19, false, 0);
            if (accumField > 0) {
                b = true;
            }
            final int n20 = accumField + accumField(n12, n19, b, n18);
            final int n21 = n20 + accumField(n15, n19, n20 > 0, n18);
            final int n22 = n21 + accumField(n14, n19, n21 > 0, n18);
            int n23;
            if (n22 > 0) {
                n23 = 3;
            }
            else {
                n23 = 0;
            }
            for (int i = n22 + (accumField(n6, n18, n19 != 0, n23) + n19); i < n2; ++i) {
                sFormatStr[n16] = c;
                ++n16;
            }
        }
        sFormatStr[n16] = c2;
        final int n25;
        final int n24 = n25 = n16 + 1;
        final boolean b2 = n2 != 0;
        boolean b3 = true;
        int n26 = 2;
        final int printField = printField(sFormatStr, n10, 'd', n24, false, 0);
        final char c4 = 'h';
        final boolean b4 = printField != n25;
        int n27;
        if (b2) {
            n27 = 2;
        }
        else {
            n27 = 0;
        }
        final int n28 = printField;
        final int n29 = n25;
        final int printField2 = printField(sFormatStr, n12, c4, n28, b4, n27);
        final char c5 = 'm';
        final int n30 = n29;
        final boolean b5 = printField2 != n29;
        int n31;
        if (b2) {
            n31 = 2;
        }
        else {
            n31 = 0;
        }
        final int n32 = printField2;
        final int n33 = n30;
        final int printField3 = printField(sFormatStr, n15, c5, n32, b5, n31);
        final char c6 = 's';
        final int n34 = n33;
        if (printField3 == n33) {
            b3 = false;
        }
        if (!b2) {
            n26 = 0;
        }
        final int n35 = printField3;
        final int n36 = n34;
        final int printField4 = printField(sFormatStr, n14, c6, n35, b3, n26);
        final char c7 = 'm';
        final boolean b6 = true;
        Label_0831: {
            if (b2) {
                final int n37;
                if (printField4 != (n37 = n36)) {
                    break Label_0831;
                }
            }
            n17 = 0;
        }
        final int printField5 = printField(sFormatStr, n6, c7, printField4, b6, n17);
        sFormatStr[printField5] = 's';
        return printField5 + 1;
    }
    
    private static int printField(final char[] array, int n, final char c, int n2, final boolean b, final int n3) {
        if (b || n > 0) {
            final int n4 = n2;
            if ((b && n3 >= 3) || n > 99) {
                final int n5 = n / 100;
                array[n2] = (char)(n5 + 48);
                ++n2;
                n -= n5 * 100;
            }
            if ((b && n3 >= 2) || n > 9 || n4 != n2) {
                final int n6 = n / 10;
                array[n2] = (char)(n6 + 48);
                ++n2;
                n -= n6 * 10;
            }
            array[n2] = (char)(n + 48);
            ++n2;
            array[n2] = c;
            ++n2;
        }
        return n2;
    }
}
