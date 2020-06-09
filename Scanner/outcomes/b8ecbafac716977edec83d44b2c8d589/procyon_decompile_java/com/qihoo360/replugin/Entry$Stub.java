// 
// Decompiled by Procyon v0.5.30
// 

package com.qihoo360.replugin;

import android.os.Parcel;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;

public class Entry$Stub extends Binder implements IInterface
{
    private static final String DESCRIPTOR = "com.qihoo360.loader2.IPlugin";
    private IBinder mRemote;
    
    public Entry$Stub() {
        this.mRemote = null;
        this.attachInterface((IInterface)this, "com.qihoo360.loader2.IPlugin");
    }
    
    public IBinder asBinder() {
        return this.mRemote;
    }
    
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) {
        return this.mRemote != null && this.mRemote.transact(n, parcel, parcel2, n2);
    }
    
    public void setRemote(final IBinder mRemote) {
        this.mRemote = mRemote;
    }
}
