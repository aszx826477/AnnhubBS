// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Parcelable;
import android.support.v4.os.ResultReceiver;
import android.content.Context;
import android.support.v4.app.BundleCompat;
import android.os.Message;
import android.os.IBinder;
import android.os.Bundle;
import android.os.Messenger;

class MediaBrowserCompat$ServiceBinderWrapper
{
    private Messenger mMessenger;
    private Bundle mRootHints;
    
    public MediaBrowserCompat$ServiceBinderWrapper(final IBinder binder, final Bundle mRootHints) {
        this.mMessenger = new Messenger(binder);
        this.mRootHints = mRootHints;
    }
    
    private void sendRequest(final int what, final Bundle data, final Messenger replyTo) {
        final Message obtain = Message.obtain();
        obtain.what = what;
        obtain.arg1 = 1;
        obtain.setData(data);
        obtain.replyTo = replyTo;
        this.mMessenger.send(obtain);
    }
    
    void addSubscription(final String s, final IBinder binder, final Bundle bundle, final Messenger messenger) {
        final Bundle bundle2 = new Bundle();
        bundle2.putString("data_media_item_id", s);
        BundleCompat.putBinder(bundle2, "data_callback_token", binder);
        bundle2.putBundle("data_options", bundle);
        this.sendRequest(3, bundle2, messenger);
    }
    
    void connect(final Context context, final Messenger messenger) {
        final Bundle bundle = new Bundle();
        bundle.putString("data_package_name", context.getPackageName());
        bundle.putBundle("data_root_hints", this.mRootHints);
        this.sendRequest(1, bundle, messenger);
    }
    
    void disconnect(final Messenger messenger) {
        this.sendRequest(2, null, messenger);
    }
    
    void getMediaItem(final String s, final ResultReceiver resultReceiver, final Messenger messenger) {
        final Bundle bundle = new Bundle();
        bundle.putString("data_media_item_id", s);
        bundle.putParcelable("data_result_receiver", (Parcelable)resultReceiver);
        this.sendRequest(5, bundle, messenger);
    }
    
    void registerCallbackMessenger(final Messenger messenger) {
        final Bundle bundle = new Bundle();
        bundle.putBundle("data_root_hints", this.mRootHints);
        this.sendRequest(6, bundle, messenger);
    }
    
    void removeSubscription(final String s, final IBinder binder, final Messenger messenger) {
        final Bundle bundle = new Bundle();
        bundle.putString("data_media_item_id", s);
        BundleCompat.putBinder(bundle, "data_callback_token", binder);
        this.sendRequest(4, bundle, messenger);
    }
    
    void search(final String s, final Bundle bundle, final ResultReceiver resultReceiver, final Messenger messenger) {
        final Bundle bundle2 = new Bundle();
        bundle2.putString("data_search_query", s);
        bundle2.putBundle("data_search_extras", bundle);
        bundle2.putParcelable("data_result_receiver", (Parcelable)resultReceiver);
        this.sendRequest(8, bundle2, messenger);
    }
    
    void sendCustomAction(final String s, final Bundle bundle, final ResultReceiver resultReceiver, final Messenger messenger) {
        final Bundle bundle2 = new Bundle();
        bundle2.putString("data_custom_action", s);
        bundle2.putBundle("data_custom_action_extras", bundle);
        bundle2.putParcelable("data_result_receiver", (Parcelable)resultReceiver);
        this.sendRequest(9, bundle2, messenger);
    }
    
    void unregisterCallbackMessenger(final Messenger messenger) {
        this.sendRequest(7, null, messenger);
    }
}
