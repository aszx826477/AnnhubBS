// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.support.v4.media.session.MediaSessionCompat$Token;
import android.os.IBinder;
import android.content.Intent;
import android.os.Bundle;

interface MediaBrowserServiceCompat$MediaBrowserServiceImpl
{
    Bundle getBrowserRootHints();
    
    void notifyChildrenChanged(final String p0, final Bundle p1);
    
    IBinder onBind(final Intent p0);
    
    void onCreate();
    
    void setSessionToken(final MediaSessionCompat$Token p0);
}
