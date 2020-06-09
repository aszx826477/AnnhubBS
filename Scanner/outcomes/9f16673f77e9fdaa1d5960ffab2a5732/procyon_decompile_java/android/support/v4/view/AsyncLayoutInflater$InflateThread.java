// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.LayoutInflater;
import android.os.Message;
import android.util.Log;
import android.support.v4.util.Pools$SynchronizedPool;
import java.util.concurrent.ArrayBlockingQueue;

class AsyncLayoutInflater$InflateThread extends Thread
{
    private static final AsyncLayoutInflater$InflateThread sInstance;
    private ArrayBlockingQueue mQueue;
    private Pools$SynchronizedPool mRequestPool;
    
    static {
        (sInstance = new AsyncLayoutInflater$InflateThread()).start();
    }
    
    private AsyncLayoutInflater$InflateThread() {
        final int n = 10;
        this.mQueue = new ArrayBlockingQueue(n);
        this.mRequestPool = new Pools$SynchronizedPool(n);
    }
    
    public static AsyncLayoutInflater$InflateThread getInstance() {
        return AsyncLayoutInflater$InflateThread.sInstance;
    }
    
    public void enqueue(final AsyncLayoutInflater$InflateRequest asyncLayoutInflater$InflateRequest) {
        try {
            this.mQueue.put(asyncLayoutInflater$InflateRequest);
        }
        catch (InterruptedException ex) {
            throw new RuntimeException("Failed to enqueue async inflate request", ex);
        }
    }
    
    public AsyncLayoutInflater$InflateRequest obtainRequest() {
        AsyncLayoutInflater$InflateRequest asyncLayoutInflater$InflateRequest = (AsyncLayoutInflater$InflateRequest)this.mRequestPool.acquire();
        if (asyncLayoutInflater$InflateRequest == null) {
            asyncLayoutInflater$InflateRequest = new AsyncLayoutInflater$InflateRequest();
        }
        return asyncLayoutInflater$InflateRequest;
    }
    
    public void releaseRequest(final AsyncLayoutInflater$InflateRequest asyncLayoutInflater$InflateRequest) {
        asyncLayoutInflater$InflateRequest.callback = null;
        asyncLayoutInflater$InflateRequest.inflater = null;
        asyncLayoutInflater$InflateRequest.parent = null;
        asyncLayoutInflater$InflateRequest.resid = 0;
        asyncLayoutInflater$InflateRequest.view = null;
        this.mRequestPool.release(asyncLayoutInflater$InflateRequest);
    }
    
    public void run() {
        try {
            while (true) {
                final ArrayBlockingQueue mQueue = this.mQueue;
                try {
                    final AsyncLayoutInflater$InflateRequest take = mQueue.take();
                    try {
                        final AsyncLayoutInflater$InflateRequest asyncLayoutInflater$InflateRequest = take;
                        try {
                            final AsyncLayoutInflater inflater = asyncLayoutInflater$InflateRequest.inflater;
                            try {
                                final LayoutInflater mInflater = inflater.mInflater;
                                try {
                                    final int resid = asyncLayoutInflater$InflateRequest.resid;
                                    try {
                                        asyncLayoutInflater$InflateRequest.view = mInflater.inflate(resid, asyncLayoutInflater$InflateRequest.parent, false);
                                    }
                                    catch (RuntimeException ex) {
                                        Log.w("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", (Throwable)ex);
                                    }
                                }
                                catch (RuntimeException ex3) {}
                            }
                            catch (RuntimeException ex4) {}
                        }
                        catch (RuntimeException ex5) {}
                        Message.obtain(asyncLayoutInflater$InflateRequest.inflater.mHandler, 0, (Object)asyncLayoutInflater$InflateRequest).sendToTarget();
                        continue;
                    }
                    catch (InterruptedException ex2) {
                        Log.w("AsyncLayoutInflater", (Throwable)ex2);
                        continue;
                    }
                }
                catch (InterruptedException ex6) {}
            }
        }
        catch (InterruptedException ex7) {}
    }
}
