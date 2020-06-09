// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Parcelable;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

class FragmentTabHost$SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator CREATOR;
    String curTab;
    
    static {
        CREATOR = (Parcelable$Creator)new FragmentTabHost$SavedState$1();
    }
    
    FragmentTabHost$SavedState(final Parcel parcel) {
        super(parcel);
        this.curTab = parcel.readString();
    }
    
    FragmentTabHost$SavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FragmentTabHost.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" curTab=");
        sb.append(this.curTab);
        sb.append("}");
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeString(this.curTab);
    }
}
