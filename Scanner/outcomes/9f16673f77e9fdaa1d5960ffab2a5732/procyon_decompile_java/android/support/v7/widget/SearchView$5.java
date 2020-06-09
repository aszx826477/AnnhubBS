// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.View;
import android.view.View$OnLayoutChangeListener;

class SearchView$5 implements View$OnLayoutChangeListener
{
    final /* synthetic */ SearchView this$0;
    
    SearchView$5(final SearchView this$0) {
        this.this$0 = this$0;
    }
    
    public void onLayoutChange(final View view, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        this.this$0.adjustDropDownSizeAndPosition();
    }
}
