// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable$Creator;

final class a implements Parcelable$Creator
{
    public BDLocation createFromParcel(final Parcel parcel) {
        return new BDLocation(parcel, null);
    }
    
    public BDLocation[] newArray(final int n) {
        return new BDLocation[n];
    }
}
