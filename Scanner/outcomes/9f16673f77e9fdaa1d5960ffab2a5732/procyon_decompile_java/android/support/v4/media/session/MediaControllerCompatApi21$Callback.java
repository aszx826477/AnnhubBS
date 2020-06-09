// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import java.util.List;
import android.os.Bundle;

public interface MediaControllerCompatApi21$Callback
{
    void onAudioInfoChanged(final int p0, final int p1, final int p2, final int p3, final int p4);
    
    void onExtrasChanged(final Bundle p0);
    
    void onMetadataChanged(final Object p0);
    
    void onPlaybackStateChanged(final Object p0);
    
    void onQueueChanged(final List p0);
    
    void onQueueTitleChanged(final CharSequence p0);
    
    void onSessionDestroyed();
    
    void onSessionEvent(final String p0, final Bundle p1);
}
