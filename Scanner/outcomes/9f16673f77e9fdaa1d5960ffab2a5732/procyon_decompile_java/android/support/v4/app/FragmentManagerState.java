// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

final class FragmentManagerState implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    FragmentState[] mActive;
    int[] mAdded;
    BackStackState[] mBackStack;
    int mNextFragmentIndex;
    
    static {
        CREATOR = (Parcelable$Creator)new FragmentManagerState$1();
    }
    
    public FragmentManagerState() {
    }
    
    public FragmentManagerState(final Parcel parcel) {
        this.mActive = (FragmentState[])parcel.createTypedArray(FragmentState.CREATOR);
        this.mAdded = parcel.createIntArray();
        this.mBackStack = (BackStackState[])parcel.createTypedArray(BackStackState.CREATOR);
        this.mNextFragmentIndex = parcel.readInt();
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeTypedArray((Parcelable[])this.mActive, n);
        parcel.writeIntArray(this.mAdded);
        parcel.writeTypedArray((Parcelable[])this.mBackStack, n);
        parcel.writeInt(this.mNextFragmentIndex);
    }
}
