// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.database.DataSetObserver;

class ViewPager$PagerObserver extends DataSetObserver
{
    final /* synthetic */ ViewPager this$0;
    
    ViewPager$PagerObserver(final ViewPager this$0) {
        this.this$0 = this$0;
    }
    
    public void onChanged() {
        this.this$0.dataSetChanged();
    }
    
    public void onInvalidated() {
        this.this$0.dataSetChanged();
    }
}
