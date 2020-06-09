// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.database.DataSetObserver;

class CursorAdapter$MyDataSetObserver extends DataSetObserver
{
    final /* synthetic */ CursorAdapter this$0;
    
    CursorAdapter$MyDataSetObserver(final CursorAdapter this$0) {
        this.this$0 = this$0;
    }
    
    public void onChanged() {
        final CursorAdapter this$0 = this.this$0;
        this$0.mDataValid = true;
        this$0.notifyDataSetChanged();
    }
    
    public void onInvalidated() {
        final CursorAdapter this$0 = this.this$0;
        this$0.mDataValid = false;
        this$0.notifyDataSetInvalidated();
    }
}
