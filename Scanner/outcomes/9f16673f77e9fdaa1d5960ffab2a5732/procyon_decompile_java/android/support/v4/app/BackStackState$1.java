// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable$Creator;

final class BackStackState$1 implements Parcelable$Creator
{
    public BackStackState createFromParcel(final Parcel parcel) {
        return new BackStackState(parcel);
    }
    
    public BackStackState[] newArray(final int n) {
        return new BackStackState[n];
    }
}
