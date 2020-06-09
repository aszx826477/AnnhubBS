// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.text.TextUtils;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

public final class MediaBrowserCompat
{
    static final boolean DEBUG = false;
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    static final String TAG = "MediaBrowserCompat";
    private final MediaBrowserCompat$MediaBrowserImpl mImpl;
    
    public MediaBrowserCompat(final Context context, final ComponentName componentName, final MediaBrowserCompat$ConnectionCallback mediaBrowserCompat$ConnectionCallback, final Bundle bundle) {
        if (Build$VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaBrowserCompat$MediaBrowserImplApi23(context, componentName, mediaBrowserCompat$ConnectionCallback, bundle);
        }
        else if (Build$VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaBrowserCompat$MediaBrowserImplApi21(context, componentName, mediaBrowserCompat$ConnectionCallback, bundle);
        }
        else {
            this.mImpl = new MediaBrowserCompat$MediaBrowserImplBase(context, componentName, mediaBrowserCompat$ConnectionCallback, bundle);
        }
    }
    
    public void connect() {
        this.mImpl.connect();
    }
    
    public void disconnect() {
        this.mImpl.disconnect();
    }
    
    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }
    
    public void getItem(final String s, final MediaBrowserCompat$ItemCallback mediaBrowserCompat$ItemCallback) {
        this.mImpl.getItem(s, mediaBrowserCompat$ItemCallback);
    }
    
    public String getRoot() {
        return this.mImpl.getRoot();
    }
    
    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }
    
    public MediaSessionCompat$Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }
    
    public boolean isConnected() {
        return this.mImpl.isConnected();
    }
    
    public void search(final String s, final Bundle bundle, final MediaBrowserCompat$SearchCallback mediaBrowserCompat$SearchCallback) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("query cannot be empty");
        }
        if (mediaBrowserCompat$SearchCallback != null) {
            this.mImpl.search(s, bundle, mediaBrowserCompat$SearchCallback);
            return;
        }
        throw new IllegalArgumentException("callback cannot be null");
    }
    
    public void sendCustomAction(final String s, final Bundle bundle, final MediaBrowserCompat$CustomActionCallback mediaBrowserCompat$CustomActionCallback) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            this.mImpl.sendCustomAction(s, bundle, mediaBrowserCompat$CustomActionCallback);
            return;
        }
        throw new IllegalArgumentException("action cannot be empty");
    }
    
    public void subscribe(final String s, final Bundle bundle, final MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (mediaBrowserCompat$SubscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        if (bundle != null) {
            this.mImpl.subscribe(s, bundle, mediaBrowserCompat$SubscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("options are null");
    }
    
    public void subscribe(final String s, final MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (mediaBrowserCompat$SubscriptionCallback != null) {
            this.mImpl.subscribe(s, null, mediaBrowserCompat$SubscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("callback is null");
    }
    
    public void unsubscribe(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            this.mImpl.unsubscribe(s, null);
            return;
        }
        throw new IllegalArgumentException("parentId is empty");
    }
    
    public void unsubscribe(final String s, final MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (mediaBrowserCompat$SubscriptionCallback != null) {
            this.mImpl.unsubscribe(s, mediaBrowserCompat$SubscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("callback is null");
    }
}
