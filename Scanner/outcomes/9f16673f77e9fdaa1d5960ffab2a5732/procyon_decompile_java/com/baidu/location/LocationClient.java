// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location;

import android.location.Location;
import android.text.TextUtils;
import com.baidu.location.a.j;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.location.a.k;
import android.os.Bundle;
import android.os.Message;
import android.os.Build$VERSION;
import android.os.Parcelable;
import android.app.Notification;
import java.util.Iterator;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import android.os.Messenger;
import android.content.Context;
import android.content.ServiceConnection;
import com.baidu.location.a.c;
import com.baidu.location.a.c$a;

public final class LocationClient implements c$a
{
    public static final int CONNECT_HOT_SPOT_FALSE = 0;
    public static final int CONNECT_HOT_SPOT_TRUE = 1;
    public static final int CONNECT_HOT_SPOT_UNKNOWN = 255;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_GPS = 1;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_WIFI = 2;
    public static final int LOC_DIAGNOSTIC_TYPE_FAIL_UNKNOWN = 9;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_LOC_PERMISSION = 4;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_NET = 3;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CLOSE_FLYMODE = 7;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_INSERT_SIMCARD_OR_OPEN_WIFI = 6;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_OPEN_PHONE_LOC_SWITCH = 5;
    public static final int LOC_DIAGNOSTIC_TYPE_SERVER_FAIL = 8;
    private Boolean A;
    private boolean B;
    private c C;
    private boolean D;
    private boolean E;
    private boolean F;
    private ServiceConnection G;
    private long a;
    private String b;
    private LocationClientOption c;
    private LocationClientOption d;
    private boolean e;
    private Context f;
    private Messenger g;
    private LocationClient$a h;
    private final Messenger i;
    private ArrayList j;
    private ArrayList k;
    private BDLocation l;
    private boolean m;
    private boolean n;
    private boolean o;
    private LocationClient$b p;
    private boolean q;
    private final Object r;
    private long s;
    private long t;
    private String u;
    private String v;
    private boolean w;
    private boolean x;
    private Boolean y;
    private Boolean z;
    
    public LocationClient(final Context f) {
        final long t = 0L;
        this.a = t;
        this.b = null;
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.e = false;
        this.f = null;
        this.g = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = null;
        this.q = false;
        this.r = new Object();
        this.s = t;
        this.t = t;
        this.u = null;
        this.w = false;
        final boolean x = true;
        this.x = x;
        this.y = false;
        this.z = false;
        this.A = x;
        this.C = null;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = (ServiceConnection)new b(this);
        this.f = f;
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.h = new LocationClient$a(Looper.getMainLooper(), this);
        this.i = new Messenger((Handler)this.h);
    }
    
    public LocationClient(final Context f, final LocationClientOption c) {
        final long t = 0L;
        this.a = t;
        this.b = null;
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.e = false;
        this.f = null;
        this.g = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = null;
        this.q = false;
        this.r = new Object();
        this.s = t;
        this.t = t;
        this.u = null;
        this.w = false;
        final boolean x = true;
        this.x = x;
        this.y = false;
        this.z = false;
        this.A = x;
        this.C = null;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = (ServiceConnection)new b(this);
        this.f = f;
        this.c = c;
        this.d = new LocationClientOption(c);
        this.h = new LocationClient$a(Looper.getMainLooper(), this);
        this.i = new Messenger((Handler)this.h);
    }
    
    private void a() {
        final boolean e = this.e;
        final int n = 1;
        if ((e ? 1 : 0) == n) {
            return;
        }
        if (this.A) {
            new com.baidu.location.c(this).start();
            this.A = false;
        }
        this.b = this.f.getPackageName();
        final StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append("_bdls_v2.9");
        this.u = sb.toString();
        final Intent intent = new Intent(this.f, (Class)f.class);
        final String s = "debug_dev";
        try {
            intent.putExtra(s, this.B);
        }
        catch (Exception ex2) {}
        if (this.c == null) {
            this.c = new LocationClientOption();
        }
        intent.putExtra("cache_exception", this.c.isIgnoreCacheException);
        intent.putExtra("kill_process", this.c.isIgnoreKillProcess);
        try {
            final Context f = this.f;
            try {
                f.bindService(intent, this.G, n);
            }
            catch (Exception ex) {
                ex.printStackTrace();
                this.e = false;
            }
        }
        catch (Exception ex3) {}
    }
    
    private void a(int n) {
        if (this.l.getCoorType() == null) {
            this.l.setCoorType(this.c.coorType);
        }
        n = (this.m ? 1 : 0);
        final int n2 = 67;
        final int n3 = 66;
        final boolean b = true;
        Label_0150: {
            if (n != (b ? 1 : 0)) {
                n = (this.c.location_change_notify ? 1 : 0);
                if (n == (b ? 1 : 0)) {
                    n = this.l.getLocType();
                    if (n == 61) {
                        break Label_0150;
                    }
                }
                n = this.l.getLocType();
                if (n != n3) {
                    n = this.l.getLocType();
                    if (n != n2) {
                        n = (this.w ? 1 : 0);
                        if (n == 0) {
                            n = this.l.getLocType();
                            if (n != 161) {
                                return;
                            }
                        }
                    }
                }
            }
        }
        final ArrayList j = this.j;
        if (j != null) {
            final Iterator<BDLocationListener> iterator = j.iterator();
            while (iterator.hasNext()) {
                iterator.next().onReceiveLocation(this.l);
            }
        }
        final ArrayList k = this.k;
        if (k != null) {
            final Iterator<BDAbstractLocationListener> iterator2 = k.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().onReceiveLocation(this.l);
            }
        }
        n = this.l.getLocType();
        if (n != n3) {
            n = this.l.getLocType();
            if (n != n2) {
                n = 0;
                this.m = false;
                this.t = System.currentTimeMillis();
            }
        }
    }
    
    private void a(int sdk_INT, final Notification notification) {
        try {
            try {
                final Intent intent = new Intent(this.f, (Class)f.class);
                intent.putExtra("notification", (Parcelable)notification);
                intent.putExtra("id", sdk_INT);
                final String s = "command";
                final int f = 1;
                intent.putExtra(s, f);
                sdk_INT = Build$VERSION.SDK_INT;
                if (sdk_INT >= 26) {
                    this.f.startForegroundService(intent);
                }
                else {
                    this.f.startService(intent);
                }
                try {
                    this.F = (f != 0);
                }
                catch (Exception ex) {}
            }
            catch (Exception ex2) {}
        }
        catch (Exception ex3) {}
    }
    
    private void a(Message obtain) {
        this.n = false;
        if (obtain != null) {
            if (obtain.obj != null) {
                obtain = (Message)obtain.obj;
                if (!this.c.optionEquals((LocationClientOption)obtain)) {
                    if (this.c.scanSpan != ((LocationClientOption)obtain).scanSpan) {
                        try {
                            final Object r = this.r;
                            try {
                                synchronized (r) {
                                    final boolean o = this.o;
                                    final boolean o2 = true;
                                    if (o == o2) {
                                        this.h.removeCallbacks((Runnable)this.p);
                                        this.o = false;
                                    }
                                    if (((LocationClientOption)obtain).scanSpan >= 1000 && !this.o) {
                                        if (this.p == null) {
                                            this.p = new LocationClient$b(this, null);
                                        }
                                        this.h.postDelayed((Runnable)this.p, (long)((LocationClientOption)obtain).scanSpan);
                                        this.o = o2;
                                    }
                                }
                            }
                            catch (Exception ex2) {}
                        }
                        catch (Exception ex3) {}
                    }
                    this.c = new LocationClientOption((LocationClientOption)obtain);
                    if (this.g == null) {
                        return;
                    }
                    final int n = 15;
                    final Handler handler = null;
                    try {
                        obtain = Message.obtain(handler, n);
                        try {
                            obtain.replyTo = this.i;
                            obtain.setData(this.c());
                            this.g.send(obtain);
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    catch (Exception ex4) {}
                }
            }
        }
    }
    
    private void a(final Message message, final int n) {
        if (!this.e) {
            return;
        }
        try {
            final Bundle data = message.getData();
            data.setClassLoader(BDLocation.class.getClassLoader());
            final Parcelable parcelable = data.getParcelable("locStr");
            try {
                this.l = (BDLocation)parcelable;
                final BDLocation l = this.l;
                try {
                    if (l.getLocType() == 61) {
                        this.s = System.currentTimeMillis();
                    }
                    try {
                        this.a(n);
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {}
            }
            catch (Exception ex3) {}
        }
        catch (Exception ex4) {}
    }
    
    private void a(final BDLocation l) {
        if (this.x) {
            return;
        }
        this.l = l;
        if (!this.E && l.getLocType() == 161) {
            this.D = true;
        }
        final ArrayList j = this.j;
        if (j != null) {
            final Iterator<BDLocationListener> iterator = j.iterator();
            while (iterator.hasNext()) {
                iterator.next().onReceiveLocation(l);
            }
        }
        final ArrayList k = this.k;
        if (k != null) {
            final Iterator<BDAbstractLocationListener> iterator2 = k.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().onReceiveLocation(l);
            }
        }
    }
    
    private void a(final boolean b) {
        try {
            try {
                final Intent intent = new Intent(this.f, (Class)f.class);
                intent.putExtra("removenotify", b);
                intent.putExtra("command", 2);
                this.f.startService(intent);
                this.F = true;
            }
            catch (Exception ex) {}
        }
        catch (Exception ex2) {}
    }
    
    private void b() {
        if (this.e) {
            if (this.g != null) {
                final Message obtain = Message.obtain((Handler)null, 12);
                obtain.replyTo = this.i;
                try {
                    this.g.send(obtain);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    final Context f = this.f;
                    try {
                        f.unbindService(this.G);
                        if (this.F) {
                            try {
                                try {
                                    this.f.stopService(new Intent(this.f, (Class)f.class));
                                }
                                catch (Exception ex2) {}
                            }
                            catch (Exception ex3) {}
                            this.F = false;
                        }
                    }
                    catch (Exception ex4) {}
                }
                catch (Exception ex5) {}
                final Object r = this.r;
                // monitorenter(r)
                try {
                    if (this.o) {
                        final LocationClient$a h = this.h;
                        try {
                            h.removeCallbacks((Runnable)this.p);
                            final boolean b = false;
                            this.o = b;
                        }
                        catch (Exception ex6) {}
                    }
                }
                catch (Exception ex7) {}
                finally {
                    // monitorexit(r)
                    this.g = null;
                    this.n = false;
                    this.w = false;
                    this.e = false;
                    this.D = false;
                    this.E = false;
                    return;
                }
                // monitorexit(r)
                try {
                    final boolean b = false;
                    this.o = b;
                }
                catch (Exception ex8) {}
            }
        }
    }
    
    private void b(final Message message) {
        if (message != null) {
            if (message.obj != null) {
                final BDLocationListener bdLocationListener = (BDLocationListener)message.obj;
                if (this.j == null) {
                    this.j = new ArrayList();
                }
                if (!this.j.contains(bdLocationListener)) {
                    this.j.add(bdLocationListener);
                }
            }
        }
    }
    
    private Bundle c() {
        if (this.c == null) {
            return null;
        }
        final Bundle bundle = new Bundle();
        bundle.putString("packName", this.b);
        bundle.putString("prodName", this.c.prodName);
        bundle.putString("coorType", this.c.coorType);
        bundle.putString("addrType", this.c.addrType);
        bundle.putBoolean("openGPS", this.c.openGps);
        bundle.putBoolean("location_change_notify", this.c.location_change_notify);
        bundle.putInt("scanSpan", this.c.scanSpan);
        bundle.putBoolean("enableSimulateGps", this.c.enableSimulateGps);
        bundle.putInt("timeOut", this.c.timeOut);
        bundle.putInt("priority", this.c.priority);
        bundle.putBoolean("map", (boolean)this.y);
        bundle.putBoolean("import", (boolean)this.z);
        bundle.putBoolean("needDirect", this.c.mIsNeedDeviceDirect);
        bundle.putBoolean("isneedaptag", this.c.isNeedAptag);
        bundle.putBoolean("isneedpoiregion", this.c.isNeedPoiRegion);
        bundle.putBoolean("isneedregular", this.c.isNeedRegular);
        bundle.putBoolean("isneedaptagd", this.c.isNeedAptagd);
        bundle.putBoolean("isneedaltitude", this.c.isNeedAltitude);
        bundle.putInt("autoNotifyMaxInterval", this.c.a());
        bundle.putInt("autoNotifyMinTimeInterval", this.c.getAutoNotifyMinTimeInterval());
        bundle.putInt("autoNotifyMinDistance", this.c.getAutoNotifyMinDistance());
        bundle.putFloat("autoNotifyLocSensitivity", this.c.b());
        bundle.putInt("wifitimeout", this.c.wifiCacheTimeOut);
        return bundle;
    }
    
    private void c(final Message message) {
        if (message != null) {
            if (message.obj != null) {
                final BDAbstractLocationListener bdAbstractLocationListener = (BDAbstractLocationListener)message.obj;
                if (this.k == null) {
                    this.k = new ArrayList();
                }
                if (!this.k.contains(bdAbstractLocationListener)) {
                    this.k.add(bdAbstractLocationListener);
                }
            }
        }
    }
    
    private void d() {
        if (this.g == null) {
            return;
        }
        final long n = System.currentTimeMillis() - this.s;
        final long n2 = 3000L;
        final boolean b = true;
        if ((n > n2 || !this.c.location_change_notify || this.n) && (!this.w || System.currentTimeMillis() - this.t > 20000L || this.n)) {
            final Message obtain = Message.obtain((Handler)null, 22);
            if (this.n) {
                final Bundle data = new Bundle();
                data.putBoolean("isWaitingLocTag", this.n);
                this.n = false;
                obtain.setData(data);
            }
            try {
                obtain.replyTo = this.i;
                this.g.send(obtain);
                this.a = System.currentTimeMillis();
                try {
                    this.m = b;
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            catch (Exception ex2) {}
        }
        synchronized (this.r) {
            if (this.c != null && this.c.scanSpan >= 1000 && !this.o) {
                if (this.p == null) {
                    this.p = new LocationClient$b(this, null);
                }
                this.h.postDelayed((Runnable)this.p, (long)this.c.scanSpan);
                this.o = b;
            }
        }
    }
    
    private void d(final Message message) {
        if (message != null) {
            if (message.obj != null) {
                final BDAbstractLocationListener bdAbstractLocationListener = (BDAbstractLocationListener)message.obj;
                final ArrayList k = this.k;
                if (k != null && k.contains(bdAbstractLocationListener)) {
                    this.k.remove(bdAbstractLocationListener);
                }
            }
        }
    }
    
    private void e(final Message message) {
        if (message != null) {
            if (message.obj != null) {
                final BDLocationListener bdLocationListener = (BDLocationListener)message.obj;
                final ArrayList j = this.j;
                if (j != null && j.contains(bdLocationListener)) {
                    this.j.remove(bdLocationListener);
                }
            }
        }
    }
    
    public static BDLocation getBDLocationInCoorType(final BDLocation bdLocation, final String s) {
        final BDLocation bdLocation2 = new BDLocation(bdLocation);
        final double[] coorEncrypt = Jni.coorEncrypt(bdLocation.getLongitude(), bdLocation.getLatitude(), s);
        bdLocation2.setLatitude(coorEncrypt[1]);
        bdLocation2.setLongitude(coorEncrypt[0]);
        return bdLocation2;
    }
    
    public void disableAssistantLocation() {
        com.baidu.location.a.k.a().b();
    }
    
    public void disableLocInForeground(final boolean b) {
        final Bundle data = new Bundle();
        data.putBoolean("removenotify", b);
        final Message obtainMessage = this.h.obtainMessage(704);
        obtainMessage.setData(data);
        obtainMessage.sendToTarget();
    }
    
    public void enableAssistantLocation(final WebView webView) {
        com.baidu.location.a.k.a().a(this.f, webView, this);
    }
    
    public void enableLocInForeground(final int n, final Notification notification) {
        if (n > 0 && notification != null) {
            final Bundle data = new Bundle();
            data.putInt("id", n);
            data.putParcelable("notification", (Parcelable)notification);
            final Message obtainMessage = this.h.obtainMessage(703);
            obtainMessage.setData(data);
            obtainMessage.sendToTarget();
        }
        else {
            Log.e("baidu_location_Client", "can not startLocInForeground if the param is unlegal");
        }
    }
    
    public String getAccessKey() {
        try {
            final Context f = this.f;
            try {
                this.v = com.baidu.location.a.j.b(f);
                final String v = this.v;
                try {
                    Label_0060: {
                        if (TextUtils.isEmpty((CharSequence)v)) {
                            break Label_0060;
                        }
                        final String s = "KEY=%s";
                        final Object[] array = { null };
                        try {
                            array[0] = this.v;
                            final String s2 = s;
                            try {
                                return String.format(s2, array);
                                throw new IllegalStateException("please setting key from Manifest.xml");
                            }
                            catch (Exception ex) {
                                return null;
                            }
                        }
                        catch (Exception ex2) {}
                    }
                }
                catch (Exception ex3) {}
            }
            catch (Exception ex4) {}
        }
        catch (Exception ex5) {}
    }
    
    public BDLocation getLastKnownLocation() {
        return this.l;
    }
    
    public LocationClientOption getLocOption() {
        return this.c;
    }
    
    public String getVersion() {
        return "7.5.2";
    }
    
    public boolean isStarted() {
        return this.e;
    }
    
    public void onReceiveLocation(final BDLocation obj) {
        if (this.E && !this.D) {
            return;
        }
        if (obj == null) {
            return;
        }
        final Message obtainMessage = this.h.obtainMessage(701);
        obtainMessage.obj = obj;
        obtainMessage.sendToTarget();
    }
    
    public void registerLocationListener(final BDAbstractLocationListener obj) {
        if (obj != null) {
            final Message obtainMessage = this.h.obtainMessage(1300);
            obtainMessage.obj = obj;
            obtainMessage.sendToTarget();
            return;
        }
        throw new IllegalStateException("please set a non-null listener");
    }
    
    public void registerLocationListener(final BDLocationListener obj) {
        if (obj != null) {
            final Message obtainMessage = this.h.obtainMessage(5);
            obtainMessage.obj = obj;
            obtainMessage.sendToTarget();
            return;
        }
        throw new IllegalStateException("please set a non-null listener");
    }
    
    public boolean requestHotSpotState() {
        if (this.g != null) {
            if (this.e) {
                final int n = 406;
                final Handler handler = null;
                try {
                    final Message obtain = Message.obtain(handler, n);
                    try {
                        this.g.send(obtain);
                        return true;
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {}
            }
        }
        return false;
    }
    
    public int requestLocation() {
        final Messenger g = this.g;
        final int n = 1;
        if (g == null || this.i == null) {
            return n;
        }
        final ArrayList j = this.j;
        if (j == null || j.size() < n) {
            final ArrayList k = this.k;
            if (k == null || k.size() < n) {
                return 2;
            }
        }
        if (System.currentTimeMillis() - this.a < 1000L) {
            return 6;
        }
        this.n = (n != 0);
        final Message obtainMessage = this.h.obtainMessage(4);
        obtainMessage.arg1 = 0;
        obtainMessage.sendToTarget();
        return 0;
    }
    
    public void restart() {
        this.stop();
        this.x = false;
        this.h.sendEmptyMessageDelayed(1, 1000L);
    }
    
    public void setLocOption(LocationClientOption obj) {
        if (obj == null) {
            obj = new LocationClientOption();
        }
        if (obj.a() > 0) {
            obj.setScanSpan(0);
            obj.setLocationNotify(true);
        }
        this.d = new LocationClientOption(obj);
        final Message obtainMessage = this.h.obtainMessage(3);
        obtainMessage.obj = obj;
        obtainMessage.sendToTarget();
    }
    
    public void start() {
        this.x = false;
        this.h.obtainMessage(1).sendToTarget();
    }
    
    public void stop() {
        this.x = true;
        this.h.obtainMessage(2).sendToTarget();
        this.C = null;
    }
    
    public void unRegisterLocationListener(final BDAbstractLocationListener obj) {
        if (obj != null) {
            final Message obtainMessage = this.h.obtainMessage(1400);
            obtainMessage.obj = obj;
            obtainMessage.sendToTarget();
            return;
        }
        throw new IllegalStateException("please set a non-null listener");
    }
    
    public void unRegisterLocationListener(final BDLocationListener obj) {
        if (obj != null) {
            final Message obtainMessage = this.h.obtainMessage(6);
            obtainMessage.obj = obj;
            obtainMessage.sendToTarget();
            return;
        }
        throw new IllegalStateException("please set a non-null listener");
    }
    
    public boolean updateLocation(final Location obj) {
        if (this.g != null && this.i != null && obj != null) {
            final int n = 57;
            final Handler handler = null;
            try {
                final Message obtain = Message.obtain(handler, n);
                obtain.obj = obj;
                this.g.send(obtain);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
