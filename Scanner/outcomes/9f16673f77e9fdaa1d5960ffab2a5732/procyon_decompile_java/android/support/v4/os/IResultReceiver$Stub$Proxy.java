// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.os;

import android.os.Parcel;
import android.os.Bundle;
import android.os.IBinder;

class IResultReceiver$Stub$Proxy implements IResultReceiver
{
    private IBinder mRemote;
    
    IResultReceiver$Stub$Proxy(final IBinder mRemote) {
        this.mRemote = mRemote;
    }
    
    public IBinder asBinder() {
        return this.mRemote;
    }
    
    public String getInterfaceDescriptor() {
        return "android.support.v4.os.IResultReceiver";
    }
    
    public void send(final int n, final Bundle bundle) {
        final Parcel obtain = Parcel.obtain();
        final String s = "android.support.v4.os.IResultReceiver";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s);
            obtain.writeInt(n);
            final int n2 = 1;
            if (bundle != null) {
                obtain.writeInt(n2);
                bundle.writeToParcel(obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            this.mRemote.transact(n2, obtain, (Parcel)null, n2);
        }
        finally {
            obtain.recycle();
        }
    }
}
