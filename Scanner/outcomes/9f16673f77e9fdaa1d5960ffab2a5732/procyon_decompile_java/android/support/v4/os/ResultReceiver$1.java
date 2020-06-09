// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable$Creator;

final class ResultReceiver$1 implements Parcelable$Creator
{
    public ResultReceiver createFromParcel(final Parcel parcel) {
        return new ResultReceiver(parcel);
    }
    
    public ResultReceiver[] newArray(final int n) {
        return new ResultReceiver[n];
    }
}
