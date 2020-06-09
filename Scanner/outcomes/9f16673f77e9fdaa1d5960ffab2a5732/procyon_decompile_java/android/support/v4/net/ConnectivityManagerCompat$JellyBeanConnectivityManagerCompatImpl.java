// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.net;

import android.net.ConnectivityManager;

class ConnectivityManagerCompat$JellyBeanConnectivityManagerCompatImpl extends ConnectivityManagerCompat$HoneycombMR2ConnectivityManagerCompatImpl
{
    public boolean isActiveNetworkMetered(final ConnectivityManager connectivityManager) {
        return ConnectivityManagerCompatJellyBean.isActiveNetworkMetered(connectivityManager);
    }
}
