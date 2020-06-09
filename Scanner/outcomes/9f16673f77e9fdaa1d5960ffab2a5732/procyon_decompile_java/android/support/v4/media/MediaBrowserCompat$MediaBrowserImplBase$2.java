// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.RemoteException;
import android.util.Log;

class MediaBrowserCompat$MediaBrowserImplBase$2 implements Runnable
{
    final /* synthetic */ MediaBrowserCompat$MediaBrowserImplBase this$0;
    
    MediaBrowserCompat$MediaBrowserImplBase$2(final MediaBrowserCompat$MediaBrowserImplBase this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        if (this.this$0.mCallbacksMessenger != null) {
            try {
                final MediaBrowserCompat$MediaBrowserImplBase this$0 = this.this$0;
                try {
                    final MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper = this$0.mServiceBinderWrapper;
                    try {
                        final MediaBrowserCompat$MediaBrowserImplBase this$2 = this.this$0;
                        try {
                            mServiceBinderWrapper.disconnect(this$2.mCallbacksMessenger);
                        }
                        catch (RemoteException ex) {
                            final String s = "MediaBrowserCompat";
                            final StringBuilder sb = new StringBuilder();
                            sb.append("RemoteException during connect for ");
                            sb.append(this.this$0.mServiceComponent);
                            Log.w(s, sb.toString());
                        }
                    }
                    catch (RemoteException ex2) {}
                }
                catch (RemoteException ex3) {}
            }
            catch (RemoteException ex4) {}
        }
        this.this$0.forceCloseConnection();
        if (MediaBrowserCompat.DEBUG) {
            Log.d("MediaBrowserCompat", "disconnect...");
            this.this$0.dump();
        }
    }
}
