// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.manager;

import android.content.Context;

public class ConnectivityMonitorFactory
{
    public ConnectivityMonitor build(final Context context, final ConnectivityMonitor$ConnectivityListener connectivityMonitor$ConnectivityListener) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            return new DefaultConnectivityMonitor(context, connectivityMonitor$ConnectivityListener);
        }
        return new NullConnectivityMonitor();
    }
}
