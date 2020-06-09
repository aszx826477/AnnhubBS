// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat$Token;
import java.util.List;
import android.os.Messenger;
import android.util.Log;
import android.support.v4.media.session.MediaSessionCompat;
import android.os.Message;
import java.lang.ref.WeakReference;
import android.os.Handler;

class MediaBrowserCompat$CallbackHandler extends Handler
{
    private final WeakReference mCallbackImplRef;
    private WeakReference mCallbacksMessengerRef;
    
    MediaBrowserCompat$CallbackHandler(final MediaBrowserCompat$MediaBrowserServiceCallbackImpl mediaBrowserCompat$MediaBrowserServiceCallbackImpl) {
        this.mCallbackImplRef = new WeakReference((T)mediaBrowserCompat$MediaBrowserServiceCallbackImpl);
    }
    
    public void handleMessage(final Message message) {
        final WeakReference mCallbacksMessengerRef = this.mCallbacksMessengerRef;
        if (mCallbacksMessengerRef != null && mCallbacksMessengerRef.get() != null && this.mCallbackImplRef.get() != null) {
            final Bundle data = message.getData();
            data.setClassLoader(MediaSessionCompat.class.getClassLoader());
            switch (message.what) {
                default: {
                    final String s = "MediaBrowserCompat";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unhandled message: ");
                    sb.append(message);
                    sb.append("\n  Client version: ");
                    sb.append(1);
                    sb.append("\n  Service version: ");
                    sb.append(message.arg1);
                    Log.w(s, sb.toString());
                    break;
                }
                case 3: {
                    ((MediaBrowserCompat$MediaBrowserServiceCallbackImpl)this.mCallbackImplRef.get()).onLoadChildren((Messenger)this.mCallbacksMessengerRef.get(), data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), data.getBundle("data_options"));
                    break;
                }
                case 2: {
                    ((MediaBrowserCompat$MediaBrowserServiceCallbackImpl)this.mCallbackImplRef.get()).onConnectionFailed((Messenger)this.mCallbacksMessengerRef.get());
                    break;
                }
                case 1: {
                    ((MediaBrowserCompat$MediaBrowserServiceCallbackImpl)this.mCallbackImplRef.get()).onServiceConnected((Messenger)this.mCallbacksMessengerRef.get(), data.getString("data_media_item_id"), (MediaSessionCompat$Token)data.getParcelable("data_media_session_token"), data.getBundle("data_root_hints"));
                    break;
                }
            }
        }
    }
    
    void setCallbacksMessenger(final Messenger messenger) {
        this.mCallbacksMessengerRef = new WeakReference((T)messenger);
    }
}
