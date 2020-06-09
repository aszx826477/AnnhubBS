// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;
import android.view.View$OnClickListener;

class PagerTabStrip$2 implements View$OnClickListener
{
    final /* synthetic */ PagerTabStrip this$0;
    
    PagerTabStrip$2(final PagerTabStrip this$0) {
        this.this$0 = this$0;
    }
    
    public void onClick(final View view) {
        this.this$0.mPager.setCurrentItem(this.this$0.mPager.getCurrentItem() + 1);
    }
}
