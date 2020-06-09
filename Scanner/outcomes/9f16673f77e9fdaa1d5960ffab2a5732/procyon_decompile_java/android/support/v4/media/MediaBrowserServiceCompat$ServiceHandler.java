// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Binder;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import android.os.Message;
import android.os.Handler;

final class MediaBrowserServiceCompat$ServiceHandler extends Handler
{
    private final MediaBrowserServiceCompat$ServiceBinderImpl mServiceBinderImpl;
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    
    MediaBrowserServiceCompat$ServiceHandler(final MediaBrowserServiceCompat this$0) {
        this.this$0 = this$0;
        this.mServiceBinderImpl = new MediaBrowserServiceCompat$ServiceBinderImpl(this.this$0);
    }
    
    public void handleMessage(final Message message) {
        final Bundle data = message.getData();
        switch (message.what) {
            default: {
                final String s = "MBServiceCompat";
                final StringBuilder sb = new StringBuilder();
                sb.append("Unhandled message: ");
                sb.append(message);
                sb.append("\n  Service version: ");
                sb.append(1);
                sb.append("\n  Client version: ");
                sb.append(message.arg1);
                Log.w(s, sb.toString());
                break;
            }
            case 9: {
                this.mServiceBinderImpl.sendCustomAction(data.getString("data_custom_action"), data.getBundle("data_custom_action_extras"), (ResultReceiver)data.getParcelable("data_result_receiver"), new MediaBrowserServiceCompat$ServiceCallbacksCompat(this.this$0, message.replyTo));
                break;
            }
            case 8: {
                this.mServiceBinderImpl.search(data.getString("data_search_query"), data.getBundle("data_search_extras"), (ResultReceiver)data.getParcelable("data_result_receiver"), new MediaBrowserServiceCompat$ServiceCallbacksCompat(this.this$0, message.replyTo));
                break;
            }
            case 7: {
                this.mServiceBinderImpl.unregisterCallbacks(new MediaBrowserServiceCompat$ServiceCallbacksCompat(this.this$0, message.replyTo));
                break;
            }
            case 6: {
                this.mServiceBinderImpl.registerCallbacks(new MediaBrowserServiceCompat$ServiceCallbacksCompat(this.this$0, message.replyTo), data.getBundle("data_root_hints"));
                break;
            }
            case 5: {
                this.mServiceBinderImpl.getMediaItem(data.getString("data_media_item_id"), (ResultReceiver)data.getParcelable("data_result_receiver"), new MediaBrowserServiceCompat$ServiceCallbacksCompat(this.this$0, message.replyTo));
                break;
            }
            case 4: {
                this.mServiceBinderImpl.removeSubscription(data.getString("data_media_item_id"), BundleCompat.getBinder(data, "data_callback_token"), new MediaBrowserServiceCompat$ServiceCallbacksCompat(this.this$0, message.replyTo));
                break;
            }
            case 3: {
                this.mServiceBinderImpl.addSubscription(data.getString("data_media_item_id"), BundleCompat.getBinder(data, "data_callback_token"), data.getBundle("data_options"), new MediaBrowserServiceCompat$ServiceCallbacksCompat(this.this$0, message.replyTo));
                break;
            }
            case 2: {
                this.mServiceBinderImpl.disconnect(new MediaBrowserServiceCompat$ServiceCallbacksCompat(this.this$0, message.replyTo));
                break;
            }
            case 1: {
                this.mServiceBinderImpl.connect(data.getString("data_package_name"), data.getInt("data_calling_uid"), data.getBundle("data_root_hints"), new MediaBrowserServiceCompat$ServiceCallbacksCompat(this.this$0, message.replyTo));
                break;
            }
        }
    }
    
    public void postOrRun(final Runnable runnable) {
        if (Thread.currentThread() == this.getLooper().getThread()) {
            runnable.run();
        }
        else {
            this.post(runnable);
        }
    }
    
    public boolean sendMessageAtTime(final Message message, final long n) {
        final Bundle data = message.getData();
        data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
        data.putInt("data_calling_uid", Binder.getCallingUid());
        return super.sendMessageAtTime(message, n);
    }
}
