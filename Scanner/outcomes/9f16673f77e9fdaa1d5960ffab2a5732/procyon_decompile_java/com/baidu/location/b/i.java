// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.b;

import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.os.Build$VERSION;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import com.baidu.location.f;
import java.util.List;
import android.net.wifi.ScanResult;
import com.baidu.location.a.a;
import android.os.Handler;
import android.net.wifi.WifiManager;
import com.baidu.location.a.v;
import com.baidu.location.a.t;
import com.baidu.location.a.l;

class i implements Runnable
{
    final /* synthetic */ h$a a;
    
    i(final h$a a) {
        this.a = a;
    }
    
    public void run() {
        this.a.a.r();
        l.c().h();
        if (System.currentTimeMillis() - t.b() <= 5000L) {
            v.a(t.c(), this.a.a.n(), t.d(), t.a());
        }
    }
}
