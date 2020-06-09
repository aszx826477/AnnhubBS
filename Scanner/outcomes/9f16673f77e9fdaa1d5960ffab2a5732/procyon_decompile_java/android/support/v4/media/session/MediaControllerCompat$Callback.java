// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Build$VERSION;
import android.os.IBinder$DeathRecipient;

public abstract class MediaControllerCompat$Callback implements IBinder$DeathRecipient
{
    private final Object mCallbackObj;
    MediaControllerCompat$Callback$MessageHandler mHandler;
    boolean mHasExtraCallback;
    boolean mRegistered;
    
    public MediaControllerCompat$Callback() {
        this.mRegistered = false;
        if (Build$VERSION.SDK_INT >= 21) {
            this.mCallbackObj = MediaControllerCompatApi21.createCallback(new MediaControllerCompat$Callback$StubApi21(this));
        }
        else {
            this.mCallbackObj = new MediaControllerCompat$Callback$StubCompat(this);
        }
    }
    
    private void setHandler(final Handler handler) {
        this.mHandler = new MediaControllerCompat$Callback$MessageHandler(this, handler.getLooper());
    }
    
    public void binderDied() {
        this.onSessionDestroyed();
    }
    
    public void onAudioInfoChanged(final MediaControllerCompat$PlaybackInfo mediaControllerCompat$PlaybackInfo) {
    }
    
    public void onCaptioningEnabledChanged(final boolean b) {
    }
    
    public void onExtrasChanged(final Bundle bundle) {
    }
    
    public void onMetadataChanged(final MediaMetadataCompat mediaMetadataCompat) {
    }
    
    public void onPlaybackStateChanged(final PlaybackStateCompat playbackStateCompat) {
    }
    
    public void onQueueChanged(final List list) {
    }
    
    public void onQueueTitleChanged(final CharSequence charSequence) {
    }
    
    public void onRepeatModeChanged(final int n) {
    }
    
    public void onSessionDestroyed() {
    }
    
    public void onSessionEvent(final String s, final Bundle bundle) {
    }
    
    public void onShuffleModeChanged(final boolean b) {
    }
}
