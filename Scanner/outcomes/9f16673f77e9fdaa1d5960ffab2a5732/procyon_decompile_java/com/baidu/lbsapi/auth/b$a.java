// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.lbsapi.auth;

class b$a
{
    public static String a(final byte[] array) {
        final char[] array3;
        final char[] array2 = array3 = new char[16];
        array3[0] = '0';
        array3[1] = '1';
        array3[2] = '2';
        array3[3] = '3';
        array3[4] = '4';
        array3[5] = '5';
        array3[6] = '6';
        array3[7] = '7';
        array3[8] = '8';
        array3[9] = '9';
        array3[10] = 'A';
        array3[11] = 'B';
        array3[12] = 'C';
        array3[13] = 'D';
        array3[14] = 'E';
        array3[15] = 'F';
        final StringBuilder sb = new StringBuilder(array.length * 2);
        for (int i = 0; i < array.length; ++i) {
            sb.append(array2[(array[i] & 0xF0) >> 4]);
            sb.append(array2[array[i] & 0xF]);
        }
        return sb.toString();
    }
}
