// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.os;

import android.os.Parcel;

public interface ParcelableCompatCreatorCallbacks
{
    Object createFromParcel(final Parcel p0, final ClassLoader p1);
    
    Object[] newArray(final int p0);
}
