// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

class FragmentManagerImpl$1 implements Runnable
{
    final /* synthetic */ FragmentManagerImpl this$0;
    
    FragmentManagerImpl$1(final FragmentManagerImpl this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        this.this$0.execPendingActions();
    }
}
