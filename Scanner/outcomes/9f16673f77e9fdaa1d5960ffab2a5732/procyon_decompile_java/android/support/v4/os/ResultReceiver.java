// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.os;

import android.os.RemoteException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Handler;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class ResultReceiver implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    final Handler mHandler;
    final boolean mLocal;
    IResultReceiver mReceiver;
    
    static {
        CREATOR = (Parcelable$Creator)new ResultReceiver$1();
    }
    
    public ResultReceiver(final Handler mHandler) {
        this.mLocal = true;
        this.mHandler = mHandler;
    }
    
    ResultReceiver(final Parcel parcel) {
        this.mLocal = false;
        this.mHandler = null;
        this.mReceiver = IResultReceiver$Stub.asInterface(parcel.readStrongBinder());
    }
    
    public int describeContents() {
        return 0;
    }
    
    protected void onReceiveResult(final int n, final Bundle bundle) {
    }
    
    public void send(final int n, final Bundle bundle) {
        if (this.mLocal) {
            final Handler mHandler = this.mHandler;
            if (mHandler != null) {
                mHandler.post((Runnable)new ResultReceiver$MyRunnable(this, n, bundle));
            }
            else {
                this.onReceiveResult(n, bundle);
            }
            return;
        }
        final IResultReceiver mReceiver = this.mReceiver;
        if (mReceiver != null) {
            final IResultReceiver resultReceiver = mReceiver;
            try {
                resultReceiver.send(n, bundle);
            }
            catch (RemoteException ex) {}
        }
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        synchronized (this) {
            if (this.mReceiver == null) {
                this.mReceiver = new ResultReceiver$MyResultReceiver(this);
            }
            parcel.writeStrongBinder(this.mReceiver.asBinder());
        }
    }
}
