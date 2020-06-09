// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v7.view.menu.ShowableListMenu;
import android.view.View;

class ActivityChooserView$3 extends ForwardingListener
{
    final /* synthetic */ ActivityChooserView this$0;
    
    ActivityChooserView$3(final ActivityChooserView this$0, final View view) {
        this.this$0 = this$0;
        super(view);
    }
    
    public ShowableListMenu getPopup() {
        return this.this$0.getListPopupWindow();
    }
    
    protected boolean onForwardingStarted() {
        this.this$0.showPopup();
        return true;
    }
    
    protected boolean onForwardingStopped() {
        this.this$0.dismissPopup();
        return true;
    }
}
