// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.os.Message;
import android.view.View;
import android.view.View$OnClickListener;

class AlertController$1 implements View$OnClickListener
{
    final /* synthetic */ AlertController this$0;
    
    AlertController$1(final AlertController this$0) {
        this.this$0 = this$0;
    }
    
    public void onClick(final View view) {
        Message message;
        if (view == this.this$0.mButtonPositive && this.this$0.mButtonPositiveMessage != null) {
            message = Message.obtain(this.this$0.mButtonPositiveMessage);
        }
        else if (view == this.this$0.mButtonNegative && this.this$0.mButtonNegativeMessage != null) {
            message = Message.obtain(this.this$0.mButtonNegativeMessage);
        }
        else if (view == this.this$0.mButtonNeutral && this.this$0.mButtonNeutralMessage != null) {
            message = Message.obtain(this.this$0.mButtonNeutralMessage);
        }
        else {
            message = null;
        }
        if (message != null) {
            message.sendToTarget();
        }
        this.this$0.mHandler.obtainMessage(1, (Object)this.this$0.mDialog).sendToTarget();
    }
}
