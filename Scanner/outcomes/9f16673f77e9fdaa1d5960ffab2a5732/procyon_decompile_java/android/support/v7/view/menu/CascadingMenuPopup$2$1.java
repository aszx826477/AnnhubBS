// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import android.view.MenuItem;

class CascadingMenuPopup$2$1 implements Runnable
{
    final /* synthetic */ CascadingMenuPopup$2 this$1;
    final /* synthetic */ MenuItem val$item;
    final /* synthetic */ MenuBuilder val$menu;
    final /* synthetic */ CascadingMenuPopup$CascadingMenuInfo val$nextInfo;
    
    CascadingMenuPopup$2$1(final CascadingMenuPopup$2 this$1, final CascadingMenuPopup$CascadingMenuInfo val$nextInfo, final MenuItem val$item, final MenuBuilder val$menu) {
        this.this$1 = this$1;
        this.val$nextInfo = val$nextInfo;
        this.val$item = val$item;
        this.val$menu = val$menu;
    }
    
    public void run() {
        if (this.val$nextInfo != null) {
            this.this$1.this$0.mShouldCloseImmediately = true;
            this.val$nextInfo.menu.close(false);
            this.this$1.this$0.mShouldCloseImmediately = false;
        }
        if (this.val$item.isEnabled() && this.val$item.hasSubMenu()) {
            this.val$menu.performItemAction(this.val$item, 4);
        }
    }
}
