// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Build$VERSION;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class MediaSessionCompat$Token implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    private final IMediaSession mExtraBinder;
    private final Object mInner;
    
    static {
        CREATOR = (Parcelable$Creator)new MediaSessionCompat$Token$1();
    }
    
    MediaSessionCompat$Token(final Object o) {
        this(o, null);
    }
    
    MediaSessionCompat$Token(final Object mInner, final IMediaSession mExtraBinder) {
        this.mInner = mInner;
        this.mExtraBinder = mExtraBinder;
    }
    
    public static MediaSessionCompat$Token fromToken(final Object o) {
        return fromToken(o, null);
    }
    
    public static MediaSessionCompat$Token fromToken(final Object o, final IMediaSession mediaSession) {
        if (o != null && Build$VERSION.SDK_INT >= 21) {
            return new MediaSessionCompat$Token(MediaSessionCompatApi21.verifyToken(o), mediaSession);
        }
        return null;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return b;
        }
        if (!(o instanceof MediaSessionCompat$Token)) {
            return false;
        }
        final MediaSessionCompat$Token mediaSessionCompat$Token = (MediaSessionCompat$Token)o;
        final Object mInner = this.mInner;
        if (mInner == null) {
            if (mediaSessionCompat$Token.mInner != null) {
                b = false;
            }
            return b;
        }
        final Object mInner2 = mediaSessionCompat$Token.mInner;
        return mInner2 != null && mInner.equals(mInner2);
    }
    
    public IMediaSession getExtraBinder() {
        return this.mExtraBinder;
    }
    
    public Object getToken() {
        return this.mInner;
    }
    
    public int hashCode() {
        final Object mInner = this.mInner;
        if (mInner == null) {
            return 0;
        }
        return mInner.hashCode();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (Build$VERSION.SDK_INT >= 21) {
            parcel.writeParcelable((Parcelable)this.mInner, n);
        }
        else {
            parcel.writeStrongBinder((IBinder)this.mInner);
        }
    }
}
