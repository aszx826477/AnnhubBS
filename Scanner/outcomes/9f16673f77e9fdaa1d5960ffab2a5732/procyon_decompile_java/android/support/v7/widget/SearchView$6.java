// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.ViewTreeObserver$OnGlobalLayoutListener;

class SearchView$6 implements ViewTreeObserver$OnGlobalLayoutListener
{
    final /* synthetic */ SearchView this$0;
    
    SearchView$6(final SearchView this$0) {
        this.this$0 = this$0;
    }
    
    public void onGlobalLayout() {
        this.this$0.adjustDropDownSizeAndPosition();
    }
}
