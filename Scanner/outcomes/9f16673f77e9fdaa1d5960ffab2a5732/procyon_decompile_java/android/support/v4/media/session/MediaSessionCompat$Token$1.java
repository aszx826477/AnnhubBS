// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$Creator;

final class MediaSessionCompat$Token$1 implements Parcelable$Creator
{
    public MediaSessionCompat$Token createFromParcel(final Parcel parcel) {
        Object o;
        if (Build$VERSION.SDK_INT >= 21) {
            o = parcel.readParcelable((ClassLoader)null);
        }
        else {
            o = parcel.readStrongBinder();
        }
        return new MediaSessionCompat$Token(o);
    }
    
    public MediaSessionCompat$Token[] newArray(final int n) {
        return new MediaSessionCompat$Token[n];
    }
}
