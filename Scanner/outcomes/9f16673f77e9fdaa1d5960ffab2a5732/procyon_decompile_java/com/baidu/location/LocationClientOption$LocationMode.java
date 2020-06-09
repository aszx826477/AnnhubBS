// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location;

public enum LocationClientOption$LocationMode
{
    Battery_Saving("Battery_Saving", n), 
    Device_Sensors("Device_Sensors", n2), 
    Hight_Accuracy("Hight_Accuracy", 0);
    
    static {
        final int n = 1;
        final int n2 = 2;
        final LocationClientOption$LocationMode[] $values = { LocationClientOption$LocationMode.Hight_Accuracy, null, null };
        $values[n] = LocationClientOption$LocationMode.Battery_Saving;
        $values[n2] = LocationClientOption$LocationMode.Device_Sensors;
        $VALUES = $values;
    }
    
    private LocationClientOption$LocationMode(final String s, final int n) {
    }
}
