// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Binder;
import android.os.Build$VERSION;
import java.lang.ref.WeakReference;
import android.os.IBinder;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.List;
import android.os.RemoteException;
import android.support.v4.os.ResultReceiver;
import android.os.Handler;
import android.text.TextUtils;
import android.content.ServiceConnection;
import android.content.Intent;
import android.util.Log;
import android.support.v4.util.ArrayMap;
import android.content.ComponentName;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.os.Bundle;
import android.content.Context;
import android.os.Messenger;

class MediaBrowserCompat$MediaBrowserImplBase implements MediaBrowserCompat$MediaBrowserImpl, MediaBrowserCompat$MediaBrowserServiceCallbackImpl
{
    static final int CONNECT_STATE_CONNECTED = 3;
    static final int CONNECT_STATE_CONNECTING = 2;
    static final int CONNECT_STATE_DISCONNECTED = 1;
    static final int CONNECT_STATE_DISCONNECTING = 0;
    static final int CONNECT_STATE_SUSPENDED = 4;
    final MediaBrowserCompat$ConnectionCallback mCallback;
    Messenger mCallbacksMessenger;
    final Context mContext;
    private Bundle mExtras;
    final MediaBrowserCompat$CallbackHandler mHandler;
    private MediaSessionCompat$Token mMediaSessionToken;
    final Bundle mRootHints;
    private String mRootId;
    MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper;
    final ComponentName mServiceComponent;
    MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection mServiceConnection;
    int mState;
    private final ArrayMap mSubscriptions;
    
    public MediaBrowserCompat$MediaBrowserImplBase(final Context mContext, final ComponentName mServiceComponent, final MediaBrowserCompat$ConnectionCallback mCallback, final Bundle bundle) {
        this.mHandler = new MediaBrowserCompat$CallbackHandler(this);
        this.mSubscriptions = new ArrayMap();
        this.mState = 1;
        if (mContext == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if (mServiceComponent == null) {
            throw new IllegalArgumentException("service component must not be null");
        }
        if (mCallback != null) {
            this.mContext = mContext;
            this.mServiceComponent = mServiceComponent;
            this.mCallback = mCallback;
            Bundle mRootHints;
            if (bundle == null) {
                mRootHints = null;
            }
            else {
                mRootHints = new Bundle(bundle);
            }
            this.mRootHints = mRootHints;
            return;
        }
        throw new IllegalArgumentException("connection callback must not be null");
    }
    
    private static String getStateLabel(final int n) {
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("UNKNOWN/");
                sb.append(n);
                return sb.toString();
            }
            case 4: {
                return "CONNECT_STATE_SUSPENDED";
            }
            case 3: {
                return "CONNECT_STATE_CONNECTED";
            }
            case 2: {
                return "CONNECT_STATE_CONNECTING";
            }
            case 1: {
                return "CONNECT_STATE_DISCONNECTED";
            }
            case 0: {
                return "CONNECT_STATE_DISCONNECTING";
            }
        }
    }
    
    private boolean isCurrent(final Messenger messenger, final String s) {
        final Messenger mCallbacksMessenger = this.mCallbacksMessenger;
        final boolean b = true;
        if (mCallbacksMessenger != messenger) {
            if (this.mState != (b ? 1 : 0)) {
                final String s2 = "MediaBrowserCompat";
                final StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.append(" for ");
                sb.append(this.mServiceComponent);
                sb.append(" with mCallbacksMessenger=");
                sb.append(this.mCallbacksMessenger);
                sb.append(" this=");
                sb.append(this);
                Log.i(s2, sb.toString());
            }
            return false;
        }
        return b;
    }
    
    public void connect() {
        final int mState = this.mState;
        final int n = 1;
        if (mState != n) {
            final StringBuilder sb = new StringBuilder();
            sb.append("connect() called while not disconnected (state=");
            sb.append(getStateLabel(this.mState));
            sb.append(")");
            throw new IllegalStateException(sb.toString());
        }
        if (MediaBrowserCompat.DEBUG && this.mServiceConnection != null) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("mServiceConnection should be null. Instead it is ");
            sb2.append(this.mServiceConnection);
            throw new RuntimeException(sb2.toString());
        }
        if (this.mServiceBinderWrapper != null) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("mServiceBinderWrapper should be null. Instead it is ");
            sb3.append(this.mServiceBinderWrapper);
            throw new RuntimeException(sb3.toString());
        }
        if (this.mCallbacksMessenger == null) {
            this.mState = 2;
            final Intent intent = new Intent("android.media.browse.MediaBrowserService");
            intent.setComponent(this.mServiceComponent);
            final MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection mServiceConnection = new MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection(this);
            this.mServiceConnection = mServiceConnection;
            int bindService = 0;
            try {
                final Context mContext = this.mContext;
                try {
                    bindService = (mContext.bindService(intent, (ServiceConnection)this.mServiceConnection, n) ? 1 : 0);
                }
                catch (Exception ex) {
                    final String s = "MediaBrowserCompat";
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append("Failed binding to service ");
                    sb4.append(this.mServiceComponent);
                    Log.e(s, sb4.toString());
                }
            }
            catch (Exception ex2) {}
            if (bindService == 0) {
                this.mHandler.post((Runnable)new MediaBrowserCompat$MediaBrowserImplBase$1(this, (ServiceConnection)mServiceConnection));
            }
            if (MediaBrowserCompat.DEBUG) {
                Log.d("MediaBrowserCompat", "connect...");
                this.dump();
            }
            return;
        }
        final StringBuilder sb5 = new StringBuilder();
        sb5.append("mCallbacksMessenger should be null. Instead it is ");
        sb5.append(this.mCallbacksMessenger);
        throw new RuntimeException(sb5.toString());
    }
    
    public void disconnect() {
        this.mState = 0;
        this.mHandler.post((Runnable)new MediaBrowserCompat$MediaBrowserImplBase$2(this));
    }
    
    void dump() {
        Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
        final StringBuilder sb = new StringBuilder();
        sb.append("  mServiceComponent=");
        sb.append(this.mServiceComponent);
        Log.d("MediaBrowserCompat", sb.toString());
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("  mCallback=");
        sb2.append(this.mCallback);
        Log.d("MediaBrowserCompat", sb2.toString());
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("  mRootHints=");
        sb3.append(this.mRootHints);
        Log.d("MediaBrowserCompat", sb3.toString());
        final StringBuilder sb4 = new StringBuilder();
        sb4.append("  mState=");
        sb4.append(getStateLabel(this.mState));
        Log.d("MediaBrowserCompat", sb4.toString());
        final StringBuilder sb5 = new StringBuilder();
        sb5.append("  mServiceConnection=");
        sb5.append(this.mServiceConnection);
        Log.d("MediaBrowserCompat", sb5.toString());
        final StringBuilder sb6 = new StringBuilder();
        sb6.append("  mServiceBinderWrapper=");
        sb6.append(this.mServiceBinderWrapper);
        Log.d("MediaBrowserCompat", sb6.toString());
        final StringBuilder sb7 = new StringBuilder();
        sb7.append("  mCallbacksMessenger=");
        sb7.append(this.mCallbacksMessenger);
        Log.d("MediaBrowserCompat", sb7.toString());
        final StringBuilder sb8 = new StringBuilder();
        sb8.append("  mRootId=");
        sb8.append(this.mRootId);
        Log.d("MediaBrowserCompat", sb8.toString());
        final StringBuilder sb9 = new StringBuilder();
        sb9.append("  mMediaSessionToken=");
        sb9.append(this.mMediaSessionToken);
        Log.d("MediaBrowserCompat", sb9.toString());
    }
    
    void forceCloseConnection() {
        final MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection mServiceConnection = this.mServiceConnection;
        if (mServiceConnection != null) {
            this.mContext.unbindService((ServiceConnection)mServiceConnection);
        }
        this.mState = 1;
        this.mServiceConnection = null;
        this.mServiceBinderWrapper = null;
        this.mCallbacksMessenger = null;
        this.mHandler.setCallbacksMessenger(null);
        this.mRootId = null;
        this.mMediaSessionToken = null;
    }
    
    public Bundle getExtras() {
        if (this.isConnected()) {
            return this.mExtras;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("getExtras() called while not connected (state=");
        sb.append(getStateLabel(this.mState));
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }
    
    public void getItem(final String s, final MediaBrowserCompat$ItemCallback mediaBrowserCompat$ItemCallback) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("mediaId is empty");
        }
        if (mediaBrowserCompat$ItemCallback == null) {
            throw new IllegalArgumentException("cb is null");
        }
        if (!this.isConnected()) {
            Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
            this.mHandler.post((Runnable)new MediaBrowserCompat$MediaBrowserImplBase$3(this, mediaBrowserCompat$ItemCallback, s));
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
                this.mHandler.post((Runnable)new MediaBrowserCompat$MediaBrowserImplBase$4(this, mediaBrowserCompat$ItemCallback, s));
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public String getRoot() {
        if (this.isConnected()) {
            return this.mRootId;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("getRoot() called while not connected(state=");
        sb.append(getStateLabel(this.mState));
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }
    
    public ComponentName getServiceComponent() {
        if (this.isConnected()) {
            return this.mServiceComponent;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("getServiceComponent() called while not connected (state=");
        sb.append(this.mState);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }
    
    public MediaSessionCompat$Token getSessionToken() {
        if (this.isConnected()) {
            return this.mMediaSessionToken;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("getSessionToken() called while not connected(state=");
        sb.append(this.mState);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }
    
    public boolean isConnected() {
        return this.mState == 3;
    }
    
    public void onConnectionFailed(final Messenger messenger) {
        final StringBuilder sb = new StringBuilder();
        sb.append("onConnectFailed for ");
        sb.append(this.mServiceComponent);
        Log.e("MediaBrowserCompat", sb.toString());
        if (!this.isCurrent(messenger, "onConnectFailed")) {
            return;
        }
        if (this.mState != 2) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("onConnect from service while mState=");
            sb2.append(getStateLabel(this.mState));
            sb2.append("... ignoring");
            Log.w("MediaBrowserCompat", sb2.toString());
            return;
        }
        this.forceCloseConnection();
        this.mCallback.onConnectionFailed();
    }
    
    public void onLoadChildren(final Messenger messenger, final String s, final List list, final Bundle bundle) {
        if (!this.isCurrent(messenger, "onLoadChildren")) {
            return;
        }
        if (MediaBrowserCompat.DEBUG) {
            final String s2 = "MediaBrowserCompat";
            final StringBuilder sb = new StringBuilder();
            sb.append("onLoadChildren for ");
            sb.append(this.mServiceComponent);
            sb.append(" id=");
            sb.append(s);
            Log.d(s2, sb.toString());
        }
        final MediaBrowserCompat$Subscription mediaBrowserCompat$Subscription = (MediaBrowserCompat$Subscription)this.mSubscriptions.get(s);
        if (mediaBrowserCompat$Subscription == null) {
            if (MediaBrowserCompat.DEBUG) {
                final String s3 = "MediaBrowserCompat";
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("onLoadChildren for id that isn't subscribed id=");
                sb2.append(s);
                Log.d(s3, sb2.toString());
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
    
    public void onServiceConnected(final Messenger messenger, final String mRootId, final MediaSessionCompat$Token mMediaSessionToken, final Bundle mExtras) {
        if (!this.isCurrent(messenger, "onConnect")) {
            return;
        }
        if (this.mState != 2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("onConnect from service while mState=");
            sb.append(getStateLabel(this.mState));
            sb.append("... ignoring");
            Log.w("MediaBrowserCompat", sb.toString());
            return;
        }
        this.mRootId = mRootId;
        this.mMediaSessionToken = mMediaSessionToken;
        this.mExtras = mExtras;
        this.mState = 3;
        if (MediaBrowserCompat.DEBUG) {
            Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
            this.dump();
        }
        this.mCallback.onConnected();
        try {
            final ArrayMap mSubscriptions = this.mSubscriptions;
            try {
                final Set entrySet = mSubscriptions.entrySet();
                try {
                    final Iterator<Map.Entry<Object, V>> iterator = entrySet.iterator();
                    try {
                    Label_0185:
                        while (true) {
                            Label_0360: {
                                if (!iterator.hasNext()) {
                                    break Label_0360;
                                }
                                final Map.Entry<Object, V> next = iterator.next();
                                try {
                                    final Map.Entry<Object, V> entry = next;
                                    try {
                                        final String key = entry.getKey();
                                        try {
                                            final String s = key;
                                            try {
                                                final V value = entry.getValue();
                                                try {
                                                    final MediaBrowserCompat$Subscription mediaBrowserCompat$Subscription = (MediaBrowserCompat$Subscription)value;
                                                    try {
                                                        final List callbacks = mediaBrowserCompat$Subscription.getCallbacks();
                                                        try {
                                                            final List optionsList = mediaBrowserCompat$Subscription.getOptionsList();
                                                            int n = 0;
                                                            while (true) {
                                                                Label_0357: {
                                                                    if (n >= callbacks.size()) {
                                                                        break Label_0357;
                                                                    }
                                                                    final MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper = this.mServiceBinderWrapper;
                                                                    final MediaBrowserCompat$SubscriptionCallback value2 = callbacks.get(n);
                                                                    try {
                                                                        final MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback = value2;
                                                                        try {
                                                                            final IBinder access$000 = mediaBrowserCompat$SubscriptionCallback.mToken;
                                                                            final Bundle value3 = optionsList.get(n);
                                                                            try {
                                                                                final Bundle bundle = value3;
                                                                                try {
                                                                                    mServiceBinderWrapper.addSubscription(s, access$000, bundle, this.mCallbacksMessenger);
                                                                                    ++n;
                                                                                    continue;
                                                                                    continue Label_0185;
                                                                                }
                                                                                catch (RemoteException ex) {
                                                                                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
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
                                                catch (RemoteException ex7) {}
                                            }
                                            catch (RemoteException ex8) {}
                                        }
                                        catch (RemoteException ex9) {}
                                    }
                                    catch (RemoteException ex10) {}
                                }
                                catch (RemoteException ex11) {}
                            }
                        }
                    }
                    catch (RemoteException ex12) {}
                }
                catch (RemoteException ex13) {}
            }
            catch (RemoteException ex14) {}
        }
        catch (RemoteException ex15) {}
    }
    
    public void search(final String s, final Bundle bundle, final MediaBrowserCompat$SearchCallback mediaBrowserCompat$SearchCallback) {
        if (this.isConnected()) {
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
                    this.mHandler.post((Runnable)new MediaBrowserCompat$MediaBrowserImplBase$5(this, mediaBrowserCompat$SearchCallback, s, bundle));
                }
            }
            catch (RemoteException ex2) {}
            return;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("search() called while not connected (state=");
        sb2.append(getStateLabel(this.mState));
        sb2.append(")");
        throw new IllegalStateException(sb2.toString());
    }
    
    public void sendCustomAction(final String s, final Bundle bundle, final MediaBrowserCompat$CustomActionCallback mediaBrowserCompat$CustomActionCallback) {
        if (this.isConnected()) {
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
                    this.mHandler.post((Runnable)new MediaBrowserCompat$MediaBrowserImplBase$6(this, mediaBrowserCompat$CustomActionCallback, s, bundle));
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
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = null;
        }
        else {
            bundle2 = new Bundle(bundle);
        }
        mediaBrowserCompat$Subscription.putCallback(bundle2, mediaBrowserCompat$SubscriptionCallback);
        if (this.isConnected()) {
            try {
                final MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper = this.mServiceBinderWrapper;
                try {
                    final IBinder access$000 = mediaBrowserCompat$SubscriptionCallback.mToken;
                    try {
                        mServiceBinderWrapper.addSubscription(s, access$000, bundle2, this.mCallbacksMessenger);
                    }
                    catch (RemoteException ex) {
                        final String s2 = "MediaBrowserCompat";
                        final StringBuilder sb = new StringBuilder();
                        sb.append("addSubscription failed with RemoteException parentId=");
                        sb.append(s);
                        Log.d(s2, sb.toString());
                    }
                }
                catch (RemoteException ex2) {}
            }
            catch (RemoteException ex3) {}
        }
    }
    
    public void unsubscribe(final String s, final MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback) {
        final MediaBrowserCompat$Subscription mediaBrowserCompat$Subscription = (MediaBrowserCompat$Subscription)this.mSubscriptions.get(s);
        if (mediaBrowserCompat$Subscription == null) {
            return;
        }
        while (true) {
            if (mediaBrowserCompat$SubscriptionCallback == null) {
                try {
                    Label_0181: {
                        if (this.isConnected()) {
                            this.mServiceBinderWrapper.removeSubscription(s, null, this.mCallbacksMessenger);
                            break Label_0181;
                        }
                        break Label_0181;
                        final List callbacks = mediaBrowserCompat$Subscription.getCallbacks();
                        try {
                            final List optionsList = mediaBrowserCompat$Subscription.getOptionsList();
                            try {
                                int n = callbacks.size() - 1;
                                while (true) {
                                    if (n < 0) {
                                        break Label_0181;
                                    }
                                    Label_0172: {
                                        if (callbacks.get(n) != mediaBrowserCompat$SubscriptionCallback) {
                                            break Label_0172;
                                        }
                                        Label_0149: {
                                            if (!this.isConnected()) {
                                                break Label_0149;
                                            }
                                            final MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper = this.mServiceBinderWrapper;
                                            try {
                                                final IBinder access$000 = mediaBrowserCompat$SubscriptionCallback.mToken;
                                                try {
                                                    mServiceBinderWrapper.removeSubscription(s, access$000, this.mCallbacksMessenger);
                                                    callbacks.remove(n);
                                                    final List list = optionsList;
                                                    try {
                                                        list.remove(n);
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
                                    }
                                }
                            }
                            catch (RemoteException ex4) {}
                        }
                        catch (RemoteException ex5) {}
                    }
                }
                catch (RemoteException ex6) {}
                if (mediaBrowserCompat$Subscription.isEmpty() || mediaBrowserCompat$SubscriptionCallback == null) {
                    this.mSubscriptions.remove(s);
                }
                return;
            }
            continue;
        }
    }
}
