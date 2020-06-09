// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

final class Toolbar$SavedState$1 implements ParcelableCompatCreatorCallbacks
{
    public Toolbar$SavedState createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
        return new Toolbar$SavedState(parcel, classLoader);
    }
    
    public Toolbar$SavedState[] newArray(final int n) {
        return new Toolbar$SavedState[n];
    }
}
