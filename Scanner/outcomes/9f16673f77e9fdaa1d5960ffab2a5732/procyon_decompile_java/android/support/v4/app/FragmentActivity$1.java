// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Message;
import android.os.Handler;

class FragmentActivity$1 extends Handler
{
    final /* synthetic */ FragmentActivity this$0;
    
    FragmentActivity$1(final FragmentActivity this$0) {
        this.this$0 = this$0;
    }
    
    public void handleMessage(final Message message) {
        switch (message.what) {
            default: {
                super.handleMessage(message);
                break;
            }
            case 2: {
                this.this$0.onResumeFragments();
                this.this$0.mFragments.execPendingActions();
                break;
            }
            case 1: {
                if (this.this$0.mStopped) {
                    this.this$0.doReallyStop(false);
                    break;
                }
                break;
            }
        }
    }
}
