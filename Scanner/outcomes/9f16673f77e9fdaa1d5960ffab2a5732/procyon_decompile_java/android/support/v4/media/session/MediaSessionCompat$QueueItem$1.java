// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable$Creator;

final class MediaSessionCompat$QueueItem$1 implements Parcelable$Creator
{
    public MediaSessionCompat$QueueItem createFromParcel(final Parcel parcel) {
        return new MediaSessionCompat$QueueItem(parcel);
    }
    
    public MediaSessionCompat$QueueItem[] newArray(final int n) {
        return new MediaSessionCompat$QueueItem[n];
    }
}
