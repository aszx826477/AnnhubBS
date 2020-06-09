// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.View;
import android.support.v4.view.ViewCompat;

class ListPopupWindow$ResizePopupRunnable implements Runnable
{
    final /* synthetic */ ListPopupWindow this$0;
    
    ListPopupWindow$ResizePopupRunnable(final ListPopupWindow this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        if (this.this$0.mDropDownList != null && ViewCompat.isAttachedToWindow((View)this.this$0.mDropDownList)) {
            if (this.this$0.mDropDownList.getCount() > this.this$0.mDropDownList.getChildCount()) {
                if (this.this$0.mDropDownList.getChildCount() <= this.this$0.mListItemExpandMaximum) {
                    this.this$0.mPopup.setInputMethodMode(2);
                    this.this$0.show();
                }
            }
        }
    }
}
