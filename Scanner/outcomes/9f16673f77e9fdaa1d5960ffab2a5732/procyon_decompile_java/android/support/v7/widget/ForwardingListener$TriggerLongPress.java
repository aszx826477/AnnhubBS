// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

class ForwardingListener$TriggerLongPress implements Runnable
{
    final /* synthetic */ ForwardingListener this$0;
    
    ForwardingListener$TriggerLongPress(final ForwardingListener this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        this.this$0.onLongPress();
    }
}
