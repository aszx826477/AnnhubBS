// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.b;

import com.baidu.location.Jni;
import android.os.Bundle;
import android.util.Log;
import android.location.LocationListener;
import android.location.GnssStatus$Callback;
import com.baidu.location.d.d;
import com.baidu.location.a.v;
import com.baidu.location.a.t;
import com.baidu.location.a.a;
import com.baidu.location.d.b;
import java.util.Locale;
import android.os.Build$VERSION;
import android.os.Handler;
import android.content.Context;
import java.util.Iterator;
import android.location.LocationManager;
import android.location.Location;
import com.baidu.location.d.j;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import java.util.ArrayList;
import java.util.List;
import android.location.GpsStatus$Listener;

class e$b implements GpsStatus$Listener
{
    long a;
    final /* synthetic */ e b;
    private long c;
    private final int d;
    private boolean e;
    private List f;
    private String g;
    private String h;
    private String i;
    private long j;
    
    private e$b(final e b) {
        this.b = b;
        final long j = 0L;
        this.a = j;
        this.c = j;
        this.d = 400;
        this.e = false;
        this.f = new ArrayList();
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = j;
    }
    
    public void onGpsStatusChanged(int a) {
        if (this.b.e == null) {
            return;
        }
        final int n = 2;
        int n2 = 0;
        if (a != n) {
            if (a != 4) {
                return;
            }
            a = (this.b.q ? 1 : 0);
            if (a == 0) {
                return;
            }
            try {
                final e b = this.b;
                try {
                    Label_0100: {
                        if (b.i != null) {
                            break Label_0100;
                        }
                        final e b2 = this.b;
                        try {
                            final e b3 = this.b;
                            try {
                                b2.i = b3.e.getGpsStatus((GpsStatus)null);
                                Label_0130: {
                                    break Label_0130;
                                    final e b4 = this.b;
                                    try {
                                        final LocationManager c = b4.e;
                                        try {
                                            final e b5 = this.b;
                                            try {
                                                c.getGpsStatus(b5.i);
                                                final e b6 = this.b;
                                                try {
                                                    final GpsStatus e = b6.i;
                                                    try {
                                                        final Iterable satellites = e.getSatellites();
                                                        try {
                                                            final Iterator<GpsSatellite> iterator = satellites.iterator();
                                                            try {
                                                                this.b.A = 0;
                                                                this.b.B = 0;
                                                                double n3 = 0.0;
                                                                final e b7 = this.b;
                                                                try {
                                                                    final ArrayList d = b7.F;
                                                                    try {
                                                                        d.clear();
                                                                        int n4 = 0;
                                                                    Label_0542_Outer:
                                                                        while (true) {
                                                                            Label_0491: {
                                                                                if (!iterator.hasNext()) {
                                                                                    break Label_0491;
                                                                                }
                                                                                final GpsSatellite next = iterator.next();
                                                                                try {
                                                                                    final GpsSatellite gpsSatellite = next;
                                                                                    try {
                                                                                        try {
                                                                                            final ArrayList<Float> list = new ArrayList<Float>();
                                                                                            if (!gpsSatellite.usedInFix()) {
                                                                                                continue;
                                                                                            }
                                                                                            ++n4;
                                                                                            Label_0426: {
                                                                                                if (gpsSatellite.getPrn() > 65) {
                                                                                                    break Label_0426;
                                                                                                }
                                                                                                ++n2;
                                                                                                final double n5 = gpsSatellite.getSnr();
                                                                                                Double.isNaN(n5);
                                                                                                n3 += n5;
                                                                                                list.add(0.0f);
                                                                                                final float snr = gpsSatellite.getSnr();
                                                                                                try {
                                                                                                    list.add(snr);
                                                                                                    final float azimuth = gpsSatellite.getAzimuth();
                                                                                                    try {
                                                                                                        list.add(azimuth);
                                                                                                        final float elevation = gpsSatellite.getElevation();
                                                                                                        try {
                                                                                                            list.add(elevation);
                                                                                                            list.add(1.0f);
                                                                                                            final e b8 = this.b;
                                                                                                            try {
                                                                                                                b8.F.add(list);
                                                                                                                final float snr2 = gpsSatellite.getSnr();
                                                                                                                try {
                                                                                                                    if (snr2 < com.baidu.location.d.j.G) {
                                                                                                                        continue;
                                                                                                                    }
                                                                                                                    final e b9 = this.b;
                                                                                                                    try {
                                                                                                                        b9.B++;
                                                                                                                        continue Label_0542_Outer;
                                                                                                                        // iftrue(Label_0526:, n2 <= 0)
                                                                                                                    Block_53_Outer:
                                                                                                                        while (true) {
                                                                                                                            com.baidu.location.b.e.m = n4;
                                                                                                                            return;
                                                                                                                            while (true) {
                                                                                                                                com.baidu.location.b.e.n = n2;
                                                                                                                                final double n6 = n2;
                                                                                                                                Double.isNaN(n6);
                                                                                                                                com.baidu.location.b.e.C = n3 / n6;
                                                                                                                                break Block_53_Outer;
                                                                                                                                continue;
                                                                                                                            }
                                                                                                                            this.j = System.currentTimeMillis();
                                                                                                                            continue Block_53_Outer;
                                                                                                                            final long currentTimeMillis;
                                                                                                                            Label_0551: {
                                                                                                                                currentTimeMillis = System.currentTimeMillis();
                                                                                                                            }
                                                                                                                            try {
                                                                                                                                a = lcmp(currentTimeMillis - this.j, (long)100);
                                                                                                                                if (a > 0) {
                                                                                                                                    this.j = System.currentTimeMillis();
                                                                                                                                    continue Block_53_Outer;
                                                                                                                                }
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            catch (Exception ex) {}
                                                                                                                            break;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    // iftrue(Label_0551:, n4 <= 0)
                                                                                                                    catch (Exception ex2) {}
                                                                                                                }
                                                                                                                catch (Exception ex3) {}
                                                                                                            }
                                                                                                            catch (Exception ex4) {}
                                                                                                        }
                                                                                                        catch (Exception ex5) {}
                                                                                                    }
                                                                                                    catch (Exception ex6) {}
                                                                                                }
                                                                                                catch (Exception ex7) {}
                                                                                            }
                                                                                        }
                                                                                        catch (Exception ex8) {}
                                                                                    }
                                                                                    catch (Exception ex9) {}
                                                                                }
                                                                                catch (Exception ex10) {}
                                                                            }
                                                                        }
                                                                    }
                                                                    catch (Exception ex11) {}
                                                                }
                                                                catch (Exception ex12) {}
                                                            }
                                                            catch (Exception ex13) {}
                                                        }
                                                        catch (Exception ex14) {}
                                                    }
                                                    catch (Exception ex15) {}
                                                }
                                                catch (Exception ex16) {}
                                            }
                                            catch (Exception ex17) {}
                                        }
                                        catch (Exception ex18) {}
                                    }
                                    catch (Exception ex19) {}
                                }
                            }
                            catch (Exception ex20) {}
                        }
                        catch (Exception ex21) {}
                    }
                }
                catch (Exception ex22) {}
            }
            catch (Exception ex23) {}
        }
        this.b.d(null);
        this.b.b(false);
        com.baidu.location.b.e.m = 0;
        com.baidu.location.b.e.n = 0;
    }
}
