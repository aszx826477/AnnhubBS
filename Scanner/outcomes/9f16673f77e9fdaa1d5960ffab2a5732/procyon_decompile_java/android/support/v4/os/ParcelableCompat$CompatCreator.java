// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable$Creator;

class ParcelableCompat$CompatCreator implements Parcelable$Creator
{
    final ParcelableCompatCreatorCallbacks mCallbacks;
    
    public ParcelableCompat$CompatCreator(final ParcelableCompatCreatorCallbacks mCallbacks) {
        this.mCallbacks = mCallbacks;
    }
    
    public Object createFromParcel(final Parcel parcel) {
        return this.mCallbacks.createFromParcel(parcel, null);
    }
    
    public Object[] newArray(final int n) {
        return this.mCallbacks.newArray(n);
    }
}
