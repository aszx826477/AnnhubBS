// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.media.VolumeProvider;

final class VolumeProviderCompatApi21$1 extends VolumeProvider
{
    final /* synthetic */ VolumeProviderCompatApi21$Delegate val$delegate;
    
    VolumeProviderCompatApi21$1(final int n, final int n2, final int n3, final VolumeProviderCompatApi21$Delegate val$delegate) {
        this.val$delegate = val$delegate;
        super(n, n2, n3);
    }
    
    public void onAdjustVolume(final int n) {
        this.val$delegate.onAdjustVolume(n);
    }
    
    public void onSetVolumeTo(final int n) {
        this.val$delegate.onSetVolumeTo(n);
    }
}
