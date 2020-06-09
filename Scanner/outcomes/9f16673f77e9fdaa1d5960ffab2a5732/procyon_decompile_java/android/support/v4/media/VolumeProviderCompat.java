// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Build$VERSION;

public abstract class VolumeProviderCompat
{
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private VolumeProviderCompat$Callback mCallback;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;
    private Object mVolumeProviderObj;
    
    public VolumeProviderCompat(final int mControlType, final int mMaxVolume, final int mCurrentVolume) {
        this.mControlType = mControlType;
        this.mMaxVolume = mMaxVolume;
        this.mCurrentVolume = mCurrentVolume;
    }
    
    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }
    
    public final int getMaxVolume() {
        return this.mMaxVolume;
    }
    
    public final int getVolumeControl() {
        return this.mControlType;
    }
    
    public Object getVolumeProvider() {
        if (this.mVolumeProviderObj == null && Build$VERSION.SDK_INT >= 21) {
            return this.mVolumeProviderObj = VolumeProviderCompatApi21.createVolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume, new VolumeProviderCompat$1(this));
        }
        return this.mVolumeProviderObj;
    }
    
    public void onAdjustVolume(final int n) {
    }
    
    public void onSetVolumeTo(final int n) {
    }
    
    public void setCallback(final VolumeProviderCompat$Callback mCallback) {
        this.mCallback = mCallback;
    }
    
    public final void setCurrentVolume(final int mCurrentVolume) {
        this.mCurrentVolume = mCurrentVolume;
        final Object volumeProvider = this.getVolumeProvider();
        if (volumeProvider != null) {
            VolumeProviderCompatApi21.setCurrentVolume(volumeProvider, mCurrentVolume);
        }
        final VolumeProviderCompat$Callback mCallback = this.mCallback;
        if (mCallback != null) {
            mCallback.onVolumeChanged(this);
        }
    }
}
