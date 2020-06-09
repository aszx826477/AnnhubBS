// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.media.VolumeProvider;

class VolumeProviderCompatApi21
{
    public static Object createVolumeProvider(final int n, final int n2, final int n3, final VolumeProviderCompatApi21$Delegate volumeProviderCompatApi21$Delegate) {
        return new VolumeProviderCompatApi21$1(n, n2, n3, volumeProviderCompatApi21$Delegate);
    }
    
    public static void setCurrentVolume(final Object o, final int currentVolume) {
        ((VolumeProvider)o).setCurrentVolume(currentVolume);
    }
}
