// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.net;

import android.net.NetworkInfo;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build$VERSION;

public final class ConnectivityManagerCompat
{
    private static final ConnectivityManagerCompat$ConnectivityManagerCompatImpl IMPL;
    public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
    public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
    public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;
    
    static {
        if (Build$VERSION.SDK_INT >= 24) {
            IMPL = new ConnectivityManagerCompat$Api24ConnectivityManagerCompatImpl();
        }
        else if (Build$VERSION.SDK_INT >= 16) {
            IMPL = new ConnectivityManagerCompat$JellyBeanConnectivityManagerCompatImpl();
        }
        else if (Build$VERSION.SDK_INT >= 13) {
            IMPL = new ConnectivityManagerCompat$HoneycombMR2ConnectivityManagerCompatImpl();
        }
        else {
            IMPL = new ConnectivityManagerCompat$BaseConnectivityManagerCompatImpl();
        }
    }
    
    public static NetworkInfo getNetworkInfoFromBroadcast(final ConnectivityManager connectivityManager, final Intent intent) {
        final NetworkInfo networkInfo = (NetworkInfo)intent.getParcelableExtra("networkInfo");
        if (networkInfo != null) {
            return connectivityManager.getNetworkInfo(networkInfo.getType());
        }
        return null;
    }
    
    public static int getRestrictBackgroundStatus(final ConnectivityManager connectivityManager) {
        return ConnectivityManagerCompat.IMPL.getRestrictBackgroundStatus(connectivityManager);
    }
    
    public static boolean isActiveNetworkMetered(final ConnectivityManager connectivityManager) {
        return ConnectivityManagerCompat.IMPL.isActiveNetworkMetered(connectivityManager);
    }
}
