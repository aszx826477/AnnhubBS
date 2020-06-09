// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import android.view.View;
import android.support.v7.widget.ForwardingListener;

class ActionMenuItemView$ActionMenuItemForwardingListener extends ForwardingListener
{
    final /* synthetic */ ActionMenuItemView this$0;
    
    public ActionMenuItemView$ActionMenuItemForwardingListener(final ActionMenuItemView this$0) {
        this.this$0 = this$0;
        super((View)this$0);
    }
    
    public ShowableListMenu getPopup() {
        if (this.this$0.mPopupCallback != null) {
            return this.this$0.mPopupCallback.getPopup();
        }
        return null;
    }
    
    protected boolean onForwardingStarted() {
        final MenuBuilder$ItemInvoker mItemInvoker = this.this$0.mItemInvoker;
        boolean b = false;
        if (mItemInvoker != null && this.this$0.mItemInvoker.invokeItem(this.this$0.mItemData)) {
            final ShowableListMenu popup = this.getPopup();
            if (popup != null && popup.isShowing()) {
                b = true;
            }
            return b;
        }
        return false;
    }
}
