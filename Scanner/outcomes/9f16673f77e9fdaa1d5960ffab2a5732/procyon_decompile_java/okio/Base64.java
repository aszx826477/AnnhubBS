// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.io.UnsupportedEncodingException;

final class Base64
{
    private static final byte[] MAP;
    private static final byte[] URL_MAP;
    
    static {
        final int n = 64;
        final byte[] array;
        final byte[] map = array = new byte[n];
        array[0] = 65;
        array[1] = 66;
        array[2] = 67;
        array[3] = 68;
        array[4] = 69;
        array[5] = 70;
        array[6] = 71;
        array[7] = 72;
        array[8] = 73;
        array[9] = 74;
        array[10] = 75;
        array[11] = 76;
        array[12] = 77;
        array[13] = 78;
        array[14] = 79;
        array[15] = 80;
        array[16] = 81;
        array[17] = 82;
        array[18] = 83;
        array[19] = 84;
        array[20] = 85;
        array[21] = 86;
        array[22] = 87;
        array[23] = 88;
        array[24] = 89;
        array[25] = 90;
        array[26] = 97;
        array[27] = 98;
        array[28] = 99;
        array[29] = 100;
        array[30] = 101;
        array[31] = 102;
        array[32] = 103;
        array[33] = 104;
        array[34] = 105;
        array[35] = 106;
        array[36] = 107;
        array[37] = 108;
        array[38] = 109;
        array[39] = 110;
        array[40] = 111;
        array[41] = 112;
        array[42] = 113;
        array[43] = 114;
        array[44] = 115;
        array[45] = 116;
        array[46] = 117;
        array[47] = 118;
        array[48] = 119;
        array[49] = 120;
        array[50] = 121;
        array[51] = 122;
        array[52] = 48;
        array[53] = 49;
        array[54] = 50;
        array[55] = 51;
        array[56] = 52;
        array[57] = 53;
        array[58] = 54;
        array[59] = 55;
        array[60] = 56;
        array[61] = 57;
        array[62] = 43;
        array[63] = 47;
        MAP = map;
        final byte[] array2;
        final byte[] url_MAP = array2 = new byte[n];
        array2[0] = 65;
        array2[1] = 66;
        array2[2] = 67;
        array2[3] = 68;
        array2[4] = 69;
        array2[5] = 70;
        array2[6] = 71;
        array2[7] = 72;
        array2[8] = 73;
        array2[9] = 74;
        array2[10] = 75;
        array2[11] = 76;
        array2[12] = 77;
        array2[13] = 78;
        array2[14] = 79;
        array2[15] = 80;
        array2[16] = 81;
        array2[17] = 82;
        array2[18] = 83;
        array2[19] = 84;
        array2[20] = 85;
        array2[21] = 86;
        array2[22] = 87;
        array2[23] = 88;
        array2[24] = 89;
        array2[25] = 90;
        array2[26] = 97;
        array2[27] = 98;
        array2[28] = 99;
        array2[29] = 100;
        array2[30] = 101;
        array2[31] = 102;
        array2[32] = 103;
        array2[33] = 104;
        array2[34] = 105;
        array2[35] = 106;
        array2[36] = 107;
        array2[37] = 108;
        array2[38] = 109;
        array2[39] = 110;
        array2[40] = 111;
        array2[41] = 112;
        array2[42] = 113;
        array2[43] = 114;
        array2[44] = 115;
        array2[45] = 116;
        array2[46] = 117;
        array2[47] = 118;
        array2[48] = 119;
        array2[49] = 120;
        array2[50] = 121;
        array2[51] = 122;
        array2[52] = 48;
        array2[53] = 49;
        array2[54] = 50;
        array2[55] = 51;
        array2[56] = 52;
        array2[57] = 53;
        array2[58] = 54;
        array2[59] = 55;
        array2[60] = 56;
        array2[61] = 57;
        array2[62] = 45;
        array2[63] = 95;
        URL_MAP = url_MAP;
    }
    
    public static byte[] decode(final String s) {
        int length = s.length();
        char c;
        char c2;
        char c3;
        char c4;
        while (true) {
            c = '\t';
            c2 = ' ';
            c3 = '\r';
            c4 = '\n';
            if (length <= 0) {
                break;
            }
            final char char1 = s.charAt(length - 1);
            if (char1 != '=' && char1 != c4 && char1 != c3 && char1 != c2 && char1 != c) {
                break;
            }
            --length;
        }
        final byte[] array = new byte[(int)(length * 6 / 8)];
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i = 0; i < length; ++i) {
            final char char2 = s.charAt(i);
            int n4;
            if (char2 >= 'A' && char2 <= 'Z') {
                n4 = char2 - 65;
            }
            else if (char2 >= 'a' && char2 <= 'z') {
                n4 = char2 - 71;
            }
            else if (char2 >= '0' && char2 <= '9') {
                n4 = char2 + '\u0004';
            }
            else if (char2 != '+' && char2 != '-') {
                if (char2 != '/' && char2 != '_') {
                    if (char2 == c4 || char2 == c3 || char2 == c2) {
                        continue;
                    }
                    if (char2 == c) {
                        continue;
                    }
                    return null;
                }
                else {
                    n4 = 63;
                }
            }
            else {
                n4 = 62;
            }
            n3 = (n3 << 6 | (byte)n4);
            ++n2;
            if (n2 % 4 == 0) {
                final int n5 = n + 1;
                array[n] = (byte)(n3 >> 16);
                final int n6 = n5 + 1;
                array[n5] = (byte)(n3 >> 8);
                final int n7 = n6 + 1;
                array[n6] = (byte)n3;
                n = n7;
            }
        }
        final int n8 = n2 % 4;
        if (n8 == 1) {
            return null;
        }
        if (n8 == 2) {
            final int n9 = n3 << 12;
            final int n10 = n + 1;
            array[n] = (byte)(n9 >> 16);
            n = n10;
        }
        else if (n8 == 3) {
            final int n11 = n3 << 6;
            final int n12 = n + 1;
            array[n] = (byte)(n11 >> 16);
            n = n12 + 1;
            array[n12] = (byte)(n11 >> 8);
        }
        if (n == array.length) {
            return array;
        }
        final byte[] array2 = new byte[n];
        System.arraycopy(array, 0, array2, 0, n);
        return array2;
    }
    
    public static String encode(final byte[] array) {
        return encode(array, Base64.MAP);
    }
    
    private static String encode(final byte[] array, final byte[] array2) {
        final byte[] array3 = new byte[(array.length + 2) * 4 / 3];
        int n = 0;
        final int n2 = array.length - array.length % 3;
        for (int i = 0; i < n2; i += 3) {
            final int n3 = n + 1;
            array3[n] = array2[(array[i] & 0xFF) >> 2];
            final int n4 = n3 + 1;
            array3[n3] = array2[(array[i] & 0x3) << 4 | (array[i + 1] & 0xFF) >> 4];
            final int n5 = n4 + 1;
            array3[n4] = array2[(array[i + 1] & 0xF) << 2 | (array[i + 2] & 0xFF) >> 6];
            n = n5 + 1;
            array3[n5] = array2[array[i + 2] & 0x3F];
        }
        final int n6 = array.length % 3;
        final byte b = 61;
        switch (n6) {
            case 2: {
                final int n7 = n + 1;
                array3[n] = array2[(array[n2] & 0xFF) >> 2];
                final int n8 = n7 + 1;
                array3[n7] = array2[(array[n2] & 0x3) << 4 | (array[n2 + 1] & 0xFF) >> 4];
                final int n9 = n8 + 1;
                array3[n8] = array2[(array[n2 + 1] & 0xF) << 2];
                n = n9 + 1;
                array3[n9] = b;
                break;
            }
            case 1: {
                final int n10 = n + 1;
                array3[n] = array2[(array[n2] & 0xFF) >> 2];
                final int n11 = n10 + 1;
                array3[n10] = array2[(array[n2] & 0x3) << 4];
                final int n12 = n11 + 1;
                array3[n11] = b;
                n = n12 + 1;
                array3[n12] = b;
                break;
            }
        }
        try {
            return new String(array3, 0, n, "US-ASCII");
        }
        catch (UnsupportedEncodingException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public static String encodeUrl(final byte[] array) {
        return encode(array, Base64.URL_MAP);
    }
}
