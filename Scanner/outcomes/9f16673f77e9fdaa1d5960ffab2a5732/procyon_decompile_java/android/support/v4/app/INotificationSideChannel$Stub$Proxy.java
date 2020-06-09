// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.app.Notification;
import android.os.Parcel;
import android.os.IBinder;

class INotificationSideChannel$Stub$Proxy implements INotificationSideChannel
{
    private IBinder mRemote;
    
    INotificationSideChannel$Stub$Proxy(final IBinder mRemote) {
        this.mRemote = mRemote;
    }
    
    public IBinder asBinder() {
        return this.mRemote;
    }
    
    public void cancel(final String s, final int n, final String s2) {
        final Parcel obtain = Parcel.obtain();
        final String s3 = "android.support.v4.app.INotificationSideChannel";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s3);
            obtain.writeString(s);
            obtain.writeInt(n);
            obtain.writeString(s2);
            this.mRemote.transact(2, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
    
    public void cancelAll(final String s) {
        final Parcel obtain = Parcel.obtain();
        final String s2 = "android.support.v4.app.INotificationSideChannel";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s2);
            obtain.writeString(s);
            this.mRemote.transact(3, obtain, (Parcel)null, 1);
        }
        finally {
            obtain.recycle();
        }
    }
    
    public String getInterfaceDescriptor() {
        return "android.support.v4.app.INotificationSideChannel";
    }
    
    public void notify(final String s, final int n, final String s2, final Notification notification) {
        final Parcel obtain = Parcel.obtain();
        final String s3 = "android.support.v4.app.INotificationSideChannel";
        final Parcel parcel = obtain;
        try {
            parcel.writeInterfaceToken(s3);
            obtain.writeString(s);
            obtain.writeInt(n);
            obtain.writeString(s2);
            final int n2 = 1;
            if (notification != null) {
                obtain.writeInt(n2);
                notification.writeToParcel(obtain, 0);
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
