// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v7.view.menu.ShowableListMenu;
import android.view.View;

class ActionMenuPresenter$OverflowMenuButton$1 extends ForwardingListener
{
    final /* synthetic */ ActionMenuPresenter$OverflowMenuButton this$1;
    final /* synthetic */ ActionMenuPresenter val$this$0;
    
    ActionMenuPresenter$OverflowMenuButton$1(final ActionMenuPresenter$OverflowMenuButton this$1, final View view, final ActionMenuPresenter val$this$0) {
        this.this$1 = this$1;
        this.val$this$0 = val$this$0;
        super(view);
    }
    
    public ShowableListMenu getPopup() {
        if (this.this$1.this$0.mOverflowPopup == null) {
            return null;
        }
        return this.this$1.this$0.mOverflowPopup.getPopup();
    }
    
    public boolean onForwardingStarted() {
        this.this$1.this$0.showOverflowMenu();
        return true;
    }
    
    public boolean onForwardingStopped() {
        if (this.this$1.this$0.mPostedOpenRunnable != null) {
            return false;
        }
        this.this$1.this$0.hideOverflowMenu();
        return true;
    }
}
