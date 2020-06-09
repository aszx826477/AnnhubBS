// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;
import android.os.IInterface;

public interface IMediaControllerCallback extends IInterface
{
    void onCaptioningEnabledChanged(final boolean p0);
    
    void onEvent(final String p0, final Bundle p1);
    
    void onExtrasChanged(final Bundle p0);
    
    void onMetadataChanged(final MediaMetadataCompat p0);
    
    void onPlaybackStateChanged(final PlaybackStateCompat p0);
    
    void onQueueChanged(final List p0);
    
    void onQueueTitleChanged(final CharSequence p0);
    
    void onRepeatModeChanged(final int p0);
    
    void onSessionDestroyed();
    
    void onShuffleModeChanged(final boolean p0);
    
    void onVolumeInfoChanged(final ParcelableVolumeInfo p0);
}
