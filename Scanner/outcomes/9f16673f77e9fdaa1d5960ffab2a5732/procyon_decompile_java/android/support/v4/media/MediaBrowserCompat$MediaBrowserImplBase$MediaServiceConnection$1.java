// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.content.Context;
import android.os.RemoteException;
import android.os.Handler;
import android.os.Messenger;
import android.util.Log;
import android.content.ComponentName;
import android.os.IBinder;

class MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$1 implements Runnable
{
    final /* synthetic */ MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection this$1;
    final /* synthetic */ IBinder val$binder;
    final /* synthetic */ ComponentName val$name;
    
    MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$1(final MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection this$1, final ComponentName val$name, final IBinder val$binder) {
        this.this$1 = this$1;
        this.val$name = val$name;
        this.val$binder = val$binder;
    }
    
    public void run() {
        if (MediaBrowserCompat.DEBUG) {
            final StringBuilder sb = new StringBuilder();
            sb.append("MediaServiceConnection.onServiceConnected name=");
            sb.append(this.val$name);
            sb.append(" binder=");
            sb.append(this.val$binder);
            Log.d("MediaBrowserCompat", sb.toString());
            this.this$1.this$0.dump();
        }
        if (!this.this$1.isCurrent("onServiceConnected")) {
            return;
        }
        this.this$1.this$0.mServiceBinderWrapper = new MediaBrowserCompat$ServiceBinderWrapper(this.val$binder, this.this$1.this$0.mRootHints);
        this.this$1.this$0.mCallbacksMessenger = new Messenger((Handler)this.this$1.this$0.mHandler);
        this.this$1.this$0.mHandler.setCallbacksMessenger(this.this$1.this$0.mCallbacksMessenger);
        this.this$1.this$0.mState = 2;
        try {
            Label_0271: {
                if (!MediaBrowserCompat.DEBUG) {
                    break Label_0271;
                }
                Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                final MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection this$1 = this.this$1;
                try {
                    final MediaBrowserCompat$MediaBrowserImplBase this$2 = this$1.this$0;
                    try {
                        this$2.dump();
                        final MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection this$3 = this.this$1;
                        try {
                            final MediaBrowserCompat$MediaBrowserImplBase this$4 = this$3.this$0;
                            try {
                                final MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper = this$4.mServiceBinderWrapper;
                                try {
                                    final MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection this$5 = this.this$1;
                                    try {
                                        final MediaBrowserCompat$MediaBrowserImplBase this$6 = this$5.this$0;
                                        try {
                                            final Context mContext = this$6.mContext;
                                            try {
                                                final MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection this$7 = this.this$1;
                                                try {
                                                    final MediaBrowserCompat$MediaBrowserImplBase this$8 = this$7.this$0;
                                                    try {
                                                        mServiceBinderWrapper.connect(mContext, this$8.mCallbacksMessenger);
                                                    }
                                                    catch (RemoteException ex) {
                                                        final String s = "MediaBrowserCompat";
                                                        final StringBuilder sb2 = new StringBuilder();
                                                        sb2.append("RemoteException during connect for ");
                                                        sb2.append(this.this$1.this$0.mServiceComponent);
                                                        Log.w(s, sb2.toString());
                                                        if (MediaBrowserCompat.DEBUG) {
                                                            Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                                            this.this$1.this$0.dump();
                                                        }
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
                            catch (RemoteException ex7) {}
                        }
                        catch (RemoteException ex8) {}
                    }
                    catch (RemoteException ex9) {}
                }
                catch (RemoteException ex10) {}
            }
        }
        catch (RemoteException ex11) {}
    }
}
