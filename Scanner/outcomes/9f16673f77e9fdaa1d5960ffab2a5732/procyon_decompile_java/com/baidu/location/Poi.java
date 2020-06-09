// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class Poi implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    private final String mId;
    private final String mName;
    private final double mRank;
    
    static {
        CREATOR = (Parcelable$Creator)new d();
    }
    
    public Poi(final String mId, final String mName, final double mRank) {
        this.mId = mId;
        this.mName = mName;
        this.mRank = mRank;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public String getId() {
        return this.mId;
    }
    
    public String getName() {
        return this.mName;
    }
    
    public double getRank() {
        return this.mRank;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeDouble(this.mRank);
    }
}
