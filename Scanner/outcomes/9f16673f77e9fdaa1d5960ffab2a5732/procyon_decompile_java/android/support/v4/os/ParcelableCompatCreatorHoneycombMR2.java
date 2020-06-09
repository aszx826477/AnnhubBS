// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;

class ParcelableCompatCreatorHoneycombMR2 implements Parcelable$ClassLoaderCreator
{
    private final ParcelableCompatCreatorCallbacks mCallbacks;
    
    public ParcelableCompatCreatorHoneycombMR2(final ParcelableCompatCreatorCallbacks mCallbacks) {
        this.mCallbacks = mCallbacks;
    }
    
    public Object createFromParcel(final Parcel parcel) {
        return this.mCallbacks.createFromParcel(parcel, null);
    }
    
    public Object createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
        return this.mCallbacks.createFromParcel(parcel, classLoader);
    }
    
    public Object[] newArray(final int n) {
        return this.mCallbacks.newArray(n);
    }
}
