// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.d;

import android.net.ConnectivityManager;
import com.baidu.location.f;
import android.net.Proxy;
import android.net.NetworkInfo;
import android.content.Context;
import java.util.Map;

public abstract class e
{
    private static String a;
    private static int b;
    public static int g;
    protected static int o;
    public String h;
    public int i;
    public String j;
    public Map k;
    public String l;
    public byte[] m;
    public String n;
    
    static {
        e.g = com.baidu.location.d.a.g;
        e.a = "10.0.0.172";
        e.b = 80;
        e.o = 0;
    }
    
    public e() {
        this.h = null;
        this.i = 3;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
    }
    
    private static int a(final Context context, final NetworkInfo networkInfo) {
        while (true) {
            Label_0276: {
                Label_0252: {
                    Label_0215: {
                        if (networkInfo == null || networkInfo.getExtraInfo() == null) {
                            break Label_0215;
                        }
                        final String lowerCase = networkInfo.getExtraInfo().toLowerCase();
                        if (lowerCase == null) {
                            break Label_0215;
                        }
                        String a;
                        if (!lowerCase.startsWith("cmwap") && !lowerCase.startsWith("uniwap") && !lowerCase.startsWith("3gwap")) {
                            if (lowerCase.startsWith("ctwap")) {
                                a = Proxy.getDefaultHost();
                                if (a == null || a.equals("") || a.equals("null")) {
                                    break Label_0276;
                                }
                            }
                            else {
                                if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                                    return com.baidu.location.d.a.e;
                                }
                                break Label_0215;
                            }
                        }
                        else {
                            a = Proxy.getDefaultHost();
                            if (a == null || a.equals("") || a.equals("null")) {
                                break Label_0252;
                            }
                        }
                        e.a = a;
                        return com.baidu.location.d.a.d;
                    }
                    final String defaultHost = Proxy.getDefaultHost();
                    if (defaultHost != null && defaultHost.length() > 0) {
                        if ("10.0.0.172".equals(defaultHost.trim())) {
                            break Label_0252;
                        }
                        if ("10.0.0.200".equals(defaultHost.trim())) {
                            break Label_0276;
                        }
                    }
                    return com.baidu.location.d.a.e;
                }
                String a = "10.0.0.172";
                continue;
            }
            String a = "10.0.0.200";
            continue;
        }
    }
    
    private void b() {
        e.g = this.c();
    }
    
    private int c() {
        final Context serviceContext = f.getServiceContext();
        final String s = "connectivity";
        final Context context = serviceContext;
        try {
            final Object systemService = context.getSystemService(s);
            try {
                final ConnectivityManager connectivityManager = (ConnectivityManager)systemService;
                if (connectivityManager == null) {
                    return com.baidu.location.d.a.g;
                }
                final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || activeNetworkInfo.isAvailable()) {
                    return com.baidu.location.d.a.g;
                }
                if (activeNetworkInfo.getType() != 1) {
                    return a(serviceContext, activeNetworkInfo);
                }
                final String defaultHost = Proxy.getDefaultHost();
                if (defaultHost != null && defaultHost.length() > 0) {
                    return com.baidu.location.d.a.h;
                }
                return com.baidu.location.d.a.f;
            }
            catch (Exception ex) {
                return com.baidu.location.d.a.g;
            }
        }
        catch (Exception ex2) {}
    }
    
    public abstract void a();
    
    public abstract void a(final boolean p0);
    
    public void a(final boolean b, final String s) {
        new g(this, s, b).start();
    }
    
    public void b(final String s) {
        new h(this, s).start();
    }
    
    public void d() {
        new com.baidu.location.d.f(this).start();
    }
    
    public void e() {
        this.a(false, "loc.map.baidu.com");
    }
}
