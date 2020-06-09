// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.b;

import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.os.Build$VERSION;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import com.baidu.location.f;
import java.util.List;
import android.net.wifi.ScanResult;
import com.baidu.location.a.a;
import android.os.Handler;
import android.net.wifi.WifiManager;
import android.net.NetworkInfo$State;
import android.net.NetworkInfo;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

class h$a extends BroadcastReceiver
{
    final /* synthetic */ h a;
    private long b;
    private boolean c;
    
    private h$a(final h a) {
        this.a = a;
        this.b = 0L;
        this.c = false;
    }
    
    public void onReceive(final Context context, final Intent intent) {
        if (context == null) {
            return;
        }
        final String action = intent.getAction();
        if (action.equals("android.net.wifi.SCAN_RESULTS")) {
            h.a = System.currentTimeMillis() / 1000L;
            this.a.i.post((Runnable)new i(this));
        }
        else if (action.equals("android.net.wifi.STATE_CHANGE")) {
            if (!((NetworkInfo)intent.getParcelableExtra("networkInfo")).getState().equals((Object)NetworkInfo$State.CONNECTED)) {
                return;
            }
            if (System.currentTimeMillis() - this.b < 5000L) {
                return;
            }
            this.b = System.currentTimeMillis();
            if (!this.c) {
                this.c = true;
            }
        }
    }
}
