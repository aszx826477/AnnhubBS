// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import android.os.Build$VERSION;
import android.text.TextUtils;
import android.location.Location;
import com.baidu.location.f;
import android.os.Handler;
import com.baidu.location.b.a;
import com.baidu.location.b.g;
import android.os.Message;
import com.baidu.location.b.b;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import java.util.Locale;
import com.baidu.location.d.j;
import java.util.HashMap;
import com.baidu.location.d.e;

class i$b extends e
{
    String a;
    String b;
    final /* synthetic */ i c;
    
    public i$b(final i c) {
        this.c = c;
        this.a = null;
        this.b = null;
        this.k = new HashMap();
    }
    
    public void a() {
        this.h = com.baidu.location.d.j.c();
        final boolean h = com.baidu.location.d.j.h;
        final int n = 1;
        if ((h || com.baidu.location.d.j.i) && this.c.h != null && this.c.i != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.b);
            final Locale china = Locale.CHINA;
            final String s = "&ki=%s&sn=%s";
            final Object[] array = { this.c.h, null };
            array[n] = this.c.i;
            sb.append(String.format(china, s, array));
            this.b = sb.toString();
        }
        final String encodeTp4 = Jni.encodeTp4(this.b);
        this.b = null;
        if (this.a == null) {
            this.a = v.b();
        }
        this.k.put("bloc", encodeTp4);
        if (this.a != null) {
            this.k.put("up", this.a);
        }
        final Locale china2 = Locale.CHINA;
        final Object[] array2 = new Object[n];
        array2[0] = System.currentTimeMillis();
        this.k.put("trtm", String.format(china2, "%d", array2));
    }
    
    public void a(String f) {
        this.b = f;
        f = com.baidu.location.d.j.f;
        this.b(f);
    }
    
    public void a(final boolean b) {
        final int n = 63;
        Label_0289: {
            if (b && this.j != null) {
                try {
                    final String j = this.j;
                    try {
                        com.baidu.location.a.i.c = j;
                        Label_0138: {
                            BDLocation obj = null;
                            try {
                                obj = new BDLocation(j);
                                if (obj.getLocType() == 161) {
                                    com.baidu.location.a.h.a().a(j);
                                }
                                final b a = b.a();
                                try {
                                    obj.setOperators(a.h());
                                    final n a2 = com.baidu.location.a.n.a();
                                    try {
                                        if (!a2.d()) {
                                            break Label_0138;
                                        }
                                        final n a3 = com.baidu.location.a.n.a();
                                        try {
                                            obj.setDirection(a3.e());
                                        }
                                        catch (Exception ex) {
                                            obj = new(com.baidu.location.BDLocation.class);
                                            final BDLocation bdLocation = obj;
                                            new BDLocation();
                                            final BDLocation bdLocation2 = obj;
                                            final int n2 = 0;
                                            bdLocation2.setLocType(n2);
                                        }
                                    }
                                    catch (Exception ex2) {}
                                }
                                catch (Exception ex3) {}
                            }
                            catch (Exception ex4) {}
                            try {
                                final BDLocation bdLocation = obj;
                                new BDLocation();
                                final BDLocation bdLocation2 = obj;
                                final int n2 = 0;
                                bdLocation2.setLocType(n2);
                                this.a = null;
                                Label_0232: {
                                    if (obj.getLocType() != 0) {
                                        break Label_0232;
                                    }
                                    final double latitude = obj.getLatitude();
                                    final double n3 = Double.MIN_VALUE;
                                    if (latitude != n3 || obj.getLongitude() != n3) {
                                        break Label_0232;
                                    }
                                    final i c = this.c;
                                    try {
                                        Message message = c.d.obtainMessage(n);
                                        message.obj = "HttpStatus error";
                                        message.sendToTarget();
                                        break Label_0289;
                                        final i c2 = this.c;
                                        try {
                                            message = c2.d.obtainMessage(21);
                                            message.obj = obj;
                                        }
                                        catch (Exception ex5) {}
                                    }
                                    catch (Exception ex6) {}
                                }
                            }
                            catch (Exception ex7) {}
                        }
                    }
                    catch (Exception ex8) {}
                }
                catch (Exception ex9) {}
            }
            final Message obtainMessage = this.c.d.obtainMessage(n);
            obtainMessage.obj = "HttpStatus error";
            obtainMessage.sendToTarget();
        }
        if (this.k != null) {
            this.k.clear();
        }
    }
}
