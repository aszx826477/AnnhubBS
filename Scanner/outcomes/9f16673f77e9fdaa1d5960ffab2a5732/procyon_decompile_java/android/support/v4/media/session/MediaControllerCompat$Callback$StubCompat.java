// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;

class MediaControllerCompat$Callback$StubCompat extends IMediaControllerCallback$Stub
{
    final /* synthetic */ MediaControllerCompat$Callback this$0;
    
    MediaControllerCompat$Callback$StubCompat(final MediaControllerCompat$Callback this$0) {
        this.this$0 = this$0;
    }
    
    public void onCaptioningEnabledChanged(final boolean b) {
        this.this$0.mHandler.post(11, b, null);
    }
    
    public void onEvent(final String s, final Bundle bundle) {
        this.this$0.mHandler.post(1, s, bundle);
    }
    
    public void onExtrasChanged(final Bundle bundle) {
        this.this$0.mHandler.post(7, bundle, null);
    }
    
    public void onMetadataChanged(final MediaMetadataCompat mediaMetadataCompat) {
        this.this$0.mHandler.post(3, mediaMetadataCompat, null);
    }
    
    public void onPlaybackStateChanged(final PlaybackStateCompat playbackStateCompat) {
        this.this$0.mHandler.post(2, playbackStateCompat, null);
    }
    
    public void onQueueChanged(final List list) {
        this.this$0.mHandler.post(5, list, null);
    }
    
    public void onQueueTitleChanged(final CharSequence charSequence) {
        this.this$0.mHandler.post(6, charSequence, null);
    }
    
    public void onRepeatModeChanged(final int n) {
        this.this$0.mHandler.post(9, n, null);
    }
    
    public void onSessionDestroyed() {
        this.this$0.mHandler.post(8, null, null);
    }
    
    public void onShuffleModeChanged(final boolean b) {
        this.this$0.mHandler.post(10, b, null);
    }
    
    public void onVolumeInfoChanged(final ParcelableVolumeInfo parcelableVolumeInfo) {
        Object o = null;
        if (parcelableVolumeInfo != null) {
            o = new MediaControllerCompat$PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioStream, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume);
        }
        this.this$0.mHandler.post(4, o, null);
    }
}
