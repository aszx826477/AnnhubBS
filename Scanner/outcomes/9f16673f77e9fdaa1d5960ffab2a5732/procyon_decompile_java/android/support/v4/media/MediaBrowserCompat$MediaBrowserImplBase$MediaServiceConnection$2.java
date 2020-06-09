// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Messenger;
import android.util.Log;
import android.content.ComponentName;

class MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$2 implements Runnable
{
    final /* synthetic */ MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection this$1;
    final /* synthetic */ ComponentName val$name;
    
    MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$2(final MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection this$1, final ComponentName val$name) {
        this.this$1 = this$1;
        this.val$name = val$name;
    }
    
    public void run() {
        if (MediaBrowserCompat.DEBUG) {
            final StringBuilder sb = new StringBuilder();
            sb.append("MediaServiceConnection.onServiceDisconnected name=");
            sb.append(this.val$name);
            sb.append(" this=");
            sb.append(this);
            sb.append(" mServiceConnection=");
            sb.append(this.this$1.this$0.mServiceConnection);
            Log.d("MediaBrowserCompat", sb.toString());
            this.this$1.this$0.dump();
        }
        if (!this.this$1.isCurrent("onServiceDisconnected")) {
            return;
        }
        this.this$1.this$0.mServiceBinderWrapper = null;
        this.this$1.this$0.mCallbacksMessenger = null;
        this.this$1.this$0.mHandler.setCallbacksMessenger(null);
        this.this$1.this$0.mState = 4;
        this.this$1.this$0.mCallback.onConnectionSuspended();
    }
}
