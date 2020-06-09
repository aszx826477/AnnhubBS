// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import com.baidu.location.d.a;
import org.json.JSONObject;
import java.util.Map;
import java.util.Locale;
import com.baidu.location.d.j;
import java.util.HashMap;
import java.util.ArrayList;
import com.baidu.location.d.e;

class v$a extends e
{
    boolean a;
    int b;
    int c;
    final /* synthetic */ v d;
    private ArrayList e;
    private boolean f;
    
    public v$a(final v d) {
        this.d = d;
        this.a = false;
        this.b = 0;
        this.c = 0;
        this.e = new ArrayList();
        this.f = true;
        this.k = new HashMap();
    }
    
    public void a() {
        this.h = com.baidu.location.d.j.c();
        final int b = this.b;
        final int n = 1;
        if (b != n) {
            this.h = com.baidu.location.d.j.e();
        }
        this.i = 2;
        if (this.e != null) {
            for (int i = 0; i < this.e.size(); ++i) {
                Map map;
                StringBuilder sb;
                String s;
                if (this.b == n) {
                    map = this.k;
                    sb = new StringBuilder();
                    s = "cldc[";
                }
                else {
                    map = this.k;
                    sb = new StringBuilder();
                    s = "cltr[";
                }
                sb.append(s);
                sb.append(i);
                sb.append("]");
                map.put(sb.toString(), this.e.get(i));
            }
            final Locale china = Locale.CHINA;
            final Object[] array = new Object[n];
            array[0] = System.currentTimeMillis();
            this.k.put("trtm", String.format(china, "%d", array));
            if (this.b != n) {
                this.k.put("qt", "cltrg");
            }
        }
    }
    
    public void a(final boolean b) {
        if (b && this.j != null) {
            final ArrayList e = this.e;
            if (e != null) {
                e.clear();
            }
            try {
                try {
                    final JSONObject jsonObject = new JSONObject(this.j);
                    if (jsonObject.has("ison") && jsonObject.getInt("ison") == 0) {
                        this.f = false;
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            catch (Exception ex2) {}
        }
        if (this.k != null) {
            this.k.clear();
        }
        this.a = false;
    }
    
    public void b() {
        // monitorenter(this)
        try {
            if (this.a) {
                return;
            }
            final int o = v$a.o;
            final int n = 4;
            final int n2 = 1;
            if (o > n && this.c < v$a.o) {
                this.c += n2;
                return;
            }
            this.c = 0;
            this.a = (n2 != 0);
            this.b = 0;
            try {
                Label_0104: {
                    if (this.e == null) {
                        break Label_0104;
                    }
                    final ArrayList e = this.e;
                    try {
                        Label_0293: {
                            if (e.size() >= n2) {
                                break Label_0293;
                            }
                            Label_0131: {
                                if (this.e != null) {
                                    break Label_0131;
                                }
                                try {
                                    final ArrayList e2 = new ArrayList();
                                    try {
                                        this.e = e2;
                                        try {
                                            this.b = 0;
                                            int n3 = 0;
                                            while (true) {
                                                final int b = this.b;
                                                final int b2 = 2;
                                                String b3 = null;
                                                String b4;
                                                if (b < b2) {
                                                    b4 = v.b();
                                                }
                                                else {
                                                    b4 = null;
                                                }
                                                if (b4 == null && this.b != n2 && this.f) {
                                                    this.b = b2;
                                                    try {
                                                        b3 = com.baidu.location.a.g.b();
                                                    }
                                                    catch (Exception ex) {}
                                                }
                                                else {
                                                    this.b = n2;
                                                    b3 = b4;
                                                }
                                                if (b3 == null) {
                                                    break;
                                                }
                                                if (b3.contains("err!")) {
                                                    continue;
                                                }
                                                this.e.add(b3);
                                                n3 += b3.length();
                                                if (n3 >= com.baidu.location.d.a.i) {
                                                    break;
                                                }
                                            }
                                            Label_0359: {
                                                if (this.e == null) {
                                                    break Label_0359;
                                                }
                                                final ArrayList e3 = this.e;
                                                try {
                                                    if (e3.size() >= n2) {
                                                        String s;
                                                        if (this.b != n2) {
                                                            s = com.baidu.location.d.j.e();
                                                        }
                                                        else {
                                                            s = com.baidu.location.d.j.f;
                                                        }
                                                        this.b(s);
                                                        return;
                                                    }
                                                    final ArrayList e4 = this.e;
                                                    try {
                                                        e4.clear();
                                                        try {
                                                            this.a = false;
                                                        }
                                                        catch (Exception ex2) {
                                                            if (this.e != null) {
                                                                this.e.clear();
                                                            }
                                                        }
                                                    }
                                                    catch (Exception ex3) {}
                                                }
                                                catch (Exception ex4) {}
                                            }
                                        }
                                        catch (Exception ex5) {}
                                    }
                                    catch (Exception ex6) {}
                                }
                                catch (Exception ex7) {}
                            }
                        }
                    }
                    catch (Exception ex8) {}
                    finally {
                    }
                    // monitorexit(this)
                }
            }
            catch (Exception ex9) {}
        }
        finally {}
    }
}
