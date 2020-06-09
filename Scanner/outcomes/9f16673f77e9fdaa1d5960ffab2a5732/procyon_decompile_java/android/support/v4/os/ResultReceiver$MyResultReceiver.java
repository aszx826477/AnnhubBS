// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.os;

import android.os.Bundle;

class ResultReceiver$MyResultReceiver extends IResultReceiver$Stub
{
    final /* synthetic */ ResultReceiver this$0;
    
    ResultReceiver$MyResultReceiver(final ResultReceiver this$0) {
        this.this$0 = this$0;
    }
    
    public void send(final int n, final Bundle bundle) {
        if (this.this$0.mHandler != null) {
            this.this$0.mHandler.post((Runnable)new ResultReceiver$MyRunnable(this.this$0, n, bundle));
        }
        else {
            this.this$0.onReceiveResult(n, bundle);
        }
    }
}
