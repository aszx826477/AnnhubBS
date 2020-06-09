// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;

class SearchView$10 implements AdapterView$OnItemClickListener
{
    final /* synthetic */ SearchView this$0;
    
    SearchView$10(final SearchView this$0) {
        this.this$0 = this$0;
    }
    
    public void onItemClick(final AdapterView adapterView, final View view, final int n, final long n2) {
        this.this$0.onItemClicked(n, 0, null);
    }
}
