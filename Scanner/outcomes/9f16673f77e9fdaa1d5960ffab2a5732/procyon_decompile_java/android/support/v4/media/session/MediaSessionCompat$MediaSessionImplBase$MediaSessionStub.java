// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.Parcel;
import android.os.ResultReceiver;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.support.v4.media.VolumeProviderCompat;
import android.os.Handler;
import java.util.Iterator;
import android.os.SystemClock;
import android.util.TypedValue;
import android.content.Intent;
import android.util.Log;
import android.text.TextUtils;
import android.content.ComponentName;
import android.os.Build$VERSION;
import android.content.Context;
import java.util.ArrayList;
import android.view.KeyEvent;
import android.os.IInterface;
import android.support.v4.media.RatingCompat;
import android.net.Uri;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v4.media.MediaDescriptionCompat;

class MediaSessionCompat$MediaSessionImplBase$MediaSessionStub extends IMediaSession$Stub
{
    final /* synthetic */ MediaSessionCompat$MediaSessionImplBase this$0;
    
    MediaSessionCompat$MediaSessionImplBase$MediaSessionStub(final MediaSessionCompat$MediaSessionImplBase this$0) {
        this.this$0 = this$0;
    }
    
    public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        this.this$0.postToHandler(25, mediaDescriptionCompat);
    }
    
    public void addQueueItemAt(final MediaDescriptionCompat mediaDescriptionCompat, final int n) {
        this.this$0.postToHandler(26, mediaDescriptionCompat, n);
    }
    
    public void adjustVolume(final int n, final int n2, final String s) {
        this.this$0.adjustVolume(n, n2);
    }
    
    public void fastForward() {
        this.this$0.postToHandler(16);
    }
    
    public Bundle getExtras() {
        synchronized (this.this$0.mLock) {
            return this.this$0.mExtras;
        }
    }
    
    public long getFlags() {
        synchronized (this.this$0.mLock) {
            return this.this$0.mFlags;
        }
    }
    
    public PendingIntent getLaunchPendingIntent() {
        synchronized (this.this$0.mLock) {
            return this.this$0.mSessionActivity;
        }
    }
    
    public MediaMetadataCompat getMetadata() {
        return this.this$0.mMetadata;
    }
    
    public String getPackageName() {
        return this.this$0.mPackageName;
    }
    
    public PlaybackStateCompat getPlaybackState() {
        final Object mLock = this.this$0.mLock;
        // monitorenter(mLock)
        PlaybackStateCompat mState;
        try {
            mState = this.this$0.mState;
            final MediaSessionCompat$MediaSessionImplBase$MediaSessionStub mediaSessionCompat$MediaSessionImplBase$MediaSessionStub = this;
            final MediaSessionCompat$MediaSessionImplBase this$0 = mediaSessionCompat$MediaSessionImplBase$MediaSessionStub.this$0;
            final MediaSessionCompat$MediaSessionImplBase this$2 = this$0;
            final MediaMetadataCompat mediaMetadataCompat = this$2.mMetadata;
            final Object o = mLock;
            // monitorexit(o)
            final PlaybackStateCompat playbackStateCompat = mState;
            final MediaMetadataCompat mediaMetadataCompat2 = mediaMetadataCompat;
            return getStateWithUpdatedPosition(playbackStateCompat, mediaMetadataCompat2);
        }
        finally {
            final Object o3;
            final Object o2 = o3;
        }
        while (true) {
            try {
                final MediaSessionCompat$MediaSessionImplBase$MediaSessionStub mediaSessionCompat$MediaSessionImplBase$MediaSessionStub = this;
                final MediaSessionCompat$MediaSessionImplBase this$2;
                final MediaSessionCompat$MediaSessionImplBase this$0 = this$2 = mediaSessionCompat$MediaSessionImplBase$MediaSessionStub.this$0;
                final MediaMetadataCompat mediaMetadataCompat = this$2.mMetadata;
                final Object o = mLock;
                // monitorexit(o)
                final PlaybackStateCompat playbackStateCompat = mState;
                final MediaMetadataCompat mediaMetadataCompat2 = mediaMetadataCompat;
                return getStateWithUpdatedPosition(playbackStateCompat, mediaMetadataCompat2);
                // monitorexit(mLock)
                throw;
            }
            finally {
                continue;
            }
            break;
        }
    }
    
    public List getQueue() {
        synchronized (this.this$0.mLock) {
            return this.this$0.mQueue;
        }
    }
    
    public CharSequence getQueueTitle() {
        return this.this$0.mQueueTitle;
    }
    
    public int getRatingType() {
        return this.this$0.mRatingType;
    }
    
    public int getRepeatMode() {
        return this.this$0.mRepeatMode;
    }
    
    public String getTag() {
        return this.this$0.mTag;
    }
    
    public ParcelableVolumeInfo getVolumeAttributes() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        android/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase$MediaSessionStub.this$0:Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
        //     4: getfield        android/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase.mLock:Ljava/lang/Object;
        //     7: astore_1       
        //     8: aload_1        
        //     9: monitorenter   
        //    10: iconst_0       
        //    11: istore_2       
        //    12: aload_0        
        //    13: getfield        android/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase$MediaSessionStub.this$0:Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
        //    16: astore_3       
        //    17: aload_3        
        //    18: getfield        android/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase.mVolumeType:I
        //    21: istore          4
        //    23: aload_0        
        //    24: getfield        android/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase$MediaSessionStub.this$0:Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
        //    27: astore          5
        //    29: aload           5
        //    31: getfield        android/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase.mLocalStream:I
        //    34: istore          6
        //    36: iload           6
        //    38: istore          7
        //    40: aload_0        
        //    41: getfield        android/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase$MediaSessionStub.this$0:Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
        //    44: astore          5
        //    46: aload           5
        //    48: getfield        android/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase.mVolumeProvider:Landroid/support/v4/media/VolumeProviderCompat;
        //    51: astore          5
        //    53: iconst_2       
        //    54: istore          8
        //    56: iload           4
        //    58: iload           8
        //    60: if_icmpne       94
        //    63: aload           5
        //    65: invokevirtual   android/support/v4/media/VolumeProviderCompat.getVolumeControl:()I
        //    68: istore          8
        //    70: aload           5
        //    72: invokevirtual   android/support/v4/media/VolumeProviderCompat.getMaxVolume:()I
        //    75: istore          9
        //    77: aload           5
        //    79: invokevirtual   android/support/v4/media/VolumeProviderCompat.getCurrentVolume:()I
        //    82: istore          10
        //    84: iload           8
        //    86: istore_2       
        //    87: iload           9
        //    89: istore          11
        //    91: goto            148
        //    94: iconst_2       
        //    95: istore          8
        //    97: aload_0        
        //    98: getfield        android/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase$MediaSessionStub.this$0:Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
        //   101: astore          12
        //   103: aload           12
        //   105: getfield        android/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase.mAudioManager:Landroid/media/AudioManager;
        //   108: astore          12
        //   110: aload           12
        //   112: iload           6
        //   114: invokevirtual   android/media/AudioManager.getStreamMaxVolume:(I)I
        //   117: istore          9
        //   119: aload_0        
        //   120: getfield        android/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase$MediaSessionStub.this$0:Landroid/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase;
        //   123: astore          13
        //   125: aload           13
        //   127: getfield        android/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase.mAudioManager:Landroid/media/AudioManager;
        //   130: astore          13
        //   132: aload           13
        //   134: iload           6
        //   136: invokevirtual   android/media/AudioManager.getStreamVolume:(I)I
        //   139: istore          10
        //   141: iload           8
        //   143: istore_2       
        //   144: iload           9
        //   146: istore          11
        //   148: aload_1        
        //   149: monitorexit    
        //   150: new             Landroid/support/v4/media/session/ParcelableVolumeInfo;
        //   153: astore_1       
        //   154: aload_1        
        //   155: astore          5
        //   157: iload           4
        //   159: istore          8
        //   161: iload           7
        //   163: istore          9
        //   165: aload_1        
        //   166: iload           4
        //   168: iload           7
        //   170: iload_2        
        //   171: iload           11
        //   173: iload           10
        //   175: invokespecial   android/support/v4/media/session/ParcelableVolumeInfo.<init>:(IIIII)V
        //   178: aload_1        
        //   179: areturn        
        //   180: astore          5
        //   182: iload_2        
        //   183: istore          8
        //   185: iload           11
        //   187: istore          9
        //   189: iload           10
        //   191: istore_2       
        //   192: goto            255
        //   195: astore          5
        //   197: goto            205
        //   200: astore          5
        //   202: iconst_0       
        //   203: istore          8
        //   205: iconst_0       
        //   206: istore          9
        //   208: aconst_null    
        //   209: astore          12
        //   211: goto            255
        //   214: astore          5
        //   216: iconst_0       
        //   217: istore          8
        //   219: iconst_0       
        //   220: istore          9
        //   222: aconst_null    
        //   223: astore          12
        //   225: aconst_null    
        //   226: astore          13
        //   228: iconst_0       
        //   229: istore          7
        //   231: goto            255
        //   234: astore          5
        //   236: iconst_0       
        //   237: istore          8
        //   239: iconst_0       
        //   240: istore          9
        //   242: aconst_null    
        //   243: astore          12
        //   245: iconst_0       
        //   246: istore          4
        //   248: aconst_null    
        //   249: astore_3       
        //   250: iconst_0       
        //   251: istore          7
        //   253: iconst_0       
        //   254: istore_2       
        //   255: aload_1        
        //   256: monitorexit    
        //   257: aload           5
        //   259: athrow         
        //   260: astore          5
        //   262: goto            255
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  12     16     234    255    Any
        //  17     21     234    255    Any
        //  23     27     214    234    Any
        //  29     34     214    234    Any
        //  40     44     200    205    Any
        //  46     51     200    205    Any
        //  63     68     200    205    Any
        //  70     75     195    200    Any
        //  77     82     260    265    Any
        //  97     101    195    200    Any
        //  103    108    195    200    Any
        //  112    117    195    200    Any
        //  119    123    260    265    Any
        //  125    130    260    265    Any
        //  134    139    260    265    Any
        //  148    150    180    195    Any
        //  255    257    260    265    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0094:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:317)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:238)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:138)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public boolean isCaptioningEnabled() {
        return this.this$0.mCaptioningEnabled;
    }
    
    public boolean isShuffleModeEnabled() {
        return this.this$0.mShuffleModeEnabled;
    }
    
    public boolean isTransportControlEnabled() {
        return (this.this$0.mFlags & 0x2) != 0x0;
    }
    
    public void next() {
        this.this$0.postToHandler(14);
    }
    
    public void pause() {
        this.this$0.postToHandler(12);
    }
    
    public void play() {
        this.this$0.postToHandler(7);
    }
    
    public void playFromMediaId(final String s, final Bundle bundle) {
        this.this$0.postToHandler(8, s, bundle);
    }
    
    public void playFromSearch(final String s, final Bundle bundle) {
        this.this$0.postToHandler(9, s, bundle);
    }
    
    public void playFromUri(final Uri uri, final Bundle bundle) {
        this.this$0.postToHandler(10, uri, bundle);
    }
    
    public void prepare() {
        this.this$0.postToHandler(3);
    }
    
    public void prepareFromMediaId(final String s, final Bundle bundle) {
        this.this$0.postToHandler(4, s, bundle);
    }
    
    public void prepareFromSearch(final String s, final Bundle bundle) {
        this.this$0.postToHandler(5, s, bundle);
    }
    
    public void prepareFromUri(final Uri uri, final Bundle bundle) {
        this.this$0.postToHandler(6, uri, bundle);
    }
    
    public void previous() {
        this.this$0.postToHandler(15);
    }
    
    public void rate(final RatingCompat ratingCompat) {
        this.this$0.postToHandler(19, ratingCompat);
    }
    
    public void registerCallbackListener(final IMediaControllerCallback mediaControllerCallback) {
        if (this.this$0.mDestroyed) {
            try {
                mediaControllerCallback.onSessionDestroyed();
            }
            catch (Exception ex) {}
            return;
        }
        this.this$0.mControllerCallbacks.register((IInterface)mediaControllerCallback);
    }
    
    public void removeQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        this.this$0.postToHandler(27, mediaDescriptionCompat);
    }
    
    public void removeQueueItemAt(final int n) {
        this.this$0.postToHandler(28, n);
    }
    
    public void rewind() {
        this.this$0.postToHandler(17);
    }
    
    public void seekTo(final long n) {
        this.this$0.postToHandler(18, n);
    }
    
    public void sendCommand(final String s, final Bundle bundle, final MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper) {
        this.this$0.postToHandler(1, new MediaSessionCompat$MediaSessionImplBase$Command(s, bundle, mediaSessionCompat$ResultReceiverWrapper.mResultReceiver));
    }
    
    public void sendCustomAction(final String s, final Bundle bundle) {
        this.this$0.postToHandler(20, s, bundle);
    }
    
    public boolean sendMediaButton(final KeyEvent keyEvent) {
        final int mFlags = this.this$0.mFlags;
        boolean b = true;
        if ((mFlags & (b ? 1 : 0)) == 0x0) {
            b = false;
        }
        final boolean b2 = b;
        if (b) {
            this.this$0.postToHandler(21, keyEvent);
        }
        return b2;
    }
    
    public void setCaptioningEnabled(final boolean b) {
        this.this$0.postToHandler(29, (Object)b);
    }
    
    public void setRepeatMode(final int n) {
        this.this$0.postToHandler(23, n);
    }
    
    public void setShuffleModeEnabled(final boolean b) {
        this.this$0.postToHandler(24, (Object)b);
    }
    
    public void setVolumeTo(final int n, final int n2, final String s) {
        this.this$0.setVolumeTo(n, n2);
    }
    
    public void skipToQueueItem(final long n) {
        this.this$0.postToHandler(11, n);
    }
    
    public void stop() {
        this.this$0.postToHandler(13);
    }
    
    public void unregisterCallbackListener(final IMediaControllerCallback mediaControllerCallback) {
        this.this$0.mControllerCallbacks.unregister((IInterface)mediaControllerCallback);
    }
}
