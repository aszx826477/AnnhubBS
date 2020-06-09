// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

final class DrawerLayout$SavedState$1 implements ParcelableCompatCreatorCallbacks
{
    public DrawerLayout$SavedState createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
        return new DrawerLayout$SavedState(parcel, classLoader);
    }
    
    public DrawerLayout$SavedState[] newArray(final int n) {
        return new DrawerLayout$SavedState[n];
    }
}
