// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.content.Intent;
import android.os.ResultReceiver;
import android.os.Bundle;

interface MediaSessionCompatApi21$Callback extends MediaSessionCompatApi19$Callback
{
    void onCommand(final String p0, final Bundle p1, final ResultReceiver p2);
    
    void onCustomAction(final String p0, final Bundle p1);
    
    void onFastForward();
    
    boolean onMediaButtonEvent(final Intent p0);
    
    void onPause();
    
    void onPlay();
    
    void onPlayFromMediaId(final String p0, final Bundle p1);
    
    void onPlayFromSearch(final String p0, final Bundle p1);
    
    void onRewind();
    
    void onSkipToNext();
    
    void onSkipToPrevious();
    
    void onSkipToQueueItem(final long p0);
    
    void onStop();
}
