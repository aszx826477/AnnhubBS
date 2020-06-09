// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

final class SearchView$SavedState$1 implements ParcelableCompatCreatorCallbacks
{
    public SearchView$SavedState createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
        return new SearchView$SavedState(parcel, classLoader);
    }
    
    public SearchView$SavedState[] newArray(final int n) {
        return new SearchView$SavedState[n];
    }
}
