// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import com.baidu.location.Jni;
import android.os.Parcelable;
import com.baidu.location.BDLocation;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import com.baidu.location.d.j;
import com.baidu.location.d.b;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import android.os.Messenger;

class a$a
{
    public String a;
    public Messenger b;
    public LocationClientOption c;
    public int d;
    final /* synthetic */ a e;
    
    public a$a(final a e, final Message message) {
        this.e = e;
        this.a = null;
        this.b = null;
        this.c = new LocationClientOption();
        this.d = 0;
        this.b = message.replyTo;
        this.a = message.getData().getString("packName");
        this.c.prodName = message.getData().getString("prodName");
        com.baidu.location.d.b.a().a(this.c.prodName, this.a);
        this.c.coorType = message.getData().getString("coorType");
        this.c.addrType = message.getData().getString("addrType");
        this.c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
        final boolean l = j.l;
        boolean i = true;
        j.l = (l || this.c.enableSimulateGps);
        if (!j.g.equals("all")) {
            j.g = this.c.addrType;
        }
        this.c.openGps = message.getData().getBoolean("openGPS");
        this.c.scanSpan = message.getData().getInt("scanSpan");
        this.c.timeOut = message.getData().getInt("timeOut");
        this.c.priority = message.getData().getInt("priority");
        this.c.location_change_notify = message.getData().getBoolean("location_change_notify");
        this.c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
        this.c.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
        j.h = (j.h || message.getData().getBoolean("isneedaptag", false));
        if (!j.i) {
            if (!message.getData().getBoolean("isneedaptagd", false)) {
                i = false;
            }
        }
        j.i = i;
        j.Q = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
        final int int1 = message.getData().getInt("wifitimeout", -1 >>> 1);
        if (int1 < j.ae) {
            j.ae = int1;
        }
        final int int2 = message.getData().getInt("autoNotifyMaxInterval", 0);
        if (int2 >= j.V) {
            j.V = int2;
        }
        final int int3 = message.getData().getInt("autoNotifyMinDistance", 0);
        if (int3 >= j.X) {
            j.X = int3;
        }
        final int int4 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
        if (int4 >= j.W) {
            j.W = int4;
        }
        final int scanSpan = this.c.scanSpan;
        if (this.c.mIsNeedDeviceDirect || this.c.isNeedAltitude) {
            n.a().a(this.c.mIsNeedDeviceDirect);
            n.a().b();
        }
        e.b |= this.c.isNeedAltitude;
    }
    
    private void a(int d) {
        final Message obtain = Message.obtain((Handler)null, d);
        try {
            if (this.b != null) {
                this.b.send(obtain);
            }
            d = 0;
            this.d = 0;
        }
        catch (Exception ex) {
            d = ((ex instanceof DeadObjectException) ? 1 : 0);
            if (d != 0) {
                d = this.d + 1;
                this.d = d;
            }
        }
    }
    
    private void a(int n, final Bundle data) {
        final Message obtain = Message.obtain((Handler)null, n);
        obtain.setData(data);
        try {
            if (this.b != null) {
                this.b.send(obtain);
            }
            n = 0;
            this.d = 0;
        }
        catch (Exception ex) {
            if (ex instanceof DeadObjectException) {
                ++this.d;
            }
            ex.printStackTrace();
        }
    }
    
    private void a(int d, final String s, final BDLocation bdLocation) {
        final Bundle data = new Bundle();
        data.putParcelable(s, (Parcelable)bdLocation);
        data.setClassLoader(BDLocation.class.getClassLoader());
        final Message obtain = Message.obtain((Handler)null, d);
        obtain.setData(data);
        try {
            if (this.b != null) {
                this.b.send(obtain);
            }
            d = 0;
            this.d = 0;
        }
        catch (Exception ex) {
            d = ((ex instanceof DeadObjectException) ? 1 : 0);
            if (d != 0) {
                d = this.d + 1;
                this.d = d;
            }
        }
    }
    
    public void a() {
        if (this.c.location_change_notify) {
            int n;
            if (j.b) {
                n = 54;
            }
            else {
                n = 55;
            }
            this.a(n);
        }
    }
    
    public void a(final BDLocation bdLocation) {
        this.a(bdLocation, 21);
    }
    
    public void a(final BDLocation bdLocation, final int n) {
        final BDLocation bdLocation2 = new BDLocation(bdLocation);
        if (n == 21) {
            this.a(27, "locStr", bdLocation2);
        }
        Label_0312: {
            if (this.c.coorType != null && !this.c.coorType.equals("gcj02")) {
                final double longitude = bdLocation2.getLongitude();
                final double latitude = bdLocation2.getLatitude();
                final double n2 = Double.MIN_VALUE;
                if (longitude != n2 && latitude != n2) {
                    final String coorType = bdLocation2.getCoorType();
                    final int n3 = 1;
                    String coorType2;
                    if ((coorType != null && bdLocation2.getCoorType().equals("gcj02")) || bdLocation2.getCoorType() == null) {
                        final double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.c.coorType);
                        bdLocation2.setLongitude(coorEncrypt[0]);
                        bdLocation2.setLatitude(coorEncrypt[n3]);
                        coorType2 = this.c.coorType;
                    }
                    else {
                        if (bdLocation2.getCoorType() == null || !bdLocation2.getCoorType().equals("wgs84") || this.c.coorType.equals("bd09ll")) {
                            break Label_0312;
                        }
                        final double[] coorEncrypt2 = Jni.coorEncrypt(longitude, latitude, "wgs842mc");
                        bdLocation2.setLongitude(coorEncrypt2[0]);
                        bdLocation2.setLatitude(coorEncrypt2[n3]);
                        coorType2 = "wgs84mc";
                    }
                    bdLocation2.setCoorType(coorType2);
                }
            }
        }
        this.a(n, "locStr", bdLocation2);
    }
}
