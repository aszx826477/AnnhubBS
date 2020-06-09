// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable$Creator;

final class d implements Parcelable$Creator
{
    public Poi createFromParcel(final Parcel parcel) {
        return new Poi(parcel.readString(), parcel.readString(), parcel.readDouble());
    }
    
    public Poi[] newArray(final int n) {
        return new Poi[n];
    }
}
