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
import com.baidu.location.d.j;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.location.LocationClientOption;
import android.net.wifi.WifiManager;
import com.baidu.location.b.a;
import android.telephony.TelephonyManager;
import android.content.Context;
import java.lang.reflect.Method;

public class c
{
    private static Method g;
    private static Method h;
    private static Method i;
    private static Method j;
    private static Method k;
    private static Class l;
    String a;
    String b;
    c$b c;
    private Context d;
    private TelephonyManager e;
    private a f;
    private WifiManager m;
    private c$c n;
    private String o;
    private LocationClientOption p;
    private c$a q;
    private String r;
    private String s;
    private String t;
    
    static {
        c.g = null;
        c.h = null;
        c.i = null;
        c.j = null;
        c.k = null;
        c.l = null;
    }
    
    public c(Context d, final LocationClientOption locationClientOption, final c$a q) {
        this.d = null;
        this.e = null;
        this.f = new a();
        this.m = null;
        this.n = null;
        this.o = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.a = null;
        this.b = null;
        this.c = new c$b(this);
        d = ((Context)d).getApplicationContext();
        this.d = (Context)d;
        this.p = new LocationClientOption(locationClientOption);
        this.q = q;
        this.a = this.d.getPackageName();
        this.b = null;
        try {
            d = this.d;
            final Object systemService = ((Context)d).getSystemService("phone");
            try {
                this.e = (TelephonyManager)systemService;
                final TelephonyManager e = this.e;
                try {
                    d = e.getDeviceId();
                }
                catch (Exception ex) {
                    d = null;
                }
            }
            catch (Exception ex2) {}
        }
        catch (Exception ex3) {}
        try {
            final Context d2 = this.d;
            try {
                this.b = CommonParam.a(d2);
            }
            catch (Exception ex4) {
                this.b = null;
            }
        }
        catch (Exception ex5) {}
        String o;
        if (this.b != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(this.b);
            com.baidu.location.d.j.n = sb.toString();
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("&prod=");
            sb2.append(this.p.prodName);
            sb2.append(":");
            sb2.append(this.a);
            sb2.append("|&cu=");
            sb2.append(this.b);
            sb2.append("&coor=");
            sb2.append(locationClientOption.getCoorType());
            o = sb2.toString();
        }
        else {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("&prod=");
            sb3.append(this.p.prodName);
            sb3.append(":");
            sb3.append(this.a);
            sb3.append("|&im=");
            sb3.append((String)d);
            sb3.append("&coor=");
            sb3.append(locationClientOption.getCoorType());
            o = sb3.toString();
        }
        this.o = o;
        final StringBuffer sb4 = new StringBuffer(256);
        sb4.append("&fw=");
        sb4.append("7.52");
        sb4.append("&sdk=");
        sb4.append("7.52");
        sb4.append("&lt=1");
        sb4.append("&mb=");
        sb4.append(Build.MODEL);
        sb4.append("&resid=");
        sb4.append("12");
        locationClientOption.getAddrType();
        if (locationClientOption.getAddrType() != null && locationClientOption.getAddrType().equals("all")) {
            final StringBuilder sb5 = new StringBuilder();
            sb5.append(this.o);
            sb5.append("&addr=allj");
            this.o = sb5.toString();
        }
        final boolean isNeedAptag = locationClientOption.isNeedAptag;
        final boolean b = true;
        if (isNeedAptag == b || locationClientOption.isNeedAptagd == b) {
            final StringBuilder sb6 = new StringBuilder();
            sb6.append(this.o);
            sb6.append("&sema=");
            this.o = sb6.toString();
            if (locationClientOption.isNeedAptag == b) {
                final StringBuilder sb7 = new StringBuilder();
                sb7.append(this.o);
                sb7.append("aptag|");
                this.o = sb7.toString();
            }
            if (locationClientOption.isNeedAptagd == b) {
                final StringBuilder sb8 = new StringBuilder();
                sb8.append(this.o);
                sb8.append("aptagd|");
                this.o = sb8.toString();
            }
            this.s = com.baidu.location.a.j.b(this.d);
            this.t = com.baidu.location.a.j.c(this.d);
        }
        sb4.append("&first=1");
        sb4.append("&os=A");
        sb4.append(Build$VERSION.SDK);
        final StringBuilder sb9 = new StringBuilder();
        sb9.append(this.o);
        sb9.append(sb4.toString());
        this.o = sb9.toString();
        d = this.d.getApplicationContext();
        this.m = (WifiManager)((Context)d).getSystemService("wifi");
        String s = this.a();
        if (!TextUtils.isEmpty((CharSequence)s)) {
            s = s.replace(":", "");
        }
        if (!TextUtils.isEmpty((CharSequence)s) && !s.equals("020000000000")) {
            final StringBuilder sb10 = new StringBuilder();
            sb10.append(this.o);
            sb10.append("&mac=");
            sb10.append(s);
            this.o = sb10.toString();
        }
        this.b();
    }
    
    private int a(int n) {
        if (n == -1 >>> 1) {
            n = -1;
        }
        return n;
    }
    
    private a a(final CellInfo cellInfo) {
        final int intValue = Integer.valueOf(Build$VERSION.SDK_INT);
        if (intValue < 17) {
            return null;
        }
        final a a = new a();
        final boolean b = cellInfo instanceof CellInfoGsm;
        boolean b2 = true;
        final char i = 'g';
        Label_0629: {
            int h;
            if (b) {
                final CellInfoGsm cellInfoGsm = (CellInfoGsm)cellInfo;
                final CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
                a.c = this.a(cellIdentity.getMcc());
                a.d = this.a(cellIdentity.getMnc());
                a.a = this.a(cellIdentity.getLac());
                a.b = this.a(cellIdentity.getCid());
                a.i = i;
                h = cellInfoGsm.getCellSignalStrength().getAsuLevel();
            }
            else {
                if (cellInfo instanceof CellInfoCdma) {
                    final CellInfoCdma cellInfoCdma = (CellInfoCdma)cellInfo;
                    final CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                    a.e = cellIdentity2.getLatitude();
                    a.f = cellIdentity2.getLongitude();
                    a.d = this.a(cellIdentity2.getSystemId());
                    a.a = this.a(cellIdentity2.getNetworkId());
                    a.b = this.a(cellIdentity2.getBasestationId());
                    a.i = 'c';
                    a.h = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    final a f = this.f;
                    int c;
                    if (f != null && f.c > 0) {
                        c = this.f.c;
                    }
                    else {
                        c = -1;
                        Label_0479: {
                            try {
                                final TelephonyManager e = this.e;
                                try {
                                    final String networkOperator = e.getNetworkOperator();
                                    if (networkOperator == null || networkOperator.length() <= 0) {
                                        break Label_0479;
                                    }
                                    final int length = networkOperator.length();
                                    final int n = 3;
                                    if (length < n) {
                                        break Label_0479;
                                    }
                                    final String substring = networkOperator.substring(0, n);
                                    try {
                                        final Integer value = Integer.valueOf(substring);
                                        try {
                                            final int intValue2 = value;
                                            if (intValue2 < 0) {
                                                break Label_0479;
                                            }
                                            c = intValue2;
                                        }
                                        catch (Exception ex) {}
                                    }
                                    catch (Exception ex2) {}
                                }
                                catch (Exception ex3) {}
                            }
                            catch (Exception ex4) {}
                        }
                        if (c <= 0) {
                            break Label_0629;
                        }
                    }
                    a.c = c;
                    break Label_0629;
                }
                if (!(cellInfo instanceof CellInfoLte)) {
                    b2 = false;
                    break Label_0629;
                }
                final CellInfoLte cellInfoLte = (CellInfoLte)cellInfo;
                final CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                a.c = this.a(cellIdentity3.getMcc());
                a.d = this.a(cellIdentity3.getMnc());
                a.a = this.a(cellIdentity3.getTac());
                a.b = this.a(cellIdentity3.getCi());
                a.i = i;
                h = cellInfoLte.getCellSignalStrength().getAsuLevel();
            }
            a.h = h;
        }
        if (intValue >= 18 && !b2 && cellInfo instanceof CellInfoWcdma) {
            try {
                final CellInfoWcdma cellInfoWcdma = (CellInfoWcdma)cellInfo;
                try {
                    final CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                    try {
                        a.c = this.a(cellIdentity4.getMcc());
                        a.d = this.a(cellIdentity4.getMnc());
                        a.a = this.a(cellIdentity4.getLac());
                        a.b = this.a(cellIdentity4.getCid());
                        final a a2 = a;
                        try {
                            a2.i = i;
                            final CellInfoWcdma cellInfoWcdma2 = (CellInfoWcdma)cellInfo;
                            try {
                                final CellSignalStrengthWcdma cellSignalStrength = cellInfoWcdma2.getCellSignalStrength();
                                try {
                                    a.h = cellSignalStrength.getAsuLevel();
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
            catch (Exception ex10) {}
        }
        try {
            final long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            try {
                final long n2 = (elapsedRealtimeNanos - cellInfo.getTimeStamp()) / 1000000L;
                try {
                    a.g = System.currentTimeMillis() - n2;
                }
                catch (Error error) {
                    a.g = System.currentTimeMillis();
                }
            }
            catch (Error error2) {}
        }
        catch (Error error3) {}
        return a;
    }
    
    private void a(final CellLocation cellLocation) {
        if (cellLocation != null) {
            if (this.e != null) {
                final a f = new a();
                final String networkOperator = this.e.getNetworkOperator();
                if (networkOperator != null && networkOperator.length() > 0) {
                    try {
                        final int length = networkOperator.length();
                        final int n = 3;
                        Label_0113: {
                            if (length < n) {
                                break Label_0113;
                            }
                            final String substring = networkOperator.substring(0, n);
                            try {
                                final Integer value = Integer.valueOf(substring);
                                try {
                                    int c = value;
                                    Label_0107: {
                                        if (c >= 0) {
                                            break Label_0107;
                                        }
                                        final a f2 = this.f;
                                        try {
                                            c = f2.c;
                                            f.c = c;
                                            final String s = networkOperator;
                                            try {
                                                final String substring2 = s.substring(n);
                                                Label_0179: {
                                                    if (substring2 == null) {
                                                        break Label_0179;
                                                    }
                                                    final char[] charArray = substring2.toCharArray();
                                                    int n2 = 0;
                                                    while (true) {
                                                        Label_0185: {
                                                            if (n2 >= charArray.length) {
                                                                break Label_0185;
                                                            }
                                                            final char c2 = charArray[n2];
                                                            try {
                                                                if (Character.isDigit(c2)) {
                                                                    ++n2;
                                                                    continue;
                                                                }
                                                                final String substring3 = substring2.substring(0, n2);
                                                                try {
                                                                    final Integer value2 = Integer.valueOf(substring3);
                                                                    try {
                                                                        int d = value2;
                                                                        Label_0220: {
                                                                            if (d >= 0) {
                                                                                break Label_0220;
                                                                            }
                                                                            final a f3 = this.f;
                                                                            try {
                                                                                d = f3.d;
                                                                                f.d = d;
                                                                            }
                                                                            catch (Exception ex) {}
                                                                        }
                                                                    }
                                                                    catch (Exception ex2) {}
                                                                }
                                                                catch (Exception ex3) {}
                                                                n2 = 0;
                                                            }
                                                            catch (Exception ex4) {}
                                                        }
                                                        break;
                                                    }
                                                }
                                            }
                                            catch (Exception ex5) {}
                                        }
                                        catch (Exception ex6) {}
                                    }
                                }
                                catch (Exception ex7) {}
                            }
                            catch (Exception ex8) {}
                        }
                    }
                    catch (Exception ex9) {}
                }
                Label_0744: {
                    if (cellLocation instanceof GsmCellLocation) {
                        final GsmCellLocation gsmCellLocation = (GsmCellLocation)cellLocation;
                        f.a = gsmCellLocation.getLac();
                        f.b = gsmCellLocation.getCid();
                        f.i = 'g';
                    }
                    else if (cellLocation instanceof CdmaCellLocation) {
                        f.i = 'c';
                        if (com.baidu.location.a.c.l == null) {
                            final String s2 = "android.telephony.cdma.CdmaCellLocation";
                            try {
                                final Class<?> forName = Class.forName(s2);
                                try {
                                    com.baidu.location.a.c.l = forName;
                                    final Method method = com.baidu.location.a.c.l.getMethod("getBaseStationId", (Class[])new Class[0]);
                                    try {
                                        com.baidu.location.a.c.g = method;
                                        final Method method2 = com.baidu.location.a.c.l.getMethod("getNetworkId", (Class[])new Class[0]);
                                        try {
                                            com.baidu.location.a.c.h = method2;
                                            final Method method3 = com.baidu.location.a.c.l.getMethod("getSystemId", (Class[])new Class[0]);
                                            try {
                                                com.baidu.location.a.c.i = method3;
                                                final Method method4 = com.baidu.location.a.c.l.getMethod("getBaseStationLatitude", (Class[])new Class[0]);
                                                try {
                                                    com.baidu.location.a.c.j = method4;
                                                    final Method method5 = com.baidu.location.a.c.l.getMethod("getBaseStationLongitude", (Class[])new Class[0]);
                                                    try {
                                                        com.baidu.location.a.c.k = method5;
                                                    }
                                                    catch (Exception ex10) {
                                                        com.baidu.location.a.c.l = null;
                                                        return;
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
                        final Class l = com.baidu.location.a.c.l;
                        if (l != null && l.isInstance(cellLocation)) {
                            try {
                                final Method i = com.baidu.location.a.c.i;
                                try {
                                    final Object invoke = i.invoke(cellLocation, new Object[0]);
                                    try {
                                        final Integer n3 = (Integer)invoke;
                                        try {
                                            int d2 = n3;
                                            Label_0545: {
                                                if (d2 >= 0) {
                                                    break Label_0545;
                                                }
                                                final a f4 = this.f;
                                                try {
                                                    d2 = f4.d;
                                                    f.d = d2;
                                                    final Method g = com.baidu.location.a.c.g;
                                                    try {
                                                        final Object invoke2 = g.invoke(cellLocation, new Object[0]);
                                                        try {
                                                            final Integer n4 = (Integer)invoke2;
                                                            try {
                                                                f.b = n4;
                                                                final Method h = com.baidu.location.a.c.h;
                                                                try {
                                                                    final Object invoke3 = h.invoke(cellLocation, new Object[0]);
                                                                    try {
                                                                        final Integer n5 = (Integer)invoke3;
                                                                        try {
                                                                            f.a = n5;
                                                                            final Method j = com.baidu.location.a.c.j;
                                                                            try {
                                                                                final Object invoke4 = j.invoke(cellLocation, new Object[0]);
                                                                                final Integer n6 = (Integer)invoke4;
                                                                                try {
                                                                                    final int intValue = n6;
                                                                                    final int n7 = -1 >>> 1;
                                                                                    Label_0684: {
                                                                                        if (intValue >= n7) {
                                                                                            break Label_0684;
                                                                                        }
                                                                                        final Integer n8 = (Integer)invoke4;
                                                                                        try {
                                                                                            f.e = n8;
                                                                                            final Method k = com.baidu.location.a.c.k;
                                                                                            try {
                                                                                                final Object invoke5 = k.invoke(cellLocation, new Object[0]);
                                                                                                final Integer n9 = (Integer)invoke5;
                                                                                                try {
                                                                                                    if (n9 >= n7) {
                                                                                                        break Label_0744;
                                                                                                    }
                                                                                                    final Integer n10 = (Integer)invoke5;
                                                                                                    try {
                                                                                                        f.f = n10;
                                                                                                    }
                                                                                                    catch (Exception ex17) {
                                                                                                        return;
                                                                                                    }
                                                                                                }
                                                                                                catch (Exception ex18) {}
                                                                                            }
                                                                                            catch (Exception ex19) {}
                                                                                        }
                                                                                        catch (Exception ex20) {}
                                                                                    }
                                                                                }
                                                                                catch (Exception ex21) {}
                                                                            }
                                                                            catch (Exception ex22) {}
                                                                        }
                                                                        catch (Exception ex23) {}
                                                                    }
                                                                    catch (Exception ex24) {}
                                                                }
                                                                catch (Exception ex25) {}
                                                            }
                                                            catch (Exception ex26) {}
                                                        }
                                                        catch (Exception ex27) {}
                                                    }
                                                    catch (Exception ex28) {}
                                                }
                                                catch (Exception ex29) {}
                                            }
                                        }
                                        catch (Exception ex30) {}
                                    }
                                    catch (Exception ex31) {}
                                }
                                catch (Exception ex32) {}
                            }
                            catch (Exception ex33) {}
                        }
                    }
                }
                if (f.b()) {
                    this.f = f;
                }
                else {
                    this.f = null;
                }
            }
        }
    }
    
    private String b(int n) {
        String string = null;
        try {
            final a d = this.d();
            if (d != null && d.b()) {
                this.f = d;
            }
            else {
                this.a(this.e.getCellLocation());
            }
            String g;
            if (this.f != null && this.f.b()) {
                g = this.f.g();
            }
            else {
                g = null;
            }
            try {
                if (!TextUtils.isEmpty((CharSequence)g) && this.f.j != null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(g);
                    sb.append(this.f.j);
                    sb.toString();
                }
            }
            finally {}
        }
        finally {
            string = null;
        }
        String a = null;
        try {
            this.n = null;
            try {
                final WifiManager m = this.m;
                try {
                    final c$c n2 = new c$c(this, m.getScanResults());
                    try {
                        this.n = n2;
                        a = this.n.a(n);
                    }
                    catch (Exception ex) {
                        n = 0;
                        a = null;
                    }
                }
                catch (Exception ex2) {}
            }
            catch (Exception ex3) {}
        }
        catch (Exception ex4) {}
        if (string == null && a == null) {
            return this.r = null;
        }
        if (a != null) {
            if (string == null) {
                string = a;
            }
            else {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(a);
                string = sb2.toString();
            }
        }
        if (string == null) {
            return null;
        }
        this.r = string;
        if (this.o != null) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(this.r);
            sb3.append(this.o);
            this.r = sb3.toString();
        }
        final StringBuilder sb4 = new StringBuilder();
        sb4.append(string);
        sb4.append(this.o);
        return sb4.toString();
    }
    
    private a d() {
        final int intValue = Integer.valueOf(Build$VERSION.SDK_INT);
        a a = null;
        if (intValue < 17) {
            return null;
        }
        try {
            final List allCellInfo = this.e.getAllCellInfo();
            if (allCellInfo != null && allCellInfo.size() > 0) {
                final Iterator<CellInfo> iterator = allCellInfo.iterator();
                a a2 = null;
                while (iterator.hasNext()) {
                    final CellInfo cellInfo = iterator.next();
                    if (cellInfo.isRegistered()) {
                        boolean b = false;
                        if (a2 != null) {
                            b = true;
                        }
                        a a3 = this.a(cellInfo);
                        if (a3 == null) {
                            continue;
                        }
                        if (!a3.b()) {
                            a3 = null;
                        }
                        else if (b) {
                            a2.j = a3.h();
                            return a2;
                        }
                        if (a2 != null) {
                            continue;
                        }
                        a2 = a3;
                    }
                }
                a = a2;
            }
        }
        finally {}
        return a;
    }
    
    public String a() {
        String macAddress = null;
        try {
            final WifiManager m = this.m;
            try {
                final WifiInfo connectionInfo = m.getConnectionInfo();
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
    
    public String b() {
        final int n = 15;
        try {
            return this.b(n);
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public void c() {
        final String r = this.r;
        if (r == null) {
            return;
        }
        this.c.a(r);
    }
}
