// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import android.location.Location;
import com.baidu.location.b.a;

public class t
{
    private static long a;
    private static a b;
    private static Location c;
    private static String d;
    
    public static String a() {
        return t.d;
    }
    
    public static void a(final long a) {
        t.a = a;
    }
    
    public static void a(final Location c) {
        t.c = c;
    }
    
    public static void a(final a b) {
        t.b = b;
    }
    
    public static void a(final String d) {
        t.d = d;
    }
    
    public static long b() {
        return t.a;
    }
    
    public static a c() {
        return t.b;
    }
    
    public static Location d() {
        return t.c;
    }
}
