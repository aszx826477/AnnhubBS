// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import java.util.Iterator;
import android.media.browse.MediaBrowser$MediaItem;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;
import android.service.media.MediaBrowserService$Result;

class MediaBrowserServiceCompatApi21$ResultWrapper
{
    MediaBrowserService$Result mResultObj;
    
    MediaBrowserServiceCompatApi21$ResultWrapper(final MediaBrowserService$Result mResultObj) {
        this.mResultObj = mResultObj;
    }
    
    public void detach() {
        this.mResultObj.detach();
    }
    
    List parcelListToItemList(final List list) {
        if (list == null) {
            return null;
        }
        final ArrayList<Object> list2 = new ArrayList<Object>();
        for (final Parcel parcel : list) {
            parcel.setDataPosition(0);
            list2.add(MediaBrowser$MediaItem.CREATOR.createFromParcel(parcel));
            parcel.recycle();
        }
        return list2;
    }
    
    public void sendResult(final Object o) {
        if (o instanceof List) {
            this.mResultObj.sendResult((Object)this.parcelListToItemList((List)o));
        }
        else if (o instanceof Parcel) {
            final Parcel parcel = (Parcel)o;
            parcel.setDataPosition(0);
            this.mResultObj.sendResult(MediaBrowser$MediaItem.CREATOR.createFromParcel(parcel));
            parcel.recycle();
        }
        else {
            this.mResultObj.sendResult((Object)null);
        }
    }
}
