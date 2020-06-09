// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.android.bbalbs.common.a;

import java.security.spec.AlgorithmParameterSpec;
import java.security.Key;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class a
{
    public static byte[] a(final String s, final String s2, final byte[] array) {
        final SecretKeySpec secretKeySpec = new SecretKeySpec(s2.getBytes(), "AES");
        final Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, new IvParameterSpec(s.getBytes()));
        return instance.doFinal(array);
    }
    
    public static byte[] b(final String s, final String s2, final byte[] array) {
        final SecretKeySpec secretKeySpec = new SecretKeySpec(s2.getBytes(), "AES");
        final Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(s.getBytes()));
        return instance.doFinal(array);
    }
}
