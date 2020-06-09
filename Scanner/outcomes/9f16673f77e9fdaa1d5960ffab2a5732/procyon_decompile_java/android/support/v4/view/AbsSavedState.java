// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.os.ParcelableCompat;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public abstract class AbsSavedState implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    public static final AbsSavedState EMPTY_STATE;
    private final Parcelable mSuperState;
    
    static {
        EMPTY_STATE = new AbsSavedState$1();
        CREATOR = ParcelableCompat.newCreator(new AbsSavedState$2());
    }
    
    private AbsSavedState() {
        this.mSuperState = null;
    }
    
    protected AbsSavedState(final Parcel parcel) {
        this(parcel, null);
    }
    
    protected AbsSavedState(final Parcel parcel, final ClassLoader classLoader) {
        final Parcelable parcelable = parcel.readParcelable(classLoader);
        Object empty_STATE;
        if (parcelable != null) {
            empty_STATE = parcelable;
        }
        else {
            empty_STATE = AbsSavedState.EMPTY_STATE;
        }
        this.mSuperState = (Parcelable)empty_STATE;
    }
    
    protected AbsSavedState(final Parcelable parcelable) {
        if (parcelable != null) {
            Parcelable mSuperState;
            if (parcelable != AbsSavedState.EMPTY_STATE) {
                mSuperState = parcelable;
            }
            else {
                mSuperState = null;
            }
            this.mSuperState = mSuperState;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }
    
    public int describeContents() {
        return 0;
    }
    
    public final Parcelable getSuperState() {
        return this.mSuperState;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeParcelable(this.mSuperState, n);
    }
}
