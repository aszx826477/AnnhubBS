// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import java.util.Iterator;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

class MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2 extends MediaBrowserServiceCompat$Result
{
    final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 this$1;
    final /* synthetic */ MediaBrowserServiceCompatApi21$ResultWrapper val$resultWrapper;
    
    MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2(final MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 this$1, final Object o, final MediaBrowserServiceCompatApi21$ResultWrapper val$resultWrapper) {
        this.this$1 = this$1;
        this.val$resultWrapper = val$resultWrapper;
        super(o);
    }
    
    public void detach() {
        this.val$resultWrapper.detach();
    }
    
    void onResultSent(final List list) {
        List<Parcel> list2 = null;
        if (list != null) {
            list2 = new ArrayList<Parcel>();
            for (final MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem : list) {
                final Parcel obtain = Parcel.obtain();
                mediaBrowserCompat$MediaItem.writeToParcel(obtain, 0);
                list2.add(obtain);
            }
        }
        this.val$resultWrapper.sendResult(list2);
    }
}
