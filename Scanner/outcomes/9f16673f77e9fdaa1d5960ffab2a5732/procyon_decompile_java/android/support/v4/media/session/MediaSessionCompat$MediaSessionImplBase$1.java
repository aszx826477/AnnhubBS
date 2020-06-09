// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.VolumeProviderCompat$Callback;

class MediaSessionCompat$MediaSessionImplBase$1 extends VolumeProviderCompat$Callback
{
    final /* synthetic */ MediaSessionCompat$MediaSessionImplBase this$0;
    
    MediaSessionCompat$MediaSessionImplBase$1(final MediaSessionCompat$MediaSessionImplBase this$0) {
        this.this$0 = this$0;
    }
    
    public void onVolumeChanged(final VolumeProviderCompat volumeProviderCompat) {
        if (this.this$0.mVolumeProvider != volumeProviderCompat) {
            return;
        }
        this.this$0.sendVolumeInfoChanged(new ParcelableVolumeInfo(this.this$0.mVolumeType, this.this$0.mLocalStream, volumeProviderCompat.getVolumeControl(), volumeProviderCompat.getMaxVolume(), volumeProviderCompat.getCurrentVolume()));
    }
}
