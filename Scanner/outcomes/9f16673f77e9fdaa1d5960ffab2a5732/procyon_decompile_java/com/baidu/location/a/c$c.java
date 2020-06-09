// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellInfoWcdma;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfo;
import android.text.TextUtils;
import android.os.Build;
import com.baidu.location.d.j;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.location.LocationClientOption;
import android.net.wifi.WifiManager;
import com.baidu.location.b.a;
import android.telephony.TelephonyManager;
import android.content.Context;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import android.os.SystemClock;
import android.os.Build$VERSION;
import java.util.ArrayList;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import java.util.List;

public class c$c
{
    public List a;
    final /* synthetic */ c b;
    private long c;
    
    public c$c(final c b, final List a) {
        this.b = b;
        this.a = null;
        this.c = 0L;
        this.a = a;
        this.c = System.currentTimeMillis();
        this.c();
    }
    
    private String b() {
        final WifiInfo connectionInfo = this.b.m.getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        try {
            final String bssid = connectionInfo.getBSSID();
            String replace;
            if (bssid != null) {
                replace = bssid.replace(":", "");
            }
            else {
                replace = null;
            }
            if (replace != null && replace.length() != 12) {
                return null;
            }
            return new String(replace);
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    private void c() {
        final int a = this.a();
        final int n = 1;
        if (a < n) {
            return;
        }
        int n4;
        for (int n2 = this.a.size() - n, n3 = 1; n2 >= n && n3 != 0; --n2, n3 = n4) {
            int i = 0;
            n4 = 0;
            while (i < n2) {
                final int level = this.a.get(i).level;
                final List a2 = this.a;
                final int n5 = i + 1;
                if (level < a2.get(n5).level) {
                    final ScanResult scanResult = this.a.get(n5);
                    final List a3 = this.a;
                    a3.set(n5, a3.get(i));
                    this.a.set(i, scanResult);
                    n4 = 1;
                }
                i = n5;
            }
        }
    }
    
    public int a() {
        final List a = this.a;
        if (a == null) {
            return 0;
        }
        return a.size();
    }
    
    public String a(final int n) {
        if (this.a() < 2) {
            return null;
        }
        final ArrayList<Long> list = new ArrayList<Long>();
        final int sdk_INT = Build$VERSION.SDK_INT;
        final int n2 = 19;
        int n3 = 1;
        final long n4 = 0L;
        long n5 = 0L;
        boolean b = false;
        Label_0106: {
            if (sdk_INT >= n2) {
                try {
                    n5 = SystemClock.elapsedRealtimeNanos() / 1000L;
                }
                catch (Error error) {
                    n5 = n4;
                }
                if (n5 > n4) {
                    b = true;
                    break Label_0106;
                }
            }
            else {
                n5 = n4;
            }
            b = false;
        }
        final StringBuffer sb = new StringBuffer(512);
        final int size = this.a.size();
        final String b2 = this.b();
        int n6 = (int)n4;
        int n7 = 0;
        int i = 0;
        int n8 = 1;
        int n9 = 0;
        int n10 = 0;
        while (i < size) {
            if (((ScanResult)this.a.get(i)).level != 0) {
                final int n11 = n7 + 1;
                if (n8 != 0) {
                    sb.append("&wf=");
                    n8 = 0;
                }
                else {
                    sb.append("|");
                }
                final String replace = this.a.get(i).BSSID.replace(":", "");
                sb.append(replace);
                if (b2 != null && replace.equals(b2)) {
                    n10 = n11;
                }
                int level = this.a.get(i).level;
                if (level < 0) {
                    level = -level;
                }
                final Locale china = Locale.CHINA;
                final String s = ";%d;";
                final int n12 = n11;
                final Object[] array = new Object[n3];
                array[0] = level;
                sb.append(String.format(china, s, array));
                final int n13 = n9 + 1;
                if (b) {
                    long n15;
                    try {
                        final long n14 = (n5 - this.a.get(i).timestamp) / 1000000L;
                    }
                    finally {
                        n15 = 0L;
                    }
                    list.add(n15);
                    if (n15 > n6) {
                        n6 = (int)n15;
                    }
                }
                if (n13 > n) {
                    break;
                }
                n9 = n13;
                n7 = n12;
            }
            ++i;
        }
        if (n10 > 0) {
            sb.append("&wf_n=");
            sb.append(n10);
        }
        if (n8 != 0) {
            return null;
        }
        if (n6 > 10 && list.size() > 0 && list.get(0) > 0L) {
            final StringBuffer sb2 = new StringBuffer(128);
            sb2.append("&wf_ut=");
            final Long n16 = list.get(0);
            for (final Long n17 : list) {
                if (n3 != 0) {
                    sb2.append((long)n17);
                    n3 = 0;
                }
                else {
                    final long n18 = n17 - n16;
                    if (n18 != 0L) {
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("");
                        sb3.append(n18);
                        sb2.append(sb3.toString());
                    }
                }
                sb2.append("|");
            }
            sb.append(sb2.toString());
        }
        return sb.toString();
    }
}
