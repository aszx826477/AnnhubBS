// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;

class ListFragment$2 implements AdapterView$OnItemClickListener
{
    final /* synthetic */ ListFragment this$0;
    
    ListFragment$2(final ListFragment this$0) {
        this.this$0 = this$0;
    }
    
    public void onItemClick(final AdapterView adapterView, final View view, final int n, final long n2) {
        this.this$0.onListItemClick((ListView)adapterView, view, n, n2);
    }
}
