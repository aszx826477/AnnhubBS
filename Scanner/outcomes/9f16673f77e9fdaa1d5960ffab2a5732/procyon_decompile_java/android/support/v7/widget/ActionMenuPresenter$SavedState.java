// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

class ActionMenuPresenter$SavedState implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    public int openSubMenuId;
    
    static {
        CREATOR = (Parcelable$Creator)new ActionMenuPresenter$SavedState$1();
    }
    
    ActionMenuPresenter$SavedState() {
    }
    
    ActionMenuPresenter$SavedState(final Parcel parcel) {
        this.openSubMenuId = parcel.readInt();
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.openSubMenuId);
    }
}
