// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable$Creator;

final class PlaybackStateCompat$1 implements Parcelable$Creator
{
    public PlaybackStateCompat createFromParcel(final Parcel parcel) {
        return new PlaybackStateCompat(parcel);
    }
    
    public PlaybackStateCompat[] newArray(final int n) {
        return new PlaybackStateCompat[n];
    }
}
