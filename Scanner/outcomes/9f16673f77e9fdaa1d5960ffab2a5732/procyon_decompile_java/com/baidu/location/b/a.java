// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.b;

import java.util.Locale;

public class a
{
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public long g;
    public int h;
    public char i;
    public String j;
    private boolean k;
    
    public a() {
        final int h = -1;
        this.a = h;
        this.b = h;
        this.c = h;
        this.d = h;
        final int n = -1 >>> 1;
        this.e = n;
        this.f = n;
        this.g = 0L;
        this.h = h;
        this.i = '0';
        this.j = null;
        this.k = false;
        this.g = System.currentTimeMillis();
    }
    
    public a(final int a, final int b, final int c, final int d, final int h, final char i) {
        final int h2 = -1;
        this.a = h2;
        this.b = h2;
        this.c = h2;
        this.d = h2;
        final int n = -1 >>> 1;
        this.e = n;
        this.f = n;
        this.g = 0L;
        this.h = h2;
        this.i = '0';
        this.j = null;
        this.k = false;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.h = h;
        this.i = i;
        this.g = System.currentTimeMillis();
    }
    
    public a(final a a) {
        this(a.a, a.b, a.c, a.d, a.h, a.i);
        this.g = a.g;
    }
    
    public boolean a() {
        final long currentTimeMillis = System.currentTimeMillis();
        final long g = this.g;
        return currentTimeMillis - g > 0L && currentTimeMillis - g < 3000L;
    }
    
    public boolean a(final a a) {
        return this.a == a.a && this.b == a.b && this.d == a.d && this.c == a.c;
    }
    
    public boolean b() {
        return this.a > -1 && this.b > 0;
    }
    
    public boolean c() {
        final int a = this.a;
        final int n = -1;
        return a == n && this.b == n && this.d == n && this.c == n;
    }
    
    public boolean d() {
        final int a = this.a;
        final int n = -1;
        return a > n && this.b > n && this.d == n && this.c == n;
    }
    
    public boolean e() {
        final int a = this.a;
        final int n = -1;
        return a > n && this.b > n && this.d > n && this.c > n;
    }
    
    public void f() {
        this.k = true;
    }
    
    public String g() {
        final StringBuffer sb = new StringBuffer(128);
        sb.append("&nw=");
        sb.append(this.i);
        sb.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", this.c, this.d, this.a, this.b, this.h));
        if (this.k) {
            sb.append("&newcl=1");
        }
        return sb.toString();
    }
    
    public String h() {
        final StringBuffer sb = new StringBuffer(128);
        sb.append("&nw2=");
        sb.append(this.i);
        sb.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d", this.c, this.d, this.a, this.b, this.h));
        return sb.toString();
    }
}
