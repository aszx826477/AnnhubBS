// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

class VolumeProviderCompat$1 implements VolumeProviderCompatApi21$Delegate
{
    final /* synthetic */ VolumeProviderCompat this$0;
    
    VolumeProviderCompat$1(final VolumeProviderCompat this$0) {
        this.this$0 = this$0;
    }
    
    public void onAdjustVolume(final int n) {
        this.this$0.onAdjustVolume(n);
    }
    
    public void onSetVolumeTo(final int n) {
        this.this$0.onSetVolumeTo(n);
    }
}
