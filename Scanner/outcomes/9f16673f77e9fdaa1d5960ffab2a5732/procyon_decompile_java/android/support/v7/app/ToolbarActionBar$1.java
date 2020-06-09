// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

class ToolbarActionBar$1 implements Runnable
{
    final /* synthetic */ ToolbarActionBar this$0;
    
    ToolbarActionBar$1(final ToolbarActionBar this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        this.this$0.populateOptionsMenu();
    }
}
