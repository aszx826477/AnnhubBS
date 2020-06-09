// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.net;

import android.net.ConnectivityManager;

class ConnectivityManagerCompat$Api24ConnectivityManagerCompatImpl extends ConnectivityManagerCompat$JellyBeanConnectivityManagerCompatImpl
{
    public int getRestrictBackgroundStatus(final ConnectivityManager connectivityManager) {
        return ConnectivityManagerCompatApi24.getRestrictBackgroundStatus(connectivityManager);
    }
}
