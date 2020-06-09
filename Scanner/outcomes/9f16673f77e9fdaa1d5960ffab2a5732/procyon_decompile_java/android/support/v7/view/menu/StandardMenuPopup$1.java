// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import android.view.View;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;

class StandardMenuPopup$1 implements ViewTreeObserver$OnGlobalLayoutListener
{
    final /* synthetic */ StandardMenuPopup this$0;
    
    StandardMenuPopup$1(final StandardMenuPopup this$0) {
        this.this$0 = this$0;
    }
    
    public void onGlobalLayout() {
        if (this.this$0.isShowing() && !this.this$0.mPopup.isModal()) {
            final View mShownAnchorView = this.this$0.mShownAnchorView;
            if (mShownAnchorView != null && mShownAnchorView.isShown()) {
                this.this$0.mPopup.show();
            }
            else {
                this.this$0.dismiss();
            }
        }
    }
}
