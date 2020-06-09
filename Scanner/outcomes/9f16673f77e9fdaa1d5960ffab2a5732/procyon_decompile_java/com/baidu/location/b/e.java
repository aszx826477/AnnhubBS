// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.b;

import com.baidu.location.Jni;
import android.os.Bundle;
import android.util.Log;
import android.location.LocationListener;
import android.location.GnssStatus$Callback;
import android.location.GpsStatus$Listener;
import com.baidu.location.f;
import java.util.Iterator;
import com.baidu.location.d.d;
import com.baidu.location.a.v;
import com.baidu.location.a.t;
import com.baidu.location.a.a;
import com.baidu.location.d.b;
import com.baidu.location.d.j;
import java.util.Locale;
import android.os.Build$VERSION;
import android.os.Handler;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import android.content.Context;
import java.util.ArrayList;

public class e
{
    private static double C;
    private static String D;
    private static e c;
    private static int m;
    private static int n;
    private static String u;
    private int A;
    private int B;
    private long E;
    private ArrayList F;
    private final long a;
    private final long b;
    private Context d;
    private LocationManager e;
    private Location f;
    private e$c g;
    private e$d h;
    private GpsStatus i;
    private e$a j;
    private boolean k;
    private e$b l;
    private long o;
    private boolean p;
    private boolean q;
    private String r;
    private boolean s;
    private long t;
    private Handler v;
    private final int w;
    private final int x;
    private final int y;
    private final int z;
    
    static {
        e.c = null;
        e.m = 0;
        e.n = 0;
        e.u = null;
        e.C = 100.0;
        e.D = "";
    }
    
    private e() {
        this.a = 1000L;
        this.b = 9000L;
        this.e = null;
        this.g = null;
        this.h = null;
        this.k = false;
        this.l = null;
        final long e = 0L;
        this.o = e;
        this.p = false;
        this.q = false;
        this.r = null;
        this.s = false;
        this.t = e;
        this.v = null;
        final boolean b = true;
        this.w = (b ? 1 : 0);
        this.x = 2;
        this.y = 3;
        this.z = 4;
        this.E = e;
        this.F = new ArrayList();
        if (Build$VERSION.SDK_INT >= 24) {
            final String s = "android.location.GnssStatus";
            try {
                Class.forName(s);
                try {
                    this.k = b;
                }
                catch (ClassNotFoundException ex) {
                    this.k = false;
                }
            }
            catch (ClassNotFoundException ex2) {}
        }
    }
    
    public static e a() {
        synchronized (e.class) {
            if (e.c == null) {
                e.c = new e();
            }
            return e.c;
        }
    }
    
    public static String a(final Location location) {
        String format;
        if (location == null) {
            format = null;
        }
        else {
            final double n = location.getSpeed();
            final double n2 = 3.6;
            Double.isNaN(n);
            float n3 = (float)(n * n2);
            final boolean hasSpeed = location.hasSpeed();
            float bearing = -1.0f;
            if (!hasSpeed) {
                n3 = -1.0f;
            }
            float accuracy;
            if (location.hasAccuracy()) {
                accuracy = location.getAccuracy();
            }
            else {
                accuracy = -1.0f;
            }
            final int n4 = (int)accuracy;
            double altitude;
            if (location.hasAltitude()) {
                altitude = location.getAltitude();
            }
            else {
                altitude = 555.0;
            }
            if (location.hasBearing()) {
                bearing = location.getBearing();
            }
            format = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d&ll_snr=%.1f", location.getLongitude(), location.getLatitude(), n3, bearing, n4, e.m, altitude, location.getTime() / 1000L, e.m, e.n, e.C);
        }
        return format;
    }
    
    private void a(final double q, final double r, final float n) {
        int u = 0;
        Label_0345: {
            if (q >= 73.146973 && q <= 135.252686 && r <= 54.258807 && r >= 14.604847) {
                if (n <= 18.0f) {
                    final double n2 = q - com.baidu.location.d.j.s;
                    final double n3 = com.baidu.location.d.j.t - r;
                    final double n4 = 1000.0;
                    final int n5 = (int)(n2 * n4);
                    final int n6 = (int)(n3 * n4);
                    final int n7 = 2;
                    if (n5 > 0) {
                        final int n8 = 50;
                        if (n5 < n8 && n6 > 0 && n6 < n8) {
                            final int n9 = n6 * 50 + n5;
                            final int n10 = n9 >> 2;
                            final int n11 = n9 & 0x3;
                            if (com.baidu.location.d.j.w) {
                                u = (com.baidu.location.d.j.v[n10] >> n11 * 2 & 0x3);
                            }
                            break Label_0345;
                        }
                    }
                    final Locale china = Locale.CHINA;
                    final Object[] array = new Object[n7];
                    array[0] = q;
                    array[1] = r;
                    final String format = String.format(china, "&ll=%.5f|%.5f", array);
                    final StringBuilder sb = new StringBuilder();
                    sb.append(format);
                    sb.append("&im=");
                    sb.append(com.baidu.location.d.b.a().b());
                    sb.toString();
                    com.baidu.location.d.j.q = q;
                    com.baidu.location.d.j.r = r;
                }
            }
        }
        if (com.baidu.location.d.j.u != u) {
            com.baidu.location.d.j.u = u;
        }
    }
    
    private void a(String s, final Location location) {
        if (location == null) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        s = com.baidu.location.a.a.a().c();
        sb.append(s);
        s = sb.toString();
        final boolean e = com.baidu.location.b.h.a().e();
        com.baidu.location.a.t.a(new com.baidu.location.b.a(com.baidu.location.b.b.a().f()));
        com.baidu.location.a.t.a(System.currentTimeMillis());
        com.baidu.location.a.t.a(new Location(location));
        com.baidu.location.a.t.a(s);
        if (!e) {
            com.baidu.location.a.v.a(com.baidu.location.a.t.c(), null, com.baidu.location.a.t.d(), s);
        }
    }
    
    public static boolean a(final Location location, final Location location2, final boolean b) {
        boolean b2 = false;
        if (location == location2) {
            return false;
        }
        final boolean b3 = true;
        if (location == null || location2 == null) {
            return b3;
        }
        final float speed = location2.getSpeed();
        final float n = 5.0f;
        if (b && (j.u == 3 || !d.a().a(location2.getLongitude(), location2.getLatitude())) && speed < n) {
            return b3;
        }
        final float distanceTo = location2.distanceTo(location);
        if (speed > j.K) {
            if (distanceTo > j.M) {
                b2 = true;
            }
            return b2;
        }
        if (speed > j.J) {
            if (distanceTo > j.L) {
                b2 = true;
            }
            return b2;
        }
        if (distanceTo > n) {
            b2 = true;
        }
        return b2;
    }
    
    public static String b(final Location location) {
        String s = a(location);
        if (s != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("&g_tp=0");
            s = sb.toString();
        }
        return s;
    }
    
    private void b(final boolean s) {
        this.s = s;
        if (!s || !this.i()) {}
    }
    
    public static String c(final Location location) {
        String s = a(location);
        if (s != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(e.u);
            s = sb.toString();
        }
        return s;
    }
    
    private void d(final Location location) {
        this.v.sendMessage(this.v.obtainMessage(1, (Object)location));
    }
    
    private void e(Location f) {
        if (f == null) {
            this.f = null;
            return;
        }
        int n = com.baidu.location.b.e.m;
        if (n == 0) {
            try {
                n = f.getExtras().getInt("satellites");
            }
            catch (Exception ex) {}
        }
        if (n == 0 && !com.baidu.location.d.j.l) {
            return;
        }
        this.f = f;
        int n2 = com.baidu.location.b.e.m;
        final Location f2 = this.f;
        final int n3 = 2;
        final int n4 = 1;
        Location location;
        if (f2 == null) {
            this.r = null;
            location = null;
        }
        else {
            location = new Location(f2);
            final long currentTimeMillis = System.currentTimeMillis();
            this.f.setTime(currentTimeMillis);
            final double n5 = this.f.getSpeed();
            final double n6 = 3.6;
            Double.isNaN(n5);
            final float n7 = (float)(n5 * n6);
            float n8;
            if (!this.f.hasSpeed()) {
                n8 = -1.0f;
            }
            else {
                n8 = n7;
            }
            if (n2 == 0) {
                try {
                    final Location f3 = this.f;
                    try {
                        n2 = f3.getExtras().getInt("satellites");
                    }
                    catch (Exception ex2) {}
                }
                catch (Exception ex3) {}
            }
            final Locale china = Locale.CHINA;
            final Object[] array = new Object[6];
            array[0] = this.f.getLongitude();
            array[n4] = this.f.getLatitude();
            array[n3] = n8;
            array[3] = this.f.getBearing();
            array[4] = n2;
            array[5] = currentTimeMillis;
            this.r = String.format(china, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", array);
            final double longitude = this.f.getLongitude();
            f = this.f;
            this.a(longitude, f.getLatitude(), n8);
        }
        try {
            final com.baidu.location.a.g a = com.baidu.location.a.g.a();
            try {
                a.a(this.f);
            }
            catch (Exception ex4) {}
        }
        catch (Exception ex5) {}
        if (location != null) {
            com.baidu.location.a.d.a().a(location);
        }
        if (this.i()) {
            f = this.f;
            if (f != null) {
                com.baidu.location.b.e.D = this.j();
                com.baidu.location.a.a.a().a(this.f());
                if (com.baidu.location.b.e.m > n3) {
                    f = this.f;
                    if (com.baidu.location.a.v.a(f, n4 != 0)) {
                        final boolean e = com.baidu.location.b.h.a().e();
                        com.baidu.location.a.t.a(new com.baidu.location.b.a(com.baidu.location.b.b.a().f()));
                        com.baidu.location.a.t.a(System.currentTimeMillis());
                        com.baidu.location.a.t.a(new Location(this.f));
                        com.baidu.location.a.t.a(com.baidu.location.a.a.a().c());
                        if (!e) {
                            com.baidu.location.a.v.a(com.baidu.location.a.t.c(), null, com.baidu.location.a.t.d(), com.baidu.location.a.a.a().c());
                        }
                    }
                }
            }
        }
    }
    
    private String j() {
        final StringBuilder sb = new StringBuilder();
        if (this.F.size() <= 32 && this.F.size() != 0) {
            final Iterator<ArrayList<Object>> iterator = (Iterator<ArrayList<Object>>)this.F.iterator();
            final int n = 1;
            int n2 = 1;
            while (iterator.hasNext()) {
                final ArrayList<Object> list = iterator.next();
                if (list.size() != 5) {
                    continue;
                }
                if (n2 != 0) {
                    n2 = 0;
                }
                else {
                    sb.append("|");
                }
                final Object[] array = new Object[n];
                array[0] = list.get(0);
                sb.append(String.format("%.1f;", array));
                final Object[] array2 = new Object[n];
                final int n3 = 2;
                array2[0] = list.get(n3);
                sb.append(String.format("%.1f;", array2));
                final Object[] array3 = new Object[n];
                array3[0] = list.get(n3);
                sb.append(String.format("%.0f;", array3));
                final Object[] array4 = new Object[n];
                array4[0] = list.get(3);
                sb.append(String.format("%.0f;", array4));
                final String s = "%.0f";
                final Object[] array5 = new Object[n];
                array5[0] = list.get(4);
                sb.append(String.format(s, array5));
            }
            return sb.toString();
        }
        return sb.toString();
    }
    
    public void a(final boolean b) {
        if (b) {
            this.c();
        }
        else {
            this.d();
        }
    }
    
    public void b() {
        // monitorenter(this)
        try {
            if (!com.baidu.location.f.isServing) {
                return;
            }
            this.d = com.baidu.location.f.getServiceContext();
            try {
                final Object systemService = this.d.getSystemService("location");
                try {
                    this.e = (LocationManager)systemService;
                    Label_0094: {
                        if (this.k) {
                            break Label_0094;
                        }
                        final e$b l = new e$b(this, null);
                        try {
                            this.l = l;
                            final LocationManager e = this.e;
                            try {
                                e.addGpsStatusListener((GpsStatus$Listener)this.l);
                                Label_0127: {
                                    break Label_0127;
                                    final e$a j = new e$a(this, null);
                                    try {
                                        this.j = j;
                                        final LocationManager e2 = this.e;
                                        try {
                                            e2.registerGnssStatusCallback((GnssStatus$Callback)this.j);
                                            final e$d h = new e$d(this, null);
                                            try {
                                                this.h = h;
                                                this.e.requestLocationUpdates("passive", 9000L, 0.0f, (LocationListener)this.h);
                                            }
                                            catch (Exception ex) {}
                                        }
                                        catch (Exception ex2) {
                                            this.v = new com.baidu.location.b.f(this);
                                        }
                                    }
                                    catch (Exception ex3) {}
                                }
                            }
                            catch (Exception ex4) {}
                        }
                        catch (Exception ex5) {}
                    }
                }
                catch (Exception ex6) {}
                finally {
                }
                // monitorexit(this)
            }
            catch (Exception ex7) {}
        }
        finally {}
    }
    
    public void c() {
        Log.d(com.baidu.location.d.a.a, "start gps...");
        if (this.q) {
            return;
        }
        try {
            final e$c g = new e$c(this, null);
            try {
                this.g = g;
                try {
                    try {
                        this.e.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {}
                this.e.requestLocationUpdates("gps", 1000L, 0.0f, (LocationListener)this.g);
                this.E = System.currentTimeMillis();
                this.q = true;
            }
            catch (Exception ex3) {}
        }
        catch (Exception ex4) {}
    }
    
    public void d() {
        if (!this.q) {
            return;
        }
        final LocationManager e = this.e;
        if (e != null) {
            try {
                if (this.g != null) {
                    e.removeUpdates((LocationListener)this.g);
                }
            }
            catch (Exception ex) {}
        }
        com.baidu.location.d.j.d = 0;
        com.baidu.location.d.j.u = 0;
        this.g = null;
        this.b(this.q = false);
    }
    
    public void e() {
        // monitorenter(this)
        try {
            this.d();
            if (this.e == null) {
                return;
            }
            try {
                Label_0042: {
                    if (this.l == null) {
                        break Label_0042;
                    }
                    final LocationManager e = this.e;
                    try {
                        e.removeGpsStatusListener((GpsStatus$Listener)this.l);
                        Label_0075: {
                            if (!this.k || this.j == null) {
                                break Label_0075;
                            }
                            final LocationManager e2 = this.e;
                            try {
                                e2.unregisterGnssStatusCallback((GnssStatus$Callback)this.j);
                                final LocationManager e3 = this.e;
                                try {
                                    e3.removeUpdates((LocationListener)this.h);
                                }
                                catch (Exception ex) {}
                            }
                            catch (Exception ex2) {
                                this.l = null;
                                this.e = null;
                            }
                        }
                    }
                    catch (Exception ex3) {}
                    finally {
                    }
                    // monitorexit(this)
                }
            }
            catch (Exception ex4) {}
        }
        finally {}
    }
    
    public String f() {
        String string2;
        if (this.f != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("{\"result\":{\"time\":\"");
            sb.append(com.baidu.location.d.j.a());
            sb.append("\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":");
            sb.append("\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",");
            sb.append("\"s\":\"%f\",\"n\":\"%d\"");
            final String string = sb.toString();
            float accuracy;
            if (this.f.hasAccuracy()) {
                accuracy = this.f.getAccuracy();
            }
            else {
                accuracy = 10.0f;
            }
            final int n = (int)accuracy;
            final double n2 = this.f.getSpeed();
            final double n3 = 3.6;
            Double.isNaN(n2);
            float n4 = (float)(n2 * n3);
            if (!this.f.hasSpeed()) {
                n4 = -1.0f;
            }
            final int n5 = 2;
            double[] coorEncrypt = new double[n5];
            final boolean a = com.baidu.location.d.d.a().a(this.f.getLongitude(), this.f.getLatitude());
            final int n6 = 1;
            boolean b;
            if (a) {
                coorEncrypt = Jni.coorEncrypt(this.f.getLongitude(), this.f.getLatitude(), "gps2gcj");
                final double n7 = coorEncrypt[0];
                final double n8 = 0.0;
                if (n7 <= n8 && coorEncrypt[n6] <= n8) {
                    coorEncrypt[0] = this.f.getLongitude();
                    coorEncrypt[n6] = this.f.getLatitude();
                }
                b = true;
            }
            else {
                coorEncrypt[0] = this.f.getLongitude();
                coorEncrypt[n6] = this.f.getLatitude();
                b = false;
            }
            final Locale china = Locale.CHINA;
            final Object[] array = new Object[6];
            array[0] = coorEncrypt[0];
            array[n6] = coorEncrypt[n6];
            array[n5] = n;
            array[3] = this.f.getBearing();
            array[4] = n4;
            array[5] = com.baidu.location.b.e.m;
            String s = String.format(china, string, array);
            if (!b) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(s);
                sb2.append(",\"in_cn\":\"0\"");
                s = sb2.toString();
            }
            StringBuilder sb3;
            String format;
            if (this.f.hasAltitude()) {
                sb3 = new StringBuilder();
                sb3.append(s);
                final Locale china2 = Locale.CHINA;
                final String s2 = ",\"h\":%.2f}}";
                final Object[] array2 = new Object[n6];
                array2[0] = this.f.getAltitude();
                format = String.format(china2, s2, array2);
            }
            else {
                sb3 = new StringBuilder();
                sb3.append(s);
                format = "}}";
            }
            sb3.append(format);
            string2 = sb3.toString();
        }
        else {
            string2 = null;
        }
        return string2;
    }
    
    public Location g() {
        if (this.f == null) {
            return null;
        }
        if (Math.abs(System.currentTimeMillis() - this.f.getTime()) > 60000L) {
            return null;
        }
        return this.f;
    }
    
    public boolean h() {
        final boolean b = true;
        final double n = 0.0;
        try {
            if (this.f == null) {
                return false;
            }
            final Location f = this.f;
            try {
                if (f.getLatitude() == n) {
                    return false;
                }
                final Location f2 = this.f;
                try {
                    if (f2.getLongitude() == n) {
                        return false;
                    }
                    final int m = com.baidu.location.b.e.m;
                    final int n2 = 2;
                    if (m > n2) {
                        return b;
                    }
                    final Location f3 = this.f;
                    try {
                        if (f3.getExtras().getInt("satellites", 3) > n2) {
                            return b;
                        }
                        return false;
                    }
                    catch (Exception ex) {
                        final Location f4 = this.f;
                        return f4 != null && f4.getLatitude() != n && this.f.getLongitude() != n && b;
                    }
                }
                catch (Exception ex2) {}
            }
            catch (Exception ex3) {}
        }
        catch (Exception ex4) {}
    }
    
    public boolean i() {
        if (!this.h()) {
            return false;
        }
        if (System.currentTimeMillis() - this.t > 10000L) {
            return false;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        return (this.p && currentTimeMillis - this.o < 3000L) || this.s;
    }
}
