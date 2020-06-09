// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.database.DataSetObserver;

class ActivityChooserView$4 extends DataSetObserver
{
    final /* synthetic */ ActivityChooserView this$0;
    
    ActivityChooserView$4(final ActivityChooserView this$0) {
        this.this$0 = this$0;
    }
    
    public void onChanged() {
        super.onChanged();
        this.this$0.updateAppearance();
    }
}
