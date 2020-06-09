// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.android.bbalbs.common.a;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public final class c
{
    public static String a(final byte[] array, final String s, final boolean b) {
        final StringBuilder sb = new StringBuilder();
        for (int length = array.length, i = 0; i < length; ++i) {
            String s2 = Integer.toHexString(array[i] & 0xFF);
            if (b) {
                s2 = s2.toUpperCase();
            }
            if (s2.length() == 1) {
                sb.append("0");
            }
            sb.append(s2);
            sb.append(s);
        }
        return sb.toString();
    }
    
    public static String a(byte[] digest, final boolean b) {
        final String s = "MD5";
        try {
            final MessageDigest instance = MessageDigest.getInstance(s);
            try {
                instance.reset();
                final MessageDigest messageDigest = instance;
                try {
                    messageDigest.update(digest);
                    digest = instance.digest();
                    return a(digest, "", b);
                }
                catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                }
            }
            catch (NoSuchAlgorithmException ex2) {}
        }
        catch (NoSuchAlgorithmException ex3) {}
    }
}
