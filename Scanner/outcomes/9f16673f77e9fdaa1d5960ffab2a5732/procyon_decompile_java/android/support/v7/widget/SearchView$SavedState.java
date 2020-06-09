// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.os.Parcelable;
import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.os.ParcelableCompat;
import android.os.Parcelable$Creator;
import android.support.v4.view.AbsSavedState;

class SearchView$SavedState extends AbsSavedState
{
    public static final Parcelable$Creator CREATOR;
    boolean isIconified;
    
    static {
        CREATOR = ParcelableCompat.newCreator(new SearchView$SavedState$1());
    }
    
    public SearchView$SavedState(final Parcel parcel, final ClassLoader classLoader) {
        super(parcel, classLoader);
        this.isIconified = (boolean)parcel.readValue((ClassLoader)null);
    }
    
    SearchView$SavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SearchView.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" isIconified=");
        sb.append(this.isIconified);
        sb.append("}");
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeValue((Object)this.isIconified);
    }
}
