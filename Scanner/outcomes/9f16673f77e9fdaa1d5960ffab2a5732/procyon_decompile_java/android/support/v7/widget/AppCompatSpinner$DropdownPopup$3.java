// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.widget.PopupWindow$OnDismissListener;

class AppCompatSpinner$DropdownPopup$3 implements PopupWindow$OnDismissListener
{
    final /* synthetic */ AppCompatSpinner$DropdownPopup this$1;
    final /* synthetic */ ViewTreeObserver$OnGlobalLayoutListener val$layoutListener;
    
    AppCompatSpinner$DropdownPopup$3(final AppCompatSpinner$DropdownPopup this$1, final ViewTreeObserver$OnGlobalLayoutListener val$layoutListener) {
        this.this$1 = this$1;
        this.val$layoutListener = val$layoutListener;
    }
    
    public void onDismiss() {
        final ViewTreeObserver viewTreeObserver = this.this$1.this$0.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.val$layoutListener);
        }
    }
}
