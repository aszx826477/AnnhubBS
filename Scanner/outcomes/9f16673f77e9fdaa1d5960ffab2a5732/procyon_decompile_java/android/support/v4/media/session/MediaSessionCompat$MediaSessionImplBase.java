// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.support.v4.media.MediaMetadataCompat$Builder;
import android.os.Handler;
import android.os.RemoteException;
import android.os.Build$VERSION;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.VolumeProviderCompat$Callback;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.content.Context;
import android.media.AudioManager;

class MediaSessionCompat$MediaSessionImplBase implements MediaSessionCompat$MediaSessionImpl
{
    final AudioManager mAudioManager;
    volatile MediaSessionCompat$Callback mCallback;
    boolean mCaptioningEnabled;
    private final Context mContext;
    final RemoteCallbackList mControllerCallbacks;
    boolean mDestroyed;
    Bundle mExtras;
    int mFlags;
    private MediaSessionCompat$MediaSessionImplBase$MessageHandler mHandler;
    private boolean mIsActive;
    private boolean mIsMbrRegistered;
    private boolean mIsRccRegistered;
    int mLocalStream;
    final Object mLock;
    private final ComponentName mMediaButtonReceiverComponentName;
    private final PendingIntent mMediaButtonReceiverIntent;
    MediaMetadataCompat mMetadata;
    final String mPackageName;
    List mQueue;
    CharSequence mQueueTitle;
    int mRatingType;
    private final Object mRccObj;
    int mRepeatMode;
    PendingIntent mSessionActivity;
    boolean mShuffleModeEnabled;
    PlaybackStateCompat mState;
    private final MediaSessionCompat$MediaSessionImplBase$MediaSessionStub mStub;
    final String mTag;
    private final MediaSessionCompat$Token mToken;
    private VolumeProviderCompat$Callback mVolumeCallback;
    VolumeProviderCompat mVolumeProvider;
    int mVolumeType;
    
    public MediaSessionCompat$MediaSessionImplBase(final Context mContext, final String mTag, final ComponentName mMediaButtonReceiverComponentName, final PendingIntent mMediaButtonReceiverIntent) {
        this.mLock = new Object();
        this.mControllerCallbacks = new RemoteCallbackList();
        this.mDestroyed = false;
        this.mIsActive = false;
        this.mIsRccRegistered = false;
        this.mIsMbrRegistered = false;
        this.mVolumeCallback = new MediaSessionCompat$MediaSessionImplBase$1(this);
        if (mMediaButtonReceiverComponentName != null) {
            this.mContext = mContext;
            this.mPackageName = mContext.getPackageName();
            this.mAudioManager = (AudioManager)mContext.getSystemService("audio");
            this.mTag = mTag;
            this.mMediaButtonReceiverComponentName = mMediaButtonReceiverComponentName;
            this.mMediaButtonReceiverIntent = mMediaButtonReceiverIntent;
            this.mStub = new MediaSessionCompat$MediaSessionImplBase$MediaSessionStub(this);
            this.mToken = new MediaSessionCompat$Token(this.mStub);
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = 3;
            if (Build$VERSION.SDK_INT >= 14) {
                this.mRccObj = MediaSessionCompatApi14.createRemoteControlClient(mMediaButtonReceiverIntent);
            }
            else {
                this.mRccObj = null;
            }
            return;
        }
        throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
    }
    
    private void sendCaptioningEnabled(final boolean b) {
        for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; --i) {
            final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
            try {
                mediaControllerCallback.onCaptioningEnabledChanged(b);
            }
            catch (RemoteException ex) {}
        }
        this.mControllerCallbacks.finishBroadcast();
    }
    
    private void sendEvent(final String s, final Bundle bundle) {
        for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; --i) {
            final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
            try {
                mediaControllerCallback.onEvent(s, bundle);
            }
            catch (RemoteException ex) {}
        }
        this.mControllerCallbacks.finishBroadcast();
    }
    
    private void sendExtras(final Bundle bundle) {
        for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; --i) {
            final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
            try {
                mediaControllerCallback.onExtrasChanged(bundle);
            }
            catch (RemoteException ex) {}
        }
        this.mControllerCallbacks.finishBroadcast();
    }
    
    private void sendMetadata(final MediaMetadataCompat mediaMetadataCompat) {
        for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; --i) {
            final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
            try {
                mediaControllerCallback.onMetadataChanged(mediaMetadataCompat);
            }
            catch (RemoteException ex) {}
        }
        this.mControllerCallbacks.finishBroadcast();
    }
    
    private void sendQueue(final List list) {
        for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; --i) {
            final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
            try {
                mediaControllerCallback.onQueueChanged(list);
            }
            catch (RemoteException ex) {}
        }
        this.mControllerCallbacks.finishBroadcast();
    }
    
    private void sendQueueTitle(final CharSequence charSequence) {
        for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; --i) {
            final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
            try {
                mediaControllerCallback.onQueueTitleChanged(charSequence);
            }
            catch (RemoteException ex) {}
        }
        this.mControllerCallbacks.finishBroadcast();
    }
    
    private void sendRepeatMode(final int n) {
        for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; --i) {
            final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
            try {
                mediaControllerCallback.onRepeatModeChanged(n);
            }
            catch (RemoteException ex) {}
        }
        this.mControllerCallbacks.finishBroadcast();
    }
    
    private void sendSessionDestroyed() {
        for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; --i) {
            final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
            try {
                mediaControllerCallback.onSessionDestroyed();
            }
            catch (RemoteException ex) {}
        }
        this.mControllerCallbacks.finishBroadcast();
        this.mControllerCallbacks.kill();
    }
    
    private void sendShuffleModeEnabled(final boolean b) {
        for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; --i) {
            final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
            try {
                mediaControllerCallback.onShuffleModeChanged(b);
            }
            catch (RemoteException ex) {}
        }
        this.mControllerCallbacks.finishBroadcast();
    }
    
    private void sendState(final PlaybackStateCompat playbackStateCompat) {
        for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; --i) {
            final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
            try {
                mediaControllerCallback.onPlaybackStateChanged(playbackStateCompat);
            }
            catch (RemoteException ex) {}
        }
        this.mControllerCallbacks.finishBroadcast();
    }
    
    private boolean update() {
        boolean b = false;
        final boolean mIsActive = this.mIsActive;
        final int n = 18;
        if (mIsActive) {
            final boolean mIsMbrRegistered = this.mIsMbrRegistered;
            final boolean b2 = true;
            if (!mIsMbrRegistered && (this.mFlags & (b2 ? 1 : 0)) != 0x0) {
                if (Build$VERSION.SDK_INT >= n) {
                    MediaSessionCompatApi18.registerMediaButtonEventReceiver(this.mContext, this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                }
                else {
                    ((AudioManager)this.mContext.getSystemService("audio")).registerMediaButtonEventReceiver(this.mMediaButtonReceiverComponentName);
                }
                this.mIsMbrRegistered = b2;
            }
            else if (this.mIsMbrRegistered && (this.mFlags & (b2 ? 1 : 0)) == 0x0) {
                if (Build$VERSION.SDK_INT >= n) {
                    MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.mContext, this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                }
                else {
                    ((AudioManager)this.mContext.getSystemService("audio")).unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverComponentName);
                }
                this.mIsMbrRegistered = false;
            }
            if (Build$VERSION.SDK_INT >= 14) {
                if (!this.mIsRccRegistered && (this.mFlags & 0x2) != 0x0) {
                    MediaSessionCompatApi14.registerRemoteControlClient(this.mContext, this.mRccObj);
                    this.mIsRccRegistered = b2;
                    b = true;
                }
                else if (this.mIsRccRegistered && (this.mFlags & 0x2) == 0x0) {
                    MediaSessionCompatApi14.setState(this.mRccObj, 0);
                    MediaSessionCompatApi14.unregisterRemoteControlClient(this.mContext, this.mRccObj);
                    this.mIsRccRegistered = false;
                }
            }
        }
        else {
            if (this.mIsMbrRegistered) {
                if (Build$VERSION.SDK_INT >= n) {
                    MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.mContext, this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                }
                else {
                    ((AudioManager)this.mContext.getSystemService("audio")).unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverComponentName);
                }
                this.mIsMbrRegistered = false;
            }
            if (this.mIsRccRegistered) {
                MediaSessionCompatApi14.setState(this.mRccObj, 0);
                MediaSessionCompatApi14.unregisterRemoteControlClient(this.mContext, this.mRccObj);
                this.mIsRccRegistered = false;
            }
        }
        return b;
    }
    
    void adjustVolume(final int n, final int n2) {
        if (this.mVolumeType == 2) {
            final VolumeProviderCompat mVolumeProvider = this.mVolumeProvider;
            if (mVolumeProvider != null) {
                mVolumeProvider.onAdjustVolume(n);
            }
        }
        else {
            this.mAudioManager.adjustStreamVolume(this.mLocalStream, n, n2);
        }
    }
    
    public String getCallingPackage() {
        return null;
    }
    
    public Object getMediaSession() {
        return null;
    }
    
    public Object getRemoteControlClient() {
        return this.mRccObj;
    }
    
    public MediaSessionCompat$Token getSessionToken() {
        return this.mToken;
    }
    
    public boolean isActive() {
        return this.mIsActive;
    }
    
    void postToHandler(final int n) {
        this.postToHandler(n, null);
    }
    
    void postToHandler(final int n, final int n2) {
        this.postToHandler(n, null, n2);
    }
    
    void postToHandler(final int n, final Object o) {
        this.postToHandler(n, o, null);
    }
    
    void postToHandler(final int n, final Object o, final int n2) {
        synchronized (this.mLock) {
            if (this.mHandler != null) {
                this.mHandler.post(n, o, n2);
            }
        }
    }
    
    void postToHandler(final int n, final Object o, final Bundle bundle) {
        synchronized (this.mLock) {
            if (this.mHandler != null) {
                this.mHandler.post(n, o, bundle);
            }
        }
    }
    
    public void release() {
        this.mIsActive = false;
        this.mDestroyed = true;
        this.update();
        this.sendSessionDestroyed();
    }
    
    public void sendSessionEvent(final String s, final Bundle bundle) {
        this.sendEvent(s, bundle);
    }
    
    void sendVolumeInfoChanged(final ParcelableVolumeInfo parcelableVolumeInfo) {
        for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; --i) {
            final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
            try {
                mediaControllerCallback.onVolumeInfoChanged(parcelableVolumeInfo);
            }
            catch (RemoteException ex) {}
        }
        this.mControllerCallbacks.finishBroadcast();
    }
    
    public void setActive(final boolean mIsActive) {
        if (mIsActive == this.mIsActive) {
            return;
        }
        this.mIsActive = mIsActive;
        if (this.update()) {
            this.setMetadata(this.mMetadata);
            this.setPlaybackState(this.mState);
        }
    }
    
    public void setCallback(final MediaSessionCompat$Callback mCallback, Handler handler) {
        this.mCallback = mCallback;
        final int n = 19;
        final int n2 = 18;
        if (mCallback == null) {
            if (Build$VERSION.SDK_INT >= n2) {
                MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(this.mRccObj, null);
            }
            if (Build$VERSION.SDK_INT >= n) {
                MediaSessionCompatApi19.setOnMetadataUpdateListener(this.mRccObj, null);
            }
            return;
        }
        else if (handler == null) {
            handler = new Handler();
        }
        Object mLock = this.mLock;
        synchronized (mLock) {
            this.mHandler = new MediaSessionCompat$MediaSessionImplBase$MessageHandler(this, handler.getLooper());
            // monitorexit(mLock)
            mLock = new MediaSessionCompat$MediaSessionImplBase$2(this);
            if (Build$VERSION.SDK_INT >= n2) {
                MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(this.mRccObj, MediaSessionCompatApi18.createPlaybackPositionUpdateListener((MediaSessionCompatApi18$Callback)mLock));
            }
            if (Build$VERSION.SDK_INT >= n) {
                MediaSessionCompatApi19.setOnMetadataUpdateListener(this.mRccObj, MediaSessionCompatApi19.createMetadataUpdateListener((MediaSessionCompatApi19$Callback)mLock));
            }
        }
    }
    
    public void setCaptioningEnabled(final boolean mCaptioningEnabled) {
        if (this.mCaptioningEnabled != mCaptioningEnabled) {
            this.sendCaptioningEnabled(this.mCaptioningEnabled = mCaptioningEnabled);
        }
    }
    
    public void setExtras(final Bundle mExtras) {
        this.sendExtras(this.mExtras = mExtras);
    }
    
    public void setFlags(final int mFlags) {
        synchronized (this.mLock) {
            this.mFlags = mFlags;
            // monitorexit(this.mLock)
            this.update();
        }
    }
    
    public void setMediaButtonReceiver(final PendingIntent pendingIntent) {
    }
    
    public void setMetadata(MediaMetadataCompat build) {
        if (build != null) {
            build = new MediaMetadataCompat$Builder(build, MediaSessionCompat.sMaxBitmapSize).build();
        }
        Object o = this.mLock;
        synchronized (o) {
            this.mMetadata = build;
            // monitorexit(o)
            this.sendMetadata(build);
            if (!this.mIsActive) {
                return;
            }
            final int sdk_INT = Build$VERSION.SDK_INT;
            final int n = 19;
            Bundle bundle = null;
            if (sdk_INT >= n) {
                o = this.mRccObj;
                if (build != null) {
                    bundle = build.getBundle();
                }
                final PlaybackStateCompat mState = this.mState;
                long actions;
                if (mState == null) {
                    actions = 0L;
                }
                else {
                    actions = mState.getActions();
                }
                MediaSessionCompatApi19.setMetadata(o, bundle, actions);
            }
            else if (Build$VERSION.SDK_INT >= 14) {
                o = this.mRccObj;
                if (build != null) {
                    bundle = build.getBundle();
                }
                MediaSessionCompatApi14.setMetadata(o, bundle);
            }
        }
    }
    
    public void setPlaybackState(final PlaybackStateCompat mState) {
        Object o = this.mLock;
        synchronized (o) {
            this.mState = mState;
            // monitorexit(o)
            this.sendState(mState);
            if (!this.mIsActive) {
                return;
            }
            final int n = 14;
            if (mState == null) {
                if (Build$VERSION.SDK_INT >= n) {
                    o = this.mRccObj;
                    MediaSessionCompatApi14.setState(o, 0);
                    o = this.mRccObj;
                    MediaSessionCompatApi14.setTransportControlFlags(o, 0L);
                }
            }
            else {
                final int sdk_INT = Build$VERSION.SDK_INT;
                final int n2 = 18;
                if (sdk_INT >= n2) {
                    MediaSessionCompatApi18.setState(this.mRccObj, mState.getState(), mState.getPosition(), mState.getPlaybackSpeed(), mState.getLastPositionUpdateTime());
                }
                else if (Build$VERSION.SDK_INT >= n) {
                    MediaSessionCompatApi14.setState(this.mRccObj, mState.getState());
                }
                if (Build$VERSION.SDK_INT >= 19) {
                    o = this.mRccObj;
                    MediaSessionCompatApi19.setTransportControlFlags(o, mState.getActions());
                }
                else if (Build$VERSION.SDK_INT >= n2) {
                    o = this.mRccObj;
                    MediaSessionCompatApi18.setTransportControlFlags(o, mState.getActions());
                }
                else if (Build$VERSION.SDK_INT >= n) {
                    o = this.mRccObj;
                    MediaSessionCompatApi14.setTransportControlFlags(o, mState.getActions());
                }
            }
        }
    }
    
    public void setPlaybackToLocal(final int n) {
        final VolumeProviderCompat mVolumeProvider = this.mVolumeProvider;
        if (mVolumeProvider != null) {
            mVolumeProvider.setCallback(null);
        }
        this.mVolumeType = 1;
        final int mVolumeType = this.mVolumeType;
        final int mLocalStream = this.mLocalStream;
        this.sendVolumeInfoChanged(new ParcelableVolumeInfo(mVolumeType, mLocalStream, 2, this.mAudioManager.getStreamMaxVolume(mLocalStream), this.mAudioManager.getStreamVolume(this.mLocalStream)));
    }
    
    public void setPlaybackToRemote(final VolumeProviderCompat mVolumeProvider) {
        if (mVolumeProvider != null) {
            final VolumeProviderCompat mVolumeProvider2 = this.mVolumeProvider;
            if (mVolumeProvider2 != null) {
                mVolumeProvider2.setCallback(null);
            }
            this.mVolumeType = 2;
            this.mVolumeProvider = mVolumeProvider;
            this.sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
            mVolumeProvider.setCallback(this.mVolumeCallback);
            return;
        }
        throw new IllegalArgumentException("volumeProvider may not be null");
    }
    
    public void setQueue(final List mQueue) {
        this.sendQueue(this.mQueue = mQueue);
    }
    
    public void setQueueTitle(final CharSequence mQueueTitle) {
        this.sendQueueTitle(this.mQueueTitle = mQueueTitle);
    }
    
    public void setRatingType(final int mRatingType) {
        this.mRatingType = mRatingType;
    }
    
    public void setRepeatMode(final int mRepeatMode) {
        if (this.mRepeatMode != mRepeatMode) {
            this.sendRepeatMode(this.mRepeatMode = mRepeatMode);
        }
    }
    
    public void setSessionActivity(final PendingIntent mSessionActivity) {
        synchronized (this.mLock) {
            this.mSessionActivity = mSessionActivity;
        }
    }
    
    public void setShuffleModeEnabled(final boolean mShuffleModeEnabled) {
        if (this.mShuffleModeEnabled != mShuffleModeEnabled) {
            this.sendShuffleModeEnabled(this.mShuffleModeEnabled = mShuffleModeEnabled);
        }
    }
    
    void setVolumeTo(final int n, final int n2) {
        if (this.mVolumeType == 2) {
            final VolumeProviderCompat mVolumeProvider = this.mVolumeProvider;
            if (mVolumeProvider != null) {
                mVolumeProvider.onSetVolumeTo(n);
            }
        }
        else {
            this.mAudioManager.setStreamVolume(this.mLocalStream, n, n2);
        }
    }
}
