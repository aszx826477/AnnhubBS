// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable$Creator;

final class MediaBrowserCompat$MediaItem$1 implements Parcelable$Creator
{
    public MediaBrowserCompat$MediaItem createFromParcel(final Parcel parcel) {
        return new MediaBrowserCompat$MediaItem(parcel);
    }
    
    public MediaBrowserCompat$MediaItem[] newArray(final int n) {
        return new MediaBrowserCompat$MediaItem[n];
    }
}
