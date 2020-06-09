// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.Service;

class ServiceCompat$BaseServiceCompatImpl implements ServiceCompat$ServiceCompatImpl
{
    public void stopForeground(final Service service, final int n) {
        service.stopForeground((n & 0x1) != 0x0);
    }
}
