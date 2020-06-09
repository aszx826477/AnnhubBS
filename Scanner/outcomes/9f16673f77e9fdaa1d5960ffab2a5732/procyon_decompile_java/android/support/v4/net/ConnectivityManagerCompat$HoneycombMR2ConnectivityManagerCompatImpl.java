// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.net;

import android.net.ConnectivityManager;

class ConnectivityManagerCompat$HoneycombMR2ConnectivityManagerCompatImpl extends ConnectivityManagerCompat$BaseConnectivityManagerCompatImpl
{
    public boolean isActiveNetworkMetered(final ConnectivityManager connectivityManager) {
        return ConnectivityManagerCompatHoneycombMR2.isActiveNetworkMetered(connectivityManager);
    }
}
