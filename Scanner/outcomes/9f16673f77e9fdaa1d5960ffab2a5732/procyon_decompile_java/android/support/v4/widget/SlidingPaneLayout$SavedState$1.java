// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

final class SlidingPaneLayout$SavedState$1 implements ParcelableCompatCreatorCallbacks
{
    public SlidingPaneLayout$SavedState createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
        return new SlidingPaneLayout$SavedState(parcel, classLoader);
    }
    
    public SlidingPaneLayout$SavedState[] newArray(final int n) {
        return new SlidingPaneLayout$SavedState[n];
    }
}
