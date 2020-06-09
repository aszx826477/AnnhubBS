// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

public final class MediaControllerCompat$PlaybackInfo
{
    public static final int PLAYBACK_TYPE_LOCAL = 1;
    public static final int PLAYBACK_TYPE_REMOTE = 2;
    private final int mAudioStream;
    private final int mCurrentVolume;
    private final int mMaxVolume;
    private final int mPlaybackType;
    private final int mVolumeControl;
    
    MediaControllerCompat$PlaybackInfo(final int mPlaybackType, final int mAudioStream, final int mVolumeControl, final int mMaxVolume, final int mCurrentVolume) {
        this.mPlaybackType = mPlaybackType;
        this.mAudioStream = mAudioStream;
        this.mVolumeControl = mVolumeControl;
        this.mMaxVolume = mMaxVolume;
        this.mCurrentVolume = mCurrentVolume;
    }
    
    public int getAudioStream() {
        return this.mAudioStream;
    }
    
    public int getCurrentVolume() {
        return this.mCurrentVolume;
    }
    
    public int getMaxVolume() {
        return this.mMaxVolume;
    }
    
    public int getPlaybackType() {
        return this.mPlaybackType;
    }
    
    public int getVolumeControl() {
        return this.mVolumeControl;
    }
}
