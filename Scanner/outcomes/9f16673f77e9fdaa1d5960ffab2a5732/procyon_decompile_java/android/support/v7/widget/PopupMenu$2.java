// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.widget.PopupWindow$OnDismissListener;

class PopupMenu$2 implements PopupWindow$OnDismissListener
{
    final /* synthetic */ PopupMenu this$0;
    
    PopupMenu$2(final PopupMenu this$0) {
        this.this$0 = this$0;
    }
    
    public void onDismiss() {
        if (this.this$0.mOnDismissListener != null) {
            this.this$0.mOnDismissListener.onDismiss(this.this$0);
        }
    }
}
