// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.Service;
import android.support.v4.os.BuildCompat;

public final class ServiceCompat
{
    static final ServiceCompat$ServiceCompatImpl IMPL;
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;
    
    static {
        if (BuildCompat.isAtLeastN()) {
            IMPL = new ServiceCompat$Api24ServiceCompatImpl();
        }
        else {
            IMPL = new ServiceCompat$BaseServiceCompatImpl();
        }
    }
    
    public static void stopForeground(final Service service, final int n) {
        ServiceCompat.IMPL.stopForeground(service, n);
    }
}
