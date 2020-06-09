// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v7.view.menu.ShowableListMenu;
import android.view.View;

class PopupMenu$3 extends ForwardingListener
{
    final /* synthetic */ PopupMenu this$0;
    
    PopupMenu$3(final PopupMenu this$0, final View view) {
        this.this$0 = this$0;
        super(view);
    }
    
    public ShowableListMenu getPopup() {
        return this.this$0.mPopup.getPopup();
    }
    
    protected boolean onForwardingStarted() {
        this.this$0.show();
        return true;
    }
    
    protected boolean onForwardingStopped() {
        this.this$0.dismiss();
        return true;
    }
}
