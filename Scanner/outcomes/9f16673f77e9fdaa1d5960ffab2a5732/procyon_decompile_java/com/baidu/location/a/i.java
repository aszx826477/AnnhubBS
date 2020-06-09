// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import android.os.Build$VERSION;
import android.text.TextUtils;
import java.util.Locale;
import android.os.Message;
import android.location.Location;
import com.baidu.location.b.e;
import com.baidu.location.b.h;
import com.baidu.location.b.b;
import com.baidu.location.f;
import android.os.Handler;
import com.baidu.location.b.a;
import com.baidu.location.b.g;

public abstract class i
{
    public static String c;
    public g a;
    public a b;
    final Handler d;
    private boolean e;
    private boolean f;
    private boolean g;
    private String h;
    private String i;
    
    static {
        i.c = null;
    }
    
    public i() {
        this.a = null;
        this.b = null;
        final boolean b = true;
        this.e = b;
        this.f = b;
        this.g = false;
        this.d = new i$a(this);
        this.h = null;
        this.i = null;
    }
    
    public String a(String s) {
        s = this.h;
        if (s == null) {
            s = j.b(com.baidu.location.f.getServiceContext());
            this.h = s;
        }
        s = this.i;
        if (s == null) {
            s = j.c(com.baidu.location.f.getServiceContext());
            this.i = s;
        }
        final a b = this.b;
        if (b == null || !b.a()) {
            this.b = com.baidu.location.b.b.a().f();
        }
        final g a = this.a;
        if (a == null || !a.i()) {
            this.a = com.baidu.location.b.h.a().o();
        }
        Location g;
        if (com.baidu.location.b.e.a().i()) {
            g = com.baidu.location.b.e.a().g();
        }
        else {
            g = null;
        }
        final a b2 = this.b;
        if (b2 == null || b2.d() || this.b.c()) {
            final g a2 = this.a;
            if ((a2 == null || a2.a() == 0) && g == null) {
                return null;
            }
        }
        s = this.b();
        if (com.baidu.location.a.h.a().d() == -2) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("&imo=1");
            s = sb.toString();
        }
        final int b3 = com.baidu.location.d.j.b(com.baidu.location.f.getServiceContext());
        if (b3 >= 0) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append("&lmd=");
            sb2.append(b3);
            s = sb2.toString();
        }
        final g a3 = this.a;
        if (a3 == null || a3.a() == 0) {
            final String l = com.baidu.location.b.h.a().l();
            if (l != null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(l);
                sb3.append(s);
                s = sb3.toString();
            }
        }
        final String s2 = s;
        if (this.f) {
            this.f = false;
            return com.baidu.location.d.j.a(this.b, this.a, g, s, 0, true);
        }
        return com.baidu.location.d.j.a(this.b, this.a, g, s2, 0);
    }
    
    public abstract void a();
    
    public abstract void a(final Message p0);
    
    public String b() {
        final String c = com.baidu.location.a.a.a().c();
        final boolean i = com.baidu.location.b.h.i();
        final int g = 1;
        String s;
        if (i) {
            s = "&cn=32";
        }
        else {
            final Locale china = Locale.CHINA;
            final String s2 = "&cn=%d";
            final Object[] array = new Object[g];
            array[0] = com.baidu.location.b.b.a().e();
            s = String.format(china, s2, array);
        }
        if (this.e) {
            this.e = false;
            final String q = com.baidu.location.b.h.a().q();
            if (!TextUtils.isEmpty((CharSequence)q) && !q.equals("02:00:00:00:00:00")) {
                final String replace = q.replace(":", "");
                final Locale china2 = Locale.CHINA;
                final String s3 = "%s&mac=%s";
                final Object[] array2 = { s, null };
                array2[g] = replace;
                s = String.format(china2, s3, array2);
            }
            final int sdk_INT = Build$VERSION.SDK_INT;
        }
        else if (!this.g) {
            final String f = v.f();
            if (f != null) {
                final StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.append(f);
                s = sb.toString();
            }
            this.g = (g != 0);
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(s);
        sb2.append(c);
        return sb2.toString();
    }
}
