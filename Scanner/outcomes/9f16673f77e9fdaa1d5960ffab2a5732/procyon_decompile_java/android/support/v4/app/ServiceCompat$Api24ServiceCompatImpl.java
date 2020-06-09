// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.Service;

class ServiceCompat$Api24ServiceCompatImpl implements ServiceCompat$ServiceCompatImpl
{
    public void stopForeground(final Service service, final int n) {
        ServiceCompatApi24.stopForeground(service, n);
    }
}
