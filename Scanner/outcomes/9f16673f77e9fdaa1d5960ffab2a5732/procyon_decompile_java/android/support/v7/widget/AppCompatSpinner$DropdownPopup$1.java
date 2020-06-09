// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;

class AppCompatSpinner$DropdownPopup$1 implements AdapterView$OnItemClickListener
{
    final /* synthetic */ AppCompatSpinner$DropdownPopup this$1;
    final /* synthetic */ AppCompatSpinner val$this$0;
    
    AppCompatSpinner$DropdownPopup$1(final AppCompatSpinner$DropdownPopup this$1, final AppCompatSpinner val$this$0) {
        this.this$1 = this$1;
        this.val$this$0 = val$this$0;
    }
    
    public void onItemClick(final AdapterView adapterView, final View view, final int selection, final long n) {
        this.this$1.this$0.setSelection(selection);
        if (this.this$1.this$0.getOnItemClickListener() != null) {
            this.this$1.this$0.performItemClick(view, selection, this.this$1.mAdapter.getItemId(selection));
        }
        this.this$1.dismiss();
    }
}
