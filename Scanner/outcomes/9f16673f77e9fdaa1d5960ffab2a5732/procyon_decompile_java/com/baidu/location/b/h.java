// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.b;

import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.os.Build$VERSION;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import com.baidu.location.f;
import java.util.List;
import android.net.wifi.ScanResult;
import com.baidu.location.a.a;
import android.os.Handler;
import android.net.wifi.WifiManager;

public class h
{
    public static long a;
    private static h b;
    private WifiManager c;
    private h$a d;
    private g e;
    private long f;
    private long g;
    private boolean h;
    private Handler i;
    private long j;
    private long k;
    
    static {
        h.b = null;
        h.a = 0L;
    }
    
    private h() {
        this.c = null;
        this.d = null;
        this.e = null;
        final long n = 0L;
        this.f = n;
        this.g = n;
        this.h = false;
        this.i = new Handler();
        this.j = n;
        this.k = n;
    }
    
    public static h a() {
        synchronized (h.class) {
            if (h.b == null) {
                h.b = new h();
            }
            return h.b;
        }
    }
    
    private String a(final long n) {
        final StringBuffer sb = new StringBuffer();
        final long n2 = 255L;
        sb.append(String.valueOf((int)(n & n2)));
        final char c = '.';
        sb.append(c);
        sb.append(String.valueOf((int)(n >> 8 & n2)));
        sb.append(c);
        sb.append(String.valueOf((int)(n >> 16 & n2)));
        sb.append(c);
        sb.append(String.valueOf((int)(n >> 24 & n2)));
        return sb.toString();
    }
    
    public static boolean a(final g g, final g g2) {
        boolean a = a(g, g2, 0.7f);
        final long n = System.currentTimeMillis() - com.baidu.location.a.a.c;
        if (n > 0L && n < 30000L && a && g2.f() - g.f() > 30) {
            a = false;
        }
        return a;
    }
    
    public static boolean a(final g g, final g g2, final float n) {
        if (g != null) {
            if (g2 != null) {
                final List a = g.a;
                final List a2 = g2.a;
                final boolean b = true;
                if (a == a2) {
                    return b;
                }
                if (a != null) {
                    if (a2 != null) {
                        final int size = a.size();
                        final int size2 = a2.size();
                        if (size == 0 && size2 == 0) {
                            return b;
                        }
                        if (size != 0) {
                            if (size2 != 0) {
                                int i = 0;
                                int n2 = 0;
                                while (i < size) {
                                    final String bssid = a.get(i).BSSID;
                                    if (bssid != null) {
                                        for (int j = 0; j < size2; ++j) {
                                            if (bssid.equals(a2.get(j).BSSID)) {
                                                ++n2;
                                                break;
                                            }
                                        }
                                    }
                                    ++i;
                                }
                                if (n2 >= size * n) {
                                    return b;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean i() {
        boolean b = false;
        try {
            final Object systemService = f.getServiceContext().getSystemService("connectivity");
            try {
                final ConnectivityManager connectivityManager = (ConnectivityManager)systemService;
                try {
                    final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    final boolean b2 = true;
                    if (activeNetworkInfo != null && activeNetworkInfo.getType() == (b2 ? 1 : 0)) {
                        b = true;
                        return b;
                    }
                    return b;
                }
                catch (Exception ex) {}
            }
            catch (Exception ex2) {}
        }
        catch (Exception ex3) {}
        return b;
    }
    
    private void r() {
        final WifiManager c = this.c;
        if (c == null) {
            return;
        }
        try {
            final List scanResults = c.getScanResults();
            if (scanResults != null) {
                final g e = new g(scanResults, System.currentTimeMillis());
                final g e2 = this.e;
                if (e2 == null || !e.a(e2)) {
                    this.e = e;
                }
            }
        }
        catch (Exception ex) {}
    }
    
    public void b() {
        this.j = 0L;
    }
    
    public void c() {
        // monitorenter(this)
        try {
            final boolean h = this.h;
            final boolean h2 = true;
            if (h == h2) {
                return;
            }
            if (!com.baidu.location.f.isServing) {
                return;
            }
            this.c = (WifiManager)com.baidu.location.f.getServiceContext().getApplicationContext().getSystemService("wifi");
            this.d = new h$a(this, null);
            try {
                final Context serviceContext = com.baidu.location.f.getServiceContext();
                try {
                    final h$a d = this.d;
                    try {
                        serviceContext.registerReceiver((BroadcastReceiver)d, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {
                    this.h = h2;
                }
                finally {
                }
                // monitorexit(this)
            }
            catch (Exception ex3) {}
        }
        finally {}
    }
    
    public void d() {
        synchronized (this) {
            if (!this.h) {
                return;
            }
            try {
                final Context serviceContext = com.baidu.location.f.getServiceContext();
                try {
                    serviceContext.unregisterReceiver((BroadcastReceiver)this.d);
                    com.baidu.location.b.h.a = 0L;
                }
                catch (Exception ex) {}
            }
            catch (Exception ex2) {}
            this.d = null;
            this.c = null;
            this.h = false;
        }
    }
    
    public boolean e() {
        final long currentTimeMillis = System.currentTimeMillis();
        final long g = this.g;
        if (currentTimeMillis - g > 0L && currentTimeMillis - g <= 5000L) {
            return false;
        }
        this.g = currentTimeMillis;
        this.b();
        return this.f();
    }
    
    public boolean f() {
        if (this.c == null) {
            return false;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final long f = this.f;
        if (currentTimeMillis - f > 0L) {
            final long n = currentTimeMillis - f;
            final long j = this.j;
            final long n2 = 5000L;
            if (n <= j + n2) {
                return false;
            }
            if (currentTimeMillis - com.baidu.location.b.h.a * 1000L <= j + n2) {
                return false;
            }
            if (i() && currentTimeMillis - this.f <= this.j + 10000L) {
                return false;
            }
        }
        return this.h();
    }
    
    public String g() {
        String s = "";
        final WifiManager c = this.c;
        if (c != null) {
            try {
                Label_0049: {
                    if (c.isWifiEnabled()) {
                        break Label_0049;
                    }
                    if (Build$VERSION.SDK_INT <= 17) {
                        return s;
                    }
                    final WifiManager c2 = this.c;
                    try {
                        if (c2.isScanAlwaysAvailable()) {
                            s = "&wifio=1";
                            return s;
                        }
                        return s;
                    }
                    catch (Exception ex) {
                        return s;
                    }
                    catch (NoSuchMethodError noSuchMethodError) {}
                }
            }
            catch (Exception ex2) {}
            catch (NoSuchMethodError noSuchMethodError2) {}
        }
        return s;
    }
    
    public boolean h() {
        final long n = System.currentTimeMillis() - this.k;
        if (n >= 0L && n <= 2000L) {
            return false;
        }
        this.k = System.currentTimeMillis();
        try {
            final WifiManager c = this.c;
            try {
                Label_0111: {
                    if (c.isWifiEnabled()) {
                        break Label_0111;
                    }
                    if (Build$VERSION.SDK_INT <= 17) {
                        return false;
                    }
                    final WifiManager c2 = this.c;
                    try {
                        if (!c2.isScanAlwaysAvailable()) {
                            return false;
                        }
                        final WifiManager c3 = this.c;
                        try {
                            c3.startScan();
                            this.f = System.currentTimeMillis();
                            return true;
                        }
                        catch (Exception ex) {
                            return false;
                        }
                        catch (NoSuchMethodError noSuchMethodError) {
                            return false;
                        }
                    }
                    catch (Exception ex2) {}
                    catch (NoSuchMethodError noSuchMethodError2) {}
                }
            }
            catch (Exception ex3) {}
            catch (NoSuchMethodError noSuchMethodError3) {}
        }
        catch (Exception ex4) {}
        catch (NoSuchMethodError noSuchMethodError4) {}
    }
    
    public boolean j() {
        boolean b = false;
        try {
            final WifiManager c = this.c;
            try {
                Label_0044: {
                    if (c.isWifiEnabled()) {
                        break Label_0044;
                    }
                    if (Build$VERSION.SDK_INT <= 17) {
                        return b;
                    }
                    final WifiManager c2 = this.c;
                    try {
                        if (!c2.isScanAlwaysAvailable()) {
                            return b;
                        }
                        if (i()) {
                            return false;
                        }
                        try {
                            final WifiManager c3 = this.c;
                            try {
                                if (new g(c3.getScanResults(), 0L).e()) {
                                    b = true;
                                }
                                return b;
                            }
                            catch (Exception ex) {
                                return false;
                            }
                            catch (NoSuchMethodError noSuchMethodError) {
                                return false;
                            }
                        }
                        catch (Exception ex2) {}
                        catch (NoSuchMethodError noSuchMethodError2) {}
                    }
                    catch (Exception ex3) {}
                    catch (NoSuchMethodError noSuchMethodError3) {}
                }
            }
            catch (Exception ex4) {}
            catch (NoSuchMethodError noSuchMethodError4) {}
        }
        catch (Exception ex5) {}
        catch (NoSuchMethodError noSuchMethodError5) {}
    }
    
    public WifiInfo k() {
        final WifiManager c = this.c;
        if (c == null) {
            return null;
        }
        try {
            final WifiInfo connectionInfo = c.getConnectionInfo();
            if (connectionInfo != null && connectionInfo.getBSSID() != null && connectionInfo.getRssi() > -100) {
                final String bssid = connectionInfo.getBSSID();
                if (bssid != null) {
                    final String replace = bssid.replace(":", "");
                    if ("000000000000".equals(replace) || "".equals(replace)) {
                        return null;
                    }
                }
                return connectionInfo;
            }
            return null;
        }
        catch (Error error) {
            return null;
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public String l() {
        final StringBuffer sb = new StringBuffer();
        final WifiInfo k = a().k();
        if (k != null && k.getBSSID() != null) {
            final String replace = k.getBSSID().replace(":", "");
            int rssi = k.getRssi();
            final String m = a().m();
            if (rssi < 0) {
                rssi = -rssi;
            }
            if (replace != null && rssi < 100) {
                sb.append("&wf=");
                sb.append(replace);
                sb.append(";");
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(rssi);
                sb2.append(";");
                sb.append(sb2.toString());
                String s = k.getSSID();
                if (s != null && (s.contains("&") || s.contains(";"))) {
                    s = s.replace("&", "_");
                }
                sb.append(s);
                sb.append("&wf_n=1");
                if (m != null) {
                    sb.append("&wf_gw=");
                    sb.append(m);
                }
                return sb.toString();
            }
        }
        return null;
    }
    
    public String m() {
        final WifiManager c = this.c;
        if (c != null) {
            final DhcpInfo dhcpInfo = c.getDhcpInfo();
            if (dhcpInfo != null) {
                return this.a(dhcpInfo.gateway);
            }
        }
        return null;
    }
    
    public g n() {
        final g e = this.e;
        if (e != null && e.i()) {
            return this.e;
        }
        return this.p();
    }
    
    public g o() {
        final g e = this.e;
        if (e != null && e.j()) {
            return this.e;
        }
        return this.p();
    }
    
    public g p() {
        final WifiManager c = this.c;
        if (c != null) {
            try {
                try {
                    final List scanResults = c.getScanResults();
                    try {
                        return new g(scanResults, this.f);
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {}
            }
            catch (Exception ex3) {}
        }
        return new g(null, 0L);
    }
    
    public String q() {
        String macAddress = null;
        try {
            final WifiManager c = this.c;
            try {
                final WifiInfo connectionInfo = c.getConnectionInfo();
                if (connectionInfo != null) {
                    macAddress = connectionInfo.getMacAddress();
                }
                return macAddress;
            }
            catch (Error error) {
                return null;
            }
            catch (Exception ex) {
                return null;
            }
        }
        catch (Error error2) {}
        catch (Exception ex2) {}
    }
}
