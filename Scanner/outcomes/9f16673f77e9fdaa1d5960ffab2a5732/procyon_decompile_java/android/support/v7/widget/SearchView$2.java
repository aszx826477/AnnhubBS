// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

class SearchView$2 implements Runnable
{
    final /* synthetic */ SearchView this$0;
    
    SearchView$2(final SearchView this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        this.this$0.updateFocusedState();
    }
}
