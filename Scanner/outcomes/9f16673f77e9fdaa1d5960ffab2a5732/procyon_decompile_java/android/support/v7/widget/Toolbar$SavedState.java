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

public class Toolbar$SavedState extends AbsSavedState
{
    public static final Parcelable$Creator CREATOR;
    int expandedMenuItemId;
    boolean isOverflowOpen;
    
    static {
        CREATOR = ParcelableCompat.newCreator(new Toolbar$SavedState$1());
    }
    
    public Toolbar$SavedState(final Parcel parcel) {
        this(parcel, null);
    }
    
    public Toolbar$SavedState(final Parcel parcel, final ClassLoader classLoader) {
        super(parcel, classLoader);
        this.expandedMenuItemId = parcel.readInt();
        this.isOverflowOpen = (parcel.readInt() != 0);
    }
    
    public Toolbar$SavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(this.expandedMenuItemId);
        parcel.writeInt((int)(this.isOverflowOpen ? 1 : 0));
    }
}
