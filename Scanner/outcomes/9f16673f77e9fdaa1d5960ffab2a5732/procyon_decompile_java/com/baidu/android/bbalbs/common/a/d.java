// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.android.bbalbs.common.a;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public final class d
{
    public static byte[] a(final byte[] array) {
        final String s = "SHA-1";
        try {
            return MessageDigest.getInstance(s).digest(array);
        }
        catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
}
