// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.View;

class ListPopupWindow$2 implements Runnable
{
    final /* synthetic */ ListPopupWindow this$0;
    
    ListPopupWindow$2(final ListPopupWindow this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        final View anchorView = this.this$0.getAnchorView();
        if (anchorView != null && anchorView.getWindowToken() != null) {
            this.this$0.show();
        }
    }
}
