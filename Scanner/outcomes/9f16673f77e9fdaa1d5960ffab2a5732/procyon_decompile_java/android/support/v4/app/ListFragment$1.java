// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.view.View;

class ListFragment$1 implements Runnable
{
    final /* synthetic */ ListFragment this$0;
    
    ListFragment$1(final ListFragment this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        this.this$0.mList.focusableViewAvailable((View)this.this$0.mList);
    }
}
