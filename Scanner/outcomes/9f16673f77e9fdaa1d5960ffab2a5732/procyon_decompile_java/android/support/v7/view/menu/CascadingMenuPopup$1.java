// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import java.util.Iterator;
import android.view.View;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;

class CascadingMenuPopup$1 implements ViewTreeObserver$OnGlobalLayoutListener
{
    final /* synthetic */ CascadingMenuPopup this$0;
    
    CascadingMenuPopup$1(final CascadingMenuPopup this$0) {
        this.this$0 = this$0;
    }
    
    public void onGlobalLayout() {
        if (this.this$0.isShowing() && this.this$0.mShowingMenus.size() > 0) {
            if (!this.this$0.mShowingMenus.get(0).window.isModal()) {
                final View mShownAnchorView = this.this$0.mShownAnchorView;
                if (mShownAnchorView != null && mShownAnchorView.isShown()) {
                    final Iterator<CascadingMenuPopup$CascadingMenuInfo> iterator = this.this$0.mShowingMenus.iterator();
                    while (iterator.hasNext()) {
                        iterator.next().window.show();
                    }
                }
                else {
                    this.this$0.dismiss();
                }
            }
        }
    }
}
