// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemSelectedListener;

class SearchView$11 implements AdapterView$OnItemSelectedListener
{
    final /* synthetic */ SearchView this$0;
    
    SearchView$11(final SearchView this$0) {
        this.this$0 = this$0;
    }
    
    public void onItemSelected(final AdapterView adapterView, final View view, final int n, final long n2) {
        this.this$0.onItemSelected(n);
    }
    
    public void onNothingSelected(final AdapterView adapterView) {
    }
}
