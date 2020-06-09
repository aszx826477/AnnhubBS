// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.os;

import android.os.Build$VERSION;
import android.os.Parcelable$Creator;

public final class ParcelableCompat
{
    public static Parcelable$Creator newCreator(final ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
        if (Build$VERSION.SDK_INT >= 13) {
            return ParcelableCompatCreatorHoneycombMR2Stub.instantiate(parcelableCompatCreatorCallbacks);
        }
        return (Parcelable$Creator)new ParcelableCompat$CompatCreator(parcelableCompatCreatorCallbacks);
    }
}
