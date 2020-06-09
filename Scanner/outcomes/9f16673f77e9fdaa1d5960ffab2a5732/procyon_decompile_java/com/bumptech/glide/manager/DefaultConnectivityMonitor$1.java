// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.manager;

import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

class DefaultConnectivityMonitor$1 extends BroadcastReceiver
{
    final /* synthetic */ DefaultConnectivityMonitor this$0;
    
    DefaultConnectivityMonitor$1(final DefaultConnectivityMonitor this$0) {
        this.this$0 = this$0;
    }
    
    public void onReceive(final Context context, final Intent intent) {
        final boolean access$000 = this.this$0.isConnected;
        final DefaultConnectivityMonitor this$0 = this.this$0;
        this$0.isConnected = this$0.isConnected(context);
        if (access$000 != this.this$0.isConnected) {
            this.this$0.listener.onConnectivityChanged(this.this$0.isConnected);
        }
    }
}
