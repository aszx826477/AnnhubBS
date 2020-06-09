// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.ViewConfiguration;

class ViewConfigurationCompat$IcsViewConfigurationVersionImpl extends ViewConfigurationCompat$HoneycombViewConfigurationVersionImpl
{
    public boolean hasPermanentMenuKey(final ViewConfiguration viewConfiguration) {
        return ViewConfigurationCompatICS.hasPermanentMenuKey(viewConfiguration);
    }
}
