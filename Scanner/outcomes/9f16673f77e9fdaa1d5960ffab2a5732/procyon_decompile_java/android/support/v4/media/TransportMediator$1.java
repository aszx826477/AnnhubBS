// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.view.KeyEvent;

class TransportMediator$1 implements TransportMediatorCallback
{
    final /* synthetic */ TransportMediator this$0;
    
    TransportMediator$1(final TransportMediator this$0) {
        this.this$0 = this$0;
    }
    
    public long getPlaybackPosition() {
        return this.this$0.mCallbacks.onGetCurrentPosition();
    }
    
    public void handleAudioFocusChange(final int n) {
        this.this$0.mCallbacks.onAudioFocusChange(n);
    }
    
    public void handleKey(final KeyEvent keyEvent) {
        keyEvent.dispatch(this.this$0.mKeyEventCallback);
    }
    
    public void playbackPositionUpdate(final long n) {
        this.this$0.mCallbacks.onSeekTo(n);
    }
}
