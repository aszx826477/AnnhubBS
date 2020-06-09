// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.database.DataSetObserver;

class ListPopupWindow$PopupDataSetObserver extends DataSetObserver
{
    final /* synthetic */ ListPopupWindow this$0;
    
    ListPopupWindow$PopupDataSetObserver(final ListPopupWindow this$0) {
        this.this$0 = this$0;
    }
    
    public void onChanged() {
        if (this.this$0.isShowing()) {
            this.this$0.show();
        }
    }
    
    public void onInvalidated() {
        this.this$0.dismiss();
    }
}
