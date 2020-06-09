// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable$Creator;

final class MediaSessionCompat$ResultReceiverWrapper$1 implements Parcelable$Creator
{
    public MediaSessionCompat$ResultReceiverWrapper createFromParcel(final Parcel parcel) {
        return new MediaSessionCompat$ResultReceiverWrapper(parcel);
    }
    
    public MediaSessionCompat$ResultReceiverWrapper[] newArray(final int n) {
        return new MediaSessionCompat$ResultReceiverWrapper[n];
    }
}
