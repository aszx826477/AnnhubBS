// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import android.widget.ArrayAdapter;

class AlertController$AlertParams$1 extends ArrayAdapter
{
    final /* synthetic */ AlertController$AlertParams this$0;
    final /* synthetic */ AlertController$RecycleListView val$listView;
    
    AlertController$AlertParams$1(final AlertController$AlertParams this$0, final Context context, final int n, final int n2, final CharSequence[] array, final AlertController$RecycleListView val$listView) {
        this.this$0 = this$0;
        this.val$listView = val$listView;
        super(context, n, n2, (Object[])array);
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        final View view2 = super.getView(n, view, viewGroup);
        if (this.this$0.mCheckedItems != null) {
            if (this.this$0.mCheckedItems[n]) {
                this.val$listView.setItemChecked(n, true);
            }
        }
        return view2;
    }
}
