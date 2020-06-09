// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;

class AlertController$AlertParams$4 implements AdapterView$OnItemClickListener
{
    final /* synthetic */ AlertController$AlertParams this$0;
    final /* synthetic */ AlertController val$dialog;
    final /* synthetic */ AlertController$RecycleListView val$listView;
    
    AlertController$AlertParams$4(final AlertController$AlertParams this$0, final AlertController$RecycleListView val$listView, final AlertController val$dialog) {
        this.this$0 = this$0;
        this.val$listView = val$listView;
        this.val$dialog = val$dialog;
    }
    
    public void onItemClick(final AdapterView adapterView, final View view, final int n, final long n2) {
        if (this.this$0.mCheckedItems != null) {
            this.this$0.mCheckedItems[n] = this.val$listView.isItemChecked(n);
        }
        this.this$0.mOnCheckboxClickListener.onClick((DialogInterface)this.val$dialog.mDialog, n, this.val$listView.isItemChecked(n));
    }
}
