// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import okhttp3.internal.Util;

final class Http2$FrameLogger
{
    private static final String[] BINARY;
    private static final String[] FLAGS;
    private static final String[] TYPES;
    
    static {
        final String[] types = new String[10];
        types[0] = "DATA";
        final int n = 1;
        types[n] = "HEADERS";
        types[2] = "PRIORITY";
        final int n2 = 3;
        types[n2] = "RST_STREAM";
        final int n3 = 4;
        types[n3] = "SETTINGS";
        types[5] = "PUSH_PROMISE";
        types[6] = "PING";
        types[7] = "GOAWAY";
        final int n4 = 8;
        types[n4] = "WINDOW_UPDATE";
        types[9] = "CONTINUATION";
        TYPES = types;
        FLAGS = new String[64];
        BINARY = new String[256];
        int n5 = 0;
        char c;
        while (true) {
            final String[] binary = Http2$FrameLogger.BINARY;
            final int length = binary.length;
            c = ' ';
            if (n5 >= length) {
                break;
            }
            final Object[] array = new Object[n];
            array[0] = Integer.toBinaryString(n5);
            binary[n5] = Util.format("%8s", array).replace(c, '0');
            ++n5;
        }
        final String[] flags = Http2$FrameLogger.FLAGS;
        flags[0] = "";
        flags[n] = "END_STREAM";
        final int[] array2 = new int[n];
        array2[0] = n;
        flags[n4] = "PADDED";
        for (int length2 = array2.length, i = 0; i < length2; ++i) {
            final int n6 = array2[i];
            final String[] flags2 = Http2$FrameLogger.FLAGS;
            final int n7 = n6 | 0x8;
            final StringBuilder sb = new StringBuilder();
            sb.append(Http2$FrameLogger.FLAGS[n6]);
            sb.append("|PADDED");
            flags2[n7] = sb.toString();
        }
        final String[] flags3 = Http2$FrameLogger.FLAGS;
        flags3[n3] = "END_HEADERS";
        flags3[c] = "PRIORITY";
        flags3[36] = "END_HEADERS|PRIORITY";
        final int[] array4;
        final int[] array3 = array4 = new int[n2];
        array4[0] = 4;
        array4[1] = 32;
        array4[2] = 36;
        for (int length3 = array3.length, j = 0; j < length3; ++j) {
            final int n8 = array3[j];
            for (int length4 = array2.length, k = 0; k < length4; ++k) {
                final int n9 = array2[k];
                final String[] flags4 = Http2$FrameLogger.FLAGS;
                final int n10 = n9 | n8;
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(Http2$FrameLogger.FLAGS[n9]);
                final char c2 = '|';
                sb2.append(c2);
                sb2.append(Http2$FrameLogger.FLAGS[n8]);
                flags4[n10] = sb2.toString();
                final String[] flags5 = Http2$FrameLogger.FLAGS;
                final int n11 = n9 | n8 | n4;
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(Http2$FrameLogger.FLAGS[n9]);
                sb3.append(c2);
                sb3.append(Http2$FrameLogger.FLAGS[n8]);
                sb3.append("|PADDED");
                flags5[n11] = sb3.toString();
            }
        }
        int n12 = 0;
        while (true) {
            final String[] flags6 = Http2$FrameLogger.FLAGS;
            if (n12 >= flags6.length) {
                break;
            }
            if (flags6[n12] == null) {
                flags6[n12] = Http2$FrameLogger.BINARY[n12];
            }
            ++n12;
        }
    }
    
    static String formatFlags(final byte b, final byte b2) {
        if (b2 == 0) {
            return "";
        }
        switch (b) {
            default: {
                final String[] flags = Http2$FrameLogger.FLAGS;
                String s;
                if (b2 < flags.length) {
                    s = flags[b2];
                }
                else {
                    s = Http2$FrameLogger.BINARY[b2];
                }
                if (b == 5 && (b2 & 0x4) != 0x0) {
                    return s.replace("HEADERS", "PUSH_PROMISE");
                }
                if (b == 0 && (b2 & 0x20) != 0x0) {
                    return s.replace("PRIORITY", "COMPRESSED");
                }
                return s;
            }
            case 4:
            case 6: {
                String s2;
                if (b2 == 1) {
                    s2 = "ACK";
                }
                else {
                    s2 = Http2$FrameLogger.BINARY[b2];
                }
                return s2;
            }
            case 2:
            case 3:
            case 7:
            case 8: {
                return Http2$FrameLogger.BINARY[b2];
            }
        }
    }
    
    static String formatHeader(final boolean b, final int n, final int n2, final byte b2, final byte b3) {
        final String[] types = Http2$FrameLogger.TYPES;
        final int length = types.length;
        final int n3 = 1;
        String format;
        if (b2 < length) {
            format = types[b2];
        }
        else {
            final Object[] array = new Object[n3];
            array[0] = b2;
            format = Util.format("0x%02x", array);
        }
        final String formatFlags = formatFlags(b2, b3);
        final String s = "%s 0x%08x %5d %-13s %s";
        final Object[] array2 = new Object[5];
        String s2;
        if (b) {
            s2 = "<<";
        }
        else {
            s2 = ">>";
        }
        array2[0] = s2;
        array2[n3] = n;
        array2[2] = n2;
        array2[3] = format;
        array2[4] = formatFlags;
        return Util.format(s, array2);
    }
}
