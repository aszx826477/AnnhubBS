// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.support.v4.media.session.MediaSessionCompat$Token;
import android.content.ComponentName;
import android.os.Bundle;

interface MediaBrowserCompat$MediaBrowserImpl
{
    void connect();
    
    void disconnect();
    
    Bundle getExtras();
    
    void getItem(final String p0, final MediaBrowserCompat$ItemCallback p1);
    
    String getRoot();
    
    ComponentName getServiceComponent();
    
    MediaSessionCompat$Token getSessionToken();
    
    boolean isConnected();
    
    void search(final String p0, final Bundle p1, final MediaBrowserCompat$SearchCallback p2);
    
    void sendCustomAction(final String p0, final Bundle p1, final MediaBrowserCompat$CustomActionCallback p2);
    
    void subscribe(final String p0, final Bundle p1, final MediaBrowserCompat$SubscriptionCallback p2);
    
    void unsubscribe(final String p0, final MediaBrowserCompat$SubscriptionCallback p1);
}
