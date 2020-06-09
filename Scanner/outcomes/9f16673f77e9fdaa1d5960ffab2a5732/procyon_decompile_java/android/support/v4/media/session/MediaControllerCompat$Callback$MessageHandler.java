// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.support.v4.media.MediaMetadataCompat;
import java.util.List;
import android.os.Bundle;
import android.os.Message;
import android.os.Looper;
import android.os.Handler;

class MediaControllerCompat$Callback$MessageHandler extends Handler
{
    private static final int MSG_DESTROYED = 8;
    private static final int MSG_EVENT = 1;
    private static final int MSG_UPDATE_CAPTIONING_ENABLED = 11;
    private static final int MSG_UPDATE_EXTRAS = 7;
    private static final int MSG_UPDATE_METADATA = 3;
    private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
    private static final int MSG_UPDATE_QUEUE = 5;
    private static final int MSG_UPDATE_QUEUE_TITLE = 6;
    private static final int MSG_UPDATE_REPEAT_MODE = 9;
    private static final int MSG_UPDATE_SHUFFLE_MODE = 10;
    private static final int MSG_UPDATE_VOLUME = 4;
    final /* synthetic */ MediaControllerCompat$Callback this$0;
    
    public MediaControllerCompat$Callback$MessageHandler(final MediaControllerCompat$Callback this$0, final Looper looper) {
        this.this$0 = this$0;
        super(looper);
    }
    
    public void handleMessage(final Message message) {
        if (!this.this$0.mRegistered) {
            return;
        }
        switch (message.what) {
            case 11: {
                this.this$0.onCaptioningEnabledChanged((boolean)message.obj);
                break;
            }
            case 10: {
                this.this$0.onShuffleModeChanged((boolean)message.obj);
                break;
            }
            case 9: {
                this.this$0.onRepeatModeChanged((int)message.obj);
                break;
            }
            case 8: {
                this.this$0.onSessionDestroyed();
                break;
            }
            case 7: {
                this.this$0.onExtrasChanged((Bundle)message.obj);
                break;
            }
            case 6: {
                this.this$0.onQueueTitleChanged((CharSequence)message.obj);
                break;
            }
            case 5: {
                this.this$0.onQueueChanged((List)message.obj);
                break;
            }
            case 4: {
                this.this$0.onAudioInfoChanged((MediaControllerCompat$PlaybackInfo)message.obj);
                break;
            }
            case 3: {
                this.this$0.onMetadataChanged((MediaMetadataCompat)message.obj);
                break;
            }
            case 2: {
                this.this$0.onPlaybackStateChanged((PlaybackStateCompat)message.obj);
                break;
            }
            case 1: {
                this.this$0.onSessionEvent((String)message.obj, message.getData());
                break;
            }
        }
    }
    
    public void post(final int n, final Object o, final Bundle data) {
        final Message obtainMessage = this.obtainMessage(n, o);
        obtainMessage.setData(data);
        obtainMessage.sendToTarget();
    }
}
