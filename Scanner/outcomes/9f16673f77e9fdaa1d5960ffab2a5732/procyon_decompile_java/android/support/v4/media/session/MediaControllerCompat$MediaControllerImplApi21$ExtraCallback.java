// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;

class MediaControllerCompat$MediaControllerImplApi21$ExtraCallback extends IMediaControllerCallback$Stub
{
    private MediaControllerCompat$Callback mCallback;
    final /* synthetic */ MediaControllerCompat$MediaControllerImplApi21 this$0;
    
    MediaControllerCompat$MediaControllerImplApi21$ExtraCallback(final MediaControllerCompat$MediaControllerImplApi21 this$0, final MediaControllerCompat$Callback mCallback) {
        this.this$0 = this$0;
        this.mCallback = mCallback;
    }
    
    public void onCaptioningEnabledChanged(final boolean b) {
        this.mCallback.mHandler.post((Runnable)new MediaControllerCompat$MediaControllerImplApi21$ExtraCallback$3(this, b));
    }
    
    public void onEvent(final String s, final Bundle bundle) {
        this.mCallback.mHandler.post((Runnable)new MediaControllerCompat$MediaControllerImplApi21$ExtraCallback$1(this, s, bundle));
    }
    
    public void onExtrasChanged(final Bundle bundle) {
        throw new AssertionError();
    }
    
    public void onMetadataChanged(final MediaMetadataCompat mediaMetadataCompat) {
        throw new AssertionError();
    }
    
    public void onPlaybackStateChanged(final PlaybackStateCompat playbackStateCompat) {
        this.mCallback.mHandler.post((Runnable)new MediaControllerCompat$MediaControllerImplApi21$ExtraCallback$2(this, playbackStateCompat));
    }
    
    public void onQueueChanged(final List list) {
        throw new AssertionError();
    }
    
    public void onQueueTitleChanged(final CharSequence charSequence) {
        throw new AssertionError();
    }
    
    public void onRepeatModeChanged(final int n) {
        this.mCallback.mHandler.post((Runnable)new MediaControllerCompat$MediaControllerImplApi21$ExtraCallback$4(this, n));
    }
    
    public void onSessionDestroyed() {
        throw new AssertionError();
    }
    
    public void onShuffleModeChanged(final boolean b) {
        this.mCallback.mHandler.post((Runnable)new MediaControllerCompat$MediaControllerImplApi21$ExtraCallback$5(this, b));
    }
    
    public void onVolumeInfoChanged(final ParcelableVolumeInfo parcelableVolumeInfo) {
        throw new AssertionError();
    }
}
