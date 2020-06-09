// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.widget.AbsListView;
import android.widget.AbsListView$OnScrollListener;

class ListPopupWindow$PopupScrollListener implements AbsListView$OnScrollListener
{
    final /* synthetic */ ListPopupWindow this$0;
    
    ListPopupWindow$PopupScrollListener(final ListPopupWindow this$0) {
        this.this$0 = this$0;
    }
    
    public void onScroll(final AbsListView absListView, final int n, final int n2, final int n3) {
    }
    
    public void onScrollStateChanged(final AbsListView absListView, final int n) {
        if (n == 1) {
            if (!this.this$0.isInputMethodNotNeeded() && this.this$0.mPopup.getContentView() != null) {
                this.this$0.mHandler.removeCallbacks((Runnable)this.this$0.mResizePopupRunnable);
                this.this$0.mResizePopupRunnable.run();
            }
        }
    }
}
