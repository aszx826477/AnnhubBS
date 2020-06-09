// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.b;

import com.baidu.location.Jni;
import android.util.Log;
import android.location.GnssStatus$Callback;
import android.location.GpsStatus$Listener;
import java.util.Iterator;
import com.baidu.location.d.d;
import com.baidu.location.a.t;
import com.baidu.location.a.a;
import com.baidu.location.d.b;
import com.baidu.location.d.j;
import java.util.Locale;
import android.os.Build$VERSION;
import android.os.Handler;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.content.Context;
import java.util.ArrayList;
import android.os.Bundle;
import com.baidu.location.a.v;
import android.location.Location;
import android.location.LocationListener;

class e$d implements LocationListener
{
    final /* synthetic */ e a;
    private long b;
    
    private e$d(final e a) {
        this.a = a;
        this.b = 0L;
    }
    
    public void onLocationChanged(final Location location) {
        if (this.a.q) {
            return;
        }
        if (location != null && location.getProvider() == "gps") {
            if (System.currentTimeMillis() - this.b < 10000L) {
                return;
            }
            if (v.a(location, false)) {
                this.b = System.currentTimeMillis();
                this.a.v.sendMessage(this.a.v.obtainMessage(4, (Object)location));
            }
        }
    }
    
    public void onProviderDisabled(final String s) {
    }
    
    public void onProviderEnabled(final String s) {
    }
    
    public void onStatusChanged(final String s, final int n, final Bundle bundle) {
    }
}
