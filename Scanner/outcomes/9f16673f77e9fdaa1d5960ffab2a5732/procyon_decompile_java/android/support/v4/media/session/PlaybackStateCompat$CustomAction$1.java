// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable$Creator;

final class PlaybackStateCompat$CustomAction$1 implements Parcelable$Creator
{
    public PlaybackStateCompat$CustomAction createFromParcel(final Parcel parcel) {
        return new PlaybackStateCompat$CustomAction(parcel);
    }
    
    public PlaybackStateCompat$CustomAction[] newArray(final int n) {
        return new PlaybackStateCompat$CustomAction[n];
    }
}
