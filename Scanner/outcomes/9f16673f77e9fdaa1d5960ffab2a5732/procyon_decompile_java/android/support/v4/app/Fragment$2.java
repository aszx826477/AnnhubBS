// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.view.View;

class Fragment$2 extends FragmentContainer
{
    final /* synthetic */ Fragment this$0;
    
    Fragment$2(final Fragment this$0) {
        this.this$0 = this$0;
    }
    
    public View onFindViewById(final int n) {
        if (this.this$0.mView != null) {
            return this.this$0.mView.findViewById(n);
        }
        throw new IllegalStateException("Fragment does not have a view");
    }
    
    public boolean onHasView() {
        return this.this$0.mView != null;
    }
}
