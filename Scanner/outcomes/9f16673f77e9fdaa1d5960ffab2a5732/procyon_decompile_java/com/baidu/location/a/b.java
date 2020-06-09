// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import android.os.Bundle;

public class b
{
    private static Object a;
    private static b b;
    private int c;
    
    static {
        com.baidu.location.a.b.a = new Object();
        com.baidu.location.a.b.b = null;
    }
    
    public b() {
        this.c = -1;
    }
    
    public static b a() {
        synchronized (com.baidu.location.a.b.a) {
            if (com.baidu.location.a.b.b == null) {
                com.baidu.location.a.b.b = new b();
            }
            return com.baidu.location.a.b.b;
        }
    }
    
    public void a(final int n, int c, final String s) {
        if (c != this.c) {
            this.c = c;
            final Bundle bundle = new Bundle();
            bundle.putInt("loctype", n);
            bundle.putInt("diagtype", c);
            bundle.putByteArray("diagmessage", s.getBytes());
            final a a = com.baidu.location.a.a.a();
            c = 303;
            a.a(bundle, c);
        }
    }
}
