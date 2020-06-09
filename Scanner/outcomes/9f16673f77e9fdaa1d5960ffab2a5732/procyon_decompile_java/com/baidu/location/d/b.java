// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.d;

import com.baidu.android.bbalbs.common.util.CommonParam;
import android.telephony.TelephonyManager;
import android.content.Context;
import android.os.Build$VERSION;
import java.util.Locale;
import com.baidu.location.a.m;
import android.os.Build;
import com.baidu.location.f;

public class b
{
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    private static b h;
    public String a;
    public String b;
    public String c;
    private boolean i;
    
    static {
        b.h = null;
        b.d = null;
        b.e = null;
        b.f = null;
        b.g = null;
    }
    
    private b() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.i = false;
        if (com.baidu.location.f.getServiceContext() != null) {
            this.a(com.baidu.location.f.getServiceContext());
        }
    }
    
    public static b a() {
        if (b.h == null) {
            b.h = new b();
        }
        return b.h;
    }
    
    public String a(final boolean b) {
        return this.a(b, null);
    }
    
    public String a(final boolean b, String s) {
        final StringBuffer sb = new StringBuffer(256);
        sb.append("&sdk=");
        sb.append(7.52f);
        if (b) {
            if (j.g.equals("all")) {
                sb.append("&addr=allj");
            }
            if (j.h || j.j || j.k || j.i) {
                sb.append("&sema=");
                if (j.h) {
                    sb.append("aptag|");
                }
                if (j.i) {
                    sb.append("aptagd|");
                }
                if (j.j) {
                    sb.append("poiregion|");
                }
                if (j.k) {
                    sb.append("regular");
                }
            }
        }
        if (b) {
            if (s == null) {
                s = "&coor=gcj02";
            }
            else {
                sb.append("&coor=");
            }
            sb.append(s);
        }
        s = this.b;
        Label_0369: {
            if (s == null) {
                s = "&im=";
            }
            else {
                sb.append("&cu=");
                s = this.b;
                sb.append(s);
                s = this.a;
                if (s == null || s.equals("NULL")) {
                    break Label_0369;
                }
                s = this.b;
                if (s.contains(new StringBuffer(this.a).reverse().toString())) {
                    break Label_0369;
                }
                s = "&Aim=";
            }
            sb.append(s);
            s = this.a;
            sb.append(s);
        }
        s = this.c;
        if (s != null) {
            sb.append("&Aid=");
            s = this.c;
            sb.append(s);
        }
        sb.append("&fw=");
        sb.append(com.baidu.location.f.getFrameVersion());
        sb.append("&lt=1");
        sb.append("&mb=");
        s = Build.MODEL;
        sb.append(s);
        s = j.b();
        if (s != null) {
            sb.append("&laip=");
            sb.append(s);
        }
        final float d = m.a().d();
        if (d != 0.0f) {
            sb.append("&altv=");
            s = String.format(Locale.US, "%.5f", d);
            sb.append(s);
        }
        sb.append("&resid=");
        sb.append("12");
        sb.append("&os=A");
        s = Build$VERSION.SDK;
        sb.append(s);
        if (b) {
            sb.append("&sv=");
            String s2 = Build$VERSION.RELEASE;
            if (s2 != null) {
                final int length = s2.length();
                final int n = 6;
                if (length > n) {
                    s2 = s2.substring(0, n);
                }
            }
            sb.append(s2);
        }
        return sb.toString();
    }
    
    public void a(final Context context) {
        if (context != null) {
            if (!this.i) {
                final String s = "phone";
                try {
                    final Object systemService = context.getSystemService(s);
                    try {
                        final TelephonyManager telephonyManager = (TelephonyManager)systemService;
                        try {
                            this.a = telephonyManager.getDeviceId();
                        }
                        catch (Exception ex) {
                            this.a = "NULL";
                        }
                    }
                    catch (Exception ex2) {}
                }
                catch (Exception ex3) {}
                try {
                    this.b = CommonParam.a(context);
                }
                catch (Exception ex4) {
                    this.b = null;
                }
                try {
                    this.c = com.baidu.android.bbalbs.common.util.b.b(context);
                }
                catch (Exception ex5) {
                    this.c = null;
                }
                try {
                    final String packageName = context.getPackageName();
                    try {
                        com.baidu.location.d.b.d = packageName;
                    }
                    catch (Exception ex6) {
                        com.baidu.location.d.b.d = null;
                    }
                }
                catch (Exception ex7) {}
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(this.b);
                j.n = sb.toString();
                this.i = true;
            }
        }
    }
    
    public void a(final String e, final String d) {
        com.baidu.location.d.b.e = e;
        com.baidu.location.d.b.d = d;
    }
    
    public String b() {
        StringBuilder sb;
        String s;
        if (this.b != null) {
            sb = new StringBuilder();
            sb.append("v7.52|");
            s = this.b;
        }
        else {
            sb = new StringBuilder();
            sb.append("v7.52|");
            s = this.a;
        }
        sb.append(s);
        sb.append("|");
        sb.append(Build.MODEL);
        return sb.toString();
    }
    
    public String c() {
        if (com.baidu.location.d.b.d != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.b());
            sb.append("|");
            sb.append(com.baidu.location.d.b.d);
            return sb.toString();
        }
        return this.b();
    }
}
