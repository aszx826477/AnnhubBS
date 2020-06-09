// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.Bundle;
import android.net.Uri;
import android.support.v4.media.RatingCompat;
import android.os.Parcelable;
import android.content.Intent;
import android.support.v4.media.MediaDescriptionCompat;
import android.os.Message;
import android.view.KeyEvent;
import android.os.Looper;
import android.os.Handler;

class MediaSessionCompat$MediaSessionImplBase$MessageHandler extends Handler
{
    private static final int KEYCODE_MEDIA_PAUSE = 127;
    private static final int KEYCODE_MEDIA_PLAY = 126;
    private static final int MSG_ADD_QUEUE_ITEM = 25;
    private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
    private static final int MSG_ADJUST_VOLUME = 2;
    private static final int MSG_COMMAND = 1;
    private static final int MSG_CUSTOM_ACTION = 20;
    private static final int MSG_FAST_FORWARD = 16;
    private static final int MSG_MEDIA_BUTTON = 21;
    private static final int MSG_NEXT = 14;
    private static final int MSG_PAUSE = 12;
    private static final int MSG_PLAY = 7;
    private static final int MSG_PLAY_MEDIA_ID = 8;
    private static final int MSG_PLAY_SEARCH = 9;
    private static final int MSG_PLAY_URI = 10;
    private static final int MSG_PREPARE = 3;
    private static final int MSG_PREPARE_MEDIA_ID = 4;
    private static final int MSG_PREPARE_SEARCH = 5;
    private static final int MSG_PREPARE_URI = 6;
    private static final int MSG_PREVIOUS = 15;
    private static final int MSG_RATE = 19;
    private static final int MSG_REMOVE_QUEUE_ITEM = 27;
    private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
    private static final int MSG_REWIND = 17;
    private static final int MSG_SEEK_TO = 18;
    private static final int MSG_SET_CAPTIONING_ENABLED = 29;
    private static final int MSG_SET_REPEAT_MODE = 23;
    private static final int MSG_SET_SHUFFLE_MODE_ENABLED = 24;
    private static final int MSG_SET_VOLUME = 22;
    private static final int MSG_SKIP_TO_ITEM = 11;
    private static final int MSG_STOP = 13;
    final /* synthetic */ MediaSessionCompat$MediaSessionImplBase this$0;
    
    public MediaSessionCompat$MediaSessionImplBase$MessageHandler(final MediaSessionCompat$MediaSessionImplBase this$0, final Looper looper) {
        this.this$0 = this$0;
        super(looper);
    }
    
    private void onMediaButtonEvent(final KeyEvent keyEvent, final MediaSessionCompat$Callback mediaSessionCompat$Callback) {
        if (keyEvent != null && keyEvent.getAction() == 0) {
            final PlaybackStateCompat mState = this.this$0.mState;
            final long n = 0L;
            long actions;
            if (mState == null) {
                actions = n;
            }
            else {
                actions = this.this$0.mState.getActions();
            }
            final int keyCode = keyEvent.getKeyCode();
            if (keyCode != 79) {
                switch (keyCode) {
                    default: {
                        switch (keyCode) {
                            default: {
                                return;
                            }
                            case 127: {
                                if ((0x2 & actions) != n) {
                                    mediaSessionCompat$Callback.onPause();
                                }
                                return;
                            }
                            case 126: {
                                if ((0x4 & actions) != n) {
                                    mediaSessionCompat$Callback.onPlay();
                                }
                                return;
                            }
                        }
                        break;
                    }
                    case 90: {
                        if ((0x40 & actions) != n) {
                            mediaSessionCompat$Callback.onFastForward();
                        }
                        return;
                    }
                    case 89: {
                        if ((0x8 & actions) != n) {
                            mediaSessionCompat$Callback.onRewind();
                        }
                        return;
                    }
                    case 88: {
                        if ((0x10 & actions) != n) {
                            mediaSessionCompat$Callback.onSkipToPrevious();
                        }
                        return;
                    }
                    case 87: {
                        if ((0x20 & actions) != n) {
                            mediaSessionCompat$Callback.onSkipToNext();
                        }
                        return;
                    }
                    case 86: {
                        if ((0x1L & actions) != n) {
                            mediaSessionCompat$Callback.onStop();
                        }
                        return;
                    }
                    case 85: {
                        break;
                    }
                }
            }
            final PlaybackStateCompat mState2 = this.this$0.mState;
            boolean b = true;
            final boolean b2 = mState2 != null && this.this$0.mState.getState() == 3;
            final boolean b3 = (0x204L & actions) != n;
            if ((0x202L & actions) == n) {
                b = false;
            }
            if (b2 && b) {
                mediaSessionCompat$Callback.onPause();
            }
            else if (!b2 && b3) {
                mediaSessionCompat$Callback.onPlay();
            }
        }
    }
    
    public void handleMessage(final Message message) {
        final MediaSessionCompat$Callback mCallback = this.this$0.mCallback;
        if (mCallback == null) {
            return;
        }
        switch (message.what) {
            case 29: {
                mCallback.onSetCaptioningEnabled((boolean)message.obj);
                break;
            }
            case 28: {
                mCallback.onRemoveQueueItemAt(message.arg1);
                break;
            }
            case 27: {
                mCallback.onRemoveQueueItem((MediaDescriptionCompat)message.obj);
                break;
            }
            case 26: {
                mCallback.onAddQueueItem((MediaDescriptionCompat)message.obj, message.arg1);
                break;
            }
            case 25: {
                mCallback.onAddQueueItem((MediaDescriptionCompat)message.obj);
                break;
            }
            case 24: {
                mCallback.onSetShuffleModeEnabled((boolean)message.obj);
                break;
            }
            case 23: {
                mCallback.onSetRepeatMode(message.arg1);
                break;
            }
            case 22: {
                this.this$0.setVolumeTo(message.arg1, 0);
                break;
            }
            case 21: {
                final KeyEvent keyEvent = (KeyEvent)message.obj;
                final Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.putExtra("android.intent.extra.KEY_EVENT", (Parcelable)keyEvent);
                if (!mCallback.onMediaButtonEvent(intent)) {
                    this.onMediaButtonEvent(keyEvent, mCallback);
                    break;
                }
                break;
            }
            case 20: {
                mCallback.onCustomAction((String)message.obj, message.getData());
                break;
            }
            case 19: {
                mCallback.onSetRating((RatingCompat)message.obj);
                break;
            }
            case 18: {
                mCallback.onSeekTo((long)message.obj);
                break;
            }
            case 17: {
                mCallback.onRewind();
                break;
            }
            case 16: {
                mCallback.onFastForward();
                break;
            }
            case 15: {
                mCallback.onSkipToPrevious();
                break;
            }
            case 14: {
                mCallback.onSkipToNext();
                break;
            }
            case 13: {
                mCallback.onStop();
                break;
            }
            case 12: {
                mCallback.onPause();
                break;
            }
            case 11: {
                mCallback.onSkipToQueueItem((long)message.obj);
                break;
            }
            case 10: {
                mCallback.onPlayFromUri((Uri)message.obj, message.getData());
                break;
            }
            case 9: {
                mCallback.onPlayFromSearch((String)message.obj, message.getData());
                break;
            }
            case 8: {
                mCallback.onPlayFromMediaId((String)message.obj, message.getData());
                break;
            }
            case 7: {
                mCallback.onPlay();
                break;
            }
            case 6: {
                mCallback.onPrepareFromUri((Uri)message.obj, message.getData());
                break;
            }
            case 5: {
                mCallback.onPrepareFromSearch((String)message.obj, message.getData());
                break;
            }
            case 4: {
                mCallback.onPrepareFromMediaId((String)message.obj, message.getData());
                break;
            }
            case 3: {
                mCallback.onPrepare();
                break;
            }
            case 2: {
                this.this$0.adjustVolume(message.arg1, 0);
                break;
            }
            case 1: {
                final MediaSessionCompat$MediaSessionImplBase$Command mediaSessionCompat$MediaSessionImplBase$Command = (MediaSessionCompat$MediaSessionImplBase$Command)message.obj;
                mCallback.onCommand(mediaSessionCompat$MediaSessionImplBase$Command.command, mediaSessionCompat$MediaSessionImplBase$Command.extras, mediaSessionCompat$MediaSessionImplBase$Command.stub);
                break;
            }
        }
    }
    
    public void post(final int n) {
        this.post(n, null);
    }
    
    public void post(final int n, final Object o) {
        this.obtainMessage(n, o).sendToTarget();
    }
    
    public void post(final int n, final Object o, final int n2) {
        this.obtainMessage(n, n2, 0, o).sendToTarget();
    }
    
    public void post(final int n, final Object o, final Bundle data) {
        final Message obtainMessage = this.obtainMessage(n, o);
        obtainMessage.setData(data);
        obtainMessage.sendToTarget();
    }
}
