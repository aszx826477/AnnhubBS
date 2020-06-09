// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.view.ViewTreeObserver$OnWindowFocusChangeListener;
import android.view.ViewTreeObserver$OnWindowAttachListener;
import android.view.View;
import android.media.RemoteControlClient;
import android.content.IntentFilter;
import android.media.RemoteControlClient$OnPlaybackPositionUpdateListener;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.media.RemoteControlClient$OnGetPlaybackPositionListener;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager$OnAudioFocusChangeListener;

class TransportMediatorJellybeanMR2
{
    AudioManager$OnAudioFocusChangeListener mAudioFocusChangeListener;
    boolean mAudioFocused;
    final AudioManager mAudioManager;
    final Context mContext;
    boolean mFocused;
    final RemoteControlClient$OnGetPlaybackPositionListener mGetPlaybackPositionListener;
    final Intent mIntent;
    final BroadcastReceiver mMediaButtonReceiver;
    PendingIntent mPendingIntent;
    int mPlayState;
    final RemoteControlClient$OnPlaybackPositionUpdateListener mPlaybackPositionUpdateListener;
    final String mReceiverAction;
    final IntentFilter mReceiverFilter;
    RemoteControlClient mRemoteControl;
    final View mTargetView;
    final TransportMediatorCallback mTransportCallback;
    final ViewTreeObserver$OnWindowAttachListener mWindowAttachListener;
    final ViewTreeObserver$OnWindowFocusChangeListener mWindowFocusListener;
    
    public TransportMediatorJellybeanMR2(final Context mContext, final AudioManager mAudioManager, final View mTargetView, final TransportMediatorCallback mTransportCallback) {
        this.mWindowAttachListener = (ViewTreeObserver$OnWindowAttachListener)new TransportMediatorJellybeanMR2$1(this);
        this.mWindowFocusListener = (ViewTreeObserver$OnWindowFocusChangeListener)new TransportMediatorJellybeanMR2$2(this);
        this.mMediaButtonReceiver = new TransportMediatorJellybeanMR2$3(this);
        this.mAudioFocusChangeListener = (AudioManager$OnAudioFocusChangeListener)new TransportMediatorJellybeanMR2$4(this);
        this.mGetPlaybackPositionListener = (RemoteControlClient$OnGetPlaybackPositionListener)new TransportMediatorJellybeanMR2$5(this);
        this.mPlaybackPositionUpdateListener = (RemoteControlClient$OnPlaybackPositionUpdateListener)new TransportMediatorJellybeanMR2$6(this);
        this.mPlayState = 0;
        this.mContext = mContext;
        this.mAudioManager = mAudioManager;
        this.mTargetView = mTargetView;
        this.mTransportCallback = mTransportCallback;
        final StringBuilder sb = new StringBuilder();
        sb.append(mContext.getPackageName());
        sb.append(":transport:");
        sb.append(System.identityHashCode(this));
        this.mReceiverAction = sb.toString();
        (this.mIntent = new Intent(this.mReceiverAction)).setPackage(mContext.getPackageName());
        (this.mReceiverFilter = new IntentFilter()).addAction(this.mReceiverAction);
        this.mTargetView.getViewTreeObserver().addOnWindowAttachListener(this.mWindowAttachListener);
        this.mTargetView.getViewTreeObserver().addOnWindowFocusChangeListener(this.mWindowFocusListener);
    }
    
    public void destroy() {
        this.windowDetached();
        this.mTargetView.getViewTreeObserver().removeOnWindowAttachListener(this.mWindowAttachListener);
        this.mTargetView.getViewTreeObserver().removeOnWindowFocusChangeListener(this.mWindowFocusListener);
    }
    
    void dropAudioFocus() {
        if (this.mAudioFocused) {
            this.mAudioFocused = false;
            this.mAudioManager.abandonAudioFocus(this.mAudioFocusChangeListener);
        }
    }
    
    void gainFocus() {
        if (!this.mFocused) {
            this.mFocused = true;
            this.mAudioManager.registerMediaButtonEventReceiver(this.mPendingIntent);
            this.mAudioManager.registerRemoteControlClient(this.mRemoteControl);
            if (this.mPlayState == 3) {
                this.takeAudioFocus();
            }
        }
    }
    
    public Object getRemoteControlClient() {
        return this.mRemoteControl;
    }
    
    void loseFocus() {
        this.dropAudioFocus();
        if (this.mFocused) {
            this.mFocused = false;
            this.mAudioManager.unregisterRemoteControlClient(this.mRemoteControl);
            this.mAudioManager.unregisterMediaButtonEventReceiver(this.mPendingIntent);
        }
    }
    
    public void pausePlaying() {
        if (this.mPlayState == 3) {
            final int n = 2;
            this.mPlayState = n;
            this.mRemoteControl.setPlaybackState(n);
        }
        this.dropAudioFocus();
    }
    
    public void refreshState(final boolean b, final long n, final int transportControlFlags) {
        final RemoteControlClient mRemoteControl = this.mRemoteControl;
        if (mRemoteControl != null) {
            int n2;
            if (b) {
                n2 = 3;
            }
            else {
                n2 = 1;
            }
            float n3;
            if (b) {
                n3 = 1.0f;
            }
            else {
                n3 = 0.0f;
            }
            mRemoteControl.setPlaybackState(n2, n, n3);
            this.mRemoteControl.setTransportControlFlags(transportControlFlags);
        }
    }
    
    public void startPlaying() {
        final int mPlayState = this.mPlayState;
        final int n = 3;
        if (mPlayState != n) {
            this.mPlayState = n;
            this.mRemoteControl.setPlaybackState(n);
        }
        if (this.mFocused) {
            this.takeAudioFocus();
        }
    }
    
    public void stopPlaying() {
        final int mPlayState = this.mPlayState;
        final int n = 1;
        if (mPlayState != n) {
            this.mPlayState = n;
            this.mRemoteControl.setPlaybackState(n);
        }
        this.dropAudioFocus();
    }
    
    void takeAudioFocus() {
        if (!this.mAudioFocused) {
            final int mAudioFocused = 1;
            this.mAudioFocused = (mAudioFocused != 0);
            this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, mAudioFocused);
        }
    }
    
    void windowAttached() {
        this.mContext.registerReceiver(this.mMediaButtonReceiver, this.mReceiverFilter);
        this.mPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, this.mIntent, 268435456);
        (this.mRemoteControl = new RemoteControlClient(this.mPendingIntent)).setOnGetPlaybackPositionListener(this.mGetPlaybackPositionListener);
        this.mRemoteControl.setPlaybackPositionUpdateListener(this.mPlaybackPositionUpdateListener);
    }
    
    void windowDetached() {
        this.loseFocus();
        if (this.mPendingIntent != null) {
            this.mContext.unregisterReceiver(this.mMediaButtonReceiver);
            this.mPendingIntent.cancel();
            this.mPendingIntent = null;
            this.mRemoteControl = null;
        }
    }
}
