// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.service.media.MediaBrowserService;
import android.os.Bundle;
import android.content.Context;
import java.lang.reflect.Field;
import android.util.Log;
import java.util.Iterator;
import android.media.browse.MediaBrowser$MediaItem;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;
import android.service.media.MediaBrowserService$Result;

class MediaBrowserServiceCompatApi24$ResultWrapper
{
    MediaBrowserService$Result mResultObj;
    
    MediaBrowserServiceCompatApi24$ResultWrapper(final MediaBrowserService$Result mResultObj) {
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
    
    public void sendResult(final List list, final int n) {
        try {
            final Field access$000 = MediaBrowserServiceCompatApi24.sResultFlags;
            try {
                access$000.setInt(this.mResultObj, n);
            }
            catch (IllegalAccessException ex) {
                Log.w("MBSCompatApi24", (Throwable)ex);
            }
        }
        catch (IllegalAccessException ex2) {}
        this.mResultObj.sendResult((Object)this.parcelListToItemList(list));
    }
}
