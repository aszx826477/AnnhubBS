// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import android.os.Build$VERSION;
import com.baidu.location.f;
import android.os.SystemClock;
import android.location.Location;
import com.baidu.location.d.j;
import com.baidu.location.b.e;
import com.baidu.location.b.h;
import com.baidu.location.b.b;
import android.os.Message;
import java.util.List;
import com.baidu.location.Address;
import com.baidu.location.b.a;
import com.baidu.location.b.g;
import com.baidu.location.BDLocation;
import android.os.Handler;

public class l extends i
{
    public static boolean h;
    private static l i;
    private double A;
    private boolean B;
    private long C;
    private long D;
    private l$a E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private l$b K;
    private boolean L;
    private int M;
    private long N;
    private boolean O;
    final int e;
    public i$b f;
    public final Handler g;
    private boolean j;
    private String k;
    private BDLocation l;
    private BDLocation m;
    private g n;
    private a o;
    private g p;
    private a q;
    private boolean r;
    private volatile boolean s;
    private boolean t;
    private long u;
    private long v;
    private Address w;
    private String x;
    private List y;
    private double z;
    
    static {
        l.i = null;
        l.h = false;
    }
    
    private l() {
        this.e = 1000;
        final boolean b = true;
        this.j = b;
        this.f = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = b;
        this.s = false;
        this.t = false;
        final long n = 0L;
        this.u = n;
        this.v = n;
        this.w = null;
        this.x = null;
        this.y = null;
        this.B = false;
        this.C = n;
        this.D = n;
        this.E = null;
        this.F = false;
        this.G = false;
        this.H = b;
        this.g = new i$a(this);
        this.I = false;
        this.J = false;
        this.K = null;
        this.L = false;
        this.M = 0;
        this.N = n;
        this.O = b;
        this.f = new i$b(this);
    }
    
    private boolean a(final a a) {
        this.b = com.baidu.location.b.b.a().f();
        if (this.b == a) {
            return false;
        }
        final a b = this.b;
        final boolean b2 = true;
        if (b != null && a != null) {
            return a.a(this.b) ^ b2;
        }
        return b2;
    }
    
    private boolean a(final g g) {
        this.a = com.baidu.location.b.h.a().o();
        if (g == this.a) {
            return false;
        }
        final g a = this.a;
        final boolean b = true;
        if (a != null && g != null) {
            return g.c(this.a) ^ b;
        }
        return b;
    }
    
    public static l c() {
        synchronized (l.class) {
            if (l.i == null) {
                l.i = new l();
            }
            return l.i;
        }
    }
    
    private void c(final Message message) {
        final boolean boolean1 = message.getData().getBoolean("isWaitingLocTag", false);
        final int h = 1;
        if (boolean1) {
            com.baidu.location.a.l.h = (h != 0);
        }
        final int d = com.baidu.location.a.a.a().d(message);
        switch (d) {
            default: {
                final Object[] array = new Object[h];
                array[0] = d;
                throw new IllegalArgumentException(String.format("this type %d is illegal", array));
            }
            case 3: {
                if (com.baidu.location.b.e.a().i()) {
                    this.e(message);
                    break;
                }
                break;
            }
            case 2: {
                this.g(message);
                break;
            }
            case 1: {
                this.d(message);
                break;
            }
        }
    }
    
    private void d(final Message message) {
        if (com.baidu.location.b.e.a().i()) {
            this.e(message);
            com.baidu.location.a.n.a().c();
        }
        else {
            this.g(message);
            com.baidu.location.a.n.a().b();
        }
    }
    
    private void e(final Message message) {
        final BDLocation l = new BDLocation(com.baidu.location.b.e.a().f());
        if (com.baidu.location.d.j.g.equals("all") || com.baidu.location.d.j.h || com.baidu.location.d.j.i) {
            final float[] array = new float[2];
            Location.distanceBetween(this.A, this.z, l.getLatitude(), l.getLongitude(), array);
            if (array[0] < 100.0f) {
                final Address w = this.w;
                if (w != null) {
                    l.setAddr(w);
                }
                final String x = this.x;
                if (x != null) {
                    l.setLocationDescribe(x);
                }
                final List y = this.y;
                if (y != null) {
                    l.setPoiList(y);
                }
            }
            else {
                this.B = true;
                this.g(null);
            }
        }
        this.l = l;
        this.m = null;
        com.baidu.location.a.a.a().a(l);
    }
    
    private void f(final Message message) {
        if (com.baidu.location.b.h.a().f()) {
            final boolean b = true;
            this.t = b;
            if (this.K == null) {
                this.K = new l$b(this, null);
            }
            if (this.L) {
                final l$b k = this.K;
                if (k != null) {
                    this.g.removeCallbacks((Runnable)k);
                }
            }
            this.g.postDelayed((Runnable)this.K, 3500L);
            this.L = b;
        }
        else {
            this.h(message);
        }
    }
    
    private void g(final Message message) {
        this.M = 0;
        if (this.r) {
            this.M = 1;
            this.D = SystemClock.uptimeMillis();
            if (com.baidu.location.b.h.a().j()) {
                this.f(message);
            }
            else {
                this.h(message);
            }
        }
        else {
            this.f(message);
            this.D = SystemClock.uptimeMillis();
        }
    }
    
    private void h(final Message message) {
        final long n = System.currentTimeMillis() - this.u;
        if (this.s && n <= 12000L) {
            return;
        }
        final long n2 = System.currentTimeMillis() - this.u;
        long n3 = 0L;
        if (n2 > n3 && System.currentTimeMillis() - this.u < 1000L) {
            if (this.l != null) {
                com.baidu.location.a.a.a().a(this.l);
            }
            this.k();
            return;
        }
        final boolean b = true;
        this.s = b;
        this.j = this.a(this.o);
        if (!this.a(this.n) && !this.j && this.l != null && !this.B) {
            if (this.m != null && System.currentTimeMillis() - this.v > 30000L) {
                this.l = this.m;
                this.m = null;
            }
            if (com.baidu.location.a.n.a().d()) {
                this.l.setDirection(com.baidu.location.a.n.a().e());
            }
            final int locType = this.l.getLocType();
            final int n4 = 62;
            if (locType == n4) {
                final long n5 = System.currentTimeMillis() - this.N;
                if (n5 > n3) {
                    n3 = n5;
                }
            }
            if (this.l.getLocType() == 61 || this.l.getLocType() == 161 || (this.l.getLocType() == n4 && n3 < 15000L)) {
                com.baidu.location.a.a.a().a(this.l);
                this.k();
                return;
            }
        }
        this.u = System.currentTimeMillis();
        String s = this.a((String)null);
        this.J = false;
        if (s == null) {
            this.J = b;
            this.N = System.currentTimeMillis();
            final String[] j = this.j();
            final long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > 60000L) {
                this.C = currentTimeMillis;
            }
            final String l = com.baidu.location.b.h.a().l();
            if (l != null) {
                final StringBuilder sb = new StringBuilder();
                sb.append(l);
                sb.append(this.b());
                sb.append(j[0]);
                s = sb.toString();
            }
            else {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(this.b());
                sb2.append(j[0]);
                s = sb2.toString();
            }
            if (this.b != null && this.b.g() != null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(this.b.g());
                sb3.append(s);
                s = sb3.toString();
            }
            final String a = com.baidu.location.d.b.a().a(b);
            if (a != null) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(s);
                sb4.append(a);
                s = sb4.toString();
            }
        }
        if (this.k != null) {
            final StringBuilder sb5 = new StringBuilder();
            sb5.append(s);
            sb5.append(this.k);
            s = sb5.toString();
            this.k = null;
        }
        this.f.a(s);
        this.o = this.b;
        this.n = this.a;
        if (this.r == b) {
            this.r = false;
            if (com.baidu.location.b.h.i() && message != null) {
                com.baidu.location.a.a.a().e(message);
            }
        }
        final int m = this.M;
        if (m > 0) {
            if (m == 2) {
                com.baidu.location.b.h.a().f();
            }
            this.M = 0;
        }
    }
    
    private String[] j() {
        final String[] array = { "", null };
        final int n = 1;
        array[n] = "Location failed beacuse we can not get any loc information!";
        final StringBuffer sb = new StringBuffer();
        sb.append("&apl=");
        final int a = com.baidu.location.d.j.a(com.baidu.location.f.getServiceContext());
        if (a == n) {
            array[n] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        }
        sb.append(a);
        final String c = com.baidu.location.d.j.c(com.baidu.location.f.getServiceContext());
        if (c.contains("0|0|")) {
            array[n] = "Location failed beacuse we can not get any loc information without any location permission!";
        }
        sb.append(c);
        boolean b2;
        if (Build$VERSION.SDK_INT >= 23) {
            sb.append("&loc=");
            final int b = com.baidu.location.d.j.b(com.baidu.location.f.getServiceContext());
            if (b == 0) {
                array[n] = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
                b2 = true;
            }
            else {
                b2 = false;
            }
            sb.append(b);
        }
        else {
            b2 = false;
        }
        if (Build$VERSION.SDK_INT >= 19) {
            sb.append("&lmd=");
            final int b3 = com.baidu.location.d.j.b(com.baidu.location.f.getServiceContext());
            if (b3 >= 0) {
                sb.append(b3);
            }
        }
        final String g = com.baidu.location.b.b.a().g();
        final String g2 = com.baidu.location.b.h.a().g();
        sb.append(g2);
        sb.append(g);
        sb.append(com.baidu.location.d.j.d(com.baidu.location.f.getServiceContext()));
        final int n2 = 62;
        com.baidu.location.a.b b4;
        int n3;
        String s;
        if (a == n) {
            b4 = com.baidu.location.a.b.a();
            n3 = 7;
            s = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        }
        else if (c.contains("0|0|")) {
            b4 = com.baidu.location.a.b.a();
            n3 = 4;
            s = "Location failed beacuse we can not get any loc information without any location permission!";
        }
        else if (b2) {
            b4 = com.baidu.location.a.b.a();
            n3 = 5;
            s = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
        }
        else if (g != null && g2 != null && g.equals("&sim=1") && !g2.equals("&wifio=1")) {
            b4 = com.baidu.location.a.b.a();
            n3 = 6;
            s = "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!";
        }
        else {
            b4 = com.baidu.location.a.b.a();
            n3 = 9;
            s = "Location failed beacuse we can not get any loc information!";
        }
        b4.a(n2, n3, s);
        array[0] = sb.toString();
        return array;
    }
    
    private void k() {
        this.s = false;
        this.G = false;
        this.H = false;
        this.B = false;
        this.l();
        if (this.O) {
            this.O = false;
        }
    }
    
    private void l() {
        if (this.l != null) {
            com.baidu.location.a.v.a().c();
        }
    }
    
    public Address a(final BDLocation bdLocation) {
        if (com.baidu.location.d.j.g.equals("all") || com.baidu.location.d.j.h || com.baidu.location.d.j.i) {
            final float[] array = new float[2];
            Location.distanceBetween(this.A, this.z, bdLocation.getLatitude(), bdLocation.getLongitude(), array);
            if (array[0] < 100.0f) {
                final Address w = this.w;
                if (w != null) {
                    return w;
                }
            }
            else {
                this.x = null;
                this.y = null;
                this.B = true;
                this.g(null);
            }
        }
        return null;
    }
    
    public void a() {
        final l$a e = this.E;
        if (e != null && this.F) {
            this.F = false;
            this.g.removeCallbacks((Runnable)e);
        }
        if (com.baidu.location.b.e.a().i()) {
            final BDLocation bdLocation = new BDLocation(com.baidu.location.b.e.a().f());
            if (com.baidu.location.d.j.g.equals("all") || com.baidu.location.d.j.h || com.baidu.location.d.j.i) {
                final float[] array = new float[2];
                Location.distanceBetween(this.A, this.z, bdLocation.getLatitude(), bdLocation.getLongitude(), array);
                if (array[0] < 100.0f) {
                    final Address w = this.w;
                    if (w != null) {
                        bdLocation.setAddr(w);
                    }
                    final String x = this.x;
                    if (x != null) {
                        bdLocation.setLocationDescribe(x);
                    }
                    final List y = this.y;
                    if (y != null) {
                        bdLocation.setPoiList(y);
                    }
                }
            }
            com.baidu.location.a.a.a().a(bdLocation);
        }
        else {
            if (this.G) {
                this.k();
                return;
            }
            if (!this.j && this.l != null) {
                com.baidu.location.a.a.a().a(this.l);
            }
            else {
                final BDLocation bdLocation2 = new BDLocation();
                bdLocation2.setLocType(63);
                this.l = null;
                com.baidu.location.a.a.a().a(bdLocation2);
            }
            this.m = null;
        }
        this.k();
    }
    
    public void a(final Message message) {
        final l$a e = this.E;
        if (e != null && this.F) {
            this.F = false;
            this.g.removeCallbacks((Runnable)e);
        }
        final BDLocation bdLocation = (BDLocation)message.obj;
        if (bdLocation != null && bdLocation.getLocType() == 167 && this.J) {
            bdLocation.setLocType(62);
        }
        this.b(bdLocation);
    }
    
    public void b(final Message message) {
        if (!this.I) {
            return;
        }
        this.c(message);
    }
    
    public void b(final BDLocation bdLocation) {
        final BDLocation bdLocation2 = new BDLocation(bdLocation);
        if (bdLocation.hasAddr()) {
            this.w = bdLocation.getAddress();
            this.z = bdLocation.getLongitude();
            this.A = bdLocation.getLatitude();
        }
        if (bdLocation.getLocationDescribe() != null) {
            this.x = bdLocation.getLocationDescribe();
            this.z = bdLocation.getLongitude();
            this.A = bdLocation.getLatitude();
        }
        if (bdLocation.getPoiList() != null) {
            this.y = bdLocation.getPoiList();
            this.z = bdLocation.getLongitude();
            this.A = bdLocation.getLatitude();
        }
        final boolean i = com.baidu.location.b.e.a().i();
        final float n = 100.0f;
        final int n2 = 2;
        boolean b = false;
        if (i) {
            final BDLocation bdLocation3 = new BDLocation(com.baidu.location.b.e.a().f());
            if (com.baidu.location.d.j.g.equals("all") || com.baidu.location.d.j.h || com.baidu.location.d.j.i) {
                final float[] array = new float[n2];
                Location.distanceBetween(this.A, this.z, bdLocation3.getLatitude(), bdLocation3.getLongitude(), array);
                if (array[0] < n) {
                    final Address w = this.w;
                    if (w != null) {
                        bdLocation3.setAddr(w);
                    }
                    final String x = this.x;
                    if (x != null) {
                        bdLocation3.setLocationDescribe(x);
                    }
                    final List y = this.y;
                    if (y != null) {
                        bdLocation3.setPoiList(y);
                    }
                }
            }
            com.baidu.location.a.a.a().a(bdLocation3);
            this.k();
            return;
        }
        if (this.G) {
            final float[] array2 = new float[n2];
            final BDLocation l = this.l;
            if (l != null) {
                Location.distanceBetween(l.getLatitude(), this.l.getLongitude(), bdLocation.getLatitude(), bdLocation.getLongitude(), array2);
            }
            Label_0485: {
                if (array2[0] > 10.0f) {
                    this.l = bdLocation;
                    if (this.H) {
                        break Label_0485;
                    }
                    this.H = false;
                }
                else {
                    if (bdLocation.getUserIndoorState() <= -1) {
                        break Label_0485;
                    }
                    this.l = bdLocation;
                }
                com.baidu.location.a.a.a().a(bdLocation);
            }
            this.k();
            return;
        }
        final int locType = bdLocation.getLocType();
        final int n3 = 167;
        final int n4 = 1;
        final int n5 = 161;
        if (locType == n3) {
            com.baidu.location.a.b.a().a(n3, 8, "NetWork location failed because baidu location service can not caculate the location!");
        }
        else if (bdLocation.getLocType() == n5) {
            boolean b3 = false;
            Label_0605: {
                if (Build$VERSION.SDK_INT >= 19) {
                    final int b2 = com.baidu.location.d.j.b(com.baidu.location.f.getServiceContext());
                    if (b2 == 0 || b2 == n2) {
                        b3 = true;
                        break Label_0605;
                    }
                }
                b3 = false;
            }
            if (b3) {
                com.baidu.location.a.b.a().a(n5, n4, "NetWork location successful, open gps will be better!");
            }
            else if (bdLocation.getRadius() >= n && bdLocation.getNetworkLocationType() != null && bdLocation.getNetworkLocationType().equals("cl")) {
                final String g = com.baidu.location.b.h.a().g();
                if (g != null && !g.equals("&wifio=1")) {
                    com.baidu.location.a.b.a().a(n5, n2, "NetWork location successful, open wifi will be better!");
                }
            }
        }
        this.m = null;
        if (bdLocation.getLocType() == n5 && "cl".equals(bdLocation.getNetworkLocationType())) {
            final BDLocation j = this.l;
            if (j != null && j.getLocType() == n5 && "wf".equals(this.l.getNetworkLocationType()) && System.currentTimeMillis() - this.v < 30000L) {
                this.m = bdLocation;
                b = true;
            }
        }
        if (b) {
            com.baidu.location.a.a.a().a(this.l);
        }
        else {
            com.baidu.location.a.a.a().a(bdLocation);
            this.v = System.currentTimeMillis();
        }
        if (com.baidu.location.d.j.a(bdLocation)) {
            if (!b) {
                this.l = bdLocation;
            }
        }
        else {
            this.l = null;
        }
        final int a = com.baidu.location.d.j.a(com.baidu.location.a.l.c, "ssid\":\"", "\"");
        Label_1023: {
            if (a != -1 << -1) {
                final g n6 = this.n;
                if (n6 != null) {
                    this.k = n6.c(a);
                    break Label_1023;
                }
            }
            this.k = null;
        }
        com.baidu.location.b.h.i();
        this.k();
    }
    
    public void c(final BDLocation bdLocation) {
        this.l = new BDLocation(bdLocation);
    }
    
    public void d() {
        final boolean b = true;
        this.r = b;
        this.s = false;
        this.I = b;
    }
    
    public void e() {
        this.s = false;
        this.t = false;
        this.G = false;
        this.H = true;
        this.i();
        this.I = false;
    }
    
    public String f() {
        return this.x;
    }
    
    public List g() {
        return this.y;
    }
    
    public void h() {
        if (this.t) {
            this.h(null);
            this.t = false;
        }
    }
    
    public void i() {
        this.l = null;
    }
}
