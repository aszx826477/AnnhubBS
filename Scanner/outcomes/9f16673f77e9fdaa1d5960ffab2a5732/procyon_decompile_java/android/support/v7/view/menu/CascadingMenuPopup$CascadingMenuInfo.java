// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import android.widget.ListView;
import android.support.v7.widget.MenuPopupWindow;

class CascadingMenuPopup$CascadingMenuInfo
{
    public final MenuBuilder menu;
    public final int position;
    public final MenuPopupWindow window;
    
    public CascadingMenuPopup$CascadingMenuInfo(final MenuPopupWindow window, final MenuBuilder menu, final int position) {
        this.window = window;
        this.menu = menu;
        this.position = position;
    }
    
    public ListView getListView() {
        return this.window.getListView();
    }
}
