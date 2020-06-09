// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import java.util.Collections;
import android.os.Bundle;
import java.util.List;

class MediaBrowserCompat$SubscriptionCallback$StubApi21 implements MediaBrowserCompatApi21$SubscriptionCallback
{
    final /* synthetic */ MediaBrowserCompat$SubscriptionCallback this$0;
    
    MediaBrowserCompat$SubscriptionCallback$StubApi21(final MediaBrowserCompat$SubscriptionCallback this$0) {
        this.this$0 = this$0;
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
    
    public void onChildrenLoaded(final String s, final List list) {
        MediaBrowserCompat$Subscription mediaBrowserCompat$Subscription;
        if (this.this$0.mSubscriptionRef == null) {
            mediaBrowserCompat$Subscription = null;
        }
        else {
            mediaBrowserCompat$Subscription = (MediaBrowserCompat$Subscription)this.this$0.mSubscriptionRef.get();
        }
        if (mediaBrowserCompat$Subscription == null) {
            this.this$0.onChildrenLoaded(s, MediaBrowserCompat$MediaItem.fromMediaItemList(list));
        }
        else {
            final List fromMediaItemList = MediaBrowserCompat$MediaItem.fromMediaItemList(list);
            final List callbacks = mediaBrowserCompat$Subscription.getCallbacks();
            final List optionsList = mediaBrowserCompat$Subscription.getOptionsList();
            for (int i = 0; i < callbacks.size(); ++i) {
                final Bundle bundle = optionsList.get(i);
                if (bundle == null) {
                    this.this$0.onChildrenLoaded(s, fromMediaItemList);
                }
                else {
                    this.this$0.onChildrenLoaded(s, this.applyOptions(fromMediaItemList, bundle), bundle);
                }
            }
        }
    }
    
    public void onError(final String s) {
        this.this$0.onError(s);
    }
}
