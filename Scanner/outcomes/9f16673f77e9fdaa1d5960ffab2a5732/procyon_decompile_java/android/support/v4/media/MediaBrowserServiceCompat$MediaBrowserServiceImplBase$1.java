// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import java.util.Iterator;
import android.os.RemoteException;
import android.util.Log;
import android.support.v4.media.session.MediaSessionCompat$Token;

class MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1 implements Runnable
{
    final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplBase this$1;
    final /* synthetic */ MediaSessionCompat$Token val$token;
    
    MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1(final MediaBrowserServiceCompat$MediaBrowserServiceImplBase this$1, final MediaSessionCompat$Token val$token) {
        this.this$1 = this$1;
        this.val$token = val$token;
    }
    
    public void run() {
        final Iterator iterator = this.this$1.this$0.mConnections.values().iterator();
        while (iterator.hasNext()) {
            final MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = iterator.next();
            try {
                final MediaBrowserServiceCompat$ServiceCallbacks callbacks = mediaBrowserServiceCompat$ConnectionRecord.callbacks;
                try {
                    final MediaBrowserServiceCompat$BrowserRoot root = mediaBrowserServiceCompat$ConnectionRecord.root;
                    try {
                        final String rootId = root.getRootId();
                        try {
                            final MediaSessionCompat$Token val$token = this.val$token;
                            try {
                                final MediaBrowserServiceCompat$BrowserRoot root2 = mediaBrowserServiceCompat$ConnectionRecord.root;
                                try {
                                    callbacks.onConnect(rootId, val$token, root2.getExtras());
                                }
                                catch (RemoteException ex) {
                                    final String s = "MBServiceCompat";
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("Connection for ");
                                    sb.append(mediaBrowserServiceCompat$ConnectionRecord.pkg);
                                    sb.append(" is no longer valid.");
                                    Log.w(s, sb.toString());
                                    iterator.remove();
                                }
                            }
                            catch (RemoteException ex2) {}
                        }
                        catch (RemoteException ex3) {}
                    }
                    catch (RemoteException ex4) {}
                }
                catch (RemoteException ex5) {}
            }
            catch (RemoteException ex6) {}
        }
    }
}
