// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.ViewGroup;
import android.content.Context;
import android.view.LayoutInflater;
import android.os.Handler$Callback;
import android.os.Handler;

public final class AsyncLayoutInflater
{
    private static final String TAG = "AsyncLayoutInflater";
    Handler mHandler;
    private Handler$Callback mHandlerCallback;
    AsyncLayoutInflater$InflateThread mInflateThread;
    LayoutInflater mInflater;
    
    public AsyncLayoutInflater(final Context context) {
        this.mHandlerCallback = (Handler$Callback)new AsyncLayoutInflater$1(this);
        this.mInflater = new AsyncLayoutInflater$BasicInflater(context);
        this.mHandler = new Handler(this.mHandlerCallback);
        this.mInflateThread = AsyncLayoutInflater$InflateThread.getInstance();
    }
    
    public void inflate(final int resid, final ViewGroup parent, final AsyncLayoutInflater$OnInflateFinishedListener callback) {
        if (callback != null) {
            final AsyncLayoutInflater$InflateRequest obtainRequest = this.mInflateThread.obtainRequest();
            obtainRequest.inflater = this;
            obtainRequest.resid = resid;
            obtainRequest.parent = parent;
            obtainRequest.callback = callback;
            this.mInflateThread.enqueue(obtainRequest);
            return;
        }
        throw new NullPointerException("callback argument may not be null!");
    }
}
