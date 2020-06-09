// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import java.util.List;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.os.IBinder;

interface MediaBrowserServiceCompat$ServiceCallbacks
{
    IBinder asBinder();
    
    void onConnect(final String p0, final MediaSessionCompat$Token p1, final Bundle p2);
    
    void onConnectFailed();
    
    void onLoadChildren(final String p0, final List p1, final Bundle p2);
}
