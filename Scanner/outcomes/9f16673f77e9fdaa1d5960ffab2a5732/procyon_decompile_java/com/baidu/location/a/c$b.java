// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import android.net.wifi.WifiInfo;
import java.util.Iterator;
import java.util.List;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.os.SystemClock;
import android.telephony.CellInfoWcdma;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfo;
import android.text.TextUtils;
import android.os.Build$VERSION;
import android.os.Build;
import com.baidu.android.bbalbs.common.util.CommonParam;
import android.net.wifi.WifiManager;
import com.baidu.location.b.a;
import android.telephony.TelephonyManager;
import android.content.Context;
import java.lang.reflect.Method;
import com.baidu.location.LocationClientOption;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import java.util.Locale;
import com.baidu.location.d.j;
import java.util.HashMap;
import com.baidu.location.d.e;

class c$b extends e
{
    String a;
    final /* synthetic */ c b;
    
    c$b(final c b) {
        this.b = b;
        this.a = null;
        this.k = new HashMap();
    }
    
    public void a() {
        this.h = com.baidu.location.d.j.c();
        final String a = this.b.s;
        final int n = 1;
        if (a != null && this.b.t != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            final Locale china = Locale.CHINA;
            final String s = "&ki=%s&sn=%s";
            final Object[] array = { this.b.s, null };
            array[n] = this.b.t;
            sb.append(String.format(china, s, array));
            this.a = sb.toString();
        }
        final String encodeTp4 = Jni.encodeTp4(this.a);
        this.a = null;
        this.k.put("bloc", encodeTp4);
        final Locale china2 = Locale.CHINA;
        final Object[] array2 = new Object[n];
        array2[0] = System.currentTimeMillis();
        this.k.put("trtm", String.format(china2, "%d", array2));
    }
    
    public void a(String f) {
        this.a = f;
        f = com.baidu.location.d.j.f;
        this.b(f);
    }
    
    public void a(final boolean b) {
        Label_0202: {
            if (b && this.j != null) {
                try {
                    final String j = this.j;
                    Label_0047: {
                        BDLocation bdLocation;
                        try {
                            bdLocation = new BDLocation(j);
                            break Label_0047;
                        }
                        catch (Exception ex) {
                            bdLocation = new(com.baidu.location.BDLocation.class);
                            final BDLocation bdLocation2 = bdLocation;
                            new BDLocation();
                            final int n = 63;
                            final BDLocation bdLocation3 = bdLocation;
                            final int n2 = n;
                            bdLocation3.setLocType(n2);
                        }
                        try {
                            final BDLocation bdLocation2 = bdLocation;
                            new BDLocation();
                            final int n = 63;
                            final BDLocation bdLocation3 = bdLocation;
                            final int n2 = n;
                            bdLocation3.setLocType(n2);
                            if (bdLocation.getLocType() != 161) {
                                break Label_0202;
                            }
                            final c b2 = this.b;
                            try {
                                final LocationClientOption c = b2.p;
                                try {
                                    bdLocation.setCoorType(c.coorType);
                                    try {
                                        final StringBuilder sb = new StringBuilder();
                                        final c b3 = this.b;
                                        try {
                                            sb.append(b3.a);
                                            sb.append(";");
                                            final c b4 = this.b;
                                            try {
                                                sb.append(b4.b);
                                                sb.append(";");
                                                sb.append(bdLocation.getTime());
                                                final String string = sb.toString();
                                                try {
                                                    bdLocation.setLocationID(Jni.en1(string));
                                                    final c b5 = this.b;
                                                    try {
                                                        b5.q.onReceiveLocation(bdLocation);
                                                    }
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
                            catch (Exception ex8) {}
                        }
                        catch (Exception ex9) {}
                    }
                }
                catch (Exception ex10) {}
            }
        }
        if (this.k != null) {
            this.k.clear();
        }
    }
}
