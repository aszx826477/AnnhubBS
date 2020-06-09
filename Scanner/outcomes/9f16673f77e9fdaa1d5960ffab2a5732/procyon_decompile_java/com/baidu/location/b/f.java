// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.b;

import com.baidu.location.Jni;
import android.os.Bundle;
import android.util.Log;
import android.location.LocationListener;
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
import android.location.GpsStatus;
import android.location.LocationManager;
import android.content.Context;
import java.util.ArrayList;
import android.location.Location;
import android.os.Message;
import android.os.Handler;

class f extends Handler
{
    final /* synthetic */ e a;
    
    f(final e a) {
        this.a = a;
    }
    
    public void handleMessage(final Message message) {
        if (!com.baidu.location.f.isServing) {
            return;
        }
        final int what = message.what;
        if (what != 1) {
            e e = null;
            String s = null;
            switch (what) {
                default: {
                    return;
                }
                case 4: {
                    e = this.a;
                    s = "&og=2";
                    break;
                }
                case 3: {
                    e = this.a;
                    s = "&og=1";
                    break;
                }
            }
            e.a(s, (Location)message.obj);
        }
        else {
            this.a.e((Location)message.obj);
        }
    }
}
