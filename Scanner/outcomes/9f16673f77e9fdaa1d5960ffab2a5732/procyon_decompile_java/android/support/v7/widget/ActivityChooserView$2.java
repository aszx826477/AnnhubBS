// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.ViewTreeObserver$OnGlobalLayoutListener;

class ActivityChooserView$2 implements ViewTreeObserver$OnGlobalLayoutListener
{
    final /* synthetic */ ActivityChooserView this$0;
    
    ActivityChooserView$2(final ActivityChooserView this$0) {
        this.this$0 = this$0;
    }
    
    public void onGlobalLayout() {
        if (this.this$0.isShowingPopup()) {
            if (!this.this$0.isShown()) {
                this.this$0.getListPopupWindow().dismiss();
            }
            else {
                this.this$0.getListPopupWindow().show();
                if (this.this$0.mProvider != null) {
                    this.this$0.mProvider.subUiVisibilityChanged(true);
                }
            }
        }
    }
}
