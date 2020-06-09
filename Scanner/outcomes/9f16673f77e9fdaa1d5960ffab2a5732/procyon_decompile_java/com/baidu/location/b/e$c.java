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
import com.baidu.location.a.v;
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
import android.location.Location;
import android.location.LocationListener;

class e$c implements LocationListener
{
    final /* synthetic */ e a;
    
    private e$c(final e a) {
        this.a = a;
    }
    
    public void onLocationChanged(final Location location) {
        this.a.t = System.currentTimeMillis();
        this.a.b(true);
        this.a.d(location);
        this.a.p = false;
    }
    
    public void onProviderDisabled(final String s) {
        this.a.d(null);
        this.a.b(false);
    }
    
    public void onProviderEnabled(final String s) {
    }
    
    public void onStatusChanged(final String s, final int n, final Bundle bundle) {
        switch (n) {
            default: {
                return;
            }
            case 2: {
                this.a.p = false;
                return;
            }
            case 1: {
                this.a.o = System.currentTimeMillis();
                this.a.p = true;
                break;
            }
            case 0: {
                this.a.d(null);
                break;
            }
        }
        this.a.b(false);
    }
}
