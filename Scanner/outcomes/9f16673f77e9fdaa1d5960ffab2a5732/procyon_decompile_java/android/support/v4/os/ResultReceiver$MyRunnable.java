// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.os;

import android.os.Bundle;

class ResultReceiver$MyRunnable implements Runnable
{
    final int mResultCode;
    final Bundle mResultData;
    final /* synthetic */ ResultReceiver this$0;
    
    ResultReceiver$MyRunnable(final ResultReceiver this$0, final int mResultCode, final Bundle mResultData) {
        this.this$0 = this$0;
        this.mResultCode = mResultCode;
        this.mResultData = mResultData;
    }
    
    public void run() {
        this.this$0.onReceiveResult(this.mResultCode, this.mResultData);
    }
}
