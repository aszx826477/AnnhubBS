// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.os.Parcelable;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

class NestedScrollView$SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator CREATOR;
    public int scrollPosition;
    
    static {
        CREATOR = (Parcelable$Creator)new NestedScrollView$SavedState$1();
    }
    
    NestedScrollView$SavedState(final Parcel parcel) {
        super(parcel);
        this.scrollPosition = parcel.readInt();
    }
    
    NestedScrollView$SavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("HorizontalScrollView.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" scrollPosition=");
        sb.append(this.scrollPosition);
        sb.append("}");
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(this.scrollPosition);
    }
}
