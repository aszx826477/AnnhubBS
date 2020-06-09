// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.RemoteException;
import android.util.Log;
import java.util.List;
import android.os.Bundle;

class MediaBrowserServiceCompat$1 extends MediaBrowserServiceCompat$Result
{
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    final /* synthetic */ MediaBrowserServiceCompat$ConnectionRecord val$connection;
    final /* synthetic */ Bundle val$options;
    final /* synthetic */ String val$parentId;
    
    MediaBrowserServiceCompat$1(final MediaBrowserServiceCompat this$0, final Object o, final MediaBrowserServiceCompat$ConnectionRecord val$connection, final String val$parentId, final Bundle val$options) {
        this.this$0 = this$0;
        this.val$connection = val$connection;
        this.val$parentId = val$parentId;
        this.val$options = val$options;
        super(o);
    }
    
    void onResultSent(final List list) {
        if (this.this$0.mConnections.get(this.val$connection.callbacks.asBinder()) != this.val$connection) {
            if (MediaBrowserServiceCompat.DEBUG) {
                final String s = "MBServiceCompat";
                final StringBuilder sb = new StringBuilder();
                sb.append("Not sending onLoadChildren result for connection that has been disconnected. pkg=");
                sb.append(this.val$connection.pkg);
                sb.append(" id=");
                sb.append(this.val$parentId);
                Log.d(s, sb.toString());
            }
            return;
        }
        List applyOptions;
        if ((this.getFlags() & 0x1) != 0x0) {
            applyOptions = this.this$0.applyOptions(list, this.val$options);
        }
        else {
            applyOptions = list;
        }
        try {
            final MediaBrowserServiceCompat$ConnectionRecord val$connection = this.val$connection;
            try {
                final MediaBrowserServiceCompat$ServiceCallbacks callbacks = val$connection.callbacks;
                try {
                    final String val$parentId = this.val$parentId;
                    try {
                        callbacks.onLoadChildren(val$parentId, applyOptions, this.val$options);
                    }
                    catch (RemoteException ex) {
                        final String s2 = "MBServiceCompat";
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Calling onLoadChildren() failed for id=");
                        sb2.append(this.val$parentId);
                        sb2.append(" package=");
                        sb2.append(this.val$connection.pkg);
                        Log.w(s2, sb2.toString());
                    }
                }
                catch (RemoteException ex2) {}
            }
            catch (RemoteException ex3) {}
        }
        catch (RemoteException ex4) {}
    }
}
