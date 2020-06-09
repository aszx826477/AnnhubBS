// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.os.IBinder;
import android.os.Message;
import android.os.Bundle;
import android.os.Messenger;

class MediaBrowserServiceCompat$ServiceCallbacksCompat implements MediaBrowserServiceCompat$ServiceCallbacks
{
    final Messenger mCallbacks;
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    
    MediaBrowserServiceCompat$ServiceCallbacksCompat(final MediaBrowserServiceCompat this$0, final Messenger mCallbacks) {
        this.this$0 = this$0;
        this.mCallbacks = mCallbacks;
    }
    
    private void sendRequest(final int what, final Bundle data) {
        final Message obtain = Message.obtain();
        obtain.what = what;
        obtain.arg1 = 1;
        obtain.setData(data);
        this.mCallbacks.send(obtain);
    }
    
    public IBinder asBinder() {
        return this.mCallbacks.getBinder();
    }
    
    public void onConnect(final String s, final MediaSessionCompat$Token mediaSessionCompat$Token, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        final int n = 1;
        bundle.putInt("extra_service_version", n);
        final Bundle bundle2 = new Bundle();
        bundle2.putString("data_media_item_id", s);
        bundle2.putParcelable("data_media_session_token", (Parcelable)mediaSessionCompat$Token);
        bundle2.putBundle("data_root_hints", bundle);
        this.sendRequest(n, bundle2);
    }
    
    public void onConnectFailed() {
        this.sendRequest(2, null);
    }
    
    public void onLoadChildren(final String s, final List list, final Bundle bundle) {
        final Bundle bundle2 = new Bundle();
        bundle2.putString("data_media_item_id", s);
        bundle2.putBundle("data_options", bundle);
        if (list != null) {
            final String s2 = "data_media_item_list";
            ArrayList list2;
            if (list instanceof ArrayList) {
                list2 = (ArrayList<? extends E>)list;
            }
            else {
                list2 = new ArrayList(list);
            }
            bundle2.putParcelableArrayList(s2, list2);
        }
        this.sendRequest(3, bundle2);
    }
}
