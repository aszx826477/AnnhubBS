// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.support.v4.media.session.MediaSessionCompat$Token;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.os.Bundle;

class MediaBrowserServiceCompat$ServiceBinderImpl$1 implements Runnable
{
    final /* synthetic */ MediaBrowserServiceCompat$ServiceBinderImpl this$1;
    final /* synthetic */ MediaBrowserServiceCompat$ServiceCallbacks val$callbacks;
    final /* synthetic */ String val$pkg;
    final /* synthetic */ Bundle val$rootHints;
    final /* synthetic */ int val$uid;
    
    MediaBrowserServiceCompat$ServiceBinderImpl$1(final MediaBrowserServiceCompat$ServiceBinderImpl this$1, final MediaBrowserServiceCompat$ServiceCallbacks val$callbacks, final String val$pkg, final Bundle val$rootHints, final int val$uid) {
        this.this$1 = this$1;
        this.val$callbacks = val$callbacks;
        this.val$pkg = val$pkg;
        this.val$rootHints = val$rootHints;
        this.val$uid = val$uid;
    }
    
    public void run() {
        final IBinder binder = this.val$callbacks.asBinder();
        this.this$1.this$0.mConnections.remove(binder);
        final MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = new MediaBrowserServiceCompat$ConnectionRecord(this.this$1.this$0);
        mediaBrowserServiceCompat$ConnectionRecord.pkg = this.val$pkg;
        mediaBrowserServiceCompat$ConnectionRecord.rootHints = this.val$rootHints;
        mediaBrowserServiceCompat$ConnectionRecord.callbacks = this.val$callbacks;
        mediaBrowserServiceCompat$ConnectionRecord.root = this.this$1.this$0.onGetRoot(this.val$pkg, this.val$uid, this.val$rootHints);
        if (mediaBrowserServiceCompat$ConnectionRecord.root == null) {
            final String s = "MBServiceCompat";
            final StringBuilder sb = new StringBuilder();
            sb.append("No root for client ");
            sb.append(this.val$pkg);
            sb.append(" from service ");
            sb.append(this.getClass().getName());
            Log.i(s, sb.toString());
            try {
                final MediaBrowserServiceCompat$ServiceCallbacks val$callbacks = this.val$callbacks;
                try {
                    val$callbacks.onConnectFailed();
                }
                catch (RemoteException ex) {
                    final String s2 = "MBServiceCompat";
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Calling onConnectFailed() failed. Ignoring. pkg=");
                    sb2.append(this.val$pkg);
                    Log.w(s2, sb2.toString());
                }
            }
            catch (RemoteException ex2) {}
        }
        else {
            try {
                final MediaBrowserServiceCompat$ServiceBinderImpl this$1 = this.this$1;
                try {
                    final MediaBrowserServiceCompat this$2 = this$1.this$0;
                    try {
                        this$2.mConnections.put(binder, mediaBrowserServiceCompat$ConnectionRecord);
                        final MediaBrowserServiceCompat$ServiceBinderImpl this$3 = this.this$1;
                        try {
                            final MediaBrowserServiceCompat this$4 = this$3.this$0;
                            try {
                                Label_0373: {
                                    if (this$4.mSession == null) {
                                        break Label_0373;
                                    }
                                    final MediaBrowserServiceCompat$ServiceCallbacks val$callbacks2 = this.val$callbacks;
                                    try {
                                        final MediaBrowserServiceCompat$BrowserRoot root = mediaBrowserServiceCompat$ConnectionRecord.root;
                                        try {
                                            final String rootId = root.getRootId();
                                            try {
                                                final MediaBrowserServiceCompat$ServiceBinderImpl this$5 = this.this$1;
                                                try {
                                                    final MediaBrowserServiceCompat this$6 = this$5.this$0;
                                                    try {
                                                        final MediaSessionCompat$Token mSession = this$6.mSession;
                                                        try {
                                                            final MediaBrowserServiceCompat$BrowserRoot root2 = mediaBrowserServiceCompat$ConnectionRecord.root;
                                                            try {
                                                                val$callbacks2.onConnect(rootId, mSession, root2.getExtras());
                                                            }
                                                            catch (RemoteException ex3) {
                                                                final StringBuilder sb3 = new StringBuilder();
                                                                sb3.append("Calling onConnect() failed. Dropping client. pkg=");
                                                                sb3.append(this.val$pkg);
                                                                Log.w("MBServiceCompat", sb3.toString());
                                                                this.this$1.this$0.mConnections.remove(binder);
                                                            }
                                                        }
                                                        catch (RemoteException ex4) {}
                                                    }
                                                    catch (RemoteException ex5) {}
                                                }
                                                catch (RemoteException ex6) {}
                                            }
                                            catch (RemoteException ex7) {}
                                        }
                                        catch (RemoteException ex8) {}
                                    }
                                    catch (RemoteException ex9) {}
                                }
                            }
                            catch (RemoteException ex10) {}
                        }
                        catch (RemoteException ex11) {}
                    }
                    catch (RemoteException ex12) {}
                }
                catch (RemoteException ex13) {}
            }
            catch (RemoteException ex14) {}
        }
    }
}
