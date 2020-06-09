// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.manager;

import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import android.content.Context;
import android.content.BroadcastReceiver;

class DefaultConnectivityMonitor implements ConnectivityMonitor
{
    private final BroadcastReceiver connectivityReceiver;
    private final Context context;
    private boolean isConnected;
    private boolean isRegistered;
    private final ConnectivityMonitor$ConnectivityListener listener;
    
    public DefaultConnectivityMonitor(final Context context, final ConnectivityMonitor$ConnectivityListener listener) {
        this.connectivityReceiver = new DefaultConnectivityMonitor$1(this);
        this.context = context.getApplicationContext();
        this.listener = listener;
    }
    
    private boolean isConnected(final Context context) {
        final NetworkInfo activeNetworkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    
    private void register() {
        if (this.isRegistered) {
            return;
        }
        this.isConnected = this.isConnected(this.context);
        this.context.registerReceiver(this.connectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.isRegistered = true;
    }
    
    private void unregister() {
        if (!this.isRegistered) {
            return;
        }
        this.context.unregisterReceiver(this.connectivityReceiver);
        this.isRegistered = false;
    }
    
    public void onDestroy() {
    }
    
    public void onStart() {
        this.register();
    }
    
    public void onStop() {
        this.unregister();
    }
}
