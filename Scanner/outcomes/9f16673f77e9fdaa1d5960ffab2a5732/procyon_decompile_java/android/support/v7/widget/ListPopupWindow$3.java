// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemSelectedListener;

class ListPopupWindow$3 implements AdapterView$OnItemSelectedListener
{
    final /* synthetic */ ListPopupWindow this$0;
    
    ListPopupWindow$3(final ListPopupWindow this$0) {
        this.this$0 = this$0;
    }
    
    public void onItemSelected(final AdapterView adapterView, final View view, final int n, final long n2) {
        if (n != -1) {
            final DropDownListView mDropDownList = this.this$0.mDropDownList;
            if (mDropDownList != null) {
                mDropDownList.setListSelectionHidden(false);
            }
        }
    }
    
    public void onNothingSelected(final AdapterView adapterView) {
    }
}
