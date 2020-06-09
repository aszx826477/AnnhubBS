// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.os.Message;
import android.os.Handler$Callback;

class AsyncLayoutInflater$1 implements Handler$Callback
{
    final /* synthetic */ AsyncLayoutInflater this$0;
    
    AsyncLayoutInflater$1(final AsyncLayoutInflater this$0) {
        this.this$0 = this$0;
    }
    
    public boolean handleMessage(final Message message) {
        final AsyncLayoutInflater$InflateRequest asyncLayoutInflater$InflateRequest = (AsyncLayoutInflater$InflateRequest)message.obj;
        if (asyncLayoutInflater$InflateRequest.view == null) {
            asyncLayoutInflater$InflateRequest.view = this.this$0.mInflater.inflate(asyncLayoutInflater$InflateRequest.resid, asyncLayoutInflater$InflateRequest.parent, false);
        }
        asyncLayoutInflater$InflateRequest.callback.onInflateFinished(asyncLayoutInflater$InflateRequest.view, asyncLayoutInflater$InflateRequest.resid, asyncLayoutInflater$InflateRequest.parent);
        this.this$0.mInflateThread.releaseRequest(asyncLayoutInflater$InflateRequest);
        return true;
    }
}
