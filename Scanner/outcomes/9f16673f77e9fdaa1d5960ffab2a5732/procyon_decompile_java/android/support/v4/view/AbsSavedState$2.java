// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

final class AbsSavedState$2 implements ParcelableCompatCreatorCallbacks
{
    public AbsSavedState createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
        if (parcel.readParcelable(classLoader) == null) {
            return AbsSavedState.EMPTY_STATE;
        }
        throw new IllegalStateException("superState must be null");
    }
    
    public AbsSavedState[] newArray(final int n) {
        return new AbsSavedState[n];
    }
}
