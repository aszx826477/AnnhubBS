// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.android.bbalbs.common.a;

public final class b
{
    private static final byte[] a;
    
    static {
        final byte[] array;
        final byte[] a2 = array = new byte[64];
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
        a = a2;
    }
    
    public static String a(final byte[] array, final String s) {
        final int n = array.length * 4 / 3;
        final byte[] array2 = new byte[n + (n / 76 + 3)];
        final int n2 = array.length - array.length % 3;
        int i = 0;
        int n3 = 0;
        int n4 = 0;
        while (i < n2) {
            final int n5 = n3 + 1;
            final byte[] a = b.a;
            array2[n3] = a[(array[i] & 0xFF) >> 2];
            final int n6 = n5 + 1;
            final int n7 = (array[i] & 0x3) << 4;
            final int n8 = i + 1;
            array2[n5] = a[n7 | (array[n8] & 0xFF) >> 4];
            final int n9 = n6 + 1;
            final int n10 = (array[n8] & 0xF) << 2;
            final int n11 = i + 2;
            array2[n6] = a[n10 | (array[n11] & 0xFF) >> 6];
            n3 = n9 + 1;
            array2[n9] = a[array[n11] & 0x3F];
            if ((n3 - n4) % 76 == 0 && n3 != 0) {
                final int n12 = n3 + 1;
                array2[n3] = 10;
                ++n4;
                n3 = n12;
            }
            i += 3;
        }
        final int n13 = array.length % 3;
        final byte b = 61;
        switch (n13) {
            case 2: {
                final int n14 = n3 + 1;
                final byte[] a2 = com.baidu.android.bbalbs.common.a.b.a;
                array2[n3] = a2[(array[n2] & 0xFF) >> 2];
                final int n15 = n14 + 1;
                final int n16 = (array[n2] & 0x3) << 4;
                final int n17 = n2 + 1;
                array2[n14] = a2[n16 | (array[n17] & 0xFF) >> 4];
                final int n18 = n15 + 1;
                array2[n15] = a2[(array[n17] & 0xF) << 2];
                n3 = n18 + 1;
                array2[n18] = b;
                break;
            }
            case 1: {
                final int n19 = n3 + 1;
                final byte[] a3 = com.baidu.android.bbalbs.common.a.b.a;
                array2[n3] = a3[(array[n2] & 0xFF) >> 2];
                final int n20 = n19 + 1;
                array2[n19] = a3[(array[n2] & 0x3) << 4];
                final int n21 = n20 + 1;
                array2[n20] = b;
                n3 = n21 + 1;
                array2[n21] = b;
                break;
            }
        }
        return new String(array2, 0, n3, s);
    }
    
    public static byte[] a(final byte[] array) {
        return a(array, array.length);
    }
    
    public static byte[] a(final byte[] array, final int n) {
        final int n2 = n / 4;
        final int n3 = 3;
        final int n4 = n2 * 3;
        if (n4 == 0) {
            return new byte[0];
        }
        final byte[] array2 = new byte[n4];
        int n5 = n;
        int n6 = 0;
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        while (true) {
            final byte b = array[n5 - 1];
            b2 = 10;
            if (b != b2) {
                b3 = 13;
                if (b != b3) {
                    b4 = 32;
                    if (b != b4) {
                        b5 = 9;
                        if (b != b5) {
                            if (b != 61) {
                                break;
                            }
                            ++n6;
                        }
                    }
                }
            }
            --n5;
        }
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        while (true) {
            final int n11 = 65280;
            final int n12 = 16711680;
            if (n7 >= n5) {
                if (n6 > 0) {
                    final int n13 = n8 << n6 * 6;
                    final int n14 = n9 + 1;
                    array2[n9] = (byte)((n13 & n12) >> 16);
                    if (n6 == 1) {
                        n9 = n14 + 1;
                        array2[n14] = (byte)((n13 & n11) >> 8);
                    }
                    else {
                        n9 = n14;
                    }
                }
                final byte[] array3 = new byte[n9];
                System.arraycopy(array2, 0, array3, 0, n9);
                return array3;
            }
            final byte b6 = array[n7];
            if (b6 != b2 && b6 != b3 && b6 != b4) {
                if (b6 != b5) {
                    int n15;
                    if (b6 >= 65 && b6 <= 90) {
                        n15 = b6 - 65;
                    }
                    else if (b6 >= 97 && b6 <= 122) {
                        n15 = b6 - 71;
                    }
                    else if (b6 >= 48 && b6 <= 57) {
                        n15 = b6 + 4;
                    }
                    else if (b6 == 43) {
                        n15 = 62;
                    }
                    else {
                        if (b6 != 47) {
                            return null;
                        }
                        n15 = 63;
                    }
                    final int n16 = n8 << 6 | (byte)n15;
                    int n19;
                    if (n10 % 4 == n3) {
                        final int n17 = n9 + 1;
                        array2[n9] = (byte)((n12 & n16) >> 16);
                        final int n18 = n17 + 1;
                        array2[n17] = (byte)((n11 & n16) >> 8);
                        n19 = n18 + 1;
                        array2[n18] = (byte)(n16 & 0xFF);
                    }
                    else {
                        n19 = n9;
                    }
                    ++n10;
                    n9 = n19;
                    n8 = n16;
                }
            }
            ++n7;
            b2 = 10;
        }
    }
}
