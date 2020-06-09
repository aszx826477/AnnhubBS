// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.net;

import android.net.NetworkInfo;
import android.net.ConnectivityManager;

class ConnectivityManagerCompatHoneycombMR2
{
    public static boolean isActiveNetworkMetered(final ConnectivityManager connectivityManager) {
        final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        final boolean b = true;
        if (activeNetworkInfo == null) {
            return b;
        }
        switch (activeNetworkInfo.getType()) {
            default: {
                return b;
            }
            case 1:
            case 7:
            case 9: {
                return false;
            }
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6: {
                return b;
            }
        }
    }
}
