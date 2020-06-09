// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable$Creator;

final class MediaMetadataCompat$1 implements Parcelable$Creator
{
    public MediaMetadataCompat createFromParcel(final Parcel parcel) {
        return new MediaMetadataCompat(parcel);
    }
    
    public MediaMetadataCompat[] newArray(final int n) {
        return new MediaMetadataCompat[n];
    }
}
