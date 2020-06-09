// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.b;

import com.baidu.location.Jni;
import android.os.Bundle;
import android.util.Log;
import android.location.LocationListener;
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
import android.location.Location;
import java.util.ArrayList;
import android.location.GnssStatus;
import android.location.GnssStatus$Callback;

class e$a extends GnssStatus$Callback
{
    final /* synthetic */ e a;
    
    private e$a(final e a) {
        this.a = a;
    }
    
    public void onFirstFix(final int n) {
    }
    
    public void onSatelliteStatusChanged(final GnssStatus gnssStatus) {
        if (this.a.e == null) {
            return;
        }
        final int satelliteCount = gnssStatus.getSatelliteCount();
        this.a.F.clear();
        int i = 0;
        int n = 0;
        int n2 = 0;
        while (i < satelliteCount) {
            final ArrayList<Float> list = new ArrayList<Float>();
            if (gnssStatus.usedInFix(i)) {
                ++n;
                if (gnssStatus.getConstellationType(i) == 1) {
                    ++n2;
                    list.add(gnssStatus.getCn0DbHz(i));
                    list.add(0.0f);
                    list.add(gnssStatus.getAzimuthDegrees(i));
                    list.add(gnssStatus.getElevationDegrees(i));
                    list.add(1.0f);
                }
                this.a.F.add(list);
            }
            ++i;
        }
        e.m = n;
        e.n = n2;
    }
    
    public void onStarted() {
    }
    
    public void onStopped() {
        this.a.d(null);
        this.a.b(false);
        e.m = 0;
        e.n = 0;
    }
}
