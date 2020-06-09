// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import com.baidu.location.Jni;
import android.os.Parcelable;
import android.os.DeadObjectException;
import android.os.Handler;
import com.baidu.location.LocationClientOption;
import java.util.List;
import com.baidu.location.Address;
import android.location.Location;
import com.baidu.location.b.h;
import android.os.Message;
import android.os.Bundle;
import com.baidu.location.b.e;
import com.baidu.location.d.j;
import com.baidu.location.f;
import com.baidu.location.d.b;
import android.content.Intent;
import java.util.Iterator;
import android.os.Messenger;
import com.baidu.location.BDLocation;
import java.util.ArrayList;

public class a
{
    public static long c;
    private static a e;
    public boolean a;
    boolean b;
    int d;
    private ArrayList f;
    private boolean g;
    private BDLocation h;
    private BDLocation i;
    private BDLocation j;
    private BDLocation k;
    private boolean l;
    private boolean m;
    private a$b n;
    
    static {
        a.e = null;
        a.c = 0L;
    }
    
    private a() {
        this.f = null;
        this.g = false;
        this.a = false;
        this.b = false;
        this.h = null;
        this.i = null;
        this.j = null;
        this.d = 0;
        this.k = null;
        this.l = false;
        this.m = false;
        this.n = null;
        this.f = new ArrayList();
    }
    
    private a$a a(final Messenger messenger) {
        final ArrayList f = this.f;
        if (f == null) {
            return null;
        }
        for (final a$a a$a : f) {
            if (a$a.b.equals((Object)messenger)) {
                return a$a;
            }
        }
        return null;
    }
    
    public static a a() {
        if (a.e == null) {
            a.e = new a();
        }
        return a.e;
    }
    
    private void a(final a$a a$a) {
        if (a$a == null) {
            return;
        }
        int n;
        if (this.a(a$a.b) != null) {
            n = 14;
        }
        else {
            this.f.add(a$a);
            n = 13;
        }
        a$a.a(n);
    }
    
    private void b(final String s) {
        final Intent intent = new Intent("com.baidu.location.flp.log");
        intent.setPackage("com.baidu.baidulocationdemo");
        intent.putExtra("data", s);
        intent.putExtra("pack", com.baidu.location.d.b.d);
        intent.putExtra("tag", "state");
        com.baidu.location.f.getServiceContext().sendBroadcast(intent);
    }
    
    private void e() {
        this.f();
        this.d();
    }
    
    private void f() {
        final Iterator<a$a> iterator = (Iterator<a$a>)this.f.iterator();
        boolean a = false;
        boolean g = false;
        while (iterator.hasNext()) {
            final a$a a$a = iterator.next();
            if (a$a.c.openGps) {
                g = true;
            }
            if (a$a.c.location_change_notify) {
                a = true;
            }
        }
        com.baidu.location.d.j.a = a;
        if (this.g != g) {
            this.g = g;
            com.baidu.location.b.e.a().a(this.g);
        }
    }
    
    public void a(final Bundle bundle, final int n) {
        final Iterator<a$a> iterator = (Iterator<a$a>)this.f.iterator();
        try {
            while (iterator.hasNext()) {
                final a$a next = iterator.next();
                try {
                    final a$a a$a = next;
                    a$a.a(n, bundle);
                    if (a$a.d > 4) {
                        iterator.remove();
                        continue;
                    }
                    continue;
                }
                catch (Exception ex) {}
            }
        }
        catch (Exception ex2) {}
    }
    
    public void a(final Message message) {
        if (message != null) {
            if (message.replyTo != null) {
                com.baidu.location.a.a.c = System.currentTimeMillis();
                this.a = true;
                com.baidu.location.b.h.a().b();
                this.a(new a$a(this, message));
                this.e();
                if (this.l) {
                    this.b("start");
                    this.d = 0;
                }
            }
        }
    }
    
    public void a(final BDLocation bdLocation) {
        this.b(bdLocation);
    }
    
    public void a(final String s) {
        this.c(new BDLocation(s));
    }
    
    public void b() {
        this.f.clear();
        this.h = null;
        this.e();
    }
    
    public void b(final Message message) {
        final a$a a = this.a(message.replyTo);
        if (a != null) {
            this.f.remove(a);
        }
        com.baidu.location.a.n.a().c();
        this.e();
        if (this.l) {
            this.b("stop");
            this.d = 0;
        }
    }
    
    public void b(BDLocation bdLocation) {
        final boolean h = com.baidu.location.a.l.h;
        if (h) {
            com.baidu.location.a.l.h = false;
        }
        final int v = com.baidu.location.d.j.V;
        final int n = 10000;
        final int n2 = 161;
        if (v >= n && (bdLocation.getLocType() == 61 || bdLocation.getLocType() == n2 || bdLocation.getLocType() == 66)) {
            final BDLocation h2 = this.h;
            BDLocation h3;
            if (h2 != null) {
                final float[] array = { 0.0f };
                Location.distanceBetween(h2.getLatitude(), this.h.getLongitude(), bdLocation.getLatitude(), bdLocation.getLongitude(), array);
                if (array[0] <= com.baidu.location.d.j.X && !h) {
                    return;
                }
                this.h = null;
                h3 = new BDLocation(bdLocation);
            }
            else {
                h3 = new BDLocation(bdLocation);
            }
            this.h = h3;
        }
        final int n3 = 4;
        Label_0367: {
            if (bdLocation == null || bdLocation.getLocType() != n2 || com.baidu.location.a.j.a().b()) {
                break Label_0367;
            }
            bdLocation = this.i;
            if (bdLocation == null) {
                this.i = new BDLocation();
                bdLocation = this.i;
                bdLocation.setLocType(505);
            }
            final Iterator iterator = this.f.iterator();
        Label_0376_Outer:
            while (true) {
                while (true) {
                    Iterator iterator2 = null;
                    a$a next2 = null;
                    try {
                        while (iterator.hasNext()) {
                            final a$a next = iterator.next();
                            try {
                                final a$a a$a = next;
                                try {
                                    a$a.a(this.i);
                                    if (a$a.d > n3) {
                                        iterator.remove();
                                        continue Label_0376_Outer;
                                    }
                                    continue Label_0376_Outer;
                                    iterator2 = this.f.iterator();
                                    // iftrue(Label_0435:, !iterator2.hasNext())
                                    next2 = iterator2.next();
                                }
                                catch (Exception ex) {}
                            }
                            catch (Exception ex2) {}
                        }
                        break;
                    }
                    catch (Exception ex3) {}
                    final a$a a$a2 = next2;
                    a$a2.a(bdLocation);
                    if (a$a2.d > n3) {
                        iterator2.remove();
                        continue;
                    }
                    continue;
                }
            }
        }
        Label_0435:;
    }
    
    public String c() {
        final StringBuffer sb = new StringBuffer(256);
        if (this.f.isEmpty()) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("&prod=");
            sb2.append(com.baidu.location.d.b.e);
            sb2.append(":");
            sb2.append(com.baidu.location.d.b.d);
            return sb2.toString();
        }
        final a$a a$a = this.f.get(0);
        if (a$a.c.prodName != null) {
            sb.append(a$a.c.prodName);
        }
        if (a$a.a != null) {
            sb.append(":");
            sb.append(a$a.a);
            sb.append("|");
        }
        final String string = sb.toString();
        String string2;
        if (string != null && !string.equals("")) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("&prod=");
            sb3.append(string);
            string2 = sb3.toString();
        }
        else {
            string2 = null;
        }
        return string2;
    }
    
    public void c(final BDLocation bdLocation) {
        final Address a = com.baidu.location.a.l.c().a(bdLocation);
        final String f = com.baidu.location.a.l.c().f();
        final List g = com.baidu.location.a.l.c().g();
        if (a != null) {
            bdLocation.setAddr(a);
        }
        if (f != null) {
            bdLocation.setLocationDescribe(f);
        }
        if (g != null) {
            bdLocation.setPoiList(g);
        }
        com.baidu.location.a.l.c().c(bdLocation);
        this.a(bdLocation);
    }
    
    public boolean c(final Message message) {
        final a$a a = this.a(message.replyTo);
        boolean b = false;
        if (a == null) {
            return false;
        }
        final int scanSpan = a.c.scanSpan;
        a.c.scanSpan = message.getData().getInt("scanSpan", a.c.scanSpan);
        final int scanSpan2 = a.c.scanSpan;
        final boolean a2 = true;
        final int n = 1000;
        if (scanSpan2 < n) {
            com.baidu.location.a.n.a().c();
            this.a = false;
        }
        else {
            this.a = a2;
        }
        if (a.c.scanSpan > 999 && scanSpan < n) {
            if (a.c.mIsNeedDeviceDirect || a.c.isNeedAltitude) {
                com.baidu.location.a.n.a().a(a.c.mIsNeedDeviceDirect);
                com.baidu.location.a.n.a().b();
            }
            this.b |= a.c.isNeedAltitude;
            b = true;
        }
        a.c.openGps = message.getData().getBoolean("openGPS", a.c.openGps);
        String coorType = message.getData().getString("coorType");
        final LocationClientOption c = a.c;
        if (coorType == null || coorType.equals("")) {
            coorType = a.c.coorType;
        }
        c.coorType = coorType;
        String addrType = message.getData().getString("addrType");
        final LocationClientOption c2 = a.c;
        if (addrType == null || addrType.equals("")) {
            addrType = a.c.addrType;
        }
        c2.addrType = addrType;
        if (!com.baidu.location.d.j.g.equals(a.c.addrType)) {
            com.baidu.location.a.l.c().i();
        }
        a.c.timeOut = message.getData().getInt("timeOut", a.c.timeOut);
        a.c.location_change_notify = message.getData().getBoolean("location_change_notify", a.c.location_change_notify);
        a.c.priority = message.getData().getInt("priority", a.c.priority);
        final int int1 = message.getData().getInt("wifitimeout", -1 >>> 1);
        if (int1 < com.baidu.location.d.j.ae) {
            com.baidu.location.d.j.ae = int1;
        }
        this.e();
        return b;
    }
    
    public int d(final Message message) {
        final boolean b = true;
        if (message != null) {
            if (message.replyTo != null) {
                final a$a a = this.a(message.replyTo);
                if (a != null) {
                    if (a.c != null) {
                        return a.c.priority;
                    }
                }
            }
        }
        return b ? 1 : 0;
    }
    
    public void d() {
        final Iterator<a$a> iterator = this.f.iterator();
        while (iterator.hasNext()) {
            iterator.next().a();
        }
    }
    
    public int e(final Message message) {
        final int n = 1000;
        if (message != null) {
            if (message.replyTo != null) {
                final a$a a = this.a(message.replyTo);
                if (a != null) {
                    if (a.c != null) {
                        return a.c.scanSpan;
                    }
                }
            }
        }
        return n;
    }
}
