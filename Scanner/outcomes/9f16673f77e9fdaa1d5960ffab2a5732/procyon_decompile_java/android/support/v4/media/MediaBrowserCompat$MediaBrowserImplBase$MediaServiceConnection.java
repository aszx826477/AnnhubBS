// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.IBinder;
import android.content.ComponentName;
import android.util.Log;
import android.content.ServiceConnection;

class MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection implements ServiceConnection
{
    final /* synthetic */ MediaBrowserCompat$MediaBrowserImplBase this$0;
    
    MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection(final MediaBrowserCompat$MediaBrowserImplBase this$0) {
        this.this$0 = this$0;
    }
    
    private void postOrRun(final Runnable runnable) {
        if (Thread.currentThread() == this.this$0.mHandler.getLooper().getThread()) {
            runnable.run();
        }
        else {
            this.this$0.mHandler.post(runnable);
        }
    }
    
    boolean isCurrent(final String s) {
        final MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection mServiceConnection = this.this$0.mServiceConnection;
        final boolean b = true;
        if (mServiceConnection != this) {
            if (this.this$0.mState != (b ? 1 : 0)) {
                final String s2 = "MediaBrowserCompat";
                final StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.append(" for ");
                sb.append(this.this$0.mServiceComponent);
                sb.append(" with mServiceConnection=");
                sb.append(this.this$0.mServiceConnection);
                sb.append(" this=");
                sb.append(this);
                Log.i(s2, sb.toString());
            }
            return false;
        }
        return b;
    }
    
    public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        this.postOrRun(new MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$1(this, componentName, binder));
    }
    
    public void onServiceDisconnected(final ComponentName componentName) {
        this.postOrRun(new MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$2(this, componentName));
    }
}
