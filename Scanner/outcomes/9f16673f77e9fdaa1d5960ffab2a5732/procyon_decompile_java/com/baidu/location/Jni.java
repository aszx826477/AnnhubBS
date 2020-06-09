// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location;

public class Jni
{
    private static int a;
    private static int b;
    private static int c;
    private static int d;
    private static int e;
    private static int f;
    private static int g;
    private static int h;
    private static int i;
    private static boolean j;
    
    static {
        Jni.a = 0;
        final int j = Jni.b = 1;
        Jni.c = 2;
        Jni.d = 11;
        Jni.e = 12;
        Jni.f = 13;
        Jni.g = 14;
        Jni.h = 15;
        Jni.i = 1024;
        Jni.j = false;
        final String s = "locSDK7b";
        try {
            System.loadLibrary(s);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            unsatisfiedLinkError.printStackTrace();
            Jni.j = (j != 0);
        }
    }
    
    private static native String a(final byte[] p0, final int p1);
    
    private static native String b(final double p0, final double p1, final int p2, final int p3);
    
    private static native String c(final byte[] p0, final int p1);
    
    public static double[] coorEncrypt(final double n, double n2, final String s) {
        final double[] array2;
        final double[] array = array2 = new double[2];
        array2[1] = (array2[0] = 0.0);
        if (Jni.j) {
            return array;
        }
        int n3 = -1;
        if (s.equals("bd09")) {
            n3 = Jni.a;
        }
        else if (s.equals("bd09ll")) {
            n3 = Jni.b;
        }
        else if (s.equals("gcj02")) {
            n3 = Jni.c;
        }
        else if (s.equals("gps2gcj")) {
            n3 = Jni.d;
        }
        else if (s.equals("bd092gcj")) {
            n3 = Jni.e;
        }
        else if (s.equals("bd09ll2gcj")) {
            n3 = Jni.f;
        }
        else if (s.equals("wgs842mc")) {
            n3 = Jni.h;
        }
        int n4;
        if (s.equals("gcj2wgs")) {
            n4 = 16;
        }
        else {
            n4 = n3;
        }
        final int n5 = 132456;
        final double n6 = n2;
        final int n7 = n4;
        try {
            final String[] split = b(n, n6, n7, n5).split(":");
            final String s2 = split[0];
            try {
                n2 = Double.parseDouble(s2);
                array[0] = n2;
                final int n8 = 1;
                final String s3 = split[n8];
                try {
                    n2 = Double.parseDouble(s3);
                    array[n8] = n2;
                }
                catch (UnsatisfiedLinkError unsatisfiedLinkError) {}
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError2) {}
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError3) {}
        return array;
    }
    
    private static native String ee(final String p0, final int p1);
    
    public static String en1(String a) {
        if (Jni.j) {
            return "err!";
        }
        if (a == null) {
            return "null";
        }
        final byte[] bytes = a.getBytes();
        final byte[] array = new byte[Jni.i];
        int length = bytes.length;
        if (length > 740) {
            length = 740;
        }
        int i = 0;
        int n = 0;
        while (i < length) {
            if (bytes[i] != 0) {
                array[n] = bytes[i];
                ++n;
            }
            ++i;
        }
        final int n2 = 132456;
        final byte[] array2 = array;
        try {
            a = a(array2, n2);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            unsatisfiedLinkError.printStackTrace();
            a = "err!";
        }
        return a;
    }
    
    public static String encode(String en1) {
        if (Jni.j) {
            return "err!";
        }
        final StringBuilder sb = new StringBuilder();
        en1 = en1(en1);
        sb.append(en1);
        sb.append("|tp=3");
        return sb.toString();
    }
    
    public static String encode2(String c) {
        if (Jni.j) {
            return "err!";
        }
        if (c == null) {
            return "null";
        }
        final byte[] bytes = c.getBytes();
        final int n = 132456;
        final byte[] array = bytes;
        try {
            c = c(array, n);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            unsatisfiedLinkError.printStackTrace();
            c = "err!";
        }
        return c;
    }
    
    public static Long encode3(final String s) {
        final boolean j = Jni.j;
        Long value = null;
        if (j) {
            return null;
        }
        String s2 = "";
        try {
            try {
                s2 = new String(s.getBytes(), "UTF-8");
            }
            catch (Exception ex) {}
        }
        catch (Exception ex2) {}
        try {
            final long murmur = murmur(s2);
            try {
                value = murmur;
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                unsatisfiedLinkError.printStackTrace();
            }
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError2) {}
        return value;
    }
    
    private static native String encodeNotLimit(final String p0, final int p1);
    
    public static String encodeOfflineLocationUpdateRequest(String encodeNotLimit) {
        if (Jni.j) {
            return "err!";
        }
        String s = "";
        try {
            try {
                s = new String(encodeNotLimit.getBytes(), "UTF-8");
            }
            catch (Exception ex) {}
        }
        catch (Exception ex2) {}
        final int n = 132456;
        final String s2 = s;
        try {
            encodeNotLimit = encodeNotLimit(s2, n);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            unsatisfiedLinkError.printStackTrace();
            encodeNotLimit = "err!";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(encodeNotLimit);
        sb.append("|tp=3");
        return sb.toString();
    }
    
    public static String encodeTp4(String ee) {
        if (Jni.j) {
            return "err!";
        }
        String s = "";
        try {
            try {
                s = new String(ee.getBytes(), "UTF-8");
            }
            catch (Exception ex) {}
        }
        catch (Exception ex2) {}
        final int n = 132456;
        final String s2 = s;
        try {
            ee = ee(s2, n);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            unsatisfiedLinkError.printStackTrace();
            ee = "err!";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(ee);
        sb.append("|tp=4");
        return sb.toString();
    }
    
    public static double getGpsSwiftRadius(final float n, final double n2, final double n3) {
        final boolean j = Jni.j;
        double gsr = 0.0;
        if (j) {
            return gsr;
        }
        try {
            gsr = gsr(n, n2, n3);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {}
        return gsr;
    }
    
    private static native double gsr(final float p0, final double p1, final double p2);
    
    private static native long murmur(final String p0);
}
