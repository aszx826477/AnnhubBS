// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.support.v4.os.ResultReceiver;
import android.os.Build$VERSION;
import android.content.Intent;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import java.util.Collections;
import java.util.Iterator;
import android.support.v4.util.Pair;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.util.ArrayMap;
import android.app.Service;

public abstract class MediaBrowserServiceCompat extends Service
{
    static final boolean DEBUG = false;
    public static final String KEY_MEDIA_ITEM = "media_item";
    public static final String KEY_SEARCH_RESULTS = "search_results";
    static final int RESULT_ERROR = 255;
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    static final int RESULT_OK = 0;
    static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    static final String TAG = "MBServiceCompat";
    final ArrayMap mConnections;
    MediaBrowserServiceCompat$ConnectionRecord mCurConnection;
    final MediaBrowserServiceCompat$ServiceHandler mHandler;
    private MediaBrowserServiceCompat$MediaBrowserServiceImpl mImpl;
    MediaSessionCompat$Token mSession;
    
    public MediaBrowserServiceCompat() {
        this.mConnections = new ArrayMap();
        this.mHandler = new MediaBrowserServiceCompat$ServiceHandler(this);
    }
    
    void addSubscription(final String s, final MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord, final IBinder binder, final Bundle bundle) {
        List<?> list = mediaBrowserServiceCompat$ConnectionRecord.subscriptions.get(s);
        if (list == null) {
            list = new ArrayList<Object>();
        }
        for (final Pair pair : list) {
            if (binder == pair.first && MediaBrowserCompatUtils.areSameOptions(bundle, (Bundle)pair.second)) {
                return;
            }
        }
        list.add(new Pair(binder, bundle));
        mediaBrowserServiceCompat$ConnectionRecord.subscriptions.put(s, list);
        this.performLoadChildren(s, mediaBrowserServiceCompat$ConnectionRecord, bundle);
    }
    
    List applyOptions(final List list, final Bundle bundle) {
        if (list == null) {
            return null;
        }
        final String s = "android.media.browse.extra.PAGE";
        final int n = -1;
        final int int1 = bundle.getInt(s, n);
        final int int2 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", n);
        if (int1 == n && int2 == n) {
            return list;
        }
        final int n2 = int2 * int1;
        int size = n2 + int2;
        if (int1 >= 0 && int2 >= 1 && n2 < list.size()) {
            if (size > list.size()) {
                size = list.size();
            }
            return list.subList(n2, size);
        }
        return Collections.EMPTY_LIST;
    }
    
    public void dump(final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
    }
    
    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }
    
    public MediaSessionCompat$Token getSessionToken() {
        return this.mSession;
    }
    
    boolean isValidPackage(final String s, final int n) {
        if (s == null) {
            return false;
        }
        final String[] packagesForUid = this.getPackageManager().getPackagesForUid(n);
        for (int length = packagesForUid.length, i = 0; i < length; ++i) {
            if (packagesForUid[i].equals(s)) {
                return true;
            }
        }
        return false;
    }
    
    public void notifyChildrenChanged(final String s) {
        if (s != null) {
            this.mImpl.notifyChildrenChanged(s, null);
            return;
        }
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }
    
    public void notifyChildrenChanged(final String s, final Bundle bundle) {
        if (s == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle != null) {
            this.mImpl.notifyChildrenChanged(s, bundle);
            return;
        }
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    }
    
    public IBinder onBind(final Intent intent) {
        return this.mImpl.onBind(intent);
    }
    
    public void onCreate() {
        super.onCreate();
        if (Build$VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi23(this);
        }
        else if (Build$VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi21(this);
        }
        else {
            this.mImpl = new MediaBrowserServiceCompat$MediaBrowserServiceImplBase(this);
        }
        this.mImpl.onCreate();
    }
    
    public void onCustomAction(final String s, final Bundle bundle, final MediaBrowserServiceCompat$Result mediaBrowserServiceCompat$Result) {
        mediaBrowserServiceCompat$Result.sendError(null);
    }
    
    public abstract MediaBrowserServiceCompat$BrowserRoot onGetRoot(final String p0, final int p1, final Bundle p2);
    
    public abstract void onLoadChildren(final String p0, final MediaBrowserServiceCompat$Result p1);
    
    public void onLoadChildren(final String s, final MediaBrowserServiceCompat$Result mediaBrowserServiceCompat$Result, final Bundle bundle) {
        mediaBrowserServiceCompat$Result.setFlags(1);
        this.onLoadChildren(s, mediaBrowserServiceCompat$Result);
    }
    
    public void onLoadItem(final String s, final MediaBrowserServiceCompat$Result mediaBrowserServiceCompat$Result) {
        mediaBrowserServiceCompat$Result.setFlags(2);
        mediaBrowserServiceCompat$Result.sendResult(null);
    }
    
    public void onSearch(final String s, final Bundle bundle, final MediaBrowserServiceCompat$Result mediaBrowserServiceCompat$Result) {
        mediaBrowserServiceCompat$Result.setFlags(4);
        mediaBrowserServiceCompat$Result.sendResult(null);
    }
    
    void performCustomAction(final String s, final Bundle bundle, final MediaBrowserServiceCompat$ConnectionRecord mCurConnection, final ResultReceiver resultReceiver) {
        final MediaBrowserServiceCompat$4 mediaBrowserServiceCompat$4 = new MediaBrowserServiceCompat$4(this, s, resultReceiver);
        this.mCurConnection = mCurConnection;
        this.onCustomAction(s, bundle, mediaBrowserServiceCompat$4);
        this.mCurConnection = null;
        if (mediaBrowserServiceCompat$4.isDone()) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("onCustomAction must call detach() or sendResult() or sendError() before returning for action=");
        sb.append(s);
        sb.append(" extras=");
        sb.append(bundle);
        throw new IllegalStateException(sb.toString());
    }
    
    void performLoadChildren(final String s, final MediaBrowserServiceCompat$ConnectionRecord mCurConnection, final Bundle bundle) {
        final MediaBrowserServiceCompat$1 mediaBrowserServiceCompat$2;
        final MediaBrowserServiceCompat$1 mediaBrowserServiceCompat$1 = mediaBrowserServiceCompat$2 = new MediaBrowserServiceCompat$1(this, s, mCurConnection, s, bundle);
        this.mCurConnection = mCurConnection;
        if (bundle == null) {
            this.onLoadChildren(s, mediaBrowserServiceCompat$1);
        }
        else {
            this.onLoadChildren(s, mediaBrowserServiceCompat$1, bundle);
        }
        this.mCurConnection = null;
        if (mediaBrowserServiceCompat$2.isDone()) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("onLoadChildren must call detach() or sendResult() before returning for package=");
        sb.append(mCurConnection.pkg);
        sb.append(" id=");
        sb.append(s);
        throw new IllegalStateException(sb.toString());
    }
    
    void performLoadItem(final String s, final MediaBrowserServiceCompat$ConnectionRecord mCurConnection, final ResultReceiver resultReceiver) {
        final MediaBrowserServiceCompat$2 mediaBrowserServiceCompat$2 = new MediaBrowserServiceCompat$2(this, s, resultReceiver);
        this.mCurConnection = mCurConnection;
        this.onLoadItem(s, mediaBrowserServiceCompat$2);
        this.mCurConnection = null;
        if (mediaBrowserServiceCompat$2.isDone()) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("onLoadItem must call detach() or sendResult() before returning for id=");
        sb.append(s);
        throw new IllegalStateException(sb.toString());
    }
    
    void performSearch(final String s, final Bundle bundle, final MediaBrowserServiceCompat$ConnectionRecord mCurConnection, final ResultReceiver resultReceiver) {
        final MediaBrowserServiceCompat$3 mediaBrowserServiceCompat$3 = new MediaBrowserServiceCompat$3(this, s, resultReceiver);
        this.mCurConnection = mCurConnection;
        this.onSearch(s, bundle, mediaBrowserServiceCompat$3);
        this.mCurConnection = null;
        if (mediaBrowserServiceCompat$3.isDone()) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("onSearch must call detach() or sendResult() before returning for query=");
        sb.append(s);
        throw new IllegalStateException(sb.toString());
    }
    
    boolean removeSubscription(final String s, final MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord, final IBinder binder) {
        if (binder == null) {
            return mediaBrowserServiceCompat$ConnectionRecord.subscriptions.remove(s) != null;
        }
        boolean b = false;
        final List<Pair> list = mediaBrowserServiceCompat$ConnectionRecord.subscriptions.get(s);
        if (list != null) {
            final Iterator<Pair> iterator = list.iterator();
            while (iterator.hasNext()) {
                if (binder == iterator.next().first) {
                    b = true;
                    iterator.remove();
                }
            }
            if (list.size() == 0) {
                mediaBrowserServiceCompat$ConnectionRecord.subscriptions.remove(s);
            }
        }
        return b;
    }
    
    public void setSessionToken(final MediaSessionCompat$Token mediaSessionCompat$Token) {
        if (mediaSessionCompat$Token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        }
        if (this.mSession == null) {
            this.mSession = mediaSessionCompat$Token;
            this.mImpl.setSessionToken(mediaSessionCompat$Token);
            return;
        }
        throw new IllegalStateException("The session token has already been set.");
    }
}
