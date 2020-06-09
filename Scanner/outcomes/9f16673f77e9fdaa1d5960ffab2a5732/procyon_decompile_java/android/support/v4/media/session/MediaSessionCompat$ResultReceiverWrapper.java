// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.Parcel;
import android.os.ResultReceiver;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

final class MediaSessionCompat$ResultReceiverWrapper implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    private ResultReceiver mResultReceiver;
    
    static {
        CREATOR = (Parcelable$Creator)new MediaSessionCompat$ResultReceiverWrapper$1();
    }
    
    MediaSessionCompat$ResultReceiverWrapper(final Parcel parcel) {
        this.mResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(parcel);
    }
    
    public MediaSessionCompat$ResultReceiverWrapper(final ResultReceiver mResultReceiver) {
        this.mResultReceiver = mResultReceiver;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        this.mResultReceiver.writeToParcel(parcel, n);
    }
}
