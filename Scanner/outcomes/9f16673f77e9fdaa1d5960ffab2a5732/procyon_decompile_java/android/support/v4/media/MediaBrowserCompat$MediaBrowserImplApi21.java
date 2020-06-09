// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Binder;
import android.os.Build$VERSION;
import java.lang.ref.WeakReference;
import java.util.List;
import android.support.v4.media.session.IMediaSession;
import android.os.IBinder;
import android.support.v4.media.session.IMediaSession$Stub;
import android.support.v4.app.BundleCompat;
import android.support.v4.os.ResultReceiver;
import android.os.Handler;
import android.text.TextUtils;
import android.os.RemoteException;
import android.util.Log;
import android.content.ComponentName;
import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.os.Messenger;

class MediaBrowserCompat$MediaBrowserImplApi21 implements MediaBrowserCompat$MediaBrowserImpl, MediaBrowserCompat$MediaBrowserServiceCallbackImpl, MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal
{
    protected final Object mBrowserObj;
    protected Messenger mCallbacksMessenger;
    protected final MediaBrowserCompat$CallbackHandler mHandler;
    private MediaSessionCompat$Token mMediaSessionToken;
    protected final Bundle mRootHints;
    protected MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper;
    private final ArrayMap mSubscriptions;
    
    public MediaBrowserCompat$MediaBrowserImplApi21(final Context context, final ComponentName componentName, final MediaBrowserCompat$ConnectionCallback mediaBrowserCompat$ConnectionCallback, Bundle bundle) {
        this.mHandler = new MediaBrowserCompat$CallbackHandler(this);
        this.mSubscriptions = new ArrayMap();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("extra_client_version", 1);
        this.mRootHints = new Bundle(bundle);
        mediaBrowserCompat$ConnectionCallback.setInternalConnectionCallback(this);
        this.mBrowserObj = MediaBrowserCompatApi21.createBrowser(context, componentName, mediaBrowserCompat$ConnectionCallback.mConnectionCallbackObj, this.mRootHints);
    }
    
    public void connect() {
        MediaBrowserCompatApi21.connect(this.mBrowserObj);
    }
    
    public void disconnect() {
        final MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper = this.mServiceBinderWrapper;
        if (mServiceBinderWrapper != null) {
            final Messenger mCallbacksMessenger = this.mCallbacksMessenger;
            if (mCallbacksMessenger != null) {
                final MediaBrowserCompat$ServiceBinderWrapper mediaBrowserCompat$ServiceBinderWrapper = mServiceBinderWrapper;
                try {
                    mediaBrowserCompat$ServiceBinderWrapper.unregisterCallbackMessenger(mCallbacksMessenger);
                }
                catch (RemoteException ex) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
        }
        MediaBrowserCompatApi21.disconnect(this.mBrowserObj);
    }
    
    public Bundle getExtras() {
        return MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
    }
    
    public void getItem(final String s, final MediaBrowserCompat$ItemCallback mediaBrowserCompat$ItemCallback) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("mediaId is empty");
        }
        if (mediaBrowserCompat$ItemCallback == null) {
            throw new IllegalArgumentException("cb is null");
        }
        if (!MediaBrowserCompatApi21.isConnected(this.mBrowserObj)) {
            Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
            this.mHandler.post((Runnable)new MediaBrowserCompat$MediaBrowserImplApi21$1(this, mediaBrowserCompat$ItemCallback, s));
            return;
        }
        if (this.mServiceBinderWrapper == null) {
            this.mHandler.post((Runnable)new MediaBrowserCompat$MediaBrowserImplApi21$2(this, mediaBrowserCompat$ItemCallback, s));
            return;
        }
        final MediaBrowserCompat$ItemReceiver mediaBrowserCompat$ItemReceiver = new MediaBrowserCompat$ItemReceiver(s, mediaBrowserCompat$ItemCallback, this.mHandler);
        try {
            final MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper = this.mServiceBinderWrapper;
            try {
                mServiceBinderWrapper.getMediaItem(s, mediaBrowserCompat$ItemReceiver, this.mCallbacksMessenger);
            }
            catch (RemoteException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Remote error getting media item: ");
                sb.append(s);
                Log.i("MediaBrowserCompat", sb.toString());
                this.mHandler.post((Runnable)new MediaBrowserCompat$MediaBrowserImplApi21$3(this, mediaBrowserCompat$ItemCallback, s));
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public String getRoot() {
        return MediaBrowserCompatApi21.getRoot(this.mBrowserObj);
    }
    
    public ComponentName getServiceComponent() {
        return MediaBrowserCompatApi21.getServiceComponent(this.mBrowserObj);
    }
    
    public MediaSessionCompat$Token getSessionToken() {
        if (this.mMediaSessionToken == null) {
            this.mMediaSessionToken = MediaSessionCompat$Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj));
        }
        return this.mMediaSessionToken;
    }
    
    public boolean isConnected() {
        return MediaBrowserCompatApi21.isConnected(this.mBrowserObj);
    }
    
    public void onConnected() {
        final Bundle extras = MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
        if (extras == null) {
            return;
        }
        final IBinder binder = BundleCompat.getBinder(extras, "extra_messenger");
        if (binder != null) {
            this.mServiceBinderWrapper = new MediaBrowserCompat$ServiceBinderWrapper(binder, this.mRootHints);
            this.mCallbacksMessenger = new Messenger((Handler)this.mHandler);
            this.mHandler.setCallbacksMessenger(this.mCallbacksMessenger);
            try {
                final MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper = this.mServiceBinderWrapper;
                try {
                    mServiceBinderWrapper.registerCallbackMessenger(this.mCallbacksMessenger);
                }
                catch (RemoteException ex) {
                    Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                }
            }
            catch (RemoteException ex2) {}
        }
        final IMediaSession interface1 = IMediaSession$Stub.asInterface(BundleCompat.getBinder(extras, "extra_session_binder"));
        if (interface1 != null) {
            this.mMediaSessionToken = MediaSessionCompat$Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj), interface1);
        }
    }
    
    public void onConnectionFailed() {
    }
    
    public void onConnectionFailed(final Messenger messenger) {
    }
    
    public void onConnectionSuspended() {
        this.mServiceBinderWrapper = null;
        this.mCallbacksMessenger = null;
        this.mMediaSessionToken = null;
        this.mHandler.setCallbacksMessenger(null);
    }
    
    public void onLoadChildren(final Messenger messenger, final String s, final List list, final Bundle bundle) {
        if (this.mCallbacksMessenger != messenger) {
            return;
        }
        final MediaBrowserCompat$Subscription mediaBrowserCompat$Subscription = (MediaBrowserCompat$Subscription)this.mSubscriptions.get(s);
        if (mediaBrowserCompat$Subscription == null) {
            if (MediaBrowserCompat.DEBUG) {
                final String s2 = "MediaBrowserCompat";
                final StringBuilder sb = new StringBuilder();
                sb.append("onLoadChildren for id that isn't subscribed id=");
                sb.append(s);
                Log.d(s2, sb.toString());
            }
            return;
        }
        final MediaBrowserCompat$SubscriptionCallback callback = mediaBrowserCompat$Subscription.getCallback(bundle);
        if (callback != null) {
            if (bundle == null) {
                if (list == null) {
                    callback.onError(s);
                }
                else {
                    callback.onChildrenLoaded(s, list);
                }
            }
            else if (list == null) {
                callback.onError(s, bundle);
            }
            else {
                callback.onChildrenLoaded(s, list, bundle);
            }
        }
    }
    
    public void onServiceConnected(final Messenger messenger, final String s, final MediaSessionCompat$Token mediaSessionCompat$Token, final Bundle bundle) {
    }
    
    public void search(final String s, final Bundle bundle, final MediaBrowserCompat$SearchCallback mediaBrowserCompat$SearchCallback) {
        if (!this.isConnected()) {
            throw new IllegalStateException("search() called while not connected");
        }
        if (this.mServiceBinderWrapper == null) {
            Log.i("MediaBrowserCompat", "The connected service doesn't support search.");
            this.mHandler.post((Runnable)new MediaBrowserCompat$MediaBrowserImplApi21$4(this, mediaBrowserCompat$SearchCallback, s, bundle));
            return;
        }
        final MediaBrowserCompat$SearchResultReceiver mediaBrowserCompat$SearchResultReceiver = new MediaBrowserCompat$SearchResultReceiver(s, bundle, mediaBrowserCompat$SearchCallback, this.mHandler);
        try {
            final MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper = this.mServiceBinderWrapper;
            try {
                mServiceBinderWrapper.search(s, bundle, mediaBrowserCompat$SearchResultReceiver, this.mCallbacksMessenger);
            }
            catch (RemoteException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Remote error searching items with query: ");
                sb.append(s);
                Log.i("MediaBrowserCompat", sb.toString(), (Throwable)ex);
                this.mHandler.post((Runnable)new MediaBrowserCompat$MediaBrowserImplApi21$5(this, mediaBrowserCompat$SearchCallback, s, bundle));
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public void sendCustomAction(final String s, final Bundle bundle, final MediaBrowserCompat$CustomActionCallback mediaBrowserCompat$CustomActionCallback) {
        if (this.isConnected()) {
            if (this.mServiceBinderWrapper == null) {
                Log.i("MediaBrowserCompat", "The connected service doesn't support sendCustomAction.");
                this.mHandler.post((Runnable)new MediaBrowserCompat$MediaBrowserImplApi21$6(this, mediaBrowserCompat$CustomActionCallback, s, bundle));
            }
            final MediaBrowserCompat$CustomActionResultReceiver mediaBrowserCompat$CustomActionResultReceiver = new MediaBrowserCompat$CustomActionResultReceiver(s, bundle, mediaBrowserCompat$CustomActionCallback, this.mHandler);
            try {
                final MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper = this.mServiceBinderWrapper;
                try {
                    mServiceBinderWrapper.sendCustomAction(s, bundle, mediaBrowserCompat$CustomActionResultReceiver, this.mCallbacksMessenger);
                }
                catch (RemoteException ex) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Remote error sending a custom action: action=");
                    sb.append(s);
                    sb.append(", extras=");
                    sb.append(bundle);
                    Log.i("MediaBrowserCompat", sb.toString(), (Throwable)ex);
                    this.mHandler.post((Runnable)new MediaBrowserCompat$MediaBrowserImplApi21$7(this, mediaBrowserCompat$CustomActionCallback, s, bundle));
                }
            }
            catch (RemoteException ex2) {}
            return;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot send a custom action (");
        sb2.append(s);
        sb2.append(") with ");
        sb2.append("extras ");
        sb2.append(bundle);
        sb2.append(" because the browser is not connected to the ");
        sb2.append("service.");
        throw new IllegalStateException(sb2.toString());
    }
    
    public void subscribe(final String s, final Bundle bundle, final MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback) {
        MediaBrowserCompat$Subscription mediaBrowserCompat$Subscription = (MediaBrowserCompat$Subscription)this.mSubscriptions.get(s);
        if (mediaBrowserCompat$Subscription == null) {
            mediaBrowserCompat$Subscription = new MediaBrowserCompat$Subscription();
            this.mSubscriptions.put(s, mediaBrowserCompat$Subscription);
        }
        mediaBrowserCompat$SubscriptionCallback.setSubscription(mediaBrowserCompat$Subscription);
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = null;
        }
        else {
            bundle2 = new Bundle(bundle);
        }
        mediaBrowserCompat$Subscription.putCallback(bundle2, mediaBrowserCompat$SubscriptionCallback);
        final MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper = this.mServiceBinderWrapper;
        if (mServiceBinderWrapper == null) {
            MediaBrowserCompatApi21.subscribe(this.mBrowserObj, s, mediaBrowserCompat$SubscriptionCallback.mSubscriptionCallbackObj);
        }
        else {
            try {
                final IBinder access$000 = mediaBrowserCompat$SubscriptionCallback.mToken;
                try {
                    mServiceBinderWrapper.addSubscription(s, access$000, bundle2, this.mCallbacksMessenger);
                }
                catch (RemoteException ex) {
                    final String s2 = "MediaBrowserCompat";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Remote error subscribing media item: ");
                    sb.append(s);
                    Log.i(s2, sb.toString());
                }
            }
            catch (RemoteException ex2) {}
        }
    }
    
    public void unsubscribe(final String s, final MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback) {
        final MediaBrowserCompat$Subscription mediaBrowserCompat$Subscription = (MediaBrowserCompat$Subscription)this.mSubscriptions.get(s);
        if (mediaBrowserCompat$Subscription == null) {
            return;
        }
        final MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper = this.mServiceBinderWrapper;
        if (mServiceBinderWrapper == null) {
            if (mediaBrowserCompat$SubscriptionCallback == null) {
                MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, s);
            }
            else {
                final List callbacks = mediaBrowserCompat$Subscription.getCallbacks();
                final List optionsList = mediaBrowserCompat$Subscription.getOptionsList();
                for (int i = callbacks.size() - 1; i >= 0; --i) {
                    if (callbacks.get(i) == mediaBrowserCompat$SubscriptionCallback) {
                        callbacks.remove(i);
                        optionsList.remove(i);
                    }
                }
                if (callbacks.size() == 0) {
                    MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, s);
                }
            }
        }
        else {
            Label_0181: {
                if (mediaBrowserCompat$SubscriptionCallback != null) {
                    break Label_0181;
                }
                try {
                    mServiceBinderWrapper.removeSubscription(s, null, this.mCallbacksMessenger);
                    Label_0286: {
                        break Label_0286;
                        final List callbacks2 = mediaBrowserCompat$Subscription.getCallbacks();
                        try {
                            final List optionsList2 = mediaBrowserCompat$Subscription.getOptionsList();
                            try {
                                int n = callbacks2.size() - 1;
                                while (true) {
                                    if (n < 0) {
                                        break Label_0286;
                                    }
                                    Label_0277: {
                                        if (callbacks2.get(n) != mediaBrowserCompat$SubscriptionCallback) {
                                            break Label_0277;
                                        }
                                        final MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper2 = this.mServiceBinderWrapper;
                                        try {
                                            final IBinder access$000 = mediaBrowserCompat$SubscriptionCallback.mToken;
                                            try {
                                                mServiceBinderWrapper2.removeSubscription(s, access$000, this.mCallbacksMessenger);
                                                final List<MediaBrowserCompat$SubscriptionCallback> list = (List<MediaBrowserCompat$SubscriptionCallback>)callbacks2;
                                                try {
                                                    list.remove(n);
                                                    final List list2 = optionsList2;
                                                    try {
                                                        list2.remove(n);
                                                        --n;
                                                        continue;
                                                    }
                                                    catch (RemoteException ex) {
                                                        final String s2 = "MediaBrowserCompat";
                                                        final StringBuilder sb = new StringBuilder();
                                                        sb.append("removeSubscription failed with RemoteException parentId=");
                                                        sb.append(s);
                                                        Log.d(s2, sb.toString());
                                                    }
                                                }
                                                catch (RemoteException ex2) {}
                                            }
                                            catch (RemoteException ex3) {}
                                        }
                                        catch (RemoteException ex4) {}
                                    }
                                }
                            }
                            catch (RemoteException ex5) {}
                        }
                        catch (RemoteException ex6) {}
                    }
                }
                catch (RemoteException ex7) {}
            }
        }
        if (mediaBrowserCompat$Subscription.isEmpty() || mediaBrowserCompat$SubscriptionCallback == null) {
            this.mSubscriptions.remove(s);
        }
    }
}
