// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.os.ParcelableCompat;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

class AppCompatDelegateImplV9$PanelFeatureState$SavedState implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    int featureId;
    boolean isOpen;
    Bundle menuState;
    
    static {
        CREATOR = ParcelableCompat.newCreator(new AppCompatDelegateImplV9$PanelFeatureState$SavedState$1());
    }
    
    static AppCompatDelegateImplV9$PanelFeatureState$SavedState readFromParcel(final Parcel parcel, final ClassLoader classLoader) {
        final AppCompatDelegateImplV9$PanelFeatureState$SavedState appCompatDelegateImplV9$PanelFeatureState$SavedState = new AppCompatDelegateImplV9$PanelFeatureState$SavedState();
        appCompatDelegateImplV9$PanelFeatureState$SavedState.featureId = parcel.readInt();
        final int int1 = parcel.readInt();
        boolean isOpen = true;
        if (int1 != (isOpen ? 1 : 0)) {
            isOpen = false;
        }
        appCompatDelegateImplV9$PanelFeatureState$SavedState.isOpen = isOpen;
        if (appCompatDelegateImplV9$PanelFeatureState$SavedState.isOpen) {
            appCompatDelegateImplV9$PanelFeatureState$SavedState.menuState = parcel.readBundle(classLoader);
        }
        return appCompatDelegateImplV9$PanelFeatureState$SavedState;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.featureId);
        parcel.writeInt((int)(this.isOpen ? 1 : 0));
        if (this.isOpen) {
            parcel.writeBundle(this.menuState);
        }
    }
}
